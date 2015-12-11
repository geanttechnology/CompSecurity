// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            bh, cj, bi

public class bg
{

    private final List a = new ArrayList();

    public bg()
    {
    }

    public final void a()
    {
        List list = a;
        list;
        JVM INSTR monitorenter ;
        bh bh1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); a.remove(bh1))
        {
            bh1 = (bh)iterator.next();
        }

        break MISSING_BLOCK_LABEL_55;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public final void a(bi bi1)
    {
label0:
        {
            synchronized (a)
            {
                Iterator iterator = a.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                } while (((bh)iterator.next()).a != bi1);
                (new StringBuilder("Ignoring attempt to re-register listener ")).append(bi1);
            }
            return;
        }
        a.add(new bh(bi1));
        list;
        JVM INSTR monitorexit ;
        return;
        bi1;
        list;
        JVM INSTR monitorexit ;
        throw bi1;
    }

    public final void a(cj cj1)
    {
        (new StringBuilder("dispatching ")).append(cj1.n());
        if (cj1.o() >= 0L) goto _L2; else goto _L1
_L1:
        (new StringBuilder("discarding ")).append(cj1.n());
_L4:
        return;
_L2:
        ArrayList arraylist = new ArrayList();
        List list = a;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator1 = a.iterator(); iterator1.hasNext(); arraylist.add(0, (bh)iterator1.next())) { }
        break MISSING_BLOCK_LABEL_105;
        cj1;
        list;
        JVM INSTR monitorexit ;
        throw cj1;
        list;
        JVM INSTR monitorexit ;
        Iterator iterator = arraylist.iterator();
        while (iterator.hasNext()) 
        {
            ((bh)iterator.next()).a.a(cj1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        com/paypal/android/sdk/bg.getSimpleName();
    }
}
