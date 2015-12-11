// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;

public final class MessageLoop
    implements Executor
{

    private final BlockingQueue a = new LinkedBlockingQueue();
    private final Runnable b = new _cls1();
    private boolean c;
    private boolean d;

    public MessageLoop()
    {
        c = false;
        d = false;
    }

    static boolean a(MessageLoop messageloop, boolean flag)
    {
        messageloop.c = false;
        return false;
    }

    public final void a()
    {
        if (d)
        {
            throw new IllegalStateException("Cannot run loop as an exception has occurred previously.");
        }
        if (c)
        {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        c = true;
_L2:
        if (!c)
        {
            break; /* Loop/switch isn't completed */
        }
        ((Runnable)a.take()).run();
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
_L3:
        c = false;
        d = true;
        if (obj instanceof InterruptedException)
        {
            throw new IOException(((Throwable) (obj)));
        }
        if (obj instanceof RuntimeException)
        {
            throw (RuntimeException)obj;
        }
        if (true) goto _L2; else goto _L1
_L1:
        return;
        obj;
          goto _L3
    }

    public final void b()
    {
        execute(b);
    }

    public final void execute(Runnable runnable)
    {
        if (runnable == null)
        {
            throw new IllegalArgumentException();
        }
        try
        {
            a.put(runnable);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            throw new RejectedExecutionException(runnable);
        }
    }

    private class _cls1
        implements Runnable
    {

        private MessageLoop a;

        public void run()
        {
            MessageLoop.a(a, false);
        }

        _cls1()
        {
            a = MessageLoop.this;
            super();
        }
    }

}
