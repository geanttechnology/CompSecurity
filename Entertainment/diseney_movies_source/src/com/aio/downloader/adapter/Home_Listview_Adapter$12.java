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

class val.ppp
    implements android.view.ew_Adapter._cls12
{

    final Home_Listview_Adapter this$0;
    private String url_gag;
    private final int val$ppp;

    public void onClick(View view)
    {
        Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getFunlist()).toString());
        url_gag = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getSerial()).toString();
        (new Thread() {

            final Home_Listview_Adapter._cls12 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_gag).toString());
                publicTools.getUrl(url_gag);
            }

            
            {
                this$1 = Home_Listview_Adapter._cls12.this;
                super();
            }
        }).start();
        view = new Intent(Home_Listview_Adapter.access$0(Home_Listview_Adapter.this), com/aio/downloader/activity/FunImagePagerActivity);
        view.putExtra("screenshotlist", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getFunlist());
        view.putExtra("detailtitle", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getTitle());
        view.putExtra("detailcount", ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(val$ppp)).getImg_count());
        view.putExtra("gag", 1);
        Home_Listview_Adapter.access$0(Home_Listview_Adapter.this).startActivity(view);
    }


    _cls1.this._cls1()
    {
        this$0 = final_home_listview_adapter;
        val$ppp = I.this;
        super();
    }
}
