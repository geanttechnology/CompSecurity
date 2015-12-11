// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.dto.Item;
import com.offerup.android.tracker.a;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class dx
    implements Callback
{

    private Item a;
    private MyOffersActivity b;

    private dx(MyOffersActivity myoffersactivity, Item item)
    {
        b = myoffersactivity;
        super();
        a = item;
    }

    dx(MyOffersActivity myoffersactivity, Item item, byte byte0)
    {
        this(myoffersactivity, item);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        b.i();
        if (b.a == 1)
        {
            g.c(MyOffersActivity.h(b), "Error archiving a buying item");
        } else
        {
            g.c(MyOffersActivity.h(b), "Error archiving a selling item");
        }
        MyOffersActivity.i(b);
    }

    public final void success(Object obj, Response response)
    {
        b.i();
        obj = j.a();
        if (!((j) (obj)).y())
        {
            ((j) (obj)).i(true);
            b.supportInvalidateOptionsMenu();
        }
        com.offerup.android.activities.MyOffersActivity.g(b);
        if (b.a == 1)
        {
            com.offerup.android.tracker.a.a(b, a);
            return;
        } else
        {
            com.offerup.android.tracker.a.b(b, a);
            return;
        }
    }
}
