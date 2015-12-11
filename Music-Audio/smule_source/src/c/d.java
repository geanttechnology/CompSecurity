// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.immersion.hapticmediasdk.a.a;
import com.immersion.hapticmediasdk.a.c;

public class d extends Handler
{

    public static int b = 16;
    public static int c = 0;
    public static int d = 1;
    public final c a;

    private d(c c1)
    {
        throw new Runtime("d2j fail translate: java.lang.IndexOutOfBoundsException: fromIndex < 0: -1\n\tat java.util.BitSet.nextSetBit(BitSet.java:701)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.makeSureAllElementAreAssigned(FillArrayTransformer.java:505)\n\tat com.googlecode.dex2jar.ir.ts.array.FillArrayTransformer.transformReportChanged(FillArrayTransformer.java:123)\n\tat com.googlecode.dex2jar.ir.ts.StatedTransformer.transform(StatedTransformer.java:10)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:149)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
    }

    public d(c c1, com.immersion.hapticmediasdk.a.c.b b1)
    {
        this(c1);
    }

    public static int a()
    {
        return 2;
    }

    public static int b()
    {
        return 85;
    }

    public void handleMessage(Message message)
    {
        int i = 0;
        message.what;
        JVM INSTR tableswitch 1 9: default 56
    //                   1 57
    //                   2 115
    //                   3 140
    //                   4 242
    //                   5 256
    //                   6 56
    //                   7 56
    //                   8 264
    //                   9 273;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L1 _L7 _L8
_L1:
        return;
_L2:
        com.immersion.hapticmediasdk.a.c.b(a).removeCallbacks(com.immersion.hapticmediasdk.a.c.a(a));
        com.immersion.hapticmediasdk.a.c.a(a, message.arg1);
        com.immersion.hapticmediasdk.a.c.b(a, message.arg2);
        com.immersion.hapticmediasdk.a.c.c(a, 0);
        com.immersion.hapticmediasdk.a.c.c(a);
        return;
_L3:
        message = message.getData();
        com.immersion.hapticmediasdk.a.c.a(a, message.getInt("playback_timecode"), message.getLong("playback_uptime"));
        return;
_L4:
        if (com.immersion.hapticmediasdk.a.c.d(a) == null)
        {
            com.immersion.hapticmediasdk.a.c.a(a, com.immersion.hapticmediasdk.a.a.a(com.immersion.hapticmediasdk.a.c.e(a), com.immersion.hapticmediasdk.a.c.f(a)));
        }
        if (com.immersion.hapticmediasdk.a.c.d(a) != null && com.immersion.hapticmediasdk.a.c.g(a) == 0)
        {
            com.immersion.hapticmediasdk.a.c.d(a, com.immersion.hapticmediasdk.a.c.d(a).a());
        }
        if (com.immersion.hapticmediasdk.a.c.d(a) != null)
        {
            com.immersion.hapticmediasdk.a.c.d(a).a(message.arg1);
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
        break; /* Loop/switch isn't completed */
_L5:
        com.immersion.hapticmediasdk.a.c.h(a);
        try
        {
            do
            {
                i /= 0;
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Message message) { }
        break; /* Loop/switch isn't completed */
_L6:
        com.immersion.hapticmediasdk.a.c.i(a);
        return;
_L7:
        com.immersion.hapticmediasdk.a.c.a(a, message);
        return;
_L8:
        com.immersion.hapticmediasdk.a.c.j(a);
        return;
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
    }
}
