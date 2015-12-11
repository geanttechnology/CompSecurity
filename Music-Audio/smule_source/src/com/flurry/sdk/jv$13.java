// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.net.InetAddress;

// Referenced classes of package com.flurry.sdk:
//            ir, jv, jx, jy, 
//            jz

final class  extends ir
{

    public InetAddress a(jx jx1)
    {
        if (jx1.f() == jy.i)
        {
            jx1.j();
            return null;
        } else
        {
            return InetAddress.getByName(jx1.h());
        }
    }

    public volatile void a(jz jz1, Object obj)
    {
        a(jz1, (InetAddress)obj);
    }

    public void a(jz jz1, InetAddress inetaddress)
    {
        if (inetaddress == null)
        {
            inetaddress = null;
        } else
        {
            inetaddress = inetaddress.getHostAddress();
        }
        jz1.b(inetaddress);
    }

    public Object b(jx jx1)
    {
        return a(jx1);
    }

    ()
    {
    }
}
