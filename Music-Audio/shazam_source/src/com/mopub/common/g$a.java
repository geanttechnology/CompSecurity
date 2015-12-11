// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


// Referenced classes of package com.mopub.common:
//            g

public static final class h extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g i[];
    final int h;

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/mopub/common/g$a, s);
    }

    public static f[] values()
    {
        return (f[])i.clone();
    }

    static 
    {
        a = new <init>("TOP_LEFT", 0, 51);
        b = new <init>("TOP_CENTER", 1, 49);
        c = new <init>("TOP_RIGHT", 2, 53);
        d = new <init>("CENTER", 3, 17);
        e = new <init>("BOTTOM_LEFT", 4, 83);
        f = new <init>("BOTTOM_CENTER", 5, 81);
        g = new <init>("BOTTOM_RIGHT", 6, 85);
        i = (new i[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, int j, int k)
    {
        super(s, j);
        h = k;
    }
}
