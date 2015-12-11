// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.net.InetAddress;

// Referenced classes of package com.a.a.a:
//            j

final class k
    implements j
{

    k()
    {
    }

    public final InetAddress[] a(String s)
    {
        return InetAddress.getAllByName(s);
    }
}
