// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewTiltiShiftTouch

public static final class  extends Enum
{

    private static final None $VALUES[];
    public static final None Linear;
    public static final None None;
    public static final None Radial;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewTiltiShiftTouch$TiltShiftDrawMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Radial = new <init>("Radial", 0);
        Linear = new <init>("Linear", 1);
        None = new <init>("None", 2);
        $VALUES = (new .VALUES[] {
            Radial, Linear, None
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
