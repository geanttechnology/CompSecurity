// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseHttpClient

private class request
    implements com.parse.http.st
{

    private final int externalIndex;
    private final int internalIndex;
    private final ParseHttpRequest request;
    final ParseHttpClient this$0;

    public ParseHttpRequest getRequest()
    {
        return request;
    }

    public ParseHttpResponse proceed(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        if (ParseHttpClient.access$000(ParseHttpClient.this) != null && internalIndex < ParseHttpClient.access$000(ParseHttpClient.this).size())
        {
            parsehttprequest = new <init>(internalIndex + 1, externalIndex, parsehttprequest);
            return ((ParseNetworkInterceptor)ParseHttpClient.access$000(ParseHttpClient.this).get(internalIndex)).intercept(parsehttprequest);
        }
        if (ParseHttpClient.access$100(ParseHttpClient.this) != null && externalIndex < ParseHttpClient.access$100(ParseHttpClient.this).size())
        {
            parsehttprequest = new <init>(internalIndex, externalIndex + 1, parsehttprequest);
            return ((ParseNetworkInterceptor)ParseHttpClient.access$100(ParseHttpClient.this).get(externalIndex)).intercept(parsehttprequest);
        } else
        {
            return executeInternal(parsehttprequest);
        }
    }

    (int i, int j, ParseHttpRequest parsehttprequest)
    {
        this$0 = ParseHttpClient.this;
        super();
        internalIndex = i;
        externalIndex = j;
        request = parsehttprequest;
    }
}
