// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.util.MutableBoolean;
import com.amazon.gallery.foundation.utils.file.MimeTypeUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.messaging.DownloadFinishedEvent;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.download.CustomDownloadId;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.transcoder.CompressionQuality;
import com.amazon.gallery.framework.transcoder.VideoProperties;
import com.amazon.gallery.framework.transcoder.VideoTranscoderUtil;
import com.amazon.gallery.thor.app.service.exception.FailedToTranscodeException;
import com.amazon.gallery.thor.app.service.exception.TerminalFailedToTranscodeException;
import com.amazon.gallery.thor.app.service.exception.VideoTooLargeException;
import com.amazon.transcoder.TranscodeVideo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.gallery.thor.app.service:
//            VideoTranscodeService

private class request
    implements Runnable
{

    private final Request request;
    final VideoTranscodeService this$0;

    private File downloadItem(ObjectID objectid)
        throws TerminalException, InterruptedException
    {
        final CountDownLatch hasTerminated = VideoTranscodeService.access$100(VideoTranscodeService.this).getItemById(objectid);
        objectid = MimeTypeUtil.getFileExtensionFromPath(hasTerminated.getName());
        objectid = new File(VideoTranscodeService.access$200(VideoTranscodeService.this), String.format("%s.%s", new Object[] {
            request.getId(), objectid
        }));
        final CustomDownloadId customDownloadId = VideoTranscodeService.access$300(VideoTranscodeService.this).downloadMediaItem(hasTerminated, objectid);
        hasTerminated = new CountDownLatch(1);
        final MutableBoolean success = new MutableBoolean(false);
        customDownloadId = new VideoTranscodeService.OnDownloadCompleteListener() {

            final VideoTranscodeService.TrimTask this$1;
            final CustomDownloadId val$customDownloadId;
            final CountDownLatch val$hasTerminated;
            final MutableBoolean val$success;

            public void onDownloadComplete(DownloadFinishedEvent downloadfinishedevent)
            {
                if (VideoTranscodeService.TranscodeRequest.access$500(request).getObjectId().equals(customDownloadId.getMediaItemObjectId()))
                {
                    GLogger.i(VideoTranscodeService.access$600(), "Download success: %b request: %s", new Object[] {
                        Boolean.valueOf(downloadfinishedevent.isSuccessful()), request.getId()
                    });
                    success.value = downloadfinishedevent.isSuccessful();
                    hasTerminated.countDown();
                }
            }

            
            {
                this$1 = VideoTranscodeService.TrimTask.this;
                customDownloadId = customdownloadid;
                success = mutableboolean;
                hasTerminated = countdownlatch;
                super();
            }
        };
        VideoTranscodeService.access$700(VideoTranscodeService.this, customDownloadId);
        hasTerminated.await();
        VideoTranscodeService.access$800(VideoTranscodeService.this, customDownloadId);
        if (success.value)
        {
            return objectid;
        } else
        {
            throw new TerminalException("Download terminated without STATUS_SUCCESSFUL");
        }
    }

    private void transcode(File file, CompressionQuality compressionquality, VideoProperties videoproperties)
        throws FailedToTranscodeException, TerminalFailedToTranscodeException, VideoTooLargeException
    {
        file = VideoTranscodeService.access$1700(file, request, videoproperties, compressionquality);
        GLogger.i(VideoTranscodeService.access$600(), "Transcoding: %s with parameters %s", new Object[] {
            videoproperties.toString(), file.()
        });
        int i = file.().transcode();
        if (i != 0)
        {
            if (i == -15 || i == -14 || i == -13)
            {
                throw new TerminalFailedToTranscodeException();
            } else
            {
                throw new FailedToTranscodeException();
            }
        }
        if (Request.access._mth1400(request).length() > Request.access._mth1200(request))
        {
            throw new VideoTooLargeException();
        } else
        {
            return;
        }
    }

    public void run()
    {
        Object obj;
        File file;
        VideoTranscodeService.access$900(VideoTranscodeService.this, request.getId());
        VideoProperties videoproperties;
        Iterator iterator;
        if (MediaItemUtil.isLocalMediaItem(Request.access._mth500(request)))
        {
            file = new File(Request.access._mth500(request).getLocalPath());
            videoproperties = new VideoProperties(Request.access._mth500(request).getLocalPath());
        } else
        {
            try
            {
                file = downloadItem(Request.access._mth500(request).getObjectId());
                videoproperties = new VideoProperties(file.getAbsolutePath());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                GLogger.e(VideoTranscodeService.access$600(), "Error while downloading cloud video", new Object[] {
                    obj
                });
                VideoTranscodeService.access$1000(VideoTranscodeService.this, request.getId());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                GLogger.i(VideoTranscodeService.access$600(), "Interrupted downloading cloud video. Cancelling transcode", new Object[] {
                    obj
                });
                VideoTranscodeService.access$1100(VideoTranscodeService.this, request.getId());
                return;
            }
        }
        iterator = VideoTranscoderUtil.getBitrates(Request.access._mth1200(request), Request.access._mth1300(request)).iterator();
        obj = Boolean.valueOf(false);
_L1:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_161;
        }
        obj = (CompressionQuality)iterator.next();
        transcode(file, ((CompressionQuality) (obj)), videoproperties);
        obj = Boolean.valueOf(true);
        GLogger.v(VideoTranscodeService.access$600(), "Transcoded: %s", new Object[] {
            new VideoProperties(Request.access._mth1400(request).getAbsolutePath())
        });
_L2:
        VideoTranscodeService.access$1500(VideoTranscodeService.this).remove(request.getId());
        VideoTooLargeException videotoolargeexception;
        Object obj1;
        FailedToTranscodeException failedtotranscodeexception;
        if (((Boolean) (obj)).booleanValue())
        {
            VideoTranscodeService.access$1600(VideoTranscodeService.this, request.getId(), Request.access._mth1400(request));
        } else
        {
            VideoTranscodeService.access$1000(VideoTranscodeService.this, request.getId());
        }
        if (!MediaItemUtil.isLocalMediaItem(Request.access._mth500(request)))
        {
            file.delete();
        }
        if (VideoTranscodeService.access$1500(VideoTranscodeService.this).isEmpty())
        {
            stopSelf();
        }
        return;
        videotoolargeexception;
        Request.access._mth1400(request).delete();
        videotoolargeexception = Boolean.valueOf(false);
        GLogger.i(VideoTranscodeService.access$600(), "Transcoded video is too large", new Object[0]);
          goto _L1
        failedtotranscodeexception;
        videotoolargeexception = Boolean.valueOf(false);
        GLogger.exf(VideoTranscodeService.access$600(), failedtotranscodeexception, "Failed to transcode video:%s", new Object[] {
            file
        });
          goto _L1
        obj1;
        videotoolargeexception = Boolean.valueOf(false);
        GLogger.exf(VideoTranscodeService.access$600(), ((Throwable) (obj1)), "Failed to transcode video:%s", new Object[] {
            file
        });
          goto _L2
        obj1;
        videotoolargeexception = Boolean.valueOf(false);
        GLogger.exf(VideoTranscodeService.access$600(), ((Throwable) (obj1)), "Failed to transcode video %s with unexpected error", new Object[] {
            file
        });
          goto _L2
    }


    public Request(Request request1)
    {
        this$0 = VideoTranscodeService.this;
        super();
        request = request1;
    }
}
