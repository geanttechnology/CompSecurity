// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.explore;

import java.util.Map;

public class TopTracks
{

    public final Map topTracksMap;
    public final long version;

    private TopTracks(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        topTracksMap = Builder.access._mth100(builder);
        version = Builder.access._mth200(builder);
    }

    TopTracks(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
