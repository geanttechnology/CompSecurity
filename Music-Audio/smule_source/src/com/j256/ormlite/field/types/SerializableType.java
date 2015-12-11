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

    public static SerializableType getSingleton()
    {
        return singleTon;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

    public boolean isComparable()
    {
        return false;
    }

    public boolean isSelectArgRequired()
    {
        return true;
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
    {
        try
        {
            fieldtype = new ByteArrayOutputStream();
            (new ObjectOutputStream(fieldtype)).writeObject(obj);
            fieldtype = fieldtype.toByteArray();
        }
        // Misplaced declaration of an exception variable
        catch (FieldType fieldtype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not write serialized object to byte array: ").append(obj).toString(), fieldtype);
        }
        return fieldtype;
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        throw new SQLException("Default values for serializable types are not supported");
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        databaseresults = databaseresults.getBytes(i);
        if (databaseresults == null)
        {
            return null;
        } else
        {
            return sqlArgToJava(fieldtype, databaseresults, i);
        }
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
    {
        fieldtype = (byte[])(byte[])obj;
        try
        {
            obj = (new ObjectInputStream(new ByteArrayInputStream(fieldtype))).readObject();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not read serialized object from byte array: ").append(Arrays.toString(fieldtype)).append("(len ").append(fieldtype.length).append(")").toString(), ((Throwable) (obj)));
        }
        return obj;
    }

}
