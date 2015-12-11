// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;

import com.shazam.server.legacy.track.Track;

public class RequestSmoid
{

    private Track track;

    private RequestSmoid()
    {
    }

    public RequestSmoid(Track track1)
    {
        track = track1;
    }

    public Track getTrack()
    {
        return track;
    }
}
