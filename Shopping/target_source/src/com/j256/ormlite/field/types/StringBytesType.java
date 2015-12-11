// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public class StringBytesType extends BaseDataType
{

    private static final String DEFAULT_STRING_BYTES_CHARSET_NAME = "Unicode";
    private static final StringBytesType singleTon = new StringBytesType();

    private StringBytesType()
    {
        super(SqlType.BYTE_ARRAY, new Class[0]);
    }

    protected StringBytesType(SqlType sqltype, Class aclass[])
    {
        super(sqltype, aclass);
    }

    private String getCharsetName(FieldType fieldtype)
    {
        if (fieldtype == null || fieldtype.getFormat() == null)
        {
            return "Unicode";
        } else
        {
            return fieldtype.getFormat();
        }
    }

    public static StringBytesType getSingleton()
    {
        return singleTon;
    }

    public Class getPrimaryClass()
    {
        return java/lang/String;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

    public boolean isArgumentHolderRequired()
    {
        return true;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
        throws SQLException
    {
        obj = (String)obj;
        fieldtype = getCharsetName(fieldtype);
        try
        {
            obj = ((String) (obj)).getBytes(fieldtype);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not convert string with charset name: ").append(fieldtype).toString(), ((Throwable) (obj)));
        }
        return obj;
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
        throws SQLException
    {
        throw new SQLException("String-bytes type cannot have default values");
    }

    public Object resultStringToJava(FieldType fieldtype, String s, int i)
        throws SQLException
    {
        throw new SQLException("String-bytes type cannot be converted from string to Java");
    }

    public Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        return databaseresults.getBytes(i);
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
        throws SQLException
    {
        obj = (byte[])(byte[])obj;
        fieldtype = getCharsetName(fieldtype);
        try
        {
            obj = new String(((byte []) (obj)), fieldtype);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not convert string with charset name: ").append(fieldtype).toString(), ((Throwable) (obj)));
        }
        return obj;
    }

}
