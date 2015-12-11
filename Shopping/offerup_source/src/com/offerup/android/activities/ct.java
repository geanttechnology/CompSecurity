// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.Item;
import com.offerup.android.dto.ItemResponse;
import com.offerup.android.tracker.ItemDetailUserInteractionRecord;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            ItemDetailActivity

final class ct
    implements Callback
{

    private ItemDetailActivity a;

    ct(ItemDetailActivity itemdetailactivity)
    {
        a = itemdetailactivity;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        ItemDetailActivity.a(a, retrofiterror.getMessage());
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemResponse)obj;
        if (((ItemResponse) (obj)).isSuccess())
        {
            ItemDetailActivity.a(a, ((ItemResponse) (obj)).getItem());
            obj = ItemDetailActivity.d(a);
            int i;
            if (ItemDetailActivity.c(a).getPhotos() != null)
            {
                i = ItemDetailActivity.c(a).getPhotos().length;
            } else
            {
                i = 0;
            }
            ((ItemDetailUserInteractionRecord) (obj)).b(i);
            ItemDetailActivity.e(a);
            return;
        } else
        {
            ItemDetailActivity.a(a, "Unable to get item from the ItemResponse");
            return;
        }
    }
}
