package org.study.unitils.dataset.util;

import org.apache.commons.lang.StringUtils;
import org.dbunit.database.AmbiguousTableNameException;
import org.dbunit.dataset.*;
import org.dbunit.dataset.excel.XlsDataSet;
import org.unitils.core.UnitilsException;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by haoyuewen on 8/31/14.
 */
public class MultiSchemaXlsDataSetReader {

    private String defaultSchemaName;

    public MultiSchemaXlsDataSetReader(String defaultSchemaName) {
        this.defaultSchemaName = defaultSchemaName;
    }

    public MultiSchemaDataSet readDataSetXls(File... dataSetFiles) {
        Map<String, List<ITable>> tableMap = getTables(dataSetFiles);

        MultiSchemaDataSet dataSets = new MultiSchemaDataSet();
        for (Map.Entry<String, List<ITable>> entry : tableMap.entrySet()) {
            List<ITable> tables = entry.getValue();
            DefaultDataSet ds = null;
            try {
                ds = new DefaultDataSet(tables.toArray(new ITable[] {}));
            } catch (AmbiguousTableNameException e) {
                throw new UnitilsException("Construct DataSet Failure!", e);
            }
            dataSets.setDataSetForSchema(entry.getKey(), ds);
        }
        return dataSets;
    }


    private Map<String, List<ITable>> getTables(File... dataSetFiles) {
        Pattern pattern = Pattern.compile("\\.");
        Map<String, List<ITable>> tableMap = new HashMap<String, List<ITable>>();
        try {
            for (File file : dataSetFiles) {
                IDataSet dataSet = new XlsDataSet(new FileInputStream(file));
                String[] tableNames = dataSet.getTableNames();
                for (String each : tableNames) {
                    String schema = null;
                    String tableName;
                    String[] temp = pattern.split(each);
                    if (temp.length == 2) {
                        schema = temp[0];
                        tableName = temp[1];
                    } else {
                        schema = this.defaultSchemaName;
                        tableName = each;
                    }
                    ITable table = dataSet.getTable(each);
                    if (!tableMap.containsKey(schema)) {
                        tableMap.put(schema, new ArrayList<ITable>());
                    }
                    tableMap.get(schema).add(new XlsTable(tableName, table));
                }
            }
        } catch (Exception e) {
            throw new UnitilsException("¥¥Ω® ˝æ›ºØ ß∞‹: "
                    + Arrays.toString(dataSetFiles), e);
        }
        return tableMap;
    }
    //ππ‘ÏXslTable±Ì
    class XlsTable extends AbstractTable {
        private ITable delegate;
        private String tableName;

        public XlsTable(String tableName, ITable table) {
            this.delegate = table;
            this.tableName = tableName;
        }

        public int getRowCount() {
            return delegate.getRowCount();
        }

        public ITableMetaData getTableMetaData() {
            ITableMetaData meta = delegate.getTableMetaData();
            try {
                return new DefaultTableMetaData(tableName, meta.getColumns(),
                        meta.getPrimaryKeys());
            } catch (DataSetException e) {
                throw new UnitilsException("Don't get the meta info from  "
                        + meta, e);
            }
        }

        public Object getValue(int row, String column) throws DataSetException {
            Object delta = delegate.getValue(row, column);
            if (delta instanceof String) {
                if (StringUtils.isEmpty((String) delta)) {
                    return null;
                }
            }
            return delta;
        }


    }


}
