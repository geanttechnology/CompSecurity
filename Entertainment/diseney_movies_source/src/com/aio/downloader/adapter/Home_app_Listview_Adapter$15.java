// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class val.ppp
    implements android.view.ew_Adapter._cls15
{

    final Home_app_Listview_Adapter this$0;
    private String url_share;
    private final int val$ppp;

    public void onClick(View view)
    {
        url_share = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).getSerial()).append("&type=share").toString();
        (new Thread() {

            final Home_app_Listview_Adapter._cls15 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                publicTools.getUrl(url_share);
            }

            
            {
                this$1 = Home_app_Listview_Adapter._cls15.this;
                super();
            }
        }).start();
        view = new Intent("android.intent.action.SEND");
        view.setType("text/plain");
        view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
        Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(Intent.createChooser(view, "AIO Downloaded").addFlags(0x10000000));
        MobclickAgent.onEvent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), "share");
    }


    _cls1.this._cls1()
    {
        this$0 = final_home_app_listview_adapter;
        val$ppp = I.this;
        super();
    }
}
