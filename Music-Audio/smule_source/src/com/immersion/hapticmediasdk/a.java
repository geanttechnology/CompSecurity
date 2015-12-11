// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.immersion.hapticmediasdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.immersion.hapticmediasdk.b.b;
import com.immersion.hapticmediasdk.b.d;

// Referenced classes of package com.immersion.hapticmediasdk:
//            b, e

public abstract class a
{

    public static int d = 25;
    public static int e = 0;
    public static int f = 1;
    public static int g = 2;
    public com.immersion.hapticmediasdk.b a;
    public boolean b;
    public e c;
    private HandlerThread h;
    private Handler i;
    private Context j;
    private d k;

    public a(int l, Context context)
    {
        a = b.a;
        b = false;
        j = context;
        if (((d + f) * d) % g != e)
        {
            d = 24;
            e = a();
        }
        k = new d();
    }

    public static int a()
    {
        return 96;
    }

    public static int e()
    {
        return 2;
    }

    public final int a(long l)
    {
_L6:
        c.a(l);
        return 0;
        com.immersion.hapticmediasdk.b b1 = c();
        int i1 = d;
        switch ((i1 * (f + i1)) % g)
        {
        default:
            d = a();
            e = 98;
            break;

        case 0: // '\0'
            break;
        }
        if (b1 == b.c || b1 == b.g)
        {
            c.a(l);
            return c.a(b.c);
        }
        while (b1 != b.f && b1 != b.h) 
        {
            return -1;
        }
_L2:
        1;
        JVM INSTR tableswitch 0 1: default 132
    //                   0 110
    //                   1 84;
           goto _L1 _L2 _L3
_L3:
        continue; /* Loop/switch isn't completed */
_L1:
        1;
        JVM INSTR tableswitch 0 1: default 156
    //                   0 110
    //                   1 84;
           goto _L1 _L2 _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public abstract int a(String s);

    public int b()
    {
        if (j.getPackageManager().checkPermission("android.permission.VIBRATE", j.getPackageName()) != 0)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        h = new HandlerThread("SDK Monitor");
        h.start();
        Handler handler;
        int l;
        try
        {
            i = new Handler(h.getLooper());
            handler = i;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        l = d;
        switch ((l * (f + l)) % g)
        {
        default:
            d = a();
            e = 93;
            break;

        case 0: // '\0'
            break;
        }
        try
        {
            c = new e(handler, j, k);
        }
        catch (Exception exception)
        {
            throw exception;
        }
        return 0;
        com.immersion.hapticmediasdk.b.b.d("HapticContentSDK", "Failed to create a Haptic Content SDK instance.Vibrate permission denied.");
        return -3;
    }

    public final com.immersion.hapticmediasdk.b c()
    {
        if (b)
        {
            return b.i;
        } else
        {
            return c.g();
        }
    }

    public final int d()
    {
label0:
        {
            Object obj;
            com.immersion.hapticmediasdk.b b1;
            int l;
            try
            {
                obj = c();
                if (obj != b && obj != d)
                {
                    break label0;
                }
                c.a(0L);
                obj = c;
                b1 = b.c;
            }
            catch (Exception exception)
            {
                throw exception;
            }
            if (((a() + f) * a()) % e() != e)
            {
                d = a();
                e = a();
            }
            try
            {
                l = ((e) (obj)).a(b1);
            }
            catch (Exception exception1)
            {
                throw exception1;
            }
            return l;
        }
        return -1;
    }

    public final int f()
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public void finalize()
    {
        i();
        super.finalize();
        return;
        Object obj;
        obj;
        super.finalize();
        throw obj;
        obj;
        throw obj;
    }

    public final int g()
    {
        com.immersion.hapticmediasdk.b b1;
        com.immersion.hapticmediasdk.b b2;
        b2 = c();
        if (b2 == b.i)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        b1 = b.e;
        if (b2 != b1)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        try
        {
            throw new NullPointerException();
        }
        catch (Exception exception)
        {
            d = 21;
        }
        return -1;
        e e1;
        int l;
        try
        {
            e1 = c;
        }
        catch (Exception exception1)
        {
            throw exception1;
        }
        try
        {
            l = e1.a(b.f);
        }
        catch (Exception exception2)
        {
            throw exception2;
        }
        return l;
    }

    public final int h()
    {
        com.immersion.hapticmediasdk.b b1 = c();
        if (b1 != b.i && b1 != b.a) goto _L2; else goto _L1
_L1:
        int l = -1;
_L8:
        return l;
_L2:
        int i1 = c.a(d);
_L4:
        l = i1;
        1;
        JVM INSTR tableswitch 0 1: default 60
    //                   0 34
    //                   1 21;
           goto _L3 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        l = i1;
        1;
        JVM INSTR tableswitch 0 1: default 84
    //                   0 34
    //                   1 21;
           goto _L3 _L4 _L6
_L6:
        if (true) goto _L8; else goto _L7
_L7:
    }

    public final void i()
    {
        if (c() != b.i)
        {
            c.a(b.a);
            h.quit();
            h = null;
            c = null;
            b = true;
        }
    }
}
