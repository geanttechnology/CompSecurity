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

public class n
{
    public static interface a
    {

        public abstract boolean a(m m1);
    }

    public static interface b
    {

        public abstract void a(m m1);
    }


    private AtomicInteger a;
    private final Map b;
    private final Set c;
    private final PriorityBlockingQueue d;
    private final PriorityBlockingQueue e;
    private final com.a.a.b f;
    private final g g;
    private final p h;
    private h i[];
    private c j;
    private List k;

    public n(com.a.a.b b1, g g1)
    {
        this(b1, g1, 4);
    }

    public n(com.a.a.b b1, g g1, int l)
    {
        this(b1, g1, l, ((p) (new e(new Handler(Looper.getMainLooper())))));
    }

    public n(com.a.a.b b1, g g1, int l, p p)
    {
        a = new AtomicInteger();
        b = new HashMap();
        c = new HashSet();
        d = new PriorityBlockingQueue();
        e = new PriorityBlockingQueue();
        k = new ArrayList();
        f = b1;
        g = g1;
        i = new h[l];
        h = p;
    }

    public m a(m m1)
    {
        m1.setRequestQueue(this);
        synchronized (c)
        {
            c.add(m1);
        }
        m1.setSequence(c());
        m1.addMarker("add-to-queue");
        if (!m1.shouldCache())
        {
            e.add(m1);
            return m1;
        }
        break MISSING_BLOCK_LABEL_64;
        m1;
        set;
        JVM INSTR monitorexit ;
        throw m1;
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        String s;
        s = m1.getCacheKey();
        if (!b.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        queue = (Queue)b.get(s);
        Object obj;
        obj = queue;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj = new LinkedList();
        ((Queue) (obj)).add(m1);
        b.put(s, obj);
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
        b.put(s, null);
        d.add(m1);
          goto _L1
    }

    public void a()
    {
        b();
        j = new c(d, e, f, h);
        j.start();
        for (int l = 0; l < i.length; l++)
        {
            h h1 = new h(e, g, f, h);
            i[l] = h1;
            h1.start();
        }

    }

    public void a(a a1)
    {
        Set set = c;
        set;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
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

    public void a(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        } else
        {
            a(new a(obj) {

                final Object a;
                final n b;

                public boolean a(m m1)
                {
                    return m1.getTag() == a;
                }

            
            {
                b = n.this;
                a = obj;
                super();
            }
            });
            return;
        }
    }

    public void b()
    {
        if (j != null)
        {
            j.a();
        }
        for (int l = 0; l < i.length; l++)
        {
            if (i[l] != null)
            {
                i[l].a();
            }
        }

    }

    void b(m m1)
    {
        synchronized (c)
        {
            c.remove(m1);
        }
        obj = k;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = k.iterator(); iterator.hasNext(); ((b)iterator.next()).a(m1)) { }
        break MISSING_BLOCK_LABEL_74;
        m1;
        obj;
        JVM INSTR monitorexit ;
        throw m1;
        m1;
        obj;
        JVM INSTR monitorexit ;
        throw m1;
        obj;
        JVM INSTR monitorexit ;
        if (!m1.shouldCache())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        m1 = m1.getCacheKey();
        queue = (Queue)b.remove(m1);
        if (queue == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        if (u.b)
        {
            u.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] {
                Integer.valueOf(queue.size()), m1
            });
        }
        d.addAll(queue);
        map;
        JVM INSTR monitorexit ;
        return;
        m1;
        map;
        JVM INSTR monitorexit ;
        throw m1;
    }

    public int c()
    {
        return a.incrementAndGet();
    }
}
