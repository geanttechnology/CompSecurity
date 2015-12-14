// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;


public final class  extends Enum
{

    private static final CLIPART $VALUES[];
    public static final CLIPART ARROW;
    public static final CLIPART CLIPART;
    public static final CLIPART LINE;
    public static final CLIPART SVG;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/brushlib/controller/ShapeOverlayController$ShapeType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LINE = new <init>("LINE", 0);
        ARROW = new <init>("ARROW", 1);
        SVG = new <init>("SVG", 2);
        CLIPART = new <init>("CLIPART", 3);
        $VALUES = (new .VALUES[] {
            LINE, ARROW, SVG, CLIPART
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
