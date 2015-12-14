// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.network;

import java.util.Map;

// Referenced classes of package com.inmobi.commons.core.network:
//            NetworkRequest, NetworkError

public class c
{

    private NetworkRequest a;
    private String b;
    private NetworkError c;
    private Map d;

    public c(NetworkRequest networkrequest)
    {
        a = networkrequest;
    }

    public void a(NetworkError networkerror)
    {
        c = networkerror;
    }

    public void a(String s)
    {
        b = s;
    }

    public void a(Map map)
    {
        d = map;
    }

    public boolean a()
    {
        return c != null;
    }

    public String b()
    {
        return b;
    }

    public NetworkError c()
    {
        return c;
    }
}
