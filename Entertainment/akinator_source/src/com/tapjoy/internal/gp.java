// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.tapjoy.internal:
//            gq, gc, ga, gg, 
//            gb, go

final class gp
{

    final gc a;
    final AtomicBoolean b = new AtomicBoolean();
    ScheduledFuture c;
    private final Runnable d = new Runnable() {

        final gp a;

        public final void run()
        {
            if (a.b.compareAndSet(true, false))
            {
                ga.a("The session ended");
                Object obj = a.a;
                long l = ((gc) (obj)).c;
                l = SystemClock.elapsedRealtime() - ((gc) (obj)).c;
                ((gc) (obj)).a.a(l);
                gt.c.a a1 = ((gc) (obj)).a(gt.i.a, "session").d(l);
                ((gc) (obj)).a(a1);
                obj.c = 0L;
                ((gc) (obj)).a.a(a1.h(), l);
                obj = ((gc) (obj)).b;
                if (((gb) (obj)).b != null)
                {
                    ((gb) (obj)).a();
                    (new gb._cls1(((gb) (obj)))).run();
                }
                ((gb) (obj)).a.flush();
            }
        }

            
            {
                a = gp.this;
                super();
            }
    };
    private final Runnable e = new Runnable() {

        final gp a;

        public final void run()
        {
            gc gc1 = a.a;
        }

            
            {
                a = gp.this;
                super();
            }
    };

    gp(gc gc)
    {
        a = gc;
    }

    final void a()
    {
label0:
        {
            if (b.get())
            {
                if (!Boolean.FALSE.booleanValue())
                {
                    break label0;
                }
                if (c == null || c.cancel(false))
                {
                    c = gq.a.schedule(d, 3000L, TimeUnit.MILLISECONDS);
                }
            }
            return;
        }
        d.run();
    }
}
