// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;


// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            CreateCheckoutSessionRequest

private static final class Y extends Enum
{

    private static final EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER $VALUES[];
    public static final EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER;
    public static final EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER;
    public static final EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER;
    public static final EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER;

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/CreateCheckoutSessionRequest$CheckoutFlow, s);
    }

    public static Y[] values()
    {
        return (Y[])$VALUES.clone();
    }

    static 
    {
        EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER = new <init>("EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER", 0);
        EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER = new <init>("EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER", 1);
        EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER = new <init>("EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER", 2);
        EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER = new <init>("EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER", 3);
        $VALUES = (new .VALUES[] {
            EBAY_SVC_BASED_CHECKOUT_FLOW_IDENTIFIER, EBAY_SBC_APP_SUPPORT_XO_FLOW_IDENTIFIER, EBAY_PROGRESSEIV_XO_FLOW_IDENTIFIER, EBAY_PROGRESSEIV_XO_MOBLIE_FLOW_IDENTIFIER
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
