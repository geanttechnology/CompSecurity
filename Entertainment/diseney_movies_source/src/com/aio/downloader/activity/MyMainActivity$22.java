// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.content.Intent;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends TimerTask
{

    final MyMainActivity this$0;

    public void run()
    {
        Intent intent = new Intent("\u53D1\u9001\u5E7F\u64AD");
        sendBroadcast(intent);
    }

    ()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
