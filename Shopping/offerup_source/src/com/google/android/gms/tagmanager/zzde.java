// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;


class zzde extends Number
    implements Comparable
{

    private double zzaZG;
    private long zzaZH;
    private boolean zzaZI;

    private zzde(double d)
    {
        zzaZG = d;
        zzaZI = false;
    }

    private zzde(long l)
    {
        zzaZH = l;
        zzaZI = true;
    }

    public static zzde zzW(long l)
    {
        return new zzde(l);
    }

    public static zzde zza(Double double1)
    {
        return new zzde(double1.doubleValue());
    }

    public static zzde zzfd(String s)
    {
        zzde zzde1;
        try
        {
            zzde1 = new zzde(Long.parseLong(s));
        }
        catch (NumberFormatException numberformatexception)
        {
            zzde zzde2;
            try
            {
                zzde2 = new zzde(Double.parseDouble(s));
            }
            catch (NumberFormatException numberformatexception1)
            {
                throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid TypedNumber").toString());
            }
            return zzde2;
        }
        return zzde1;
    }

    public byte byteValue()
    {
        return (byte)(int)longValue();
    }

    public int compareTo(Object obj)
    {
        return zza((zzde)obj);
    }

    public double doubleValue()
    {
        if (zzDN())
        {
            return (double)zzaZH;
        } else
        {
            return zzaZG;
        }
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof zzde) && zza((zzde)obj) == 0;
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
        return zzDP();
    }

    public long longValue()
    {
        return zzDO();
    }

    public short shortValue()
    {
        return zzDQ();
    }

    public String toString()
    {
        if (zzDN())
        {
            return Long.toString(zzaZH);
        } else
        {
            return Double.toString(zzaZG);
        }
    }

    public boolean zzDM()
    {
        return !zzDN();
    }

    public boolean zzDN()
    {
        return zzaZI;
    }

    public long zzDO()
    {
        if (zzDN())
        {
            return zzaZH;
        } else
        {
            return (long)zzaZG;
        }
    }

    public int zzDP()
    {
        return (int)longValue();
    }

    public short zzDQ()
    {
        return (short)(int)longValue();
    }

    public int zza(zzde zzde1)
    {
        if (zzDN() && zzde1.zzDN())
        {
            return (new Long(zzaZH)).compareTo(Long.valueOf(zzde1.zzaZH));
        } else
        {
            return Double.compare(doubleValue(), zzde1.doubleValue());
        }
    }
}
