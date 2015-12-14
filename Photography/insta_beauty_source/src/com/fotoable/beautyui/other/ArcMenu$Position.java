// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;


public final class  extends Enum
{

    private static final BOTTOM_CENTER $VALUES[];
    public static final BOTTOM_CENTER BOTTOM_CENTER;
    public static final BOTTOM_CENTER LEFT_BOTTOM;
    public static final BOTTOM_CENTER LEFT_TOP;
    public static final BOTTOM_CENTER RIGHT_BOTTOM;
    public static final BOTTOM_CENTER RIGHT_TOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/fotoable/beautyui/other/ArcMenu$Position, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LEFT_TOP = new <init>("LEFT_TOP", 0);
        LEFT_BOTTOM = new <init>("LEFT_BOTTOM", 1);
        RIGHT_TOP = new <init>("RIGHT_TOP", 2);
        RIGHT_BOTTOM = new <init>("RIGHT_BOTTOM", 3);
        BOTTOM_CENTER = new <init>("BOTTOM_CENTER", 4);
        $VALUES = (new .VALUES[] {
            LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, RIGHT_BOTTOM, BOTTOM_CENTER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
