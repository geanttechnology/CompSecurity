// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.web.apache.apache40;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.amazon.ansel.fetch.tools.web.apache.apache40:
//            ApacheUtil

public class ConnectionManager
{

    private final ClientConnectionManager connectionManager;
    private final HttpParams httpParams;

    public ConnectionManager(int i)
    {
        httpParams = ApacheUtil.createHttpParams(i);
        connectionManager = ApacheUtil.createConnectionManager(httpParams);
    }

    public HttpClient createHttpClient()
    {
        return ApacheUtil.createHttpClient(httpParams, connectionManager);
    }
}
