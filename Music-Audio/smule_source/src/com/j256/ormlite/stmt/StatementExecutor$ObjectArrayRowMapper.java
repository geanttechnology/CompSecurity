// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.support.DatabaseResults;

// Referenced classes of package com.j256.ormlite.stmt:
//            GenericRowMapper

class columnTypes
    implements GenericRowMapper
{

    private final DataType columnTypes[];

    public volatile Object mapRow(DatabaseResults databaseresults)
    {
        return ((Object) (mapRow(databaseresults)));
    }

    public Object[] mapRow(DatabaseResults databaseresults)
    {
        int j = databaseresults.getColumnCount();
        Object aobj[] = new Object[j];
        int i = 0;
        while (i < j) 
        {
            DataType datatype;
            if (i >= columnTypes.length)
            {
                datatype = DataType.STRING;
            } else
            {
                datatype = columnTypes[i];
            }
            aobj[i] = datatype.getDataPersister().resultToJava(null, databaseresults, i);
            i++;
        }
        return aobj;
    }

    public (DataType adatatype[])
    {
        columnTypes = adatatype;
    }
}
