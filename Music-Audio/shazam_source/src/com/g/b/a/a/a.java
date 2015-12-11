// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import com.g.b.a.k;
import com.g.b.b;
import com.g.b.g;
import com.g.b.l;
import com.g.b.v;
import com.g.b.x;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.List;

public final class a
    implements b
{

    public static final b a = new a();

    public a()
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

    public final v a(Proxy proxy, x x1)
    {
        List list = x1.f();
        x1 = x1.a;
        URL url = x1.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Object obj = (g)list.get(i);
            if (!"Basic".equalsIgnoreCase(((g) (obj)).a))
            {
                continue;
            }
            obj = Authenticator.requestPasswordAuthentication(url.getHost(), a(proxy, url), k.a(url), url.getProtocol(), ((g) (obj)).b, ((g) (obj)).a, url, java.net.Authenticator.RequestorType.SERVER);
            if (obj != null)
            {
                proxy = l.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
                return x1.c().a("Authorization", proxy).a();
            }
        }

        return null;
    }

    public final v b(Proxy proxy, x x1)
    {
        List list = x1.f();
        x1 = x1.a;
        URL url = x1.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Object obj = (g)list.get(i);
            if (!"Basic".equalsIgnoreCase(((g) (obj)).a))
            {
                continue;
            }
            InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy.address();
            obj = Authenticator.requestPasswordAuthentication(inetsocketaddress.getHostName(), a(proxy, url), inetsocketaddress.getPort(), url.getProtocol(), ((g) (obj)).b, ((g) (obj)).a, url, java.net.Authenticator.RequestorType.PROXY);
            if (obj != null)
            {
                proxy = l.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
                return x1.c().a("Proxy-Authorization", proxy).a();
            }
        }

        return null;
    }

}
