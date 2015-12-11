// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_app_Listview_Adapter

class val.ppp
    implements android.view.ew_Adapter._cls14
{

    final Home_app_Listview_Adapter this$0;
    private String url_like;
    private final int val$ppp;

    public void onClick(View view)
    {
        url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).getSerial()).toString();
        (new Thread() {

            final Home_app_Listview_Adapter._cls14 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                publicTools.getUrl(url_like);
            }

            
            {
                this$1 = Home_app_Listview_Adapter._cls14.this;
                super();
            }
        }).start();
        if (!((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).isLikenum())
        {
            ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).setLikenum(true);
            ((ImageView)view).setImageResource(0x7f0200bd);
            return;
        } else
        {
            ((Fun_appModel)Home_app_Listview_Adapter.access$1(Home_app_Listview_Adapter.this).get(val$ppp)).setLikenum(false);
            ((ImageView)view).setImageResource(0x7f0200bc);
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = final_home_app_listview_adapter;
        val$ppp = I.this;
        super();
    }
}
