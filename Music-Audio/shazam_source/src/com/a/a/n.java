// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.a.a:
//            e, h, m, u, 
//            c, b, g, p

public final class n
{
    public static interface a
    {

        public abstract boolean a(m m1);
    }


    final Map a;
    final Set b;
    final PriorityBlockingQueue c;
    public final b d;
    List e;
    private AtomicInteger f;
    private final PriorityBlockingQueue g;
    private final g h;
    private final p i;
    private h j[];
    private c k;

    private n(b b1, g g1)
    {
        this(b1, g1, ((p) (new e(new Handler(Looper.getMainLooper())))));
    }

    public n(b b1, g g1, byte byte0)
    {
        this(b1, g1);
    }

    private n(b b1, g g1, p p)
    {
        f = new AtomicInteger();
        a = new HashMap();
        b = new HashSet();
        c = new PriorityBlockingQueue();
        g = new PriorityBlockingQueue();
        e = new ArrayList();
        d = b1;
        h = g1;
        j = new h[4];
        i = p;
    }

    public final m a(m m1)
    {
        m1.setRequestQueue(this);
        synchronized (b)
        {
            b.add(m1);
        }
        m1.setSequence(f.incrementAndGet());
        m1.addMarker("add-to-queue");
        if (!m1.shouldCache())
        {
            g.add(m1);
            return m1;
        }
        break MISSING_BLOCK_LABEL_67;
        m1;
        set;
        JVM INSTR monitorexit ;
        throw m1;
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        String s;
        s = m1.getCacheKey();
        if (!a.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_177;
        }
        queue = (Queue)a.get(s);
        Object obj;
        obj = queue;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        obj = new LinkedList();
        ((Queue) (obj)).add(m1);
        a.put(s, obj);
        if (u.b)
        {
            u.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] {
                s
            });
        }
_L1:
        map;
        JVM INSTR monitorexit ;
        return m1;
        m1;
        map;
        JVM INSTR monitorexit ;
        throw m1;
        a.put(s, null);
        c.add(m1);
          goto _L1
    }

    public final void a()
    {
        boolean flag = false;
        if (k != null)
        {
            c c1 = k;
            c1.a = true;
            c1.interrupt();
        }
        for (int l = 0; l < j.length; l++)
        {
            if (j[l] != null)
            {
                h h1 = j[l];
                h1.a = true;
                h1.interrupt();
            }
        }

        k = new c(c, g, d, i);
        k.start();
        for (int i1 = ((flag) ? 1 : 0); i1 < j.length; i1++)
        {
            h h2 = new h(g, h, d, i);
            j[i1] = h2;
            h2.start();
        }

    }

    public final void a(a a1)
    {
        Set set = b;
        set;
        JVM INSTR monitorenter ;
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            m m1 = (m)iterator.next();
            if (a1.a(m1))
            {
                m1.cancel();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_61;
        a1;
        set;
        JVM INSTR monitorexit ;
        throw a1;
        set;
        JVM INSTR monitorexit ;
    }

    // Unreferenced inner class com/a/a/n$1

/* anonymous class */
    public final class _cls1
        implements a
    {

        final Object a;
        final n b;

        public final boolean a(m m1)
        {
            return m1.getTag() == a;
        }

            public 
            {
                b = n.this;
                a = obj;
                super();
            }
    }

}
