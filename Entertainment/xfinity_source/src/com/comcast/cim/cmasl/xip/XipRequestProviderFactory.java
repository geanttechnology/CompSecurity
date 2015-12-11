// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProviderFactory;

// Referenced classes of package com.comcast.cim.cmasl.xip:
//            XipServer

public class XipRequestProviderFactory
    implements RequestProviderFactory
{

    private final RequestProviderFactory basicRequestProviderFactory;
    private final XipServer xipServer;

    public XipRequestProviderFactory(RequestProviderFactory requestproviderfactory, XipServer xipserver)
    {
        basicRequestProviderFactory = requestproviderfactory;
        xipServer = xipserver;
    }

    public RequestProvider create(String s)
    {
        return basicRequestProviderFactory.create((new StringBuilder()).append(xipServer.getURI()).append(s).toString());
    }

    public RequestProvider create(String s, String s1)
    {
        return basicRequestProviderFactory.create((new StringBuilder()).append(xipServer.getURI()).append(s).toString(), s1);
    }
}
