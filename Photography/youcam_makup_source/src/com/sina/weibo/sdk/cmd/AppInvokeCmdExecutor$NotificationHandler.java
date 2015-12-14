// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            AppInvokeCmdExecutor, AppInvokeCmd

class this._cls0 extends Handler
{

    final AppInvokeCmdExecutor this$0;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AppInvokeCmdExecutor.access$2(AppInvokeCmdExecutor.access$1(AppInvokeCmdExecutor.this), (AppInvokeCmd)message.obj);
            break;
        }
    }

    public (Looper looper)
    {
        this$0 = AppInvokeCmdExecutor.this;
        super(looper);
    }
}
