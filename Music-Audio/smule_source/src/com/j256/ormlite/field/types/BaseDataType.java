// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;

public abstract class BaseDataType
    implements DataPersister
{

    private final Class classes[];
    private final SqlType sqlType;

    public BaseDataType(SqlType sqltype, Class aclass[])
    {
        sqlType = sqltype;
        classes = aclass;
    }

    public Object convertIdNumber(Number number)
    {
        return null;
    }

    public boolean dataIsEqual(Object obj, Object obj1)
    {
        boolean flag = false;
        if (obj == null)
        {
            if (obj1 == null)
            {
                flag = true;
            }
        } else
        if (obj1 != null)
        {
            return obj.equals(obj1);
        }
        return flag;
    }

    public Object generateId()
    {
        throw new IllegalStateException("Should not have tried to generate this type");
    }

    public Class[] getAssociatedClasses()
    {
        return classes;
    }

    public int getDefaultWidth()
    {
        return 0;
    }

    public SqlType getSqlType()
    {
        return sqlType;
    }

    public boolean isAppropriateId()
    {
        return true;
    }

    public boolean isComparable()
    {
        return true;
    }

    public boolean isEscapedDefaultValue()
    {
        return isEscapedValue();
    }

    public boolean isEscapedValue()
    {
        return true;
    }

    public boolean isPrimitive()
    {
        return false;
    }

    public boolean isSelectArgRequired()
    {
        return false;
    }

    public boolean isSelfGeneratedId()
    {
        return false;
    }

    public boolean isStreamType()
    {
        return false;
    }

    public abstract boolean isValidForField(Field field);

    public boolean isValidForVersion()
    {
        return false;
    }

    public boolean isValidGeneratedType()
    {
        return false;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return obj;
    }

    public Object makeConfigObject(FieldType fieldtype)
    {
        return null;
    }

    public Object moveToNextValue(Object obj)
    {
        return null;
    }

    public abstract Object parseDefaultString(FieldType fieldtype, String s);

    public abstract Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i);

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
    {
        return obj;
    }
}
