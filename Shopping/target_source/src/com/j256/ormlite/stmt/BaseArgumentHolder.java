// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.stmt:
//            ArgumentHolder

public abstract class BaseArgumentHolder
    implements ArgumentHolder
{

    private String columnName;
    private FieldType fieldType;
    private SqlType sqlType;

    public BaseArgumentHolder()
    {
        columnName = null;
        fieldType = null;
        sqlType = null;
    }

    public BaseArgumentHolder(SqlType sqltype)
    {
        columnName = null;
        fieldType = null;
        sqlType = null;
        sqlType = sqltype;
    }

    public BaseArgumentHolder(String s)
    {
        columnName = null;
        fieldType = null;
        sqlType = null;
        columnName = s;
    }

    public String getColumnName()
    {
        return columnName;
    }

    public FieldType getFieldType()
    {
        return fieldType;
    }

    public Object getSqlArgValue()
        throws SQLException
    {
        if (!isValueSet())
        {
            throw new SQLException((new StringBuilder()).append("Column value has not been set for ").append(columnName).toString());
        }
        Object obj1 = getValue();
        Object obj;
        if (obj1 == null)
        {
            obj = null;
        } else
        {
            obj = obj1;
            if (fieldType != null)
            {
                if (fieldType.isForeign() && fieldType.getType() == obj1.getClass())
                {
                    return fieldType.getForeignIdField().extractJavaFieldValue(obj1);
                } else
                {
                    return fieldType.convertJavaFieldToSqlArgValue(obj1);
                }
            }
        }
        return obj;
    }

    public SqlType getSqlType()
    {
        return sqlType;
    }

    protected abstract Object getValue();

    protected abstract boolean isValueSet();

    public void setMetaInfo(FieldType fieldtype)
    {
        while (fieldType == null || fieldType == fieldtype) 
        {
            fieldType = fieldtype;
            return;
        }
        throw new IllegalArgumentException((new StringBuilder()).append("FieldType name cannot be set twice from ").append(fieldType).append(" to ").append(fieldtype).append(".  Using a SelectArg twice in query with different columns?").toString());
    }

    public void setMetaInfo(String s)
    {
        while (columnName == null || columnName.equals(s)) 
        {
            columnName = s;
            return;
        }
        throw new IllegalArgumentException((new StringBuilder()).append("Column name cannot be set twice from ").append(columnName).append(" to ").append(s).append(".  Using a SelectArg twice in query with different columns?").toString());
    }

    public void setMetaInfo(String s, FieldType fieldtype)
    {
        setMetaInfo(s);
        setMetaInfo(fieldtype);
    }

    public abstract void setValue(Object obj);

    public String toString()
    {
        if (!isValueSet())
        {
            return "[unset]";
        }
        Object obj;
        try
        {
            obj = getSqlArgValue();
        }
        catch (SQLException sqlexception)
        {
            return (new StringBuilder()).append("[could not get value: ").append(sqlexception).append("]").toString();
        }
        if (obj == null)
        {
            return "[null]";
        }
        obj = obj.toString();
        return ((String) (obj));
    }
}
