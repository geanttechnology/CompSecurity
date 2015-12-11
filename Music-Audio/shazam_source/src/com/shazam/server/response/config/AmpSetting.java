// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class AmpSetting
    implements Serializable
{

    private boolean enabled;

    private AmpSetting()
    {
    }

    protected AmpSetting(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        enabled = Builder.access._mth000(builder);
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
