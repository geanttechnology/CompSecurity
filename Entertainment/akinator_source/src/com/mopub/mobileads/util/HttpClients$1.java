// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.util;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

// Referenced classes of package com.mopub.mobileads.util:
//            HttpClients

static final class val.httpClient
    implements Runnable
{

    final HttpClient val$httpClient;

    public void run()
    {
        if (val$httpClient != null && val$httpClient.getConnectionManager() != null)
        {
            val$httpClient.getConnectionManager().shutdown();
        }
    }

    nager(HttpClient httpclient)
    {
        val$httpClient = httpclient;
        super();
    }
}
