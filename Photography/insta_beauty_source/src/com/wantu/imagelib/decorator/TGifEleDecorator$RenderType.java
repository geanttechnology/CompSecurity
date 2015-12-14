// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator;


public final class  extends Enum
{

    private static final DRAW $VALUES[];
    public static final DRAW BLEND;
    public static final DRAW DRAW;
    public static final DRAW TRANSCOLOR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/imagelib/decorator/TGifEleDecorator$RenderType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TRANSCOLOR = new <init>("TRANSCOLOR", 0);
        BLEND = new <init>("BLEND", 1);
        DRAW = new <init>("DRAW", 2);
        $VALUES = (new .VALUES[] {
            TRANSCOLOR, BLEND, DRAW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
