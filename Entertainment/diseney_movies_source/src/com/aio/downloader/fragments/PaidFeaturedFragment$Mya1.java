// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            PaidFeaturedFragment

class this._cls0 extends AsyncTask
{

    final PaidFeaturedFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=")).append(PaidFeaturedFragment.access$1(PaidFeaturedFragment.this)).toString());
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
            PaidFeaturedFragment.access$2(PaidFeaturedFragment.this, false);
            return;
        } else
        {
            PaidFeaturedFragment.access$3(PaidFeaturedFragment.this, s);
            PaidFeaturedFragment.access$2(PaidFeaturedFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        PaidFeaturedFragment.access$0(PaidFeaturedFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = PaidFeaturedFragment.this;
        super();
    }
}
