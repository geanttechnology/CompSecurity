// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


public class PlayerAdBreakPolicies
{
    public static final class AdBreakPolicy extends Enum
    {

        private static final AdBreakPolicy $VALUES[];
        public static final AdBreakPolicy KEEP;
        public static final AdBreakPolicy REMOVE;
        public static final AdBreakPolicy REMOVE_BEFORE_PLAYBACK;

        public static AdBreakPolicy valueOf(String s)
        {
            return (AdBreakPolicy)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy, s);
        }

        public static AdBreakPolicy[] values()
        {
            return (AdBreakPolicy[])$VALUES.clone();
        }

        static 
        {
            KEEP = new AdBreakPolicy("KEEP", 0);
            REMOVE = new AdBreakPolicy("REMOVE", 1);
            REMOVE_BEFORE_PLAYBACK = new AdBreakPolicy("REMOVE_BEFORE_PLAYBACK", 2);
            $VALUES = (new AdBreakPolicy[] {
                KEEP, REMOVE, REMOVE_BEFORE_PLAYBACK
            });
        }

        private AdBreakPolicy(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AdBreakSeekIntoPolicy extends Enum
    {

        private static final AdBreakSeekIntoPolicy $VALUES[];
        public static final AdBreakSeekIntoPolicy PLAY;
        public static final AdBreakSeekIntoPolicy PLAY_FROM_BEGINNING;

        public static AdBreakSeekIntoPolicy valueOf(String s)
        {
            return (AdBreakSeekIntoPolicy)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy, s);
        }

        public static AdBreakSeekIntoPolicy[] values()
        {
            return (AdBreakSeekIntoPolicy[])$VALUES.clone();
        }

        static 
        {
            PLAY = new AdBreakSeekIntoPolicy("PLAY", 0);
            PLAY_FROM_BEGINNING = new AdBreakSeekIntoPolicy("PLAY_FROM_BEGINNING", 1);
            $VALUES = (new AdBreakSeekIntoPolicy[] {
                PLAY, PLAY_FROM_BEGINNING
            });
        }

        private AdBreakSeekIntoPolicy(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class AdBreakWatchedPolicy extends Enum
    {

        private static final AdBreakWatchedPolicy $VALUES[];
        public static final AdBreakWatchedPolicy DO_NOT_MARK;
        public static final AdBreakWatchedPolicy MARK_AS_WATCHED;

        public static AdBreakWatchedPolicy valueOf(String s)
        {
            return (AdBreakWatchedPolicy)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakWatchedPolicy, s);
        }

        public static AdBreakWatchedPolicy[] values()
        {
            return (AdBreakWatchedPolicy[])$VALUES.clone();
        }

        static 
        {
            MARK_AS_WATCHED = new AdBreakWatchedPolicy("MARK_AS_WATCHED", 0);
            DO_NOT_MARK = new AdBreakWatchedPolicy("DO_NOT_MARK", 1);
            $VALUES = (new AdBreakWatchedPolicy[] {
                MARK_AS_WATCHED, DO_NOT_MARK
            });
        }

        private AdBreakWatchedPolicy(String s, int i)
        {
            super(s, i);
        }
    }


    private AdBreakWatchedPolicy adBreakWatchedPolicy;
    private AdBreakPolicy midRollPolicy;
    private AdBreakPolicy postRollPolicy;
    private AdBreakPolicy preRollPolicy;

    public PlayerAdBreakPolicies()
    {
        midRollPolicy = AdBreakPolicy.KEEP;
        postRollPolicy = AdBreakPolicy.KEEP;
        preRollPolicy = AdBreakPolicy.KEEP;
        adBreakWatchedPolicy = AdBreakWatchedPolicy.DO_NOT_MARK;
    }

    public AdBreakWatchedPolicy getAdBreakWatchedPolicy()
    {
        return adBreakWatchedPolicy;
    }

    public AdBreakPolicy getMidRollPolicy()
    {
        return midRollPolicy;
    }

    public AdBreakPolicy getPostRollPolicy()
    {
        return postRollPolicy;
    }

    public AdBreakPolicy getPreRollPolicy()
    {
        return preRollPolicy;
    }

    public PlayerAdBreakPolicies setMidRollPolicy(AdBreakPolicy adbreakpolicy)
    {
        midRollPolicy = adbreakpolicy;
        return this;
    }

    public PlayerAdBreakPolicies setPostRollPolicy(AdBreakPolicy adbreakpolicy)
    {
        postRollPolicy = adbreakpolicy;
        return this;
    }

    public PlayerAdBreakPolicies setPreRollPolicy(AdBreakPolicy adbreakpolicy)
    {
        preRollPolicy = adbreakpolicy;
        return this;
    }
}
