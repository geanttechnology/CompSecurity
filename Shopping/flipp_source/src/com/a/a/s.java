// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

// Referenced classes of package com.a.a:
//            r

final class s extends URLStreamHandler
{

    final String a;
    final r b;

    s(r r1, String s1)
    {
        b = r1;
        a = s1;
        super();
    }

    protected final int getDefaultPort()
    {
        if (a.equals("http"))
        {
            return 80;
        }
        if (a.equals("https"))
        {
            return 443;
        } else
        {
            throw new AssertionError();
        }
    }

    protected final URLConnection openConnection(URL url)
    {
        return b.a(url);
    }

    protected final URLConnection openConnection(URL url, Proxy proxy)
    {
        return b.a(url, proxy);
    }
}
