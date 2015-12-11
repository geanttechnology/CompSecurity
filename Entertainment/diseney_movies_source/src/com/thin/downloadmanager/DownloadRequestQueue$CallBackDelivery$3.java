// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;


// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequestQueue, DownloadRequest, DownloadStatusListener

class val.errorMsg
    implements Runnable
{

    final val.errorMsg this$1;
    final int val$errorCode;
    final String val$errorMsg;
    final DownloadRequest val$request;

    public void run()
    {
        val$request.getDownloadListener().onDownloadFailed(val$request.getDownloadId(), val$errorCode, val$errorMsg);
    }

    ()
    {
        this$1 = final_;
        val$request = downloadrequest;
        val$errorCode = i;
        val$errorMsg = String.this;
        super();
    }
}
