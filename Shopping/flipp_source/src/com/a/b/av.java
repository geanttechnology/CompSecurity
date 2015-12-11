// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;


public final class av
{

    public final int a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final int i;
    public final int j;
    public final long k;

    public av(int l, int i1, long l1, long l2, long l3, long l4, long l5, long l6, 
            int j1, int k1, long l7)
    {
        a = l;
        b = i1;
        c = l1;
        d = l2;
        e = l3;
        f = l4;
        g = l5;
        h = l6;
        i = j1;
        j = k1;
        k = l7;
    }

    public final String toString()
    {
        return (new StringBuilder("StatsSnapshot{maxSize=")).append(a).append(", size=").append(b).append(", cacheHits=").append(c).append(", cacheMisses=").append(d).append(", totalOriginalBitmapSize=").append(e).append(", totalTransformedBitmapSize=").append(f).append(", averageOriginalBitmapSize=").append(g).append(", averageTransformedBitmapSize=").append(h).append(", originalBitmapCount=").append(i).append(", transformedBitmapCount=").append(j).append(", timeStamp=").append(k).append('}').toString();
    }
}
