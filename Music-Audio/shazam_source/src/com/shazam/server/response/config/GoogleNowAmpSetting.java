// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class GoogleNowAmpSetting
    implements Serializable
{

    private boolean enabled;
    private String icon;

    private GoogleNowAmpSetting()
    {
    }

    protected GoogleNowAmpSetting(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        enabled = Builder.access._mth000(builder);
        icon = Builder.access._mth100(builder);
    }

    public String getIcon()
    {
        return icon;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
