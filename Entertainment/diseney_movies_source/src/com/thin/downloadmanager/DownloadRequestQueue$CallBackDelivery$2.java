// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;


// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequestQueue, DownloadRequest, DownloadStatusListener

class val.request
    implements Runnable
{

    final val.request this$1;
    final DownloadRequest val$request;

    public void run()
    {
        val$request.getDownloadListener().onDownloadComplete(val$request.getDownloadId());
    }

    ()
    {
        this$1 = final_;
        val$request = DownloadRequest.this;
        super();
    }
}
