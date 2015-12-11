// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls0 extends AsyncTask
{

    private int showup;
    final ServiceUpdate this$0;
    private String url1;

    private void ShowResult7(String s)
    {
        list_update.addAll(Myutils.parseupdata(s));
        if (Myutils.status != 1)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        try
        {
            Log.e("qaz", (new StringBuilder(String.valueOf(list_update.size()))).toString());
            showup = (int)(Math.random() * (double)list_update.size());
            (new Timer()).schedule(new TimerTask() {

                final ServiceUpdate.Mya7 this$1;

                public void run()
                {
                    Log.e("qaz", (new StringBuilder("updateservise")).append(((DownloadMovieItem)list_update.get(showup)).getId()).toString());
                    Intent intent = new Intent("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD");
                    intent.putExtra("appid", ((DownloadMovieItem)list_update.get(showup)).getId());
                    intent.putExtra("appvirsion", ((DownloadMovieItem)list_update.get(showup)).getVersion());
                    intent.putExtra("appurl", ((DownloadMovieItem)list_update.get(showup)).getLink_url());
                    sendBroadcast(intent);
                }

            
            {
                this$1 = ServiceUpdate.Mya7.this;
                super();
            }
            }, 1000L, 30000L);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = new MyAppInfo(getApplicationContext());
        appName = s.getAppName(((DownloadMovieItem)list_update.get(showup)).getId());
        appVersion = s.getAppVersion(((DownloadMovieItem)list_update.get(showup)).getId());
        appIcon = s.getAppIcon(((DownloadMovieItem)list_update.get(showup)).getId());
        return;
        s;
        s.printStackTrace();
        return;
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Log.e("qaz", (new StringBuilder(String.valueOf(ServiceUpdate.access$51(ServiceUpdate.this)))).append("===").toString());
        return ServiceUpdate.access$51(ServiceUpdate.this);
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
            Log.e("qaz", (new StringBuilder("result=")).append(s).toString());
            ShowResult7(s);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
    }



    _cls1.this._cls1()
    {
        this$0 = ServiceUpdate.this;
        super();
    }
}
