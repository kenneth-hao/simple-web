package org.study.unitils.dataset.util;

import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.util.Properties;

/**
 * Created by haoyuewen on 8/31/14.
 */
public class MultiSchemaXlsDataSetFactory implements DataSetFactory {
    protected String defaultSchemaName;

    @Override
    public void init(Properties properties, String s) {
        this.defaultSchemaName = s;
    }

    @Override
    public MultiSchemaDataSet createDataSet(File... files) {
        MultiSchemaXlsDataSetReader xlsDataSetReader = new MultiSchemaXlsDataSetReader(defaultSchemaName);
        return xlsDataSetReader.readDataSetXls(files);
    }

    @Override
    public String getDataSetFileExtension() {
        return "xls";
    }
}
