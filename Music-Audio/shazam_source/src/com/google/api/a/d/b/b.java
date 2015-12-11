// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d.b;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

// Referenced classes of package com.google.api.a.d.b:
//            a

public final class b
    implements a
{

    private final Proxy a;

    public b()
    {
        this((byte)0);
    }

    private b(byte byte0)
    {
        a = null;
    }

    public final HttpURLConnection a(URL url)
    {
        if (a == null)
        {
            url = url.openConnection();
        } else
        {
            url = url.openConnection(a);
        }
        return (HttpURLConnection)(HttpURLConnection)url;
    }
}
