// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.LinkedHashSet;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            gx

public final class hk
{

    private final Set a = new LinkedHashSet();

    public hk()
    {
    }

    public final void a(gx gx)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(gx);
        this;
        JVM INSTR monitorexit ;
        return;
        gx;
        throw gx;
    }

    public final void b(gx gx)
    {
        this;
        JVM INSTR monitorenter ;
        a.remove(gx);
        this;
        JVM INSTR monitorexit ;
        return;
        gx;
        throw gx;
    }

    public final boolean c(gx gx)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a.contains(gx);
        this;
        JVM INSTR monitorexit ;
        return flag;
        gx;
        throw gx;
    }
}
