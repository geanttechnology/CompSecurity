// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.filter;


final class  extends Enum
{

    private static final ZOOM $VALUES[];
    public static final ZOOM LINEAR;
    public static final ZOOM RADIAL;
    public static final ZOOM ZOOM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/imagelib/filter/motionBlur$EMotionBlurType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LINEAR = new <init>("LINEAR", 0);
        RADIAL = new <init>("RADIAL", 1);
        ZOOM = new <init>("ZOOM", 2);
        $VALUES = (new .VALUES[] {
            LINEAR, RADIAL, ZOOM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
