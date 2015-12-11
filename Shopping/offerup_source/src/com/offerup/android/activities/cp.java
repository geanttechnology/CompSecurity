// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.b.a;
import com.offerup.android.dto.Item;
import com.offerup.android.e.b;
import com.offerup.android.e.d;
import com.squareup.otto.Bus;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            ItemDetailActivity

final class cp
    implements Callback
{

    private ItemDetailActivity a;

    cp(ItemDetailActivity itemdetailactivity)
    {
        a = itemdetailactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        com.offerup.android.b.a.getInstance().post(new b(0x7f09021a, false, ItemDetailActivity.c(a).getId()));
    }

    public final void success(Object obj, Response response)
    {
        ItemDetailActivity.c(a).setWatched(true);
        com.offerup.android.b.a.getInstance().post(new d(ItemDetailActivity.c(a).getId()));
        com.offerup.android.b.a.getInstance().post(new com.offerup.android.e.a(ItemDetailActivity.c(a).getId()));
        com.offerup.android.tracker.a.a(a.getApplicationContext(), a, ItemDetailActivity.c(a));
    }
}
