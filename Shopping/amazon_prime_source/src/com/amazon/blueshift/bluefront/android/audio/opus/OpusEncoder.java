// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio.opus;

import com.amazon.blueshift.bluefront.android.audio.AudioEncoder;
import com.amazon.blueshift.bluefront.android.audio.AudioEncoderException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.common.net.MediaType;
import java.nio.ByteBuffer;
import java.util.Set;

public class OpusEncoder
    implements AudioEncoder
{

    private static final int APPLICATION_AUDIO = 2049;
    private static final int BIT_RATE_INTERVAL = 400;
    private static final int DEFAULT_BIT_RATE = 32000;
    private static final int DEFAULT_CHANNELS = 1;
    private static final int DEFAULT_COMPLEXITY = 10;
    private static final int DEFAULT_FRAME_SIZE_MILLIS = 20;
    private static final int DEFAULT_SAMPLE_RATE = 16000;
    private static final boolean IS_VBR = false;
    private static final int MAX_BIT_RATE = 0x7d000;
    private static final int MAX_COMPLEXITY = 10;
    private static final int MIN_BIT_RATE = 6000;
    private static final int MIN_COMPLEXITY = 1;
    private static final int MS_PER_SEC = 1000;
    private static final int SIGNAL_VOICE = 3001;
    private static final Set VALID_FRAME_SIZE_MILLIS = Sets.newHashSet(new Integer[] {
        Integer.valueOf(5), Integer.valueOf(10), Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(60)
    });
    private static final Set VALID_SAMPLES_RATES = Sets.newHashSet(new Integer[] {
        Integer.valueOf(8000), Integer.valueOf(12000), Integer.valueOf(16000), Integer.valueOf(24000), Integer.valueOf(48000)
    });
    private final int mFrameSize;
    private final MediaType mMediaType;
    private ByteBuffer mOpusEncoder;
    private final int mPacketSize;

    public OpusEncoder()
        throws AudioEncoderException
    {
        this(20, 16000, 1, 32000, 10);
    }

    public OpusEncoder(int i, int j, int k, int l, int i1)
        throws AudioEncoderException
    {
        boolean flag1 = true;
        super();
        Preconditions.checkArgument(VALID_FRAME_SIZE_MILLIS.contains(Integer.valueOf(i)), "Frame size is invalid");
        Preconditions.checkArgument(VALID_SAMPLES_RATES.contains(Integer.valueOf(j)), "Sample rate is invalid");
        boolean flag;
        if (k == 1 || k == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Number of channels is invalid");
        if (l >= 6000 && l <= 0x7d000 && (l - 6000) % 400 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Bitrate is invalid");
        if (i1 >= 1 && i1 <= 10)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Complexity is invalid");
        mOpusEncoder = createOpusEncoder(j, k, l, i1, false, 2049, 3001);
        mPacketSize = (l * i) / 8000;
        mFrameSize = (j * i) / 1000;
        mMediaType = MediaType.parse("audio/x-cbr-opus-with-preamble").withParameter("bit-rate", Integer.toString(l)).withParameter("frame-size-milliseconds", Integer.toString(i)).withParameter("preamble-size", "0");
    }

    private native ByteBuffer createOpusEncoder(int i, int j, int k, int l, boolean flag, int i1, int j1)
        throws AudioEncoderException;

    private native void destroyOpusEncoder(ByteBuffer bytebuffer);

    private native byte[] encodeOpus(ByteBuffer bytebuffer, short aword0[], int i)
        throws AudioEncoderException;

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mOpusEncoder != null)
        {
            destroyOpusEncoder(mOpusEncoder);
            mOpusEncoder = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public byte[] encode(short aword0[], int i)
        throws AudioEncoderException
    {
        this;
        JVM INSTR monitorenter ;
        Preconditions.checkNotNull(mOpusEncoder, "Opus encoder is not initialized");
        Preconditions.checkNotNull(aword0, "Samples buffer cannot be null");
        boolean flag;
        if (aword0.length >= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Number of samples cannot exceed buffer size");
        aword0 = encodeOpus(mOpusEncoder, aword0, mPacketSize);
        this;
        JVM INSTR monitorexit ;
        return aword0;
        aword0;
        throw aword0;
    }

    public int getFrameSize()
    {
        return mFrameSize;
    }

    public MediaType getMediaType()
    {
        return mMediaType;
    }

    public int getPacketSize()
    {
        return mPacketSize;
    }

    static 
    {
        System.loadLibrary("blueshift-opus");
    }
}
