// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.content.Context;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.data_model.models.inner_models.PaymentInfo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardUtils
{

    public CreditCardUtils()
    {
    }

    public static String getCreditCardType(Context context, String s)
    {
        String s1 = context.getString(0x7f060071);
        String s2 = s.replace(" ", "").replace("-", "'");
        s = Pattern.compile("^4[0-9]{12}(?:[0-9]{3})?$");
        Pattern pattern1 = Pattern.compile("^5[1-5][0-9]{14}$");
        Pattern pattern2 = Pattern.compile("^3[47][0-9]{13}$");
        Pattern pattern = Pattern.compile("^(?:2131|1800|35[0-9]{3})[0-9]{11}$");
        if (s.matcher(s2).matches())
        {
            s = context.getString(0x7f0602c9);
        } else
        {
            if (pattern1.matcher(s2).matches())
            {
                return context.getString(0x7f0601a3);
            }
            if (pattern2.matcher(s2).matches())
            {
                return context.getString(0x7f060041);
            }
            s = s1;
            if (pattern.matcher(s2).matches())
            {
                return context.getString(0x7f0600bd);
            }
        }
        return s;
    }

    public static String getFormattedCreditCardExpirationDate(Context context, CreditCard creditcard)
    {
        getCreditCardType(context, creditcard.getNumber());
        context = creditcard.getExpirationYear();
        int i = context.length();
        byte byte0;
        if (i == 4)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        context = context.substring(byte0, i);
        creditcard = creditcard.getExpirationMonth();
        return (new StringBuilder()).append(creditcard).append("/").append(context).toString();
    }

    public static String getStringFromCreditCard(Context context, CreditCard creditcard)
    {
        String s1 = getCreditCardType(context, creditcard.getNumber());
        String s = creditcard.getExpirationYear();
        int j = s.length();
        String s2;
        String s3;
        int i;
        if (j == 4)
        {
            i = 2;
        } else
        {
            i = 0;
        }
        s2 = s.substring(i, j);
        s3 = creditcard.getExpirationMonth();
        s = creditcard.getNumber();
        i = s.length();
        creditcard = s;
        if (i > 4)
        {
            creditcard = s.substring(i - 4, i);
        }
        creditcard = (new StringBuilder()).append("****").append(creditcard).toString();
        return (new StringBuilder()).append(s1).append(" ").append(context.getString(0x7f0600cd)).append(" ").append(creditcard).append("\n").append(context.getString(0x7f060105)).append(" ").append(s3).append("/").append(s2).toString();
    }

    public static String getStringFromPaymentInfo(Context context, PaymentInfo paymentinfo)
    {
label0:
        {
            if (paymentinfo == null)
            {
                return context.getString(0x7f0601cf);
            }
            String s1 = paymentinfo.getExpiryDate();
            String s;
            if (s1 != null)
            {
                s = s1;
                if (s1.length() != 0)
                {
                    break label0;
                }
            }
            s = Integer.toString(paymentinfo.getExpirationYear());
            int i = s.length();
            byte byte0;
            if (i == 4)
            {
                byte0 = 2;
            } else
            {
                byte0 = 0;
            }
            s = s.substring(byte0, i);
            s1 = Integer.toString(paymentinfo.getExpirationMonth());
            s = (new StringBuilder()).append(s1).append("/").append(s).toString();
        }
        s1 = (new StringBuilder()).append("****").append(paymentinfo.getCreditCardLast4Digits()).toString();
        return (new StringBuilder()).append(paymentinfo.getCreditCardType()).append(" ").append(context.getString(0x7f0600cd)).append(" ").append(s1).append("\n").append(context.getString(0x7f060105)).append(" ").append(s).toString();
    }
}
