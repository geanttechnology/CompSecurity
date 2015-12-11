// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;

public final class cmk
{

    private long a;
    private final atl b = new atl(10000);

    public cmk()
    {
        a = -1L;
    }

    public final int a()
    {
        this;
        JVM INSTR monitorenter ;
        float f = b.a(0.5F);
        int i = (int)f;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(long l, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (l <= 30000L) goto _L2; else goto _L1
_L1:
        float f;
        atl atl1;
        long l2;
        l2 = SystemClock.elapsedRealtime();
        f = ((float)l * 1000F) / (float)l1;
        atl1 = b;
        if (a != -1L) goto _L4; else goto _L3
_L3:
        int i = 10000;
_L6:
        atl1.a(i, f);
        a = l2;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        l = a;
        i = (int)(l2 - l);
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }
}
