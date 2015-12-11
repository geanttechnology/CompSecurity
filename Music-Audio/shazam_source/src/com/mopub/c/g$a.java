// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;


// Referenced classes of package com.mopub.c:
//            g

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
        return ()Enum.valueOf(com/mopub/c/g$a, s);
    }

    public static [] values()
    {
        return ([])g.clone();
    }

    static 
    {
        a = new <init>("WARMING_UP", 0);
        b = new <init>("NO_FILL", 1);
        c = new <init>("BAD_HEADER_DATA", 2);
        d = new <init>("BAD_BODY", 3);
        e = new <init>("TRACKING_FAILURE", 4);
        f = new <init>("UNSPECIFIED", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
