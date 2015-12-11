// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.Context;
import android.support.v7.ahj;
import android.util.Log;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.kahuna.sdk:
//            m, t, p, h, 
//            w, r, a, c, 
//            d

class nit>
    implements Runnable
{

    final Context a;
    final m b;

    public void run()
    {
        Object obj;
        Object obj1;
        t.a(m.j(), m.a(b));
        if (!m.b(b))
        {
            m.c(b);
        }
        p.a(m.a(b));
        h.a();
        w.a(a);
        a a1;
        try
        {
            ahj.a(m.j());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (m.a)
            {
                Log.w("Kahuna", "Caught error when attepmting to initialize location services. If you are NOT using location services please ignore this error: ");
                Log.w("Kahuna", ((Throwable) (obj)));
            }
            continue; /* Loop/switch isn't completed */
        }
_L6:
        a1 = r.a(m.a(b), false);
        obj1 = m.d(b);
        obj1;
        JVM INSTR monitorenter ;
        m.a(b, a1.a());
        if (m.e(b).isEmpty()) goto _L2; else goto _L1
_L1:
        obj = (c)m.e(b).get(m.e(b).size() - 1);
_L3:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        if (((c) (obj)).k() <= 0L)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        m.f(b).set(((c) (obj)).k() + 1L);
_L4:
        obj1;
        JVM INSTR monitorexit ;
        d.a(m.e(b));
        m.a(b, a1.b());
        m.a(b, a1.c());
        return;
_L2:
        obj = null;
          goto _L3
        m.f(b).set(r.m(m.a(b)));
          goto _L4
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    text(m m1, Context context)
    {
        b = m1;
        a = context;
        super();
    }
}
