// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import java.util.concurrent.Semaphore;

// Referenced classes of package net.singular.sdk:
//            Collector, SingularLog

class e
    implements Runnable
{

    final Collector this$0;
    final String val$name;
    final Runnable val$setRunnable;
    final Semaphore val$waitSem;

    public void run()
    {
        val$setRunnable.run();
        Object obj;
        try
        {
            val$waitSem.release();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            return;
        }
        obj;
        Collector.access$200(Collector.this).trackError("singular_sdk", String.format("runExternalJob(%s) failed", new Object[] {
            val$name
        }), ((Throwable) (obj)));
        try
        {
            val$waitSem.release();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        obj;
        try
        {
            val$waitSem.release();
        }
        catch (RuntimeException runtimeexception1) { }
        throw obj;
    }

    e()
    {
        this$0 = final_collector;
        val$setRunnable = runnable;
        val$name = s;
        val$waitSem = Semaphore.this;
        super();
    }
}
