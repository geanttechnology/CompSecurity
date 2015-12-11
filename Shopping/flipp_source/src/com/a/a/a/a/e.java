// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.o;
import com.a.a.p;
import com.a.a.q;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

final class e
    implements o
{

    e()
    {
    }

    private static InetAddress a(Proxy proxy, URL url)
    {
        if (proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT)
        {
            return ((InetSocketAddress)proxy.address()).getAddress();
        } else
        {
            return InetAddress.getByName(url.getHost());
        }
    }

    public final q a(Proxy proxy, URL url, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (p)list.next();
            obj = Authenticator.requestPasswordAuthentication(url.getHost(), a(proxy, url), url.getPort(), url.getProtocol(), ((p) (obj)).b, ((p) (obj)).a, url, java.net.Authenticator.RequestorType.SERVER);
            if (obj != null)
            {
                return q.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
            }
        }

        return null;
    }

    public final q b(Proxy proxy, URL url, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (p)list.next();
            InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy.address();
            obj = Authenticator.requestPasswordAuthentication(inetsocketaddress.getHostName(), a(proxy, url), inetsocketaddress.getPort(), url.getProtocol(), ((p) (obj)).b, ((p) (obj)).a, url, java.net.Authenticator.RequestorType.PROXY);
            if (obj != null)
            {
                return q.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
            }
        }

        return null;
    }
}
