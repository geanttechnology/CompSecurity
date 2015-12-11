// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow.config;

import java.net.URI;

// Referenced classes of package com.xfinity.playnow.config:
//            PlayNowConfiguration

public class SprintQaConfiguration extends PlayNowConfiguration
{

    public SprintQaConfiguration()
    {
        XIP_URI = "https://xip-sprint.qa.cim.comcast.net/xip/";
        CONSUMABLES_HYPERMEDIA_SERVICES_URL = "http://sprint.qa.xfinitytv.comcast.net/api/hypermedia/consumables/";
        TVE_HYPERMEDIA_SERVICES_URL = "http://sprint.qa.xfinitytv.comcast.net/xtvapi/tve/android/home/";
        EDITORIAL_COVERS_URI = URI.create("http://sprint.qa.xfinitytv.comcast.net/api/xfinity/ipad/home/cover?filter&type=json");
        EDITORIAL_VIDEO_URI = URI.create("http://sprint.qa.xfinitytv.comcast.net/api/xfinity/ipad/home/videos?filter&type=json");
    }
}
