// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class AmpHref
    implements Serializable
{

    private boolean authenticated;
    private String href;

    private AmpHref()
    {
    }

    private AmpHref(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        href = Builder.access._mth000(builder);
        authenticated = Builder.access._mth100(builder);
    }

    AmpHref(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getHref()
    {
        return href;
    }

    public boolean isAuthenticated()
    {
        return authenticated;
    }
}
