// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.sighting;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.c.h;
import com.gimbal.internal.proximity.core.sighting.b.a;
import com.gimbal.internal.proximity.core.sighting.b.d;
import com.gimbal.internal.proximity.e;
import com.gimbal.internal.proximity.impl.TransmitterInternal;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.gimbal.internal.proximity.core.sighting:
//            g, Sighting, f, i

public class b
    implements g
{
    public final class a extends com.gimbal.internal.persistance.c
    {

        com.gimbal.internal.b.a.a a;
        private b b;

        public final void a()
        {
            b.();
        }

        public final void b()
        {
            b.b();
        }

        public a(com.gimbal.internal.b.a.a a1)
        {
            b = b.this;
            super();
            a = a1;
        }
    }


    private static com.gimbal.a.a c = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/core/sighting/b.getName());
    public a a;
    public h b;
    private final d d;
    private final i e;
    private AtomicBoolean f;

    public b(com.gimbal.internal.proximity.core.g.d d1, Map map)
    {
        d = new com.gimbal.internal.proximity.core.sighting.b.a(this, new com.gimbal.internal.proximity.core.g.a(), d1, map);
        e = com.gimbal.internal.proximity.core.e.a.a().b;
        a = new a(com.gimbal.internal.proximity.e.a().f);
        f = new AtomicBoolean(false);
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != null && a.c() > 0 && !f.get() && b.e())
        {
            b.d();
            f.set(true);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(h h1)
    {
        if (b == null)
        {
            b = h1;
            return;
        } else
        {
            b();
            b = h1;
            a();
            return;
        }
    }

    public final void a(Sighting sighting)
    {
        this;
        JVM INSTR monitorenter ;
        d.a(sighting);
        this;
        JVM INSTR monitorexit ;
        return;
        sighting;
        throw sighting;
    }

    public final void a(Sighting sighting, TransmitterInternal transmitterinternal)
    {
        boolean flag = true;
        int k = 1;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Object obj1;
        sighting.getPayload();
        transmitterinternal.getIdentifier();
        transmitterinternal.getName();
        obj = e;
        obj1 = transmitterinternal.getIdentifier();
        int j;
        if (0L > 0L)
        {
            j = 1;
        } else
        {
            j = 0;
        }
          goto _L1
_L6:
        if (k == 0) goto _L3; else goto _L2
_L2:
        if (transmitterinternal.getTemperature() == -70)
        {
            transmitterinternal.setTemperature(Integer.valueOf(0x7fffffff));
        }
        obj = a;
        obj1 = ((a) (obj)).a;
        if (((com.gimbal.internal.b.a.a) (obj1)).b && ((com.gimbal.internal.b.a.a) (obj1)).c)
        {
            obj1 = com.gimbal.internal.b.a.a.a;
            String s = transmitterinternal.getName();
            j = sighting.getRssi();
            ((com.gimbal.a.b) (obj1)).a.a("Sighted '{}' with RSSI [{}].", s, Integer.valueOf(j));
        }
        obj = ((a) (obj)).iterator();
_L5:
        if (!((Iterator) (obj)).hasNext()) goto _L3; else goto _L4
_L4:
        obj1 = (f)((Iterator) (obj)).next();
        try
        {
            ((f) (obj1)).a(sighting, transmitterinternal);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
          goto _L5
        sighting;
        throw sighting;
_L7:
        Long long1 = (Long)((i) (obj)).a.get(obj1);
        j = ((flag) ? 1 : 0);
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        if (System.currentTimeMillis() - long1.longValue() >= 0L)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        k = j;
        if (j == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((i) (obj)).a.put(obj1, Long.valueOf(System.currentTimeMillis()));
        k = j;
        break; /* Loop/switch isn't completed */
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L1:
        if (j != 0) goto _L7; else goto _L6
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != null && f.get())
        {
            b.c();
            f.set(false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
