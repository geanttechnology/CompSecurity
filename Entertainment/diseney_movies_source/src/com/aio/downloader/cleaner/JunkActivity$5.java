// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            JunkActivity

class this._cls0
    implements com.wjj.manager.ger.RubSoftwareManagerListener
{

    final JunkActivity this$0;

    public void DownCount(List list, long l)
    {
        list = new Message();
        list.obj = Long.valueOf(l);
        list.what = 4;
        JunkActivity.access$55(JunkActivity.this).sendMessage(list);
    }

    wareManagerListener()
    {
        this$0 = JunkActivity.this;
        super();
    }
}
