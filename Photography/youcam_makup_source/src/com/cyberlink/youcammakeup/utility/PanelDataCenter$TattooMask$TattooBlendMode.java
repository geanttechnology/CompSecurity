// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public final class  extends Enum
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
        return ()Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$TattooMask$TattooBlendMode, s);
    }

    public static [] values()
    {
        return ([])g.clone();
    }

    static 
    {
        a = new <init>("NORMAL_ON_SKIN", 0);
        b = new <init>("NORMAL", 1);
        c = new <init>("MULTIPLY_ON_SKIN", 2);
        d = new <init>("MULTIPLY", 3);
        e = new <init>("NATURE_ON_SKIN", 4);
        f = new <init>("NATURE", 5);
        g = (new g[] {
            a, b, c, d, e, f
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
