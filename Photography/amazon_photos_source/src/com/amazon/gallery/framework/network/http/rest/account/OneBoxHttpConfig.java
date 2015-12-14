// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;


// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            HttpConfig, Endpoint

public class OneBoxHttpConfig
    implements HttpConfig
{

    public OneBoxHttpConfig()
    {
    }

    public Endpoint getDefaultEndpoint(String s, int i)
    {
        return new Endpoint("http://www.amazon.com/photos1box/api/", true);
    }

    public boolean isDefaultEndpointSticky()
    {
        return true;
    }
}
