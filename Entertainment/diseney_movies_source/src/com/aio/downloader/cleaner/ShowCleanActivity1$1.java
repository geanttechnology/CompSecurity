// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.os.Handler;
import android.os.Message;
import android.widget.Button;

// Referenced classes of package com.aio.downloader.cleaner:
//            ShowCleanActivity1

class this._cls0 extends Handler
{

    final ShowCleanActivity1 this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 100)
        {
            ShowCleanActivity1.access$0(ShowCleanActivity1.this).performClick();
            ShowCleanActivity1.access$1(ShowCleanActivity1.this).setVisibility(0);
        }
    }

    ()
    {
        this$0 = ShowCleanActivity1.this;
        super();
    }
}
