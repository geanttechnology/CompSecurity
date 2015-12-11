// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.b.f;
import e.c.a;
import e.d.d.a.q;
import e.d.d.a.x;
import e.d.d.e;
import e.g;
import e.h;
import e.j;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

// Referenced classes of package e.d.a:
//            a, r, s

final class p extends j
{

    static final AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(e/d/a/p, "d");
    private static AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(e/d/a/p, "f");
    final j a;
    final h b;
    final s c;
    volatile long d;
    volatile long f;
    private e.d.a.a g;
    private Queue h;
    private volatile boolean i;
    private volatile Throwable k;
    private a l;

    public p(g g1, j j1)
    {
        g = e.d.a.a.a();
        i = false;
        d = 0L;
        l = new r(this);
        a = j1;
        b = g1.a();
        if (x.a())
        {
            h = new q(e.b);
        } else
        {
            h = new e.d.d.q(e.b);
        }
        c = new s(b);
    }

    public final void a()
    {
        if (c() || i)
        {
            return;
        } else
        {
            i = true;
            e();
            return;
        }
    }

    public final void a(Object obj)
    {
        if (c())
        {
            return;
        }
        if (!h.offer(e.d.a.a.a(obj)))
        {
            a(((Throwable) (new f())));
            return;
        } else
        {
            e();
            return;
        }
    }

    public final void a(Throwable throwable)
    {
        if (c() || i)
        {
            return;
        } else
        {
            k = throwable;
            b();
            i = true;
            e();
            return;
        }
    }

    public final void d()
    {
        a(e.b);
    }

    protected final void e()
    {
        if (j.getAndIncrement(this) == 0L)
        {
            b.a(l);
        }
    }

    final void f()
    {
        int i1 = 0;
_L5:
        int j1;
        long l1;
        long l2;
        f = 1L;
        l2 = d;
        l1 = 0L;
        j1 = i1;
_L3:
        if (!a.c()) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            if (i)
            {
                Throwable throwable = k;
                if (throwable != null)
                {
                    h.clear();
                    a.a(throwable);
                    return;
                }
                if (h.isEmpty())
                {
                    a.a();
                    return;
                }
            }
            if (l2 <= 0L)
            {
                break label0;
            }
            Object obj = h.poll();
            if (obj == null)
            {
                break label0;
            }
            a.a(e.d.a.a.c(obj));
            l2--;
            l1++;
            j1++;
        }
          goto _L3
        if (l1 > 0L && d != 0x7fffffffffffffffL)
        {
            e.addAndGet(this, -l1);
        }
        i1 = j1;
        if (j.decrementAndGet(this) > 0L) goto _L5; else goto _L4
_L4:
        if (j1 <= 0) goto _L1; else goto _L6
_L6:
        a(j1);
        return;
          goto _L3
    }

}
