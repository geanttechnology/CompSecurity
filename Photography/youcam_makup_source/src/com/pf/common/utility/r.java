// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import java.util.concurrent.atomic.AtomicInteger;

public final class r
{

    private static final r b = new r();
    private final AtomicInteger a = new AtomicInteger();

    public r()
    {
    }

    private static long a(Object obj, int i)
    {
        return (long)System.identityHashCode(obj) << 32 | (long)i;
    }

    private static String b(Object obj, int i)
    {
        return (new StringBuilder()).append(System.identityHashCode(obj)).append("@").append(i).toString();
    }

    public long a(Object obj)
    {
        return a(obj, a.incrementAndGet());
    }

    public String b(Object obj)
    {
        return b(obj, a.incrementAndGet());
    }

}
