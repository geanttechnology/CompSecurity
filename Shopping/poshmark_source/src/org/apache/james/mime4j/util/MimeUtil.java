// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public final class MimeUtil
{
    private static final class Rfc822DateFormat extends SimpleDateFormat
    {

        private static final long serialVersionUID = 1L;

        public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
        {
            date = super.format(date, stringbuffer, fieldposition);
            int i = (calendar.get(15) + calendar.get(16)) / 1000 / 60;
            if (i < 0)
            {
                date.append('-');
                i = -i;
            } else
            {
                date.append('+');
            }
            date.append(String.format("%02d%02d", new Object[] {
                Integer.valueOf(i / 60), Integer.valueOf(i % 60)
            }));
            return date;
        }

        public Rfc822DateFormat()
        {
            super("EEE, d MMM yyyy HH:mm:ss ", Locale.US);
        }
    }


    public static final String ENC_7BIT = "7bit";
    public static final String ENC_8BIT = "8bit";
    public static final String ENC_BASE64 = "base64";
    public static final String ENC_BINARY = "binary";
    public static final String ENC_QUOTED_PRINTABLE = "quoted-printable";
    private static final ThreadLocal RFC822_DATE_FORMAT = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected DateFormat initialValue()
        {
            return new Rfc822DateFormat();
        }

    };
    private static int counter = 0;
    private static final Random random = new Random();

    private MimeUtil()
    {
    }

    public static String createUniqueBoundary()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("-=Part.");
        stringbuilder.append(Integer.toHexString(nextCounterValue()));
        stringbuilder.append('.');
        stringbuilder.append(Long.toHexString(random.nextLong()));
        stringbuilder.append('.');
        stringbuilder.append(Long.toHexString(System.currentTimeMillis()));
        stringbuilder.append('.');
        stringbuilder.append(Long.toHexString(random.nextLong()));
        stringbuilder.append("=-");
        return stringbuilder.toString();
    }

    public static String createUniqueMessageId(String s)
    {
        StringBuilder stringbuilder = new StringBuilder("<Mime4j.");
        stringbuilder.append(Integer.toHexString(nextCounterValue()));
        stringbuilder.append('.');
        stringbuilder.append(Long.toHexString(random.nextLong()));
        stringbuilder.append('.');
        stringbuilder.append(Long.toHexString(System.currentTimeMillis()));
        if (s != null)
        {
            stringbuilder.append('@');
            stringbuilder.append(s);
        }
        stringbuilder.append('>');
        return stringbuilder.toString();
    }

    public static String fold(String s, int i)
    {
        int i1 = s.length();
        if (i + i1 <= 76)
        {
            return s;
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = -i;
        i = indexOfWsp(s, 0);
        do
        {
            if (i == i1)
            {
                stringbuilder.append(s.substring(Math.max(0, j)));
                return stringbuilder.toString();
            }
            int l = indexOfWsp(s, i + 1);
            int k = j;
            if (l - j > 76)
            {
                stringbuilder.append(s.substring(Math.max(0, j), i));
                stringbuilder.append("\r\n");
                k = i;
            }
            i = l;
            j = k;
        } while (true);
    }

    public static String formatDate(Date date, TimeZone timezone)
    {
        DateFormat dateformat = (DateFormat)RFC822_DATE_FORMAT.get();
        if (timezone == null)
        {
            dateformat.setTimeZone(TimeZone.getDefault());
        } else
        {
            dateformat.setTimeZone(timezone);
        }
        return dateformat.format(date);
    }

    private static int indexOfWsp(String s, int i)
    {
        int j;
        for (j = s.length(); i < j; i++)
        {
            char c = s.charAt(i);
            if (c == ' ' || c == '\t')
            {
                return i;
            }
        }

        return j;
    }

    public static boolean isBase64Encoding(String s)
    {
        return "base64".equalsIgnoreCase(s);
    }

    public static boolean isMessage(String s)
    {
        return s != null && s.equalsIgnoreCase("message/rfc822");
    }

    public static boolean isMultipart(String s)
    {
        return s != null && s.toLowerCase().startsWith("multipart/");
    }

    public static boolean isQuotedPrintableEncoded(String s)
    {
        return "quoted-printable".equalsIgnoreCase(s);
    }

    public static boolean isSameMimeType(String s, String s1)
    {
        return s != null && s1 != null && s.equalsIgnoreCase(s1);
    }

    private static int nextCounterValue()
    {
        org/apache/james/mime4j/util/MimeUtil;
        JVM INSTR monitorenter ;
        int i;
        i = counter;
        counter = i + 1;
        org/apache/james/mime4j/util/MimeUtil;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static String unfold(String s)
    {
        int j = s.length();
        int i = 0;
        do
        {
label0:
            {
                String s1 = s;
                if (i < j)
                {
                    char c = s.charAt(i);
                    if (c != '\r' && c != '\n')
                    {
                        break label0;
                    }
                    s1 = unfold0(s, i);
                }
                return s1;
            }
            i++;
        } while (true);
    }

    private static String unfold0(String s, int i)
    {
        int j = s.length();
        StringBuilder stringbuilder = new StringBuilder(j);
        if (i > 0)
        {
            stringbuilder.append(s.substring(0, i));
        }
        for (i++; i < j; i++)
        {
            char c = s.charAt(i);
            if (c != '\r' && c != '\n')
            {
                stringbuilder.append(c);
            }
        }

        return stringbuilder.toString();
    }

}
