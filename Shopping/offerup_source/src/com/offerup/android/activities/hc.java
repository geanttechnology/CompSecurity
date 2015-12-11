// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;

// Referenced classes of package com.offerup.android.activities:
//            SearchActivity

final class hc extends AsyncTask
{

    private SearchActivity a;

    hc(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }

    protected final volatile Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        try
        {
            a.i();
            a.g = ProgressDialog.show(a, "", SearchActivity.m(a));
            a.g.setCancelable(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }
}
