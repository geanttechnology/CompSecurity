// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public class DateTimeType extends BaseDataType
{

    private static final String associatedClassNames[] = {
        "org.joda.time.DateTime"
    };
    private static Class dateTimeClass = null;
    private static Method getMillisMethod = null;
    private static Constructor millisConstructor = null;
    private static final DateTimeType singleTon = new DateTimeType();

    private DateTimeType()
    {
        super(SqlType.LONG, new Class[0]);
    }

    private Constructor getConstructor()
        throws Exception
    {
        if (millisConstructor == null)
        {
            millisConstructor = getDateTimeClass().getConstructor(new Class[] {
                Long.TYPE
            });
        }
        return millisConstructor;
    }

    private Class getDateTimeClass()
        throws ClassNotFoundException
    {
        if (dateTimeClass == null)
        {
            dateTimeClass = Class.forName("org.joda.time.DateTime");
        }
        return dateTimeClass;
    }

    private Method getMillisMethod()
        throws Exception
    {
        if (getMillisMethod == null)
        {
            getMillisMethod = getDateTimeClass().getMethod("getMillis", new Class[0]);
        }
        return getMillisMethod;
    }

    public static DateTimeType getSingleton()
    {
        return singleTon;
    }

    public String[] getAssociatedClassNames()
    {
        return associatedClassNames;
    }

    public Class getPrimaryClass()
    {
        Class class1;
        try
        {
            class1 = getDateTimeClass();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return null;
        }
        return class1;
    }

    public boolean isAppropriateId()
    {
        return false;
    }

    public boolean isEscapedValue()
    {
        return false;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
        throws SQLException
    {
        try
        {
            fieldtype = getMillisMethod();
        }
        // Misplaced declaration of an exception variable
        catch (FieldType fieldtype)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not use reflection to get millis from Joda DateTime: ").append(obj).toString(), fieldtype);
        }
        if (obj == null)
        {
            return null;
        }
        fieldtype = ((FieldType) (fieldtype.invoke(obj, new Object[0])));
        return fieldtype;
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        return Long.valueOf(Long.parseLong(s));
    }

    public Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        return Long.valueOf(databaseresults.getLong(i));
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
        throws SQLException
    {
        try
        {
            fieldtype = ((FieldType) (getConstructor().newInstance(new Object[] {
                (Long)obj
            })));
        }
        // Misplaced declaration of an exception variable
        catch (FieldType fieldtype)
        {
            throw SqlExceptionUtil.create("Could not use reflection to construct a Joda DateTime", fieldtype);
        }
        return fieldtype;
    }

}
