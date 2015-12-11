// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

protected static final class  extends Enum
{

    private static final CHANGE_SHIPPING_ADDRESS $VALUES[];
    public static final CHANGE_SHIPPING_ADDRESS CHANGE_CREDIT_CARD_INFO;
    public static final CHANGE_SHIPPING_ADDRESS CHANGE_SHIPPING_ADDRESS;
    public static final CHANGE_SHIPPING_ADDRESS CHECKOUT;
    public static final CHANGE_SHIPPING_ADDRESS GATHER_DETAILS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CHECKOUT = new <init>("CHECKOUT", 0);
        GATHER_DETAILS = new <init>("GATHER_DETAILS", 1);
        CHANGE_CREDIT_CARD_INFO = new <init>("CHANGE_CREDIT_CARD_INFO", 2);
        CHANGE_SHIPPING_ADDRESS = new <init>("CHANGE_SHIPPING_ADDRESS", 3);
        $VALUES = (new .VALUES[] {
            CHECKOUT, GATHER_DETAILS, CHANGE_CREDIT_CARD_INFO, CHANGE_SHIPPING_ADDRESS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
