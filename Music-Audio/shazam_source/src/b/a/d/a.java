// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.d;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends DateFormat
{

    private static final Pattern a = Pattern.compile("(.*)([+-][0-9][0-9])\\:?([0-9][0-9])$");
    private static final Pattern b = Pattern.compile("(.*)\\.([0-9]+)(.*)");
    private final SimpleDateFormat c;
    private final SimpleDateFormat d;

    public a()
    {
        this(TimeZone.getTimeZone("UTC"));
    }

    public a(TimeZone timezone)
    {
        c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        d.setTimeZone(timezone);
    }

    public final StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        stringbuffer = new StringBuffer();
        stringbuffer.append(d.format(date).toString());
        long l = date.getTime();
        if (l % 1000L != 0L)
        {
            date = Long.toString(l % 1000L);
            stringbuffer.append((new StringBuilder(".")).append(date).toString());
        }
        date = d.getTimeZone();
        if (date.getOffset(l) == 0)
        {
            date = "Z";
        } else
        {
            int j = (int)((long)date.getOffset(l) / 1000L);
            int i = j / 3600;
            j = Math.abs((j - i * 3600) / 60);
            if (i >= 0)
            {
                date = "+";
            } else
            {
                date = "-";
            }
            date = (new StringBuilder()).append(date).append(String.format("%02d", new Object[] {
                Integer.valueOf(Math.abs(i))
            })).append(":").append(String.format("%02d", new Object[] {
                Integer.valueOf(j)
            })).toString();
        }
        stringbuffer.append(date);
        return stringbuffer;
    }

    public final Date parse(String s, ParsePosition parseposition)
    {
        Date date;
        long l;
        if (s.contains("."))
        {
            s = b.matcher(s);
            l = Long.parseLong(s.replaceAll("$2"));
            s = (new StringBuilder()).append(s.replaceAll("$1")).append(s.replaceAll("$3")).toString();
        } else
        {
            l = 0L;
        }
        if (s.endsWith("Z"))
        {
            s = (new StringBuilder()).append(s.substring(0, s.length() - 1)).append("-0000").toString();
        } else
        {
            Matcher matcher = a.matcher(s);
            if (matcher.matches())
            {
                s = (new StringBuilder()).append(matcher.replaceAll("$1")).append(matcher.replaceAll("$2")).append(matcher.replaceAll("$3")).toString();
            } else
            {
                s = (new StringBuilder()).append(s).append("-0000").toString();
            }
        }
        try
        {
            date = c.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        date = new Date(l + date.getTime());
        parseposition.setIndex(s.length());
        return date;
    }

}
