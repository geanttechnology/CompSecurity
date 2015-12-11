// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import com.facebook.ads.a.e.a;

// Referenced classes of package com.facebook.ads.a.b:
//            n, l, o, p

public final class m extends Enum
{

    public static final m a;
    public static final m b;
    public static final m c;
    private static final m h[];
    public Class d;
    public String e;
    public l f;
    public a g;

    private m(String s, int i, Class class1, l l1, a a1)
    {
        super(s, i);
        d = class1;
        f = l1;
        g = a1;
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/facebook/ads/a/b/m, s);
    }

    public static m[] values()
    {
        return (m[])h.clone();
    }

    static 
    {
        a = new m("ANBANNER", 0, com/facebook/ads/a/b/n, l.b, a.b);
        b = new m("ANINTERSTITIAL", 1, com/facebook/ads/a/b/o, l.b, a.c);
        c = new m("ANNATIVE", 2, com/facebook/ads/a/b/p, l.b, a.d);
        h = (new m[] {
            a, b, c
        });
    }
}
