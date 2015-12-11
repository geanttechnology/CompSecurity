// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

public static final class  extends Enum
{

    private static final CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS $VALUES[];
    public static final CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS;
    public static final CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS CHECKOUT_FORM_MODE_CREDIT_CARD;
    public static final CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS CHECKOUT_FORM_MODE_SHIPPING_ADDRESS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CHECKOUT_FORM_MODE_CREDIT_CARD = new <init>("CHECKOUT_FORM_MODE_CREDIT_CARD", 0);
        CHECKOUT_FORM_MODE_SHIPPING_ADDRESS = new <init>("CHECKOUT_FORM_MODE_SHIPPING_ADDRESS", 1);
        CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS = new <init>("CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS", 2);
        $VALUES = (new .VALUES[] {
            CHECKOUT_FORM_MODE_CREDIT_CARD, CHECKOUT_FORM_MODE_SHIPPING_ADDRESS, CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
