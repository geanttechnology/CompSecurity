// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequestQueue

class val.handler
    implements Executor
{

    final val.handler this$1;
    final Handler val$handler;
    final DownloadRequestQueue val$this$0;

    public void execute(Runnable runnable)
    {
        val$handler.post(runnable);
    }

    ()
    {
        this$1 = final_;
        val$this$0 = downloadrequestqueue;
        val$handler = Handler.this;
        super();
    }
}
