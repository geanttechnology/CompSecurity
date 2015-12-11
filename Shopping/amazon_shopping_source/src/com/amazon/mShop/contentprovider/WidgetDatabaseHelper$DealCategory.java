// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;


// Referenced classes of package com.amazon.mShop.contentprovider:
//            WidgetDatabaseHelper

private static final class  extends Enum
{

    private static final S9 $VALUES[];
    public static final S9 FEATURED;
    public static final S9 S9;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FEATURED = new <init>("FEATURED", 0);
        S9 = new <init>("S9", 1);
        $VALUES = (new .VALUES[] {
            FEATURED, S9
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
