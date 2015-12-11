// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.mopub.d:
//            e, g, c, l, 
//            t, b, f, o

public class m
{
    public static interface a
    {

        public abstract boolean a(l l1);
    }


    private AtomicInteger a;
    final Map b;
    final Set c;
    final PriorityBlockingQueue d;
    private final PriorityBlockingQueue e;
    private final b f;
    private final f g;
    private final o h;
    private g i[];
    private c j;

    private m(b b1, f f1)
    {
        this(b1, f1, ((o) (new e(new Handler(Looper.getMainLooper())))));
    }

    public m(b b1, f f1, byte byte0)
    {
        this(b1, f1);
    }

    private m(b b1, f f1, o o)
    {
        a = new AtomicInteger();
        b = new HashMap();
        c = new HashSet();
        d = new PriorityBlockingQueue();
        e = new PriorityBlockingQueue();
        f = b1;
        g = f1;
        i = new g[4];
        h = o;
    }

    public final void a()
    {
        boolean flag = false;
        if (j != null)
        {
            c c1 = j;
            c1.a = true;
            c1.interrupt();
        }
        for (int k = 0; k < i.length; k++)
        {
            if (i[k] != null)
            {
                g g1 = i[k];
                g1.a = true;
                g1.interrupt();
            }
        }

        j = new c(d, e, f, h);
        j.start();
        for (int i1 = ((flag) ? 1 : 0); i1 < i.length; i1++)
        {
            g g2 = new g(e, g, f, h);
            i[i1] = g2;
            g2.start();
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
            l l1 = (l)iterator.next();
            if (a1.a(l1))
            {
                l1.h = true;
            }
        } while (true);
        break MISSING_BLOCK_LABEL_62;
        a1;
        set;
        JVM INSTR monitorexit ;
        throw a1;
        set;
        JVM INSTR monitorexit ;
    }

    public final l b(l l1)
    {
        l1.f = this;
        synchronized (c)
        {
            c.add(l1);
        }
        l1.e = Integer.valueOf(a.incrementAndGet());
        l1.a("add-to-queue");
        if (!l1.g)
        {
            e.add(l1);
            return l1;
        }
        break MISSING_BLOCK_LABEL_68;
        l1;
        set;
        JVM INSTR monitorexit ;
        throw l1;
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        String s;
        s = l1.b;
        if (!b.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        queue = (Queue)b.get(s);
        Object obj;
        obj = queue;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = new LinkedList();
        ((Queue) (obj)).add(l1);
        b.put(s, obj);
        if (t.b)
        {
            t.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] {
                s
            });
        }
_L1:
        map;
        JVM INSTR monitorexit ;
        return l1;
        l1;
        map;
        JVM INSTR monitorexit ;
        throw l1;
        b.put(s, null);
        d.add(l1);
          goto _L1
    }
}
