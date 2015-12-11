// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import com.offerup.android.dto.response.BaseResponse;

// Referenced classes of package com.offerup.android.dto:
//            BuyRequest

public class OfferResponse extends BaseResponse
{

    Data data;

    public OfferResponse()
    {
    }

    public BuyRequest getBuyRequest()
    {
        return data.getBuyRequest();
    }

    private class Data
    {

        BuyRequest buyRequest;

        public BuyRequest getBuyRequest()
        {
            return buyRequest;
        }

        public Data()
        {
        }
    }

}
