// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.mediacore.qos.PlaybackInformation;
import java.util.Hashtable;
import java.util.Map;

public class PlayerMetrics
{

    private static float currentAspectRatio = 0.0F;
    private static long drmLatencyEnd = 0L;
    private static boolean islatencyComplete = false;
    private static long latencyStart = 0L;
    private static PlaybackInformation playbackInformation;
    private static long playbackLatencyEnd = 0L;

    public PlayerMetrics()
    {
    }

    public static long getBitrate()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getBitrate();
        } else
        {
            return -1L;
        }
    }

    public static long getBufferLength()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getBufferLength();
        } else
        {
            return -1L;
        }
    }

    public static long getBufferTime()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getBufferTime();
        } else
        {
            return -1L;
        }
    }

    public static long getBufferingTime()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getBufferingTime();
        } else
        {
            return -1L;
        }
    }

    public static float getCurrentAspectRatio()
    {
        return currentAspectRatio;
    }

    public static long getDrmLatency()
    {
        long l = drmLatencyEnd - latencyStart;
        if (l > 0L)
        {
            return l;
        } else
        {
            return -1L;
        }
    }

    static Map getDrmLatencyDictionary()
    {
        long l = drmLatencyEnd - latencyStart;
        Hashtable hashtable;
        if (l <= 0L)
        {
            l = -1L;
        }
        hashtable = new Hashtable();
        hashtable.put("drmLatency", String.valueOf(l));
        return hashtable;
    }

    public static long getDroppedFrames()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getDroppedFrameCount();
        } else
        {
            return -1L;
        }
    }

    public static long getEmptyBufferCount()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getEmptyBufferCount();
        } else
        {
            return -1L;
        }
    }

    public static float getFrameRate()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getFrameRate();
        } else
        {
            return -1F;
        }
    }

    public static long getLoadingLatency()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getTimeToLoad();
        } else
        {
            return -1L;
        }
    }

    public static long getOpeningLatency()
    {
        long l = playbackLatencyEnd - latencyStart;
        if (l > 0L)
        {
            return l;
        } else
        {
            return -1L;
        }
    }

    public static long getStartLatency()
    {
        if (playbackInformation != null)
        {
            return playbackInformation.getTimeToStart();
        } else
        {
            return -1L;
        }
    }

    void clearLatencyValues()
    {
        latencyStart = 0L;
        playbackLatencyEnd = 0L;
        drmLatencyEnd = 0L;
        islatencyComplete = false;
    }

    PlaybackInformation getPlaybackInformaiton()
    {
        return playbackInformation;
    }

    boolean isIslatencyComplete()
    {
        return islatencyComplete;
    }

    void setCurrentAspectRatio(float f)
    {
        currentAspectRatio = f;
    }

    void setDrmLatencyEnd(long l)
    {
        drmLatencyEnd = l;
    }

    void setIslatencyComplete(boolean flag)
    {
        islatencyComplete = flag;
    }

    void setLatencyStart(long l)
    {
        latencyStart = l;
    }

    void setPlaybackInformation(PlaybackInformation playbackinformation)
    {
        playbackInformation = playbackinformation;
    }

    void setPlaybackLatencyEnd(long l)
    {
        playbackLatencyEnd = l;
    }

}
