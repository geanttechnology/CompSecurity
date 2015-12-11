// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.widget.Toast;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.ItemResponse;
import com.offerup.android.tracker.a;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class ef
    implements Callback
{

    private MyOffersActivity a;

    private ef(MyOffersActivity myoffersactivity)
    {
        a = myoffersactivity;
        super();
    }

    ef(MyOffersActivity myoffersactivity, byte byte0)
    {
        this(myoffersactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a(true, 4);
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemResponse)obj;
        a.i();
        if (obj != null && ((ItemResponse) (obj)).isSuccess() && ((ItemResponse) (obj)).getItem() != null)
        {
            obj = ((ItemResponse) (obj)).getItem();
            com.offerup.android.tracker.a.a(a, ((Item) (obj)));
            if (!com.offerup.android.c.a.ratingsUseInAppRatings || Integer.valueOf(((Item)a.c.get(MyOffersActivity.d(a))).getDiscussionCount()).intValue() == 0)
            {
                Toast.makeText(a, a.getString(0x7f090187), 1).show();
            }
            MyOffersActivity.g(a);
        }
    }
}
