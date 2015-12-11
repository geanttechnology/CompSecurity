// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.ShowAideoActivity;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            FunAllAdapter

class this._cls1 extends Thread
{

    final l_video_bt this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=")).append(l_video_bt).toString());
        publicTools.getUrl(l_video_bt);
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/FunAllAdapter$6

/* anonymous class */
    class FunAllAdapter._cls6
        implements android.view.View.OnClickListener
    {

        final FunAllAdapter this$0;
        private String url_video_bt;
        private final int val$position;

        public void onClick(View view)
        {
            url_video_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial()).toString();
            (new FunAllAdapter._cls6._cls1()).start();
            view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/aio/downloader/activity/ShowAideoActivity);
            view.putExtra("strurl", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getVideo_src());
            FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
        }


            
            {
                this$0 = final_funalladapter;
                position = I.this;
                super();
            }
    }

}
