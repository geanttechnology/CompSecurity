// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class Uninterruptibles
{

    private Uninterruptibles()
    {
    }

    public static void awaitUninterruptibly(CountDownLatch countdownlatch)
    {
        boolean flag = false;
_L2:
        countdownlatch.await();
        if (flag)
        {
            Thread.currentThread().interrupt();
        }
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        countdownlatch;
        if (flag)
        {
            Thread.currentThread().interrupt();
        }
        throw countdownlatch;
    }

    public static Object getUninterruptibly(Future future)
        throws ExecutionException
    {
        boolean flag = false;
_L2:
        Object obj = future.get();
        if (flag)
        {
            Thread.currentThread().interrupt();
        }
        return obj;
        InterruptedException interruptedexception;
        interruptedexception;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        future;
        if (flag)
        {
            Thread.currentThread().interrupt();
        }
        throw future;
    }
}
