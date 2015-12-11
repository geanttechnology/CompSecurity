// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AppIndiaNewFragment

class this._cls0 extends AsyncTask
{

    final AppIndiaNewFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=app_us_new&page=")).append(AppIndiaNewFragment.access$1(AppIndiaNewFragment.this)).toString());
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
            AppIndiaNewFragment.access$2(AppIndiaNewFragment.this, false);
            return;
        } else
        {
            AppIndiaNewFragment.access$3(AppIndiaNewFragment.this, s);
            AppIndiaNewFragment.access$2(AppIndiaNewFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppIndiaNewFragment.access$0(AppIndiaNewFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppIndiaNewFragment.this;
        super();
    }
}
