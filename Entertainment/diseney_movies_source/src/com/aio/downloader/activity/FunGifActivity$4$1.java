// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            FunGifActivity

class this._cls1 extends Thread
{

    final l_share this$1;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=+")).append(l_share).toString());
        publicTools.getUrl(l_share);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/activity/FunGifActivity$4

/* anonymous class */
    class FunGifActivity._cls4
        implements android.view.View.OnClickListener
    {

        final FunGifActivity this$0;
        private String url_share;

        public void onClick(View view)
        {
            url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(FunGifActivity.access$6(FunGifActivity.this)).toString();
            (new FunGifActivity._cls4._cls1()).start();
            view = (new StringBuilder("Share: ")).append(FunGifActivity.access$7(FunGifActivity.this)).append("\nhttp://welaf.com/fun/share.php?id=").append(FunGifActivity.access$6(FunGifActivity.this)).toString();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", view);
            startActivity(Intent.createChooser(intent, "AIO Downloaded"));
        }


            
            {
                this$0 = FunGifActivity.this;
                super();
            }
    }

}
