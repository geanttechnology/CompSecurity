// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.e.a;
import com.offerup.android.dto.Item;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyArchivedOffersActivity

final class di
    implements Callback
{

    private Item a;
    private MyArchivedOffersActivity b;

    private di(MyArchivedOffersActivity myarchivedoffersactivity, Item item)
    {
        b = myarchivedoffersactivity;
        super();
        a = item;
    }

    di(MyArchivedOffersActivity myarchivedoffersactivity, Item item, byte byte0)
    {
        this(myarchivedoffersactivity, item);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        b.i();
        MyArchivedOffersActivity.c(b);
    }

    public final void success(Object obj, Response response)
    {
        b.i();
        com.offerup.android.activities.MyArchivedOffersActivity.a(b);
        if (MyArchivedOffersActivity.b(b) == 1)
        {
            android.support.v4.e.a.j();
            com.offerup.android.tracker.a.c(b, a);
            return;
        } else
        {
            android.support.v4.e.a.i();
            com.offerup.android.tracker.a.d(b, a);
            return;
        }
    }
}
