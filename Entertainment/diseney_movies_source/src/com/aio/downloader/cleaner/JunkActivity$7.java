// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.wjj.manager.UnloadingResidueManager;
import java.io.File;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0 extends Thread
{

    final JunkActivity this$0;

    public void run()
    {
        super.run();
        JunkActivity.access$22(JunkActivity.this, JunkActivity.access$59(JunkActivity.this).GGGfile(new File(Environment.getExternalStorageDirectory().getPath())));
        Message message = JunkActivity.access$55(JunkActivity.this).obtainMessage();
        message.obj = JunkActivity.access$23(JunkActivity.this);
        message.what = 5;
        JunkActivity.access$55(JunkActivity.this).sendMessage(message);
    }

    ()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
