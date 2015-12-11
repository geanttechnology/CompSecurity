// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.widget.Toast;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.ItemResponse;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class eg
    implements Callback
{

    private int a;
    private MyOffersActivity b;

    public eg(MyOffersActivity myoffersactivity, int i)
    {
        b = myoffersactivity;
        super();
        a = i;
    }

    public final void failure(RetrofitError retrofiterror)
    {
        b.i();
        b.a(true, a);
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemResponse)obj;
        b.i();
        if (((ItemResponse) (obj)).getItem().getState() == 2)
        {
            b.c.remove(MyOffersActivity.d(b));
        }
        Toast.makeText(b, "Offer updated successfully.", 1).show();
        MyOffersActivity.g(b);
    }
}
