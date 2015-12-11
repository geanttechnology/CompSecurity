// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;


public final class CameraOpenMode extends Enum
{

    private static final CameraOpenMode $VALUES[];
    public static final CameraOpenMode FIRST_BACK_FACING;
    public static final CameraOpenMode FIRST_FRONT_FACING;
    public static final CameraOpenMode UNKOWN;

    private CameraOpenMode(String s, int i)
    {
        super(s, i);
    }

    public static CameraOpenMode valueOf(String s)
    {
        return (CameraOpenMode)Enum.valueOf(com/a9/cameralibrary/CameraOpenMode, s);
    }

    public static CameraOpenMode[] values()
    {
        return (CameraOpenMode[])$VALUES.clone();
    }

    static 
    {
        FIRST_FRONT_FACING = new CameraOpenMode("FIRST_FRONT_FACING", 0);
        FIRST_BACK_FACING = new CameraOpenMode("FIRST_BACK_FACING", 1);
        UNKOWN = new CameraOpenMode("UNKOWN", 2);
        $VALUES = (new CameraOpenMode[] {
            FIRST_FRONT_FACING, FIRST_BACK_FACING, UNKOWN
        });
    }
}
