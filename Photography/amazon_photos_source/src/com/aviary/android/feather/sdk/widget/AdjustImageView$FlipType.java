// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AdjustImageView

public static final class nativeInt extends Enum
{

    private static final FLIP_VERTICAL $VALUES[];
    public static final FLIP_VERTICAL FLIP_HORIZONTAL;
    public static final FLIP_VERTICAL FLIP_NONE;
    public static final FLIP_VERTICAL FLIP_VERTICAL;
    public final int nativeInt;

    public static nativeInt valueOf(String s)
    {
        return (nativeInt)Enum.valueOf(com/aviary/android/feather/sdk/widget/AdjustImageView$FlipType, s);
    }

    public static nativeInt[] values()
    {
        return (nativeInt[])$VALUES.clone();
    }

    static 
    {
        FLIP_NONE = new <init>("FLIP_NONE", 0, 1);
        FLIP_HORIZONTAL = new <init>("FLIP_HORIZONTAL", 1, 2);
        FLIP_VERTICAL = new <init>("FLIP_VERTICAL", 2, 4);
        $VALUES = (new .VALUES[] {
            FLIP_NONE, FLIP_HORIZONTAL, FLIP_VERTICAL
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        nativeInt = j;
    }
}
