// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


public class VideoAd
{

    private int adProgressPercent;
    private String clickTitle;
    private String clickableUrl;
    private long duration;
    private String id;
    private boolean isClickable;
    private long secondsRemaining;
    private long startTime;

    public VideoAd()
    {
        startTime = -1L;
        duration = -1L;
        isClickable = false;
        adProgressPercent = 0;
        secondsRemaining = 0L;
    }

    public boolean coversLocation(long l)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (startTime != -1L)
        {
            flag = flag1;
            if (duration != -1L)
            {
                flag = flag1;
                if (startTime <= l)
                {
                    flag = flag1;
                    if (l <= getEndTime())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public int getAdProgressPercent()
    {
        return adProgressPercent;
    }

    public String getClickTitle()
    {
        return clickTitle;
    }

    public String getClickUrl()
    {
        return clickableUrl;
    }

    public long getDuration()
    {
        return duration;
    }

    public long getEndTime()
    {
        long l1 = -1L;
        long l = l1;
        if (startTime != -1L)
        {
            l = l1;
            if (duration != -1L)
            {
                l = startTime + duration;
            }
        }
        return l;
    }

    public String getId()
    {
        return id;
    }

    public long getSecondsRemaining()
    {
        return secondsRemaining;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public boolean isClickable()
    {
        return isClickable;
    }

    public void setClickTitle(String s)
    {
        clickTitle = s;
    }

    public void setClickUrl(String s)
    {
        clickableUrl = s;
    }

    public void setDuration(long l)
    {
        duration = Math.abs(l);
        secondsRemaining = l;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setIsClickable(boolean flag)
    {
        isClickable = flag;
    }

    public void setStartTime(long l)
    {
        startTime = l;
    }

    public void updateProgress(long l)
    {
        if (coversLocation(l))
        {
            secondsRemaining = getEndTime() - l;
            adProgressPercent = 100 - (int)((secondsRemaining * 100L) / getDuration());
            return;
        } else
        {
            secondsRemaining = getDuration();
            adProgressPercent = 0;
            return;
        }
    }
}
