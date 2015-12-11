// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;
import java.util.Date;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDateType

public class DateLongType extends BaseDateType
{

    private static final DateLongType singleTon = new DateLongType();

    private DateLongType()
    {
        super(SqlType.LONG, new Class[0]);
    }

    public static DateLongType getSingleton()
    {
        return singleTon;
    }

    public boolean isEscapedValue()
    {
        return false;
    }

    public boolean isValidForField(Field field)
    {
        return true;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return Long.valueOf(((Date)obj).getTime());
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems with field ").append(fieldtype).append(" parsing default date-long value: ").append(s).toString(), numberformatexception);
        }
        return Long.valueOf(l);
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        databaseresults = Long.valueOf(databaseresults.getLong(i));
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
        return new Date(((Long)obj).longValue());
    }

}
