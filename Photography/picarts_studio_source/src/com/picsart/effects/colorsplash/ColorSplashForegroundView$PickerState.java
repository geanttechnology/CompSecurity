// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;


final class  extends Enum
{

    private static final CLOSING $VALUES[];
    public static final CLOSING CLOSED;
    public static final CLOSING CLOSING;
    public static final CLOSING OPEN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/effects/colorsplash/ColorSplashForegroundView$PickerState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OPEN = new <init>("OPEN", 0);
        CLOSED = new <init>("CLOSED", 1);
        CLOSING = new <init>("CLOSING", 2);
        $VALUES = (new .VALUES[] {
            OPEN, CLOSED, CLOSING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
