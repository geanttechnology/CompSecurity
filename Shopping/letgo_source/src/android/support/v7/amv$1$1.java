// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package android.support.v7:
//            amp, amv

class t> extends amp
{

    final Runnable a;
    final a b;

    public void onRun()
    {
        a.run();
    }

    .AtomicLong(.AtomicLong atomiclong, Runnable runnable)
    {
        b = atomiclong;
        a = runnable;
        super();
    }

    // Unreferenced inner class android/support/v7/amv$1

/* anonymous class */
    static final class amv._cls1
        implements ThreadFactory
    {

        final String a;
        final AtomicLong b;

        public Thread newThread(Runnable runnable)
        {
            runnable = Executors.defaultThreadFactory().newThread(new amv._cls1._cls1(this, runnable));
            runnable.setName((new StringBuilder()).append(a).append(b.getAndIncrement()).toString());
            return runnable;
        }

            
            {
                a = s;
                b = atomiclong;
                super();
            }
    }

}
