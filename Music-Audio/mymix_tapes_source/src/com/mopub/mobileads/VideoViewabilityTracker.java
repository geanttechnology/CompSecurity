// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            VastTracker

public class VideoViewabilityTracker extends VastTracker
{

    private final int mPercentViewable;
    private final int mViewablePlaytimeMS;

    public VideoViewabilityTracker(int i, int j, String s)
    {
        super(s);
        mViewablePlaytimeMS = i;
        mPercentViewable = j;
    }

    public int getPercentViewable()
    {
        return mPercentViewable;
    }

    public int getViewablePlaytimeMS()
    {
        return mViewablePlaytimeMS;
    }
}
