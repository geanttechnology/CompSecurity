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

class this._cls0
    implements android.view.gerActivity._cls10
{

    final FunImagePagerActivity this$0;
    private String url_like;

    public void onClick(View view)
    {
        FunImagePagerActivity.access$16(FunImagePagerActivity.this).setImageResource(0x7f0200ba);
        url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(FunImagePagerActivity.access$17(FunImagePagerActivity.this)).toString();
        (new Thread() {

            final FunImagePagerActivity._cls10 this$1;

            public void run()
            {
                super.run();
                Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                publicTools.getUrl(url_like);
            }

            
            {
                this$1 = FunImagePagerActivity._cls10.this;
                super();
            }
        }).start();
    }


    _cls1.this._cls1()
    {
        this$0 = FunImagePagerActivity.this;
        super();
    }
}
