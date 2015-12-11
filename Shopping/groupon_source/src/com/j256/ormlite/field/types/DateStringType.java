// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDateType

public class DateStringType extends BaseDateType
{

    public static int DEFAULT_WIDTH = 50;
    private static final DateStringType singleTon = new DateStringType();

    private DateStringType()
    {
        super(SqlType.STRING, new Class[0]);
    }

    public static DateStringType getSingleton()
    {
        return singleTon;
    }

    public int getDefaultWidth()
    {
        return DEFAULT_WIDTH;
    }

    public Class getPrimaryClass()
    {
        return [B;
    }

    public Object javaToSqlArg(FieldType fieldtype, Object obj)
    {
        return convertDateStringConfig(fieldtype, defaultDateFormatConfig).getDateFormat().format((Date)obj);
    }

    public Object makeConfigObject(FieldType fieldtype)
    {
        fieldtype = fieldtype.getFormat();
        if (fieldtype == null)
        {
            return defaultDateFormatConfig;
        } else
        {
            return new BaseDateType.DateStringFormatConfig(fieldtype);
        }
    }

    public Object parseDefaultString(FieldType fieldtype, String s)
        throws SQLException
    {
        BaseDateType.DateStringFormatConfig datestringformatconfig = convertDateStringConfig(fieldtype, defaultDateFormatConfig);
        String s1;
        try
        {
            s1 = normalizeDateString(datestringformatconfig, s);
        }
        catch (ParseException parseexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems with field ").append(fieldtype).append(" parsing default date-string '").append(s).append("' using '").append(datestringformatconfig).append("'").toString(), parseexception);
        }
        return s1;
    }

    public Object resultStringToJava(FieldType fieldtype, String s, int i)
        throws SQLException
    {
        return sqlArgToJava(fieldtype, s, i);
    }

    public Object resultToSqlArg(FieldType fieldtype, DatabaseResults databaseresults, int i)
        throws SQLException
    {
        return databaseresults.getString(i);
    }

    public Object sqlArgToJava(FieldType fieldtype, Object obj, int i)
        throws SQLException
    {
        obj = (String)obj;
        fieldtype = convertDateStringConfig(fieldtype, defaultDateFormatConfig);
        Date date;
        try
        {
            date = parseDateString(fieldtype, ((String) (obj)));
        }
        catch (ParseException parseexception)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Problems with column ").append(i).append(" parsing date-string '").append(((String) (obj))).append("' using '").append(fieldtype).append("'").toString(), parseexception);
        }
        return date;
    }

}
