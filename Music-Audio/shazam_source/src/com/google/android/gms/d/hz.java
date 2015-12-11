// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.google.android.gms.d:
//            cy, fa, hx, lf, 
//            ba, z, dz, iu

public final class hz
{

    final Map a;
    final Set b;
    final PriorityBlockingQueue c;
    List d;
    private AtomicInteger e;
    private final PriorityBlockingQueue f;
    private final z g;
    private final dz h;
    private final iu i;
    private fa j[];
    private ba k;

    private hz(z z, dz dz)
    {
        this(z, dz, ((iu) (new cy(new Handler(Looper.getMainLooper())))));
    }

    public hz(z z, dz dz, byte byte0)
    {
        this(z, dz);
    }

    private hz(z z, dz dz, iu iu)
    {
        e = new AtomicInteger();
        a = new HashMap();
        b = new HashSet();
        c = new PriorityBlockingQueue();
        f = new PriorityBlockingQueue();
        d = new ArrayList();
        g = z;
        h = dz;
        j = new fa[4];
        i = iu;
    }

    public final hx a(hx hx1)
    {
        hx1.h = this;
        synchronized (b)
        {
            b.add(hx1);
        }
        hx1.g = Integer.valueOf(e.incrementAndGet());
        hx1.a("add-to-queue");
        if (!hx1.i)
        {
            f.add(hx1);
            return hx1;
        }
        break MISSING_BLOCK_LABEL_68;
        hx1;
        set;
        JVM INSTR monitorexit ;
        throw hx1;
        Map map = a;
        map;
        JVM INSTR monitorenter ;
        Queue queue;
        String s;
        s = hx1.d;
        if (!a.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        queue = (Queue)a.get(s);
        Object obj;
        obj = queue;
        if (queue != null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = new LinkedList();
        ((Queue) (obj)).add(hx1);
        a.put(s, obj);
        if (lf.b)
        {
            lf.a("Request for cacheKey=%s is in flight, putting on hold.", new Object[] {
                s
            });
        }
_L1:
        map;
        JVM INSTR monitorexit ;
        return hx1;
        hx1;
        map;
        JVM INSTR monitorexit ;
        throw hx1;
        a.put(s, null);
        c.add(hx1);
          goto _L1
    }

    public final void a()
    {
        boolean flag = false;
        if (k != null)
        {
            ba ba1 = k;
            ba1.a = true;
            ba1.interrupt();
        }
        for (int l = 0; l < j.length; l++)
        {
            if (j[l] != null)
            {
                fa fa1 = j[l];
                fa1.a = true;
                fa1.interrupt();
            }
        }

        k = new ba(c, f, g, i);
        k.start();
        for (int i1 = ((flag) ? 1 : 0); i1 < j.length; i1++)
        {
            fa fa2 = new fa(f, h, g, i);
            j[i1] = fa2;
            fa2.start();
        }

    }
}
