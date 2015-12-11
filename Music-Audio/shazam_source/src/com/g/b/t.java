// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import com.g.b.a.b.b;
import com.g.b.a.b.c;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

// Referenced classes of package com.g.b:
//            s

public final class t
    implements Cloneable, URLStreamHandlerFactory
{

    private final s a;

    public t(s s1)
    {
        a = s1;
    }

    public final HttpURLConnection a(URL url)
    {
        return a(url, a.c);
    }

    final HttpURLConnection a(URL url, Proxy proxy)
    {
        String s1 = url.getProtocol();
        s s2 = a.a();
        s2.c = proxy;
        if (s1.equals("http"))
        {
            return new b(url, s2);
        }
        if (s1.equals("https"))
        {
            return new c(url, s2);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unexpected protocol: ")).append(s1).toString());
        }
    }

    public final Object clone()
    {
        return new t(a.b());
    }

    public final URLStreamHandler createURLStreamHandler(String s1)
    {
        if (!s1.equals("http") && !s1.equals("https"))
        {
            return null;
        } else
        {
            return new URLStreamHandler(s1) {

                final String a;
                final t b;

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

            
            {
                b = t.this;
                a = s1;
                super();
            }
            };
        }
    }
}
