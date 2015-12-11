// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.restlet.engine.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InternetDateFormat extends DateFormat
{

    static final Pattern PATTERN = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})[tT\\s](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?(?:([zZ])|(?:(\\+|\\-)(\\d{2}):(\\d{2})))");
    public static final TimeZone UTC = new SimpleTimeZone(0, "Z");
    protected static volatile DecimalFormat df2 = new DecimalFormat("00");
    protected static volatile DecimalFormat df4 = new DecimalFormat("0000");
    protected Calendar cal;

    public InternetDateFormat()
    {
        this(UTC);
    }

    public InternetDateFormat(TimeZone timezone)
    {
        cal = new GregorianCalendar(timezone);
    }

    public CharSequence format(CharSequence charsequence, Date date)
    {
        return (new SimpleDateFormat(charsequence.toString())).format(date);
    }

    public CharSequence format(CharSequence charsequence, Date date, TimeZone timezone)
    {
        charsequence = new SimpleDateFormat(charsequence.toString());
        charsequence.setTimeZone(timezone);
        return charsequence.format(date);
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        return stringbuffer.append(toString(date));
    }

    public Calendar getCalendar()
    {
        return (Calendar)cal.clone();
    }

    public void initCalendar()
    {
        cal = new GregorianCalendar();
    }

    public void initCalendar(long l, TimeZone timezone)
    {
        initCalendar(timezone);
        cal.setTimeInMillis(l);
    }

    public void initCalendar(Date date, TimeZone timezone)
    {
        initCalendar(timezone);
        cal.setTime(date);
    }

    public void initCalendar(TimeZone timezone)
    {
        cal = new GregorianCalendar(timezone);
    }

    public Date parse(String s)
        throws ParseException
    {
        return parse(s, (ParsePosition)null);
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        return parseDate(s);
    }

    protected void parse(String s, Calendar calendar)
    {
        int i = 1;
        Matcher matcher = PATTERN.matcher(s);
        if (!matcher.matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid date/time: ").append(s).toString());
        }
        calendar.clear();
        calendar.set(1, Integer.parseInt(matcher.group(1)));
        calendar.set(2, Integer.parseInt(matcher.group(2)) - 1);
        calendar.set(5, Integer.parseInt(matcher.group(3)));
        calendar.set(11, Integer.parseInt(matcher.group(4)));
        calendar.set(12, Integer.parseInt(matcher.group(5)));
        calendar.set(13, Integer.parseInt(matcher.group(6)));
        if (matcher.group(7) != null)
        {
            calendar.set(14, (int)(1000F * Float.parseFloat(matcher.group(7))));
        }
        if (matcher.group(8) != null)
        {
            calendar.setTimeZone(new SimpleTimeZone(0, "Z"));
            return;
        }
        if (matcher.group(9).equals("-"))
        {
            i = -1;
        }
        i *= Integer.parseInt(matcher.group(10)) * 60 + Integer.parseInt(matcher.group(11));
        calendar.setTimeZone(new SimpleTimeZone(60000 * i, Integer.toString(i)));
    }

    public Date parseDate(String s)
    {
        initCalendar();
        parse(s, cal);
        return cal.getTime();
    }

    public String toString()
    {
        return toString(cal, false);
    }

    public String toString(long l, TimeZone timezone)
    {
        initCalendar(l, timezone);
        return toString();
    }

    public String toString(long l, TimeZone timezone, boolean flag)
    {
        if (flag)
        {
            return toString(l, timezone);
        } else
        {
            initCalendar(l, timezone);
            return toString(flag);
        }
    }

    public String toString(Calendar calendar, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(df4.format(calendar.get(1)));
        stringbuilder.append("-");
        stringbuilder.append(df2.format(calendar.get(2) + 1));
        stringbuilder.append("-");
        stringbuilder.append(df2.format(calendar.get(5)));
        stringbuilder.append("T");
        stringbuilder.append(df2.format(calendar.get(11)));
        stringbuilder.append(":");
        stringbuilder.append(df2.format(calendar.get(12)));
        stringbuilder.append(":");
        stringbuilder.append(df2.format(calendar.get(13)));
        int i = calendar.get(14);
        if (flag && i != 0)
        {
            stringbuilder.append(".").append((int)((float)i / 10F));
        }
        i = (calendar.get(15) + calendar.get(16)) / 60000;
        if (i == 0)
        {
            stringbuilder.append("Z");
        } else
        {
            int j;
            if (i < 0)
            {
                i = -i;
                stringbuilder.append("-");
            } else
            {
                stringbuilder.append("+");
            }
            j = i / 60;
            stringbuilder.append(df2.format(j));
            stringbuilder.append(":");
            stringbuilder.append(df2.format(i - j * 60));
        }
        return stringbuilder.toString();
    }

    public String toString(Date date)
    {
        return toString(date, UTC);
    }

    public String toString(Date date, TimeZone timezone)
    {
        initCalendar(date, timezone);
        return toString();
    }

    public String toString(boolean flag)
    {
        return toString(cal, flag);
    }

}
