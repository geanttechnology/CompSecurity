// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.ads;


public class AdPlayerPositionUpdateEvent
{

    private final int duration;
    private final int position;

    public AdPlayerPositionUpdateEvent(int i, int j)
    {
        position = i;
        duration = j;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getPosition()
    {
        return position;
    }
}
