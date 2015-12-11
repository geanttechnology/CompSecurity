// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.res.Resources;
import android.support.v4.e.a;
import android.widget.Toast;
import com.b.a.a.j;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            RatingActivity, a

final class gq
    implements Callback
{

    private boolean a;
    private int b;
    private RatingActivity c;

    public gq(RatingActivity ratingactivity, boolean flag, int i)
    {
        c = ratingactivity;
        super();
        a = flag;
        b = i;
    }

    public final void failure(RetrofitError retrofiterror)
    {
        c.i();
        c.a(c.getString(0x7f09017d), c.getString(0x7f09017b));
    }

    public final void success(Object obj, Response response)
    {
        c.i();
        android.support.v4.e.a.i();
        if (a)
        {
            com.offerup.android.tracker.a.a(j.a().n(), RatingActivity.c(c).getId());
            Toast.makeText(c.getApplicationContext(), c.getResources().getString(0x7f0900d9), 1).show();
        } else
        if (RatingActivity.b(c))
        {
            com.offerup.android.tracker.a.a("ou_rate_buyer_submit", RatingActivity.d(c).getId(), RatingActivity.c(c).getId(), b);
            Toast.makeText(c.getApplicationContext(), c.getResources().getString(0x7f0901de), 1).show();
        } else
        {
            com.offerup.android.tracker.a.a("ou_rate_seller_submit", j.a().n(), RatingActivity.c(c).getId(), b);
            Toast.makeText(c.getApplicationContext(), c.getResources().getString(0x7f0900d8), 1).show();
        }
        c.setResult(-1);
        if (RatingActivity.e(c))
        {
            com.offerup.android.activities.RatingActivity.a(c, false);
            c.f.d();
        }
        c.finish();
    }
}
