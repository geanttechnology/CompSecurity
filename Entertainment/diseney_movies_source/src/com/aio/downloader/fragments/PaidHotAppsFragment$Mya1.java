// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            PaidHotAppsFragment

class this._cls0 extends AsyncTask
{

    final PaidHotAppsFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_hot_app&page=")).append(PaidHotAppsFragment.access$1(PaidHotAppsFragment.this)).toString());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        if (s == null)
        {
            PaidHotAppsFragment.access$2(PaidHotAppsFragment.this, false);
            return;
        } else
        {
            PaidHotAppsFragment.access$3(PaidHotAppsFragment.this, s);
            PaidHotAppsFragment.access$2(PaidHotAppsFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        PaidHotAppsFragment.access$0(PaidHotAppsFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = PaidHotAppsFragment.this;
        super();
    }
}
