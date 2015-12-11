// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.u;
import com.a.a.b;
import com.a.a.r;
import com.a.a.x;
import java.net.CacheResponse;
import java.net.SecureCacheResponse;
import java.net.URL;
import javax.net.ssl.SSLSocket;

// Referenced classes of package com.a.a.a.a:
//            h, x, u, v, 
//            ab

public final class q extends h
{

    public SSLSocket k;

    public q(r r, com.a.a.a.a.u u1, String s, v v, b b1, ab ab)
    {
        super(r, u1, s, v, b1, ab);
        if (b1 != null)
        {
            r = (SSLSocket)b1.e;
        } else
        {
            r = null;
        }
        k = r;
    }

    protected final void a(b b1)
    {
        k = (SSLSocket)b1.e;
    }

    protected final boolean a(CacheResponse cacheresponse)
    {
        return cacheresponse instanceof SecureCacheResponse;
    }

    protected final boolean l()
    {
        return false;
    }

    protected final x o()
    {
        Object obj = i.j;
        String s = ((String) (obj));
        if (obj == null)
        {
            s = m();
        }
        obj = a.getURL();
        return new x(((URL) (obj)).getHost(), u.a(((URL) (obj))), s, i.p);
    }
}
