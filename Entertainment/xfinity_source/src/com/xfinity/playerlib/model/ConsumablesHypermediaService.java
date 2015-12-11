// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.task.HypermediaService;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ConsumablesHypermediaService extends HypermediaService
{

    public ConsumablesHypermediaService(MicrodataItem microdataitem)
    {
        super(microdataitem);
    }

    public URI getConsumablesUri(String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("programId", s);
        hashmap.put("maxDimension", s1);
        return fetchServiceUriPath("getProgramVideos", hashmap);
    }

    public URI getDibicMoviesUri()
    {
        return fetchServiceUriPath("getMoviePrograms");
    }

    public URI getDibicTvSeriesUri()
    {
        return fetchServiceUriPath("getTvSeriesPrograms");
    }

    public URI getTagsUri()
    {
        return fetchServiceUriPath("getTags");
    }
}
