// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.FunImagePagerActivity;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class this._cls1 extends Thread
{

    final l_gag this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_gag).toString());
        publicTools.getUrl(l_gag);
    }

    l.ppp()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_app_Listview_Adapter$13

/* anonymous class */
    class Home_app_Listview_Adapter._cls13
        implements android.view.View.OnClickListener
    {

        final Home_app_Listview_Adapter this$0;
        private String url_gag;
        private final int val$ppp;

        public void onClick(View view)
        {
            Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getFunlist()).toString());
            url_gag = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getSerial()).toString();
            (new Home_app_Listview_Adapter._cls13._cls1()).start();
            view = new Intent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), com/aio/downloader/activity/FunImagePagerActivity);
            view.putExtra("screenshotlist", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getFunlist());
            view.putExtra("detailtitle", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getTitle());
            view.putExtra("detailcount", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(ppp)).getImg_count());
            view.putExtra("gag", 1);
            Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(view);
        }


            
            {
                this$0 = final_home_app_listview_adapter;
                ppp = I.this;
                super();
            }
    }

}
