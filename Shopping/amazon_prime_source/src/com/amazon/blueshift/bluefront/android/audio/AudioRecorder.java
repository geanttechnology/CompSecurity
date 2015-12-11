// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.SystemClock;
import android.util.Log;
import com.amazon.blueshift.bluefront.android.SpeechClientException;
import com.amazon.blueshift.bluefront.android.audio.opus.OpusEncoder;
import com.amazon.blueshift.bluefront.android.vad.DnnVAD;
import com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector;
import com.amazon.blueshift.bluefront.android.vad.WebRtcVAD;
import com.amazon.blueshift.bluefront.android.vad.config.DnnVADConfig;
import com.amazon.blueshift.bluefront.android.vad.config.WebRtcVADConfig;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioSource, AudioEncoder, AudioSourceListener, L16PcmEncoder, 
//            AudioTimeouts, AudioEncoderException, BufferedAudioEncoder

public class AudioRecorder extends AudioSource
{
    public static class Builder
    {

        private AudioEncoder mAudioEncoder;
        private AudioTimeouts mAudioTimeouts;
        private final Context mContext;
        private DnnVADConfig mDnnVADConfig;
        private WebRtcVADConfig mWebRtcVADConfig;

        public Builder audioEncoder(AudioEncoder audioencoder)
        {
            Preconditions.checkNotNull(audioencoder, "AudioEncoder cannot be null.");
            if (audioencoder instanceof BufferedAudioEncoder)
            {
                mAudioEncoder = audioencoder;
                return this;
            } else
            {
                mAudioEncoder = new BufferedAudioEncoder(audioencoder);
                return this;
            }
        }

        public Builder audioTimeouts(AudioTimeouts audiotimeouts)
        {
            Preconditions.checkNotNull(audiotimeouts, "AudioTimeouts cannot ne null.");
            mAudioTimeouts = audiotimeouts;
            return this;
        }

        public AudioRecorder build()
        {
            if (mWebRtcVADConfig != null)
            {
                WebRtcVAD webrtcvad = new WebRtcVAD(16000, mWebRtcVADConfig);
                return new AudioRecorder(mContext, mAudioEncoder, webrtcvad, mAudioTimeouts);
            } else
            {
                DnnVAD dnnvad = new DnnVAD(16000, mDnnVADConfig);
                return new AudioRecorder(mContext, mAudioEncoder, dnnvad, mAudioTimeouts);
            }
        }

        public Builder dnnVADConfig(DnnVADConfig dnnvadconfig)
        {
            Preconditions.checkNotNull(dnnvadconfig, "DnnVadConfig cannot be null.");
            mDnnVADConfig = dnnvadconfig;
            return this;
        }

        public Builder webRtcVADConfig(WebRtcVADConfig webrtcvadconfig)
        {
            Preconditions.checkNotNull(webrtcvadconfig, "WebRtcVADConfig cannot be null.");
            mWebRtcVADConfig = webrtcvadconfig;
            return this;
        }

        public Builder(Context context)
            throws AudioEncoderException
        {
            mDnnVADConfig = new DnnVADConfig();
            mAudioTimeouts = new AudioTimeouts();
            Preconditions.checkNotNull(context, "Context cannot be null.");
            mContext = context;
            mAudioEncoder = new BufferedAudioEncoder(new OpusEncoder());
        }
    }

    private class RecordPositionChangeListener
        implements android.media.AudioRecord.OnRecordPositionUpdateListener
    {

        private static final double DEFAULT_WEIGHT = -3.1000000000000001D;
        private double max;
        private double min;
        final AudioRecorder this$0;

        public void onMarkerReached(AudioRecord audiorecord)
        {
        }

        public void onPeriodicNotification(AudioRecord audiorecord)
        {
            if (mSamplesCountInRecPosNotificationPeriod <= 0)
            {
                return;
            }
            double d = Math.log10(Math.sqrt(mSumOfSampleSquaresInRecPosNotificationPeriod / (double)mSamplesCountInRecPosNotificationPeriod) / 32767D);
            mSumOfSampleSquaresInRecPosNotificationPeriod = 0.0D;
            mSamplesCountInRecPosNotificationPeriod = 0;
            if (d < min && d > -200000D)
            {
                min = d;
            }
            if (d > max)
            {
                max = d;
            }
            d = (d + 3.2000000000000002D) / 2D;
            getAudioSourceListener().onRmsChanged((float)d);
        }

        private RecordPositionChangeListener()
        {
            this$0 = AudioRecorder.this;
            super();
            min = -3.1000000000000001D;
            max = -3.1000000000000001D;
        }

    }


    private static final String ANDROID_PERMISSION_RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    protected static final int CHANNELS = 16;
    protected static final int FORMAT = 2;
    private static final int RECORDER_POSITION_NOTIFICATION_PERIOD = 100;
    protected static final int SAMPLE_RATE = 16000;
    protected static final int SAMPLE_SIZE = 16;
    private static final String TAG = com/amazon/blueshift/bluefront/android/audio/AudioRecorder.getCanonicalName();
    private final AudioEncoder mAudioEncoder;
    private final AudioTimeouts mAudioTimeouts;
    private final Context mContext;
    private final int mNumSamplesPerRead;
    private long mRecordStartTime;
    private AudioRecord mRecorder;
    private int mSamplesCountInRecPosNotificationPeriod;
    private double mSumOfSampleSquaresInRecPosNotificationPeriod;
    private final VoiceActivityDetector mVAD;

    private AudioRecorder(Context context, AudioEncoder audioencoder, VoiceActivityDetector voiceactivitydetector, AudioTimeouts audiotimeouts)
    {
        this(context, audioencoder, voiceactivitydetector, audiotimeouts, AudioRecord.getMinBufferSize(16000, 16, 2));
    }

    AudioRecorder(Context context, AudioEncoder audioencoder, VoiceActivityDetector voiceactivitydetector, AudioTimeouts audiotimeouts, int i)
    {
        super(audioencoder.getMediaType());
        Preconditions.checkNotNull(context, "Context cannot be null");
        Preconditions.checkNotNull(audioencoder, "AudioEncoder cannot be null");
        Preconditions.checkNotNull(voiceactivitydetector, "VAD cannot be null");
        Preconditions.checkNotNull(audiotimeouts, "Audio timeouts cannot be null");
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Num samples per read must be greater than 0");
        if (context.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == -1)
        {
            throw new SecurityException("Insufficient permissions to start ASR.");
        } else
        {
            mContext = context;
            mAudioEncoder = audioencoder;
            mVAD = voiceactivitydetector;
            mAudioTimeouts = audiotimeouts;
            mNumSamplesPerRead = i;
            mRecorder = new AudioRecord(6, 16000, 16, 2, mNumSamplesPerRead);
            mRecorder.setPositionNotificationPeriod(100);
            mRecorder.setRecordPositionUpdateListener(new RecordPositionChangeListener());
            return;
        }
    }


    private void destroyAudioRecorder()
    {
        Log.v(TAG, "Tear down speech detection.");
        mVAD.close();
        Log.v(TAG, "Clean up audio encoder");
        mAudioEncoder.close();
        Log.v(TAG, "Destroying recorder.");
        if (mRecorder != null)
        {
            mRecorder.release();
            mRecorder = null;
            ((AudioManager)mContext.getSystemService("audio")).abandonAudioFocus(null);
            return;
        } else
        {
            Log.w(TAG, "Recorder is null.");
            return;
        }
    }

    private void startAudioRecorder()
        throws SpeechClientException
    {
        mRecordStartTime = SystemClock.elapsedRealtime();
        if (mRecorder.getState() != 1)
        {
            Log.e(TAG, "Failed to initiate recorder.");
            throw new SpeechClientException("Failed to initiate recorder.");
        }
        try
        {
            ((AudioManager)mContext.getSystemService("audio")).requestAudioFocus(null, 3, 2);
            mRecorder.startRecording();
            getAudioSourceListener().onReadyForSpeech();
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log.e(TAG, "Exception starting recording", illegalstateexception);
            destroyAudioRecorder();
            throw new SpeechClientException("Exception starting recording", illegalstateexception);
        }
    }

    public int getChunkSize()
    {
        return mAudioEncoder.getPacketSize();
    }

    protected void writeBody(OutputStream outputstream)
        throws Exception
    {
        Object obj;
        L16PcmEncoder l16pcmencoder;
        short aword0[];
        AudioSourceListener audiosourcelistener;
        boolean flag;
        boolean flag1;
        long l;
        startAudioRecorder();
        aword0 = new short[mNumSamplesPerRead];
        obj = com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector.VADState.NOT_STARTPOINTED;
        flag = false;
        flag1 = false;
        audiosourcelistener = getAudioSourceListener();
        l = mRecordStartTime;
        l16pcmencoder = new L16PcmEncoder();
        Log.v(TAG, "Starting record loop");
_L11:
        if (isCancelled() || obj == com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector.VADState.ENDPOINTED) goto _L2; else goto _L1
_L1:
        if (mRecorder == null)
        {
            Log.e(TAG, "Recorder is null.");
            throw new SpeechClientException("Recorder null");
        }
          goto _L3
        outputstream;
        l16pcmencoder.close();
        Log.v(TAG, "Releasing recorder");
        destroyAudioRecorder();
        Log.v(TAG, "Released recorder");
        throw outputstream;
_L3:
        int j = mRecorder.read(aword0, 0, mNumSamplesPerRead);
        Object obj1;
        if (-3 == j)
        {
            break MISSING_BLOCK_LABEL_533;
        }
        obj1 = obj;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        obj1 = mAudioEncoder.encode(aword0, j);
        outputstream.write(((byte []) (obj1)), 0, obj1.length);
        outputstream.flush();
        int i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        mSumOfSampleSquaresInRecPosNotificationPeriod = mSumOfSampleSquaresInRecPosNotificationPeriod + (double)(aword0[i] * aword0[i]);
        i++;
        if (true) goto _L5; else goto _L4
        outputstream;
        throw new SpeechClientException("Error writing to audio upload output stream", outputstream);
_L4:
        mSamplesCountInRecPosNotificationPeriod = mSamplesCountInRecPosNotificationPeriod + j;
        audiosourcelistener.onBufferReceived(l16pcmencoder.encode(aword0, j));
        obj1 = mVAD.processSamples(aword0, j);
        long l1 = SystemClock.elapsedRealtime() - l;
        if (obj != com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector.VADState.NOT_STARTPOINTED) goto _L7; else goto _L6
_L6:
        if (obj1 != com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector.VADState.STARTPOINTED) goto _L9; else goto _L8
_L8:
        Log.v(TAG, "Speech detected");
        audiosourcelistener.onBeginningOfSpeech();
        j = ((flag) ? 1 : 0);
        i = ((flag1) ? 1 : 0);
_L13:
        flag1 = i;
        flag = j;
        if (obj == obj1) goto _L11; else goto _L10
_L10:
        l = SystemClock.elapsedRealtime();
        obj = obj1;
        flag1 = i;
        flag = j;
          goto _L11
_L9:
        i = ((flag1) ? 1 : 0);
        j = ((flag) ? 1 : 0);
        if (flag) goto _L13; else goto _L12
_L12:
        i = ((flag1) ? 1 : 0);
        j = ((flag) ? 1 : 0);
        if (l1 < (long)mAudioTimeouts.getNoSpeechTimeout()) goto _L13; else goto _L14
_L14:
        Log.i(TAG, "No speech timeout fired");
        j = 1;
        audiosourcelistener.onNoSpeechTimeout();
        i = ((flag1) ? 1 : 0);
          goto _L13
_L7:
        if (obj != com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector.VADState.STARTPOINTED)
        {
            break MISSING_BLOCK_LABEL_522;
        }
        if (obj1 != com.amazon.blueshift.bluefront.android.vad.VoiceActivityDetector.VADState.ENDPOINTED)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        Log.v(TAG, "Silence detected");
        audiosourcelistener.onSilenceDetected();
        i = ((flag1) ? 1 : 0);
        j = ((flag) ? 1 : 0);
          goto _L13
        i = ((flag1) ? 1 : 0);
        j = ((flag) ? 1 : 0);
        if (flag1) goto _L13; else goto _L15
_L15:
        i = ((flag1) ? 1 : 0);
        j = ((flag) ? 1 : 0);
        if (l1 < (long)mAudioTimeouts.getMaxSpeechTimeout()) goto _L13; else goto _L16
_L16:
        Log.i(TAG, "Max speech timeout fired");
        i = 1;
        audiosourcelistener.onMaxSpeechTimeout();
        j = ((flag) ? 1 : 0);
          goto _L13
        throw new SpeechClientException("Invalid VAD state transition while processing audio");
        Log.v(TAG, "AudioRecord - Invalid Operation");
        throw new SpeechClientException("AudioRecord - Invalid Operation");
_L2:
        Log.v(TAG, "Finished record loop");
        l16pcmencoder.close();
        Log.v(TAG, "Releasing recorder");
        destroyAudioRecorder();
        Log.v(TAG, "Released recorder");
        return;
          goto _L11
    }




/*
    static int access$102(AudioRecorder audiorecorder, int i)
    {
        audiorecorder.mSamplesCountInRecPosNotificationPeriod = i;
        return i;
    }

*/



/*
    static double access$202(AudioRecorder audiorecorder, double d)
    {
        audiorecorder.mSumOfSampleSquaresInRecPosNotificationPeriod = d;
        return d;
    }

*/
}
