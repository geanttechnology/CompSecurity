// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;


// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            ImageViewSpotSingleTap

public static final class  extends Enum
{

    private static final DRAW $VALUES[];
    public static final DRAW DRAW;
    public static final DRAW IMAGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewSpotSingleTap$TouchMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IMAGE = new <init>("IMAGE", 0);
        DRAW = new <init>("DRAW", 1);
        $VALUES = (new .VALUES[] {
            IMAGE, DRAW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
