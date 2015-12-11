// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AppGlobalNewFragment

class this._cls0 extends AsyncTask
{

    final AppGlobalNewFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=aio_apps_popular&page=")).append(AppGlobalNewFragment.access$1(AppGlobalNewFragment.this)).toString());
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
            AppGlobalNewFragment.access$2(AppGlobalNewFragment.this, false);
            return;
        } else
        {
            AppGlobalNewFragment.access$3(AppGlobalNewFragment.this, s);
            AppGlobalNewFragment.access$2(AppGlobalNewFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppGlobalNewFragment.access$0(AppGlobalNewFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppGlobalNewFragment.this;
        super();
    }
}
