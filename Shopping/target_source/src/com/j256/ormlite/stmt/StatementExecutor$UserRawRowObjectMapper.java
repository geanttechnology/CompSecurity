// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowObjectMapper;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper, StatementExecutor

private static class columnTypes
    implements GenericRowMapper
{

    private String columnNames[];
    private final DataType columnTypes[];
    private final RawRowObjectMapper mapper;

    private String[] getColumnNames(DatabaseResults databaseresults)
        throws SQLException
    {
        if (columnNames != null)
        {
            return columnNames;
        } else
        {
            columnNames = databaseresults.getColumnNames();
            return columnNames;
        }
    }

    public Object mapRow(DatabaseResults databaseresults)
        throws SQLException
    {
        int j = databaseresults.getColumnCount();
        Object aobj[] = new Object[j];
        int i = 0;
        while (i < j) 
        {
            if (i >= columnTypes.length)
            {
                aobj[i] = null;
            } else
            {
                aobj[i] = columnTypes[i].getDataPersister().resultToJava(null, databaseresults, i);
            }
            i++;
        }
        return mapper.mapRow(getColumnNames(databaseresults), columnTypes, aobj);
    }

    public (RawRowObjectMapper rawrowobjectmapper, DataType adatatype[])
    {
        mapper = rawrowobjectmapper;
        columnTypes = adatatype;
    }
}
