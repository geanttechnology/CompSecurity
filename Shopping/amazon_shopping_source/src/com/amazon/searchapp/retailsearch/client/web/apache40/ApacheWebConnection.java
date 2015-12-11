// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import com.amazon.searchapp.retailsearch.client.web.WebConnection;
import com.amazon.searchapp.retailsearch.client.web.WebResponse;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web.apache40:
//            ApacheWebResponse

public class ApacheWebConnection
    implements WebConnection
{

    private final HttpClient client;
    private final HttpRequestBase request;

    public ApacheWebConnection(HttpClient httpclient, HttpRequestBase httprequestbase)
    {
        client = httpclient;
        request = httprequestbase;
    }

    public WebResponse getResponse()
        throws IOException
    {
        return new ApacheWebResponse(client.execute(request));
    }
}
