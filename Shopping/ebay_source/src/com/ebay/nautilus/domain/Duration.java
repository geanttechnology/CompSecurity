// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import java.util.Calendar;
import java.util.Date;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

public final class Duration
{

    public final long timeInSeconds;

    public Duration(long l)
    {
        timeInSeconds = l;
    }

    private static long getTimeInSeconds(int i, int j, int k, int l, int i1, int j1, Date date)
    {
        Calendar calendar = Calendar.getInstance();
        if (date == null)
        {
            date = new Date();
        }
        calendar.setTime(date);
        if (i != 0)
        {
            calendar.add(1, i);
        }
        if (j != 0)
        {
            calendar.add(2, j);
        }
        if (k != 0)
        {
            calendar.add(5, k);
        }
        if (l != 0)
        {
            calendar.add(10, l);
        }
        if (i1 != 0)
        {
            calendar.add(12, i1);
        }
        if (j1 != 0)
        {
            calendar.add(13, j1);
        }
        return (calendar.getTime().getTime() - date.getTime()) / 1000L;
    }

    public static final Duration parse(String s)
        throws IllegalArgumentException
    {
        return parse(s, null);
    }

    public static final Duration parse(String s, Date date)
        throws IllegalArgumentException
    {
        return new Duration(parseToTimeInSeconds(s, date));
    }

    private static long parseToTimeInSeconds(String s, Date date)
        throws IllegalArgumentException
    {
        int i;
        int j;
        int k;
        int l;
        boolean flag1;
        int i1;
        int j1;
        int l1;
        int i2;
        int j2;
        int k2;
label0:
        {
            boolean flag = true;
            i1 = 0;
            j = 0;
            j2 = 0;
            i2 = 0;
            k = 0;
            j1 = 0;
            k2 = s.length();
            if (k2 < 1)
            {
                return 0L;
            }
            i = 0;
            char c1 = s.charAt(0);
            if (c1 != '-')
            {
                l = ((flag) ? 1 : 0);
                if (c1 != '+')
                {
                    break label0;
                }
            }
            int k1 = 0 + 1;
            i = k1;
            l = ((flag) ? 1 : 0);
            if (c1 == '-')
            {
                l = -1;
                i = k1;
            }
        }
        if (i == k2)
        {
            return 0L;
        }
        if (s.charAt(i) != 'P')
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") expected 'P' at index=").append(String.valueOf(i)).toString());
        }
        l1 = i + 1;
        i = 0;
        flag1 = false;
_L10:
        char c;
        if (l1 >= k2)
        {
            break MISSING_BLOCK_LABEL_715;
        }
        c = s.charAt(l1);
        c;
        JVM INSTR lookupswitch 16: default 308
    //                   48: 357
    //                   49: 357
    //                   50: 357
    //                   51: 357
    //                   52: 357
    //                   53: 357
    //                   54: 357
    //                   55: 357
    //                   56: 357
    //                   57: 357
    //                   68: 438
    //                   72: 504
    //                   77: 632
    //                   83: 570
    //                   84: 651
    //                   89: 376;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L7:
        break MISSING_BLOCK_LABEL_651;
_L8:
        break; /* Loop/switch isn't completed */
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected '").append(c).append("' at index=").append(String.valueOf(l1)).toString());
_L2:
        i = i * 10 + (c - 48);
_L11:
        l1++;
        if (true) goto _L10; else goto _L9
_L9:
        if (flag1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected '").append(c).append("' at index=").append(String.valueOf(l1)).toString());
        }
        i1 = i;
        i = 0;
          goto _L11
_L3:
        if (flag1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected '").append(c).append("' at index=").append(String.valueOf(l1)).toString());
        }
        boolean flag2 = false;
        j2 = i;
        i = ((flag2) ? 1 : 0);
          goto _L11
_L4:
        if (!flag1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected '").append(c).append("' at index=").append(String.valueOf(l1)).toString());
        }
        boolean flag3 = false;
        i2 = i;
        i = ((flag3) ? 1 : 0);
          goto _L11
_L6:
        if (!flag1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected '").append(c).append("' at index=").append(String.valueOf(l1)).toString());
        }
        j1 = i;
        i = 0;
          goto _L11
_L5:
        if (flag1)
        {
            k = i;
        } else
        {
            j = i;
        }
        i = 0;
          goto _L11
        if (flag1 || i != 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected '").append(c).append("' at index=").append(String.valueOf(l1)).toString());
        }
        flag1 = true;
          goto _L11
        if (i != 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duration.parseToTimeInSeconds(str=\"").append(s).append("\") unexpected end of string").toString());
        }
        if (i1 == 0 && j == 0)
        {
            return (((24L * (long)j2 + (long)i2) * 60L + (long)k) * 60L + (long)j1) * (long)l;
        } else
        {
            return getTimeInSeconds(i1 * l, j * l, j2 * l, i2 * l, k * l, j1 * l, date);
        }
    }

    public static final Duration parseXml(String s)
        throws SAXException
    {
        return parseXml(s, null);
    }

    public static final Duration parseXml(String s, Date date)
        throws SAXException
    {
        try
        {
            s = parse(s, date);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotSupportedException(s.getLocalizedMessage());
        }
        return s;
    }

    public final String format()
    {
        long l1 = timeInSeconds;
        if (l1 == 0L)
        {
            return "PT0S";
        }
        StringBuilder stringbuilder;
        boolean flag;
        long l;
        long l2;
        long l3;
        if (l1 < 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l = l1;
        if (flag)
        {
            l = -l1;
        }
        l1 = l % 60L;
        l2 = l / 60L;
        l = l2 % 60L;
        l3 = l2 / 60L;
        l2 = l3 % 24L;
        l3 /= 24L;
        stringbuilder = new StringBuilder();
        if (flag)
        {
            stringbuilder.append('-');
        }
        stringbuilder.append('P');
        if (l3 != 0L)
        {
            stringbuilder.append(l3).append('D');
        }
        if (l2 != 0L || l != 0L || l1 != 0L)
        {
            stringbuilder.append('T');
            if (l2 != 0L)
            {
                stringbuilder.append(l2).append('H');
            }
            if (l != 0L)
            {
                stringbuilder.append(l).append('M');
            }
            if (l1 != 0L)
            {
                stringbuilder.append(l1).append('S');
            }
        }
        return stringbuilder.toString();
    }

    public final Date getEndFromStart(Date date)
    {
        long l = date.getTime();
        return new Date(timeInSeconds * 1000L + l);
    }

    public final Date getStartFromEnd(Date date)
    {
        return new Date(date.getTime() - timeInSeconds * 1000L);
    }

    public String toString()
    {
        return format();
    }
}
