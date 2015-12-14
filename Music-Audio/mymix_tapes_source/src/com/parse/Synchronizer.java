// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Synchronizer
{

    boolean done;
    CountDownLatch latch;

    Synchronizer()
    {
        done = false;
        latch = new CountDownLatch(1);
    }

    void assertFinishes()
    {
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
            throw new RuntimeException("assertFinishes() should *not* be called from the UI thread");
        }
        try
        {
            Thread.sleep(500L);
            done = latch.await(10L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException(interruptedexception.getMessage());
        }
        if (!done)
        {
            throw new RuntimeException("finish() was never called");
        } else
        {
            return;
        }
    }

    void finish()
    {
        if (Thread.currentThread() != Looper.getMainLooper().getThread())
        {
            throw new RuntimeException("finish() should be called from the UI thread");
        }
        if (done)
        {
            throw new RuntimeException("finish() was called too much");
        } else
        {
            latch.countDown();
            return;
        }
    }

    void start(int i)
    {
        latch = new CountDownLatch(i);
    }
}
