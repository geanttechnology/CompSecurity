// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.net.EndpointType;
import com.pointinside.net.url.URLBuilder;

// Referenced classes of package com.pointinside.maps:
//            MapZoneViewAnalyticsRequestor

static class  extends URLBuilder
{

    public void onPrepareURL()
    {
        addProximityDataIfAvailable();
    }

    public ()
    {
        super(EndpointType.MAP_ZONE_VIEW_ANALYTICS, null);
    }
}
