// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.r;
import java.net.HttpURLConnection;
import java.net.SecureCacheResponse;
import java.net.URL;

// Referenced classes of package com.a.a.a.a:
//            o, q, h, r

public final class s extends o
{

    final com.a.a.a.a.r d;

    private s(com.a.a.a.a.r r, URL url, r r1)
    {
        d = r;
        super(url, r1);
    }

    s(com.a.a.a.a.r r, URL url, r r1, byte byte0)
    {
        this(r, url, r1);
    }

    public final HttpURLConnection a()
    {
        return d;
    }

    public final SecureCacheResponse e()
    {
        if (c instanceof q)
        {
            return (SecureCacheResponse)c.f;
        } else
        {
            return null;
        }
    }
}
