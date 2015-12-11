// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            fm, gi, gu, gq, 
//            fw, dd, gr

public final class jh
    implements fm
{

    public static final fm a = new jh();

    public jh()
    {
    }

    private static InetAddress a(Proxy proxy, gi gi1)
    {
        if (proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT)
        {
            return ((InetSocketAddress)proxy.address()).getAddress();
        } else
        {
            return InetAddress.getByName(gi1.g());
        }
    }

    public final gq a(Proxy proxy, gu gu1)
    {
        List list = gu1.j();
        gu1 = gu1.a();
        gi gi1 = gu1.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Object obj = (fw)list.get(i);
            if (!"Basic".equalsIgnoreCase(((fw) (obj)).a()))
            {
                continue;
            }
            obj = Authenticator.requestPasswordAuthentication(gi1.g(), a(proxy, gi1), gi1.h(), gi1.c(), ((fw) (obj)).b(), ((fw) (obj)).a(), gi1.a(), java.net.Authenticator.RequestorType.SERVER);
            if (obj != null)
            {
                proxy = dd.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
                return gu1.h().a("Authorization", proxy).a();
            }
        }

        return null;
    }

    public final gq b(Proxy proxy, gu gu1)
    {
        List list = gu1.j();
        gu1 = gu1.a();
        gi gi1 = gu1.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            Object obj = (fw)list.get(i);
            if (!"Basic".equalsIgnoreCase(((fw) (obj)).a()))
            {
                continue;
            }
            InetSocketAddress inetsocketaddress = (InetSocketAddress)proxy.address();
            obj = Authenticator.requestPasswordAuthentication(inetsocketaddress.getHostName(), a(proxy, gi1), inetsocketaddress.getPort(), gi1.c(), ((fw) (obj)).b(), ((fw) (obj)).a(), gi1.a(), java.net.Authenticator.RequestorType.PROXY);
            if (obj != null)
            {
                proxy = dd.a(((PasswordAuthentication) (obj)).getUserName(), new String(((PasswordAuthentication) (obj)).getPassword()));
                return gu1.h().a("Proxy-Authorization", proxy).a();
            }
        }

        return null;
    }

}
