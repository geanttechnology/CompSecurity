// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.offerup.android.dto.ItemsResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyArchivedOffersActivity

final class dh
    implements Callback
{

    private MyArchivedOffersActivity a;

    private dh(MyArchivedOffersActivity myarchivedoffersactivity)
    {
        a = myarchivedoffersactivity;
        super();
    }

    dh(MyArchivedOffersActivity myarchivedoffersactivity, byte byte0)
    {
        this(myarchivedoffersactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        if (MyArchivedOffersActivity.b(a) == 1)
        {
            g.c(MyArchivedOffersActivity.d(a), "Error unarchiving a buying item");
        } else
        {
            g.c(MyArchivedOffersActivity.d(a), "Error unarchiving a selling item");
        }
        MyArchivedOffersActivity.e(a);
    }

    public final void success(Object obj, Response response)
    {
        obj = (ItemsResponse)obj;
        a.i();
        MyArchivedOffersActivity.a(a, ((ItemsResponse) (obj)));
    }
}
