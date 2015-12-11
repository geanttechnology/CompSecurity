// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDateType

public class DateType extends BaseDateType
{

    public static final BaseDateType.DateStringFormatConfig defaultDateFormatConfig = new BaseDateType.DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");
    private static final DateType singleTon = new DateType();

    private DateType()
    {
        super(SqlType.DATE, new Class[] {
            java/util/Date
        });
    }

    public static DateType getSingleton()
    {
        return singleTon;
    }

    public boolean isSelectArgRequired()
    {
        return true;
    }

    public boolean isValidForField(Field field)
    {
        return true;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return new Timestamp(((Date)obj).getTime());
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
    {
        fieldtype = convertDateStringConfig(fieldtype);
        Timestamp timestamp;
        try
        {
            timestamp = new Timestamp(parseDateString(fieldtype, s).getTime());
        }
        catch (ParseException parseexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems parsing default date string '").append(s).append("' using '").append(fieldtype).append('\'').toString(), parseexception);
        }
        return timestamp;
    }

    public Object resultToJava(FieldType fieldtype, DatabaseResults databaseresults, int i)
    {
        databaseresults = databaseresults.getTimestamp(i);
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
        return new Date(((Timestamp)obj).getTime());
    }

}
