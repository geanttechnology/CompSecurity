// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.ItemsResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class dj
    implements Callback
{

    private MyOffersActivity a;

    dj(MyOffersActivity myoffersactivity)
    {
        a = myoffersactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        MyOffersActivity.a(a, retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemsResponse)obj;
        MyOffersActivity.a(a, ((ItemsResponse) (obj)).getItems());
    }
}
