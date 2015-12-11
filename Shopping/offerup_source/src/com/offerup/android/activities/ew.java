// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.network.c;

// Referenced classes of package com.offerup.android.activities:
//            PayItemGridActivity

final class ew extends AsyncTask
{

    private Context a;
    private PayItemGridActivity b;

    public ew(PayItemGridActivity payitemgridactivity, Context context)
    {
        b = payitemgridactivity;
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
        PayItemGridActivity.a(b, ((DiscussionsResponse) (obj)).getDiscussions());
    }

    protected final void onPreExecute()
    {
        b.g = ProgressDialog.show(a, "", "Loading Items ...");
    }
}
