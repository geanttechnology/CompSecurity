// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            FunGifActivity

class this._cls1 extends Thread
{

    final l_like this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_like).toString());
        publicTools.getUrl(l_like);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/FunGifActivity$3

/* anonymous class */
    class FunGifActivity._cls3
        implements android.view.View.OnClickListener
    {

        final FunGifActivity this$0;
        private String url_like;

        public void onClick(View view)
        {
            FunGifActivity.access$5(FunGifActivity.this).setImageResource(0x7f0200ba);
            url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(FunGifActivity.access$6(FunGifActivity.this)).toString();
            (new FunGifActivity._cls3._cls1()).start();
        }


            
            {
                this$0 = FunGifActivity.this;
                super();
            }
    }

}
