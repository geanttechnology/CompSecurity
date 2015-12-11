// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.mrz.impl.smartEngines.swig.MrzEngine;
import com.jumio.mrz.impl.smartEngines.swig.MrzEngineSessionHelpers;
import java.util.concurrent.ExecutorService;

// Referenced classes of package jumiomobile:
//            ix, jd, mt, l, 
//            n, oo, ja, ii, 
//            ht, iy

class iz
    implements Runnable
{

    final ix a;

    private iz(ix ix1)
    {
        a = ix1;
        super();
    }

    iz(ix ix1, iy iy)
    {
        this(ix1);
    }

    public void run()
    {
        ix.a(a).a();
        int i;
        int j;
        if (ix.f(a) != null)
        {
            try
            {
                ix.f(a).InitializeSession(ix.a(a), ix.b(a), ix.h(a));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                a.d.a(ht.l);
                ix.g(a).shutdownNow();
            }
        }
        ix.a(a, ix.i(a).getROIXOffset());
        i = a.b.b.a - ix.c(a) * 2;
        j = (int)((double)i / ix.b(a).get_optimal_aspect_ratio());
        ix.b(a, ix.i(a).a(j));
        if (ix.d(a) + j > a.b.b.b)
        {
            ix.b(a, a.b.b.b - j);
        }
        synchronized (a)
        {
            ix.a(a, false);
        }
        if (oo.a() && a.g != null)
        {
            a.d.a(new ja(this, i, j));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
