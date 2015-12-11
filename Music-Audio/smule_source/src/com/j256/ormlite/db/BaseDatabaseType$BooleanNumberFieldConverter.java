// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.db;

import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

public class 
    implements FieldConverter
{

    public SqlType getSqlType()
    {
        return SqlType.BOOLEAN;
    }

    public boolean isStreamType()
    {
        return false;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        if (((Boolean)obj).booleanValue())
        {
            return Byte.valueOf((byte)1);
        } else
        {
            return Byte.valueOf((byte)0);
        }
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        if (Boolean.parseBoolean(s))
        {
            return Byte.valueOf((byte)1);
        } else
        {
            return Byte.valueOf((byte)0);
        }
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        return sqlArgToJava(fieldtype, Byte.valueOf(databaseresults.getByte(i)), i);
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
    {
        if (((Byte)obj).byteValue() == 1)
        {
            return Boolean.valueOf(true);
        } else
        {
            return Boolean.valueOf(false);
        }
    }

    protected ()
    {
    }
}
