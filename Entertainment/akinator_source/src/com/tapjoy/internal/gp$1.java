// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.tapjoy.internal:
//            gp, ga, gc, gg, 
//            gb, go

final class a
    implements Runnable
{

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
            a a1 = ((gc) (obj)).a(a, "session").d(l);
            ((gc) (obj)).a(a1);
            obj.c = 0L;
            ((gc) (obj)).a.a(a1.h(), l);
            obj = ((gc) (obj)).b;
            if (((gb) (obj)).b != null)
            {
                ((gb) (obj)).a();
                (new <init>(((gb) (obj)))).run();
            }
            ((gb) (obj)).a.flush();
        }
    }

    a(gp gp1)
    {
        a = gp1;
        super();
    }
}
