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

class val.myPosition
    implements android.view.viewAdapter._cls4
{

    final AppListviewAdapter this$0;
    private final int val$myPosition;

    public void onClick(View view)
    {
        view = (new StringBuilder("Share: http://android.downloadatoz.com/apps/")).append(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(val$myPosition)).getId()).append(",").append(((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(val$myPosition)).getSerial()).append(".html").toString();
        Log.e("location", view);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", view);
        AppListviewAdapter.access$0(AppListviewAdapter.this).startActivity(Intent.createChooser(intent, "AIO Downloaded"));
        (new Handler()).post(new Runnable() {

            final AppListviewAdapter._cls4 this$1;

            public void run()
            {
                AppListviewAdapter.access$7(this$0).dismiss();
            }

            
            {
                this$1 = AppListviewAdapter._cls4.this;
                super();
            }
        });
        MobclickAgent.onEvent(AppListviewAdapter.access$0(AppListviewAdapter.this), "share");
    }


    _cls1.this._cls1()
    {
        this$0 = final_applistviewadapter;
        val$myPosition = I.this;
        super();
    }
}
