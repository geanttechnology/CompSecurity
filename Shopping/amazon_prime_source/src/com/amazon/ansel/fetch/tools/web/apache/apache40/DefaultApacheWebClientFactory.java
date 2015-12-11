// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.web.apache.apache40;

import com.amazon.ansel.fetch.tools.web.WebClient;
import com.amazon.ansel.fetch.tools.web.WebClientFactory;

// Referenced classes of package com.amazon.ansel.fetch.tools.web.apache.apache40:
//            ApacheWebClient

public class DefaultApacheWebClientFactory
    implements WebClientFactory
{

    private WebClient webClient;

    public DefaultApacheWebClientFactory()
    {
    }

    public WebClient getWebClient()
    {
        this;
        JVM INSTR monitorenter ;
        WebClient webclient;
        if (webClient == null)
        {
            webClient = new ApacheWebClient();
        }
        webclient = webClient;
        this;
        JVM INSTR monitorexit ;
        return webclient;
        Exception exception;
        exception;
        throw exception;
    }
}
