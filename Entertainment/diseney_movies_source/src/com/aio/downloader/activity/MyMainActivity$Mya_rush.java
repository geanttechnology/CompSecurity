// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends AsyncTask
{

    final MyMainActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Log.e("fuck", (new StringBuilder("url=")).append("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=home&page=1").toString());
        return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=home&page=1");
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
            MyMainActivity.access$35(MyMainActivity.this, s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MyMainActivity.access$13(MyMainActivity.this).setVisibility(0);
    }

    _cls9()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
