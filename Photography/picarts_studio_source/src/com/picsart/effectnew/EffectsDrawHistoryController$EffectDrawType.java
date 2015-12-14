// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;


public final class  extends Enum
{

    private static final CLEAR $VALUES[];
    public static final CLEAR CLEAR;
    public static final CLEAR DRAW_PATH;
    public static final CLEAR DRAW_SHAPE;
    public static final CLEAR FILL;
    public static final CLEAR INVERT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/effectnew/EffectsDrawHistoryController$EffectDrawType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAW_PATH = new <init>("DRAW_PATH", 0);
        DRAW_SHAPE = new <init>("DRAW_SHAPE", 1);
        INVERT = new <init>("INVERT", 2);
        FILL = new <init>("FILL", 3);
        CLEAR = new <init>("CLEAR", 4);
        $VALUES = (new .VALUES[] {
            DRAW_PATH, DRAW_SHAPE, INVERT, FILL, CLEAR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
