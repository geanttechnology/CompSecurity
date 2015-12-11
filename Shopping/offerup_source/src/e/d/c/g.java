// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;

import e.b.h;
import e.c.a;
import e.d.d.p;
import e.f.d;
import e.h.b;
import e.k;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package e.d.c:
//            j, i, h

public final class g extends AtomicReference
    implements k, Runnable
{

    private p a;
    private a b;

    public g(a a1)
    {
        b = a1;
        a = new p();
    }

    public g(a a1, p p1)
    {
        b = a1;
        a = new p(new j(this, p1));
    }

    public g(a a1, b b1)
    {
        b = a1;
        a = new p(new i(this, b1));
    }

    public final void a(b b1)
    {
        a.a(new i(this, b1));
    }

    public final void a(k k1)
    {
        a.a(k1);
    }

    public final void a(Future future)
    {
        a.a(new e.d.c.h(this, future, (byte)0));
    }

    public final void b()
    {
        if (!a.c())
        {
            a.b();
        }
    }

    public final boolean c()
    {
        return a.c();
    }

    public final void run()
    {
        lazySet(Thread.currentThread());
        b.a();
        b();
        return;
        Object obj;
        obj;
        if (!(obj instanceof h))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", ((Throwable) (obj)));
_L1:
        d.a().b();
        Thread thread = Thread.currentThread();
        thread.getUncaughtExceptionHandler().uncaughtException(thread, ((Throwable) (obj)));
        b();
        return;
        obj = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", ((Throwable) (obj)));
          goto _L1
        obj;
        b();
        throw obj;
    }
}
