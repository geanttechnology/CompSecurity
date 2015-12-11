// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field:
//            FieldConverter, FieldType

public abstract class BaseFieldConverter
    implements FieldConverter
{

    public BaseFieldConverter()
    {
    }

    public boolean isStreamType()
    {
        return false;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
        throws SQLException
    {
        return obj;
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        databaseresults = ((DatabaseResults) (resultToSqlArg(fieldtype, databaseresults, i)));
        if (databaseresults == null)
        {
            return null;
        } else
        {
            return sqlArgToJava(fieldtype, databaseresults, i);
        }
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
        throws SQLException
    {
        return obj;
    }
}
