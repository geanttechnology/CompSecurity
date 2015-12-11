// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.InetSocketAddress;
import java.net.Proxy;

// Referenced classes of package com.paypal.android.sdk:
//            fl

public final class gx
{

    final fl a;
    final Proxy b;
    final InetSocketAddress c;

    public gx(fl fl1, Proxy proxy, InetSocketAddress inetsocketaddress)
    {
        if (fl1 == null)
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
            a = fl1;
            b = proxy;
            c = inetsocketaddress;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof gx)
        {
            obj = (gx)obj;
            flag = flag1;
            if (a.equals(((gx) (obj)).a))
            {
                flag = flag1;
                if (b.equals(((gx) (obj)).b))
                {
                    flag = flag1;
                    if (c.equals(((gx) (obj)).c))
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
