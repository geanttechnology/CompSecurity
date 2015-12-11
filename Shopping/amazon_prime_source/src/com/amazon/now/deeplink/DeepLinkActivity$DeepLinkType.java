// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.deeplink;


// Referenced classes of package com.amazon.now.deeplink:
//            DeepLinkActivity

private static final class  extends Enum
{

    private static final GENERIC $VALUES[];
    public static final GENERIC BROWSE_NODE;
    public static final GENERIC CART;
    public static final GENERIC DETAIL_PAGE;
    public static final GENERIC GENERIC;
    public static final GENERIC ORDER_STATUS;
    public static final GENERIC SEARCH;
    public static final GENERIC YOUR_ACCOUNT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/deeplink/DeepLinkActivity$DeepLinkType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DETAIL_PAGE = new <init>("DETAIL_PAGE", 0);
        BROWSE_NODE = new <init>("BROWSE_NODE", 1);
        SEARCH = new <init>("SEARCH", 2);
        ORDER_STATUS = new <init>("ORDER_STATUS", 3);
        YOUR_ACCOUNT = new <init>("YOUR_ACCOUNT", 4);
        CART = new <init>("CART", 5);
        GENERIC = new <init>("GENERIC", 6);
        $VALUES = (new .VALUES[] {
            DETAIL_PAGE, BROWSE_NODE, SEARCH, ORDER_STATUS, YOUR_ACCOUNT, CART, GENERIC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
