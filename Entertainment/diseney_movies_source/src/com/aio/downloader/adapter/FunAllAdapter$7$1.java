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
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            FunAllAdapter

class this._cls1 extends Thread
{

    final l this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=")).append(l).toString());
        publicTools.getUrl(l);
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/FunAllAdapter$7

/* anonymous class */
    class FunAllAdapter._cls7
        implements android.view.View.OnClickListener
    {

        final FunAllAdapter this$0;
        private String url;
        private final int val$position;

        public void onClick(View view)
        {
            Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getFunlist()).toString());
            url = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial()).toString();
            (new FunAllAdapter._cls7._cls1()).start();
            view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/aio/downloader/activity/FunImagePagerActivity);
            view.putExtra("screenshotlist", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getFunlist());
            view.putExtra("detailtitle", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getTitle());
            view.putExtra("detailcount", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getImg_count());
            view.putExtra("gag", 1);
            FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
        }


            
            {
                this$0 = final_funalladapter;
                position = I.this;
                super();
            }
    }

}
