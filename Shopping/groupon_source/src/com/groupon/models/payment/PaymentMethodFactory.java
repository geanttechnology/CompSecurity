// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.content.Context;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ArraySharedPreferences;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.models.payment:
//            CreditCardPaymentMethod, MaestroPaymentMethod, ElvPaymentMethod, SepaPaymentMethod, 
//            IsracardPaymentMethod, GoogleWalletPaymentMethod, PayPalPaymentMethod, DotPayPaymentMethod, 
//            IPay88PaymentMethod, IDealPaymentMethod, JPAUEasyPayPaymentMethod, OneClickPaymentMethod, 
//            RedcompraPaymentMethod, WebPayPaymentMethod, VisaPePaymentMethod, MastercardPePaymentMethod, 
//            PsePaymentMethod, AlipayPaymentMethod, AbstractPaymentMethod

public class PaymentMethodFactory
{

    private Activity activity;
    private ConsumerDeviceSettings consumerDeviceSettings;
    private Context context;
    private CurrentCountryManager currentCountryManager;
    private ArraySharedPreferences loginPrefs;
    private String referrer;

    public PaymentMethodFactory()
    {
    }

    public AbstractPaymentMethod createCreditCardPaymentMethod(BillingRecord billingrecord, Deal deal, Option option, int i, boolean flag)
    {
        String s;
        s = billingrecord.paymentType;
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$activity$IntentFactory$Payments[];

            static 
            {
                $SwitchMap$com$groupon$activity$IntentFactory$Payments = new int[com.groupon.activity.IntentFactory.Payments.values().length];
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.MAESTRO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.MAESTROUK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.ELV.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.SEPADIRECTDEBIT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.ISRACARD.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.GOOGLEWALLET.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.PAYPAL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.PAYPALMX.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.DOTPAY.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.IPAY88.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.IDEAL.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.AUEASYPAY.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.MONECLICKCL.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.MDEBITCL.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.MWEBPAYCL.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.VISANETPE.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.MASTERCARDPE.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.PSEMOBILECO.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$activity$IntentFactory$Payments[com.groupon.activity.IntentFactory.Payments.ALIPAY.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.groupon.activity.IntentFactory.Payments payments;
        if (!Strings.notEmpty(s))
        {
            s = billingrecord.cardType;
        }
        if (!currentCountryManager.getCurrentCountry().acceptsPayment(s)) goto _L2; else goto _L1
_L1:
        payments = com.groupon.activity.IntentFactory.Payments.paymentValueOf(s);
        if (payments == null) goto _L2; else goto _L3
_L3:
        _cls1..SwitchMap.com.groupon.activity.IntentFactory.Payments[payments.ordinal()];
        JVM INSTR tableswitch 1 6: default 88
    //                   1 128
    //                   2 128
    //                   3 168
    //                   4 199
    //                   5 230
    //                   6 261;
           goto _L2 _L4 _L4 _L5 _L6 _L7 _L8
_L2:
        return new CreditCardPaymentMethod(billingrecord, activity, context, loginPrefs, deal, option, i, flag, referrer);
_L4:
        return new MaestroPaymentMethod(billingrecord, activity, context, loginPrefs, consumerDeviceSettings.getUserAgent(), deal, option, i, flag, referrer, s);
_L5:
        return new ElvPaymentMethod(billingrecord, activity, context, loginPrefs, deal, option, i, flag, referrer);
_L6:
        return new SepaPaymentMethod(billingrecord, activity, context, loginPrefs, deal, option, i, flag, referrer);
_L7:
        return new IsracardPaymentMethod(billingrecord, activity, context, loginPrefs, deal, option, i, flag, referrer);
_L8:
        return new GoogleWalletPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer);
    }

    public AbstractPaymentMethod createGoogleWalletPaymentMethod(Deal deal, Option option, int i, boolean flag)
    {
        if (currentCountryManager.getCurrentCountry().acceptsPayment("google-wallet"))
        {
            return new GoogleWalletPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer);
        } else
        {
            return null;
        }
    }

    public AbstractPaymentMethod createPaymentMethod(Deal deal, Option option, int i, boolean flag)
    {
        return new CreditCardPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer);
    }

    public AbstractPaymentMethod createPaymentMethod(BillingRecord billingrecord)
    {
        return createCreditCardPaymentMethod(billingrecord, null, null, 0, false);
    }

    public AbstractPaymentMethod createPaymentMethod(BillingRecord billingrecord, Deal deal, Option option, int i, boolean flag)
    {
        return createCreditCardPaymentMethod(billingrecord, deal, option, i, flag);
    }

    public AbstractPaymentMethod createPaymentMethod(String s)
    {
        return createPaymentMethod(s, null, null, 0, false);
    }

    public AbstractPaymentMethod createPaymentMethod(String s, Deal deal, Option option, int i, boolean flag)
    {
        if (!currentCountryManager.getCurrentCountry().acceptsPayment(s)) goto _L2; else goto _L1
_L1:
        com.groupon.activity.IntentFactory.Payments payments = com.groupon.activity.IntentFactory.Payments.paymentValueOf(s);
        if (payments == null) goto _L2; else goto _L3
_L3:
        _cls1..SwitchMap.com.groupon.activity.IntentFactory.Payments[payments.ordinal()];
        JVM INSTR tableswitch 1 19: default 124
    //                   1 249
    //                   2 249
    //                   3 280
    //                   4 311
    //                   5 342
    //                   6 124
    //                   7 126
    //                   8 126
    //                   9 157
    //                   10 187
    //                   11 219
    //                   12 373
    //                   13 403
    //                   14 435
    //                   15 467
    //                   16 499
    //                   17 531
    //                   18 563
    //                   19 595;
           goto _L2 _L4 _L4 _L5 _L6 _L7 _L2 _L8 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L2:
        return null;
_L8:
        return new PayPalPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, s);
_L9:
        return new DotPayPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer);
_L10:
        return new IPay88PaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "ipay88");
_L11:
        return new IDealPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer);
_L4:
        return new MaestroPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, s);
_L5:
        return new ElvPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, s);
_L6:
        return new SepaPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, s);
_L7:
        return new IsracardPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, s);
_L12:
        return new JPAUEasyPayPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer);
_L13:
        return new OneClickPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "m-oneclick-cl");
_L14:
        return new RedcompraPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "m-debit-cl");
_L15:
        return new WebPayPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "m-webpay-cl");
_L16:
        return new VisaPePaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "visanet-pe");
_L17:
        return new MastercardPePaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "mastercard-pe");
_L18:
        return new PsePaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "pse-mobile-co");
_L19:
        return new AlipayPaymentMethod(activity, context, loginPrefs, deal, option, i, flag, referrer, "alipay");
    }
}
