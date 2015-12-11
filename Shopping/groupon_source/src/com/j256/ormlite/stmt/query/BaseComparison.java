// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.ColumnArg;
import com.j256.ormlite.stmt.SelectArg;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.j256.ormlite.stmt.query:
//            Comparison

abstract class BaseComparison
    implements Comparison
{

    protected final String columnName;
    protected final FieldType fieldType;
    private final Object value;

    protected BaseComparison(String s, FieldType fieldtype, Object obj, boolean flag)
        throws SQLException
    {
        if (flag && fieldtype != null && !fieldtype.isComparable())
        {
            throw new SQLException((new StringBuilder()).append("Field '").append(s).append("' is of data type ").append(fieldtype.getDataPersister()).append(" which can not be compared").toString());
        } else
        {
            columnName = s;
            fieldType = fieldtype;
            value = obj;
            return;
        }
    }

    protected void appendArgOrValue(DatabaseType databasetype, FieldType fieldtype, StringBuilder stringbuilder, List list, Object obj)
        throws SQLException
    {
        boolean flag = true;
        if (obj == null)
        {
            throw new SQLException((new StringBuilder()).append("argument for '").append(fieldtype.getFieldName()).append("' is null").toString());
        }
        if (obj instanceof ArgumentHolder)
        {
            stringbuilder.append('?');
            databasetype = (ArgumentHolder)obj;
            databasetype.setMetaInfo(columnName, fieldtype);
            list.add(databasetype);
        } else
        if (obj instanceof ColumnArg)
        {
            fieldtype = (ColumnArg)obj;
            list = fieldtype.getTableName();
            if (list != null)
            {
                databasetype.appendEscapedEntityName(stringbuilder, list);
                stringbuilder.append('.');
            }
            databasetype.appendEscapedEntityName(stringbuilder, fieldtype.getColumnName());
        } else
        if (fieldtype.isArgumentHolderRequired())
        {
            stringbuilder.append('?');
            databasetype = new SelectArg();
            databasetype.setMetaInfo(columnName, fieldtype);
            databasetype.setValue(obj);
            list.add(databasetype);
        } else
        if (fieldtype.isForeign() && fieldtype.getType().isAssignableFrom(obj.getClass()))
        {
            fieldtype = fieldtype.getForeignIdField();
            appendArgOrValue(databasetype, fieldtype, stringbuilder, list, fieldtype.extractJavaFieldValue(obj));
            flag = false;
        } else
        if (fieldtype.isEscapedValue())
        {
            databasetype.appendEscapedWord(stringbuilder, fieldtype.convertJavaFieldToSqlArgValue(obj).toString());
        } else
        if (fieldtype.isForeign())
        {
            databasetype = fieldtype.convertJavaFieldToSqlArgValue(obj).toString();
            if (databasetype.length() > 0 && "0123456789.-+".indexOf(databasetype.charAt(0)) < 0)
            {
                throw new SQLException((new StringBuilder()).append("Foreign field ").append(fieldtype).append(" does not seem to be producing a numerical value '").append(databasetype).append("'. Maybe you are passing the wrong object to comparison: ").append(this).toString());
            }
            stringbuilder.append(databasetype);
        } else
        {
            stringbuilder.append(fieldtype.convertJavaFieldToSqlArgValue(obj));
        }
        if (flag)
        {
            stringbuilder.append(' ');
        }
    }

    public abstract void appendOperation(StringBuilder stringbuilder);

    public void appendSql(DatabaseType databasetype, String s, StringBuilder stringbuilder, List list)
        throws SQLException
    {
        if (s != null)
        {
            databasetype.appendEscapedEntityName(stringbuilder, s);
            stringbuilder.append('.');
        }
        databasetype.appendEscapedEntityName(stringbuilder, columnName);
        stringbuilder.append(' ');
        appendOperation(stringbuilder);
        appendValue(databasetype, stringbuilder, list);
    }

    public void appendValue(DatabaseType databasetype, StringBuilder stringbuilder, List list)
        throws SQLException
    {
        appendArgOrValue(databasetype, fieldType, stringbuilder, list, value);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(columnName).append(' ');
        appendOperation(stringbuilder);
        stringbuilder.append(' ');
        stringbuilder.append(value);
        return stringbuilder.toString();
    }
}
