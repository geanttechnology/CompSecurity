// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow.config;

import java.net.URI;

// Referenced classes of package com.xfinity.playnow.config:
//            PlayNowConfiguration

public class DenverStagingConfiguration extends PlayNowConfiguration
{

    public DenverStagingConfiguration()
    {
        XIP_URI = "https://xip-staging.cim.comcast.net/xip/";
        CONSUMABLES_HYPERMEDIA_SERVICES_URL = "http://denver.staging.xfinitytv.comcast.net/api/hypermedia/consumables/";
        TVE_HYPERMEDIA_SERVICES_URL = "http://denver.staging.xfinitytv.comcast.net/xtvapi/tve/android/home/";
        EDITORIAL_COVERS_URI = URI.create("http://xfinitytv.comcast.net/api/xfinity/ipad/home/cover?filter&type=json");
        EDITORIAL_VIDEO_URI = URI.create("http://xfinitytv.comcast.net/api/xfinity/ipad/home/videos?filter&type=json");
    }
}
