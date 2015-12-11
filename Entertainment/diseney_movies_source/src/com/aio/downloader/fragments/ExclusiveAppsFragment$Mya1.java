// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.fragments:
//            ExclusiveAppsFragment

class this._cls0 extends AsyncTask
{

    final ExclusiveAppsFragment this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        avoid = publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=exclusive&page=")).append(ExclusiveAppsFragment.access$1(ExclusiveAppsFragment.this)).toString());
        Log.e("www", (new StringBuilder("ex=")).append(avoid).toString());
        return avoid;
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
            ExclusiveAppsFragment.access$2(ExclusiveAppsFragment.this, false);
            return;
        } else
        {
            ExclusiveAppsFragment.access$3(ExclusiveAppsFragment.this, s);
            ExclusiveAppsFragment.access$2(ExclusiveAppsFragment.this, true);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        ExclusiveAppsFragment.access$0(ExclusiveAppsFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = ExclusiveAppsFragment.this;
        super();
    }
}
