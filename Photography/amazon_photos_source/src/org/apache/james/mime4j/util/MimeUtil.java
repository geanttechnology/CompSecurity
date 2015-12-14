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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class MimeUtil
{
    private static final class Rfc822DateFormat extends SimpleDateFormat
    {

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
    private static final Log log = LogFactory.getLog(org/apache/james/mime4j/util/MimeUtil);
    private static final Random random = new Random();

    private MimeUtil()
    {
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

    public static boolean isQuotedPrintableEncoded(String s)
    {
        return "quoted-printable".equalsIgnoreCase(s);
    }

}
