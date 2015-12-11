// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.sighting.Sighting;
import com.gimbal.internal.proximity.core.sighting.c.b;
import com.gimbal.internal.proximity.core.sighting.f;
import com.gimbal.internal.proximity.impl.TransmitterInternal;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class a
    implements f
{

    private static final com.gimbal.a.a b = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/a.getName());
    public AtomicInteger a;
    private AtomicBoolean c;
    private List d;
    private com.gimbal.internal.proximity.core.sighting.b e;
    private b f;
    private c g;

    public a(com.gimbal.internal.proximity.core.sighting.b b1, c c1, com.gimbal.internal.persistance.a a1)
    {
        d = new ArrayList();
        g = c1;
        c = new AtomicBoolean(false);
        e = b1;
        f = new b(g, a1);
        a = new AtomicInteger(0);
    }

    private boolean b()
    {
        return a.get() > 0;
    }

    public final void a()
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        b();
        boolean flag;
        if (!d.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!c.get())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        if (!b()) goto _L2; else goto _L1
_L1:
        if (!d.isEmpty() && !c.get())
        {
            e.a.a(this);
            c.set(true);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (c.get())
        {
            e.a.b(this);
            c.set(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(Sighting sighting, TransmitterInternal transmitterinternal)
    {
        b b1 = f;
        int i = sighting.getRssi();
        String s = transmitterinternal.getIdentifier();
        com.gimbal.internal.proximity.core.sighting.c.a a1 = (com.gimbal.internal.proximity.core.sighting.c.a)b1.c.get(s);
        Object obj = a1;
        if (a1 == null)
        {
            obj = new com.gimbal.internal.proximity.core.sighting.c.a(b1.b, b1.a);
            b1.c.put(s, obj);
        }
        obj = ((com.gimbal.internal.proximity.core.sighting.c.a) (obj)).a(i);
        if (obj == null)
        {
            sighting = null;
        } else
        {
            sighting.setRssi(((Integer) (obj)).intValue());
        }
        if (sighting != null)
        {
            obj = d.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                WeakReference weakreference = (WeakReference)((Iterator) (obj)).next();
                if (weakreference.get() != null)
                {
                    ((f)weakreference.get()).a(sighting, transmitterinternal);
                }
            } while (true);
        }
    }

    public final void a(f f1)
    {
        this;
        JVM INSTR monitorenter ;
        d.add(new WeakReference(f1));
        a();
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        throw f1;
    }

    public final void b(f f1)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = d.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            WeakReference weakreference = (WeakReference)iterator.next();
            if (f1 == weakreference.get())
            {
                d.remove(weakreference);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_58;
        f1;
        throw f1;
        a();
        this;
        JVM INSTR monitorexit ;
    }

}
