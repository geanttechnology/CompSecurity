// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import java.io.File;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class m extends AsyncTask
{

    DownloadMovieItem d;
    final MyMainActivity this$0;
    private final int val$appserial;
    private final String val$icon;
    private final String val$id;
    private final String val$title;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (MyMainActivity.access$8(MyMainActivity.this).findItemsByWhereAndWhereValue("downloadUrl", MyMainActivity.access$93(MyMainActivity.this), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
        {
            avoid = new Message();
            avoid.what = 2;
            handler.sendMessage(avoid);
            return null;
        } else
        {
            avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(val$id))).append(".apk").toString())).getAbsolutePath();
            d.setDownloadUrl(MyMainActivity.access$93(MyMainActivity.this));
            d.setFilePath(avoid);
            d.setDownloadState(Integer.valueOf(4));
            d.setMovieName(val$title);
            d.setMovieHeadImagePath(val$icon);
            d.setFile_id(val$id);
            d.setType("app");
            d.setTitle(val$title);
            d.setSerial(val$appserial);
            d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
            toDownload(d);
            Myutils.getInstance();
            Myutils.list.add(d);
            avoid = new Message();
            avoid.what = 3;
            handler.sendMessage(avoid);
            return null;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        MyMainActivity.access$13(MyMainActivity.this).setVisibility(8);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        MyMainActivity.access$13(MyMainActivity.this).setVisibility(0);
    }

    m()
    {
        this$0 = final_mymainactivity;
        val$id = s;
        val$title = s1;
        val$icon = s2;
        val$appserial = I.this;
        super();
        d = new DownloadMovieItem();
    }
}
