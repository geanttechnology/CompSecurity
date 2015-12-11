// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.track;

import java.util.Map;

public class AdvertisingInfo
{

    private Map params;
    private String previewAdSiteName;
    private String siteName;

    public AdvertisingInfo()
    {
    }

    private AdvertisingInfo(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        params = Builder.access._mth000(builder);
        siteName = Builder.access._mth100(builder);
        previewAdSiteName = Builder.access._mth200(builder);
    }

    AdvertisingInfo(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Map getParams()
    {
        return params;
    }

    public String getPreviewAdSiteName()
    {
        return previewAdSiteName;
    }

    public String getSiteName()
    {
        return siteName;
    }
}
