// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import e.d.d.a.d;
import e.d.d.a.x;
import e.g;
import e.g.j;
import e.h;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package e.d.d:
//            b

public abstract class a
{

    private Queue a;
    private final int b;
    private h c;

    public a()
    {
        this(0, 0, 67L);
    }

    private a(int i, int k, long l)
    {
        b = 0;
        a(0);
        c = j.a().a();
        c.a(new b(this, 0, 0), 67L, 67L, TimeUnit.SECONDS);
    }

    static Queue a(a a1)
    {
        return a1.a;
    }

    private void a(int i)
    {
        int k;
        if (x.a())
        {
            a = new d(Math.max(b, 1024));
        } else
        {
            a = new ConcurrentLinkedQueue();
        }
        for (k = 0; k < i; k++)
        {
            a.add(b());
        }

    }

    public final Object a()
    {
        Object obj1 = a.poll();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = b();
        }
        return obj;
    }

    public final void a(Object obj)
    {
        if (obj == null)
        {
            return;
        } else
        {
            a.offer(obj);
            return;
        }
    }

    protected abstract Object b();
}
