// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


public class PlaybackSequencePositionChangedEvent
{

    private int position;

    public PlaybackSequencePositionChangedEvent(int i)
    {
        position = i;
    }

    public int getPosition()
    {
        return position;
    }
}
