// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui.resources;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.platform.Resources;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;

public class PaymentFormat
{

    public PaymentFormat()
    {
    }

    public static void appendPaymentMethod(PaymentMethod paymentmethod, StringBuffer stringbuffer)
    {
        Resources resources = com.amazon.mShop.platform.Platform.Factory.getInstance().getResources();
        if (paymentmethod.getIssuer() != null)
        {
            stringbuffer.append(paymentmethod.getIssuer());
        }
        if (paymentmethod.getNumber() != null)
        {
            stringbuffer.append(" ***");
            stringbuffer.append(paymentmethod.getNumber());
        }
        if (paymentmethod.getMethod() != null && paymentmethod.getMethod().equals("creditCard") && paymentmethod.getMonth() != null && paymentmethod.getYear() != null)
        {
            if (stringbuffer.length() > 0)
            {
                stringbuffer.append("\n");
            }
            stringbuffer.append(resources.getString(1));
            stringbuffer.append("\240");
            stringbuffer.append(paymentmethod.getMonth());
            stringbuffer.append('/');
            stringbuffer.append(paymentmethod.getYear());
        }
    }

    public static String formatPaymentMethod(PaymentMethod paymentmethod)
    {
        StringBuffer stringbuffer = new StringBuffer(64);
        appendPaymentMethod(paymentmethod, stringbuffer);
        return stringbuffer.toString();
    }
}
