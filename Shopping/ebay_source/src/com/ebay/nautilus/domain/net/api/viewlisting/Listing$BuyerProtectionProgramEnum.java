// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final EBAY_VEHICLE_PURCHASE_PROTECTION $VALUES[];
    public static final EBAY_VEHICLE_PURCHASE_PROTECTION EBAY_BUYER_PROTECTION;
    public static final EBAY_VEHICLE_PURCHASE_PROTECTION EBAY_VEHICLE_PURCHASE_PROTECTION;
    public static final EBAY_VEHICLE_PURCHASE_PROTECTION PAYPAL_BUYER_PROTECTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$BuyerProtectionProgramEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EBAY_BUYER_PROTECTION = new <init>("EBAY_BUYER_PROTECTION", 0);
        PAYPAL_BUYER_PROTECTION = new <init>("PAYPAL_BUYER_PROTECTION", 1);
        EBAY_VEHICLE_PURCHASE_PROTECTION = new <init>("EBAY_VEHICLE_PURCHASE_PROTECTION", 2);
        $VALUES = (new .VALUES[] {
            EBAY_BUYER_PROTECTION, PAYPAL_BUYER_PROTECTION, EBAY_VEHICLE_PURCHASE_PROTECTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
