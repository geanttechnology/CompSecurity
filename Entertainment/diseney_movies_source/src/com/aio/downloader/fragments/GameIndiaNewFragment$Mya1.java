// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            GameIndiaNewFragment

class this._cls0 extends AsyncTask
{

    final GameIndiaNewFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=games_india_new&page=")).append(GameIndiaNewFragment.access$1(GameIndiaNewFragment.this)).toString());
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
            GameIndiaNewFragment.access$2(GameIndiaNewFragment.this, false);
            return;
        } else
        {
            GameIndiaNewFragment.access$3(GameIndiaNewFragment.this, s);
            GameIndiaNewFragment.access$2(GameIndiaNewFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        GameIndiaNewFragment.access$0(GameIndiaNewFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = GameIndiaNewFragment.this;
        super();
    }
}
