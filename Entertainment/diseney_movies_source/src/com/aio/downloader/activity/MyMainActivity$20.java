// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends Thread
{

    final MyMainActivity this$0;

    public void run()
    {
        super.run();
        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_mp4&action=")).append(MyMainActivity.access$83(MyMainActivity.this)).toString());
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
