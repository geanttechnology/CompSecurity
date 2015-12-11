// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;


// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequestQueue, DownloadRequest, DownloadStatusListener

class val.progress
    implements Runnable
{

    final val.progress this$1;
    final long val$downloadedBytes;
    final int val$progress;
    final DownloadRequest val$request;
    final long val$totalBytes;

    public void run()
    {
        val$request.getDownloadListener().onProgress(val$request.getDownloadId(), val$totalBytes, val$downloadedBytes, val$progress);
    }

    ()
    {
        this$1 = final_;
        val$request = downloadrequest;
        val$totalBytes = l;
        val$downloadedBytes = l1;
        val$progress = I.this;
        super();
    }
}
