// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import shared_presage.com.google.android.exoplayer.drm.DrmInitData;
import shared_presage.com.google.android.exoplayer.drm.DrmSessionManager;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.TraceUtil;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            TrackRenderer, SampleSource, CodecCounters, SampleHolder, 
//            MediaFormatHolder, MediaFormat, ExoPlaybackException, CryptoInfo, 
//            h, g, i, TrackInfo, 
//            MediaCodecUtil, DecoderInfo

public abstract class MediaCodecTrackRenderer extends TrackRenderer
{
    public static class DecoderInitializationException extends Exception
    {

        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;

        private static String buildCustomDiagnosticInfo(int j)
        {
            String s;
            if (j < 0)
            {
                s = "neg_";
            } else
            {
                s = "";
            }
            return (new StringBuilder("shared_presage.com.google.android.exoplayer.MediaCodecTrackRenderer_")).append(s).append(Math.abs(j)).toString();
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

        public DecoderInitializationException(shared_presage.com.google.android.exoplayer.MediaFormat mediaformat, Throwable throwable, int j)
        {
            super((new StringBuilder("Decoder init failed: [")).append(j).append("], ").append(mediaformat).toString(), throwable);
            decoderName = null;
            diagnosticInfo = buildCustomDiagnosticInfo(j);
        }

        public DecoderInitializationException(shared_presage.com.google.android.exoplayer.MediaFormat mediaformat, Throwable throwable, String s)
        {
            super((new StringBuilder("Decoder init failed: ")).append(s).append(", ").append(mediaformat).toString(), throwable);
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
    private shared_presage.com.google.android.exoplayer.MediaFormat format;
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
        int j = getDecodeOnlyIndex(outputBufferInfo.presentationTimeUs);
        MediaCodec mediacodec = codec;
        ByteBuffer bytebuffer = outputBuffers[outputIndex];
        android.media.MediaCodec.BufferInfo bufferinfo = outputBufferInfo;
        int k = outputIndex;
        boolean flag;
        if (j != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (processOutputBuffer(l, l1, mediacodec, bytebuffer, bufferinfo, k, flag))
        {
            if (j != -1)
            {
                decodeOnlyPresentationTimestamps.remove(j);
            }
            outputIndex = -1;
            return true;
        } else
        {
            return false;
        }
    }

    private boolean feedInputBuffer(long l, boolean flag)
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
        int j = -3;
_L4:
        if (j == -2)
        {
            return false;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (codecReconfigurationState == 1)
        {
            for (j = 0; j < format.initializationData.size(); j++)
            {
                byte abyte0[] = (byte[])format.initializationData.get(j);
                sampleHolder.data.put(abyte0);
            }

            codecReconfigurationState = 2;
        }
        int k = source.readData(trackIndex, l, formatHolder, sampleHolder, false);
        j = k;
        if (flag)
        {
            j = k;
            if (sourceState == 1)
            {
                j = k;
                if (k == -2)
                {
                    sourceState = 2;
                    j = k;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (j == -5)
        {
            flushCodec();
            return true;
        }
        if (j == -4)
        {
            if (codecReconfigurationState == 2)
            {
                sampleHolder.data.clear();
                codecReconfigurationState = 1;
            }
            onInputFormatChanged(formatHolder);
            return true;
        }
        if (j == -1)
        {
            if (codecReconfigurationState == 2)
            {
                sampleHolder.data.clear();
                codecReconfigurationState = 1;
            }
            inputStreamEnded = true;
            try
            {
                if (!codecNeedsEndOfStreamWorkaround)
                {
                    codec.queueInputBuffer(inputIndex, 0, 0, 0L, 4);
                    inputIndex = -1;
                }
            }
            catch (android.media.MediaCodec.CryptoException cryptoexception)
            {
                notifyCryptoError(cryptoexception);
                throw new ExoPlaybackException(cryptoexception);
            }
            return false;
        }
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
            break MISSING_BLOCK_LABEL_590;
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
    }

    private void flushCodec()
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
        int k = decodeOnlyPresentationTimestamps.size();
        for (int j = 0; j < k; j++)
        {
            if (((Long)decodeOnlyPresentationTimestamps.get(j)).longValue() == l)
            {
                return j;
            }
        }

        return -1;
    }

    private static android.media.MediaCodec.CryptoInfo getFrameworkCryptoInfo(SampleHolder sampleholder, int j)
    {
        sampleholder = sampleholder.cryptoInfo.getFrameworkCryptoInfoV16();
        if (j == 0)
        {
            return sampleholder;
        }
        if (((android.media.MediaCodec.CryptoInfo) (sampleholder)).numBytesOfClearData == null)
        {
            sampleholder.numBytesOfClearData = new int[1];
        }
        int ai[] = ((android.media.MediaCodec.CryptoInfo) (sampleholder)).numBytesOfClearData;
        ai[0] = ai[0] + j;
        return sampleholder;
    }

    private boolean isWithinHotswapPeriod()
    {
        return SystemClock.elapsedRealtime() < codecHotswapTimeMs + 1000L;
    }

    private void notifyAndThrowDecoderInitError(DecoderInitializationException decoderinitializationexception)
    {
        notifyDecoderInitializationError(decoderinitializationexception);
        throw new ExoPlaybackException(decoderinitializationexception);
    }

    private void notifyCryptoError(android.media.MediaCodec.CryptoException cryptoexception)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new h(this, cryptoexception));
        }
    }

    private void notifyDecoderInitializationError(DecoderInitializationException decoderinitializationexception)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new g(this, decoderinitializationexception));
        }
    }

    private void notifyDecoderInitialized(String s, long l, long l1)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new i(this, s, l, l1));
        }
    }

    private void processEndOfStream()
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
    {
        if (openedDrmSession)
        {
            int j = drmSessionManager.getState();
            if (j == 0)
            {
                throw new ExoPlaybackException(drmSessionManager.getError());
            }
            if (j != 4 && (flag || !playClearSamplesWithoutKeys))
            {
                return true;
            }
        }
        return false;
    }

    protected boolean canReconfigureCodec(MediaCodec mediacodec, boolean flag, shared_presage.com.google.android.exoplayer.MediaFormat mediaformat, shared_presage.com.google.android.exoplayer.MediaFormat mediaformat1)
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
        int j = 0;
        if (!source.prepare(l))
        {
            return 0;
        }
        for (int k = source.getTrackCount(); j < k; j++)
        {
            if (handlesMimeType(source.getTrackInfo(j).mimeType))
            {
                trackIndex = j;
                return 1;
            }
        }

        return -1;
    }

    protected void doSomeWork(long l, long l1)
    {
        int j;
        if (source.continueBuffering(trackIndex, l))
        {
            if (sourceState == 0)
            {
                j = 1;
            } else
            {
                j = sourceState;
            }
        } else
        {
            j = 0;
        }
        sourceState = j;
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
    {
        if (shouldInitCodec()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj1;
        boolean flag;
        obj1 = format.mimeType;
        flag = false;
        if (drmInitData == null) goto _L4; else goto _L3
_L3:
        int j;
        if (drmSessionManager == null)
        {
            throw new ExoPlaybackException("Media requires a DrmSessionManager");
        }
        if (!openedDrmSession)
        {
            drmSessionManager.open(drmInitData);
            openedDrmSession = true;
        }
        j = drmSessionManager.getState();
        if (j == 0)
        {
            throw new ExoPlaybackException(drmSessionManager.getError());
        }
        if (j != 3 && j != 4) goto _L1; else goto _L5
_L5:
        Object obj;
        obj = drmSessionManager.getMediaCrypto();
        flag = drmSessionManager.requiresSecureDecoderComponent(((String) (obj1)));
_L7:
        String s;
        long l1;
        try
        {
            obj1 = getDecoderInfo(((String) (obj1)), flag);
        }
        catch (MediaCodecUtil.DecoderQueryException decoderqueryexception)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, decoderqueryexception, -49998));
            decoderqueryexception = null;
        }
        if (obj1 == null)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, null, -49999));
        }
        s = ((DecoderInfo) (obj1)).name;
        codecIsAdaptive = ((DecoderInfo) (obj1)).adaptive;
        codecNeedsEndOfStreamWorkaround = codecNeedsEndOfStreamWorkaround(s);
        try
        {
            long l = SystemClock.elapsedRealtime();
            TraceUtil.beginSection((new StringBuilder("createByCodecName(")).append(s).append(")").toString());
            codec = MediaCodec.createByCodecName(s);
            TraceUtil.endSection();
            TraceUtil.beginSection("configureCodec");
            configureCodec(codec, s, format.getFrameworkMediaFormatV16(), ((MediaCrypto) (obj)));
            TraceUtil.endSection();
            TraceUtil.beginSection("codec.start()");
            codec.start();
            TraceUtil.endSection();
            long l2 = SystemClock.elapsedRealtime();
            notifyDecoderInitialized(s, l2, l2 - l);
            inputBuffers = codec.getInputBuffers();
            outputBuffers = codec.getOutputBuffers();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            notifyAndThrowDecoderInitError(new DecoderInitializationException(format, ((Throwable) (obj)), s));
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
_L4:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void maybeThrowError()
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
    {
        shared_presage.com.google.android.exoplayer.MediaFormat mediaformat = format;
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

    protected void onOutputFormatChanged(shared_presage.com.google.android.exoplayer.MediaFormat mediaformat, MediaFormat mediaformat1)
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
            int j, boolean flag);

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
    {
        source.seekToUs(l);
        seekToInternal();
    }

    protected boolean shouldInitCodec()
    {
        return codec == null && format != null;
    }

}
