// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0
    implements com.wjj.manager.SoftApkManagerListener2
{

    final JunkActivity this$0;

    public void DownCount(long l)
    {
        Message message = JunkActivity.access$55(JunkActivity.this).obtainMessage();
        message.obj = Long.valueOf(l);
        message.what = 7;
        JunkActivity.access$55(JunkActivity.this).sendMessage(message);
    }

    gerListener2()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
