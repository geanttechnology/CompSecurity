// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.activity.FunGifActivity;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            FunAllAdapter

class val.position
    implements android.view.ener
{

    final FunAllAdapter this$0;
    private String url_gif_bt;
    private final int val$position;

    public void onClick(View view)
    {
        url_gif_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial()).toString();
        (new Thread() {

            final FunAllAdapter._cls4 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_gif_bt).toString());
                publicTools.getUrl(url_gif_bt);
            }

            
            {
                this$1 = FunAllAdapter._cls4.this;
                super();
            }
        }).start();
        view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/aio/downloader/activity/FunGifActivity);
        view.putExtra("fullpath", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getImg_src());
        view.putExtra("apath", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getThu_path());
        view.putExtra("detailtitle", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getTitle());
        view.putExtra("detailcount", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getImg_count());
        view.putExtra("detailserial", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial());
        FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
    }


    _cls1.this._cls1()
    {
        this$0 = final_funalladapter;
        val$position = I.this;
        super();
    }
}
