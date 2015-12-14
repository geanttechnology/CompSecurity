// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;


public final class  extends Enum
{

    private static final ERASE $VALUES[];
    public static final ERASE DRAW;
    public static final ERASE ERASE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/effectnew/MaskBrushNew$BrushDrawMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DRAW = new <init>("DRAW", 0);
        ERASE = new <init>("ERASE", 1);
        $VALUES = (new .VALUES[] {
            DRAW, ERASE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
