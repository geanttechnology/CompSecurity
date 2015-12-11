// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Listview_Adapter

class this._cls1 extends Thread
{

    final l_share this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_share).toString());
        publicTools.getUrl(l_share);
    }

    l.ppp()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_Listview_Adapter$14

/* anonymous class */
    class Home_Listview_Adapter._cls14
        implements android.view.View.OnClickListener
    {

        final Home_Listview_Adapter this$0;
        private String url_share;
        private final int val$ppp;

        public void onClick(View view)
        {
            url_share = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getSerial()).append("&type=share").toString();
            (new Home_Listview_Adapter._cls14._cls1()).start();
            view = new Intent("android.intent.action.SEND");
            view.setType("text/plain");
            view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
            Home_Listview_Adapter.access$0(Home_Listview_Adapter.this).startActivity(Intent.createChooser(view, "AIO Downloaded").addFlags(0x10000000));
            MobclickAgent.onEvent(Home_Listview_Adapter.access$0(Home_Listview_Adapter.this), "share");
        }


            
            {
                this$0 = final_home_listview_adapter;
                ppp = I.this;
                super();
            }
    }

}
