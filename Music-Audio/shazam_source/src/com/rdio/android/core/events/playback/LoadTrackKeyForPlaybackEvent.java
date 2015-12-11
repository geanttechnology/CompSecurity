// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


public class LoadTrackKeyForPlaybackEvent
{

    private final int indexInParent;
    private final String parentKey;
    private final boolean startPlaying;
    private final String trackKey;

    public LoadTrackKeyForPlaybackEvent(String s, String s1, int i, boolean flag)
    {
        trackKey = s;
        parentKey = s1;
        indexInParent = i;
        startPlaying = flag;
    }

    public int getIndexInParent()
    {
        return indexInParent;
    }

    public String getParentKey()
    {
        return parentKey;
    }

    public String getTrackKey()
    {
        return trackKey;
    }

    public boolean shouldStartPlaying()
    {
        return startPlaying;
    }
}
