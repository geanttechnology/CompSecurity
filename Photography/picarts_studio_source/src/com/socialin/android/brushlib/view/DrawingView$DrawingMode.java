// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import android.graphics.PorterDuffXfermode;

public final class xfermode extends Enum
{

    private static final ERASE $VALUES[];
    public static final ERASE DRAW;
    public static final ERASE ERASE;
    public final PorterDuffXfermode xfermode;

    public static xfermode valueOf(String s)
    {
        return (xfermode)Enum.valueOf(com/socialin/android/brushlib/view/DrawingView$DrawingMode, s);
    }

    public static xfermode[] values()
    {
        return (xfermode[])$VALUES.clone();
    }

    static 
    {
        DRAW = new <init>("DRAW", 0, null);
        ERASE = new <init>("ERASE", 1, new PorterDuffXfermode(android.graphics.>));
        $VALUES = (new .VALUES[] {
            DRAW, ERASE
        });
    }

    private (String s, int i, PorterDuffXfermode porterduffxfermode)
    {
        super(s, i);
        xfermode = porterduffxfermode;
    }
}
