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

class val.position
    implements android.view.ener
{

    final FunAllAdapter this$0;
    private String url_video_bt;
    private final int val$position;

    public void onClick(View view)
    {
        url_video_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial()).toString();
        (new Thread() {

            final FunAllAdapter._cls6 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=")).append(url_video_bt).toString());
                publicTools.getUrl(url_video_bt);
            }

            
            {
                this$1 = FunAllAdapter._cls6.this;
                super();
            }
        }).start();
        view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/aio/downloader/activity/ShowAideoActivity);
        view.putExtra("strurl", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getVideo_src());
        FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
    }


    _cls1.this._cls1()
    {
        this$0 = final_funalladapter;
        val$position = I.this;
        super();
    }
}
