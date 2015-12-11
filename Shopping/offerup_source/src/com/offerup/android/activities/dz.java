// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.widget.Toast;
import com.offerup.android.dto.Item;
import com.offerup.android.g.ad;
import com.offerup.android.tracker.a;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class dz
    implements Callback
{

    private MyOffersActivity a;

    private dz(MyOffersActivity myoffersactivity)
    {
        a = myoffersactivity;
        super();
    }

    dz(MyOffersActivity myoffersactivity, byte byte0)
    {
        this(myoffersactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        Toast.makeText(a, "Error deleting item.", 1).show();
    }

    public final void success(Object obj, Response response)
    {
        a.i();
        obj = (Item)a.c.get(MyOffersActivity.d(a));
        a.c.remove(MyOffersActivity.d(a));
        a.b.a(a.c);
        com.offerup.android.tracker.a.b(a, ((Item) (obj)));
        Toast.makeText(a, "Item deleted.", 1).show();
    }
}
