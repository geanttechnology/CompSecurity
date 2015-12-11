// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;


public class PlayTrackKeyEvent
{

    public final boolean isManualPlay;
    public final String parentKey;
    public final int timeOffset;
    public final String trackKey;

    public PlayTrackKeyEvent(String s, String s1, boolean flag, int i)
    {
        trackKey = s;
        parentKey = s1;
        isManualPlay = flag;
        timeOffset = i;
    }
}
