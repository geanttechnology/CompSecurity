// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

public class Option
    implements Serializable
{

    private String caption;
    private String icon;
    private String id;
    private String oauthrefresh;
    private String oauthswap;
    private String packageName;
    private String store;
    private String subscribe;

    private Option()
    {
    }

    private Option(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        id = Builder.access._mth000(builder);
        icon = Builder.access._mth100(builder);
        caption = Builder.access._mth200(builder);
        store = Builder.access._mth300(builder);
        subscribe = Builder.access._mth400(builder);
        oauthswap = Builder.access._mth500(builder);
        oauthrefresh = Builder.access._mth600(builder);
        packageName = Builder.access._mth700(builder);
    }

    Option(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public String getCaption()
    {
        return caption;
    }

    public String getIcon()
    {
        return icon;
    }

    public String getId()
    {
        return id;
    }

    public String getOauthrefresh()
    {
        return oauthrefresh;
    }

    public String getOauthswap()
    {
        return oauthswap;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public String getStore()
    {
        return store;
    }

    public String getSubscribe()
    {
        return subscribe;
    }
}
