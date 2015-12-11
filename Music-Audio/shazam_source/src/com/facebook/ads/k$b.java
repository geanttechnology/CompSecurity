// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import java.util.EnumSet;

// Referenced classes of package com.facebook.ads:
//            k

public static final class e extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final EnumSet d = EnumSet.allOf(com/facebook/ads/k$b);
    private static final Of f[];
    private final long e;

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/facebook/ads/k$b, s);
    }

    public static f[] values()
    {
        return (f[])f.clone();
    }

    static 
    {
        a = new <init>("NONE", 0, 0L);
        b = new <init>("ICON", 1, 1L);
        c = new <init>("IMAGE", 2, 2L);
        f = (new f[] {
            a, b, c
        });
    }

    private (String s, int i, long l)
    {
        super(s, i);
        e = l;
    }
}
