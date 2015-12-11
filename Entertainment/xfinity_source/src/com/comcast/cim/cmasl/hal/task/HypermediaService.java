// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.task;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.cmasl.hal.model.MicrodataUriTemplate;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.comcast.cim.microdata.model.MicrodataLinkValue;
import com.comcast.cim.microdata.model.MicrodataProperty;
import java.net.URI;
import java.util.Map;

public class HypermediaService
{

    MicrodataItem services;

    public HypermediaService(MicrodataItem microdataitem)
    {
        services = microdataitem;
    }

    protected URI fetchServiceUriPath(String s)
    {
        return services.get(s, false).asLink().resolve();
    }

    protected URI fetchServiceUriPath(String s, Map map)
    {
        return services.get(s, false).asLink().resolve(map);
    }

    protected MicrodataUriTemplate fetchServiceUriTemplate(String s)
    {
        return (new MicrodataPropertyResolver(services)).fetchLinkAsUriTemplate(s);
    }
}
