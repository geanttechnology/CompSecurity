// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.dao.RawRowMapper;
import com.j256.ormlite.support.DatabaseResults;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper

class stringRowMapper
    implements GenericRowMapper
{

    private final String columnNames[];
    private final RawRowMapper mapper;
    private final GenericRowMapper stringRowMapper;

    public Object mapRow(DatabaseResults databaseresults)
    {
        databaseresults = (String[])stringRowMapper.mapRow(databaseresults);
        return mapper.mapRow(columnNames, databaseresults);
    }

    public A(RawRowMapper rawrowmapper, String as[], GenericRowMapper genericrowmapper)
    {
        mapper = rawrowmapper;
        columnNames = as;
        stringRowMapper = genericrowmapper;
    }
}
