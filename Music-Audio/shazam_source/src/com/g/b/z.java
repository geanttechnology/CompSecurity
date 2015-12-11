// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import java.net.InetSocketAddress;
import java.net.Proxy;

// Referenced classes of package com.g.b:
//            a

public final class z
{

    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;

    public z(a a1, Proxy proxy, InetSocketAddress inetsocketaddress)
    {
        if (a1 == null)
        {
            throw new NullPointerException("address == null");
        }
        if (proxy == null)
        {
            throw new NullPointerException("proxy == null");
        }
        if (inetsocketaddress == null)
        {
            throw new NullPointerException("inetSocketAddress == null");
        } else
        {
            a = a1;
            b = proxy;
            c = inetsocketaddress;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof z)
        {
            obj = (z)obj;
            flag = flag1;
            if (a.equals(((z) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((z) (obj)).b))
                {
                    flag = flag1;
                    if (c.equals(((z) (obj)).c))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return ((a.hashCode() + 527) * 31 + b.hashCode()) * 31 + c.hashCode();
    }
}
