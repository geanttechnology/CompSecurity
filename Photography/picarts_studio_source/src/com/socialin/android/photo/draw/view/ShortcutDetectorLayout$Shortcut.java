// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.view;


public final class  extends Enum
{

    private static final CENTER $VALUES[];
    public static final CENTER BOTTOM_LEFT;
    public static final CENTER BOTTOM_RIGHT;
    public static final CENTER CENTER;
    public static final CENTER TOP_LEFT;
    public static final CENTER TOP_RIGHT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/socialin/android/photo/draw/view/ShortcutDetectorLayout$Shortcut, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TOP_LEFT = new <init>("TOP_LEFT", 0);
        TOP_RIGHT = new <init>("TOP_RIGHT", 1);
        BOTTOM_LEFT = new <init>("BOTTOM_LEFT", 2);
        BOTTOM_RIGHT = new <init>("BOTTOM_RIGHT", 3);
        CENTER = new <init>("CENTER", 4);
        $VALUES = (new .VALUES[] {
            TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
