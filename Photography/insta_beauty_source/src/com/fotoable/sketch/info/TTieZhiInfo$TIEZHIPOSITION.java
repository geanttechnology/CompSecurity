// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.info;


public final class _cls9 extends Enum
{

    private static final RIGHTBOTTOM $VALUES[];
    public static final RIGHTBOTTOM BOTTOM;
    public static final RIGHTBOTTOM CENTER;
    public static final RIGHTBOTTOM LEFT;
    public static final RIGHTBOTTOM LEFTBOTTOM;
    public static final RIGHTBOTTOM LEFTTOP;
    public static final RIGHTBOTTOM RIGHT;
    public static final RIGHTBOTTOM RIGHTBOTTOM;
    public static final RIGHTBOTTOM RIGHTTOP;
    public static final RIGHTBOTTOM TOP;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/fotoable/sketch/info/TTieZhiInfo$TIEZHIPOSITION, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        CENTER = new <init>("CENTER", 0);
        LEFT = new <init>("LEFT", 1);
        TOP = new <init>("TOP", 2);
        RIGHT = new <init>("RIGHT", 3);
        BOTTOM = new <init>("BOTTOM", 4);
        LEFTTOP = new <init>("LEFTTOP", 5);
        LEFTBOTTOM = new <init>("LEFTBOTTOM", 6);
        RIGHTTOP = new <init>("RIGHTTOP", 7);
        RIGHTBOTTOM = new <init>("RIGHTBOTTOM", 8);
        $VALUES = (new .VALUES[] {
            CENTER, LEFT, TOP, RIGHT, BOTTOM, LEFTTOP, LEFTBOTTOM, RIGHTTOP, RIGHTBOTTOM
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
