// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


class adn extends Number
    implements Comparable
{

    private double a;
    private long b;
    private boolean c;

    private adn(double d1)
    {
        a = d1;
        c = false;
    }

    private adn(long l)
    {
        b = l;
        c = true;
    }

    public static adn a(long l)
    {
        return new adn(l);
    }

    public static adn a(Double double1)
    {
        return new adn(double1.doubleValue());
    }

    public static adn a(String s)
        throws NumberFormatException
    {
        adn adn1;
        try
        {
            adn1 = new adn(Long.parseLong(s));
        }
        catch (NumberFormatException numberformatexception)
        {
            adn adn2;
            try
            {
                adn2 = new adn(Double.parseDouble(s));
            }
            catch (NumberFormatException numberformatexception1)
            {
                throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid TypedNumber").toString());
            }
            return adn2;
        }
        return adn1;
    }

    public int a(adn adn1)
    {
        if (b() && adn1.b())
        {
            return (new Long(b)).compareTo(Long.valueOf(adn1.b));
        } else
        {
            return Double.compare(doubleValue(), adn1.doubleValue());
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
        return a((adn)obj);
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
        return (obj instanceof adn) && a((adn)obj) == 0;
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
