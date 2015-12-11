// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class Provider
    implements Serializable
{

    private String id;
    private String name;
    private Map parameters;
    private String providerKey;
    private Map sites;

    private Provider()
    {
    }

    private Provider(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        name = Builder.access._mth000(builder);
        id = Builder.access._mth100(builder);
        sites = Builder.access._mth200(builder);
        parameters = Builder.access._mth300(builder);
        providerKey = Builder.access._mth400(builder);
    }

    Provider(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Map getParameters()
    {
        if (parameters != null)
        {
            return parameters;
        } else
        {
            return Collections.emptyMap();
        }
    }

    public String getProviderKey()
    {
        return providerKey;
    }

    public Map getSites()
    {
        if (sites != null)
        {
            return sites;
        } else
        {
            return Collections.emptyMap();
        }
    }
}
