// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


public final class mGravity extends Enum
{

    private static final BOTTOM_RIGHT $VALUES[];
    public static final BOTTOM_RIGHT BOTTOM_CENTER;
    public static final BOTTOM_RIGHT BOTTOM_LEFT;
    public static final BOTTOM_RIGHT BOTTOM_RIGHT;
    public static final BOTTOM_RIGHT CENTER;
    public static final BOTTOM_RIGHT TOP_CENTER;
    public static final BOTTOM_RIGHT TOP_LEFT;
    public static final BOTTOM_RIGHT TOP_RIGHT;
    private final int mGravity;

    public static mGravity valueOf(String s)
    {
        return (mGravity)Enum.valueOf(com/mopub/common/CloseableLayout$ClosePosition, s);
    }

    public static mGravity[] values()
    {
        return (mGravity[])$VALUES.clone();
    }

    final int getGravity()
    {
        return mGravity;
    }

    static 
    {
        TOP_LEFT = new <init>("TOP_LEFT", 0, 51);
        TOP_CENTER = new <init>("TOP_CENTER", 1, 49);
        TOP_RIGHT = new <init>("TOP_RIGHT", 2, 53);
        CENTER = new <init>("CENTER", 3, 17);
        BOTTOM_LEFT = new <init>("BOTTOM_LEFT", 4, 83);
        BOTTOM_CENTER = new <init>("BOTTOM_CENTER", 5, 81);
        BOTTOM_RIGHT = new <init>("BOTTOM_RIGHT", 6, 85);
        $VALUES = (new .VALUES[] {
            TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mGravity = j;
    }
}
