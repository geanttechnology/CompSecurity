// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;
import java.util.List;

public class PaymentMethodResponse extends BaseResponse
{

    Data data;

    public PaymentMethodResponse()
    {
    }

    public List getPaymentMethods()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getPaymentMethods();
        }
    }

    private class Data
    {

        List paymentMethods;

        public List getPaymentMethods()
        {
            return paymentMethods;
        }

        public Data()
        {
        }
    }

}
