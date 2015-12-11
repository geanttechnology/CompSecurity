// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            GameGlobalNewFragment

class this._cls0 extends AsyncTask
{

    final GameGlobalNewFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=games_us_new&page=")).append(GameGlobalNewFragment.access$1(GameGlobalNewFragment.this)).toString());
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
            GameGlobalNewFragment.access$2(GameGlobalNewFragment.this, false);
            return;
        } else
        {
            GameGlobalNewFragment.access$3(GameGlobalNewFragment.this, s);
            GameGlobalNewFragment.access$2(GameGlobalNewFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        GameGlobalNewFragment.access$0(GameGlobalNewFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = GameGlobalNewFragment.this;
        super();
    }
}
