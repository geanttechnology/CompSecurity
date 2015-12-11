// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.google.android.speech.SpeechSettings;
import com.google.android.speech.listeners.OnReadyForSpeechListener;
import com.google.android.speech.logger.SpeechLibLogger;
import com.google.android.speech.params.AudioInputParams;
import com.google.android.speech.utils.NetworkInformation;
import dax;
import dbg;
import dbh;
import eyc;
import f;
import java.util.List;

// Referenced classes of package com.google.android.speech.audio:
//            MicrophoneInputStreamFactory, AudioSource, VoiceAudioInputStreamFactory, AudioUtils, 
//            AudioInputStreamFactory, SpeakNowSoundPlayer

public class AudioController
{

    private static final boolean DBG = false;
    public static final boolean DEBUG_BLUETOOTH = false;
    private static final String PERMISSION_CAPTURE_AUDIO_HOTWORD = "android.permission.CAPTURE_AUDIO_HOTWORD";
    private static final String TAG = "AudioController";
    public static final int TEE_BUFFER_SIZE = 1000;
    public static final int TEE_KEEP_SIZE = 500;
    private final dbh mAudioRouter;
    private AudioSource mAudioSource;
    private final Context mContext;
    private boolean mListening;
    private final dbg mLogExtras;
    private final SpeechLibLogger mLogger;
    private List mNoiseSuppressors;
    private AudioInputStreamFactory mRawInputStreamFactory;
    private boolean mRequestAudioFocus;
    private final SpeechSettings mSettings;
    private final SpeakNowSoundPlayer mSoundManager;
    private final dax mSpeechLevelSource;

    public AudioController(Context context, SpeechSettings speechsettings, dax dax1, SpeakNowSoundPlayer speaknowsoundplayer, dbh dbh, SpeechLibLogger speechliblogger, dbg dbg1)
    {
        mRawInputStreamFactory = null;
        mContext = context;
        mSettings = speechsettings;
        mSoundManager = speaknowsoundplayer;
        mSpeechLevelSource = dax1;
        mAudioRouter = dbh;
        mLogger = speechliblogger;
        mLogExtras = dbg1;
    }

    private AudioSource createAudioSource(AudioInputStreamFactory audioinputstreamfactory, AudioInputParams audioinputparams)
    {
        int i = audioinputparams.getSamplingRate();
        int j = MicrophoneInputStreamFactory.getMicrophoneReadSize(audioinputparams.getSamplingRate());
        if (audioinputparams.shouldReportSoundLevels())
        {
            audioinputparams = mSpeechLevelSource;
        } else
        {
            audioinputparams = null;
        }
        return new AudioSource(i, j, 500, 1000, audioinputstreamfactory, audioinputparams);
    }

    private AudioInputStreamFactory createDefaultRawInputStreamFactoryLocked(AudioInputParams audioinputparams)
    {
        int i;
        boolean flag;
        boolean flag1;
        if (audioinputparams.usePreemptibleAudioSource() && isPreemptibleAudioSourceSupported())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = audioinputparams.getSamplingRate();
        flag1 = isNoiseSuppressionEnabled(audioinputparams);
        if (audioinputparams.isPlayBeepEnabled())
        {
            audioinputparams = mSoundManager;
        } else
        {
            audioinputparams = null;
        }
        return new VoiceAudioInputStreamFactory(new MicrophoneInputStreamFactory(i, flag1, audioinputparams, mAudioRouter, mLogger, flag), mSettings, mContext);
    }

    private AudioInputStreamFactory createFactoryForRecordedUri(final Uri recordedAudioUri)
    {
        return new _cls1();
    }

    private AudioInputStreamFactory getRawInputStreamFactoryLocked(AudioInputParams audioinputparams)
    {
        if (mRawInputStreamFactory != null)
        {
            return mRawInputStreamFactory;
        }
        if (audioinputparams.getRecordedAudioUri() != null)
        {
            return createFactoryForRecordedUri(audioinputparams.getRecordedAudioUri());
        } else
        {
            return createDefaultRawInputStreamFactoryLocked(audioinputparams);
        }
    }

    private boolean isNoiseSuppressionEnabled(AudioInputParams audioinputparams)
    {
        if (audioinputparams.isNoiseSuppressionEnabled())
        {
            if (mNoiseSuppressors == null)
            {
                mNoiseSuppressors = AudioUtils.getNoiseSuppressors(mSettings.getConfiguration().h);
            }
            if (mNoiseSuppressors.size() != 0)
            {
                return true;
            }
        }
        return false;
    }

    private boolean isPreemptibleAudioSourceSupported()
    {
        return mContext.getPackageManager().checkPermission("android.permission.CAPTURE_AUDIO_HOTWORD", mContext.getPackageName()) == 0;
    }

    public AudioInputStreamFactory createInputStreamFactory(AudioInputParams audioinputparams)
    {
        this;
        JVM INSTR monitorenter ;
        mAudioSource = createAudioSource(getRawInputStreamFactoryLocked(audioinputparams), audioinputparams);
        audioinputparams = mAudioSource;
        this;
        JVM INSTR monitorexit ;
        return audioinputparams;
        audioinputparams;
        throw audioinputparams;
    }

    public AudioInputStreamFactory rewindInputStreamFactory(long l)
    {
        this;
        JVM INSTR monitorenter ;
        AudioSource audiosource;
        f.b(mAudioSource);
        f.b(mListening);
        mAudioSource = new AudioSource(mAudioSource);
        mAudioSource.setStartTime(l);
        audiosource = mAudioSource;
        this;
        JVM INSTR monitorexit ;
        return audiosource;
        Exception exception;
        exception;
        throw exception;
    }

    public void setRawInputStreamFactory(AudioInputStreamFactory audioinputstreamfactory)
    {
        this;
        JVM INSTR monitorenter ;
        mRawInputStreamFactory = audioinputstreamfactory;
        this;
        JVM INSTR monitorexit ;
        return;
        audioinputstreamfactory;
        throw audioinputstreamfactory;
    }

    public void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        if (mAudioSource != null)
        {
            mAudioSource.shutdown();
            mAudioSource = null;
        }
        stopListening();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void startListening(boolean flag, OnReadyForSpeechListener onreadyforspeechlistener)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mListening)
        {
            mSpeechLevelSource.a(-1);
            mRequestAudioFocus = flag;
            dbh dbh = mAudioRouter;
            if (mAudioSource != null)
            {
                mAudioSource.start(onreadyforspeechlistener);
            }
            onreadyforspeechlistener = mLogger;
            dbh = mAudioRouter;
            onreadyforspeechlistener.logAudioPathEstablished(new com.google.android.speech.logger.SpeechLibLogger.LogData(0, mLogExtras.a.getConnectionId()));
            mListening = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        onreadyforspeechlistener;
        throw onreadyforspeechlistener;
    }

    public void stopListening()
    {
        this;
        JVM INSTR monitorenter ;
        if (mListening)
        {
            if (mAudioSource != null)
            {
                mAudioSource.stopListening();
            }
            dbh dbh = mAudioRouter;
            boolean flag = mRequestAudioFocus;
            mSpeechLevelSource.a(-1);
            mListening = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1
        implements AudioInputStreamFactory
    {

        private int mNumStreamsCreated;
        final AudioController this$0;
        final Uri val$recordedAudioUri;

        public InputStream createInputStream()
        {
            this;
            JVM INSTR monitorenter ;
            int i;
            i = mNumStreamsCreated;
            mNumStreamsCreated = i + 1;
            boolean flag;
            if (i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            f.b(flag);
            this;
            JVM INSTR monitorexit ;
            return new android.os.ParcelFileDescriptor.AutoCloseInputStream(mContext.getContentResolver().openFileDescriptor(recordedAudioUri, "r"));
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls1()
        {
            this$0 = AudioController.this;
            recordedAudioUri = uri;
            super();
            mNumStreamsCreated = 0;
        }
    }

}
