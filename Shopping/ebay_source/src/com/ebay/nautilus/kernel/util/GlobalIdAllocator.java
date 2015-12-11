// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import java.util.concurrent.atomic.AtomicInteger;

public class GlobalIdAllocator
{

    private static final int ID_BASE = 0xf4240;
    private static AtomicInteger next = new AtomicInteger(0xf4240);

    public GlobalIdAllocator()
    {
    }

    public static int nextId()
    {
        return next.getAndIncrement();
    }

}
