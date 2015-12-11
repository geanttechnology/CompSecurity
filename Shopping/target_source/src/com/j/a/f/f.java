// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.f;

import android.graphics.Color;
import com.j.a.g.t;

// Referenced classes of package com.j.a.f:
//            g

public class f
{

    public static int a()
    {
        return Color.parseColor("#CCe75f68");
    }

    public static int a(t t1)
    {
        g.a[t1.ordinal()];
        JVM INSTR tableswitch 2 4: default 36
    //                   2 44
    //                   3 44
    //                   4 50;
           goto _L1 _L2 _L2 _L3
_L1:
        t1 = "#CC70daff";
_L5:
        return Color.parseColor(t1);
_L2:
        t1 = "#CC7fe1a5";
        continue; /* Loop/switch isn't completed */
_L3:
        t1 = "#ba76e5";
        if (true) goto _L5; else goto _L4
_L4:
    }
}
