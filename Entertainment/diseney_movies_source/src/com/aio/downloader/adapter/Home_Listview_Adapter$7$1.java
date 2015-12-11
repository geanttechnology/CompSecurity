// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.FunImagePagerActivity;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Listview_Adapter

class this._cls1 extends Thread
{

    final l_adult_bt this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_adult_bt).toString());
        publicTools.getUrl(l_adult_bt);
    }

    l.ppp()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_Listview_Adapter$7

/* anonymous class */
    class Home_Listview_Adapter._cls7
        implements android.view.View.OnClickListener
    {

        final Home_Listview_Adapter this$0;
        private String url_adult_bt;
        private final int val$ppp;

        public void onClick(View view)
        {
            Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getFunlist()).toString());
            url_adult_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getSerial()).toString();
            (new Home_Listview_Adapter._cls7._cls1()).start();
            view = new Intent(Home_Listview_Adapter.access$0(Home_Listview_Adapter.this), com/aio/downloader/activity/FunImagePagerActivity);
            view.putExtra("screenshotlist", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getFunlist());
            view.putExtra("detailtitle", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getTitle());
            view.putExtra("detailcount", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getImg_count());
            view.putExtra("detailserial", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getSerial());
            view.putExtra("gag", 0);
            Home_Listview_Adapter.access$0(Home_Listview_Adapter.this).startActivity(view);
        }


            
            {
                this$0 = final_home_listview_adapter;
                ppp = I.this;
                super();
            }
    }

}
