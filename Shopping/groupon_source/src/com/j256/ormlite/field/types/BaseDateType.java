// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.j256.ormlite.field.types:
//            BaseDataType

public abstract class BaseDateType extends BaseDataType
{
    protected static class DateStringFormatConfig
    {

        final String dateFormatStr;
        private final ThreadLocal threadLocal = new _cls1();

        public DateFormat getDateFormat()
        {
            return (DateFormat)threadLocal.get();
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


    protected static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");

    protected BaseDateType(SqlType sqltype, Class aclass[])
    {
        super(sqltype, aclass);
    }

    protected static DateStringFormatConfig convertDateStringConfig(FieldType fieldtype, DateStringFormatConfig datestringformatconfig)
    {
        if (fieldtype != null)
        {
            if ((fieldtype = (DateStringFormatConfig)fieldtype.getDataTypeConfigObj()) != null)
            {
                return fieldtype;
            }
        }
        return datestringformatconfig;
    }

    protected static String normalizeDateString(DateStringFormatConfig datestringformatconfig, String s)
        throws ParseException
    {
        datestringformatconfig = datestringformatconfig.getDateFormat();
        return datestringformatconfig.format(datestringformatconfig.parse(s));
    }

    protected static Date parseDateString(DateStringFormatConfig datestringformatconfig, String s)
        throws ParseException
    {
        return datestringformatconfig.getDateFormat().parse(s);
    }

    public boolean isValidForField(Field field)
    {
        return field.getType() == java/util/Date;
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
            return new Date(1L + l);
        } else
        {
            return new Date(l);
        }
    }


    // Unreferenced inner class com/j256/ormlite/field/types/BaseDateType$DateStringFormatConfig$1

/* anonymous class */
    class DateStringFormatConfig._cls1 extends ThreadLocal
    {

        final DateStringFormatConfig this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            return new SimpleDateFormat(dateFormatStr);
        }

            
            {
                this$0 = DateStringFormatConfig.this;
                super();
            }
    }

}
