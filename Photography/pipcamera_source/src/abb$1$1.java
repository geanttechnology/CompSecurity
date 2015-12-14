// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class t> extends aav
{

    final Runnable a;
    final g.Runnable b;

    public void onRun()
    {
        a.run();
    }

    g.Runnable(le le, Runnable runnable)
    {
        b = le;
        a = runnable;
        super();
    }

    // Unreferenced inner class abb$1

/* anonymous class */
    final class abb._cls1
        implements ThreadFactory
    {

        final String a;
        final AtomicLong b;

        public Thread newThread(Runnable runnable)
        {
            runnable = Executors.defaultThreadFactory().newThread(new abb._cls1._cls1(this, runnable));
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
