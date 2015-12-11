// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends AsyncTask
{

    final MyMainActivity this$0;
    private String url1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        url1 = "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1";
        return publicTools.getUrl(url1);
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
            Log.e("asd", (new StringBuilder("result=")).append(s).toString());
            MyMainActivity.access$37(MyMainActivity.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
