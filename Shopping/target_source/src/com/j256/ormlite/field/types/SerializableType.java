// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public class SerializableType extends BaseDataType
{

    private static final SerializableType singleTon = new SerializableType();

    private SerializableType()
    {
        super(SqlType.SERIALIZABLE, new Class[0]);
    }

    protected SerializableType(SqlType sqltype, Class aclass[])
    {
        super(sqltype, aclass);
    }

    public static SerializableType getSingleton()
    {
        return singleTon;
    }

    public Class getPrimaryClass()
    {
        return java/io/Serializable;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

    public boolean isArgumentHolderRequired()
    {
        return true;
    }

    public boolean isComparable()
    {
        return false;
    }

    public boolean isStreamType()
    {
        return true;
    }

    public boolean isValidForField(Field field)
    {
        return java/io/Serializable.isAssignableFrom(field.getType());
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
        throws SQLException
    {
        Object obj2;
        Object obj3;
        obj3 = null;
        obj2 = null;
        fieldtype = obj3;
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        fieldtype = obj3;
        Object obj1 = new ObjectOutputStream(bytearrayoutputstream);
        ((ObjectOutputStream) (obj1)).writeObject(obj);
        ((ObjectOutputStream) (obj1)).close();
        fieldtype = obj3;
        obj1 = bytearrayoutputstream.toByteArray();
        if (false)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (FieldType fieldtype)
            {
                return obj1;
            }
        } else
        {
            return obj1;
        }
        obj1;
        fieldtype = obj2;
_L4:
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not write serialized object to byte array: ").append(obj).toString(), ((Throwable) (obj1)));
        obj;
        obj1 = fieldtype;
        fieldtype = ((FieldType) (obj));
_L2:
        if (obj1 != null)
        {
            try
            {
                ((ObjectOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw fieldtype;
        fieldtype;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        fieldtype = ((FieldType) (obj1));
        obj1 = exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
        throws SQLException
    {
        throw new SQLException("Default values for serializable types are not supported");
    }

    public Object resultStringToJava(FieldType fieldtype, String s, int i)
        throws SQLException
    {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    public Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        return databaseresults.getBytes(i);
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
        throws SQLException
    {
        byte abyte0[] = (byte[])(byte[])obj;
        obj = new ObjectInputStream(new ByteArrayInputStream(abyte0));
        fieldtype = ((FieldType) (obj));
        Object obj1 = ((ObjectInputStream) (obj)).readObject();
        if (obj != null)
        {
            try
            {
                ((ObjectInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (FieldType fieldtype)
            {
                return obj1;
            }
        }
        return obj1;
        obj1;
        fieldtype = null;
_L4:
        throw SqlExceptionUtil.create((new StringBuilder()).append("Could not read serialized object from byte array: ").append(Arrays.toString(abyte0)).append("(len ").append(abyte0.length).append(")").toString(), ((Throwable) (obj1)));
        obj1;
        obj = fieldtype;
        fieldtype = ((FieldType) (obj1));
_L2:
        if (obj != null)
        {
            try
            {
                ((ObjectInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw fieldtype;
        fieldtype;
        obj = null;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        fieldtype = ((FieldType) (obj));
        if (true) goto _L4; else goto _L3
_L3:
    }

}
