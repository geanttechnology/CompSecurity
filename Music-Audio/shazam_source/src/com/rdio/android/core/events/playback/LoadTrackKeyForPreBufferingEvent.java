// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


public class LoadTrackKeyForPreBufferingEvent
{

    private final int indexInParent;
    private final String parentKey;
    private final String trackKey;

    public LoadTrackKeyForPreBufferingEvent(String s, String s1, int i)
    {
        trackKey = s;
        parentKey = s1;
        indexInParent = i;
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
}
