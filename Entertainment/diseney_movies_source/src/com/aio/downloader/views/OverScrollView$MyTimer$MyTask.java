// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

// Referenced classes of package com.aio.downloader.views:
//            OverScrollView

class handler extends TimerTask
{

    private Handler handler;
    final handler this$1;

    public void run()
    {
        handler.obtainMessage().sendToTarget();
    }

    public (Handler handler1)
    {
        this$1 = this._cls1.this;
        super();
        handler = handler1;
    }
}
