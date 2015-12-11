// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.advert;

import java.util.Map;

public class AdvertisingInfo
{

    public Map params;
    public String previewSiteName;
    public String siteName;

    private AdvertisingInfo()
    {
    }

    private AdvertisingInfo(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        params = Builder.a(builder);
        siteName = Builder.b(builder);
        previewSiteName = Builder.c(builder);
    }

    public AdvertisingInfo(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
