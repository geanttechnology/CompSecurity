// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.protocol.Protocol;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpHost

public class ProxyHost extends HttpHost
{

    public ProxyHost(String s)
    {
        this(s, -1);
    }

    public ProxyHost(String s, int i)
    {
        super(s, i, Protocol.getProtocol("http"));
    }

    public ProxyHost(ProxyHost proxyhost)
    {
        super(proxyhost);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return (ProxyHost)super.clone();
    }
}
