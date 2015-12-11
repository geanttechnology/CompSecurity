// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class MoodstocksAmpSetting
    implements Serializable
{

    private String apiKey;
    private String bundle;
    private boolean enabled;
    private Long expiry;
    private String syncProxy;

    private MoodstocksAmpSetting()
    {
    }

    private MoodstocksAmpSetting(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        enabled = Builder.access._mth000(builder);
        apiKey = Builder.access._mth100(builder);
        bundle = Builder.access._mth200(builder);
        syncProxy = Builder.access._mth300(builder);
        expiry = Builder.access._mth400(builder);
    }

    MoodstocksAmpSetting(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public String getBundle()
    {
        return bundle;
    }

    public Long getExpiry()
    {
        return expiry;
    }

    public String getSyncProxy()
    {
        return syncProxy;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
