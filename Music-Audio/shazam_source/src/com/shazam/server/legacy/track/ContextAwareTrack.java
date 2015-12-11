// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;

import com.shazam.server.response.play.Streams;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ContextAwareTrack
{

    private List actions;
    private String id;
    private String image;
    private Map stores;
    private Streams streams;
    private String subtitle;
    private long timestamp;
    private String title;
    private String type;
    private Map urlParams;

    private ContextAwareTrack()
    {
    }

    private ContextAwareTrack(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        timestamp = Builder.access._mth000(builder);
        title = Builder.access._mth100(builder);
        subtitle = Builder.access._mth200(builder);
        image = Builder.access._mth300(builder);
        type = Builder.access._mth400(builder);
        id = Builder.access._mth500(builder);
        actions = Builder.access._mth600(builder);
        streams = Builder.access._mth700(builder);
        urlParams = Builder.access._mth800(builder);
        stores = Builder.access._mth900(builder);
    }

    ContextAwareTrack(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public List getActions()
    {
        if (actions == null)
        {
            return Collections.emptyList();
        } else
        {
            return actions;
        }
    }

    public String getId()
    {
        return id;
    }

    public String getImage()
    {
        return image;
    }

    public Map getStores()
    {
        return stores;
    }

    public Streams getStreams()
    {
        return streams;
    }

    public String getSubtitle()
    {
        return subtitle;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public String getTitle()
    {
        return title;
    }

    public String getType()
    {
        return type;
    }

    public Map getUrlParams()
    {
        return urlParams;
    }
}
