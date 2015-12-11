// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.feeds.BaseEntity;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.net.url.FeedsURLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

// Referenced classes of package com.pointinside.net.requestor:
//            AllVenueFeedRequestor

public class SingleVenueFeedRequestor extends AllVenueFeedRequestor
{

    SingleVenueFeedRequestor(FeedsURLBuilder feedsurlbuilder, JSONResponse jsonresponse)
    {
        super(feedsurlbuilder, jsonresponse);
    }

    public final BaseEntity fetchEntry()
        throws IOException
    {
        return fetchEntryIfModifiedSince(null);
    }

    public final BaseEntity fetchEntryIfModifiedSince(Long long1)
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
        IOUtils.executeHttpRequest(httpurlconnection, "GET");
        long1 = parseResponse(httpurlconnection);
        httpurlconnection.disconnect();
        if (long1.isEmpty())
        {
            return null;
        } else
        {
            return (BaseEntity)long1.get(0);
        }
    }
}
