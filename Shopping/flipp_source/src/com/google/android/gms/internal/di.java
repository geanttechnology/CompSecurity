// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.a;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;

// Referenced classes of package com.google.android.gms.internal:
//            dg, dj, bz, cu, 
//            cb, df, ee, eg, 
//            et, do

public final class di extends dg
    implements c, d
{

    private final df a;
    private final dj b;
    private final Object c = new Object();

    public di(Context context, bz bz1, df df1)
    {
        super(bz1, df1);
        a = df1;
        b = new dj(context, this, this, bz1.k.d);
        b.d();
    }

    public final void a(a a1)
    {
        a.a(new cb(0));
    }

    public final void a_()
    {
        com.google.android.gms.internal.eg.a(super.e);
    }

    public final void b()
    {
        com.google.android.gms.internal.et.a("Disconnected from remote ad request service.");
    }

    public final void c()
    {
        synchronized (c)
        {
            if (b.e() || b.f())
            {
                b.g();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final do d()
    {
        obj;
        JVM INSTR monitorenter ;
        do do1;
        synchronized (c)
        {
            do1 = b.c();
        }
        return do1;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        obj;
        JVM INSTR monitorexit ;
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
