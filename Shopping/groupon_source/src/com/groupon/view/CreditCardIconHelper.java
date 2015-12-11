// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.service.BillingService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import roboguice.util.Strings;

public class CreditCardIconHelper
{
    public static class CreditCardIconData
    {

        public int largeId;
        public int paymentIcon;
        public int redesignedId;
        public int redesignedSmallId;
        public int smallId;

        public CreditCardIconData(int i, int j, int k, int l, int i1)
        {
            smallId = i;
            largeId = j;
            redesignedId = k;
            paymentIcon = l;
            redesignedSmallId = i1;
        }
    }

    public static final class IconType extends Enum
    {

        private static final IconType $VALUES[];
        public static final IconType LARGE;
        public static final IconType PAYMENT_ICON;
        public static final IconType REDESIGNED;
        public static final IconType REDESIGNED_SMALL;
        public static final IconType SMALL;

        public static IconType valueOf(String s)
        {
            return (IconType)Enum.valueOf(com/groupon/view/CreditCardIconHelper$IconType, s);
        }

        public static IconType[] values()
        {
            return (IconType[])$VALUES.clone();
        }

        static 
        {
            SMALL = new IconType("SMALL", 0);
            LARGE = new IconType("LARGE", 1);
            REDESIGNED = new IconType("REDESIGNED", 2);
            PAYMENT_ICON = new IconType("PAYMENT_ICON", 3);
            REDESIGNED_SMALL = new IconType("REDESIGNED_SMALL", 4);
            $VALUES = (new IconType[] {
                SMALL, LARGE, REDESIGNED, PAYMENT_ICON, REDESIGNED_SMALL
            });
        }

        private IconType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final Map cardTypes;
    public static final Map supportedCardTypes;

    public CreditCardIconHelper()
    {
    }

    public static void createCreditCardIcon(BillingRecord billingrecord, ImageView imageview)
    {
        if (Strings.notEmpty(billingrecord.cardType))
        {
            billingrecord = billingrecord.cardType;
        } else
        {
            billingrecord = null;
        }
        imageview.setImageResource(getCreditCardIcon(billingrecord));
    }

    public static void createCreditCardIcon(BillingRecord billingrecord, TextView textview, IconType icontype)
    {
        String s1 = BillingService.getPaymentOrCardTypeId(billingrecord);
        String s = s1;
        if (s1 == null)
        {
            s = billingrecord.cardType;
            if (!Strings.notEmpty(s))
            {
                s = null;
            }
        }
        createCreditCardIcon(s, ((View) (textview)), icontype);
        icontype = billingrecord.cardNumber;
        if (Strings.notEmpty(icontype))
        {
            if (Strings.equalsIgnoreCase(billingrecord.paymentType, "elv"))
            {
                billingrecord = icontype.substring(0, Math.min(icontype.length(), 4));
            } else
            {
                billingrecord = icontype.substring(Math.max(0, icontype.length() - 4));
            }
            textview.setText(billingrecord);
        }
    }

    public static void createCreditCardIcon(String s, View view, IconType icontype)
    {
        int i = -1;
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$view$CreditCardIconHelper$IconType[];

            static 
            {
                $SwitchMap$com$groupon$view$CreditCardIconHelper$IconType = new int[IconType.values().length];
                try
                {
                    $SwitchMap$com$groupon$view$CreditCardIconHelper$IconType[IconType.SMALL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$view$CreditCardIconHelper$IconType[IconType.LARGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$view$CreditCardIconHelper$IconType[IconType.REDESIGNED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.groupon.view.CreditCardIconHelper.IconType[icontype.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 131
    //                   2 138
    //                   3 145;
           goto _L1 _L2 _L3 _L4
_L1:
        int j = i;
        if (!Strings.notEmpty(s)) goto _L6; else goto _L5
_L5:
        j = i;
        if (!cardTypes.containsKey(s)) goto _L6; else goto _L7
_L7:
        s = (CreditCardIconData)cardTypes.get(s);
        j = i;
        if (s == null) goto _L6; else goto _L8
_L8:
        _cls1..SwitchMap.com.groupon.view.CreditCardIconHelper.IconType[icontype.ordinal()];
        JVM INSTR tableswitch 1 3: default 116
    //                   1 152
    //                   2 161
    //                   3 170;
           goto _L9 _L10 _L11 _L12
_L12:
        break MISSING_BLOCK_LABEL_170;
_L9:
        j = i;
_L6:
        if (j > 0)
        {
            view.setBackgroundResource(j);
        }
        return;
_L2:
        i = 0x7f0200bc;
          goto _L1
_L3:
        i = 0x7f0200b9;
          goto _L1
_L4:
        i = 0x7f0200ba;
          goto _L1
_L10:
        j = ((CreditCardIconData) (s)).smallId;
          goto _L6
_L11:
        j = ((CreditCardIconData) (s)).largeId;
          goto _L6
        j = ((CreditCardIconData) (s)).redesignedId;
          goto _L6
    }

    public static void createCreditCardIcon(String s, ImageView imageview)
    {
        imageview.setImageResource(getCreditCardIcon(s));
    }

    public static int getCreditCardIcon(String s)
    {
        int j = 0x7f0200bb;
        int i = j;
        if (Strings.notEmpty(s))
        {
            i = j;
            if (cardTypes.containsKey(s))
            {
                s = (CreditCardIconData)cardTypes.get(s);
                i = j;
                if (s != null)
                {
                    i = ((CreditCardIconData) (s)).redesignedSmallId;
                }
            }
        }
        return i;
    }

    public static CreditCardIconData getCreditCardIconData(String s)
    {
        return (CreditCardIconData)cardTypes.get(s);
    }

    static 
    {
        cardTypes = new HashMap();
        cardTypes.put("master", new CreditCardIconData(0x7f0200dd, 0x7f0200db, 0x7f0200dc, 0x7f0202aa, 0x7f0200d9));
        cardTypes.put("visa", new CreditCardIconData(0x7f0200e8, 0x7f0200e5, 0x7f0200e6, 0x7f0202ab, 0x7f0200e7));
        cardTypes.put("discover", new CreditCardIconData(0x7f0200c0, 0x7f0200bd, 0x7f0200be, 0x7f0202a9, 0x7f0200bf));
        cardTypes.put("american_express", new CreditCardIconData(0x7f0200b6, 0x7f0200b3, 0x7f0200b4, 0x7f0202a8, 0x7f0200b5));
        cardTypes.put("amex", new CreditCardIconData(0x7f0200b6, 0x7f0200b3, 0x7f0200b4, 0x7f0202a8, 0x7f0200b5));
        cardTypes.put("paypal", new CreditCardIconData(0x7f0202ad, 0x7f0202ac, 0x7f0202ae, -1, 0x7f0200de));
        cardTypes.put("ideal", new CreditCardIconData(0x7f020235, 0x7f020234, 0x7f020236, -1, 0x7f0200ce));
        cardTypes.put("maestro", new CreditCardIconData(0x7f0200d8, 0x7f0200d5, 0x7f0200d6, -1, 0x7f0200d7));
        cardTypes.put("maestrouk", new CreditCardIconData(0x7f0200d8, 0x7f0200d5, 0x7f0200d6, -1, 0x7f0200d7));
        cardTypes.put("elv", new CreditCardIconData(0x7f0200c6, 0x7f0200c3, 0x7f0200c4, -1, 0x7f0200c5));
        cardTypes.put("isracard", new CreditCardIconData(0x7f0200d3, 0x7f0200d0, 0x7f0200d1, -1, 0x7f0200d2));
        cardTypes.put("sepadirectdebit", new CreditCardIconData(0x7f0200e4, 0x7f0200e1, 0x7f0200e2, -1, 0x7f0200e3));
        cardTypes.put("dotpay", new CreditCardIconData(0x7f020159, 0x7f020159, 0x7f020159, -1, 0x7f0200c1));
        cardTypes.put("ipay88", new CreditCardIconData(0x7f02023e, 0x7f02023e, 0x7f02023f, -1, 0x7f0200cf));
        cardTypes.put("ideal", new CreditCardIconData(0x7f020233, 0x7f020233, 0x7f020236, -1, 0x7f0200ce));
        cardTypes.put("auEasyPay", new CreditCardIconData(0x7f0200b7, 0x7f0200b7, 0x7f0200b8, -1, 0x7f0200c2));
        cardTypes.put("m-oneclick-cl", new CreditCardIconData(0x7f0202a2, 0x7f0202a2, 0x7f0202a2, -1, 0x7f0200eb));
        cardTypes.put("m-debit-cl", new CreditCardIconData(0x7f0202ca, 0x7f0202ca, 0x7f0202ca, -1, 0x7f0200e9));
        cardTypes.put("m-webpay-cl", new CreditCardIconData(0x7f020328, 0x7f020328, 0x7f020328, -1, 0x7f0200ea));
        cardTypes.put("mastercard", new CreditCardIconData(0x7f0200da, 0x7f0200da, 0x7f0200da, -1, 0x7f0200da));
        cardTypes.put("pse-mobile-co", new CreditCardIconData(0x7f0200df, 0x7f0200df, 0x7f0200df, -1, 0x7f0200df));
        cardTypes.put("visanet-pe", new CreditCardIconData(0x7f0200e8, 0x7f0200e5, 0x7f0200e6, 0x7f0202ab, 0x7f0200e7));
        cardTypes.put("mastercard-pe", new CreditCardIconData(0x7f0200da, 0x7f0200da, 0x7f0200da, -1, 0x7f0200da));
        cardTypes.put("alipay", new CreditCardIconData(0x7f0200b1, 0x7f0200b1, 0x7f0200b1, -1, 0x7f0200b1));
        cardTypes.put("google-wallet", new CreditCardIconData(-1, -1, 0x7f0200c8, -1, 0x7f0200c7));
        HashMap hashmap = new HashMap(20);
        hashmap.put("amex", Integer.valueOf(0x7f020215));
        hashmap.put("american express", Integer.valueOf(0x7f020215));
        hashmap.put("argencard", Integer.valueOf(0x7f020216));
        hashmap.put("cabal", Integer.valueOf(0x7f020217));
        hashmap.put("diners club", Integer.valueOf(0x7f020218));
        hashmap.put("discover", Integer.valueOf(0x7f020219));
        hashmap.put("hipercard", Integer.valueOf(0x7f02021a));
        hashmap.put("italcred", Integer.valueOf(0x7f02021b));
        hashmap.put("jcb", Integer.valueOf(0x7f02021c));
        hashmap.put("mastercard", Integer.valueOf(0x7f02021d));
        hashmap.put("naranja", Integer.valueOf(0x7f02021e));
        hashmap.put("visa", Integer.valueOf(0x7f02021f));
        hashmap.put("ideal", Integer.valueOf(0x7f020236));
        hashmap.put("maestro", Integer.valueOf(0x7f0200d6));
        hashmap.put("maestrouk", Integer.valueOf(0x7f0200d6));
        hashmap.put("elv", Integer.valueOf(0x7f0200c4));
        hashmap.put("isracard", Integer.valueOf(0x7f0200d1));
        hashmap.put("sepadirectdebit", Integer.valueOf(0x7f0200e2));
        hashmap.put("paypal", Integer.valueOf(0x7f0202ae));
        hashmap.put("ipay88", Integer.valueOf(0x7f02023f));
        hashmap.put("auEasyPay", Integer.valueOf(0x7f0200b8));
        supportedCardTypes = Collections.unmodifiableMap(hashmap);
    }
}
