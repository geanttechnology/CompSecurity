// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.start;

import android.content.Intent;
import com.aio.downloader.activity.MyDownloaderList;

// Referenced classes of package com.aio.downloader.start:
//            MainActivity

class this._cls0
    implements Runnable
{

    final MainActivity this$0;

    public void run()
    {
        Intent intent = new Intent(MainActivity.this, com/aio/downloader/activity/MyDownloaderList);
        intent.putExtra("acquire_url_start", "");
        startActivity(intent);
        finish();
        overridePendingTransition(0x7f04000c, 0x7f040011);
    }

    ist()
    {
        this$0 = MainActivity.this;
        super();
    }
}
