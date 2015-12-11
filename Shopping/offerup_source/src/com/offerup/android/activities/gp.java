// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.ItemResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            RatingActivity

final class gp
    implements Callback
{

    private RatingActivity a;

    private gp(RatingActivity ratingactivity)
    {
        a = ratingactivity;
        super();
    }

    gp(RatingActivity ratingactivity, byte byte0)
    {
        this(ratingactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        RatingActivity.a(a, retrofiterror.getMessage());
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemResponse)obj;
        a.i();
        if (((ItemResponse) (obj)).isSuccess())
        {
            RatingActivity.a(a, ((ItemResponse) (obj)).getItem());
            RatingActivity.f(a);
            return;
        } else
        {
            RatingActivity.a(a, "Unable to get item from the ItemResponse");
            return;
        }
    }
}
