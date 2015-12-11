// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;


// Referenced classes of package com.amazon.now.nav:
//            NavListItem

public static final class  extends Enum
{

    private static final RESTAURANTS $VALUES[];
    public static final RESTAURANTS ALL_STORES;
    public static final RESTAURANTS BROWSE_BY_CATEGORY;
    public static final RESTAURANTS CONTACT_US;
    public static final RESTAURANTS DEBUG;
    public static final RESTAURANTS DIVIDER;
    public static final RESTAURANTS HELP_ABOUT;
    public static final RESTAURANTS HOME;
    public static final RESTAURANTS LOCATION;
    public static final RESTAURANTS LOGO;
    public static final RESTAURANTS RESTAURANTS;
    public static final RESTAURANTS SHOP_BY_STORES;
    public static final RESTAURANTS SHOP_PAST_PURCHASE;
    public static final RESTAURANTS SIGN_IN;
    public static final RESTAURANTS SIGN_OUT;
    public static final RESTAURANTS SPACER;
    public static final RESTAURANTS YOUR_ACCOUNT;
    public static final RESTAURANTS YOUR_ORDERS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/nav/NavListItem$NavItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOCATION = new <init>("LOCATION", 0);
        HOME = new <init>("HOME", 1);
        SHOP_PAST_PURCHASE = new <init>("SHOP_PAST_PURCHASE", 2);
        BROWSE_BY_CATEGORY = new <init>("BROWSE_BY_CATEGORY", 3);
        YOUR_ACCOUNT = new <init>("YOUR_ACCOUNT", 4);
        YOUR_ORDERS = new <init>("YOUR_ORDERS", 5);
        HELP_ABOUT = new <init>("HELP_ABOUT", 6);
        CONTACT_US = new <init>("CONTACT_US", 7);
        SIGN_IN = new <init>("SIGN_IN", 8);
        SIGN_OUT = new <init>("SIGN_OUT", 9);
        SPACER = new <init>("SPACER", 10);
        DIVIDER = new <init>("DIVIDER", 11);
        LOGO = new <init>("LOGO", 12);
        DEBUG = new <init>("DEBUG", 13);
        SHOP_BY_STORES = new <init>("SHOP_BY_STORES", 14);
        ALL_STORES = new <init>("ALL_STORES", 15);
        RESTAURANTS = new <init>("RESTAURANTS", 16);
        $VALUES = (new .VALUES[] {
            LOCATION, HOME, SHOP_PAST_PURCHASE, BROWSE_BY_CATEGORY, YOUR_ACCOUNT, YOUR_ORDERS, HELP_ABOUT, CONTACT_US, SIGN_IN, SIGN_OUT, 
            SPACER, DIVIDER, LOGO, DEBUG, SHOP_BY_STORES, ALL_STORES, RESTAURANTS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
