// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.network.c;

// Referenced classes of package com.offerup.android.activities:
//            DiscussionsListActivity

public final class bx extends AsyncTask
{

    private DiscussionsListActivity a;

    public bx(DiscussionsListActivity discussionslistactivity)
    {
        a = discussionslistactivity;
        super();
    }

    protected final Object doInBackground(Object aobj[])
    {
        return c.a(a.b);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (DiscussionsResponse)obj;
        a.i();
        if (obj == null || !((DiscussionsResponse) (obj)).isSuccess())
        {
            DiscussionsListActivity.a(a, true);
            return;
        } else
        {
            a.a(((DiscussionsResponse) (obj)));
            return;
        }
    }

    protected final void onPreExecute()
    {
        a.g = ProgressDialog.show(a, "", "Fetching your conversations");
    }
}
