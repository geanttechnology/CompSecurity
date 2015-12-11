// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            lf

final class lg
{

    private static lf a;
    private static long b;

    private lg()
    {
    }

    static lf a()
    {
        com/paypal/android/sdk/lg;
        JVM INSTR monitorenter ;
        lf lf1;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        lf1 = a;
        a = lf1.f;
        lf1.f = null;
        b -= 2048L;
        com/paypal/android/sdk/lg;
        JVM INSTR monitorexit ;
        return lf1;
        com/paypal/android/sdk/lg;
        JVM INSTR monitorexit ;
        return new lf();
        Exception exception;
        exception;
        com/paypal/android/sdk/lg;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(lf lf1)
    {
        if (lf1.f != null || lf1.g != null)
        {
            throw new IllegalArgumentException();
        }
        if (lf1.d)
        {
            return;
        }
        com/paypal/android/sdk/lg;
        JVM INSTR monitorenter ;
        if (b + 2048L <= 0x10000L)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        com/paypal/android/sdk/lg;
        JVM INSTR monitorexit ;
        return;
        lf1;
        com/paypal/android/sdk/lg;
        JVM INSTR monitorexit ;
        throw lf1;
        b += 2048L;
        lf1.f = a;
        lf1.c = 0;
        lf1.b = 0;
        a = lf1;
        com/paypal/android/sdk/lg;
        JVM INSTR monitorexit ;
    }
}
