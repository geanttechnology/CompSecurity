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

    // Unreferenced inner class com/aio/downloader/adapter/AppListviewAdapter$5

/* anonymous class */
    class AppListviewAdapter._cls5
        implements android.view.View.OnClickListener
    {

        final AppListviewAdapter this$0;
        private final int val$myPosition;

        public void onClick(View view)
        {
            view = new Intent(AppListviewAdapter.access$0(AppListviewAdapter.this), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", ((DownloadMovieItem)AppListviewAdapter.access$8(AppListviewAdapter.this).get(myPosition)).getId());
            view.addFlags(0x10000000);
            AppListviewAdapter.access$0(AppListviewAdapter.this).startActivity(view);
            (new Handler()).post(new AppListviewAdapter._cls5._cls1());
        }


            
            {
                this$0 = final_applistviewadapter;
                myPosition = I.this;
                super();
            }
    }

}
