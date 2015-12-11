// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad;

import com.amazon.blueshift.bluefront.android.vad.config.VADConfig;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

// Referenced classes of package com.amazon.blueshift.bluefront.android.vad:
//            VADException

public abstract class VoiceActivityDetector
    implements Closeable
{
    public static final class VADState extends Enum
    {

        private static final VADState $VALUES[];
        public static final VADState ENDPOINTED;
        public static final VADState NOT_STARTPOINTED;
        public static final VADState STARTPOINTED;

        public static VADState valueOf(String s)
        {
            return (VADState)Enum.valueOf(com/amazon/blueshift/bluefront/android/vad/VoiceActivityDetector$VADState, s);
        }

        public static VADState[] values()
        {
            return (VADState[])$VALUES.clone();
        }

        static 
        {
            NOT_STARTPOINTED = new VADState("NOT_STARTPOINTED", 0);
            STARTPOINTED = new VADState("STARTPOINTED", 1);
            ENDPOINTED = new VADState("ENDPOINTED", 2);
            $VALUES = (new VADState[] {
                NOT_STARTPOINTED, STARTPOINTED, ENDPOINTED
            });
        }

        private VADState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int VAD_FRAMES_PER_SEC = 100;
    private int mConsecutiveNonSpeechFrames;
    private int mConsecutiveSpeechFrames;
    private final int mEndpointingThreshold;
    private final int mSampleRate;
    private final ShortBuffer mSamplesBuffer;
    private final int mStartpointingThreshold;
    private ByteBuffer mVAD;
    private VADState mVADState;

    protected VoiceActivityDetector(int i, VADConfig vadconfig)
    {
        mSampleRate = i;
        mStartpointingThreshold = vadconfig.getStartpointingThreshold();
        mEndpointingThreshold = vadconfig.getEndpointingThreshold();
        mConsecutiveSpeechFrames = 0;
        mConsecutiveNonSpeechFrames = 0;
        mVAD = setupVAD(vadconfig);
        mVADState = VADState.NOT_STARTPOINTED;
        mSamplesBuffer = ShortBuffer.wrap(new short[mSampleRate / 100]);
    }

    private void updateVADState()
    {
        if (mVADState == VADState.NOT_STARTPOINTED && mConsecutiveSpeechFrames >= mStartpointingThreshold)
        {
            mVADState = VADState.STARTPOINTED;
        } else
        if (mVADState == VADState.STARTPOINTED && mConsecutiveNonSpeechFrames >= mEndpointingThreshold)
        {
            mVADState = VADState.ENDPOINTED;
            return;
        }
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        if (mVAD != null)
        {
            destroyVAD(mVAD);
            mVAD = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected native ByteBuffer createVAD(boolean flag);

    protected native int destroyVAD(ByteBuffer bytebuffer);

    protected native int isSpeech(ByteBuffer bytebuffer, short aword0[], int i);

    public final VADState processSamples(short aword0[], int i)
        throws VADException
    {
        this;
        JVM INSTR monitorenter ;
        if (mVAD == null)
        {
            throw new VADException("VAD is not initialized");
        }
        break MISSING_BLOCK_LABEL_24;
        aword0;
        this;
        JVM INSTR monitorexit ;
        throw aword0;
        int j = 0;
_L2:
        int k;
        if (mSamplesBuffer.remaining() > i - j)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        k = mSamplesBuffer.remaining();
        mSamplesBuffer.put(aword0, j, k);
        j += k;
        k = isSpeech(mVAD, mSamplesBuffer.array(), mSampleRate);
        mSamplesBuffer.clear();
        if (k != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        mConsecutiveSpeechFrames = mConsecutiveSpeechFrames + 1;
        mConsecutiveNonSpeechFrames = 0;
_L3:
        updateVADState();
        if (true) goto _L2; else goto _L1
_L1:
        if (k != 0)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        mConsecutiveNonSpeechFrames = mConsecutiveNonSpeechFrames + 1;
        mConsecutiveSpeechFrames = 0;
          goto _L3
        throw new VADException("Error processing speech frames");
        mSamplesBuffer.put(aword0, j, i - j);
        aword0 = mVADState;
        this;
        JVM INSTR monitorexit ;
        return aword0;
    }

    protected native int setDNNThreshold(ByteBuffer bytebuffer, float f);

    protected native int setWebRtcCustomizedMode(ByteBuffer bytebuffer, int i, int j, int k, int l);

    protected native int setWebRtcMode(ByteBuffer bytebuffer, int i);

    protected abstract ByteBuffer setupVAD(VADConfig vadconfig);

    static 
    {
        System.loadLibrary("blueshift-audioprocessing");
    }
}
