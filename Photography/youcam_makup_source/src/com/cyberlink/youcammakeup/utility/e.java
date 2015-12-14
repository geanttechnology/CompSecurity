// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.EnumMap;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            BeautyMode

public class e
{

    private static final EnumMap a;

    public static Integer a(BeautyMode beautymode)
    {
        if (!a.containsKey(beautymode))
        {
            return null;
        } else
        {
            return (Integer)a.get(beautymode);
        }
    }

    static 
    {
        a = new EnumMap(com/cyberlink/youcammakeup/utility/BeautyMode);
        a.put(BeautyMode.d, Integer.valueOf(0x7f07034e));
        a.put(BeautyMode.b, Integer.valueOf(0x7f07034f));
        a.put(BeautyMode.h, Integer.valueOf(0x7f07033f));
        a.put(BeautyMode.a, Integer.valueOf(0x7f070332));
        a.put(BeautyMode.c, Integer.valueOf(0x7f070349));
        a.put(BeautyMode.o, Integer.valueOf(0x7f070336));
        a.put(BeautyMode.u, Integer.valueOf(0x7f070350));
        a.put(BeautyMode.p, Integer.valueOf(0x7f070337));
        a.put(BeautyMode.g, Integer.valueOf(0x7f070333));
        a.put(BeautyMode.f, Integer.valueOf(0x7f070334));
        a.put(BeautyMode.q, Integer.valueOf(0x7f07034b));
        a.put(BeautyMode.n, Integer.valueOf(0x7f07033c));
        a.put(BeautyMode.r, Integer.valueOf(0x7f070338));
        a.put(BeautyMode.s, Integer.valueOf(0x7f070339));
        a.put(BeautyMode.l, Integer.valueOf(0x7f07033b));
        a.put(BeautyMode.m, Integer.valueOf(0x7f07033a));
        a.put(BeautyMode.t, Integer.valueOf(0x7f07033d));
        a.put(BeautyMode.e, Integer.valueOf(0x7f07034a));
        a.put(BeautyMode.v, Integer.valueOf(0x7f070345));
        a.put(BeautyMode.w, Integer.valueOf(0x7f070351));
        a.put(BeautyMode.x, Integer.valueOf(0x7f070343));
        a.put(BeautyMode.y, Integer.valueOf(0x7f070341));
        a.put(BeautyMode.z, Integer.valueOf(0x7f07008c));
        a.put(BeautyMode.A, Integer.valueOf(0x7f07008d));
        a.put(BeautyMode.B, Integer.valueOf(0x7f07008e));
        a.put(BeautyMode.C, Integer.valueOf(0x7f07008b));
    }
}
