// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Listview_Adapter

class this._cls1 extends Thread
{

    final l_like this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_like).toString());
        publicTools.getUrl(l_like);
    }

    l.ppp()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/Home_Listview_Adapter$13

/* anonymous class */
    class Home_Listview_Adapter._cls13
        implements android.view.View.OnClickListener
    {

        final Home_Listview_Adapter this$0;
        private String url_like;
        private final int val$ppp;

        public void onClick(View view)
        {
            url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).getSerial()).toString();
            (new Home_Listview_Adapter._cls13._cls1()).start();
            if (!((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).isLikenum())
            {
                ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).setLikenum(true);
                ((ImageView)view).setImageResource(0x7f0200bd);
                return;
            } else
            {
                ((FunModel)Home_Listview_Adapter.access$1(Home_Listview_Adapter.this).get(ppp)).setLikenum(false);
                ((ImageView)view).setImageResource(0x7f0200bc);
                return;
            }
        }


            
            {
                this$0 = final_home_listview_adapter;
                ppp = I.this;
                super();
            }
    }

}
