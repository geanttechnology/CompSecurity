// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;


final class ci extends Number
    implements Comparable
{

    boolean a;
    private double b;
    private long c;

    private ci(double d)
    {
        b = d;
        a = false;
    }

    private ci(long l)
    {
        c = l;
        a = true;
    }

    public static ci a(long l)
    {
        return new ci(l);
    }

    public static ci a(Double double1)
    {
        return new ci(double1.doubleValue());
    }

    public static ci a(String s)
    {
        ci ci1;
        try
        {
            ci1 = new ci(Long.parseLong(s));
        }
        catch (NumberFormatException numberformatexception)
        {
            ci ci2;
            try
            {
                ci2 = new ci(Double.parseDouble(s));
            }
            catch (NumberFormatException numberformatexception1)
            {
                throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid TypedNumber").toString());
            }
            return ci2;
        }
        return ci1;
    }

    public final int a(ci ci1)
    {
        if (a && ci1.a)
        {
            return (new Long(c)).compareTo(Long.valueOf(ci1.c));
        } else
        {
            return Double.compare(doubleValue(), ci1.doubleValue());
        }
    }

    public final byte byteValue()
    {
        return (byte)(int)longValue();
    }

    public final int compareTo(Object obj)
    {
        return a((ci)obj);
    }

    public final double doubleValue()
    {
        if (a)
        {
            return (double)c;
        } else
        {
            return b;
        }
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof ci) && a((ci)obj) == 0;
    }

    public final float floatValue()
    {
        return (float)doubleValue();
    }

    public final int hashCode()
    {
        return (new Long(longValue())).hashCode();
    }

    public final int intValue()
    {
        return (int)longValue();
    }

    public final long longValue()
    {
        if (a)
        {
            return c;
        } else
        {
            return (long)b;
        }
    }

    public final short shortValue()
    {
        return (short)(int)longValue();
    }

    public final String toString()
    {
        if (a)
        {
            return Long.toString(c);
        } else
        {
            return Double.toString(b);
        }
    }
}
