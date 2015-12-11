// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            TodaysPickActivity

class this._cls0 extends AsyncTask
{

    final TodaysPickActivity this$0;
    private String url;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        if (TodaysPickActivity.access$2(TodaysPickActivity.this) != null)
        {
            url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=rs&id=")).append(TodaysPickActivity.access$2(TodaysPickActivity.this)).append("&page=").append(TodaysPickActivity.access$3(TodaysPickActivity.this)).toString();
        } else
        {
            url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=")).append(TodaysPickActivity.access$3(TodaysPickActivity.this)).toString();
        }
        return publicTools.getUrl(url);
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
            return;
        } else
        {
            TodaysPickActivity.access$4(TodaysPickActivity.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        TodaysPickActivity.access$1(TodaysPickActivity.this).setVisibility(0);
    }

    _cls9()
    {
        this$0 = TodaysPickActivity.this;
        super();
    }
}
