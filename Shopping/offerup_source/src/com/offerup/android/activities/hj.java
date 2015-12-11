// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.response.RateTransactionData;
import com.offerup.android.dto.response.RateTransactionResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            SelectBuyerActivity

final class hj
    implements Callback
{

    private SelectBuyerActivity a;

    private hj(SelectBuyerActivity selectbuyeractivity)
    {
        a = selectbuyeractivity;
        super();
    }

    hj(SelectBuyerActivity selectbuyeractivity, byte byte0)
    {
        this(selectbuyeractivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a(a.getString(0x7f09017d), a.getString(0x7f09017b));
    }

    public final void success(Object obj, Response response)
    {
        obj = (RateTransactionResponse)obj;
        a.i();
        if (((RateTransactionResponse) (obj)).isSuccess())
        {
            obj = ((RateTransactionResponse) (obj)).getData().getListOfInterestedBuyers();
            SelectBuyerActivity.a(a, ((java.util.ArrayList) (obj)));
            return;
        } else
        {
            a.a(a.getString(0x7f09017d), a.getString(0x7f09017b));
            return;
        }
    }
}
