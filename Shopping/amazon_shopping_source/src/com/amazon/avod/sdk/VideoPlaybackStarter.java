// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;

import com.amazon.avod.sdk.internal.AivConnection;
import java.util.HashMap;
import java.util.Map;

public class VideoPlaybackStarter
{
    public static final class PlaybackProfile extends Enum
    {

        private static final PlaybackProfile $VALUES[];
        public static final PlaybackProfile FULL;
        public static final PlaybackProfile LIMITED;
        private final String mParameterValue;

        public static PlaybackProfile valueOf(String s)
        {
            return (PlaybackProfile)Enum.valueOf(com/amazon/avod/sdk/VideoPlaybackStarter$PlaybackProfile, s);
        }

        public static PlaybackProfile[] values()
        {
            return (PlaybackProfile[])$VALUES.clone();
        }

        public String getParameterValue()
        {
            return mParameterValue;
        }

        static 
        {
            FULL = new PlaybackProfile("FULL", 0, "full");
            LIMITED = new PlaybackProfile("LIMITED", 1, "limited");
            $VALUES = (new PlaybackProfile[] {
                FULL, LIMITED
            });
        }

        private PlaybackProfile(String s, int i, String s1)
        {
            super(s, i);
            mParameterValue = s1;
        }
    }


    private static final PlaybackProfile DEFAULT_PROFILE;
    private final String mAsin;
    private String mAudioLanguageCode;
    private String mClientSessionId;
    private final AivConnection mConnection;
    private PlaybackProfile mPlaybackProfile;
    private String mRefMarker;
    private long mTimecodeMillis;
    private final Constants.UrlType mUrlType;

    VideoPlaybackStarter(AivConnection aivconnection, String s, Constants.UrlType urltype)
    {
        mTimecodeMillis = -1L;
        mPlaybackProfile = DEFAULT_PROFILE;
        mRefMarker = null;
        mAudioLanguageCode = null;
        if (aivconnection == null)
        {
            throw new NullPointerException("Need a valid AIV connection.");
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("A valid asin must be provided in order to start playback.");
        }
        if (urltype == null)
        {
            throw new IllegalArgumentException("A valid urlType must be specified in order to start playback.");
        } else
        {
            mConnection = aivconnection;
            mAsin = s;
            mUrlType = urltype;
            return;
        }
    }

    private Map generatePlaybackParameters()
    {
        HashMap hashmap = new HashMap();
        if (mUrlType == Constants.UrlType.TRAILER)
        {
            hashmap.put("playTrailer", "T");
        }
        if (mTimecodeMillis != -1L)
        {
            hashmap.put("playbackTimecode", String.valueOf(mTimecodeMillis));
        }
        hashmap.put("playbackProfile", mPlaybackProfile.getParameterValue());
        if (mRefMarker != null)
        {
            hashmap.put("refMarker", mRefMarker);
        }
        if (mClientSessionId != null)
        {
            hashmap.put("clientSessionId", mClientSessionId);
        }
        if (mAudioLanguageCode != null)
        {
            hashmap.put("audioLanguage", mAudioLanguageCode);
        }
        return hashmap;
    }

    public void start()
    {
        Map map = generatePlaybackParameters();
        mConnection.playVideo(mAsin, map);
    }

    public VideoPlaybackStarter withRefMarker(String s)
    {
        mRefMarker = s;
        return this;
    }

    public VideoPlaybackStarter withResumeTimecode(long l)
    {
        long l1 = l;
        if (l < 0L)
        {
            l1 = -1L;
        }
        mTimecodeMillis = l1;
        return this;
    }

    static 
    {
        DEFAULT_PROFILE = PlaybackProfile.FULL;
    }
}
