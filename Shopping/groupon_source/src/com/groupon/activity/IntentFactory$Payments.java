// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            IntentFactory

public static final class paymentId extends Enum
{

    private static final GOOGLEWALLET $VALUES[];
    public static final GOOGLEWALLET ALIPAY;
    public static final GOOGLEWALLET AUEASYPAY;
    public static final GOOGLEWALLET DOTPAY;
    public static final GOOGLEWALLET ELV;
    public static final GOOGLEWALLET GOOGLEWALLET;
    public static final GOOGLEWALLET IDEAL;
    public static final GOOGLEWALLET IPAY88;
    public static final GOOGLEWALLET ISRACARD;
    public static final GOOGLEWALLET MAESTRO;
    public static final GOOGLEWALLET MAESTROUK;
    public static final GOOGLEWALLET MASTERCARDPE;
    public static final GOOGLEWALLET MDEBITCL;
    public static final GOOGLEWALLET MONECLICKCL;
    public static final GOOGLEWALLET MWEBPAYCL;
    public static final GOOGLEWALLET PAYPAL;
    public static final GOOGLEWALLET PAYPALMX;
    public static final GOOGLEWALLET PSEMOBILECO;
    public static final GOOGLEWALLET SEPADIRECTDEBIT;
    public static final GOOGLEWALLET VISANETPE;
    private final String paymentId;
    private final String paymentType;

    public static paymentId paymentValueOf(String s)
    {
        try
        {
            s = valueOf(s.toUpperCase().replaceAll("-", ""));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static valueOf valueOf(String s)
    {
        return (valueOf)Enum.valueOf(com/groupon/activity/IntentFactory$Payments, s);
    }

    public static valueOf[] values()
    {
        return (valueOf[])$VALUES.clone();
    }

    public String getPaymentId()
    {
        return paymentId;
    }

    public String getPaymentType()
    {
        return paymentType;
    }

    static 
    {
        IDEAL = new <init>("IDEAL", 0, "ECommerce", "ideal");
        PAYPAL = new <init>("PAYPAL", 1, "ECommerce", "paypal");
        PAYPALMX = new <init>("PAYPALMX", 2, "ECommerce", "paypal-mx");
        IPAY88 = new <init>("IPAY88", 3, "ECommerce", "ipay88");
        DOTPAY = new <init>("DOTPAY", 4, "ECommerce", "dotpay");
        MAESTRO = new <init>("MAESTRO", 5, "CreditCard", "maestro");
        MAESTROUK = new <init>("MAESTROUK", 6, "CreditCard", "maestrouk");
        ELV = new <init>("ELV", 7, "CreditCard", "elv");
        ISRACARD = new <init>("ISRACARD", 8, "CreditCard", "isracard");
        SEPADIRECTDEBIT = new <init>("SEPADIRECTDEBIT", 9, "CreditCard", "sepadirectdebit");
        AUEASYPAY = new <init>("AUEASYPAY", 10, "ECommerce", "auEasyPay");
        MONECLICKCL = new <init>("MONECLICKCL", 11, "ECommerce", "m-oneclick-cl");
        MDEBITCL = new <init>("MDEBITCL", 12, "ECommerce", "m-debit-cl");
        MWEBPAYCL = new <init>("MWEBPAYCL", 13, "ECommerce", "m-webpay-cl");
        PSEMOBILECO = new <init>("PSEMOBILECO", 14, "ECommerce", "pse-mobile-co");
        VISANETPE = new <init>("VISANETPE", 15, "ECommerce", "visanet-pe");
        MASTERCARDPE = new <init>("MASTERCARDPE", 16, "ECommerce", "mastercard-pe");
        ALIPAY = new <init>("ALIPAY", 17, "ECommerce", "alipay");
        GOOGLEWALLET = new <init>("GOOGLEWALLET", 18, "ECommerce", "google-wallet");
        $VALUES = (new .VALUES[] {
            IDEAL, PAYPAL, PAYPALMX, IPAY88, DOTPAY, MAESTRO, MAESTROUK, ELV, ISRACARD, SEPADIRECTDEBIT, 
            AUEASYPAY, MONECLICKCL, MDEBITCL, MWEBPAYCL, PSEMOBILECO, VISANETPE, MASTERCARDPE, ALIPAY, GOOGLEWALLET
        });
    }

    private (String s, int i, String s1, String s2)
    {
        super(s, i);
        paymentType = s1;
        paymentId = s2;
    }
}
