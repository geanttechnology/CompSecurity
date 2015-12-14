// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package org.apache.commons.httpclient.util:
//            DateParseException

public class DateUtil
{

    private static final Collection DEFAULT_PATTERNS = Arrays.asList(new String[] {
        "EEE MMM d HH:mm:ss yyyy", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE, dd MMM yyyy HH:mm:ss zzz"
    });
    private static final Date DEFAULT_TWO_DIGIT_YEAR_START;
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final String PATTERN_ASCTIME = "EEE MMM d HH:mm:ss yyyy";
    public static final String PATTERN_RFC1036 = "EEEE, dd-MMM-yy HH:mm:ss zzz";
    public static final String PATTERN_RFC1123 = "EEE, dd MMM yyyy HH:mm:ss zzz";

    private DateUtil()
    {
    }

    public static String formatDate(Date date)
    {
        return formatDate(date, "EEE, dd MMM yyyy HH:mm:ss zzz");
    }

    public static String formatDate(Date date, String s)
    {
        if (date == null)
        {
            throw new IllegalArgumentException("date is null");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("pattern is null");
        } else
        {
            s = new SimpleDateFormat(s, Locale.US);
            s.setTimeZone(GMT);
            return s.format(date);
        }
    }

    public static Date parseDate(String s)
        throws DateParseException
    {
        return parseDate(s, null, null);
    }

    public static Date parseDate(String s, Collection collection)
        throws DateParseException
    {
        return parseDate(s, collection, null);
    }

    public static Date parseDate(String s, Collection collection, Date date)
        throws DateParseException
    {
        Object obj;
        if (s == null)
        {
            throw new IllegalArgumentException("dateValue is null");
        }
        obj = collection;
        if (collection == null)
        {
            obj = DEFAULT_PATTERNS;
        }
        collection = date;
        if (date == null)
        {
            collection = DEFAULT_TWO_DIGIT_YEAR_START;
        }
        date = s;
        if (s.length() > 1)
        {
            date = s;
            if (s.startsWith("'"))
            {
                date = s;
                if (s.endsWith("'"))
                {
                    date = s.substring(1, s.length() - 1);
                }
            }
        }
        s = null;
        obj = ((Collection) (obj)).iterator();
_L2:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_157;
        }
        Object obj1 = (String)((Iterator) (obj)).next();
        if (s == null)
        {
            s = new SimpleDateFormat(((String) (obj1)), Locale.US);
            s.setTimeZone(TimeZone.getTimeZone("GMT"));
            s.set2DigitYearStart(collection);
        } else
        {
            s.applyPattern(((String) (obj1)));
        }
        obj1 = s.parse(date);
        return ((Date) (obj1));
        throw new DateParseException("Unable to parse the date " + date);
        ParseException parseexception;
        parseexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 0, 1, 0, 0);
        DEFAULT_TWO_DIGIT_YEAR_START = calendar.getTime();
    }
}
