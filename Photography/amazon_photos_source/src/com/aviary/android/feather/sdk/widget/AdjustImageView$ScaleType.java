// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

public static final class nativeInt extends Enum
{

    private static final CENTER_INSIDE $VALUES[];
    public static final CENTER_INSIDE CENTER;
    public static final CENTER_INSIDE CENTER_CROP;
    public static final CENTER_INSIDE CENTER_INSIDE;
    public static final CENTER_INSIDE FIT_CENTER;
    public static final CENTER_INSIDE FIT_END;
    public static final CENTER_INSIDE FIT_START;
    public static final CENTER_INSIDE FIT_XY;
    public static final CENTER_INSIDE MATRIX;
    final int nativeInt;

    public static nativeInt valueOf(String s)
    {
        return (nativeInt)Enum.valueOf(com/aviary/android/feather/sdk/widget/AdjustImageView$ScaleType, s);
    }

    public static nativeInt[] values()
    {
        return (nativeInt[])$VALUES.clone();
    }

    static 
    {
        MATRIX = new <init>("MATRIX", 0, 0);
        FIT_XY = new <init>("FIT_XY", 1, 1);
        FIT_START = new <init>("FIT_START", 2, 2);
        FIT_CENTER = new <init>("FIT_CENTER", 3, 3);
        FIT_END = new <init>("FIT_END", 4, 4);
        CENTER = new <init>("CENTER", 5, 5);
        CENTER_CROP = new <init>("CENTER_CROP", 6, 6);
        CENTER_INSIDE = new <init>("CENTER_INSIDE", 7, 7);
        $VALUES = (new .VALUES[] {
            MATRIX, FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_CROP, CENTER_INSIDE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        nativeInt = j;
    }
}
