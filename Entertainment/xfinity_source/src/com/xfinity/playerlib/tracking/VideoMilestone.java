// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;

import com.xfinity.playerlib.model.consumable.VideoFacade;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class VideoMilestone extends Enum
    implements Comparable
{

    private static final VideoMilestone $VALUES[];
    public static final VideoMilestone COMPLETED;
    public static final VideoMilestone LIVE_STREAM_STARTED;
    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/tracking/VideoMilestone);
    public static final VideoMilestone NOT_STARTED;
    public static final VideoMilestone ONE_HALF;
    public static final VideoMilestone ONE_QUARTER;
    public static final VideoMilestone STARTED;
    public static final VideoMilestone THREE_QUARTERS;

    private VideoMilestone(String s, int i)
    {
        super(s, i);
    }


    public static VideoMilestone decodePercentage(float f)
    {
        if (f < 0.0F)
        {
            return NOT_STARTED;
        }
        if ((double)f < 0.25D)
        {
            return STARTED;
        }
        if ((double)f < 0.5D)
        {
            return ONE_QUARTER;
        }
        if ((double)f < 0.75D)
        {
            return ONE_HALF;
        }
        if ((double)f < 0.97999999999999998D)
        {
            return THREE_QUARTERS;
        }
        if (f > 1.0F)
        {
            LOG.warn("unexpected argument; percent > 1 percent={}", Float.valueOf(f));
        }
        return COMPLETED;
    }

    public static VideoMilestone decodePosition(int i, int j)
    {
        return decodePercentage((float)i / (float)j);
    }

    public static VideoMilestone decodePosition(int i, VideoFacade videofacade)
    {
        int j = videofacade.getDurationInSeconds() * 1000;
        LOG.debug("decodePosition() position={} durationMillis={}", Integer.valueOf(i), Integer.valueOf(j));
        return decodePosition(i, j);
    }

    public static VideoMilestone fromInt(int i)
    {
        VideoMilestone avideomilestone[] = values();
        int k = avideomilestone.length;
        for (int j = 0; j < k; j++)
        {
            VideoMilestone videomilestone = avideomilestone[j];
            if (videomilestone.ordinal() == i)
            {
                return videomilestone;
            }
        }

        return NOT_STARTED;
    }

    public static VideoMilestone valueOf(String s)
    {
        return (VideoMilestone)Enum.valueOf(com/xfinity/playerlib/tracking/VideoMilestone, s);
    }

    public static VideoMilestone[] values()
    {
        return (VideoMilestone[])$VALUES.clone();
    }

    public abstract String getEvent();

    public boolean greaterThan(VideoMilestone videomilestone)
    {
        return compareTo(videomilestone) > 0;
    }

    public List valuesBetween(VideoMilestone videomilestone)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = ordinal(); i <= videomilestone.ordinal(); i++)
        {
            VideoMilestone videomilestone1 = values()[i];
            if (videomilestone1.greaterThan(this))
            {
                arraylist.add(videomilestone1);
            }
        }

        return arraylist;
    }

    static 
    {
        NOT_STARTED = new VideoMilestone("NOT_STARTED", 0) {

            public String getEvent()
            {
                VideoMilestone.LOG.warn("getPositionInSeconds() unexpected invocation this={}", this);
                return null;
            }

        };
        STARTED = new VideoMilestone("STARTED", 1) {

            public String getEvent()
            {
                return "vodstart";
            }

        };
        ONE_QUARTER = new VideoMilestone("ONE_QUARTER", 2) {

            public String getEvent()
            {
                return "25percentWatched";
            }

        };
        ONE_HALF = new VideoMilestone("ONE_HALF", 3) {

            public String getEvent()
            {
                return "50percentWatched";
            }

        };
        THREE_QUARTERS = new VideoMilestone("THREE_QUARTERS", 4) {

            public String getEvent()
            {
                return "75percentWatched";
            }

        };
        COMPLETED = new VideoMilestone("COMPLETED", 5) {

            public String getEvent()
            {
                return "100percentWatched";
            }

        };
        LIVE_STREAM_STARTED = new VideoMilestone("LIVE_STREAM_STARTED", 6) {

            public String getEvent()
            {
                return "livestart";
            }

        };
        $VALUES = (new VideoMilestone[] {
            NOT_STARTED, STARTED, ONE_QUARTER, ONE_HALF, THREE_QUARTERS, COMPLETED, LIVE_STREAM_STARTED
        });
    }

}
