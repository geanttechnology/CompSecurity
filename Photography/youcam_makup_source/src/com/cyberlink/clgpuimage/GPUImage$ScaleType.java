// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


public final class  extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/clgpuimage/GPUImage$ScaleType, s);
    }

    public static [] values()
    {
        return ([])h.clone();
    }

    static 
    {
        a = new <init>("CENTER_INSIDE", 0);
        b = new <init>("CENTER_CROP", 1);
        c = new <init>("CENTER_INSIDE_CAMERA", 2);
        d = new <init>("SQUARE_CROP_INSIDE_CAMERA", 3);
        e = new <init>("CENTER_INSIDE_CAMERA_YUV_BUFFER", 4);
        f = new <init>("AS_DISAPLY", 5);
        g = new <init>("MANUALLY", 6);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
