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

class val.position
    implements android.view.ener
{

    final FunAllAdapter this$0;
    private String url_pics_bt;
    private final int val$position;

    public void onClick(View view)
    {
        Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getFunlist()).toString());
        url_pics_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial()).toString();
        (new Thread() {

            final FunAllAdapter._cls2 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_pics_bt).toString());
                publicTools.getUrl(url_pics_bt);
            }

            
            {
                this$1 = FunAllAdapter._cls2.this;
                super();
            }
        }).start();
        view = new Intent(FunAllAdapter.access$1(FunAllAdapter.this), com/aio/downloader/activity/FunImagePagerActivity);
        view.putExtra("screenshotlist", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getFunlist());
        view.putExtra("detailtitle", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getTitle());
        view.putExtra("detailcount", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getImg_count());
        view.putExtra("detailserial", ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(val$position)).getSerial());
        view.putExtra("gag", 0);
        FunAllAdapter.access$1(FunAllAdapter.this).startActivity(view);
    }


    _cls1.this._cls1()
    {
        this$0 = final_funalladapter;
        val$position = I.this;
        super();
    }
}
