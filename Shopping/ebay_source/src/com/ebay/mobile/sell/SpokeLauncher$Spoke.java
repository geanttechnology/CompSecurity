// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;


// Referenced classes of package com.ebay.mobile.sell:
//            SpokeLauncher

private static final class  extends Enum
{

    private static final PREFERENCES $VALUES[];
    public static final PREFERENCES CATEGORY;
    public static final PREFERENCES CONDITION;
    public static final PREFERENCES DESCRIPTION;
    public static final PREFERENCES FORMAT_PRICE;
    public static final PREFERENCES ITEM_SPECIFICS;
    public static final PREFERENCES PHOTOS;
    public static final PREFERENCES PREFERENCES;
    public static final PREFERENCES SHIPPING;
    public static final PREFERENCES TITLE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/sell/SpokeLauncher$Spoke, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PHOTOS = new <init>("PHOTOS", 0);
        TITLE = new <init>("TITLE", 1);
        CATEGORY = new <init>("CATEGORY", 2);
        CONDITION = new <init>("CONDITION", 3);
        ITEM_SPECIFICS = new <init>("ITEM_SPECIFICS", 4);
        DESCRIPTION = new <init>("DESCRIPTION", 5);
        FORMAT_PRICE = new <init>("FORMAT_PRICE", 6);
        SHIPPING = new <init>("SHIPPING", 7);
        PREFERENCES = new <init>("PREFERENCES", 8);
        $VALUES = (new .VALUES[] {
            PHOTOS, TITLE, CATEGORY, CONDITION, ITEM_SPECIFICS, DESCRIPTION, FORMAT_PRICE, SHIPPING, PREFERENCES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
