// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;


public final class o
    implements Cloneable
{

    private long a;

    public o(long l)
    {
        a = l;
    }

    public byte[] a()
    {
        return (new byte[] {
            (byte)(int)(a & 255L), (byte)(int)((a & 65280L) >> 8), (byte)(int)((a & 0xff0000L) >> 16), (byte)(int)((a & 0xff000000L) >> 24)
        });
    }

    public long b()
    {
        return a;
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof o) || a != ((o)obj).b()) 
        {
            return false;
        }
        return true;
    }

    public int hashCode()
    {
        return (int)a;
    }
}
