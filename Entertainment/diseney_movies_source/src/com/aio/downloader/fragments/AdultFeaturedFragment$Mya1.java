// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AdultFeaturedFragment

class this._cls0 extends AsyncTask
{

    final AdultFeaturedFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=sex_featured&page=")).append(AdultFeaturedFragment.access$1(AdultFeaturedFragment.this)).toString());
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
            AdultFeaturedFragment.access$2(AdultFeaturedFragment.this, false);
            return;
        } else
        {
            AdultFeaturedFragment.access$3(AdultFeaturedFragment.this, s);
            AdultFeaturedFragment.access$2(AdultFeaturedFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AdultFeaturedFragment.access$0(AdultFeaturedFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AdultFeaturedFragment.this;
        super();
    }
}
