// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtils
{

    public ConcurrentUtils()
    {
    }

    public static boolean waitLatchWithTimeOut(CountDownLatch countdownlatch, long l, TimeUnit timeunit)
    {
        boolean flag;
        try
        {
            flag = countdownlatch.await(l, timeunit);
        }
        // Misplaced declaration of an exception variable
        catch (CountDownLatch countdownlatch)
        {
            Thread.currentThread().interrupt();
            return false;
        }
        return flag;
    }
}
