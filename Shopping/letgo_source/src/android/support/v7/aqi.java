// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            aqh

final class aqi
{

    static aqh a;
    static long b;

    private aqi()
    {
    }

    static aqh a()
    {
        android/support/v7/aqi;
        JVM INSTR monitorenter ;
        aqh aqh1;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        aqh1 = a;
        a = aqh1.f;
        aqh1.f = null;
        b -= 2048L;
        android/support/v7/aqi;
        JVM INSTR monitorexit ;
        return aqh1;
        android/support/v7/aqi;
        JVM INSTR monitorexit ;
        return new aqh();
        Exception exception;
        exception;
        android/support/v7/aqi;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(aqh aqh1)
    {
        if (aqh1.f != null || aqh1.g != null)
        {
            throw new IllegalArgumentException();
        }
        if (aqh1.d)
        {
            return;
        }
        android/support/v7/aqi;
        JVM INSTR monitorenter ;
        if (b + 2048L <= 0x10000L)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        android/support/v7/aqi;
        JVM INSTR monitorexit ;
        return;
        aqh1;
        android/support/v7/aqi;
        JVM INSTR monitorexit ;
        throw aqh1;
        b += 2048L;
        aqh1.f = a;
        aqh1.c = 0;
        aqh1.b = 0;
        a = aqh1;
        android/support/v7/aqi;
        JVM INSTR monitorexit ;
    }
}
