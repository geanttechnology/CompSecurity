// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package com.g.b.a:
//            g

static final class ddress
    implements g
{

    public final InetAddress[] a(String s)
    {
        if (s == null)
        {
            throw new UnknownHostException("host == null");
        } else
        {
            return InetAddress.getAllByName(s);
        }
    }

    ddress()
    {
    }
}
