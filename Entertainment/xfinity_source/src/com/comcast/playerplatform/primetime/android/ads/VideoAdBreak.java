// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            VideoAd, AdRestriction

public class VideoAdBreak
{

    private long duration;
    private boolean hasBeenSeen;
    private String id;
    private boolean isPauseDisabled;
    private boolean isSeekDisabled;
    private long markerPosition;
    private int percentComplete;
    private List restrictions;
    private long secondsRemaining;
    private long startTime;
    private List videoAdsList;

    public VideoAdBreak()
    {
        secondsRemaining = 0L;
        duration = 0L;
        startTime = -1L;
        videoAdsList = new ArrayList();
        isSeekDisabled = true;
        isPauseDisabled = true;
        markerPosition = -1L;
    }

    public VideoAdBreak(VideoAd videoad)
    {
        secondsRemaining = 0L;
        duration = 0L;
        startTime = -1L;
        videoAdsList = new ArrayList();
        isSeekDisabled = true;
        isPauseDisabled = true;
        markerPosition = -1L;
        videoAdsList.add(videoad);
        duration = duration + videoad.getDuration();
        secondsRemaining = duration;
        startTime = videoad.getStartTime();
    }

    private void updateInternalValues(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            VideoAd videoad = (VideoAd)list.next();
            duration = duration + videoad.getDuration();
            if (videoad.getStartTime() < startTime)
            {
                startTime = videoad.getStartTime();
                markerPosition = startTime;
            }
        } while (true);
        secondsRemaining = duration;
    }

    public void addAd(VideoAd videoad)
    {
        videoAdsList.add(videoad);
        duration = duration + videoad.getDuration();
        secondsRemaining = duration;
        if (startTime == -1L || startTime > videoad.getStartTime())
        {
            startTime = videoad.getStartTime();
            markerPosition = startTime;
        }
    }

    public void addRestriction(AdRestriction adrestriction)
    {
        if (restrictions == null)
        {
            restrictions = new ArrayList();
        }
        restrictions.add(adrestriction);
        static class _cls1
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType = new int[AdRestriction.RestrictionType.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType[AdRestriction.RestrictionType.SEEK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$ads$AdRestriction$RestrictionType[AdRestriction.RestrictionType.PAUSE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.comcast.playerplatform.primetime.android.ads.AdRestriction.RestrictionType[adrestriction.getType().ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            isSeekDisabled = adrestriction.isRestricted();
            return;

        case 2: // '\002'
            isPauseDisabled = adrestriction.isRestricted();
            break;
        }
    }

    public boolean coversLocation(long l)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (startTime != -1L)
        {
            flag = flag1;
            if (duration > 0L)
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

    public VideoAd getAdAtLocation(long l)
    {
        for (Iterator iterator = videoAdsList.iterator(); iterator.hasNext();)
        {
            VideoAd videoad = (VideoAd)iterator.next();
            if (videoad.coversLocation(l))
            {
                return videoad;
            }
        }

        return null;
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
            if (duration > 0L)
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

    public long getMarkerPosition()
    {
        return markerPosition;
    }

    public int getPercentComplete()
    {
        return percentComplete;
    }

    public List getRestrictions()
    {
        return restrictions;
    }

    public long getSecondsRemaining()
    {
        return secondsRemaining;
    }

    public long getStartTime()
    {
        return startTime;
    }

    public List getVideoAdsList()
    {
        return videoAdsList;
    }

    public boolean hasBeenSeen()
    {
        return hasBeenSeen;
    }

    public boolean isPauseDisabled()
    {
        return isPauseDisabled;
    }

    public boolean isSeekDisabled()
    {
        return isSeekDisabled;
    }

    public void setDuration(long l)
    {
        secondsRemaining = l;
        duration = Math.abs(l);
    }

    public void setHasBeenSeen(boolean flag)
    {
        hasBeenSeen = flag;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setMarkerPosition(long l)
    {
        markerPosition = l;
    }

    public void setStartTime(long l)
    {
        startTime = l;
        markerPosition = l;
    }

    public void setVideoAdsList(List list)
    {
        duration = 0L;
        secondsRemaining = 0L;
        startTime = -1L;
        videoAdsList = list;
        if (list != null && list.size() > 0)
        {
            startTime = ((VideoAd)list.get(0)).getStartTime();
            markerPosition = startTime;
            updateInternalValues(list);
        }
    }

    public void updateProgress(long l)
    {
        if (coversLocation(l))
        {
            secondsRemaining = getEndTime() - l;
            percentComplete = 100 - (int)((secondsRemaining * 100L) / getDuration());
            return;
        } else
        {
            secondsRemaining = getDuration();
            percentComplete = 0;
            return;
        }
    }
}
