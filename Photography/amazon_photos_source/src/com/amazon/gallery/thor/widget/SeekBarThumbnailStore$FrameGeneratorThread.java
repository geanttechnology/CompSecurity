// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.io.File;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            SeekBarThumbnailStore, VideoFramesParams, RangeSeekBarFrameProcessor, FrameProcessor

private class video extends Thread
{

    final SeekBarThumbnailStore this$0;
    private final Video video;

    private void generateFrameThumbnails(VideoFramesParams videoframesparams, final String identifier)
    {
        final CountDownLatch latch;
        final MediaMetadataRetriever retriever;
        latch = new CountDownLatch(videoframesparams.framesCount);
        retriever = new MediaMetadataRetriever();
        final RangeSeekBarFrameProcessor frameProcessor = videoframesparams.videoUri.getScheme();
        if (!frameProcessor.equalsIgnoreCase("http") && !frameProcessor.equalsIgnoreCase("https")) goto _L2; else goto _L1
_L1:
        retriever.setDataSource(videoframesparams.videoUri.toString(), Collections.emptyMap());
_L5:
        final long period;
        period = (long)Integer.parseInt(retriever.extractMetadata(9)) / (long)videoframesparams.framesCount;
        frameProcessor = new RangeSeekBarFrameProcessor();
        final int index = 0;
_L4:
        if (index >= videoframesparams.framesCount)
        {
            break; /* Loop/switch isn't completed */
        }
        SeekBarThumbnailStore.access$700(SeekBarThumbnailStore.this).execute(new Runnable() {

            final SeekBarThumbnailStore.FrameGeneratorThread this$1;
            final FrameProcessor val$frameProcessor;
            final String val$identifier;
            final int val$index;
            final CountDownLatch val$latch;
            final long val$period;
            final MediaMetadataRetriever val$retriever;

            public void run()
            {
                android.graphics.Bitmap bitmap;
                long l = period;
                long l1 = index;
                bitmap = retriever.getFrameAtTime(l * l1 * 1000L, 2);
                if (bitmap == null)
                {
                    break MISSING_BLOCK_LABEL_61;
                }
                bitmap = frameProcessor.process(bitmap);
                SeekBarThumbnailStore.access$600(this$0, bitmap, index, identifier);
                latch.countDown();
                return;
                Exception exception;
                exception;
                latch.countDown();
                throw exception;
            }

            
            {
                this$1 = SeekBarThumbnailStore.FrameGeneratorThread.this;
                period = l;
                index = i;
                retriever = mediametadataretriever;
                frameProcessor = frameprocessor;
                identifier = s;
                latch = countdownlatch;
                super();
            }
        });
        index++;
        if (true) goto _L4; else goto _L3
_L2:
        retriever.setDataSource(SeekBarThumbnailStore.access$500(SeekBarThumbnailStore.this), videoframesparams.videoUri);
          goto _L5
        videoframesparams;
        SeekBarThumbnailStore.access$700(SeekBarThumbnailStore.this).execute(new Runnable() {

            final SeekBarThumbnailStore.FrameGeneratorThread this$1;
            final CountDownLatch val$latch;
            final MediaMetadataRetriever val$retriever;

            public void run()
            {
                while (latch.getCount() > 0L) 
                {
                    try
                    {
                        latch.await();
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        GLogger.w(SeekBarThumbnailStore.access$100(), "Thread interrupted...", new Object[0]);
                    }
                }
                retriever.release();
            }

            
            {
                this$1 = SeekBarThumbnailStore.FrameGeneratorThread.this;
                latch = countdownlatch;
                retriever = mediametadataretriever;
                super();
            }
        });
        throw videoframesparams;
_L3:
        SeekBarThumbnailStore.access$700(SeekBarThumbnailStore.this).execute(new _cls2());
        return;
    }

    public void run()
    {
        if (video != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        String s;
        s = SeekBarThumbnailStore.access$000(video);
        if (s.isEmpty())
        {
            GLogger.d(SeekBarThumbnailStore.access$100(), (new StringBuilder()).append("Could not compute identifier for the video: ").append(video.getName()).toString(), new Object[0]);
            return;
        }
        obj = new File(SeekBarThumbnailStore.access$200(SeekBarThumbnailStore.this), s);
        if (SeekBarThumbnailStore.access$300(SeekBarThumbnailStore.this, ((File) (obj)))) goto _L1; else goto _L3
_L3:
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        if (!MediaItemUtil.isLocalMediaItem(video)) goto _L5; else goto _L4
_L4:
        obj = Uri.fromFile(new File(video.getLocalPath()));
        obj = (new video()).video(((Uri) (obj))).video();
_L7:
        generateFrameThumbnails(((VideoFramesParams) (obj)), s);
        return;
_L5:
        try
        {
            obj = SeekBarThumbnailStore.access$400(SeekBarThumbnailStore.this).getMediaItemURLOperation(video.getObjectId(), SennaMediaType.valueOf(video.getType()), 0, 0, ScaleMode.SCALE_TO_FIT);
            obj = (String)NetworkExecutor.getInstance().execute(((com.amazon.gallery.framework.network.on) (obj)));
            obj = (new video()).video(Uri.parse(((String) (obj)))).video();
        }
        catch (TerminalException terminalexception)
        {
            GLogger.ex(SeekBarThumbnailStore.access$100(), "Could not fetch video url", terminalexception);
            return;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public _cls2.val.retriever(Video video1)
    {
        this$0 = SeekBarThumbnailStore.this;
        super();
        video = video1;
    }
}
