// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.umeng.analytics.MobclickAgent;
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

    l.myPosition()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/AppListviewAdapter$4

/* anonymous class */
    class AppListviewAdapter._cls4
        implements android.view.View.OnClickListener
    {

        final AppListviewAdapter this$0;
        private final int val$myPosition;

        public void onClick(View view)
        {
            view = (new StringBuilder("Share: http://android.downloadatoz.com/apps/")).append(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getId()).append(",").append(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getSerial()).append(".html").toString();
            Log.e("location", view);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", view);
            AppListviewAdapter.access$0(AppListviewAdapter.this).startActivity(Intent.createChooser(intent, "AIO Downloaded"));
            (new Handler()).post(new AppListviewAdapter._cls4._cls1());
            MobclickAgent.onEvent(AppListviewAdapter.access$0(AppListviewAdapter.this), "share");
        }


            
            {
                this$0 = final_applistviewadapter;
                myPosition = I.this;
                super();
            }
    }

}
