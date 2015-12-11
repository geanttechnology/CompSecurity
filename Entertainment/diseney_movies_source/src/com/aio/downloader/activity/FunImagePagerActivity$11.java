// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

class this._cls0
    implements android.view.gerActivity._cls11
{

    final FunImagePagerActivity this$0;
    private String url_share;

    public void onClick(View view)
    {
        url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(FunImagePagerActivity.access$17(FunImagePagerActivity.this)).toString();
        (new Thread() {

            final FunImagePagerActivity._cls11 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                publicTools.getUrl(url_share);
            }

            
            {
                this$1 = FunImagePagerActivity._cls11.this;
                super();
            }
        }).start();
        view = (new StringBuilder("Share: ")).append(FunImagePagerActivity.access$18(FunImagePagerActivity.this)).append("\nhttp://welaf.com/fun/share.php?id=").append(FunImagePagerActivity.access$17(FunImagePagerActivity.this)).toString();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", view);
        startActivity(Intent.createChooser(intent, "AIO Downloaded"));
    }


    _cls1.this._cls1()
    {
        this$0 = FunImagePagerActivity.this;
        super();
    }
}
