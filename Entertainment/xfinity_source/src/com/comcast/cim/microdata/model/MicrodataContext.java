// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.microdata.model;

import com.comcast.cim.microdata.client.HypermediaClient;
import com.comcast.cim.microdata.deserialization.MicrodataModelFactory;
import java.util.Map;

public class MicrodataContext
{

    private final String baseUrl;
    private final HypermediaClient hypermediaClient;
    private final Map itemMap;
    private final MicrodataModelFactory modelFactory;

    public MicrodataContext(HypermediaClient hypermediaclient, String s, MicrodataModelFactory microdatamodelfactory, Map map)
    {
        hypermediaClient = hypermediaclient;
        baseUrl = s;
        modelFactory = microdatamodelfactory;
        itemMap = map;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public HypermediaClient getHypermediaClient()
    {
        return hypermediaClient;
    }

    public Map getItemMap()
    {
        return itemMap;
    }

    public MicrodataModelFactory getModelFactory()
    {
        return modelFactory;
    }
}
