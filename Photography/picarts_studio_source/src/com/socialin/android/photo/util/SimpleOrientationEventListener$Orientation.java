// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.util;


public final class angle extends Enum
{

    private static final UNDEFINED $VALUES[];
    public static final UNDEFINED BOTTOM_DOWN;
    public static final UNDEFINED FLAT;
    public static final UNDEFINED LEFT_DOWN;
    public static final UNDEFINED RIGHT_DOWN;
    public static final UNDEFINED TOP_DOWN;
    public static final UNDEFINED UNDEFINED;
    public final int angle;

    public static angle valueOf(String s)
    {
        return (angle)Enum.valueOf(com/socialin/android/photo/util/SimpleOrientationEventListener$Orientation, s);
    }

    public static angle[] values()
    {
        return (angle[])$VALUES.clone();
    }

    static 
    {
        BOTTOM_DOWN = new <init>("BOTTOM_DOWN", 0, 0);
        RIGHT_DOWN = new <init>("RIGHT_DOWN", 1, 90);
        TOP_DOWN = new <init>("TOP_DOWN", 2, 180);
        LEFT_DOWN = new <init>("LEFT_DOWN", 3, 270);
        FLAT = new <init>("FLAT", 4, -1);
        UNDEFINED = new <init>("UNDEFINED", 5, -1);
        $VALUES = (new .VALUES[] {
            BOTTOM_DOWN, RIGHT_DOWN, TOP_DOWN, LEFT_DOWN, FLAT, UNDEFINED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        angle = j;
    }
}
