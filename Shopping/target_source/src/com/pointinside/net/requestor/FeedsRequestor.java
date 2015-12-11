// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.internal.utils.IOUtils;
import com.pointinside.json.JSONResponse;
import com.pointinside.net.url.FeedsURLBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

// Referenced classes of package com.pointinside.net.requestor:
//            WebserviceRequestor

public abstract class FeedsRequestor extends WebserviceRequestor
{

    FeedsRequestor(FeedsURLBuilder feedsurlbuilder, JSONResponse jsonresponse)
    {
        super(feedsurlbuilder, jsonresponse);
    }

    public List fetchEntriesIfModifiedSinceAtPageNum(long l, int i)
        throws IOException
    {
        return fetchEntriesIfModifiedSinceAtPageNum(l, i, -1);
    }

    public List fetchEntriesIfModifiedSinceAtPageNum(long l, int i, int j)
        throws IOException
    {
        ((FeedsURLBuilder)URL).modifiedSince = Long.valueOf(l);
        ((FeedsURLBuilder)URL).startIndex = Integer.valueOf(i + 1);
        if (j >= 0)
        {
            ((FeedsURLBuilder)URL).maxResults = Integer.valueOf(j);
        }
        HttpURLConnection httpurlconnection = ((FeedsURLBuilder)URL).openConnection();
        List list = parseResponse(IOUtils.executeHttpRequest(httpurlconnection, "GET"));
        httpurlconnection.disconnect();
        return list;
    }
}
