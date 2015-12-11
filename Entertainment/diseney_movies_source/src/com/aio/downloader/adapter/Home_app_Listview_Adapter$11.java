// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.ShowAideoActivity;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class val.ppp
    implements android.view.ew_Adapter._cls11
{

    final Home_app_Listview_Adapter this$0;
    private String url_video;
    private final int val$ppp;

    public void onClick(View view)
    {
        url_video = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).getSerial()).toString();
        (new Thread() {

            final Home_app_Listview_Adapter._cls11 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_video).toString());
                publicTools.getUrl(url_video);
            }

            
            {
                this$1 = Home_app_Listview_Adapter._cls11.this;
                super();
            }
        }).start();
        view = new Intent(Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this), com/aio/downloader/activity/ShowAideoActivity);
        view.putExtra("strurl", ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).getVideo_src());
        Home_app_Listview_Adapter.access$0(Home_app_Listview_Adapter.this).startActivity(view);
    }


    _cls1.this._cls1()
    {
        this$0 = final_home_app_listview_adapter;
        val$ppp = I.this;
        super();
    }
}
