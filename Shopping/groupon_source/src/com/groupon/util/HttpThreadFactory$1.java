// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import roboguice.util.Ln;

// Referenced classes of package com.groupon.util:
//            HttpThreadFactory

class val.runnable
    implements Runnable
{

    final HttpThreadFactory this$0;
    final Runnable val$runnable;

    public void run()
    {
        Thread thread = Thread.currentThread();
        Ln.d("Starting new thread %s", new Object[] {
            thread
        });
        val$runnable.run();
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

    ()
    {
        this$0 = final_httpthreadfactory;
        val$runnable = Runnable.this;
        super();
    }
}
