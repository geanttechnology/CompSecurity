// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.model.MicrodataUriTemplate;
import com.comcast.cim.cmasl.hal.task.HypermediaService;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.net.URI;

public class TveHypermediaService extends HypermediaService
{

    private MicrodataUriTemplate streamMetadataTemplate;

    public TveHypermediaService(MicrodataItem microdataitem)
    {
        super(microdataitem);
    }

    public URI getListingsUri()
    {
        return fetchServiceUriPath("listings");
    }

    public URI getPromotedContentUri()
    {
        return fetchServiceUriPath("promoted/livetv");
    }

    public URI getStreamMetadataUri(String s)
    {
        if (streamMetadataTemplate == null)
        {
            streamMetadataTemplate = fetchServiceUriTemplate("stream_metadata");
        }
        com.comcast.cim.cmasl.hal.model.MicrodataUriTemplate.Resolver resolver = streamMetadataTemplate.createResolver();
        resolver.set("cmsId", s);
        return URI.create(resolver.resolve());
    }

    public URI getStremsUri()
    {
        return fetchServiceUriPath("streams2");
    }
}
