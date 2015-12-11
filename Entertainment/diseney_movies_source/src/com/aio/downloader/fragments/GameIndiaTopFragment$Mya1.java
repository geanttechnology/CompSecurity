// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            GameIndiaTopFragment

class this._cls0 extends AsyncTask
{

    final GameIndiaTopFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=games_india_top&page=")).append(GameIndiaTopFragment.access$1(GameIndiaTopFragment.this)).toString());
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
            GameIndiaTopFragment.access$2(GameIndiaTopFragment.this, false);
            return;
        } else
        {
            GameIndiaTopFragment.access$3(GameIndiaTopFragment.this, s);
            GameIndiaTopFragment.access$2(GameIndiaTopFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        GameIndiaTopFragment.access$0(GameIndiaTopFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = GameIndiaTopFragment.this;
        super();
    }
}
