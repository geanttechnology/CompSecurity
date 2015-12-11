// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import com.a.a.a.a.d;
import com.a.a.a.a.o;
import com.a.a.a.a.t;
import com.a.a.a.c.b;
import com.a.a.a.u;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.ResponseCache;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.a.a:
//            w, e, f, c, 
//            s, o, t

public final class r
    implements URLStreamHandlerFactory
{

    private static final List n = u.a(Arrays.asList(new String[] {
        "spdy/3", "http/1.1"
    }));
    public final w a;
    public Proxy b;
    public List c;
    public ProxySelector d;
    public CookieHandler e;
    public ResponseCache f;
    public SSLSocketFactory g;
    public HostnameVerifier h;
    public com.a.a.o i;
    public c j;
    public boolean k;
    public int l;
    public int m;
    private final e o;

    public r()
    {
        k = true;
        a = new w();
        o = new e();
    }

    private r(r r1)
    {
        k = true;
        a = r1.a;
        o = r1.o;
    }

    public final com.a.a.t a()
    {
        if (f instanceof f)
        {
            return ((f)f).a;
        }
        if (f != null)
        {
            return new t(f);
        } else
        {
            return null;
        }
    }

    public final HttpURLConnection a(URL url)
    {
        return a(url, b);
    }

    final HttpURLConnection a(URL url, Proxy proxy)
    {
        String s1 = url.getProtocol();
        r r1 = new r(this);
        r1.b = b;
        Object obj;
        if (d != null)
        {
            obj = d;
        } else
        {
            obj = ProxySelector.getDefault();
        }
        r1.d = ((ProxySelector) (obj));
        if (e != null)
        {
            obj = e;
        } else
        {
            obj = CookieHandler.getDefault();
        }
        r1.e = ((CookieHandler) (obj));
        if (f != null)
        {
            obj = f;
        } else
        {
            obj = ResponseCache.getDefault();
        }
        r1.f = ((ResponseCache) (obj));
        if (g != null)
        {
            obj = g;
        } else
        {
            obj = HttpsURLConnection.getDefaultSSLSocketFactory();
        }
        r1.g = ((SSLSocketFactory) (obj));
        if (h != null)
        {
            obj = h;
        } else
        {
            obj = b.a;
        }
        r1.h = ((HostnameVerifier) (obj));
        if (i != null)
        {
            obj = i;
        } else
        {
            obj = d.a;
        }
        r1.i = ((com.a.a.o) (obj));
        if (j != null)
        {
            obj = j;
        } else
        {
            obj = com.a.a.c.a();
        }
        r1.j = ((c) (obj));
        r1.k = k;
        if (c != null)
        {
            obj = c;
        } else
        {
            obj = n;
        }
        r1.c = ((List) (obj));
        r1.l = l;
        r1.m = m;
        r1.b = proxy;
        if (s1.equals("http"))
        {
            return new o(url, r1);
        }
        if (s1.equals("https"))
        {
            return new com.a.a.a.a.r(url, r1);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unexpected protocol: ")).append(s1).toString());
        }
    }

    public final URLStreamHandler createURLStreamHandler(String s1)
    {
        if (!s1.equals("http") && !s1.equals("https"))
        {
            return null;
        } else
        {
            return new s(this, s1);
        }
    }

}
