// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

// Referenced classes of package com.groupon.util:
//            TimeZoneIntlDateFormat

public class TimeZoneUSFriendlyDateFormat extends TimeZoneIntlDateFormat
{
    public static final class OutputType extends Enum
    {

        private static final OutputType $VALUES[];
        public static final OutputType longDate;
        public static final OutputType shortDate;

        public static OutputType valueOf(String s)
        {
            return (OutputType)Enum.valueOf(com/groupon/util/TimeZoneUSFriendlyDateFormat$OutputType, s);
        }

        public static OutputType[] values()
        {
            return (OutputType[])$VALUES.clone();
        }

        static 
        {
            longDate = new OutputType("longDate", 0);
            shortDate = new OutputType("shortDate", 1);
            $VALUES = (new OutputType[] {
                longDate, shortDate
            });
        }

        private OutputType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String USER_FRIENDLY_INTL_DATE_FORMAT = "E, MMMM dd, yyyy";
    private static final String USER_FRIENDLY_INTL_DATE_FORMAT_SHORT = "MMM dd, yyyy";
    private OutputType outputType;

    public TimeZoneUSFriendlyDateFormat()
    {
        outputType = OutputType.longDate;
    }

    protected DateFormat getLocalInstance()
    {
        Object obj;
        if (outputType == OutputType.longDate)
        {
            obj = "E, MMMM dd, yyyy";
        } else
        {
            obj = "MMM dd, yyyy";
        }
        obj = new SimpleDateFormat(((String) (obj)));
        if (timeZone != null)
        {
            ((DateFormat) (obj)).setTimeZone(timeZone);
        }
        return ((DateFormat) (obj));
    }

    public void setOutputType(OutputType outputtype)
    {
        outputType = outputtype;
    }
}
