// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCart

public static final class  extends Enum
{

    private static final PURCHASE_FAILED $VALUES[];
    public static final PURCHASE_FAILED NOT_PURCHASED;
    public static final PURCHASE_FAILED PURCHASED;
    public static final PURCHASE_FAILED PURCHASE_FAILED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$CartPurchaseStatusEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NOT_PURCHASED = new <init>("NOT_PURCHASED", 0);
        PURCHASED = new <init>("PURCHASED", 1);
        PURCHASE_FAILED = new <init>("PURCHASE_FAILED", 2);
        $VALUES = (new .VALUES[] {
            NOT_PURCHASED, PURCHASED, PURCHASE_FAILED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
