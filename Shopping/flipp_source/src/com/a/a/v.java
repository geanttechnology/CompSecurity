// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import java.net.InetSocketAddress;
import java.net.Proxy;

// Referenced classes of package com.a.a:
//            a

public final class v
{

    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;
    public final boolean d;

    public v(a a1, Proxy proxy, InetSocketAddress inetsocketaddress, boolean flag)
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
            d = flag;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof v)
        {
            obj = (v)obj;
            flag = flag1;
            if (a.equals(((v) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((v) (obj)).b))
                {
                    flag = flag1;
                    if (c.equals(((v) (obj)).c))
                    {
                        flag = flag1;
                        if (d == ((v) (obj)).d)
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        int i = a.hashCode();
        int j = b.hashCode();
        j = c.hashCode() + ((i + 527) * 31 + j) * 31;
        if (d)
        {
            i = j * 31;
        } else
        {
            i = 0;
        }
        return i + j;
    }
}
