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

    final l_pics this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_pics).toString());
        publicTools.getUrl(l_pics);
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/FunAllAdapter$1

/* anonymous class */
    class FunAllAdapter._cls1
        implements android.view.View.OnClickListener
    {

        final FunAllAdapter this$0;
        private String url_pics;
        private final int val$position;

        public void onClick(View view)
        {
            Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getFunlist()).toString());
            url_pics = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial()).toString();
            (new FunAllAdapter._cls1._cls1()).start();
            view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/aio/downloader/activity/FunImagePagerActivity);
            view.putExtra("screenshotlist", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getFunlist());
            view.putExtra("detailtitle", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getTitle());
            view.putExtra("detailcount", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getImg_count());
            view.putExtra("detailserial", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial());
            view.putExtra("gag", 0);
            FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
        }


            
            {
                this$0 = final_funalladapter;
                position = I.this;
                super();
            }
    }

}
