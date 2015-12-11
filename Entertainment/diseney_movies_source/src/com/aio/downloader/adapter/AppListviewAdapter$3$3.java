// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            AppListviewAdapter

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        AppListviewAdapter.access$7(_fld0).dismiss();
    }

    l.mHas_apk()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/AppListviewAdapter$3

/* anonymous class */
    class AppListviewAdapter._cls3
        implements android.view.View.OnClickListener
    {

        final AppListviewAdapter this$0;
        private final String val$mHas_apk;
        private final int val$myPosition;

        public void onClick(View view)
        {
            AppListviewAdapter.access$3(AppListviewAdapter.this).edit().putString("appname", ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getTitle()).commit();
            AppListviewAdapter.access$4(AppListviewAdapter.this).edit().putString("appid", ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getId()).commit();
            if (!mHas_apk.equals("1")) goto _L2; else goto _L1
_L1:
            (new Thread(new AppListviewAdapter._cls3._cls1())).start();
            if (AppListviewAdapter.access$9(AppListviewAdapter.this).getBoolean("isopen", false) && NetWorkUtil.getAPNType(AppListviewAdapter.access$0(AppListviewAdapter.this)) != 1)
            {
                AppListviewAdapter.access$10(AppListviewAdapter.this);
                return;
            }
            if (AppListviewAdapter.access$11(AppListviewAdapter.this).queryfile(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getId()) == null)
            {
                MydownloadApk(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getId(), ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getTitle(), ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getIcon(), ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getSerial());
            } else
            {
                AppListviewAdapter.access$1(AppListviewAdapter.this);
            }
_L4:
            (new Handler()).post(new AppListviewAdapter._cls3._cls3());
            return;
_L2:
            if (mHas_apk.equals("0"))
            {
                (new Thread(new AppListviewAdapter._cls3._cls2())).start();
                view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getId()).toString()));
                AppListviewAdapter.access$0(AppListviewAdapter.this).startActivity(view);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }


            
            {
                this$0 = final_applistviewadapter;
                myPosition = i;
                mHas_apk = String.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/adapter/AppListviewAdapter$3$1

/* anonymous class */
        class AppListviewAdapter._cls3._cls1
            implements Runnable
        {

            final AppListviewAdapter._cls3 this$1;
            private final int val$myPosition;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)AppListviewAdapter.access$8(this$0).get(myPosition)).getId()).append("&from=apk").toString());
            }

                    
                    {
                        this$1 = AppListviewAdapter._cls3.this;
                        myPosition = i;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/adapter/AppListviewAdapter$3$2

/* anonymous class */
        class AppListviewAdapter._cls3._cls2
            implements Runnable
        {

            final AppListviewAdapter._cls3 this$1;
            private final int val$myPosition;

            public void run()
            {
                try
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(((DownloadMovieItem)AppListviewAdapter.access$8(this$0).get(myPosition)).getId()).append("&from=google").toString());
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

                    
                    {
                        this$1 = AppListviewAdapter._cls3.this;
                        myPosition = i;
                        super();
                    }
        }

    }

}
