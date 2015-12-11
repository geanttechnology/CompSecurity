// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.audio;

import android.content.Context;
import com.amazon.blueshift.bluefront.android.audio.opus.OpusEncoder;
import com.amazon.blueshift.bluefront.android.vad.DnnVAD;
import com.amazon.blueshift.bluefront.android.vad.WebRtcVAD;
import com.amazon.blueshift.bluefront.android.vad.config.DnnVADConfig;
import com.amazon.blueshift.bluefront.android.vad.config.WebRtcVADConfig;
import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.blueshift.bluefront.android.audio:
//            AudioRecorder, AudioEncoderException, AudioTimeouts, BufferedAudioEncoder, 
//            AudioEncoder

public static class >
{

    private AudioEncoder mAudioEncoder;
    private AudioTimeouts mAudioTimeouts;
    private final Context mContext;
    private DnnVADConfig mDnnVADConfig;
    private WebRtcVADConfig mWebRtcVADConfig;

    public > audioEncoder(AudioEncoder audioencoder)
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

    public init> audioTimeouts(AudioTimeouts audiotimeouts)
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
            return new AudioRecorder(mContext, mAudioEncoder, webrtcvad, mAudioTimeouts, null);
        } else
        {
            DnnVAD dnnvad = new DnnVAD(16000, mDnnVADConfig);
            return new AudioRecorder(mContext, mAudioEncoder, dnnvad, mAudioTimeouts, null);
        }
    }

    public mAudioTimeouts dnnVADConfig(DnnVADConfig dnnvadconfig)
    {
        Preconditions.checkNotNull(dnnvadconfig, "DnnVadConfig cannot be null.");
        mDnnVADConfig = dnnvadconfig;
        return this;
    }

    public mDnnVADConfig webRtcVADConfig(WebRtcVADConfig webrtcvadconfig)
    {
        Preconditions.checkNotNull(webrtcvadconfig, "WebRtcVADConfig cannot be null.");
        mWebRtcVADConfig = webrtcvadconfig;
        return this;
    }

    public (Context context)
        throws AudioEncoderException
    {
        mDnnVADConfig = new DnnVADConfig();
        mAudioTimeouts = new AudioTimeouts();
        Preconditions.checkNotNull(context, "Context cannot be null.");
        mContext = context;
        mAudioEncoder = new BufferedAudioEncoder(new OpusEncoder());
    }
}
