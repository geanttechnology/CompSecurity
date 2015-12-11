// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class AmpNcmRange
    implements Serializable
{

    private final long start;
    private final long stop;
    private final String type;

    private AmpNcmRange(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        type = Builder.access._mth000(builder);
        start = Builder.access._mth100(builder);
        stop = Builder.access._mth200(builder);
    }

    AmpNcmRange(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public long getStart()
    {
        return start;
    }

    public long getStop()
    {
        return stop;
    }

    public String getType()
    {
        return type;
    }
}
