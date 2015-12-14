// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.cloudfront;

import android.net.Uri;

public final class CloudFrontConfig extends Enum
{

    private static final CloudFrontConfig $VALUES[];
    public static final CloudFrontConfig DEVELOPMENT;
    public static final CloudFrontConfig PRODUCTION;
    public static final CloudFrontConfig STAGING;
    private final android.net.Uri.Builder builder;

    private CloudFrontConfig(String s, int i, String s1)
    {
        super(s, i);
        builder = (new android.net.Uri.Builder()).scheme("https").authority((new StringBuilder()).append(s1).append(".cloudfront.net").toString());
    }

    public static CloudFrontConfig valueOf(String s)
    {
        return (CloudFrontConfig)Enum.valueOf(com/amazon/gallery/framework/network/cloudfront/CloudFrontConfig, s);
    }

    public static CloudFrontConfig[] values()
    {
        return (CloudFrontConfig[])$VALUES.clone();
    }

    public Uri getCloudFrontURI(String s)
    {
        return builder.encodedPath(s).build();
    }

    static 
    {
        DEVELOPMENT = new CloudFrontConfig("DEVELOPMENT", 0, "db7afg225qesv");
        STAGING = new CloudFrontConfig("STAGING", 1, "d1fruzwfnysxz6");
        PRODUCTION = new CloudFrontConfig("PRODUCTION", 2, "d21m0ezw6fosyw");
        $VALUES = (new CloudFrontConfig[] {
            DEVELOPMENT, STAGING, PRODUCTION
        });
    }
}
