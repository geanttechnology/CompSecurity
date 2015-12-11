// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.o;

import java.util.concurrent.TimeUnit;

public final class q
    implements Comparable
{
    public static final class a
    {

        public long a;
        public TimeUnit b;

        public final q a()
        {
            return new q(this, (byte)0);
        }

        public a()
        {
        }
    }


    private final long a;
    private final TimeUnit b;

    public q(long l, TimeUnit timeunit)
    {
        b = timeunit;
        a = l;
    }

    private q(a a1)
    {
        a = a1.a;
        b = a1.b;
    }

    q(a a1, byte byte0)
    {
        this(a1);
    }

    public final int a(q q1)
    {
        if (a() < q1.a())
        {
            return -1;
        }
        return a() != q1.a() ? 1 : 0;
    }

    public final long a()
    {
        return b.toMillis(a);
    }

    public final int compareTo(Object obj)
    {
        return a((q)obj);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof q)
        {
            obj = (q)obj;
            flag = flag1;
            if (a() == ((q) (obj)).a())
            {
                flag = true;
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return (int)(a ^ a >>> 32) * 31 + b.hashCode();
    }
}
