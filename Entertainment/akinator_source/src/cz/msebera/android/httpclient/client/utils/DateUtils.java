// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.util.Args;
import java.lang.ref.SoftReference;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class DateUtils
{
    static final class DateFormatHolder
    {

        private static final ThreadLocal THREADLOCAL_FORMATS = new ThreadLocal() {

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected SoftReference initialValue()
            {
                return new SoftReference(new HashMap());
            }

        };

        public static void clearThreadLocal()
        {
            THREADLOCAL_FORMATS.remove();
        }

        public static SimpleDateFormat formatFor(String s)
        {
            Object obj1 = (Map)((SoftReference)THREADLOCAL_FORMATS.get()).get();
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = new HashMap();
                THREADLOCAL_FORMATS.set(new SoftReference(obj));
            }
            SimpleDateFormat simpledateformat = (SimpleDateFormat)((Map) (obj)).get(s);
            obj1 = simpledateformat;
            if (simpledateformat == null)
            {
                obj1 = new SimpleDateFormat(s, Locale.US);
                ((SimpleDateFormat) (obj1)).setTimeZone(TimeZone.getTimeZone("GMT"));
                ((Map) (obj)).put(s, obj1);
            }
            return ((SimpleDateFormat) (obj1));
        }


        DateFormatHolder()
        {
        }
    }


    private static final String DEFAULT_PATTERNS[] = {
        "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"
    };
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    public static final TimeZone GMT;
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateUtils()
    {
    }

    public static void clearThreadLocal()
    {
        DateFormatHolder.clearThreadLocal();
    }

    public static String formatDate(Date date)
    {
        return formatDate(date, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date date, String s)
    {
        Args.notNull(date, "Date");
        Args.notNull(s, "Pattern");
        return DateFormatHolder.formatFor(s).format(date);
    }

    public static Date parseDate(String s)
    {
        return parseDate(s, null, null);
    }

    public static Date parseDate(String s, String as[])
    {
        return parseDate(s, as, null);
    }

    public static Date parseDate(String s, String as[], Date date)
    {
        Args.notNull(s, "Date value");
        String s1;
        int j;
        if (as == null)
        {
            as = DEFAULT_PATTERNS;
        }
        if (date == null)
        {
            date = DEFAULT_TWO_DIGIT_YEAR_START;
        }
        s1 = s;
        s = s1;
        if (s1.length() > 1)
        {
            s = s1;
            if (s1.startsWith("'"))
            {
                s = s1;
                if (s1.endsWith("'"))
                {
                    s = s1.substring(1, s1.length() - 1);
                }
            }
        }
        j = as.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = DateFormatHolder.formatFor(as[i]);
            ((SimpleDateFormat) (obj)).set2DigitYearStart(date);
            ParsePosition parseposition = new ParsePosition(0);
            obj = ((SimpleDateFormat) (obj)).parse(s, parseposition);
            if (parseposition.getIndex() != 0)
            {
                return ((Date) (obj));
            }
        }

        return null;
    }

    static 
    {
        GMT = TimeZone.getTimeZone("GMT");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(GMT);
        calendar.set(2000, 0, 1, 0, 0, 0);
        calendar.set(14, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime();
    }
}
