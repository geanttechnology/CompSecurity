// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk;


// Referenced classes of package com.amazon.avod.sdk:
//            PlaybackSupportResponse

public static class <init>
{
    public static class Factory
    {

        public static PlaybackSupportResponse.PlaybackSupport newPlaybackSupport(boolean flag, boolean flag1)
        {
            return new PlaybackSupportResponse.PlaybackSupport(flag, flag1, null);
        }

        public Factory()
        {
        }
    }


    public static final mIsPlaybackSustainable FULL_SUPPORT = new <init>(true, true);
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


    private Factory(boolean flag, boolean flag1)
    {
        mIsPlaybackSupported = flag;
        mIsPlaybackSustainable = flag1;
    }

    mIsPlaybackSustainable(boolean flag, boolean flag1, mIsPlaybackSustainable misplaybacksustainable)
    {
        this(flag, flag1);
    }
}
