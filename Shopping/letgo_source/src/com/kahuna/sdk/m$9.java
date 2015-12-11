// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.kahuna.sdk:
//            m, r

class nit>
    implements Runnable
{

    final m a;

    public void run()
    {
        Object obj = m.t();
        obj;
        JVM INSTR monitorenter ;
        int i;
        i = m.g(a).decrementAndGet();
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Called stop, remaining activities in foreground is: ").append(i).toString());
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (m.k(a) != null)
        {
            m.k(a).cancel();
            m.a(a, null);
        }
        m.a(a, new Timer());
        m.k(a).schedule(new TimerTask() {

            final m._cls9 a;

            public void run()
            {
                Object obj2 = m.t();
                obj2;
                JVM INSTR monitorenter ;
                int j;
                if (m.k(a.a) != null)
                {
                    m.k(a.a).cancel();
                    m.a(a.a, null);
                }
                j = m.g(a.a).get();
                if (j <= 0)
                {
                    break MISSING_BLOCK_LABEL_67;
                }
                obj2;
                JVM INSTR monitorexit ;
                return;
                synchronized (m.n(a.a))
                {
                    if (m.o(a.a) != null)
                    {
                        m.o(a.a).cancel();
                        m.a(a.a, null);
                    }
                }
                m.b(a.a, "k_app_bg");
_L2:
                obj2;
                JVM INSTR monitorexit ;
                return;
                obj3;
                obj2;
                JVM INSTR monitorexit ;
                throw obj3;
                exception3;
                obj3;
                JVM INSTR monitorexit ;
                throw exception3;
                Exception exception2;
                exception2;
                if (!m.a) goto _L2; else goto _L1
_L1:
                Log.d("Kahuna", (new StringBuilder()).append("Handled exception in KahunaCommon.stop() timer: ").append(exception2).toString());
                  goto _L2
            }

            
            {
                a = m._cls9.this;
                super();
            }
        }, 5000L);
        synchronized (m.d(a))
        {
            r.a(m.e(a), m.a(a));
        }
        r.b(m.f(a).get(), m.a(a));
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
