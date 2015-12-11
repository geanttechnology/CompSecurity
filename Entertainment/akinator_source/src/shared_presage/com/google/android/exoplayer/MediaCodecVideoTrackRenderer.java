// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.nio.ByteBuffer;
import shared_presage.com.google.android.exoplayer.drm.DrmSessionManager;
import shared_presage.com.google.android.exoplayer.util.MimeTypes;
import shared_presage.com.google.android.exoplayer.util.TraceUtil;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecTrackRenderer, l, m, k, 
//            MediaFormat, CodecCounters, MediaFormatHolder, SampleSource

public class MediaCodecVideoTrackRenderer extends MediaCodecTrackRenderer
{
    public static interface EventListener
        extends MediaCodecTrackRenderer.EventListener
    {

        public abstract void onDrawnToSurface(Surface surface1);

        public abstract void onDroppedFrames(int i, long l1);

        public abstract void onVideoSizeChanged(int i, int j, float f);
    }

    public static interface FrameReleaseTimeHelper
    {

        public abstract long adjustReleaseTime(long l1, long l2);

        public abstract void disable();

        public abstract void enable();
    }


    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    public static final int MSG_SET_SURFACE = 1;
    private final long allowedJoiningTimeUs;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentWidth;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrameCount;
    private final EventListener eventListener;
    private final FrameReleaseTimeHelper frameReleaseTimeHelper;
    private long joiningDeadlineUs;
    private int lastReportedHeight;
    private float lastReportedPixelWidthHeightRatio;
    private int lastReportedWidth;
    private final int maxDroppedFrameCountToNotify;
    private float pendingPixelWidthHeightRatio;
    private boolean renderedFirstFrame;
    private boolean reportedDrawnToSurface;
    private Surface surface;
    private final int videoScalingMode;

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, int i)
    {
        this(samplesource, null, true, i);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, int i, long l1)
    {
        this(samplesource, null, true, i, l1);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, int i, long l1, Handler handler, EventListener eventlistener, int j)
    {
        this(samplesource, null, true, i, l1, null, handler, eventlistener, j);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, int i)
    {
        this(samplesource, drmsessionmanager, flag, i, 0L);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, int i, long l1)
    {
        this(samplesource, drmsessionmanager, flag, i, l1, null, null, null, -1);
    }

    public MediaCodecVideoTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, int i, long l1, FrameReleaseTimeHelper framereleasetimehelper, 
            Handler handler, EventListener eventlistener, int j)
    {
        super(samplesource, drmsessionmanager, flag, handler, eventlistener);
        videoScalingMode = i;
        allowedJoiningTimeUs = 1000L * l1;
        frameReleaseTimeHelper = framereleasetimehelper;
        eventListener = eventlistener;
        maxDroppedFrameCountToNotify = j;
        joiningDeadlineUs = -1L;
        currentWidth = -1;
        currentHeight = -1;
        currentPixelWidthHeightRatio = -1F;
        pendingPixelWidthHeightRatio = -1F;
        lastReportedWidth = -1;
        lastReportedHeight = -1;
        lastReportedPixelWidthHeightRatio = -1F;
    }

    private void maybeNotifyDrawnToSurface()
    {
        if (eventHandler == null || eventListener == null || reportedDrawnToSurface)
        {
            return;
        } else
        {
            Surface surface1 = surface;
            eventHandler.post(new l(this, surface1));
            reportedDrawnToSurface = true;
            return;
        }
    }

    private void maybeNotifyDroppedFrameCount()
    {
        if (eventHandler == null || eventListener == null || droppedFrameCount == 0)
        {
            return;
        } else
        {
            long l1 = SystemClock.elapsedRealtime();
            int i = droppedFrameCount;
            long l2 = droppedFrameAccumulationStartTimeMs;
            eventHandler.post(new m(this, i, l1 - l2));
            droppedFrameCount = 0;
            droppedFrameAccumulationStartTimeMs = l1;
            return;
        }
    }

    private void maybeNotifyVideoSizeChanged()
    {
        if (eventHandler == null || eventListener == null || lastReportedWidth == currentWidth && lastReportedHeight == currentHeight && lastReportedPixelWidthHeightRatio == currentPixelWidthHeightRatio)
        {
            return;
        } else
        {
            int i = currentWidth;
            int j = currentHeight;
            float f = currentPixelWidthHeightRatio;
            eventHandler.post(new k(this, i, j, f));
            lastReportedWidth = i;
            lastReportedHeight = j;
            lastReportedPixelWidthHeightRatio = f;
            return;
        }
    }

    private void setSurface(Surface surface1)
    {
        if (surface != surface1)
        {
            surface = surface1;
            reportedDrawnToSurface = false;
            int i = getState();
            if (i == 2 || i == 3)
            {
                releaseCodec();
                maybeInitCodec();
                return;
            }
        }
    }

    protected boolean canReconfigureCodec(MediaCodec mediacodec, boolean flag, shared_presage.com.google.android.exoplayer.MediaFormat mediaformat, shared_presage.com.google.android.exoplayer.MediaFormat mediaformat1)
    {
        return mediaformat1.mimeType.equals(mediaformat.mimeType) && (flag || mediaformat.width == mediaformat1.width && mediaformat.height == mediaformat1.height);
    }

    protected void configureCodec(MediaCodec mediacodec, String s, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        mediacodec.configure(mediaformat, surface, mediacrypto, 0);
        mediacodec.setVideoScalingMode(videoScalingMode);
    }

    protected void dropOutputBuffer(MediaCodec mediacodec, int i)
    {
        TraceUtil.beginSection("dropVideoBuffer");
        mediacodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.droppedOutputBufferCount = ((CodecCounters) (mediacodec)).droppedOutputBufferCount + 1;
        droppedFrameCount = droppedFrameCount + 1;
        if (droppedFrameCount == maxDroppedFrameCountToNotify)
        {
            maybeNotifyDroppedFrameCount();
        }
    }

    public void handleMessage(int i, Object obj)
    {
        if (i == 1)
        {
            setSurface((Surface)obj);
            return;
        } else
        {
            super.handleMessage(i, obj);
            return;
        }
    }

    protected boolean handlesMimeType(String s)
    {
        return MimeTypes.isVideo(s) && super.handlesMimeType(s);
    }

    protected final boolean haveRenderedFirstFrame()
    {
        return renderedFirstFrame;
    }

    protected boolean isReady()
    {
        if (super.isReady() && (renderedFirstFrame || !codecInitialized() || getSourceState() == 2))
        {
            joiningDeadlineUs = -1L;
        } else
        {
            if (joiningDeadlineUs == -1L)
            {
                return false;
            }
            if (SystemClock.elapsedRealtime() * 1000L >= joiningDeadlineUs)
            {
                joiningDeadlineUs = -1L;
                return false;
            }
        }
        return true;
    }

    public void onDisabled()
    {
        currentWidth = -1;
        currentHeight = -1;
        currentPixelWidthHeightRatio = -1F;
        pendingPixelWidthHeightRatio = -1F;
        lastReportedWidth = -1;
        lastReportedHeight = -1;
        lastReportedPixelWidthHeightRatio = -1F;
        if (frameReleaseTimeHelper != null)
        {
            frameReleaseTimeHelper.disable();
        }
        super.onDisabled();
    }

    protected void onEnabled(long l1, boolean flag)
    {
        super.onEnabled(l1, flag);
        renderedFirstFrame = false;
        if (flag && allowedJoiningTimeUs > 0L)
        {
            joiningDeadlineUs = SystemClock.elapsedRealtime() * 1000L + allowedJoiningTimeUs;
        }
        if (frameReleaseTimeHelper != null)
        {
            frameReleaseTimeHelper.enable();
        }
    }

    protected void onInputFormatChanged(MediaFormatHolder mediaformatholder)
    {
        super.onInputFormatChanged(mediaformatholder);
        float f;
        if (mediaformatholder.format.pixelWidthHeightRatio == -1F)
        {
            f = 1.0F;
        } else
        {
            f = mediaformatholder.format.pixelWidthHeightRatio;
        }
        pendingPixelWidthHeightRatio = f;
    }

    protected void onOutputFormatChanged(shared_presage.com.google.android.exoplayer.MediaFormat mediaformat, MediaFormat mediaformat1)
    {
        int i;
        int j;
        if (mediaformat1.containsKey("crop-right") && mediaformat1.containsKey("crop-left") && mediaformat1.containsKey("crop-bottom") && mediaformat1.containsKey("crop-top"))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            j = (mediaformat1.getInteger("crop-right") - mediaformat1.getInteger("crop-left")) + 1;
        } else
        {
            j = mediaformat1.getInteger("width");
        }
        currentWidth = j;
        if (i != 0)
        {
            i = (mediaformat1.getInteger("crop-bottom") - mediaformat1.getInteger("crop-top")) + 1;
        } else
        {
            i = mediaformat1.getInteger("height");
        }
        currentHeight = i;
        currentPixelWidthHeightRatio = pendingPixelWidthHeightRatio;
    }

    protected void onStarted()
    {
        super.onStarted();
        droppedFrameCount = 0;
        droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
    }

    protected void onStopped()
    {
        joiningDeadlineUs = -1L;
        maybeNotifyDroppedFrameCount();
        super.onStopped();
    }

    protected boolean processOutputBuffer(long l1, long l2, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i, boolean flag)
    {
        if (flag)
        {
            skipOutputBuffer(mediacodec, i);
            return true;
        }
        long l3 = SystemClock.elapsedRealtime();
        l2 = bufferinfo.presentationTimeUs - l1 - (l3 * 1000L - l2);
        long l4 = System.nanoTime();
        l3 = 1000L * l2 + l4;
        l1 = l3;
        if (frameReleaseTimeHelper != null)
        {
            l1 = frameReleaseTimeHelper.adjustReleaseTime(bufferinfo.presentationTimeUs, l3);
            l2 = (l1 - l4) / 1000L;
        }
        if (l2 < -30000L)
        {
            dropOutputBuffer(mediacodec, i);
            return true;
        }
        if (!renderedFirstFrame)
        {
            if (Util.SDK_INT >= 21)
            {
                renderOutputBufferV21(mediacodec, i, System.nanoTime());
            } else
            {
                renderOutputBuffer(mediacodec, i);
            }
            return true;
        }
        if (getState() != 3)
        {
            return false;
        }
        if (Util.SDK_INT >= 21)
        {
            if (l2 < 50000L)
            {
                renderOutputBufferV21(mediacodec, i, l1);
                return true;
            }
        } else
        if (l2 < 30000L)
        {
            if (l2 > 11000L)
            {
                try
                {
                    Thread.sleep((l2 - 10000L) / 1000L);
                }
                // Misplaced declaration of an exception variable
                catch (ByteBuffer bytebuffer)
                {
                    Thread.currentThread().interrupt();
                }
            }
            renderOutputBuffer(mediacodec, i);
            return true;
        }
        return false;
    }

    protected void renderOutputBuffer(MediaCodec mediacodec, int i)
    {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediacodec.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.renderedOutputBufferCount = ((CodecCounters) (mediacodec)).renderedOutputBufferCount + 1;
        renderedFirstFrame = true;
        maybeNotifyDrawnToSurface();
    }

    protected void renderOutputBufferV21(MediaCodec mediacodec, int i, long l1)
    {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediacodec.releaseOutputBuffer(i, l1);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.renderedOutputBufferCount = ((CodecCounters) (mediacodec)).renderedOutputBufferCount + 1;
        renderedFirstFrame = true;
        maybeNotifyDrawnToSurface();
    }

    protected void seekTo(long l1)
    {
        super.seekTo(l1);
        renderedFirstFrame = false;
        joiningDeadlineUs = -1L;
    }

    protected boolean shouldInitCodec()
    {
        return super.shouldInitCodec() && surface != null && surface.isValid();
    }

    protected void skipOutputBuffer(MediaCodec mediacodec, int i)
    {
        TraceUtil.beginSection("skipVideoBuffer");
        mediacodec.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        mediacodec = codecCounters;
        mediacodec.skippedOutputBufferCount = ((CodecCounters) (mediacodec)).skippedOutputBufferCount + 1;
    }

}
