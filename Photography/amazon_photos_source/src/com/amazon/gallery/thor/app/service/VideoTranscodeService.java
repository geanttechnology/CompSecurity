// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.MutableBoolean;
import com.amazon.gallery.foundation.image.Dimension;
import com.amazon.gallery.foundation.utils.file.MimeTypeUtil;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.messaging.DownloadFinishedEvent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.download.CustomDownloadId;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.transcoder.CompressionQuality;
import com.amazon.gallery.framework.transcoder.VideoProperties;
import com.amazon.gallery.framework.transcoder.VideoTranscoderUtil;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.service.exception.FailedToTranscodeException;
import com.amazon.gallery.thor.app.service.exception.TerminalFailedToTranscodeException;
import com.amazon.gallery.thor.app.service.exception.VideoTooLargeException;
import com.amazon.transcoder.TranscodeVideo;
import com.google.common.base.Optional;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.Validate;

public class VideoTranscodeService extends Service
{
    public static final class Container extends Enum
    {

        private static final Container $VALUES[];
        public static final Container FORMAT_3GPP;
        public static final Container FORMAT_MP4;
        public final int code;
        public final String ext;
        public final String name;

        public static Container getFormat(String s)
        {
            if (FORMAT_3GPP.name.equals(s))
            {
                return FORMAT_3GPP;
            } else
            {
                return FORMAT_MP4;
            }
        }

        public static Container valueOf(String s)
        {
            return (Container)Enum.valueOf(com/amazon/gallery/thor/app/service/VideoTranscodeService$Container, s);
        }

        public static Container[] values()
        {
            return (Container[])$VALUES.clone();
        }

        static 
        {
            FORMAT_3GPP = new Container("FORMAT_3GPP", 0, "3GPP", 1, "3gp");
            FORMAT_MP4 = new Container("FORMAT_MP4", 1, "MP4", 2, "mp4");
            $VALUES = (new Container[] {
                FORMAT_3GPP, FORMAT_MP4
            });
        }

        private Container(String s, int i, String s1, int j, String s2)
        {
            super(s, i);
            name = s1;
            code = j;
            ext = s2;
        }
    }

    public final class LocalBinder extends Binder
    {

        final VideoTranscodeService this$0;

        public VideoTranscodeService getService()
        {
            return VideoTranscodeService.this;
        }

        public LocalBinder()
        {
            this$0 = VideoTranscodeService.this;
            super();
        }
    }

    private static interface OnDownloadCompleteListener
    {

        public abstract void onDownloadComplete(DownloadFinishedEvent downloadfinishedevent);
    }

    public static interface OnUpdateListener
    {

        public abstract void onVideoTranscodeCancelled(String s);

        public abstract void onVideoTranscodeCompleted(String s, File file);

        public abstract void onVideoTranscodeFailed(String s);

        public abstract void onVideoTranscodeStarted(String s);
    }

    public static class TranscodeRequest
    {

        private final int audioCodec;
        private final int duration;
        private final int endTime;
        private final String id;
        private long maxFileSize;
        private final File outputFile;
        private final int startTime;
        private final Video video;
        private final int videoCodec;
        private final int videoContainer;
        private WorkState workState;

        public String getId()
        {
            return id;
        }










        private TranscodeRequest(Video video1, int i, int j, long l, File file, int k, 
                int i1, int j1)
        {
            id = UUID.randomUUID().toString();
            video = video1;
            startTime = i;
            endTime = j;
            duration = j - i;
            workState = WorkState.NOT_STARTED;
            outputFile = file;
            maxFileSize = l;
            videoContainer = k;
            audioCodec = i1;
            videoCodec = j1;
        }

        TranscodeRequest(Video video1, int i, int j, long l, File file, int k, 
                int i1, int j1, _cls1 _pcls1)
        {
            this(video1, i, j, l, file, k, i1, j1);
        }
    }

    public static final class TranscodeRequest.Builder
    {

        private int audioCodec;
        private int endTime;
        private long maxFileSize;
        private File outputFile;
        private int startTime;
        private Video video;
        private int videoCodec;
        private int videoContainer;

        public TranscodeRequest build()
        {
            Validate.notNull(outputFile);
            return new TranscodeRequest(video, startTime, endTime, maxFileSize, outputFile, videoContainer, audioCodec, videoCodec);
        }

        public TranscodeRequest.Builder withBounds(int i, int j)
        {
            Validate.inclusiveBetween(0L, j + 1, i);
            Validate.inclusiveBetween(i, (int)video.getDuration(), j);
            startTime = i;
            endTime = j;
            return this;
        }

        public TranscodeRequest.Builder withMaxFileSize(long l)
        {
            Validate.inclusiveBetween(0L, 0x7fffffffffffffffL, l);
            maxFileSize = l;
            return this;
        }

        public TranscodeRequest.Builder withOutputFile(File file)
        {
            outputFile = (File)Validate.notNull(file);
            return this;
        }

        public TranscodeRequest.Builder withVideoContainer(Container container)
        {
label0:
            {
                if (container != null)
                {
                    videoContainer = container.code;
                    static class _cls5
                    {

                        static final int $SwitchMap$com$amazon$gallery$thor$app$service$VideoTranscodeService$Container[];

                        static 
                        {
                            $SwitchMap$com$amazon$gallery$thor$app$service$VideoTranscodeService$Container = new int[Container.values().length];
                            try
                            {
                                $SwitchMap$com$amazon$gallery$thor$app$service$VideoTranscodeService$Container[Container.FORMAT_3GPP.ordinal()] = 1;
                            }
                            catch (NoSuchFieldError nosuchfielderror1) { }
                            try
                            {
                                $SwitchMap$com$amazon$gallery$thor$app$service$VideoTranscodeService$Container[Container.FORMAT_MP4.ordinal()] = 2;
                            }
                            catch (NoSuchFieldError nosuchfielderror)
                            {
                                return;
                            }
                        }
                    }

                    switch (_cls5..SwitchMap.com.amazon.gallery.thor.app.service.VideoTranscodeService.Container[container.ordinal()])
                    {
                    default:
                        videoCodec = 2;
                        audioCodec = 1;
                        break;

                    case 1: // '\001'
                        break label0;
                    }
                }
                return this;
            }
            videoCodec = 2;
            audioCodec = 2;
            return this;
        }

        public TranscodeRequest.Builder(Video video1)
        {
            videoContainer = Container.FORMAT_MP4.code;
            videoCodec = 2;
            audioCodec = 1;
            maxFileSize = 0x500000L;
            video = (Video)Validate.notNull(video1);
            startTime = 0;
            endTime = (int)(video1.getDuration() / 1000L);
        }
    }

    private class TrimTask
        implements Runnable
    {

        private final TranscodeRequest request;
        final VideoTranscodeService this$0;

        private File downloadItem(ObjectID objectid)
            throws TerminalException, InterruptedException
        {
            Object obj = mediaItemDao.getItemById(objectid);
            objectid = MimeTypeUtil.getFileExtensionFromPath(((MediaItem) (obj)).getName());
            objectid = new File(temporaryDirectory, String.format("%s.%s", new Object[] {
                request.getId(), objectid
            }));
            final CustomDownloadId customDownloadId = downloadManager.downloadMediaItem(((MediaItem) (obj)), objectid);
            obj = new CountDownLatch(1);
            final MutableBoolean success = new MutableBoolean(false);
            customDownloadId = ((_cls1) (obj)). new OnDownloadCompleteListener() {

                final TrimTask this$1;
                final CustomDownloadId val$customDownloadId;
                final CountDownLatch val$hasTerminated;
                final MutableBoolean val$success;

                public void onDownloadComplete(DownloadFinishedEvent downloadfinishedevent)
                {
                    if (request.video.getObjectId().equals(customDownloadId.getMediaItemObjectId()))
                    {
                        GLogger.i(VideoTranscodeService.TAG, "Download success: %b request: %s", new Object[] {
                            Boolean.valueOf(downloadfinishedevent.isSuccessful()), request.getId()
                        });
                        success.value = downloadfinishedevent.isSuccessful();
                        hasTerminated.countDown();
                    }
                }

            
            {
                this$1 = final_trimtask;
                customDownloadId = customdownloadid;
                success = mutableboolean;
                hasTerminated = CountDownLatch.this;
                super();
            }
            };
            addOnDownloadCompleteListener(customDownloadId);
            ((CountDownLatch) (obj)).await();
            removeOnDownloadCompleteListener(customDownloadId);
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
            file = VideoTranscodeService.createTranscodeBuilder(file, request, videoproperties, compressionquality);
            GLogger.i(VideoTranscodeService.TAG, "Transcoding: %s with parameters %s", new Object[] {
                videoproperties.toString(), file.toString()
            });
            int i = file.build().transcode();
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
            if (request.outputFile.length() > request.maxFileSize)
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
            notifyStarted(request.getId());
            VideoProperties videoproperties;
            Iterator iterator;
            if (MediaItemUtil.isLocalMediaItem(request.video))
            {
                file = new File(request.video.getLocalPath());
                videoproperties = new VideoProperties(request.video.getLocalPath());
            } else
            {
                try
                {
                    file = downloadItem(request.video.getObjectId());
                    videoproperties = new VideoProperties(file.getAbsolutePath());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    GLogger.e(VideoTranscodeService.TAG, "Error while downloading cloud video", new Object[] {
                        obj
                    });
                    notifyFailed(request.getId());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    GLogger.i(VideoTranscodeService.TAG, "Interrupted downloading cloud video. Cancelling transcode", new Object[] {
                        obj
                    });
                    notifyCancelled(request.getId());
                    return;
                }
            }
            iterator = VideoTranscoderUtil.getBitrates(request.maxFileSize, request.duration).iterator();
            obj = Boolean.valueOf(false);
_L1:
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_161;
            }
            obj = (CompressionQuality)iterator.next();
            transcode(file, ((CompressionQuality) (obj)), videoproperties);
            obj = Boolean.valueOf(true);
            GLogger.v(VideoTranscodeService.TAG, "Transcoded: %s", new Object[] {
                new VideoProperties(request.outputFile.getAbsolutePath())
            });
_L2:
            pendingTasks.remove(request.getId());
            VideoTooLargeException videotoolargeexception;
            Object obj1;
            FailedToTranscodeException failedtotranscodeexception;
            if (((Boolean) (obj)).booleanValue())
            {
                notifyCompleted(request.getId(), request.outputFile);
            } else
            {
                notifyFailed(request.getId());
            }
            if (!MediaItemUtil.isLocalMediaItem(request.video))
            {
                file.delete();
            }
            if (pendingTasks.isEmpty())
            {
                stopSelf();
            }
            return;
            videotoolargeexception;
            request.outputFile.delete();
            videotoolargeexception = Boolean.valueOf(false);
            GLogger.i(VideoTranscodeService.TAG, "Transcoded video is too large", new Object[0]);
              goto _L1
            failedtotranscodeexception;
            videotoolargeexception = Boolean.valueOf(false);
            GLogger.exf(VideoTranscodeService.TAG, failedtotranscodeexception, "Failed to transcode video:%s", new Object[] {
                file
            });
              goto _L1
            obj1;
            videotoolargeexception = Boolean.valueOf(false);
            GLogger.exf(VideoTranscodeService.TAG, ((Throwable) (obj1)), "Failed to transcode video:%s", new Object[] {
                file
            });
              goto _L2
            obj1;
            videotoolargeexception = Boolean.valueOf(false);
            GLogger.exf(VideoTranscodeService.TAG, ((Throwable) (obj1)), "Failed to transcode video %s with unexpected error", new Object[] {
                file
            });
              goto _L2
        }


        public TrimTask(TranscodeRequest transcoderequest)
        {
            this$0 = VideoTranscodeService.this;
            super();
            request = transcoderequest;
        }
    }

    public static final class WorkState extends Enum
    {

        private static final WorkState $VALUES[];
        public static final WorkState CANCELLED;
        public static final WorkState COMPLETED;
        public static final WorkState FAILED;
        public static final WorkState NOT_REQUESTED;
        public static final WorkState NOT_STARTED;
        public static final WorkState STARTED;

        public static WorkState valueOf(String s)
        {
            return (WorkState)Enum.valueOf(com/amazon/gallery/thor/app/service/VideoTranscodeService$WorkState, s);
        }

        public static WorkState[] values()
        {
            return (WorkState[])$VALUES.clone();
        }

        static 
        {
            CANCELLED = new WorkState("CANCELLED", 0);
            COMPLETED = new WorkState("COMPLETED", 1);
            STARTED = new WorkState("STARTED", 2);
            NOT_STARTED = new WorkState("NOT_STARTED", 3);
            NOT_REQUESTED = new WorkState("NOT_REQUESTED", 4);
            FAILED = new WorkState("FAILED", 5);
            $VALUES = (new WorkState[] {
                CANCELLED, COMPLETED, STARTED, NOT_STARTED, NOT_REQUESTED, FAILED
            });
        }

        private WorkState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/thor/app/service/VideoTranscodeService.toString();
    private static final Map TASK_STATES = new HashMap();
    private final LocalBinder binder = new LocalBinder();
    private final List downloadListeners = new ArrayList();
    private GalleryDownloadManager downloadManager;
    private ExecutorService executor;
    private Handler handler;
    private final List listeners = new ArrayList();
    private MediaItemDao mediaItemDao;
    private NetworkExecutor networkExecutor;
    private final Map pendingTasks = new LinkedHashMap();
    private RestClient restClient;
    private File temporaryDirectory;

    public VideoTranscodeService()
    {
    }

    private void addOnDownloadCompleteListener(OnDownloadCompleteListener ondownloadcompletelistener)
    {
        this;
        JVM INSTR monitorenter ;
        downloadListeners.add(ondownloadcompletelistener);
        this;
        JVM INSTR monitorexit ;
        return;
        ondownloadcompletelistener;
        throw ondownloadcompletelistener;
    }

    private static boolean convertTo3GPP(Video video, Container container)
    {
        return container != null && container.equals(Container.FORMAT_3GPP) && !container.ext.equals(FilenameUtils.getExtension(video.getName()));
    }

    private static com.amazon.transcoder.TranscodeVideo.Builder createTranscodeBuilder(File file, TranscodeRequest transcoderequest, VideoProperties videoproperties, CompressionQuality compressionquality)
    {
        videoproperties = VideoTranscoderUtil.getTranscodeDimension(new Dimension(videoproperties.getWidth(), videoproperties.getHeight()), compressionquality.boundingSize);
        return (new com.amazon.transcoder.TranscodeVideo.Builder()).withSource(file.getAbsolutePath()).withDestination(transcoderequest.outputFile.getAbsolutePath()).withStart(transcoderequest.startTime).withEnd(transcoderequest.endTime).withContainer(transcoderequest.videoContainer).withAudioCodec(transcoderequest.audioCodec).withVideoCodec(transcoderequest.videoCodec).withWidth(((Dimension) (videoproperties)).width).withHeight(((Dimension) (videoproperties)).height).withAudioBitRate(compressionquality.audioBitrate).withVideoBitRate(compressionquality.videoBitrate);
    }

    public static long getMaxVideoLength(Video video, Optional optional)
    {
        if (!optional.isPresent())
        {
            return Math.min(0x124f80L, video.getDuration());
        }
        if (((Long)optional.get()).longValue() >= 0x2800000L)
        {
            return Math.min(0x124f80L, video.getDuration());
        } else
        {
            return Math.min((long)(((double)((Long)optional.get()).longValue() / 1048576D) * 30000D), video.getDuration());
        }
    }

    public static long getMediaItemSize(MediaItem mediaitem)
    {
        long l1 = 0x7fffffffffffffffL;
        long l;
        if (MediaItemUtil.isLocalMediaItem(mediaitem))
        {
            mediaitem = new File(mediaitem.getLocalPath());
            l = l1;
            if (mediaitem != null)
            {
                l = l1;
                if (mediaitem.exists())
                {
                    l = FileUtils.sizeOf(mediaitem);
                }
            }
        } else
        {
            mediaitem = (String)mediaitem.getMetadata().get("size");
            l = l1;
            if (mediaitem != null)
            {
                return Long.parseLong(mediaitem);
            }
        }
        return l;
    }

    private void notifyCancelled(final String id)
    {
        GLogger.i(TAG, "Video Transcode request id:%s cancelled", new Object[] {
            id
        });
        handler.post(new Runnable() {

            final VideoTranscodeService this$0;
            final String val$id;

            public void run()
            {
                updateWorkState(id, WorkState.CANCELLED);
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((OnUpdateListener)iterator.next()).onVideoTranscodeCancelled(id)) { }
            }

            
            {
                this$0 = VideoTranscodeService.this;
                id = s;
                super();
            }
        });
    }

    private void notifyCompleted(final String id, final File output)
    {
        GLogger.i(TAG, "Video Transcode request id:%s completed", new Object[] {
            id
        });
        handler.post(new Runnable() {

            final VideoTranscodeService this$0;
            final String val$id;
            final File val$output;

            public void run()
            {
                updateWorkState(id, WorkState.COMPLETED);
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((OnUpdateListener)iterator.next()).onVideoTranscodeCompleted(id, output)) { }
            }

            
            {
                this$0 = VideoTranscodeService.this;
                id = s;
                output = file;
                super();
            }
        });
    }

    private void notifyFailed(final String id)
    {
        GLogger.i(TAG, "Video Transcode request id:%s failed", new Object[] {
            id
        });
        handler.post(new Runnable() {

            final VideoTranscodeService this$0;
            final String val$id;

            public void run()
            {
                updateWorkState(id, WorkState.FAILED);
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((OnUpdateListener)iterator.next()).onVideoTranscodeFailed(id)) { }
            }

            
            {
                this$0 = VideoTranscodeService.this;
                id = s;
                super();
            }
        });
    }

    private void notifyStarted(final String id)
    {
        GLogger.i(TAG, "Video Transcode request id:%s started", new Object[] {
            id
        });
        handler.post(new Runnable() {

            final VideoTranscodeService this$0;
            final String val$id;

            public void run()
            {
                updateWorkState(id, WorkState.STARTED);
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((OnUpdateListener)iterator.next()).onVideoTranscodeStarted(id)) { }
            }

            
            {
                this$0 = VideoTranscodeService.this;
                id = s;
                super();
            }
        });
    }

    private void removeOnDownloadCompleteListener(OnDownloadCompleteListener ondownloadcompletelistener)
    {
        this;
        JVM INSTR monitorenter ;
        downloadListeners.remove(ondownloadcompletelistener);
        this;
        JVM INSTR monitorexit ;
        return;
        ondownloadcompletelistener;
        throw ondownloadcompletelistener;
    }

    public static boolean shouldAutoTranscode(Video video, Optional optional, Container container)
    {
label0:
        {
            boolean flag3 = false;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag4;
            if (video.getDuration() < 30000L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!optional.isPresent() || getMediaItemSize(video) > ((Long)optional.get()).longValue())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag4 = convertTo3GPP(video, container);
            if (!flag)
            {
                flag2 = flag3;
                if (flag1)
                {
                    break label0;
                }
                flag2 = flag3;
                if (!flag4)
                {
                    break label0;
                }
            }
            flag2 = true;
        }
        return flag2;
    }

    private void updateWorkState(String s, WorkState workstate)
    {
        this;
        JVM INSTR monitorenter ;
        TASK_STATES.put(s, workstate);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void addOnUpdateListener(OnUpdateListener onupdatelistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.add(onupdatelistener);
        this;
        JVM INSTR monitorexit ;
        return;
        onupdatelistener;
        throw onupdatelistener;
    }

    public String addRequest(TranscodeRequest transcoderequest)
    {
        this;
        JVM INSTR monitorenter ;
        Future future = executor.submit(new TrimTask(transcoderequest));
        pendingTasks.put(transcoderequest.getId(), future);
        updateWorkState(transcoderequest.getId(), WorkState.NOT_STARTED);
        transcoderequest = transcoderequest.getId();
        this;
        JVM INSTR monitorexit ;
        return transcoderequest;
        transcoderequest;
        throw transcoderequest;
    }

    public boolean cancelRequest(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Future future = (Future)pendingTasks.get(s);
        if (future == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        future.cancel(true);
        pendingTasks.remove(s);
        notifyCancelled(s);
        this;
        JVM INSTR monitorexit ;
        return false;
        s;
        throw s;
    }

    public WorkState getRequestWorkState(String s)
    {
        s = (WorkState)TASK_STATES.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return WorkState.NOT_REQUESTED;
        }
    }

    public IBinder onBind(Intent intent)
    {
        return binder;
    }

    public void onCreate()
    {
        handler = new Handler();
        restClient = (RestClient)ThorGalleryApplication.getBean(Keys.REST_CLIENT);
        mediaItemDao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        networkExecutor = NetworkExecutor.getInstance();
        downloadManager = (GalleryDownloadManager)ThorGalleryApplication.getBean(Keys.GALLERY_DOWNLOAD_MANAGER);
        GlobalMessagingBus.register(this);
        temporaryDirectory = new File(getExternalCacheDir(), "trimmer_artifacts");
        if (!temporaryDirectory.exists())
        {
            temporaryDirectory.mkdir();
        }
        executor = Executors.newSingleThreadExecutor();
    }

    public void onDestroy()
    {
        if (executor != null)
        {
            executor.shutdown();
        }
        GlobalMessagingBus.unregister(this);
    }

    public void onDownloadFinished(DownloadFinishedEvent downloadfinishedevent)
    {
        for (Iterator iterator = downloadListeners.iterator(); iterator.hasNext(); ((OnDownloadCompleteListener)iterator.next()).onDownloadComplete(downloadfinishedevent)) { }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 2;
    }

    public void removeOnUpdateListener(OnUpdateListener onupdatelistener)
    {
        this;
        JVM INSTR monitorenter ;
        listeners.remove(onupdatelistener);
        this;
        JVM INSTR monitorexit ;
        return;
        onupdatelistener;
        throw onupdatelistener;
    }















}
