// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CountDownLatch;

public class DataSourceThread extends Thread
{

    private Handler m_handler;
    private final String m_name;
    private final CountDownLatch m_readyLatch = new CountDownLatch(1);

    public DataSourceThread(String s)
    {
        m_name = s;
    }

    public void awaitReady()
        throws InterruptedException
    {
        m_readyLatch.await();
    }

    public void run()
    {
        setName((new StringBuilder()).append(m_name).append(" Thread").toString());
        Looper.prepare();
        m_handler = new Handler();
        m_readyLatch.countDown();
        Looper.loop();
    }

    public void runRunnable(Runnable runnable)
    {
        m_handler.post(runnable);
    }

    public void shutdown()
    {
        m_handler.getLooper().quit();
    }

    public void start()
    {
        super.start();
        try
        {
            awaitReady();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not start data source thread for ").append(m_name).toString());
        }
    }
}
