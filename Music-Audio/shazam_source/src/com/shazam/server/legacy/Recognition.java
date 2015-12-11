// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy;

import java.util.List;

public class Recognition
{

    private String eventId;
    private List matches;
    private String retryDelay;
    private List tracks;

    private Recognition()
    {
    }

    private Recognition(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        eventId = Builder.access._mth000(builder);
        tracks = Builder.access._mth100(builder);
        matches = Builder.access._mth200(builder);
        retryDelay = Builder.access._mth300(builder);
    }

    Recognition(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getEventId()
    {
        return eventId;
    }

    public List getMatches()
    {
        return matches;
    }

    public Long getRetryDelay()
    {
        if (retryDelay == null)
        {
            return null;
        } else
        {
            return Long.valueOf(Long.parseLong(retryDelay));
        }
    }

    public List getTracks()
    {
        return tracks;
    }
}
