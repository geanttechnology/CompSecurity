// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.utils.publicTools;
import java.util.List;

// Referenced classes of package com.aio.downloader.adapter:
//            FunAllAdapter

class this._cls1 extends Thread
{

    final l_like this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_like).toString());
        publicTools.getUrl(l_like);
    }

    l.position()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/adapter/FunAllAdapter$8

/* anonymous class */
    class FunAllAdapter._cls8
        implements android.view.View.OnClickListener
    {

        final FunAllAdapter this$0;
        private String url_like;
        private final int val$position;

        public void onClick(View view)
        {
            url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).getSerial()).toString();
            (new FunAllAdapter._cls8._cls1()).start();
            if (!((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).isLikenum())
            {
                ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).setLikenum(true);
                ((ImageView)view).setImageResource(0x7f0200bd);
                return;
            } else
            {
                ((FunModel)FunAllAdapter.access$0(FunAllAdapter.this).get(position)).setLikenum(false);
                ((ImageView)view).setImageResource(0x7f0200bc);
                return;
            }
        }


            
            {
                this$0 = final_funalladapter;
                position = I.this;
                super();
            }
    }

}
