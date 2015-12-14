// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;


public final class p
    implements Cloneable
{

    private int a;

    public p(int i)
    {
        a = i;
    }

    public p(byte abyte0[])
    {
        this(abyte0, 0);
    }

    public p(byte abyte0[], int i)
    {
        a = abyte0[i + 1] << 8 & 0xff00;
        a = a + (abyte0[i] & 0xff);
    }

    public byte[] a()
    {
        return (new byte[] {
            (byte)(a & 0xff), (byte)((a & 0xff00) >> 8)
        });
    }

    public int b()
    {
        return a;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof p) || a != ((p)obj).b()) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return a;
    }
}
