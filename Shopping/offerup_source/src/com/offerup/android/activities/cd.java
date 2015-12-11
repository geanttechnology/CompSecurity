// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.e.a;
import com.b.a.a.j;
import com.google.gson.Gson;
import com.offerup.android.dto.ItemListsResponse;
import com.offerup.android.gson.GsonManager;

// Referenced classes of package com.offerup.android.activities:
//            ExploreActivity

final class cd extends AsyncTask
{

    private ExploreActivity a;

    private cd(ExploreActivity exploreactivity)
    {
        a = exploreactivity;
        super();
    }

    cd(ExploreActivity exploreactivity, byte byte0)
    {
        this(exploreactivity);
    }

    protected final Object doInBackground(Object aobj[])
    {
        return android.support.v4.e.a.b();
    }

    protected final void onPostExecute(Object obj)
    {
        Object obj1 = (ItemListsResponse)obj;
        a.i();
        if (obj1 != null && ((ItemListsResponse) (obj1)).isSuccess())
        {
            obj = ((ItemListsResponse) (obj1)).getItemLists();
            obj1 = GsonManager.getGson().toJson(((ItemListsResponse) (obj1)).getItemLists());
            a.e.o(((String) (obj1)));
            com.offerup.android.activities.ExploreActivity.a(a, ((java.util.List) (obj)));
            return;
        } else
        {
            a.a(true, new cd(a), new Object[0]);
            return;
        }
    }

    protected final void onPreExecute()
    {
        a.g = ProgressDialog.show(a, "", "Loading...");
    }
}
