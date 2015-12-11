// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.easibeacon.protocol;

import java.io.Serializable;
import java.util.Arrays;

public class IBeacon
    implements Serializable
{

    private byte a[];
    private int b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g;
    private String h;

    public IBeacon()
    {
        this(null, -1, -1, -1);
    }

    public IBeacon(byte abyte0[], int i, int j)
    {
        this(abyte0, i, j, -1);
    }

    public IBeacon(byte abyte0[], int i, int j, int k)
    {
        d = false;
        a = abyte0;
        b = i;
        c = j;
        g = k;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && getClass() == obj.getClass())
        {
            obj = (IBeacon)obj;
            if (getUuidHexString().equals(((IBeacon) (obj)).getUuidHexString()) && b == ((IBeacon) (obj)).getMajor() && c == ((IBeacon) (obj)).getMinor())
            {
                return true;
            }
        }
        return false;
    }

    public int getMajor()
    {
        return b;
    }

    public int getMinor()
    {
        return c;
    }

    public int getPowerValue()
    {
        return e;
    }

    public int getProximity()
    {
        return g;
    }

    public int getRssi()
    {
        return f;
    }

    public byte[] getUuid()
    {
        return a;
    }

    public String getUuidHexString()
    {
        byte abyte0[] = a;
        int j = abyte0.length;
        String s = "";
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            s = (new StringBuilder()).append(s).append(String.format("%2X", new Object[] {
                Byte.valueOf(byte0)
            })).toString();
        }

        return s;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (a != null)
        {
            i = Arrays.hashCode(a);
        } else
        {
            i = 0;
        }
        l = b;
        i1 = c;
        if (d)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        j1 = e;
        k1 = f;
        l1 = g;
        if (h != null)
        {
            k = h.hashCode();
        }
        return ((((j + ((i * 31 + l) * 31 + i1) * 31) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + k;
    }

    public boolean isEasiBeacon()
    {
        return d;
    }

    public void setEasiBeacon(boolean flag)
    {
        d = flag;
    }

    public void setMacAddress(String s)
    {
        h = s;
    }

    public void setMajor(int i)
    {
        b = i;
    }

    public void setMinor(int i)
    {
        c = i;
    }

    public void setPowerValue(int i)
    {
        e = i;
    }

    public void setProximity(int i)
    {
        g = i;
    }

    public void setRssi(int i)
    {
        f = i;
    }

    public void setUuid(byte abyte0[])
    {
        a = abyte0;
    }

    public String toString()
    {
        return (new StringBuilder("UUID:")).append(getUuidHexString()).append(" M:").append(getMajor()).append(" m:").append(getMinor()).append(" p:").append(getProximity()).toString();
    }
}
