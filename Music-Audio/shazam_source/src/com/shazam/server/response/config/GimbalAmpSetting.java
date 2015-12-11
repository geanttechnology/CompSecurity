// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class GimbalAmpSetting
    implements Serializable
{

    private String apiKey;
    private boolean enabled;

    public GimbalAmpSetting()
    {
    }

    private GimbalAmpSetting(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        enabled = Builder.access._mth000(builder);
        apiKey = Builder.access._mth100(builder);
    }

    GimbalAmpSetting(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
