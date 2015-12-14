// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.kindle.cms.CMSImageHelper;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.io.File;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            VideoFramesParams, RangeSeekBarFrameProcessor, FrameProcessor

public class SeekBarThumbnailStore
{
    private class FrameGeneratorThread extends Thread
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
            frameProcessorExecutor.execute(latch. new Runnable() {

                final FrameGeneratorThread this$1;
                final FrameProcessor val$frameProcessor;
                final String val$identifier;
                final int val$index;
                final CountDownLatch val$latch;
                final long val$period;
                final MediaMetadataRetriever val$retriever;

                public void run()
                {
                    Bitmap bitmap;
                    long l = period;
                    long l1 = index;
                    bitmap = retriever.getFrameAtTime(l * l1 * 1000L, 2);
                    if (bitmap == null)
                    {
                        break MISSING_BLOCK_LABEL_61;
                    }
                    bitmap = frameProcessor.process(bitmap);
                    cacheThumbnail(bitmap, index, identifier);
                    latch.countDown();
                    return;
                    Exception exception;
                    exception;
                    latch.countDown();
                    throw exception;
                }

            
            {
                this$1 = final_framegeneratorthread;
                period = l;
                index = i;
                retriever = mediametadataretriever;
                frameProcessor = frameprocessor;
                identifier = s;
                latch = CountDownLatch.this;
                super();
            }
            });
            index++;
            if (true) goto _L4; else goto _L3
_L2:
            retriever.setDataSource(context, videoframesparams.videoUri);
              goto _L5
            videoframesparams;
            frameProcessorExecutor.execute(retriever. new Runnable() {

                final FrameGeneratorThread this$1;
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
                            GLogger.w(SeekBarThumbnailStore.TAG, "Thread interrupted...", new Object[0]);
                        }
                    }
                    retriever.release();
                }

            
            {
                this$1 = final_framegeneratorthread;
                latch = countdownlatch;
                retriever = MediaMetadataRetriever.this;
                super();
            }
            });
            throw videoframesparams;
_L3:
            frameProcessorExecutor.execute(retriever. new _cls2());
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
            s = SeekBarThumbnailStore.getUniqueCacheID(video);
            if (s.isEmpty())
            {
                GLogger.d(SeekBarThumbnailStore.TAG, (new StringBuilder()).append("Could not compute identifier for the video: ").append(video.getName()).toString(), new Object[0]);
                return;
            }
            obj = new File(cacheDir, s);
            if (alreadyCached(((File) (obj)))) goto _L1; else goto _L3
_L3:
            if (!((File) (obj)).exists())
            {
                ((File) (obj)).mkdirs();
            }
            if (!MediaItemUtil.isLocalMediaItem(video)) goto _L5; else goto _L4
_L4:
            obj = Uri.fromFile(new File(video.getLocalPath()));
            obj = (new VideoFramesParams.Builder()).withVideoUri(((Uri) (obj))).build();
_L7:
            generateFrameThumbnails(((VideoFramesParams) (obj)), s);
            return;
_L5:
            try
            {
                obj = restClient.getMediaItemURLOperation(video.getObjectId(), SennaMediaType.valueOf(video.getType()), 0, 0, ScaleMode.SCALE_TO_FIT);
                obj = (String)NetworkExecutor.getInstance().execute(((com.amazon.gallery.framework.network.NetworkExecutor.NetworkOperation) (obj)));
                obj = (new VideoFramesParams.Builder()).withVideoUri(Uri.parse(((String) (obj)))).build();
            }
            catch (TerminalException terminalexception)
            {
                GLogger.ex(SeekBarThumbnailStore.TAG, "Could not fetch video url", terminalexception);
                return;
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        public FrameGeneratorThread(Video video1)
        {
            this$0 = SeekBarThumbnailStore.this;
            super();
            video = video1;
        }
    }

    public static interface SeekBarThumbnailListener
    {

        public abstract void onThumbnailLoaded(Bitmap bitmap, int i);
    }


    private static final android.graphics.Bitmap.CompressFormat COMPRESS_FORMAT;
    private static final String TAG = com/amazon/gallery/thor/widget/SeekBarThumbnailStore.getName();
    private static SeekBarThumbnailStore instance = null;
    private File cacheDir;
    private final Context context;
    private final ExecutorService frameProcessorExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private SeekBarThumbnailListener listener;
    private final RestClient restClient;

    private SeekBarThumbnailStore(Context context1, RestClient restclient)
    {
        context = context1;
        restClient = restclient;
        initCacheDir();
    }

    private boolean alreadyCached(File file)
    {
        return file.exists() && file.isDirectory() && file.listFiles().length == 10;
    }

    private void cacheThumbnail(Bitmap bitmap, int i, String s)
    {
        if (bitmap == null)
        {
            return;
        }
        CMSImageHelper.writeBitmapToFile(bitmap, new File(new File(cacheDir, s), (new StringBuilder()).append(i).append("").toString()), COMPRESS_FORMAT, 70);
        if (listener != null)
        {
            listener.onThumbnailLoaded(bitmap, i);
            return;
        } else
        {
            bitmap.recycle();
            return;
        }
    }

    public static SeekBarThumbnailStore getInstance(Context context1, RestClient restclient)
    {
        com/amazon/gallery/thor/widget/SeekBarThumbnailStore;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new SeekBarThumbnailStore(context1, restclient);
        }
        context1 = instance;
        com/amazon/gallery/thor/widget/SeekBarThumbnailStore;
        JVM INSTR monitorexit ;
        return context1;
        context1;
        throw context1;
    }

    private static String getUniqueCacheID(Video video)
    {
        Object obj = video.getName();
        String s = Long.toString(video.getDuration());
        video = Long.toString(video.getDateCreatedMs());
        obj = new StringBuilder(((String) (obj)));
        ((StringBuilder) (obj)).append(s);
        ((StringBuilder) (obj)).append(video);
        return ((StringBuilder) (obj)).toString();
    }

    private void initCacheDir()
    {
        File file = new File(context.getCacheDir(), "trimmer-cache");
        if (file.exists()) goto _L2; else goto _L1
_L1:
        file.mkdir();
_L4:
        cacheDir = file;
        return;
_L2:
        if (!file.isDirectory())
        {
            file.delete();
            file.mkdir();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void attachListener(SeekBarThumbnailListener seekbarthumbnaillistener)
    {
        listener = seekbarthumbnaillistener;
    }

    public void detachListener()
    {
        listener = null;
    }

    public Bitmap[] getFrameThumbnails(Video video)
    {
        Object obj = null;
        if (video != null) goto _L2; else goto _L1
_L1:
        video = obj;
_L4:
        return video;
_L2:
        Object obj1 = getUniqueCacheID(video);
        if (((String) (obj1)).isEmpty())
        {
            GLogger.d(TAG, (new StringBuilder()).append("Could not compute identifier for the video: ").append(video.getName()).toString(), new Object[0]);
            return null;
        }
        Bitmap abitmap[] = new Bitmap[10];
        obj1 = new File(cacheDir, ((String) (obj1)));
        if (!((File) (obj1)).exists())
        {
            prepareFrameThumbnails(video);
            return abitmap;
        }
        File afile[] = ((File) (obj1)).listFiles();
        int j = afile.length;
        int i = 0;
        do
        {
            video = abitmap;
            if (i >= j)
            {
                continue;
            }
            video = afile[i];
            Bitmap bitmap = BitmapFactory.decodeFile(video.getAbsolutePath());
            abitmap[Integer.parseInt(video.getName())] = bitmap;
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void prepareFrameThumbnails(Video video)
    {
        (new FrameGeneratorThread(video)).start();
    }

    static 
    {
        COMPRESS_FORMAT = android.graphics.Bitmap.CompressFormat.PNG;
    }








}
