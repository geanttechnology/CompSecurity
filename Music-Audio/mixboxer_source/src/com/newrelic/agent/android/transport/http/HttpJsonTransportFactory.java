// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.transport.http;

import com.newrelic.agent.android.transport.Transport;
import com.newrelic.agent.android.transport.TransportFactory;

// Referenced classes of package com.newrelic.agent.android.transport.http:
//            HttpJsonTransport

public class HttpJsonTransportFactory
    implements TransportFactory
{

    private final String endpoint;
    private final String licenseKey;

    public HttpJsonTransportFactory(String s, String s1)
    {
        endpoint = s;
        licenseKey = s1;
    }

    public Transport newTransport()
    {
        return new HttpJsonTransport(endpoint, licenseKey);
    }
}
