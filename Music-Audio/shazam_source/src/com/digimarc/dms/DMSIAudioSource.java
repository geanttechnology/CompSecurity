// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


// Referenced classes of package com.digimarc.dms:
//            DMSIBaseSource

public abstract class DMSIAudioSource extends DMSIBaseSource
{

    private int bitsPerSample;
    private int numChannels;
    private int sampleRate;

    public DMSIAudioSource()
    {
        sampleRate = 16000;
        numChannels = 1;
        bitsPerSample = 16;
    }

    public int getBitsPerSample()
    {
        return bitsPerSample;
    }

    public int getNumChannels()
    {
        return numChannels;
    }

    public int getSampleRate()
    {
        return sampleRate;
    }

    public void setBitsPerSample(int i)
    {
        bitsPerSample = i;
    }

    public void setNumChannels(int i)
    {
        numChannels = i;
    }

    public void setSampleRate(int i)
    {
        sampleRate = i;
    }
}
