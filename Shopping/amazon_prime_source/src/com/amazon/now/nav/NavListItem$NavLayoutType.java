// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;


// Referenced classes of package com.amazon.now.nav:
//            NavListItem

public static final class  extends Enum
{

    private static final SHOP_BY_STORES $VALUES[];
    public static final SHOP_BY_STORES DIVIDER;
    public static final SHOP_BY_STORES LOCATION;
    public static final SHOP_BY_STORES LOGO;
    public static final SHOP_BY_STORES NORMAL;
    public static final SHOP_BY_STORES SHOP_BY_STORES;
    public static final SHOP_BY_STORES SPACER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/nav/NavListItem$NavLayoutType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0);
        LOCATION = new <init>("LOCATION", 1);
        SPACER = new <init>("SPACER", 2);
        DIVIDER = new <init>("DIVIDER", 3);
        LOGO = new <init>("LOGO", 4);
        SHOP_BY_STORES = new <init>("SHOP_BY_STORES", 5);
        $VALUES = (new .VALUES[] {
            NORMAL, LOCATION, SPACER, DIVIDER, LOGO, SHOP_BY_STORES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
