// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.res.Resources;
import android.support.v4.e.a;
import android.widget.Toast;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            SelectBuyerActivity

final class hi
    implements Callback
{

    private SelectBuyerActivity a;

    private hi(SelectBuyerActivity selectbuyeractivity)
    {
        a = selectbuyeractivity;
        super();
    }

    hi(SelectBuyerActivity selectbuyeractivity, byte byte0)
    {
        this(selectbuyeractivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a(a.getString(0x7f09017d), a.getString(0x7f09017b));
    }

    public final void success(Object obj, Response response)
    {
        a.i();
        android.support.v4.e.a.i();
        Toast.makeText(a, a.getResources().getString(0x7f0901d3), 1).show();
        a.finish();
    }
}
