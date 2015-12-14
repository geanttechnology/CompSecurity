// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.disk;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.framework.network.disk:
//            ContentLoadCallback, CloudDriveNetworkStore

class val.countDownLatch
    implements ContentLoadCallback
{

    final CloudDriveNetworkStore this$0;
    final CountDownLatch val$countDownLatch;

    public void onContentLoadFailure()
    {
        val$countDownLatch.countDown();
    }

    public void onContentLoadSuccess()
    {
        val$countDownLatch.countDown();
    }

    ()
    {
        this$0 = final_clouddrivenetworkstore;
        val$countDownLatch = CountDownLatch.this;
        super();
    }
}
