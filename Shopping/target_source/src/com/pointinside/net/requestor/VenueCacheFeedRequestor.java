// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.google.b.t;
import com.pointinside.feeds.BaseEntity;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.net.url.FeedsURLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.net.requestor:
//            AllVenueFeedRequestor

public class VenueCacheFeedRequestor extends AllVenueFeedRequestor
{

    VenueCacheFeedRequestor(FeedsURLBuilder feedsurlbuilder, JSONResponse jsonresponse)
    {
        super(feedsurlbuilder, jsonresponse);
    }

    public final List fetchEntry(String s, Map map)
        throws IOException
    {
        return fetchEntryIfModifiedSince(s, null, map);
    }

    public final List fetchEntryIfModifiedSince(String s, Long long1, Map map)
        throws IOException
    {
        HttpURLConnection httpurlconnection = ((FeedsURLBuilder)URL).openConnection();
        ((FeedsURLBuilder)URL).maxResults = Integer.valueOf(1);
        if (long1 != null)
        {
            ((FeedsURLBuilder)URL).modifiedSince = long1;
        } else
        {
            ((FeedsURLBuilder)URL).modifiedSince = null;
        }
        ((FeedsURLBuilder)URL).venueUUID = s;
        lastPostBody = IOUtils.serializeToJSONString(map, new t[0]);
        IOUtils.executeHttpPostRequest(httpurlconnection, lastPostBody);
        s = parseResponse(httpurlconnection);
        httpurlconnection.disconnect();
        return s;
    }

    public final BaseEntity fetchSingleEntry(String s, Map map)
        throws IOException
    {
        return (BaseEntity)fetchEntryIfModifiedSince(s, null, map).get(0);
    }
}
