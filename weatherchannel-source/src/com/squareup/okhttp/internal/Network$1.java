// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

// Referenced classes of package com.squareup.okhttp.internal:
//            Network

static final class 
    implements Network
{

    public InetAddress[] resolveInetAddresses(String s)
        throws UnknownHostException
    {
        if (s == null)
        {
            throw new UnknownHostException("host == null");
        } else
        {
            return InetAddress.getAllByName(s);
        }
    }

    ()
    {
    }
}
