// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;


public class NavListItem
{
    public static final class NavItemType extends Enum
    {

        private static final NavItemType $VALUES[];
        public static final NavItemType ALL_STORES;
        public static final NavItemType BROWSE_BY_CATEGORY;
        public static final NavItemType CONTACT_US;
        public static final NavItemType DEBUG;
        public static final NavItemType DIVIDER;
        public static final NavItemType HELP_ABOUT;
        public static final NavItemType HOME;
        public static final NavItemType LOCATION;
        public static final NavItemType LOGO;
        public static final NavItemType RESTAURANTS;
        public static final NavItemType SHOP_BY_STORES;
        public static final NavItemType SHOP_PAST_PURCHASE;
        public static final NavItemType SIGN_IN;
        public static final NavItemType SIGN_OUT;
        public static final NavItemType SPACER;
        public static final NavItemType YOUR_ACCOUNT;
        public static final NavItemType YOUR_ORDERS;

        public static NavItemType valueOf(String s)
        {
            return (NavItemType)Enum.valueOf(com/amazon/now/nav/NavListItem$NavItemType, s);
        }

        public static NavItemType[] values()
        {
            return (NavItemType[])$VALUES.clone();
        }

        static 
        {
            LOCATION = new NavItemType("LOCATION", 0);
            HOME = new NavItemType("HOME", 1);
            SHOP_PAST_PURCHASE = new NavItemType("SHOP_PAST_PURCHASE", 2);
            BROWSE_BY_CATEGORY = new NavItemType("BROWSE_BY_CATEGORY", 3);
            YOUR_ACCOUNT = new NavItemType("YOUR_ACCOUNT", 4);
            YOUR_ORDERS = new NavItemType("YOUR_ORDERS", 5);
            HELP_ABOUT = new NavItemType("HELP_ABOUT", 6);
            CONTACT_US = new NavItemType("CONTACT_US", 7);
            SIGN_IN = new NavItemType("SIGN_IN", 8);
            SIGN_OUT = new NavItemType("SIGN_OUT", 9);
            SPACER = new NavItemType("SPACER", 10);
            DIVIDER = new NavItemType("DIVIDER", 11);
            LOGO = new NavItemType("LOGO", 12);
            DEBUG = new NavItemType("DEBUG", 13);
            SHOP_BY_STORES = new NavItemType("SHOP_BY_STORES", 14);
            ALL_STORES = new NavItemType("ALL_STORES", 15);
            RESTAURANTS = new NavItemType("RESTAURANTS", 16);
            $VALUES = (new NavItemType[] {
                LOCATION, HOME, SHOP_PAST_PURCHASE, BROWSE_BY_CATEGORY, YOUR_ACCOUNT, YOUR_ORDERS, HELP_ABOUT, CONTACT_US, SIGN_IN, SIGN_OUT, 
                SPACER, DIVIDER, LOGO, DEBUG, SHOP_BY_STORES, ALL_STORES, RESTAURANTS
            });
        }

        private NavItemType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class NavLayoutType extends Enum
    {

        private static final NavLayoutType $VALUES[];
        public static final NavLayoutType DIVIDER;
        public static final NavLayoutType LOCATION;
        public static final NavLayoutType LOGO;
        public static final NavLayoutType NORMAL;
        public static final NavLayoutType SHOP_BY_STORES;
        public static final NavLayoutType SPACER;

        public static NavLayoutType valueOf(String s)
        {
            return (NavLayoutType)Enum.valueOf(com/amazon/now/nav/NavListItem$NavLayoutType, s);
        }

        public static NavLayoutType[] values()
        {
            return (NavLayoutType[])$VALUES.clone();
        }

        static 
        {
            NORMAL = new NavLayoutType("NORMAL", 0);
            LOCATION = new NavLayoutType("LOCATION", 1);
            SPACER = new NavLayoutType("SPACER", 2);
            DIVIDER = new NavLayoutType("DIVIDER", 3);
            LOGO = new NavLayoutType("LOGO", 4);
            SHOP_BY_STORES = new NavLayoutType("SHOP_BY_STORES", 5);
            $VALUES = (new NavLayoutType[] {
                NORMAL, LOCATION, SPACER, DIVIDER, LOGO, SHOP_BY_STORES
            });
        }

        private NavLayoutType(String s, int i)
        {
            super(s, i);
        }
    }


    private final NavItemType mItem;
    private final NavLayoutType mLayout;
    private final String mName;

    public NavListItem(NavItemType navitemtype, String s, NavLayoutType navlayouttype)
    {
        mItem = navitemtype;
        mName = s;
        mLayout = navlayouttype;
    }

    public NavItemType getItemType()
    {
        return mItem;
    }

    public NavLayoutType getLayoutType()
    {
        return mLayout;
    }

    public String getName()
    {
        return mName;
    }
}
