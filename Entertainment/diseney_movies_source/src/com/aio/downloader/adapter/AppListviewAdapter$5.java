// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.mydownload.DownloadMovieItem;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            AppListviewAdapter

class val.myPosition
    implements android.view.viewAdapter._cls5
{

    final AppListviewAdapter this$0;
    private final int val$myPosition;

    public void onClick(View view)
    {
        view = new Intent(AppListviewAdapter.access$0(AppListviewAdapter.this), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(val$myPosition)).getId());
        view.addFlags(0x10000000);
        AppListviewAdapter.access$0(AppListviewAdapter.this).startActivity(view);
        (new Handler()).post(new Runnable() {

            final AppListviewAdapter._cls5 this$1;

            public void run()
            {
                AppListviewAdapter.access$7(this$0).dismiss();
            }

            
            {
                this$1 = AppListviewAdapter._cls5.this;
                super();
            }
        });
    }


    _cls1.this._cls1()
    {
        this$0 = final_applistviewadapter;
        val$myPosition = I.this;
        super();
    }
}
