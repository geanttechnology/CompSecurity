// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;


public interface PlaybackSupportResponse
{
    public static class PlaybackSupport
    {

        public static final PlaybackSupport FULL_SUPPORT = new PlaybackSupport(true, true);
        private final boolean mIsPlaybackSupported;
        private final boolean mIsPlaybackSustainable;

        public boolean isPlaybackSupported()
        {
            return mIsPlaybackSupported;
        }

        public boolean isPlaybackSustainable()
        {
            return mIsPlaybackSustainable;
        }


        private PlaybackSupport(boolean flag, boolean flag1)
        {
            mIsPlaybackSupported = flag;
            mIsPlaybackSustainable = flag1;
        }

    }

    public static class PlaybackSupport.Factory
    {

        public static PlaybackSupport newPlaybackSupport(boolean flag, boolean flag1)
        {
            return new PlaybackSupport(flag, flag1);
        }

        public PlaybackSupport.Factory()
        {
        }
    }


    public abstract void onPlaybackSupport(PlaybackSupport playbacksupport);
}
