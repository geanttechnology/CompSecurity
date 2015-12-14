// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.util.MutableBoolean;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.messaging.DownloadFinishedEvent;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.download.CustomDownloadId;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

class val.hasTerminated
    implements ompleteListener
{

    final val.hasTerminated this$1;
    final CustomDownloadId val$customDownloadId;
    final CountDownLatch val$hasTerminated;
    final MutableBoolean val$success;

    public void onDownloadComplete(DownloadFinishedEvent downloadfinishedevent)
    {
        if (quest.access._mth500(cess._mth400(this._cls1.this)).getObjectId().equals(val$customDownloadId.getMediaItemObjectId()))
        {
            GLogger.i(VideoTranscodeService.access$600(), "Download success: %b request: %s", new Object[] {
                Boolean.valueOf(downloadfinishedevent.isSuccessful()), cess._mth400(this._cls1.this).getId()
            });
            val$success.value = downloadfinishedevent.isSuccessful();
            val$hasTerminated.countDown();
        }
    }

    quest()
    {
        this$1 = final_quest;
        val$customDownloadId = customdownloadid;
        val$success = mutableboolean;
        val$hasTerminated = CountDownLatch.this;
        super();
    }
}
