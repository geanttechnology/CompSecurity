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

    // Unreferenced inner class com/aio/downloader/adapter/Home_Gridview_Adapter$8

/* anonymous class */
    class Home_Gridview_Adapter._cls8
        implements android.view.View.OnClickListener
    {

        final Home_Gridview_Adapter this$0;
        private final int val$myPosition;

        public void onClick(View view)
        {
            MobclickAgent.onEvent(Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this), "share");
            view = (new StringBuilder("Share: http://android.downloadatoz.com/apps/")).append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getId()).append(",").append(((DownloadMovieItem)Home_Gridview_Adapter.access$9(Home_Gridview_Adapter.this).get(myPosition)).getSerial()).append(".html").toString();
            Log.e("location", view);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", view);
            Home_Gridview_Adapter.access$0(Home_Gridview_Adapter.this).startActivity(Intent.createChooser(intent, "AIO Downloaded").addFlags(0x10000000));
            (new Handler()).post(new Home_Gridview_Adapter._cls8._cls1());
        }


            
            {
                this$0 = final_home_gridview_adapter;
                myPosition = I.this;
                super();
            }
    }

}
