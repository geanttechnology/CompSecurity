// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;


public class Match
{

    private Double frequency;
    private Double offset;
    private Double skew;
    private String trackId;

    private Match()
    {
    }

    private Match(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        frequency = Builder.access._mth000(builder);
        offset = Builder.access._mth100(builder);
        skew = Builder.access._mth200(builder);
        trackId = Builder.access._mth300(builder);
    }

    Match(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Double getFrequency()
    {
        return frequency;
    }

    public Double getOffset()
    {
        return offset;
    }

    public Double getSkew()
    {
        return skew;
    }

    public String getTrackId()
    {
        return trackId;
    }
}
