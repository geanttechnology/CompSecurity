// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.util.Log;
import com.aio.downloader.utils.publicTools;

// Referenced classes of package com.aio.downloader.activity:
//            FunImagePagerActivity

class this._cls0 extends Thread
{

    final FunImagePagerActivity this$0;

    public void run()
    {
        super.run();
        Log.e("www", (new StringBuilder("url=")).append(FunImagePagerActivity.access$19(FunImagePagerActivity.this)).toString());
        publicTools.getUrl(FunImagePagerActivity.access$19(FunImagePagerActivity.this));
    }

    _cls9()
    {
        this$0 = FunImagePagerActivity.this;
        super();
    }
}
