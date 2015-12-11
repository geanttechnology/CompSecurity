// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzu, zzp

private final class zzaNH
    implements ncaughtExceptionHandler
{

    private final String zzaNH;
    final zzu zzaNI;

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        zzaNI.zzyd().zzzK().zzj(zzaNH, throwable);
        this;
        JVM INSTR monitorexit ;
        return;
        thread;
        throw thread;
    }

    public _cls9(zzu zzu1, String s)
    {
        zzaNI = zzu1;
        super();
        zzx.zzw(s);
        zzaNH = s;
    }
}
