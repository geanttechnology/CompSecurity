// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AdultGamesFragment

class this._cls0 extends AsyncTask
{

    final AdultGamesFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=sex_games&page=")).append(AdultGamesFragment.access$1(AdultGamesFragment.this)).toString());
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
            AdultGamesFragment.access$2(AdultGamesFragment.this, false);
            return;
        } else
        {
            AdultGamesFragment.access$3(AdultGamesFragment.this, s);
            AdultGamesFragment.access$2(AdultGamesFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AdultGamesFragment.access$0(AdultGamesFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AdultGamesFragment.this;
        super();
    }
}
