// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.SystemClock;

// Referenced classes of package android.support.v7:
//            vn

public final class vo
    implements vn
{

    private static vo a;

    public vo()
    {
    }

    public static vn d()
    {
        android/support/v7/vo;
        JVM INSTR monitorenter ;
        vo vo1;
        if (a == null)
        {
            a = new vo();
        }
        vo1 = a;
        android/support/v7/vo;
        JVM INSTR monitorexit ;
        return vo1;
        Exception exception;
        exception;
        throw exception;
    }

    public long a()
    {
        return System.currentTimeMillis();
    }

    public long b()
    {
        return SystemClock.elapsedRealtime();
    }

    public long c()
    {
        return System.nanoTime();
    }
}
