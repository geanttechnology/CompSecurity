// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib;

import android.graphics.PorterDuffXfermode;

public final class DrawType extends Enum
{

    private static final DrawType $VALUES[];
    public static final DrawType DRAW;
    public static final DrawType ERASE;
    public final PorterDuffXfermode xfermode;

    private DrawType(String s, int i, PorterDuffXfermode porterduffxfermode)
    {
        super(s, i);
        xfermode = porterduffxfermode;
    }

    public static DrawType valueOf(String s)
    {
        return (DrawType)Enum.valueOf(com/socialin/android/brushlib/DrawType, s);
    }

    public static DrawType[] values()
    {
        return (DrawType[])$VALUES.clone();
    }

    static 
    {
        DRAW = new DrawType("DRAW", 0, null);
        ERASE = new DrawType("ERASE", 1, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OUT));
        $VALUES = (new DrawType[] {
            DRAW, ERASE
        });
    }
}
