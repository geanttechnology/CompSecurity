// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Connector

static final class tpRequestTypeFactory
    implements tpRequestTypeFactory
{

    public volatile HttpRequestBase create(String s)
    {
        return create(s);
    }

    public HttpTrace create(String s)
    {
        return new HttpTrace(s);
    }

    tpRequestTypeFactory()
    {
    }
}
