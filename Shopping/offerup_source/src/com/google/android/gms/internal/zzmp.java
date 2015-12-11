// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            zzmn

public final class zzmp
    implements zzmn
{

    private static zzmp zzaik;

    public zzmp()
    {
    }

    public static zzmn zzqt()
    {
        com/google/android/gms/internal/zzmp;
        JVM INSTR monitorenter ;
        zzmp zzmp1;
        if (zzaik == null)
        {
            zzaik = new zzmp();
        }
        zzmp1 = zzaik;
        com/google/android/gms/internal/zzmp;
        JVM INSTR monitorexit ;
        return zzmp1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long currentTimeMillis()
    {
        return System.currentTimeMillis();
    }

    public final long elapsedRealtime()
    {
        return SystemClock.elapsedRealtime();
    }

    public final long nanoTime()
    {
        return System.nanoTime();
    }
}
