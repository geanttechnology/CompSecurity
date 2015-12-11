// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;

import android.os.Handler;
import android.os.Process;
import java.lang.ref.ReferenceQueue;

class setName extends Thread
{

    private final Handler handler;
    private final ReferenceQueue referenceQueue;

    public void run()
    {
        Process.setThreadPriority(10);
        class _cls1
            implements Runnable
        {

            final Picasso.CleanupThread this$0;
            final Exception val$e;

            public void run()
            {
                throw new RuntimeException(e);
            }

            _cls1()
            {
                this$0 = Picasso.CleanupThread.this;
                e = exception;
                super();
            }
        }

        try
        {
            do
            {
                rence rence = (rence)referenceQueue.remove();
                handler.sendMessage(handler.obtainMessage(3, rence.action));
            } while (true);
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        catch (final Exception e)
        {
            handler.post(new _cls1());
        }
    }

    void shutdown()
    {
        interrupt();
    }

    _cls1(ReferenceQueue referencequeue, Handler handler1)
    {
        referenceQueue = referencequeue;
        handler = handler1;
        setDaemon(true);
        setName("Picasso-refQueue");
    }
}
