// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;

// Referenced classes of package com.offerup.android.dto:
//            PaymentMethod

public class AddCardResponse extends BaseResponse
{

    Data data;

    public AddCardResponse()
    {
    }

    public PaymentMethod getPaymentMethod()
    {
        if (data == null)
        {
            return null;
        } else
        {
            return data.getPaymentMethod();
        }
    }

    private class Data
    {

        PaymentMethod paymentMethod;
        final AddCardResponse this$0;

        public PaymentMethod getPaymentMethod()
        {
            return paymentMethod;
        }

        public Data()
        {
            this$0 = AddCardResponse.this;
            super();
        }
    }

}
