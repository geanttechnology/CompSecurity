// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;


// Referenced classes of package com.ebay.android.widget:
//            RemoteImageView

public static final class  extends Enum
{

    private static final FOUR_BY_THREE $VALUES[];
    public static final FOUR_BY_THREE DISABLED;
    public static final FOUR_BY_THREE FOUR_BY_THREE;
    public static final FOUR_BY_THREE SQUARE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/android/widget/RemoteImageView$DynamicHeight, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DISABLED = new <init>("DISABLED", 0);
        SQUARE = new <init>("SQUARE", 1);
        FOUR_BY_THREE = new <init>("FOUR_BY_THREE", 2);
        $VALUES = (new .VALUES[] {
            DISABLED, SQUARE, FOUR_BY_THREE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
