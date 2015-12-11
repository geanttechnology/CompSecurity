// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            aq, ao

public class ap
{

    private List a;
    private List b;

    private ap()
    {
        a = Collections.synchronizedList(new ArrayList());
        b = Collections.synchronizedList(new ArrayList());
    }

    ap(byte byte0)
    {
        this();
    }

    public static ap a()
    {
        return aq.a();
    }

    private void b()
    {
        if (b.isEmpty())
        {
            break MISSING_BLOCK_LABEL_81;
        }
        this;
        JVM INSTR monitorenter ;
        if (!b.isEmpty())
        {
            ao ao1 = (ao)b.get(0);
            b.remove(0);
            a.add(ao1);
            (new Thread(ao1)).start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(ao ao1)
    {
        b.add(ao1);
        if (a.size() < 3)
        {
            b();
        }
    }

    public final void b(ao ao1)
    {
        a.remove(ao1);
        b();
    }

    static 
    {
        com/paypal/android/sdk/ap.getSimpleName();
    }
}
