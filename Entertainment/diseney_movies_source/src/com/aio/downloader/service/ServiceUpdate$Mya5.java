// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.service:
//            ServiceUpdate

class this._cls0 extends AsyncTask
{

    private String icon_pick1;
    private String img_pick;
    private String short_desc1;
    final ServiceUpdate this$0;
    private String title_pick1;
    private String url1;

    private void ShowResult6(String s)
    {
        list_pick.addAll(Myutils.parsetodaypick(s));
        Log.e("lpl", (new StringBuilder("list_pick=")).append(list_pick).toString());
        try
        {
            ServiceUpdate.access$1(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getIcon());
            ServiceUpdate.access$2(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getTitle());
            ServiceUpdate.access$3(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getShort_desc());
            img_pick = ((DownloadMovieItem)list_pick.get(0)).getMovieHeadImagePath();
            ServiceUpdate.access$5(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(0)).getId());
            icon_pick1 = ((DownloadMovieItem)list_pick.get(1)).getIcon();
            title_pick1 = ((DownloadMovieItem)list_pick.get(1)).getTitle();
            short_desc1 = ((DownloadMovieItem)list_pick.get(1)).getShort_desc();
            ServiceUpdate.access$9(ServiceUpdate.this, ((DownloadMovieItem)list_pick.get(1)).getId());
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        (new Timer()).schedule(new TimerTask() {

            final ServiceUpdate.Mya5 this$1;

            public void run()
            {
                Intent intent = new Intent("meiri");
                intent.putExtra("icon_pick1", icon_pick1);
                intent.putExtra("title_pick1", title_pick1);
                intent.putExtra("short_desc1", short_desc1);
                intent.putExtra("id_meiri", ServiceUpdate.access$13(this$0));
                sendBroadcast(intent);
                intent = new Intent("meiribig");
                intent.putExtra("icon_pick", ServiceUpdate.access$14(this$0));
                intent.putExtra("title_pick", ServiceUpdate.access$15(this$0));
                intent.putExtra("short_desc", ServiceUpdate.access$16(this$0));
                intent.putExtra("img_pick", img_pick);
                intent.putExtra("id_meiribig", ServiceUpdate.access$18(this$0));
                sendBroadcast(intent);
            }

            
            {
                this$1 = ServiceUpdate.Mya5.this;
                super();
            }
        }, 30000L, 60000L);
    }

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
            ShowResult6(s);
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
