// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.util.concurrent.ThreadFactory;
import roboguice.util.Ln;

class HttpThreadFactory
    implements ThreadFactory
{

    HttpThreadFactory()
    {
    }

    public Thread newThread(final Runnable runnable)
    {
        runnable = new Thread(new Runnable() {

            final HttpThreadFactory this$0;
            final Runnable val$runnable;

            public void run()
            {
                Thread thread = Thread.currentThread();
                Ln.d("Starting new thread %s", new Object[] {
                    thread
                });
                runnable.run();
                Ln.d("Killing old thread %s", new Object[] {
                    thread
                });
                return;
                Exception exception;
                exception;
                Ln.d("Killing old thread %s", new Object[] {
                    thread
                });
                throw exception;
            }

            
            {
                this$0 = HttpThreadFactory.this;
                runnable = runnable1;
                super();
            }
        });
        runnable.setPriority(4);
        runnable.setName(String.format("HttpThread-%s", new Object[] {
            Long.valueOf(runnable.getId())
        }));
        return runnable;
    }
}
