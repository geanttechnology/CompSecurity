// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class QuizFallbackAmpSetting
    implements Serializable
{

    private boolean enabled;
    private String url;

    private QuizFallbackAmpSetting()
    {
    }

    private QuizFallbackAmpSetting(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        enabled = Builder.access._mth000(builder);
        url = Builder.access._mth100(builder);
    }

    QuizFallbackAmpSetting(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getUrl()
    {
        return url;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
