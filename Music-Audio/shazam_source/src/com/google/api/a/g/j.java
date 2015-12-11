// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j
    implements Serializable
{

    private static final TimeZone a = TimeZone.getTimeZone("GMT");
    private static final Pattern b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
    private final long c;
    private final boolean d;
    private final int e;

    public j()
    {
        this(false, 0L, null);
    }

    private j(boolean flag, long l, Integer integer)
    {
        d = flag;
        c = l;
        int i;
        if (flag)
        {
            i = 0;
        } else
        if (integer == null)
        {
            i = TimeZone.getDefault().getOffset(l) / 60000;
        } else
        {
            i = integer.intValue();
        }
        e = i;
    }

    public static j a(String s)
    {
        Object obj;
        String s1;
        int i;
        int l;
        int j1;
        boolean flag;
        boolean flag1;
        int k2;
        int l2;
        int i3;
        obj = b.matcher(s);
        if (!((Matcher) (obj)).matches())
        {
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = "Invalid date/time format: ".concat(s);
            } else
            {
                s = new String("Invalid date/time format: ");
            }
            throw new NumberFormatException(s);
        }
        k2 = Integer.parseInt(((Matcher) (obj)).group(1));
        l2 = Integer.parseInt(((Matcher) (obj)).group(2));
        i3 = Integer.parseInt(((Matcher) (obj)).group(3));
        if (((Matcher) (obj)).group(4) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s1 = ((Matcher) (obj)).group(9);
        if (s1 != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i = 0;
        l = 0;
        j1 = 0;
        if (flag1 && !flag)
        {
            obj = String.valueOf("Invalid date/time format, cannot specify time zone shift without specifying time: ");
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = ((String) (obj)).concat(s);
            } else
            {
                s = new String(((String) (obj)));
            }
            throw new NumberFormatException(s);
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        int k1;
        int l1;
        int i2;
        k1 = Integer.parseInt(((Matcher) (obj)).group(5));
        l1 = Integer.parseInt(((Matcher) (obj)).group(6));
        i2 = Integer.parseInt(((Matcher) (obj)).group(7));
        i = k1;
        l = l1;
        j1 = i2;
        if (((Matcher) (obj)).group(8) == null) goto _L2; else goto _L3
_L3:
        int j2;
        j2 = Integer.parseInt(((Matcher) (obj)).group(8).substring(1));
        j1 = i2;
        l = l1;
        i = k1;
_L5:
        s = new GregorianCalendar(a);
        s.set(k2, l2 - 1, i3, i, l, j1);
        s.set(14, j2);
        long l3 = s.getTimeInMillis();
        boolean flag2;
        if (flag && flag1)
        {
            int k;
            if (Character.toUpperCase(s1.charAt(0)) == 'Z')
            {
                k = 0;
            } else
            {
                int i1 = Integer.parseInt(((Matcher) (obj)).group(11)) * 60 + Integer.parseInt(((Matcher) (obj)).group(12));
                k = i1;
                if (((Matcher) (obj)).group(10).charAt(0) == '-')
                {
                    k = -i1;
                }
                long l4 = k;
                l3 -= l4 * 60000L;
            }
            s = Integer.valueOf(k);
        } else
        {
            s = null;
        }
        if (!flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        return new j(flag2, l3, s);
_L2:
        j2 = 0;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void a(StringBuilder stringbuilder, int i, int k)
    {
        int l = i;
        if (i < 0)
        {
            stringbuilder.append('-');
            l = -i;
        }
        for (i = l; i > 0;)
        {
            i /= 10;
            k--;
        }

        for (i = 0; i < k; i++)
        {
            stringbuilder.append('0');
        }

        if (l != 0)
        {
            stringbuilder.append(l);
        }
    }

    public final String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        GregorianCalendar gregoriancalendar = new GregorianCalendar(a);
        gregoriancalendar.setTimeInMillis(c + (long)e * 60000L);
        a(stringbuilder, gregoriancalendar.get(1), 4);
        stringbuilder.append('-');
        a(stringbuilder, gregoriancalendar.get(2) + 1, 2);
        stringbuilder.append('-');
        a(stringbuilder, gregoriancalendar.get(5), 2);
        if (!d)
        {
            stringbuilder.append('T');
            a(stringbuilder, gregoriancalendar.get(11), 2);
            stringbuilder.append(':');
            a(stringbuilder, gregoriancalendar.get(12), 2);
            stringbuilder.append(':');
            a(stringbuilder, gregoriancalendar.get(13), 2);
            if (gregoriancalendar.isSet(14))
            {
                stringbuilder.append('.');
                a(stringbuilder, gregoriancalendar.get(14), 3);
            }
            if (e == 0)
            {
                stringbuilder.append('Z');
            } else
            {
                int i = e;
                if (e > 0)
                {
                    stringbuilder.append('+');
                } else
                {
                    stringbuilder.append('-');
                    i = -i;
                }
                a(stringbuilder, i / 60, 2);
                stringbuilder.append(':');
                a(stringbuilder, i % 60, 2);
            }
        }
        return stringbuilder.toString();
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof j))
            {
                return false;
            }
            obj = (j)obj;
            if (d != ((j) (obj)).d || c != ((j) (obj)).c || e != ((j) (obj)).e)
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        long l1 = c;
        long l;
        if (d)
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        return Arrays.hashCode(new long[] {
            l1, l, (long)e
        });
    }

    public final String toString()
    {
        return a();
    }

}
