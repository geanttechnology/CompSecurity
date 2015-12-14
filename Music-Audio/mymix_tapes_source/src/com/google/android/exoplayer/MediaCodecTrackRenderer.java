// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer.drm.DrmInitData;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.TraceUtil;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.exoplayer:
//            TrackRenderer, SampleSource, CodecCounters, SampleHolder, 
//            MediaFormatHolder, ExoPlaybackException, MediaFormat, CryptoInfo, 
//            TrackInfo, MediaCodecUtil, DecoderInfo

public abstract class MediaCodecTrackRenderer extends TrackRenderer
{
    public static class DecoderInitializationException extends Exception
    {

        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;

        private static String buildCustomDiagnosticInfo(int i)
        {
            String s;
            if (i < 0)
            {
                s = "neg_";
            } else
            {
                s = "";
            }
            return (new StringBuilder()).append("com.google.android.exoplayer.MediaCodecTrackRenderer_").append(s).append(Math.abs(i)).toString();
        }

        private static String getDiagnosticInfoV21(Throwable throwable)
        {
            if (throwable instanceof android.media.MediaCodec.CodecException)
            {
                return ((android.media.MediaCodec.CodecException)throwable).getDiagnosticInfo();
            } else
            {
                return null;
            }
        }

        public DecoderInitializationException(com.google.android.exoplayer.MediaFormat mediaformat, Throwable throwable, int i)
        {
            super((new StringBuilder()).append("Decoder init failed: [").append(i).append("], ").append(mediaformat).toString(), throwable);
            decoderName = null;
            diagnosticInfo = buildCustomDiagnosticInfo(i);
        }

        public DecoderInitializationException(com.google.android.exoplayer.MediaFormat mediaformat, Throwable throwable, String s)
        {
            super((new StringBuilder()).append("Decoder init failed: ").append(s).append(", ").append(mediaformat).toString(), throwable);
            decoderName = s;
            if (Util.SDK_INT >= 21)
            {
                mediaformat = getDiagnosticInfoV21(throwable);
            } else
            {
                mediaformat = null;
            }
            diagnosticInfo = mediaformat;
        }
    }

    public static interface EventListener
    {

        public abstract void onCryptoError(android.media.MediaCodec.CryptoException cryptoexception);

        public abstract void onDecoderInitializationError(DecoderInitializationException decoderinitializationexception);

        public abstract void onDecoderInitialized(String s, long l, long l1);
    }


    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000L;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    protected static final int SOURCE_STATE_NOT_READY = 0;
    protected static final int SOURCE_STATE_READY = 1;
    protected static final int SOURCE_STATE_READY_READ_MAY_FAIL = 2;
    private MediaCodec codec;
    public final CodecCounters codecCounters = new CodecCounters();
    private boolean codecHasQueuedBuffers;
    private long codecHotswapTimeMs;
    private boolean codecIsAdaptive;
    private boolean codecNeedsEndOfStreamWorkaround;
    private int codecReconfigurationState;
    private boolean codecReconfigured;
    private int codecReinitializationState;
    private final List decodeOnlyPresentationTimestamps = new ArrayList();
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    protected final Handler eventHandler;
    private final EventListener eventListener;
    private com.google.android.exoplayer.MediaFormat format;
    private final MediaFormatHolder formatHolder = new MediaFormatHolder();
    private ByteBuffer inputBuffers[];
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean openedDrmSession;
    private final android.media.MediaCodec.BufferInfo outputBufferInfo = new android.media.MediaCodec.BufferInfo();
    private ByteBuffer outputBuffers[];
    private int outputIndex;
    private boolean outputStreamEnded;
    private final boolean playClearSamplesWithoutKeys;
    private final SampleHolder sampleHolder = new SampleHolder(0);
    private final SampleSource.SampleSourceReader source;
    private int sourceState;
    private int trackIndex;
    private boolean waitingForFirstSyncFrame;
    private boolean waitingForKeys;

    public MediaCodecTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, Handler handler, EventListener eventlistener)
    {
        boolean flag1;
        if (Util.SDK_INT >= 16)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Assertions.checkState(flag1);
        source = samplesource.register();
        drmSessionManager = drmsessionmanager;
        playClearSamplesWithoutKeys = flag;
        eventHandler = handler;
        eventListener = eventlistener;
        codecReconfigurationState = 0;
        codecReinitializationState = 0;
    }

    private void checkForDiscontinuity(long l)
        throws ExoPlaybackException
    {
        while (codec == null || source.readData(trackIndex, l, formatHolder, sampleHolder, true) != -5) 
        {
            return;
        }
        flushCodec();
    }

    private static boolean codecNeedsEndOfStreamWorkaround(String s)
    {
        return Util.SDK_INT <= 17 && "ht7s3".equals(Util.DEVICE) && "OMX.rk.video_decoder.avc".equals(s);
    }

    private boolean drainOutputBuffer(long l, long l1)
        throws ExoPlaybackException
    {
        if (outputStreamEnded)
        {
            return false;
        }
        if (outputIndex < 0)
        {
            outputIndex = codec.dequeueOutputBuffer(outputBufferInfo, getDequeueOutputBufferTimeoutUs());
        }
        if (outputIndex == -2)
        {
            onOutputFormatChanged(format, codec.getOutputFormat());
            CodecCounters codeccounters = codecCounters;
            codeccounters.outputFormatChangedCount = codeccounters.outputFormatChangedCount + 1;
            return true;
        }
        if (outputIndex == -3)
        {
            outputBuffers = codec.getOutputBuffers();
            CodecCounters codeccounters1 = codecCounters;
            codeccounters1.outputBuffersChangedCount = codeccounters1.outputBuffersChangedCount + 1;
            return true;
        }
        if (outputIndex < 0)
        {
            if (codecNeedsEndOfStreamWorkaround && (inputStreamEnded || codecReinitializationState == 2))
            {
                processEndOfStream();
                return true;
            } else
            {
                return false;
            }
        }
        if ((outputBufferInfo.flags & 4) != 0)
        {
            processEndOfStream();
            return false;
        }
        int i = getDecodeOnlyIndex(outputBufferInfo.presentationTimeUs);
        MediaCodec mediacodec = codec;
        ByteBuffer bytebuffer = outputBuffers[outputIndex];
        android.media.MediaCodec.BufferInfo bufferinfo = outputBufferInfo;
        int j = outputIndex;
        boolean flag;
        if (i != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (processOutputBuffer(l, l1, mediacodec, bytebuffer, bufferinfo, j, flag))
        {
            if (i != -1)
            {
                decodeOnlyPresentationTimestamps.remove(i);
            }
            outputIndex = -1;
            return true;
        } else
        {
            return false;
        }
    }

    private boolean feedInputBuffer(long l, boolean flag)
        throws ExoPlaybackException
    {
        if (inputStreamEnded || codecReinitializationState == 2)
        {
            return false;
        }
        if (inputIndex < 0)
        {
            inputIndex = codec.dequeueInputBuffer(0L);
            if (inputIndex < 0)
            {
                return false;
            }
            sampleHolder.data = inputBuffers[inputIndex];
            sampleHolder.data.clear();
        }
        if (codecReinitializationState == 1)
        {
            if (!codecNeedsEndOfStreamWorkaround)
            {
                codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
                inputIndex = -1;
            }
            codecReinitializationState = 2;
            return false;
        }
        if (!waitingForKeys) goto _L2; else goto _L1
_L1:
        int i = -3;
_L4:
        if (i == -2)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (codecReconfigurationState == 1)
        {
            for (i = 0; i < format.initializationData.size(); i++)
            {
                byte abyte0[] = (byte[])format.initializationData.get(i);
                sampleHolder.data.put(abyte0);
            }

            codecReconfigurationState = 2;
        }
        int k = source.readData(trackIndex, l, formatHolder, sampleHolder, false);
        i = k;
        if (flag)
        {
            i = k;
            if (sourceState == 1)
            {
                i = k;
                if (k == -2)
                {
                    sourceState = 2;
                    i = k;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i == -5)
        {
            flushCodec();
            return true;
        }
        if (i == -4)
        {
            if (codecReconfigurationState == 2)
            {
                sampleHolder.data.clear();
                codecReconfigurationState = 1;
            }
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_419;
        }
        if (codecReconfigurationState == 2)
        {
            sampleHolder.data.clear();
            codecReconfigurationState = 1;
        }
        inputStreamEnded = true;
        if (!codecNeedsEndOfStreamWorkaround)
        {
            try
            {
                codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
                inputIndex = -1;
            }
            catch (android.media.MediaCodec.CryptoException cryptoexception)
            {
                notifyCryptoError(cryptoexception);
                throw new ExoPlaybackException(cryptoexception);
            }
        }
        break MISSING_BLOCK_LABEL_634;
        if (waitingForFirstSyncFrame)
        {
            if (!sampleHolder.isSyncFrame())
            {
                sampleHolder.data.clear();
                if (codecReconfigurationState == 2)
                {
                    codecReconfigurationState = 1;
                }
                return true;
            }
            waitingForFirstSyncFrame = false;
        }
        flag = sampleHolder.isEncrypted();
        waitingForKeys = shouldWaitForKeys(flag);
        if (waitingForKeys)
        {
            return false;
        }
        android.media.MediaCodec.CryptoInfo cryptoinfo;
        int j;
        int i1;
        try
        {
            j = sampleHolder.data.position();
            i1 = sampleHolder.size;
            l = sampleHolder.timeUs;
            if (sampleHolder.isDecodeOnly())
            {
                decodeOnlyPresentationTimestamps.add(Long.valueOf(l));
            }
        }
        catch (android.media.MediaCodec.CryptoException cryptoexception1)
        {
            notifyCryptoError(cryptoexception1);
            throw new ExoPlaybackException(cryptoexception1);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_597;
        }
        cryptoinfo = getFrameworkCryptoInfo(sampleHolder, j - i1);
        codec.queueSecureInputBuffer(inputIndex, 0, cryptoinfo, l, 0);
_L5:
        inputIndex = -1;
        codecHasQueuedBuffers = true;
        codecReconfigurationState = 0;
        return true;
        codec.queueInputBuffer(inputIndex, 0, j, l, 0);
          goto _L5
        return false;
    }

    private void flushCodec()
        throws ExoPlaybackException
    {
        codecHotswapTimeMs = -1L;
        inputIndex = -1;
        outputIndex = -1;
        waitingForFirstSyncFrame = true;
        waitingForKeys = false;
        decodeOnlyPresentationTimestamps.clear();
        if (Util.SDK_INT >= 18 && codecReinitializationState == 0)
        {
            codec.flush();
            codecHasQueuedBuffers = false;
        } else
        {
            releaseCodec();
            maybeInitCodec();
        }
        if (codecReconfigured && format != null)
        {
            codecReconfigurationState = 1;
        }
    }

    private int getDecodeOnlyIndex(long l)
    {
        int j = decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < j; i++)
        {
            if (((Long)decodeOnlyPresentationTimestamps.get(i)).longValue() == l)
            {
                return i;
            }
        }

        return -1;
    }

    private static android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfo(SampleHolder sampleholder, int i)
    {
        sampleholder = sampleholder.cryptoInfo.getFrameworkCryptoInfoV16();
        if (i == 0)
        {
            return sampleholder;
        }
        if (((android.media.MediaCodec.CryptoInfo) (sampleholder)).numBytesOfClearData == null)
        {
            sampleholder.numBytesOfClearData = new int[1];
        }
        int ai[] = ((android.media.MediaCodec.CryptoInfo) (sampleholder)).numBytesOfClearData;
        ai[0] = ai[0] + i;
        return sampleholder;
    }

    private boolean isWithinHotswapPeriod()
    {
        return SystemClock.elapsedRealtime() < codecHotswapTimeMs + 1000L;
    }

    private void notifyAndThrowDecoderInitError(DecoderInitializationException decoderinitializationexception)
        throws ExoPlaybackException
    {
        notifyDecoderInitializationError(decoderinitializationexception);
        throw new ExoPlaybackException(decoderinitializationexception);
    }

    private void notifyCryptoError(final android.media.MediaCodec.CryptoException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new Runnable() {

                final MediaCodecTrackRenderer this$0;
                final android.media.MediaCodec.CryptoException val$e;

                public void run()
                {
                    eventListener.onCryptoError(e);
                }

            
            {
                this$0 = MediaCodecTrackRenderer.this;
                e = cryptoexception;
                super();
            }
            });
        }
    }

    private void notifyDecoderInitializationError(final DecoderInitializationException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new Runnable() {

                final MediaCodecTrackRenderer this$0;
                final DecoderInitializationException val$e;

                public void run()
                {
                    eventListener.onDecoderInitializationError(e);
                }

            
            {
                this$0 = MediaCodecTrackRenderer.this;
                e = decoderinitializationexception;
                super();
            }
            });
        }
    }

    private void notifyDecoderInitialized(final String decoderName, final long initializedTimestamp, final long initializationDuration)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new Runnable() {

                final MediaCodecTrackRenderer this$0;
                final String val$decoderName;
                final long val$initializationDuration;
                final long val$initializedTimestamp;

                public void run()
                {
                    eventListener.onDecoderInitialized(decoderName, initializedTimestamp, initializationDuration);
                }

            
            {
                this$0 = MediaCodecTrackRenderer.this;
                decoderName = s;
                initializedTimestamp = l;
                initializationDuration = l1;
                super();
            }
            });
        }
    }

    private void processEndOfStream()
        throws ExoPlaybackException
    {
        if (codecReinitializationState == 2)
        {
            releaseCodec();
            maybeInitCodec();
            return;
        } else
        {
            outputStreamEnded = true;
            return;
        }
    }

    private void readFormat(long l)
        throws ExoPlaybackException
    {
        if (source.readData(trackIndex, l, formatHolder, sampleHolder, false) == -4)
        {
            onInputFormatChanged(formatHolder);
        }
    }

    private void seekToInternal()
    {
        sourceState = 0;
        inputStreamEnded = false;
        outputStreamEnded = false;
    }

    private boolean shouldWaitForKeys(boolean flag)
        throws ExoPlaybackException
    {
        if (openedDrmSession)
        {
            int i = drmSessionManager.getState();
            if (i == 0)
            {
                throw new ExoPlaybackException(drmSessionManager.getError());
            }
            if (i != 4 && (flag || !playClearSamplesWithoutKeys))
            {
                return true;
            }
        }
        return false;
    }

    protected boolean canReconfigureCodec(MediaCodec mediacodec, boolean flag, com.google.android.exoplayer.MediaFormat mediaformat, com.google.android.exoplayer.MediaFormat mediaformat1)
    {
        return false;
    }

    protected final boolean codecInitialized()
    {
        return codec != null;
    }

    protected void configureCodec(MediaCodec mediacodec, String s, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        mediacodec.configure(mediaformat, null, mediacrypto, 0);
    }

    protected int doPrepare(long l)
    {
        if (!source.prepare(l))
        {
            return 0;
        }
        int j = source.getTrackCount();
        for (int i = 0; i < j; i++)
        {
            if (handlesMimeType(source.getTrackInfo(i).mimeType))
            {
                trackIndex = i;
                return 1;
            }
        }

        return -1;
    }

    protected void doSomeWork(long l, long l1)
        throws ExoPlaybackException
    {
        int i;
        if (source.continueBuffering(trackIndex, l))
        {
            if (sourceState == 0)
            {
                i = 1;
            } else
            {
                i = sourceState;
            }
        } else
        {
            i = 0;
        }
        sourceState = i;
        checkForDiscontinuity(l);
        if (format == null)
        {
            readFormat(l);
        }
        if (codec == null && shouldInitCodec())
        {
            maybeInitCodec();
        }
        if (codec != null)
        {
            TraceUtil.beginSection("drainAndFeed");
            while (drainOutputBuffer(l, l1)) ;
            if (feedInputBuffer(l, true))
            {
                while (feedInputBuffer(l, false)) ;
            }
            TraceUtil.endSection();
        }
        codecCounters.ensureUpdated();
    }

    protected long getBufferedPositionUs()
    {
        return source.getBufferedPositionUs();
    }

    protected DecoderInfo getDecoderInfo(String s, boolean flag)
        throws MediaCodecUtil.DecoderQueryException
    {
        return MediaCodecUtil.getDecoderInfo(s, flag);
    }

    protected long getDequeueOutputBufferTimeoutUs()
    {
        return 0L;
    }

    protected long getDurationUs()
    {
        return source.getTrackInfo(trackIndex).durationUs;
    }

    protected final int getSourceState()
    {
        return sourceState;
    }

    protected boolean handlesMimeType(String s)
    {
        return true;
    }

    protected final boolean haveFormat()
    {
        return format != null;
    }

    protected boolean isEnded()
    {
        return outputStreamEnded;
    }

    protected boolean isReady()
    {
        return format != null && !waitingForKeys && (sourceState != 0 || outputIndex >= 0 || isWithinHotswapPeriod());
    }

    protected final void maybeInitCodec()
        throws ExoPlaybackException
    {
        if (shouldInitCodec()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        boolean flag;
        obj1 = format.mimeType;
        obj = null;
        flag = false;
        if (drmInitData == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (drmSessionManager == null)
        {
            throw new ExoPlaybackException("Media requires a DrmSessionManager");
        }
        if (!openedDrmSession)
        {
            drmSessionManager.open(drmInitData);
            openedDrmSession = true;
        }
        int i = drmSessionManager.getState();
        if (i == 0)
        {
            throw new ExoPlaybackException(drmSessionManager.getError());
        }
        if (i != 3 && i != 4)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = drmSessionManager.getMediaCrypto();
        flag = drmSessionManager.requiresSecureDecoderComponent(((String) (obj1)));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        DecoderInfo decoderinfo = null;
        obj1 = getDecoderInfo(((String) (obj1)), flag);
        decoderinfo = ((DecoderInfo) (obj1));
_L4:
        if (decoderinfo == null)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, null, -49999));
        }
        Object obj2 = decoderinfo.name;
        codecIsAdaptive = decoderinfo.adaptive;
        codecNeedsEndOfStreamWorkaround = codecNeedsEndOfStreamWorkaround(((String) (obj2)));
        long l1;
        try
        {
            long l = SystemClock.elapsedRealtime();
            TraceUtil.beginSection((new StringBuilder()).append("createByCodecName(").append(((String) (obj2))).append(")").toString());
            codec = MediaCodec.createByCodecName(((String) (obj2)));
            TraceUtil.endSection();
            TraceUtil.beginSection("configureCodec");
            configureCodec(codec, ((String) (obj2)), format.getFrameworkMediaFormatV16(), ((MediaCrypto) (obj)));
            TraceUtil.endSection();
            TraceUtil.beginSection("codec.start()");
            codec.start();
            TraceUtil.endSection();
            long l2 = SystemClock.elapsedRealtime();
            notifyDecoderInitialized(((String) (obj2)), l2, l2 - l);
            inputBuffers = codec.getInputBuffers();
            outputBuffers = codec.getOutputBuffers();
        }
        catch (Exception exception)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, exception, ((String) (obj2))));
        }
        if (getState() == 3)
        {
            l1 = SystemClock.elapsedRealtime();
        } else
        {
            l1 = -1L;
        }
        codecHotswapTimeMs = l1;
        inputIndex = -1;
        outputIndex = -1;
        waitingForFirstSyncFrame = true;
        obj = codecCounters;
        obj.codecInitCount = ((CodecCounters) (obj)).codecInitCount + 1;
        return;
        obj2;
        notifyAndThrowDecoderInitError(new DecoderInitializationException(format, ((Throwable) (obj2)), -49998));
          goto _L4
    }

    protected void maybeThrowError()
        throws ExoPlaybackException
    {
        try
        {
            source.maybeThrowError();
            return;
        }
        catch (IOException ioexception)
        {
            throw new ExoPlaybackException(ioexception);
        }
    }

    protected void onDisabled()
    {
        format = null;
        drmInitData = null;
        releaseCodec();
        if (openedDrmSession)
        {
            drmSessionManager.close();
            openedDrmSession = false;
        }
        source.disable(trackIndex);
        return;
        Exception exception;
        exception;
        source.disable(trackIndex);
        throw exception;
        exception;
        if (openedDrmSession)
        {
            drmSessionManager.close();
            openedDrmSession = false;
        }
        source.disable(trackIndex);
        throw exception;
        exception;
        source.disable(trackIndex);
        throw exception;
    }

    protected void onEnabled(long l, boolean flag)
    {
        source.enable(trackIndex, l);
        seekToInternal();
    }

    protected void onInputFormatChanged(MediaFormatHolder mediaformatholder)
        throws ExoPlaybackException
    {
        com.google.android.exoplayer.MediaFormat mediaformat = format;
        format = mediaformatholder.format;
        drmInitData = mediaformatholder.drmInitData;
        if (codec != null && canReconfigureCodec(codec, codecIsAdaptive, mediaformat, format))
        {
            codecReconfigured = true;
            codecReconfigurationState = 1;
            return;
        }
        if (codecHasQueuedBuffers)
        {
            codecReinitializationState = 1;
            return;
        } else
        {
            releaseCodec();
            maybeInitCodec();
            return;
        }
    }

    protected void onOutputFormatChanged(com.google.android.exoplayer.MediaFormat mediaformat, MediaFormat mediaformat1)
    {
    }

    protected void onReleased()
    {
        source.release();
    }

    protected void onStarted()
    {
    }

    protected void onStopped()
    {
    }

    protected abstract boolean processOutputBuffer(long l, long l1, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i, boolean flag)
        throws ExoPlaybackException;

    protected void releaseCodec()
    {
        if (codec == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        codecHotswapTimeMs = -1L;
        inputIndex = -1;
        outputIndex = -1;
        waitingForKeys = false;
        decodeOnlyPresentationTimestamps.clear();
        inputBuffers = null;
        outputBuffers = null;
        codecReconfigured = false;
        codecHasQueuedBuffers = false;
        codecIsAdaptive = false;
        codecNeedsEndOfStreamWorkaround = false;
        codecReconfigurationState = 0;
        codecReinitializationState = 0;
        CodecCounters codeccounters = codecCounters;
        codeccounters.codecReleaseCount = codeccounters.codecReleaseCount + 1;
        codec.stop();
        codec.release();
        codec = null;
        return;
        Exception exception;
        exception;
        codec = null;
        throw exception;
        exception;
        codec.release();
        codec = null;
        throw exception;
        exception;
        codec = null;
        throw exception;
    }

    protected void seekTo(long l)
        throws ExoPlaybackException
    {
        source.seekToUs(l);
        seekToInternal();
    }

    protected boolean shouldInitCodec()
    {
        return codec == null && format != null;
    }

}
