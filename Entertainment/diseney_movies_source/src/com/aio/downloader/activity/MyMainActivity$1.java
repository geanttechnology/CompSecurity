// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity

class this._cls0 extends Handler
{

    final MyMainActivity this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1001 1001: default 24
    //                   1001 30;
           goto _L1 _L2
_L1:
        super.handleMessage(message);
        return;
_L2:
        (new a6(MyMainActivity.this)).execute(new Void[0]);
        if (true) goto _L1; else goto _L3
_L3:
    }

    a6()
    {
        this$0 = MyMainActivity.this;
        super();
    }
}
