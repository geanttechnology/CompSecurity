// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk.a;

import android.os.Handler;
import android.os.SystemClock;
import com.immersion.hapticmediasdk.d;

// Referenced classes of package com.immersion.hapticmediasdk.a:
//            f, c

public final class a
    implements Runnable
{

    public static int b = 92;
    public static int c = 0;
    public static int d = 1;
    public static int e = 2;
    public final f a;

    public final void run()
    {
        c c1;
        int i;
        long l;
        if (!a.d() || f.c(a) == null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        c1 = f.c(a);
        f f2 = a;
        if (((f.g + f.i) * f.g) % f.j != f.h)
        {
            f.g = 51;
            f.h = 63;
        }
        i = (int)f2.e.a();
        l = a.c();
        Object obj = c1.b;
        obj;
        JVM INSTR monitorenter ;
        long l1 = SystemClock.uptimeMillis();
        i = (int)((l1 - l) + (long)i);
        int k = i - (c1.d + (int)(l1 - c1.e));
        if (50 < Math.abs(k))
        {
            c1.d = k + c1.d;
            c1.c = c1.d;
            c1.a.sendMessage(c1.a.obtainMessage(1, i, 0x80000000));
        }
        obj;
        JVM INSTR monitorexit ;
        f f1 = a;
        int j = b;
        switch ((j * (d + j)) % e)
        {
        default:
            b = 6;
            c = 99;
            // fall through

        case 0: // '\0'
            f.c(f1).c().removeCallbacks(this);
            break;
        }
        f.c(a).c().postDelayed(this, 1000L);
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (f f1)
    {
        if (((b + d) * b) % e != c)
        {
            b = 15;
            c = 7;
        }
        try
        {
            a = f1;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
        try
        {
            super();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (f f1)
        {
            throw f1;
        }
    }
}
