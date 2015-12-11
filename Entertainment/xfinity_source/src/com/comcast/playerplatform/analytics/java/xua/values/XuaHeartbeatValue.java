// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaHeartbeatValue extends AbstractXuaValue
{

    private Long bitRate;
    private String closedCaptionTrack;
    private Long currentPosition;
    private Integer framesPerSecond;
    private String secondaryAudioTrack;

    public XuaHeartbeatValue()
    {
    }

    public Long getBitRate()
    {
        return bitRate;
    }

    public String getClosedCaptionTrack()
    {
        return closedCaptionTrack;
    }

    public Long getCurrentPosition()
    {
        return currentPosition;
    }

    public Integer getFramesPerSecond()
    {
        return framesPerSecond;
    }

    public String getSecondaryAudioTrack()
    {
        return secondaryAudioTrack;
    }

    public void setBitRate(Long long1)
    {
        bitRate = long1;
    }

    public void setClosedCaptionTrack(String s)
    {
        closedCaptionTrack = s;
    }

    public void setCurrentPosition(Long long1)
    {
        currentPosition = long1;
    }

    public void setFramesPerSecond(Integer integer)
    {
        framesPerSecond = integer;
    }

    public void setSecondaryAudioTrack(String s)
    {
        secondaryAudioTrack = s;
    }
}
