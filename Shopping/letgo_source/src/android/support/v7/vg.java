// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

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

// Referenced classes of package android.support.v7:
//            pr, rt, ve, yd, 
//            np, mo, qs, vy

public class vg
{
    public static interface a
    {

        public abstract void a(ve ve1);
    }


    private AtomicInteger a;
    private final Map b;
    private final Set c;
    private final PriorityBlockingQueue d;
    private final PriorityBlockingQueue e;
    private final mo f;
    private final qs g;
    private final vy h;
    private rt i[];
    private np j;
    private List k;

    public vg(mo mo, qs qs)
    {
        this(mo, qs, 4);
    }

    public vg(mo mo, qs qs, int l)
    {
        this(mo, qs, l, ((vy) (new pr(new Handler(Looper.getMainLooper())))));
    }

    public vg(mo mo, qs qs, int l, vy vy)
    {
        a = new AtomicInteger();
        b = new HashMap();
        c = new HashSet();
        d = new PriorityBlockingQueue();
        e = new PriorityBlockingQueue();
        k = new ArrayList();
        f = mo;
        g = qs;
        i = new rt[l];
        h = vy;
    }

    public ve a(ve ve1)
    {
        ve1.a(this);
        synchronized (c)
        {
            c.add(ve1);
        }
        ve1.a(c());
        ve1.b("add-to-queue");
        if (!ve1.p())
        {
            e.add(ve1);
            return ve1;
        }
        break MISSING_BLOCK_LABEL_64;
        ve1;
        set;
        JVM INSTR monitorexit ;
        throw ve1;
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        String s;
        s = ve1.e();
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
        ((Queue) (obj)).add(ve1);
        b.put(s, obj);
        if (yd.b)
        {
            yd.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] {
                s
            });
        }
_L1:
        map;
        JVM INSTR monitorexit ;
        return ve1;
        ve1;
        map;
        JVM INSTR monitorexit ;
        throw ve1;
        b.put(s, null);
        d.add(ve1);
          goto _L1
    }

    public void a()
    {
        b();
        j = new np(d, e, f, h);
        j.start();
        for (int l = 0; l < i.length; l++)
        {
            rt rt1 = new rt(e, g, f, h);
            i[l] = rt1;
            rt1.start();
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

    void b(ve ve1)
    {
        synchronized (c)
        {
            c.remove(ve1);
        }
        obj = k;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = k.iterator(); iterator.hasNext(); ((a)iterator.next()).a(ve1)) { }
        break MISSING_BLOCK_LABEL_74;
        ve1;
        obj;
        JVM INSTR monitorexit ;
        throw ve1;
        ve1;
        obj;
        JVM INSTR monitorexit ;
        throw ve1;
        obj;
        JVM INSTR monitorexit ;
        if (!ve1.p())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        ve1 = ve1.e();
        queue = (Queue)b.remove(ve1);
        if (queue == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        if (yd.b)
        {
            yd.a("Releasing %d waiting requests for cacheKey=%s.", new Object[] {
                Integer.valueOf(queue.size()), ve1
            });
        }
        d.addAll(queue);
        map;
        JVM INSTR monitorexit ;
        return;
        ve1;
        map;
        JVM INSTR monitorexit ;
        throw ve1;
    }

    public int c()
    {
        return a.incrementAndGet();
    }
}
