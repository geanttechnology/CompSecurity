// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final SELLER_RIGHT_TO_RETURN $VALUES[];
    public static final SELLER_RIGHT_TO_RETURN BUYER;
    public static final SELLER_RIGHT_TO_RETURN BUYER_PAYS_CONDITIONALLY;
    public static final SELLER_RIGHT_TO_RETURN SELLER;
    public static final SELLER_RIGHT_TO_RETURN SELLER_RIGHT_TO_CANCEL;
    public static final SELLER_RIGHT_TO_RETURN SELLER_RIGHT_TO_RETURN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ReturnShipmentPayeeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BUYER = new <init>("BUYER", 0);
        SELLER = new <init>("SELLER", 1);
        BUYER_PAYS_CONDITIONALLY = new <init>("BUYER_PAYS_CONDITIONALLY", 2);
        SELLER_RIGHT_TO_CANCEL = new <init>("SELLER_RIGHT_TO_CANCEL", 3);
        SELLER_RIGHT_TO_RETURN = new <init>("SELLER_RIGHT_TO_RETURN", 4);
        $VALUES = (new .VALUES[] {
            BUYER, SELLER, BUYER_PAYS_CONDITIONALLY, SELLER_RIGHT_TO_CANCEL, SELLER_RIGHT_TO_RETURN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
