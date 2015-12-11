// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            AppGlobalTopFragment

class this._cls0 extends AsyncTask
{

    final AppGlobalTopFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        return publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=app_us_top&page=")).append(AppGlobalTopFragment.access$1(AppGlobalTopFragment.this)).toString());
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
            AppGlobalTopFragment.access$2(AppGlobalTopFragment.this, false);
            return;
        } else
        {
            AppGlobalTopFragment.access$3(AppGlobalTopFragment.this, s);
            AppGlobalTopFragment.access$2(AppGlobalTopFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        AppGlobalTopFragment.access$0(AppGlobalTopFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = AppGlobalTopFragment.this;
        super();
    }
}
