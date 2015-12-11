// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;


// Referenced classes of package com.google.ads:
//            g

public static final class t> extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    private static final f g[];

    public static t> valueOf(String s)
    {
        return (t>)Enum.valueOf(com/google/ads/g$a, s);
    }

    public static eOf[] values()
    {
        return (eOf[])g.clone();
    }

    static 
    {
        a = new <init>("AD", 0);
        b = new <init>("NO_FILL", 1);
        c = new <init>("ERROR", 2);
        d = new <init>("TIMEOUT", 3);
        e = new <init>("NOT_FOUND", 4);
        f = new <init>("EXCEPTION", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
