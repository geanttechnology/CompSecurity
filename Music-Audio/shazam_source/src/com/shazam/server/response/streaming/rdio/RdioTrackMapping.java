// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.rdio;


public class RdioTrackMapping
{

    public static final RdioTrackMapping EMPTY = new RdioTrackMapping(null);
    public final String trackKey;

    private RdioTrackMapping(String s)
    {
        trackKey = s;
    }

}
