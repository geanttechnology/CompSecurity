// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;
import java.math.BigInteger;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public class BigIntegerType extends BaseDataType
{

    public static int DEFAULT_WIDTH = 255;
    private static final BigIntegerType singleTon = new BigIntegerType();

    private BigIntegerType()
    {
        super(SqlType.STRING, new Class[] {
            java/math/BigInteger
        });
    }

    public static BigIntegerType getSingleton()
    {
        return singleTon;
    }

    public int getDefaultWidth()
    {
        return DEFAULT_WIDTH;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

    public boolean isValidForField(Field field)
    {
        return true;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return ((BigInteger)obj).toString();
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        BigInteger biginteger;
        try
        {
            biginteger = new BigInteger(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems with field ").append(fieldtype).append(" parsing default BigInteger string '").append(s).append("'").toString(), illegalargumentexception);
        }
        return biginteger;
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        databaseresults = databaseresults.getString(i);
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
        try
        {
            fieldtype = new BigInteger((String)obj);
        }
        // Misplaced declaration of an exception variable
        catch (FieldType fieldtype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems with column ").append(i).append(" parsing BigInteger string '").append(obj).append("'").toString(), fieldtype);
        }
        return fieldtype;
    }

}
