// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;


public class RecognitionEngineParams
{

    private final EmbeddedParams mEmbeddedParams;
    private final MicroHotwordParams mMicroHotwordParams;
    private final MusicDetectorParams mMusicDetectorParams;
    private final NetworkParams mNetworkParams;

    public RecognitionEngineParams(EmbeddedParams embeddedparams, NetworkParams networkparams, MusicDetectorParams musicdetectorparams, MicroHotwordParams microhotwordparams)
    {
        mEmbeddedParams = embeddedparams;
        mNetworkParams = networkparams;
        mMusicDetectorParams = musicdetectorparams;
        mMicroHotwordParams = microhotwordparams;
    }

    public EmbeddedParams getEmbeddedParams()
    {
        return mEmbeddedParams;
    }

    public MicroHotwordParams getMicroHotwordParams()
    {
        return mMicroHotwordParams;
    }

    public MusicDetectorParams getMusicDetectorParams()
    {
        return mMusicDetectorParams;
    }

    public NetworkParams getNetworkParams()
    {
        return mNetworkParams;
    }
}
