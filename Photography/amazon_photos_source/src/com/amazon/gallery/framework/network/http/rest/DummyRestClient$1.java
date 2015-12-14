// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest;

import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.HttpConfig;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest:
//            DummyRestClient

class 
    implements HttpConfig
{

    public Endpoint getDefaultEndpoint(String s, int i)
    {
        return new Endpoint("DummyClient", false);
    }

    public boolean isDefaultEndpointSticky()
    {
        return false;
    }

    ()
    {
    }
}
