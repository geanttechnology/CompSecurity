// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;

final class da extends Enum
{

    public static final da a;
    public static final da b;
    public static final da c;
    public static final da d;
    public static final da e;
    public static final da f;
    public static final da g;
    private static final HashMap h;
    private static final da i[];

    private da(String s, int j)
    {
        super(s, j);
    }

    public static da a(String s)
    {
        return (da)h.get(s);
    }

    public static da valueOf(String s)
    {
        return (da)Enum.valueOf(com/amazon/device/ads/da, s);
    }

    public static da[] values()
    {
        return (da[])i.clone();
    }

    static 
    {
        a = new da("TOP_LEFT", 0);
        b = new da("TOP_RIGHT", 1);
        c = new da("CENTER", 2);
        d = new da("BOTTOM_LEFT", 3);
        e = new da("BOTTOM_RIGHT", 4);
        f = new da("TOP_CENTER", 5);
        g = new da("BOTTOM_CENTER", 6);
        i = (new da[] {
            a, b, c, d, e, f, g
        });
        HashMap hashmap = new HashMap();
        h = hashmap;
        hashmap.put("top-left", a);
        h.put("top-right", b);
        h.put("top-center", f);
        h.put("bottom-left", d);
        h.put("bottom-right", e);
        h.put("bottom-center", g);
        h.put("center", c);
    }
}
