// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package com.paypal.android.sdk:
//            hc

final class hd
    implements hc
{

    hd()
    {
    }

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
}
