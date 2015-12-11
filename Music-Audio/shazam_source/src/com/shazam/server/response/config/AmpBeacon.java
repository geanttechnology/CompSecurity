// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class AmpBeacon
    implements Serializable
{

    private String beaconHref;
    private Map params;

    private AmpBeacon()
    {
    }

    private AmpBeacon(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        beaconHref = Builder.access._mth000(builder);
        params = Builder.access._mth100(builder);
    }

    AmpBeacon(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getBeaconHref()
    {
        return beaconHref;
    }

    public Map getParams()
    {
        if (params != null)
        {
            return params;
        } else
        {
            return Collections.emptyMap();
        }
    }
}
