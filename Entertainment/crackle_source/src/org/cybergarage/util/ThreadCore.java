// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;


public class ThreadCore
    implements Runnable
{

    private Thread mThreadObject;

    public ThreadCore()
    {
        mThreadObject = null;
    }

    public Thread getThreadObject()
    {
        return mThreadObject;
    }

    public boolean isRunnable()
    {
        return Thread.currentThread() == getThreadObject();
    }

    public void restart()
    {
        stop();
        start();
    }

    public void run()
    {
    }

    public void setThreadObject(Thread thread)
    {
        mThreadObject = thread;
    }

    public void start()
    {
        if (getThreadObject() == null)
        {
            Thread thread = new Thread(this, "Cyber.ThreadCore");
            setThreadObject(thread);
            thread.start();
        }
    }

    public void stop()
    {
        Thread thread = getThreadObject();
        if (thread != null)
        {
            thread.interrupt();
            setThreadObject(null);
        }
    }
}
