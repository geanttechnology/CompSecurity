// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class mh
{

    final Map a;
    final Set b;
    final PriorityBlockingQueue c;
    private AtomicInteger d;
    private final PriorityBlockingQueue e;
    private final lr f;
    private final ly g;
    private final ml h;
    private lz i[];
    private lt j;

    public mh(lr lr, ly ly)
    {
        this(lr, ly, 4);
    }

    private mh(lr lr, ly ly, int k)
    {
        this(lr, ly, 4, new ml(new Handler(Looper.getMainLooper())));
    }

    public mh(lr lr, ly ly, int k, ml ml1)
    {
        d = new AtomicInteger();
        a = new HashMap();
        b = new HashSet();
        c = new PriorityBlockingQueue();
        e = new PriorityBlockingQueue();
        f = lr;
        g = ly;
        i = new lz[k];
        h = ml1;
    }

    public me a(me me1)
    {
        me1.d = this;
        synchronized (b)
        {
            b.add(me1);
        }
        me1.c = Integer.valueOf(c());
        me1.a("add-to-queue");
        if (!me1.e)
        {
            e.add(me1);
            return me1;
        }
        break MISSING_BLOCK_LABEL_65;
        me1;
        set;
        JVM INSTR monitorexit ;
        throw me1;
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        String s;
        s = me1.b();
        if (!a.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_175;
        }
        queue = (Queue)a.get(s);
        Object obj;
        obj = queue;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        obj = new LinkedList();
        ((Queue) (obj)).add(me1);
        a.put(s, obj);
        if (mq.a)
        {
            mq.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] {
                s
            });
        }
_L1:
        map;
        JVM INSTR monitorexit ;
        return me1;
        me1;
        map;
        JVM INSTR monitorexit ;
        throw me1;
        a.put(s, null);
        c.add(me1);
          goto _L1
    }

    public void a()
    {
        b();
        j = new lt(c, e, f, h);
        j.start();
        for (int k = 0; k < i.length; k++)
        {
            lz lz1 = new lz(e, g, f, h);
            i[k] = lz1;
            lz1.start();
        }

    }

    public void b()
    {
        if (j != null)
        {
            lt lt1 = j;
            lt1.a = true;
            lt1.interrupt();
        }
        for (int k = 0; k < i.length; k++)
        {
            if (i[k] != null)
            {
                lz lz1 = i[k];
                lz1.a = true;
                lz1.interrupt();
            }
        }

    }

    public int c()
    {
        return d.incrementAndGet();
    }

    public lr d()
    {
        return f;
    }
}
