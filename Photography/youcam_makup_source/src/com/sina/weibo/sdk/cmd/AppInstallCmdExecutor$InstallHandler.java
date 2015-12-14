// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.cmd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.sina.weibo.sdk.cmd:
//            AppInstallCmd, AppInstallCmdExecutor

class this._cls0 extends Handler
{

    final AppInstallCmdExecutor this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            AppInstallCmdExecutor.access$1(AppInstallCmdExecutor.this, (AppInstallCmd)message.obj);
            return;

        case 2: // '\002'
            AppInstallCmdExecutor.access$2(AppInstallCmdExecutor.this).quit();
            break;
        }
        AppInstallCmdExecutor.access$3(AppInstallCmdExecutor.this, false);
    }

    public A(Looper looper)
    {
        this$0 = AppInstallCmdExecutor.this;
        super(looper);
    }
}
