// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import com.amazon.blueshift.bluefront.android.http.Part;
import com.google.common.base.Preconditions;
import com.google.common.net.MediaType;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioSourceListener

public abstract class AudioSource extends Part
{
    private static class NullListener
        implements AudioSourceListener
    {

        public void onBeginningOfSpeech()
        {
        }

        public void onBufferReceived(byte abyte0[])
        {
        }

        public void onMaxSpeechTimeout()
        {
        }

        public void onNoSpeechTimeout()
        {
        }

        public void onReadyForSpeech()
        {
        }

        public void onRmsChanged(float f)
        {
        }

        public void onSilenceDetected()
        {
        }

        private NullListener()
        {
        }

    }


    private static final String PART_NAME = "audio";
    private final AtomicBoolean mIsCancelled = new AtomicBoolean(false);
    private AudioSourceListener mListener;

    AudioSource(MediaType mediatype)
    {
        super("audio", mediatype);
        mListener = new NullListener();
    }

    public void cancel()
    {
        mIsCancelled.set(true);
    }

    AudioSourceListener getAudioSourceListener()
    {
        return mListener;
    }

    public abstract int getChunkSize();

    boolean isCancelled()
    {
        return mIsCancelled.get();
    }

    public void setAudioSourceListener(AudioSourceListener audiosourcelistener)
    {
        Preconditions.checkNotNull(audiosourcelistener, "AudioSourceListener cannot be null");
        mListener = audiosourcelistener;
    }
}
