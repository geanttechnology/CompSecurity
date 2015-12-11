// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            PaidHotGamesFragment

class this._cls0 extends AsyncTask
{

    final PaidHotGamesFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_hot_games&page=")).append(PaidHotGamesFragment.access$1(PaidHotGamesFragment.this)).toString());
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
            PaidHotGamesFragment.access$2(PaidHotGamesFragment.this, false);
            return;
        } else
        {
            PaidHotGamesFragment.access$3(PaidHotGamesFragment.this, s);
            PaidHotGamesFragment.access$2(PaidHotGamesFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        PaidHotGamesFragment.access$0(PaidHotGamesFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = PaidHotGamesFragment.this;
        super();
    }
}
