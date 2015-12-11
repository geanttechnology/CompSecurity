// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.view.View;
import android.widget.ImageView;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.activity:
//            MyDownloaderList

class this._cls0
    implements android.view.r
{

    final MyDownloaderList this$0;

    public void onClick(View view)
    {
        if (MyDownloaderList.access$20(MyDownloaderList.this).booleanValue())
        {
            MyDownloaderList.access$8(MyDownloaderList.this).pause();
            MyDownloaderList.access$21(MyDownloaderList.this).setBackgroundResource(0x7f02015a);
            MyDownloaderList.access$22(MyDownloaderList.this, Boolean.valueOf(false));
            return;
        } else
        {
            MyDownloaderList.access$8(MyDownloaderList.this).play();
            MyDownloaderList.access$21(MyDownloaderList.this).setBackgroundResource(0x7f02015e);
            MyDownloaderList.access$22(MyDownloaderList.this, Boolean.valueOf(true));
            return;
        }
    }

    ()
    {
        this$0 = MyDownloaderList.this;
        super();
    }
}
