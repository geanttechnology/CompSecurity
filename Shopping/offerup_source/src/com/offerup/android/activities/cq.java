// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.b.a;
import com.offerup.android.dto.Item;
import com.offerup.android.e.b;
import com.offerup.android.e.d;
import com.offerup.android.e.f;
import com.squareup.otto.Bus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            ItemDetailActivity

final class cq
    implements Callback
{

    private ItemDetailActivity a;

    cq(ItemDetailActivity itemdetailactivity)
    {
        a = itemdetailactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        com.offerup.android.b.a.getInstance().post(new b(0x7f090211, true, ItemDetailActivity.c(a).getId()));
    }

    public final void success(Object obj, Response response)
    {
        ItemDetailActivity.c(a).setWatched(false);
        com.offerup.android.b.a.getInstance().post(new d(ItemDetailActivity.c(a).getId()));
        com.offerup.android.b.a.getInstance().post(new f(ItemDetailActivity.c(a).getId()));
        com.offerup.android.tracker.a.b(a.getApplicationContext(), a, ItemDetailActivity.c(a));
    }
}
