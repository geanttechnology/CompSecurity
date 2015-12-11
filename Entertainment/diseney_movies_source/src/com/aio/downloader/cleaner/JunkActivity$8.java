// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;
import com.wjj.manager.RuningAppManager;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0 extends Thread
{

    final JunkActivity this$0;

    public void run()
    {
        super.run();
        JunkActivity.access$0(JunkActivity.this, JunkActivity.access$60(JunkActivity.this).getRuningUserApp(JunkActivity.access$61(JunkActivity.this)));
        Message message = JunkActivity.access$55(JunkActivity.this).obtainMessage();
        message.obj = JunkActivity.access$47(JunkActivity.this);
        message.what = 1;
        JunkActivity.access$55(JunkActivity.this).sendMessage(message);
    }

    ()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
