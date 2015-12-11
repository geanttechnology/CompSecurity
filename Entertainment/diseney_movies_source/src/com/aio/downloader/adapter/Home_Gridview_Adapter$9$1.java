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
//            Home_Gridview_Adapter

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        Home_Gridview_Adapter.access$5(_fld0).dismiss();
    }

    l.myPosition()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_Gridview_Adapter$9

/* anonymous class */
    class Home_Gridview_Adapter._cls9
        implements android.view.View.OnClickListener
    {

        final Home_Gridview_Adapter this$0;
        private final int val$myPosition;

        public void onClick(View view)
        {
            view = new Intent(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", ((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getId());
            view.addFlags(0x10000000);
            Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).startActivity(view);
            (new Handler()).post(new Home_Gridview_Adapter._cls9._cls1());
        }


            
            {
                this$0 = final_home_gridview_adapter;
                myPosition = I.this;
                super();
            }
    }

}
