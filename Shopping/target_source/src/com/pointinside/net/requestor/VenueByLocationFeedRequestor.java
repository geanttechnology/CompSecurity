// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.net.url.FeedsVenueLocationURLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

// Referenced classes of package com.pointinside.net.requestor:
//            FeedsRequestor

public class VenueByLocationFeedRequestor extends FeedsRequestor
{

    private static final int METERS_PER_MILE = 1609;

    VenueByLocationFeedRequestor(FeedsVenueLocationURLBuilder feedsvenuelocationurlbuilder, JSONResponse jsonresponse)
    {
        super(feedsvenuelocationurlbuilder, jsonresponse);
    }

    public List fetchByLocation(double d, double d1)
        throws IOException
    {
        return fetchByLocation(d, d1, Integer.valueOf(0), Integer.valueOf(0));
    }

    public List fetchByLocation(double d, double d1, Integer integer, Integer integer1)
        throws IOException
    {
        ((FeedsVenueLocationURLBuilder)URL).latitude = d;
        ((FeedsVenueLocationURLBuilder)URL).longitude = d1;
        ((FeedsVenueLocationURLBuilder)URL).maxResults = integer1;
        ((FeedsVenueLocationURLBuilder)URL).radius = Integer.valueOf(integer.intValue() * 1609);
        integer = ((FeedsVenueLocationURLBuilder)URL).openConnection();
        IOUtils.executeHttpRequest(integer, "GET");
        integer1 = parseResponse(integer);
        integer.disconnect();
        return integer1;
    }
}
