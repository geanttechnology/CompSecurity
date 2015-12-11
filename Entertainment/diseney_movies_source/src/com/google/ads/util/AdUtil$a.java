// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;


// Referenced classes of package com.google.ads.util:
//            AdUtil

public static final class  extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/ads/util/AdUtil$a, s);
    }

    public static [] values()
    {
        return ([])g.clone();
    }

    static 
    {
        a = new <init>("INVALID", 0);
        b = new <init>("SPEAKER", 1);
        c = new <init>("HEADPHONES", 2);
        d = new <init>("VIBRATE", 3);
        e = new <init>("EMULATOR", 4);
        f = new <init>("OTHER", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
