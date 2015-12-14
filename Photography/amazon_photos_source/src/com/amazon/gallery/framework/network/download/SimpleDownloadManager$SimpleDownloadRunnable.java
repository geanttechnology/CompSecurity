// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.messaging.DownloadFinishedEvent;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.io.File;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            SimpleDownloadManager, DownloadStatusNotifier, CustomDownloadId, FileDownloadCallback

private class downloadRequest
    implements Runnable
{

    private final downloadRequest downloadRequest;
    final SimpleDownloadManager this$0;

    private void consume(downloadRequest downloadrequest)
    {
        CustomDownloadId customdownloadid;
        FileDownloadCallback filedownloadcallback;
        File file;
        SimpleDownloadManager.access$000(SimpleDownloadManager.this).incrementAndGet();
        customdownloadid = downloadrequest.d;
        file = downloadrequest.ile;
        GLogger.d(SimpleDownloadManager.access$100(), "Downloading %s", new Object[] {
            customdownloadid
        });
        SimpleDownloadManager.access$200(SimpleDownloadManager.this).onItemDownloadStarted(customdownloadid, file.getName());
        filedownloadcallback = getCallback(customdownloadid);
        if (customdownloadid.getMediaType() != MediaType.VIDEO) goto _L2; else goto _L1
_L1:
        downloadrequest = new pl(customdownloadid);
_L3:
        if (customdownloadid.getRequestType() != pl)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        SimpleDownloadManager.access$300(SimpleDownloadManager.this).getDownloadMediaItemOperation(file, downloadrequest).ation();
_L4:
        downloadrequest = (this._cls0)SimpleDownloadManager.access$400(SimpleDownloadManager.this).get(customdownloadid.getTag());
        if (downloadrequest != null && file.exists() && customdownloadid.getCategory() != 2)
        {
            downloadrequest.nqueue(file.getAbsolutePath());
        }
        int i;
        if (file.exists())
        {
            SimpleDownloadManager.access$200(SimpleDownloadManager.this).onItemDownloadCompleted(customdownloadid);
            GlobalMessagingBus.post(new DownloadFinishedEvent(customdownloadid, true));
            if (filedownloadcallback != null)
            {
                filedownloadcallback.onDownloadCompleted(customdownloadid, file);
            }
            if (SimpleDownloadManager.access$500(SimpleDownloadManager.this).isEmpty() && customdownloadid.getCategory() != 2)
            {
                ((this._cls0)SimpleDownloadManager.access$400(SimpleDownloadManager.this).get(ObjectID.getRoot())).lush();
            }
            return;
        } else
        {
            reportFailure(customdownloadid, filedownloadcallback);
            return;
        }
_L2:
        try
        {
            downloadrequest = new pl(customdownloadid);
        }
        // Misplaced declaration of an exception variable
        catch (downloadRequest downloadrequest)
        {
            GLogger.ex(SimpleDownloadManager.access$100(), downloadrequest.getMessage(), downloadrequest);
            reportFailure(customdownloadid, filedownloadcallback);
            return;
        }
          goto _L3
        i = MathUtils.roundPower2(Math.max(customdownloadid.getDesiredWidth(), customdownloadid.getDesiredHeight()));
        SimpleDownloadManager.access$300(SimpleDownloadManager.this).getDownloadMediaItemOperation(file, downloadrequest, i, customdownloadid.getMediaType()).ation();
          goto _L4
    }

    public this._cls0 getDownloadRequest()
    {
        return downloadRequest;
    }

    public void reportFailure(CustomDownloadId customdownloadid, FileDownloadCallback filedownloadcallback)
    {
        if (customdownloadid.getCategory() != 2)
        {
            SimpleDownloadManager.access$200(SimpleDownloadManager.this).onItemDownloadFailed(customdownloadid);
            GlobalMessagingBus.post(new DownloadFinishedEvent(customdownloadid, false));
            if (filedownloadcallback != null)
            {
                filedownloadcallback.onDownloadFail(customdownloadid, "unknown");
                return;
            }
        }
    }

    public void run()
    {
        GLogger.d(SimpleDownloadManager.access$100(), "Started DownloadConsumer thread", new Object[0]);
        consume(downloadRequest);
    }

    public pl(pl pl)
    {
        this$0 = SimpleDownloadManager.this;
        super();
        downloadRequest = pl;
    }
}
