// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


public final class CameraAnimation extends Enum
{

    private static final CameraAnimation $VALUES[];
    public static final CameraAnimation EaseIn;
    public static final CameraAnimation EaseOut;
    public static final CameraAnimation ExtraSharpEaseIn;
    public static final CameraAnimation ExtraSharpEaseOut;
    public static final CameraAnimation ExtraSharpSmooth;
    public static final CameraAnimation ExtraSharpSmoothEaseOut;
    public static final CameraAnimation Flat;
    public static final CameraAnimation Linear;
    public static final CameraAnimation None;
    public static final CameraAnimation SharpEaseIn;
    public static final CameraAnimation SharpEaseOut;
    public static final CameraAnimation SharpSmooth;
    public static final CameraAnimation SharpSmoothEaseOut;
    public static final CameraAnimation Smooth;
    public static final CameraAnimation SmoothEaseOut;
    public static final CameraAnimation SoftEaseIn;
    public static final CameraAnimation SoftEaseOut;
    public static final CameraAnimation SoftSmooth;
    public static final CameraAnimation SoftSmoothEaseOut;

    private CameraAnimation(String s, int i)
    {
        super(s, i);
    }

    public static CameraAnimation valueOf(String s)
    {
        return (CameraAnimation)Enum.valueOf(com/pointinside/maps/CameraAnimation, s);
    }

    public static CameraAnimation[] values()
    {
        return (CameraAnimation[])$VALUES.clone();
    }

    static 
    {
        None = new CameraAnimation("None", 0);
        EaseIn = new CameraAnimation("EaseIn", 1);
        SharpEaseIn = new CameraAnimation("SharpEaseIn", 2);
        ExtraSharpEaseIn = new CameraAnimation("ExtraSharpEaseIn", 3);
        SoftEaseIn = new CameraAnimation("SoftEaseIn", 4);
        EaseOut = new CameraAnimation("EaseOut", 5);
        SharpEaseOut = new CameraAnimation("SharpEaseOut", 6);
        ExtraSharpEaseOut = new CameraAnimation("ExtraSharpEaseOut", 7);
        SoftEaseOut = new CameraAnimation("SoftEaseOut", 8);
        Flat = new CameraAnimation("Flat", 9);
        Linear = new CameraAnimation("Linear", 10);
        Smooth = new CameraAnimation("Smooth", 11);
        SharpSmooth = new CameraAnimation("SharpSmooth", 12);
        ExtraSharpSmooth = new CameraAnimation("ExtraSharpSmooth", 13);
        SoftSmooth = new CameraAnimation("SoftSmooth", 14);
        SmoothEaseOut = new CameraAnimation("SmoothEaseOut", 15);
        SharpSmoothEaseOut = new CameraAnimation("SharpSmoothEaseOut", 16);
        ExtraSharpSmoothEaseOut = new CameraAnimation("ExtraSharpSmoothEaseOut", 17);
        SoftSmoothEaseOut = new CameraAnimation("SoftSmoothEaseOut", 18);
        $VALUES = (new CameraAnimation[] {
            None, EaseIn, SharpEaseIn, ExtraSharpEaseIn, SoftEaseIn, EaseOut, SharpEaseOut, ExtraSharpEaseOut, SoftEaseOut, Flat, 
            Linear, Smooth, SharpSmooth, ExtraSharpSmooth, SoftSmooth, SmoothEaseOut, SharpSmoothEaseOut, ExtraSharpSmoothEaseOut, SoftSmoothEaseOut
        });
    }
}
