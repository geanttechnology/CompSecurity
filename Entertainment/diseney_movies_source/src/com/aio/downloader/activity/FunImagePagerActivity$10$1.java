// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

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

    // Unreferenced inner class com/aio/downloader/activity/FunImagePagerActivity$10

/* anonymous class */
    class FunImagePagerActivity._cls10
        implements android.view.View.OnClickListener
    {

        final FunImagePagerActivity this$0;
        private String url_like;

        public void onClick(View view)
        {
            FunImagePagerActivity.access$16(FunImagePagerActivity.this).setImageResource(0x7f0200ba);
            url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(FunImagePagerActivity.access$17(FunImagePagerActivity.this)).toString();
            (new FunImagePagerActivity._cls10._cls1()).start();
        }


            
            {
                this$0 = FunImagePagerActivity.this;
                super();
            }
    }

}
