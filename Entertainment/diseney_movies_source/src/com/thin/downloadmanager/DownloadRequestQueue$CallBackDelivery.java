// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;

import android.os.Handler;
import java.util.concurrent.Executor;

// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequestQueue, DownloadRequest, DownloadStatusListener

class _cls1.val.handler
{

    private final Executor mCallBackExecutor;
    final DownloadRequestQueue this$0;

    public void postDownloadComplete(final DownloadRequest request)
    {
        mCallBackExecutor.execute(new Runnable() {

            final DownloadRequestQueue.CallBackDelivery this$1;
            final DownloadRequest val$request;

            public void run()
            {
                request.getDownloadListener().onDownloadComplete(request.getDownloadId());
            }

            
            {
                this$1 = DownloadRequestQueue.CallBackDelivery.this;
                request = downloadrequest;
                super();
            }
        });
    }

    public void postDownloadFailed(final DownloadRequest request, final int errorCode, final String errorMsg)
    {
        mCallBackExecutor.execute(new Runnable() {

            final DownloadRequestQueue.CallBackDelivery this$1;
            final int val$errorCode;
            final String val$errorMsg;
            final DownloadRequest val$request;

            public void run()
            {
                request.getDownloadListener().onDownloadFailed(request.getDownloadId(), errorCode, errorMsg);
            }

            
            {
                this$1 = DownloadRequestQueue.CallBackDelivery.this;
                request = downloadrequest;
                errorCode = i;
                errorMsg = s;
                super();
            }
        });
    }

    public void postProgressUpdate(final DownloadRequest request, final long totalBytes, final long downloadedBytes, final int progress)
    {
        mCallBackExecutor.execute(new Runnable() {

            final DownloadRequestQueue.CallBackDelivery this$1;
            final long val$downloadedBytes;
            final int val$progress;
            final DownloadRequest val$request;
            final long val$totalBytes;

            public void run()
            {
                request.getDownloadListener().onProgress(request.getDownloadId(), totalBytes, downloadedBytes, progress);
            }

            
            {
                this$1 = DownloadRequestQueue.CallBackDelivery.this;
                request = downloadrequest;
                totalBytes = l;
                downloadedBytes = l1;
                progress = i;
                super();
            }
        });
    }

    public _cls4.val.progress(final Handler handler)
    {
        this.this$0 = DownloadRequestQueue.this;
        super();
        mCallBackExecutor = new Executor() {

            final DownloadRequestQueue.CallBackDelivery this$1;
            final Handler val$handler;
            final DownloadRequestQueue val$this$0;

            public void execute(Runnable runnable)
            {
                handler.post(runnable);
            }

            
            {
                this$1 = DownloadRequestQueue.CallBackDelivery.this;
                this$0 = downloadrequestqueue;
                handler = handler1;
                super();
            }
        };
    }
}
