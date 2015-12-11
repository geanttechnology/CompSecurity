// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.refresh;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.aio.downloader.refresh:
//            PullToRefreshLayout

class this._cls0 extends Handler
{

    final PullToRefreshLayout this$0;

    public void handleMessage(Message message)
    {
        PullToRefreshLayout.access$5(PullToRefreshLayout.this, 3);
        if (!PullToRefreshLayout.access$0(PullToRefreshLayout.this))
        {
            PullToRefreshLayout.access$6(PullToRefreshLayout.this);
        }
    }

    ()
    {
        this$0 = PullToRefreshLayout.this;
        super();
    }
}
