// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls2
    implements Runnable
{

    final _cls76 this$2;

    public void run()
    {
        if (AppDetailsActivity.access$4(_fld0).getProgress() >= AppDetailsActivity.access$78(_fld0))
        {
            if (AppDetailsActivity.access$7(_fld0) != null)
            {
                AppDetailsActivity.access$7(_fld0).cancel();
            }
            return;
        } else
        {
            AppDetailsActivity.access$4(_fld0).setProgress(AppDetailsActivity.access$4(_fld0).getProgress() + 1);
            AppDetailsActivity appdetailsactivity = _fld0;
            AppDetailsActivity.access$79(appdetailsactivity, AppDetailsActivity.access$76(appdetailsactivity) + 1);
            return;
        }
    }

    ent()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/AppDetailsActivity$29

/* anonymous class */
    class AppDetailsActivity._cls29 extends AsyncTask
    {

        String content;
        DownloadMovieItem d;
        HashMap options;
        final AppDetailsActivity this$0;
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
            options = AppDetailsActivity.access$86(AppDetailsActivity.this);
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
            Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*********").toString());
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
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(id).append("&status=fail_get_url&version=").append("3.3.9").append("&content=").append(avoid).toString());
            } else
            if (AppDetailsActivity.access$10(AppDetailsActivity.this).findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
            {
                avoid = new Message();
                avoid.what = 2;
                handler.sendMessage(avoid);
            } else
            {
                String s = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                d.setDownloadUrl(avoid);
                d.setFilePath(s);
                d.setDownloadState(Integer.valueOf(4));
                d.setMovieName(title);
                d.setMovieHeadImagePath(icon);
                d.setFile_id(id);
                d.setType("app");
                d.setCat("app");
                d.setTitle(title);
                d.setSerial(appserial);
                d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                toDownload(d);
                Myutils.getInstance();
                Myutils.list.add(d);
                avoid = new Message();
                avoid.what = 3;
                handler.sendMessage(avoid);
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
            AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(8);
            AppDetailsActivity.access$6(AppDetailsActivity.this).setVisibility(8);
            AppDetailsActivity.access$5(AppDetailsActivity.this).setVisibility(0);
            AppDetailsActivity.access$77(AppDetailsActivity.this, null);
            AppDetailsActivity.access$77(AppDetailsActivity.this, new Timer());
            AppDetailsActivity.access$7(AppDetailsActivity.this).schedule(new AppDetailsActivity._cls29._cls1(), 400L, 400L);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            AppDetailsActivity.access$0(AppDetailsActivity.this).setVisibility(0);
        }


            
            {
                this$0 = final_appdetailsactivity;
                id = s;
                title = String.this;
                icon = s3;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
    }


    // Unreferenced inner class com/aio/downloader/activity/AppDetailsActivity$29$1

/* anonymous class */
    class AppDetailsActivity._cls29._cls1 extends TimerTask
    {

        final AppDetailsActivity._cls29 this$1;

        public void run()
        {
            runOnUiThread(new AppDetailsActivity._cls29._cls1._cls1());
        }


            
            {
                this$1 = AppDetailsActivity._cls29.this;
                super();
            }
    }

}
