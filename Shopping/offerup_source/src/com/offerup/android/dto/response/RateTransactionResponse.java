// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;


// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse, RateTransactionData

public class RateTransactionResponse extends BaseResponse
{

    private RateTransactionData data;

    public RateTransactionResponse()
    {
        data = new RateTransactionData();
    }

    public RateTransactionData getData()
    {
        return data;
    }
}
