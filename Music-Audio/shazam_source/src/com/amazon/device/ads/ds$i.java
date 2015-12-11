// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            ds

public static class d extends d
{

    private final b c;
    private final b d;

    public final void a(Runnable runnable)
    {
        boolean flag = false;
        a[d.b.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 53
    //                   2 64;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_64;
_L4:
        if (flag)
        {
            d.a(runnable);
            return;
        } else
        {
            runnable.run();
            return;
        }
_L2:
        if (!b())
        {
            flag = true;
        }
          goto _L4
        flag = b();
          goto _L4
    }

    public ( ,  1)
    {
        super(a, 1.b);
        c = ;
        d = 1;
    }
}
