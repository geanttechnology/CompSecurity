// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer.audio.AudioTrack;
import com.google.android.exoplayer.drm.DrmSessionManager;
import com.google.android.exoplayer.util.MimeTypes;
import java.nio.ByteBuffer;

// Referenced classes of package com.google.android.exoplayer:
//            MediaCodecTrackRenderer, MediaClock, DecoderInfo, ExoPlaybackException, 
//            MediaFormat, CodecCounters, SampleSource

public class MediaCodecAudioTrackRenderer extends MediaCodecTrackRenderer
    implements MediaClock
{
    public static interface EventListener
        extends MediaCodecTrackRenderer.EventListener
    {

        public abstract void onAudioTrackInitializationError(com.google.android.exoplayer.audio.AudioTrack.InitializationException initializationexception);

        public abstract void onAudioTrackWriteError(com.google.android.exoplayer.audio.AudioTrack.WriteException writeexception);
    }


    public static final int MSG_SET_VOLUME = 1;
    private static final String RAW_DECODER_NAME = "OMX.google.raw.decoder";
    private boolean allowPositionDiscontinuity;
    private int audioSessionId;
    private final AudioTrack audioTrack;
    private long currentPositionUs;
    private final EventListener eventListener;

    public MediaCodecAudioTrackRenderer(SampleSource samplesource)
    {
        this(samplesource, ((DrmSessionManager) (null)), true);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, Handler handler, EventListener eventlistener)
    {
        this(samplesource, null, true, handler, eventlistener);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag)
    {
        this(samplesource, drmsessionmanager, flag, null, null);
    }

    public MediaCodecAudioTrackRenderer(SampleSource samplesource, DrmSessionManager drmsessionmanager, boolean flag, Handler handler, EventListener eventlistener)
    {
        super(samplesource, drmsessionmanager, flag, handler, eventlistener);
        eventListener = eventlistener;
        audioSessionId = 0;
        audioTrack = new AudioTrack();
    }

    private void notifyAudioTrackInitializationError(final com.google.android.exoplayer.audio.AudioTrack.InitializationException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new Runnable() {

                final MediaCodecAudioTrackRenderer this$0;
                final com.google.android.exoplayer.audio.AudioTrack.InitializationException val$e;

                public void run()
                {
                    eventListener.onAudioTrackInitializationError(e);
                }

            
            {
                this$0 = MediaCodecAudioTrackRenderer.this;
                e = initializationexception;
                super();
            }
            });
        }
    }

    private void notifyAudioTrackWriteError(final com.google.android.exoplayer.audio.AudioTrack.WriteException e)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new Runnable() {

                final MediaCodecAudioTrackRenderer this$0;
                final com.google.android.exoplayer.audio.AudioTrack.WriteException val$e;

                public void run()
                {
                    eventListener.onAudioTrackWriteError(e);
                }

            
            {
                this$0 = MediaCodecAudioTrackRenderer.this;
                e = writeexception;
                super();
            }
            });
        }
    }

    private void seekToInternal(long l)
    {
        audioTrack.reset();
        currentPositionUs = l;
        allowPositionDiscontinuity = true;
    }

    protected void configureCodec(MediaCodec mediacodec, String s, MediaFormat mediaformat, MediaCrypto mediacrypto)
    {
        if ("OMX.google.raw.decoder".equals(s))
        {
            s = mediaformat.getString("mime");
            mediaformat.setString("mime", "audio/raw");
            mediacodec.configure(mediaformat, null, mediacrypto, 0);
            mediaformat.setString("mime", s);
            return;
        } else
        {
            mediacodec.configure(mediaformat, null, mediacrypto, 0);
            return;
        }
    }

    protected DecoderInfo getDecoderInfo(String s, boolean flag)
        throws MediaCodecUtil.DecoderQueryException
    {
        if (MimeTypes.isPassthroughAudio(s))
        {
            return new DecoderInfo("OMX.google.raw.decoder", true);
        } else
        {
            return super.getDecoderInfo(s, flag);
        }
    }

    protected MediaClock getMediaClock()
    {
        return this;
    }

    public long getPositionUs()
    {
        long l = audioTrack.getCurrentPositionUs(isEnded());
        if (l != 0x8000000000000000L)
        {
            if (!allowPositionDiscontinuity)
            {
                l = Math.max(currentPositionUs, l);
            }
            currentPositionUs = l;
            allowPositionDiscontinuity = false;
        }
        return currentPositionUs;
    }

    protected void handleDiscontinuity()
    {
    }

    public void handleMessage(int i, Object obj)
        throws ExoPlaybackException
    {
        if (i == 1)
        {
            audioTrack.setVolume(((Float)obj).floatValue());
            return;
        } else
        {
            super.handleMessage(i, obj);
            return;
        }
    }

    protected boolean handlesMimeType(String s)
    {
        return MimeTypes.isAudio(s) && super.handlesMimeType(s);
    }

    protected boolean isEnded()
    {
        return super.isEnded() && (!audioTrack.hasPendingData() || !audioTrack.hasEnoughDataToBeginPlayback());
    }

    protected boolean isReady()
    {
        return audioTrack.hasPendingData() || super.isReady() && getSourceState() == 2;
    }

    protected void onAudioSessionId(int i)
    {
    }

    protected void onDisabled()
    {
        audioSessionId = 0;
        audioTrack.release();
        super.onDisabled();
        return;
        Exception exception;
        exception;
        super.onDisabled();
        throw exception;
    }

    protected void onEnabled(long l, boolean flag)
    {
        super.onEnabled(l, flag);
        seekToInternal(l);
    }

    protected void onOutputFormatChanged(com.google.android.exoplayer.MediaFormat mediaformat, MediaFormat mediaformat1)
    {
        if (MimeTypes.isPassthroughAudio(mediaformat.mimeType))
        {
            audioTrack.reconfigure(mediaformat.getFrameworkMediaFormatV16());
            return;
        } else
        {
            audioTrack.reconfigure(mediaformat1);
            return;
        }
    }

    protected void onStarted()
    {
        super.onStarted();
        audioTrack.play();
    }

    protected void onStopped()
    {
        audioTrack.pause();
        super.onStopped();
    }

    protected boolean processOutputBuffer(long l, long l1, MediaCodec mediacodec, ByteBuffer bytebuffer, android.media.MediaCodec.BufferInfo bufferinfo, 
            int i, boolean flag)
        throws ExoPlaybackException
    {
        if (flag)
        {
            mediacodec.releaseOutputBuffer(i, false);
            mediacodec = codecCounters;
            mediacodec.skippedOutputBufferCount = ((CodecCounters) (mediacodec)).skippedOutputBufferCount + 1;
            audioTrack.handleDiscontinuity();
            return true;
        }
        if (audioTrack.isInitialized()) goto _L2; else goto _L1
_L1:
        if (audioSessionId == 0) goto _L4; else goto _L3
_L3:
        audioTrack.initialize(audioSessionId);
_L6:
        if (getState() == 3)
        {
            audioTrack.play();
        }
_L2:
        int j;
        try
        {
            j = audioTrack.handleBuffer(bytebuffer, bufferinfo.offset, bufferinfo.size, bufferinfo.presentationTimeUs);
        }
        // Misplaced declaration of an exception variable
        catch (MediaCodec mediacodec)
        {
            notifyAudioTrackWriteError(mediacodec);
            throw new ExoPlaybackException(mediacodec);
        }
        if ((j & 1) != 0)
        {
            handleDiscontinuity();
            allowPositionDiscontinuity = true;
        }
        if ((j & 2) != 0)
        {
            mediacodec.releaseOutputBuffer(i, false);
            mediacodec = codecCounters;
            mediacodec.renderedOutputBufferCount = ((CodecCounters) (mediacodec)).renderedOutputBufferCount + 1;
            return true;
        } else
        {
            return false;
        }
_L4:
        try
        {
            audioSessionId = audioTrack.initialize();
            onAudioSessionId(audioSessionId);
        }
        // Misplaced declaration of an exception variable
        catch (MediaCodec mediacodec)
        {
            notifyAudioTrackInitializationError(mediacodec);
            throw new ExoPlaybackException(mediacodec);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void seekTo(long l)
        throws ExoPlaybackException
    {
        super.seekTo(l);
        seekToInternal(l);
    }

}
