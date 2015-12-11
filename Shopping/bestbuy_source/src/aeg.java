// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;

public final class aeg
    implements aef
{

    private static aeg a;

    public aeg()
    {
    }

    public static aef c()
    {
        aeg;
        JVM INSTR monitorenter ;
        aeg aeg1;
        if (a == null)
        {
            a = new aeg();
        }
        aeg1 = a;
        aeg;
        JVM INSTR monitorexit ;
        return aeg1;
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
}
