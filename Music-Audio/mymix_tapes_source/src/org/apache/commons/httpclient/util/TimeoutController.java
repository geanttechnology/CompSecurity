// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;


public final class TimeoutController
{
    public static class TimeoutException extends Exception
    {

        public TimeoutException()
        {
        }
    }


    private TimeoutController()
    {
    }

    public static void execute(Runnable runnable, long l)
        throws TimeoutException
    {
        runnable = new Thread(runnable, "Timeout guard");
        runnable.setDaemon(true);
        execute(((Thread) (runnable)), l);
    }

    public static void execute(Thread thread, long l)
        throws TimeoutException
    {
        thread.start();
        try
        {
            thread.join(l);
        }
        catch (InterruptedException interruptedexception) { }
        if (thread.isAlive())
        {
            thread.interrupt();
            throw new TimeoutException();
        } else
        {
            return;
        }
    }
}
