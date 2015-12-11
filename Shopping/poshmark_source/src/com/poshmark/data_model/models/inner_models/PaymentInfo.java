// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;

import java.math.BigDecimal;

// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            BrainTreePayment, CCInfo, PayAmount

public class PaymentInfo
{

    private BigDecimal amount;
    private BrainTreePayment braintree_payment;
    private CCInfo cc_info;
    private String cc_token;
    private PayAmount pay_amount;
    private String type;

    public PaymentInfo()
    {
    }

    public void copy(PaymentInfo paymentinfo)
    {
    }

    public String getBrainTreeToken()
    {
        if (braintree_payment != null)
        {
            return braintree_payment.cc_token;
        }
        if (cc_info != null)
        {
            return cc_info.cc_token;
        } else
        {
            return null;
        }
    }

    public String getCreditCardLast4Digits()
    {
        if (braintree_payment != null)
        {
            return braintree_payment.getLast4Digits();
        }
        if (cc_info != null)
        {
            return cc_info.last_4;
        } else
        {
            return null;
        }
    }

    public String getCreditCardType()
    {
        if (braintree_payment != null)
        {
            return braintree_payment.getCCType();
        }
        if (cc_info != null)
        {
            return cc_info.cc_type;
        } else
        {
            return null;
        }
    }

    public int getExpirationMonth()
    {
        if (braintree_payment != null)
        {
            return braintree_payment.getExpirationMonth();
        }
        if (cc_info != null)
        {
            return Integer.parseInt(cc_info.expiration_month);
        } else
        {
            return 0;
        }
    }

    public int getExpirationYear()
    {
        if (braintree_payment != null)
        {
            return braintree_payment.getExpirationYear();
        }
        if (cc_info != null)
        {
            return Integer.parseInt(cc_info.expiration_year);
        } else
        {
            return 0;
        }
    }

    public String getExpiryDate()
    {
        return null;
    }

    public String getPaymentType()
    {
        return type;
    }

    public boolean isDataAvailable()
    {
        return braintree_payment != null || cc_info != null;
    }
}
