// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.d:
//            ii

public final class ij
    implements ii
{

    private static ij a;

    public ij()
    {
    }

    public static ii d()
    {
        com/google/android/gms/d/ij;
        JVM INSTR monitorenter ;
        ij ij1;
        if (a == null)
        {
            a = new ij();
        }
        ij1 = a;
        com/google/android/gms/d/ij;
        JVM INSTR monitorexit ;
        return ij1;
        Exception exception;
        exception;
        throw exception;
    }

    public final long a()
    {
        return System.currentTimeMillis();
    }

    public final long b()
    {
        return SystemClock.elapsedRealtime();
    }

    public final long c()
    {
        return System.nanoTime();
    }
}
