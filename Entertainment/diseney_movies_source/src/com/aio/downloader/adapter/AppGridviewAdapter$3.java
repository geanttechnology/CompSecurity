// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.adapter:
//            AppGridviewAdapter

class content extends AsyncTask
{

    String content;
    DownloadMovieItem d;
    HashMap options;
    final AppGridviewAdapter this$0;
    String url;
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
        options = AppGridviewAdapter.access$7(AppGridviewAdapter.this);
        options.put("show_header", Integer.valueOf(1));
        options.put("redirect", Integer.valueOf(0));
        options.put("send_cookie", Integer.valueOf(0));
        content = publicTools.getDataFromURL(url, options);
        if (!content.contains("Location"))
        {
            url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
            options.put("redirect", Integer.valueOf(1));
            content = publicTools.getDataFromURL(url, options);
        }
        avoid = "";
        Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
        if (matcher.find())
        {
            avoid = matcher.group(1);
        } else
        {
            Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
            if (matcher1.find())
            {
                avoid = matcher1.group(1);
            }
        }
        if (TextUtils.isEmpty(avoid))
        {
            avoid = new Message();
            avoid.what = 1;
            handler.sendMessage(avoid);
            if (content.length() > 100)
            {
                avoid = content.substring(0, 100);
            } else
            {
                avoid = content;
            }
            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(val$id).append("&status=fail_get_url&version=").append("3.3.9").append("&content=").append(avoid).toString());
        } else
        if (AppGridviewAdapter.access$9(AppGridviewAdapter.this).findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
        {
            avoid = new Message();
            avoid.what = 2;
            handler.sendMessage(avoid);
        } else
        {
            String s = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(AppGridviewAdapter.access$0(AppGridviewAdapter.this).getPackageName()).toString(), (new StringBuilder(String.valueOf(val$id))).append(".apk").toString())).getAbsolutePath();
            d.setDownloadUrl(avoid);
            d.setFilePath(s);
            Log.v("fefe", avoid);
            d.setDownloadState(Integer.valueOf(4));
            d.setMovieName(val$title);
            d.setMovieHeadImagePath(val$icon);
            d.setFile_id(val$id);
            d.setTitle(val$title);
            d.setSerial(val$appserial);
            d.setType("app");
            d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
            toDownload(d);
            Myutils.getInstance();
            Myutils.list.add(d);
            avoid = new Message();
            avoid.what = 3;
            handler.sendMessage(avoid);
            AppGridviewAdapter.access$1(AppGridviewAdapter.this, Boolean.valueOf(true));
        }
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        void1 = new Intent();
        if (!AppGridviewAdapter.access$3(AppGridviewAdapter.this).equals("appgvdetail")) goto _L2; else goto _L1
_L1:
        void1.setAction("hidegvappdetail");
_L4:
        AppGridviewAdapter.access$0(AppGridviewAdapter.this).sendBroadcast(void1);
        return;
_L2:
        if (AppGridviewAdapter.access$3(AppGridviewAdapter.this).equals("appgvhome"))
        {
            void1.setAction("hidehomeapp");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPreExecute()
    {
        Intent intent;
        super.onPreExecute();
        intent = new Intent();
        if (!AppGridviewAdapter.access$3(AppGridviewAdapter.this).equals("appgvdetail")) goto _L2; else goto _L1
_L1:
        intent.setAction("showgvappdetail");
_L4:
        AppGridviewAdapter.access$0(AppGridviewAdapter.this).sendBroadcast(intent);
        return;
_L2:
        if (AppGridviewAdapter.access$3(AppGridviewAdapter.this).equals("appgvhome"))
        {
            intent.setAction("showhomeapp");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (String s3, 
            int i)
    {
        this$0 = final_appgridviewadapter;
        val$id = s;
        val$title = String.this;
        val$icon = s3;
        val$appserial = i;
        super();
        d = new DownloadMovieItem();
        url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
        options = new HashMap();
        content = "";
    }
}
