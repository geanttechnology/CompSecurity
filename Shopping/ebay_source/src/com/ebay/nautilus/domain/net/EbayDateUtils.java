// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import android.text.TextUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

public class EbayDateUtils
{
    private static final class CompleteDate
    {

        static final ThreadLocal FORMAT = new ThreadLocal() {

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected DateFormat initialValue()
            {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS".substring(0, 10), Locale.US);
            }

        };


        private CompleteDate()
        {
        }
    }

    private static final class CompleteDatePlusHoursAndMinutes
    {

        static final DateTimeParseHelper HELPER = new DateTimeParseHelper("yyyy-MM-dd'T'HH:mm:ss'.'SSS".substring(0, 18));


        private CompleteDatePlusHoursAndMinutes()
        {
        }
    }

    private static final class CompleteDateTime
    {

        static final DateTimeParseHelper HELPER = new DateTimeParseHelper("yyyy-MM-dd'T'HH:mm:ss'.'SSS");


        private CompleteDateTime()
        {
        }
    }

    private static final class CompleteDateTimeNoMillis
    {

        static final DateTimeParseHelper HELPER = new DateTimeParseHelper("yyyy-MM-dd'T'HH:mm:ss'.'SSS".substring(0, 21));


        private CompleteDateTimeNoMillis()
        {
        }
    }

    private static final class CompleteDateUtc
    {

        static final ThreadLocal FORMAT = new ThreadLocal() {

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected DateFormat initialValue()
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSS".substring(0, 10), Locale.US);
                simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpledateformat;
            }

        };


        private CompleteDateUtc()
        {
        }
    }

    private static final class CompleteDateWithTimeZone
    {

        static final DateTimeParseHelper HELPER = new DateTimeParseHelper("yyyy-MM-dd'T'HH:mm:ss'.'SSS".substring(0, 10));


        private CompleteDateWithTimeZone()
        {
        }
    }

    private static final class DateTimeParseHelper
    {

        public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss'.'SSS";
        private final String pattern;
        public final ThreadLocal standard = new _cls1();
        public final ThreadLocal utc = new _cls2();

        public final String format(Date date, TimeZone timezone)
        {
            TimeZone timezone1;
            timezone1 = timezone;
            if (timezone == null)
            {
                timezone1 = TimeZone.getDefault();
            }
            if (timezone1.getOffset(date.getTime()) != 0) goto _L2; else goto _L1
_L1:
            date = ((DateFormat)utc.get()).format(date);
_L4:
            return date;
_L2:
            timezone = (DateFormat)standard.get();
            int i;
            char c;
            if (!timezone1.equals(timezone.getTimeZone()))
            {
                timezone = (DateFormat)timezone.clone();
                timezone.setTimeZone(timezone1);
            }
            if (android.os.Build.VERSION.SDK_INT >= 18)
            {
                break MISSING_BLOCK_LABEL_154;
            }
            timezone = timezone.format(date);
            i = timezone.length();
            c = timezone.charAt(i - 5);
            if (c == '-')
            {
                break; /* Loop/switch isn't completed */
            }
            date = timezone;
            if (c != '+') goto _L4; else goto _L3
_L3:
            date = new StringBuilder(i + 1);
            date.append(timezone).insert(i - 2, ':');
            return date.toString();
            return timezone.format(date);
        }

        public final DateFormat getParser(String s)
        {
            if (TextUtils.isEmpty(s) || s.charAt(s.length() - 1) == 'Z')
            {
                return (DateFormat)utc.get();
            } else
            {
                return (DateFormat)standard.get();
            }
        }


        public DateTimeParseHelper(String s)
        {
            pattern = s;
        }
    }


    public EbayDateUtils()
    {
    }

    public static String format(Date date)
    {
        return ((DateFormat)CompleteDateTime.HELPER.utc.get()).format(date);
    }

    public static String formatIso8601DateTime(Date date)
    {
        return CompleteDateTime.HELPER.format(date, null);
    }

    public static String formatIso8601DateTime(Date date, TimeZone timezone)
    {
        return CompleteDateTime.HELPER.format(date, timezone);
    }

    public static String formatIso8601DateTimeUtc(Date date)
    {
        return ((DateFormat)CompleteDateTime.HELPER.utc.get()).format(date);
    }

    public static int getDaysBetween(Date date, Date date1)
    {
        long l = date.getTime();
        long l1 = date1.getTime();
        long l2 = l1 - l;
        if ((l1 ^ l2) < 0L && (l1 ^ l) < 0L)
        {
            throw new ArithmeticException((new StringBuilder()).append("The calculation caused an overflow: ").append(l1).append(" - ").append(l).toString());
        }
        l = l2 / 0x5265c00L;
        if (0xffffffff80000000L <= l && l <= 0x7fffffffL)
        {
            return (int)l;
        } else
        {
            throw new ArithmeticException((new StringBuilder()).append("Value cannot fit in an int: ").append(l).toString());
        }
    }

    public static Date parse(String s)
        throws ParseException
    {
        return parseIso8601DateTime(s);
    }

    public static final Date parseDateOnly(String s)
        throws ParseException
    {
        return parseIso8601Date(s.substring(0, 10));
    }

    public static long parseIntoMs(String s)
        throws ParseException
    {
        return parseIso8601DateTime(s).getTime();
    }

    public static Date parseIso8601Date(String s)
        throws ParseException
    {
        return ((DateFormat)CompleteDate.FORMAT.get()).parse(s);
    }

    public static Date parseIso8601DateTime(String s)
        throws ParseException
    {
        DateFormat dateformat1 = CompleteDateTime.HELPER.getParser(s);
        DateFormat dateformat = dateformat1;
        if (!TextUtils.isEmpty(s))
        {
            dateformat = dateformat1;
            if (s.indexOf('.') == -1)
            {
                dateformat = dateformat1;
                if (s.length() > 16)
                {
                    dateformat = dateformat1;
                    if (s.charAt(13) == ':')
                    {
                        if (s.charAt(16) == ':')
                        {
                            dateformat = CompleteDateTimeNoMillis.HELPER.getParser(s);
                        } else
                        {
                            dateformat = CompleteDatePlusHoursAndMinutes.HELPER.getParser(s);
                        }
                    }
                }
            }
        }
        return dateformat.parse(s);
    }

    public static Date parseIso8601DateUtc(String s)
        throws ParseException
    {
        return ((DateFormat)CompleteDateUtc.FORMAT.get()).parse(s);
    }

    public static Date parseIso8601DateWithTimeZone(String s)
        throws ParseException
    {
        return CompleteDateWithTimeZone.HELPER.getParser(s).parse(s);
    }

    public static final Date parseXml(String s)
        throws SAXException
    {
        try
        {
            s = parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
        return s;
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/EbayDateUtils$DateTimeParseHelper$1

/* anonymous class */
    class DateTimeParseHelper._cls1 extends ThreadLocal
    {

        final DateTimeParseHelper this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            String s;
            if (android.os.Build.VERSION.SDK_INT < 18)
            {
                s = "Z";
            } else
            {
                s = "ZZZZZ";
            }
            return new SimpleDateFormat((new StringBuilder()).append(pattern).append(s).toString(), Locale.US);
        }

            
            {
                this$0 = DateTimeParseHelper.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/nautilus/domain/net/EbayDateUtils$DateTimeParseHelper$2

/* anonymous class */
    class DateTimeParseHelper._cls2 extends ThreadLocal
    {

        final DateTimeParseHelper this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat((new StringBuilder()).append(pattern).append("'Z'").toString(), Locale.US);
            simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpledateformat;
        }

            
            {
                this$0 = DateTimeParseHelper.this;
                super();
            }
    }

}
