// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.media.MediaMetadataRetriever;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            SeekBarThumbnailStore, FrameProcessor

class val.latch
    implements Runnable
{

    final val.latch this$1;
    final FrameProcessor val$frameProcessor;
    final String val$identifier;
    final int val$index;
    final CountDownLatch val$latch;
    final long val$period;
    final MediaMetadataRetriever val$retriever;

    public void run()
    {
        android.graphics.Bitmap bitmap;
        long l = val$period;
        long l1 = val$index;
        bitmap = val$retriever.getFrameAtTime(l * l1 * 1000L, 2);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        bitmap = val$frameProcessor.process(bitmap);
        SeekBarThumbnailStore.access$600(_fld0, bitmap, val$index, val$identifier);
        val$latch.countDown();
        return;
        Exception exception;
        exception;
        val$latch.countDown();
        throw exception;
    }

    Q()
    {
        this$1 = final_q;
        val$period = l;
        val$index = i;
        val$retriever = mediametadataretriever;
        val$frameProcessor = frameprocessor;
        val$identifier = s;
        val$latch = CountDownLatch.this;
        super();
    }
}
