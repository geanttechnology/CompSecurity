// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            GameGlobalTopFragment

class this._cls0 extends AsyncTask
{

    final GameGlobalTopFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=games_us_top&page=")).append(GameGlobalTopFragment.access$1(GameGlobalTopFragment.this)).toString());
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
            GameGlobalTopFragment.access$2(GameGlobalTopFragment.this, false);
            return;
        } else
        {
            GameGlobalTopFragment.access$3(GameGlobalTopFragment.this, s);
            GameGlobalTopFragment.access$2(GameGlobalTopFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        GameGlobalTopFragment.access$0(GameGlobalTopFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = GameGlobalTopFragment.this;
        super();
    }
}
