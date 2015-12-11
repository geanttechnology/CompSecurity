// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;


// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            WebClientFactory, ServiceClient, WebClient

static final class val.webClient
    implements WebClientFactory
{

    final WebClient val$webClient;

    public WebClient getWebClient()
    {
        return val$webClient;
    }

    (WebClient webclient)
    {
        val$webClient = webclient;
        super();
    }
}
