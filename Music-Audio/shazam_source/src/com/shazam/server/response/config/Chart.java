// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class Chart
    implements Serializable
{

    private String href;
    private String id;
    private String title;

    private Chart()
    {
    }

    private Chart(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        id = Builder.access._mth000(builder);
        title = Builder.access._mth100(builder);
        href = Builder.access._mth200(builder);
    }

    Chart(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getHref()
    {
        return href;
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }
}
