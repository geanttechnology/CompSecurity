// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager.android;


// Referenced classes of package com.ebay.mobile.photomanager.android:
//            CropImageView

public static final class  extends Enum
{

    private static final RIGHT $VALUES[];
    public static final RIGHT LEFT;
    public static final RIGHT RIGHT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/photomanager/android/CropImageView$Direction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LEFT = new <init>("LEFT", 0);
        RIGHT = new <init>("RIGHT", 1);
        $VALUES = (new .VALUES[] {
            LEFT, RIGHT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
