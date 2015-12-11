// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.publicTools;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            AppDetailsActivity

class this._cls1 extends AsyncTask
{

    final is._cls0 this$1;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        try
        {
            publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(AppDetailsActivity.access$21(_fld0)).append("&from=apk").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[]) { }
        return null;
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/AppDetailsActivity$27

/* anonymous class */
    class AppDetailsActivity._cls27
        implements android.view.View.OnClickListener
    {

        final AppDetailsActivity this$0;

        public void onClick(View view)
        {
            Log.e("logg", (new StringBuilder("linkurl1=")).append(AppDetailsActivity.access$83(AppDetailsActivity.this)).append("wocao=").append(AppDetailsActivity.access$17(AppDetailsActivity.this)).toString());
            if (AppDetailsActivity.access$17(AppDetailsActivity.this) != 0)
            {
                break MISSING_BLOCK_LABEL_390;
            }
            if (!AppDetailsActivity.access$18(AppDetailsActivity.this).getHas_apk().equals("1")) goto _L2; else goto _L1
_L1:
            (new AppDetailsActivity._cls27._cls1()).execute(new Void[0]);
            if (!AppDetailsActivity.access$84(AppDetailsActivity.this).getBoolean("isopen", false) || NetWorkUtil.getAPNType(getApplicationContext()) == 1) goto _L4; else goto _L3
_L3:
            AppDetailsActivity.access$85(AppDetailsActivity.this);
_L6:
            return;
_L4:
            if (AppDetailsActivity.access$26(AppDetailsActivity.this).queryfile(AppDetailsActivity.access$18(AppDetailsActivity.this).getId()) == null)
            {
                MydownloadApk(AppDetailsActivity.access$18(AppDetailsActivity.this).getId(), AppDetailsActivity.access$18(AppDetailsActivity.this).getTitle(), AppDetailsActivity.access$18(AppDetailsActivity.this).getIcon(), AppDetailsActivity.access$18(AppDetailsActivity.this).getSerial());
                Log.e("bbb", (new StringBuilder(String.valueOf(AppDetailsActivity.access$18(AppDetailsActivity.this).getTitle()))).append("+").append(AppDetailsActivity.access$18(AppDetailsActivity.this).getIcon()).append("+").append(AppDetailsActivity.access$18(AppDetailsActivity.this).getSerial()).toString());
                AppDetailsActivity.access$32(AppDetailsActivity.this).setBackgroundResource(0x7f02006e);
                AppDetailsActivity.access$32(AppDetailsActivity.this).setText("Downloading");
                return;
            } else
            {
                AppDetailsActivity.access$16(AppDetailsActivity.this);
                return;
            }
_L2:
            if (!AppDetailsActivity.access$18(AppDetailsActivity.this).getHas_apk().equals("0")) goto _L6; else goto _L5
_L5:
            (new Thread(new AppDetailsActivity._cls27._cls2())).start();
            AppDetailsActivity.access$32(AppDetailsActivity.this).setBackgroundResource(0x7f02006e);
            view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(AppDetailsActivity.access$18(AppDetailsActivity.this).getId()).toString()));
            startActivity(view);
            return;
            Log.e("qqq", (new StringBuilder("dbUtils.queryfile(wycmyid)=")).append(AppDetailsActivity.access$26(AppDetailsActivity.this).queryfile(AppDetailsActivity.access$27(AppDetailsActivity.this))).append("=========").append(AppDetailsActivity.access$10(AppDetailsActivity.this).findItemsByWhereAndWhereValue("file_id", AppDetailsActivity.access$27(AppDetailsActivity.this), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size()).toString());
            if (AppDetailsActivity.access$26(AppDetailsActivity.this).queryfile(AppDetailsActivity.access$27(AppDetailsActivity.this)) == null && AppDetailsActivity.access$10(AppDetailsActivity.this).findItemsByWhereAndWhereValue("file_id", AppDetailsActivity.access$27(AppDetailsActivity.this), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
            {
                view = new MyAppInfo(getApplicationContext());
                try
                {
                    AppDetailsActivity.access$28(AppDetailsActivity.this, view.getAppName(AppDetailsActivity.access$27(AppDetailsActivity.this)));
                    AppDetailsActivity.access$29(AppDetailsActivity.this, view.getAppIcon(AppDetailsActivity.access$27(AppDetailsActivity.this)));
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                MydownloadApk_Update(AppDetailsActivity.access$27(AppDetailsActivity.this), AppDetailsActivity.access$19(AppDetailsActivity.this), AppDetailsActivity.access$30(AppDetailsActivity.this), 110, AppDetailsActivity.drawableToBitmap(AppDetailsActivity.access$31(AppDetailsActivity.this)));
                AppDetailsActivity.access$32(AppDetailsActivity.this).setBackgroundResource(0x7f02006e);
                view = new Intent("setbroadUpdate");
                sendBroadcast(view);
                return;
            } else
            {
                view = new Message();
                view.what = 2;
                handler.sendMessage(view);
                return;
            }
        }


            
            {
                this$0 = AppDetailsActivity.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/activity/AppDetailsActivity$27$2

/* anonymous class */
        class AppDetailsActivity._cls27._cls2
            implements Runnable
        {

            final AppDetailsActivity._cls27 this$1;

            public void run()
            {
                try
                {
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=")).append(AppDetailsActivity.access$18(this$0).getId()).append("&from=google").toString());
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

                    
                    {
                        this$1 = AppDetailsActivity._cls27.this;
                        super();
                    }
        }

    }

}
