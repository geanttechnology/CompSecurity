// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.text.DateFormat;
import java.util.Date;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public abstract class BaseDateType extends BaseDataType
{

    public static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");

    protected BaseDateType(SqlType sqltype, Class aclass[])
    {
        super(sqltype, aclass);
    }

    protected static DateStringFormatConfig convertDateStringConfig(FieldType fieldtype)
    {
        if (fieldtype == null)
        {
            fieldtype = defaultDateFormatConfig;
        } else
        {
            DateStringFormatConfig datestringformatconfig = (DateStringFormatConfig)fieldtype.getDataTypeConfigObj();
            fieldtype = datestringformatconfig;
            if (datestringformatconfig == null)
            {
                return defaultDateFormatConfig;
            }
        }
        return fieldtype;
    }

    protected static String normalizeDateString(DateStringFormatConfig datestringformatconfig, String s)
    {
        datestringformatconfig = datestringformatconfig.getDateFormat();
        return datestringformatconfig.format(datestringformatconfig.parse(s));
    }

    protected static Date parseDateString(DateStringFormatConfig datestringformatconfig, String s)
    {
        return datestringformatconfig.getDateFormat().parse(s);
    }

    public boolean isValidForVersion()
    {
        return true;
    }

    public Object moveToNextValue(Object obj)
    {
        long l = System.currentTimeMillis();
        if (obj == null)
        {
            return new Date(l);
        }
        if (l == ((Date)obj).getTime())
        {
            return new Date(l + 1L);
        } else
        {
            return new Date(l);
        }
    }


    private class DateStringFormatConfig
    {

        final String dateFormatStr;
        private final ThreadLocal threadLocal = new ThreadLocal();

        public DateFormat getDateFormat()
        {
            DateFormat dateformat = (DateFormat)threadLocal.get();
            Object obj = dateformat;
            if (dateformat == null)
            {
                obj = new SimpleDateFormat(dateFormatStr);
                threadLocal.set(obj);
            }
            return ((DateFormat) (obj));
        }

        public String toString()
        {
            return dateFormatStr;
        }

        public DateStringFormatConfig(String s)
        {
            dateFormatStr = s;
        }
    }

}
