// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.json;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.pointinside.json:
//            ResponseFeeds

public class ResponseFeedsRouteLocation extends ResponseFeeds
{

    public ArrayList cachedData;
    public ArrayList waypoints;

    public ResponseFeedsRouteLocation()
    {
    }

    public volatile Object getData()
    {
        return getData();
    }

    public List getData()
    {
        return waypoints;
    }
}
