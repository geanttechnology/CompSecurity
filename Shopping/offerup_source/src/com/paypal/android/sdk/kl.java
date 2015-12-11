// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package com.paypal.android.sdk:
//            lk, ko

public class kl extends lk
{

    private static kl b;
    private boolean c;
    private kl d;
    private long e;

    public kl()
    {
    }

    private static void a(kl kl1, long l, boolean flag)
    {
        com/paypal/android/sdk/kl;
        JVM INSTR monitorenter ;
        long l1;
        if (b == null)
        {
            b = new kl();
            (new ko()).start();
        }
        l1 = System.nanoTime();
        if (l == 0L || !flag) goto _L2; else goto _L1
_L1:
        kl1.e = Math.min(l, kl1.d_() - l1) + l1;
_L3:
        l = kl1.e;
        for (kl kl2 = b; kl2.d != null && l - l1 >= kl2.d.e - l1; kl2 = kl2.d)
        {
            break MISSING_BLOCK_LABEL_177;
        }

        kl1.d = kl2.d;
        kl2.d = kl1;
        if (kl2 == b)
        {
            com/paypal/android/sdk/kl.notify();
        }
        com/paypal/android/sdk/kl;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (l == 0L)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        kl1.e = l1 + l;
          goto _L3
        kl1;
        throw kl1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        kl1.e = kl1.d_();
          goto _L3
        throw new AssertionError();
    }

    private static boolean a(kl kl1)
    {
        com/paypal/android/sdk/kl;
        JVM INSTR monitorenter ;
        kl kl2 = b;
_L8:
        if (kl2 == null) goto _L2; else goto _L1
_L1:
        if (kl2.d != kl1) goto _L4; else goto _L3
_L3:
        kl2.d = kl1.d;
        kl1.d = null;
        boolean flag = false;
_L6:
        com/paypal/android/sdk/kl;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        kl2 = kl2.d;
        continue; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        kl1;
        throw kl1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static kl a_()
    {
        return h();
    }

    private static kl h()
    {
        Object obj = null;
        com/paypal/android/sdk/kl;
        JVM INSTR monitorenter ;
        kl kl1 = b.d;
        if (kl1 != null) goto _L2; else goto _L1
_L1:
        com/paypal/android/sdk/kl.wait();
_L4:
        com/paypal/android/sdk/kl;
        JVM INSTR monitorexit ;
        return ((kl) (obj));
_L2:
        long l;
        l = System.nanoTime();
        l = kl1.e - l;
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        long l1 = l / 0xf4240L;
        com/paypal/android/sdk/kl.wait(l1, (int)(l - 0xf4240L * l1));
        continue; /* Loop/switch isn't completed */
        obj;
        throw obj;
        b.d = kl1.d;
        kl1.d = null;
        obj = kl1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected IOException a(IOException ioexception)
    {
        InterruptedIOException interruptedioexception = new InterruptedIOException("timeout");
        if (ioexception != null)
        {
            interruptedioexception.initCause(ioexception);
        }
        return interruptedioexception;
    }

    protected void a()
    {
    }

    final void a(boolean flag)
    {
        if (d() && flag)
        {
            throw a(((IOException) (null)));
        } else
        {
            return;
        }
    }

    final IOException b(IOException ioexception)
    {
        if (!d())
        {
            return ioexception;
        } else
        {
            return a(ioexception);
        }
    }

    public final void c()
    {
        if (c)
        {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l = b_();
        boolean flag = c_();
        if (l == 0L && !flag)
        {
            return;
        } else
        {
            c = true;
            a(this, l, flag);
            return;
        }
    }

    public final boolean d()
    {
        if (!c)
        {
            return false;
        } else
        {
            c = false;
            return a(this);
        }
    }
}
