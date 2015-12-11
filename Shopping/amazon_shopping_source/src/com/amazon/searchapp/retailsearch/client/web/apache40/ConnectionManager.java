// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web.apache40;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web.apache40:
//            ApacheSearchUtil

public class ConnectionManager
{

    private final ClientConnectionManager connectionManager;
    private final HttpParams httpParams;

    public ConnectionManager(int i)
    {
        httpParams = ApacheSearchUtil.createHttpParams(i);
        connectionManager = ApacheSearchUtil.createConnectionManager(httpParams);
    }

    public HttpClient createHttpClient()
    {
        return ApacheSearchUtil.createHttpClient(httpParams, connectionManager);
    }
}
