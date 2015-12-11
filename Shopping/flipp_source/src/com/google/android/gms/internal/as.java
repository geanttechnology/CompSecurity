// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.a.d;

// Referenced classes of package com.google.android.gms.internal:
//            ar, aq, cu, x, 
//            an, bq, et

final class as
    implements Runnable
{

    final aq a;
    final ar b;

    as(ar ar1, aq aq1)
    {
        b = ar1;
        a = aq1;
        super();
    }

    public final void run()
    {
label0:
        {
            synchronized (b.e)
            {
                if (b.h == -2)
                {
                    break label0;
                }
            }
            return;
        }
        b.g = b.a();
        if (b.g != null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        b.a(4);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        aq aq1;
        ar ar1;
        aq1 = a;
        ar1 = b;
        synchronized (aq1.a)
        {
            aq1.b = ar1;
        }
        obj1 = b;
        obj2 = a;
        if (((ar) (obj1)).f.d >= 0x3e8fa0) goto _L2; else goto _L1
_L1:
        if (!((ar) (obj1)).c.e) goto _L4; else goto _L3
_L3:
        ((ar) (obj1)).g.a(d.a(((ar) (obj1)).d), ((ar) (obj1)).b, ((ar) (obj1)).a.f, ((bt) (obj2)));
_L5:
        obj;
        JVM INSTR monitorexit ;
        return;
        obj2;
        obj1;
        JVM INSTR monitorexit ;
        throw obj2;
_L4:
        ((ar) (obj1)).g.a(d.a(((ar) (obj1)).d), ((ar) (obj1)).c, ((ar) (obj1)).b, ((ar) (obj1)).a.f, ((bt) (obj2)));
          goto _L5
        obj2;
        et.a("Could not request ad from mediation adapter.", ((Throwable) (obj2)));
        ((ar) (obj1)).a(5);
          goto _L5
_L2:
label1:
        {
            if (!((ar) (obj1)).c.e)
            {
                break label1;
            }
            ((ar) (obj1)).g.a(d.a(((ar) (obj1)).d), ((ar) (obj1)).b, ((ar) (obj1)).a.f, ((ar) (obj1)).a.a, ((bt) (obj2)));
        }
          goto _L5
        ((ar) (obj1)).g.a(d.a(((ar) (obj1)).d), ((ar) (obj1)).c, ((ar) (obj1)).b, ((ar) (obj1)).a.f, ((ar) (obj1)).a.a, ((bt) (obj2)));
          goto _L5
    }
}
