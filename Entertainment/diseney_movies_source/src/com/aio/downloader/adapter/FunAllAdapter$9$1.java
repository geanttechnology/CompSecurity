// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            FunAllAdapter

class this._cls1 extends Thread
{

    final l_share this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_share).toString());
        publicTools.getUrl(l_share);
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/FunAllAdapter$9

/* anonymous class */
    class FunAllAdapter._cls9
        implements android.view.View.OnClickListener
    {

        final FunAllAdapter this$0;
        private String url_share;
        private final int val$position;

        public void onClick(View view)
        {
            url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial()).toString();
            (new FunAllAdapter._cls9._cls1()).start();
            view = (new StringBuilder("Share: ")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getTitle()).append("\nhttp://welaf.com/fun/share.php?id=").append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial()).toString();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", view);
            FunAllAdapter.access$1(FunAllAdapter.this).startActivity(Intent.createChooser(intent, "AIO Downloaded"));
        }


            
            {
                this$0 = final_funalladapter;
                position = I.this;
                super();
            }
    }

}
