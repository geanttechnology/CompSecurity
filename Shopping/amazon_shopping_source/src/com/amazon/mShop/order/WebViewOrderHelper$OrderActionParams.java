// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.order;


// Referenced classes of package com.amazon.mShop.order:
//            WebViewOrderHelper

public static final class mKey extends Enum
{

    private static final SHIP_METHOD $VALUES[];
    public static final SHIP_METHOD ORDER_ID;
    public static final SHIP_METHOD SHIP_METHOD;
    public static final SHIP_METHOD TRACKING_ID;
    private String mKey;

    public static mKey valueOf(String s)
    {
        return (mKey)Enum.valueOf(com/amazon/mShop/order/WebViewOrderHelper$OrderActionParams, s);
    }

    public static mKey[] values()
    {
        return (mKey[])$VALUES.clone();
    }

    static 
    {
        ORDER_ID = new <init>("ORDER_ID", 0, "oid");
        TRACKING_ID = new <init>("TRACKING_ID", 1, "tn");
        SHIP_METHOD = new <init>("SHIP_METHOD", 2, "sm");
        $VALUES = (new .VALUES[] {
            ORDER_ID, TRACKING_ID, SHIP_METHOD
        });
    }


    private A(String s, int i, String s1)
    {
        super(s, i);
        mKey = s1;
    }
}
