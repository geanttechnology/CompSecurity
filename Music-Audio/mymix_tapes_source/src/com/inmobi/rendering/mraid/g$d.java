// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;


// Referenced classes of package com.inmobi.rendering.mraid:
//            g

static final class  extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/inmobi/rendering/mraid/g$d, s);
    }

    public static [] values()
    {
        return ([])h.clone();
    }

    static 
    {
        a = new <init>("INITIALIZED", 0);
        b = new <init>("PLAYING", 1);
        c = new <init>("PAUSED", 2);
        d = new <init>("HIDDEN", 3);
        e = new <init>("SHOWING", 4);
        f = new <init>("COMPLETED", 5);
        g = new <init>("RELEASED", 6);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
