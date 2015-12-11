// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.offerup.android.b.a;
import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.network.c;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity, dy

final class eb extends AsyncTask
{

    private Context a;
    private MyOffersActivity b;

    public eb(MyOffersActivity myoffersactivity, Context context)
    {
        b = myoffersactivity;
        super();
        a = context;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return c.a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (DiscussionsResponse)obj;
        b.i();
        com.offerup.android.b.a.getInstance().post(new dy(((DiscussionsResponse) (obj)), (byte)0));
    }

    protected final void onPreExecute()
    {
        if (b.a == 1)
        {
            b.g = ProgressDialog.show(a, "", "Loading Offers ...");
        }
    }
}
