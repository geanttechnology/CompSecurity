// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AppIndiaTopFragment

class this._cls0 extends AsyncTask
{

    final AppIndiaTopFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=app_india_top&page=")).append(AppIndiaTopFragment.access$1(AppIndiaTopFragment.this)).toString());
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
            AppIndiaTopFragment.access$2(AppIndiaTopFragment.this, false);
            return;
        } else
        {
            AppIndiaTopFragment.access$3(AppIndiaTopFragment.this, s);
            AppIndiaTopFragment.access$2(AppIndiaTopFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppIndiaTopFragment.access$0(AppIndiaTopFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppIndiaTopFragment.this;
        super();
    }
}
