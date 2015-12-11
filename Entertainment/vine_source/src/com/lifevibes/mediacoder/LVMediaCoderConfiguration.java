// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;


public class LVMediaCoderConfiguration
{

    public int audioBitRate;
    public int audioChannelCount;
    public int audioSampleRate;
    public int videoBitRate;
    public int videoFrameRate;
    public int videoHeight;
    public int videoIFrameInterval;
    public int videoWidth;

    public LVMediaCoderConfiguration()
    {
        videoBitRate = 0xfa000;
        videoHeight = 480;
        videoWidth = 480;
        videoFrameRate = 30;
        videoIFrameInterval = 1;
        audioBitRate = 64000;
        audioChannelCount = 1;
        audioSampleRate = 44100;
    }
}
