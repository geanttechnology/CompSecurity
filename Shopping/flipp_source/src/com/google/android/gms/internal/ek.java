// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;

// Referenced classes of package com.google.android.gms.internal:
//            ej

final class ek
    implements Runnable
{

    final Context a;

    ek(Context context)
    {
        a = context;
        super();
    }

    public final void run()
    {
        synchronized (ej.d())
        {
            ej.b(ej.c(a));
            ej.d().notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
