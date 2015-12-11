// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class ary extends Number
    implements Comparable
{

    private double a;
    private long b;
    private boolean c;

    private ary(long l)
    {
        b = l;
        c = true;
    }

    public static ary a(long l)
    {
        return new ary(l);
    }

    public int a(ary ary1)
    {
        if (b() && ary1.b())
        {
            return (new Long(b)).compareTo(Long.valueOf(ary1.b));
        } else
        {
            return Double.compare(doubleValue(), ary1.doubleValue());
        }
    }

    public boolean a()
    {
        return !b();
    }

    public boolean b()
    {
        return c;
    }

    public byte byteValue()
    {
        return (byte)(int)longValue();
    }

    public long c()
    {
        if (b())
        {
            return b;
        } else
        {
            return (long)a;
        }
    }

    public int compareTo(Object obj)
    {
        return a((ary)obj);
    }

    public int d()
    {
        return (int)longValue();
    }

    public double doubleValue()
    {
        if (b())
        {
            return (double)b;
        } else
        {
            return a;
        }
    }

    public short e()
    {
        return (short)(int)longValue();
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof ary) && a((ary)obj) == 0;
    }

    public float floatValue()
    {
        return (float)doubleValue();
    }

    public int hashCode()
    {
        return (new Long(longValue())).hashCode();
    }

    public int intValue()
    {
        return d();
    }

    public long longValue()
    {
        return c();
    }

    public short shortValue()
    {
        return e();
    }

    public String toString()
    {
        if (b())
        {
            return Long.toString(b);
        } else
        {
            return Double.toString(a);
        }
    }
}
