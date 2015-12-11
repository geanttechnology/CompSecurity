// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.b.a.a.g;
import com.offerup.android.b.a;
import com.offerup.android.dto.response.UserWatchlistResponse;
import com.offerup.android.network.t;
import com.squareup.otto.Bus;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity, eh

final class ec extends AsyncTask
{

    private Context a;
    private MyOffersActivity b;

    private ec(MyOffersActivity myoffersactivity, Context context)
    {
        b = myoffersactivity;
        super();
        a = context;
    }

    ec(MyOffersActivity myoffersactivity, Context context, byte byte0)
    {
        this(myoffersactivity, context);
    }

    private transient UserWatchlistResponse a()
    {
        UserWatchlistResponse userwatchlistresponse;
        try
        {
            userwatchlistresponse = t.a();
        }
        catch (Exception exception)
        {
            g.c(getClass().getName(), Log.getStackTraceString(exception));
            return null;
        }
        return userwatchlistresponse;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (UserWatchlistResponse)obj;
        b.i();
        com.offerup.android.b.a.getInstance().post(new eh(((UserWatchlistResponse) (obj)), (byte)0));
    }

    protected final void onPreExecute()
    {
        if (b.a == 2)
        {
            b.g = ProgressDialog.show(a, "", "Loading watchlist ...");
        }
    }
}
