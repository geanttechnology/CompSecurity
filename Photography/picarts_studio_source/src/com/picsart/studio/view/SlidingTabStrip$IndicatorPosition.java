// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;


public final class  extends Enum
{

    private static final BOTTOM $VALUES[];
    public static final BOTTOM BOTTOM;
    public static final BOTTOM TOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/view/SlidingTabStrip$IndicatorPosition, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TOP = new <init>("TOP", 0);
        BOTTOM = new <init>("BOTTOM", 1);
        $VALUES = (new .VALUES[] {
            TOP, BOTTOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
