// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper, StatementExecutor

private static class stringRowMapper
    implements GenericRowMapper
{

    private String columnNames[];
    private final RawRowMapper mapper;
    private final GenericRowMapper stringRowMapper;

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
        String as[] = (String[])stringRowMapper.mapRow(databaseresults);
        return mapper.mapRow(getColumnNames(databaseresults), as);
    }

    public (RawRowMapper rawrowmapper, GenericRowMapper genericrowmapper)
    {
        mapper = rawrowmapper;
        stringRowMapper = genericrowmapper;
    }
}
