// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;
import com.wjj.eneity.RuningApp;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0
    implements com.wjj.manager.r.RuningAppManagerListener
{

    final JunkActivity this$0;

    public void DownCountSize(long l, RuningApp runingapp)
    {
        Message message = new Message();
        message.obj = Long.valueOf(l);
        message.what = 2;
        JunkActivity.access$55(JunkActivity.this).sendMessage(message);
        message = new Message();
        message.obj = runingapp;
        message.what = 22;
        JunkActivity.access$55(JunkActivity.this).sendMessage(message);
    }

    ManagerListener()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
