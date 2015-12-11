// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.b;

import c.m;
import com.g.b.a.a.f;
import com.g.b.a.a.g;
import com.g.b.a.a.h;
import com.g.b.a.a.j;
import com.g.b.a.a.l;
import com.g.b.a.a.n;
import com.g.b.a.a.t;
import com.g.b.a.d;
import com.g.b.a.i;
import com.g.b.a.k;
import com.g.b.o;
import com.g.b.s;
import com.g.b.u;
import com.g.b.v;
import com.g.b.w;
import com.g.b.x;
import com.g.b.y;
import com.g.b.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class b extends HttpURLConnection
{

    private static final Set e = new LinkedHashSet(Arrays.asList(new String[] {
        "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE", "PATCH"
    }));
    private static final w f = new com.g.b.w._cls1(new byte[0]);
    final s a;
    protected IOException b;
    protected g c;
    com.g.b.n d;
    private com.g.b.o.a g;
    private long h;
    private int i;
    private o j;
    private z k;

    public b(URL url, s s1)
    {
        super(url);
        g = new com.g.b.o.a();
        h = -1L;
        a = s1;
    }

    private g a(String s1, com.g.b.i i1, n n1, x x1)
    {
        Object obj;
        Object obj1;
        int j1;
        if (com.g.b.a.a.h.b(s1))
        {
            obj = f;
        } else
        {
            obj = null;
        }
        obj = (new com.g.b.v.a()).a(getURL()).a(s1, ((w) (obj)));
        obj1 = g.a();
        j1 = 0;
        for (int k1 = ((o) (obj1)).a.length / 2; j1 < k1; j1++)
        {
            ((com.g.b.v.a) (obj)).b(((o) (obj1)).a(j1), ((o) (obj1)).b(j1));
        }

        boolean flag1 = false;
        boolean flag = false;
        if (com.g.b.a.a.h.c(s1))
        {
            if (h != -1L)
            {
                ((com.g.b.v.a) (obj)).a("Content-Length", Long.toString(h));
            } else
            if (chunkLength > 0)
            {
                ((com.g.b.v.a) (obj)).a("Transfer-Encoding", "chunked");
            } else
            {
                flag = true;
            }
            flag1 = flag;
            if (((o) (obj1)).a("Content-Type") == null)
            {
                ((com.g.b.v.a) (obj)).a("Content-Type", "application/x-www-form-urlencoded");
                flag1 = flag;
            }
        }
        if (((o) (obj1)).a("User-Agent") == null)
        {
            s1 = System.getProperty("http.agent");
            if (s1 == null)
            {
                s1 = (new StringBuilder("Java")).append(System.getProperty("java.version")).toString();
            }
            ((com.g.b.v.a) (obj)).a("User-Agent", s1);
        }
        obj1 = ((com.g.b.v.a) (obj)).a();
        obj = a;
        s1 = ((String) (obj));
        if (d.b.a(((s) (obj))) != null)
        {
            s1 = ((String) (obj));
            if (!getUseCaches())
            {
                s1 = a.b().a(null);
            }
        }
        return new g(s1, ((v) (obj1)), flag1, true, false, i1, null, n1, x1);
    }

    private o a()
    {
        if (j == null)
        {
            Object obj = c().f();
            com.g.b.o.a a1 = ((x) (obj)).f.a();
            Object obj1 = new StringBuilder();
            com.g.b.a.i.a();
            obj1 = ((StringBuilder) (obj1)).append(com.g.b.a.i.b()).append("-Response-Source").toString();
            if (((x) (obj)).h == null)
            {
                if (((x) (obj)).i == null)
                {
                    obj = "NONE";
                } else
                {
                    obj = (new StringBuilder("CACHE ")).append(((x) (obj)).c).toString();
                }
            } else
            if (((x) (obj)).i == null)
            {
                obj = (new StringBuilder("NETWORK ")).append(((x) (obj)).c).toString();
            } else
            {
                obj = (new StringBuilder("CONDITIONAL_CACHE ")).append(((x) (obj)).h.c).toString();
            }
            j = a1.a(((String) (obj1)), ((String) (obj))).a();
        }
        return j;
    }

    private void a(String s1, boolean flag)
    {
        Object obj = new ArrayList();
        if (flag)
        {
            ((List) (obj)).addAll(a.d);
        }
        s1 = s1.split(",", -1);
        int j1 = s1.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            String s2 = s1[i1];
            try
            {
                ((List) (obj)).add(u.a(s2));
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                throw new IllegalStateException(s1);
            }
            i1++;
        }
        s1 = a;
        obj = com.g.b.a.k.a(((List) (obj)));
        if (!((List) (obj)).contains(u.b))
        {
            throw new IllegalArgumentException((new StringBuilder("protocols doesn't contain http/1.1: ")).append(obj).toString());
        }
        if (((List) (obj)).contains(u.a))
        {
            throw new IllegalArgumentException((new StringBuilder("protocols must not contain http/1.0: ")).append(obj).toString());
        }
        if (((List) (obj)).contains(null))
        {
            throw new IllegalArgumentException("protocols must not contain null");
        } else
        {
            s1.d = com.g.b.a.k.a(((List) (obj)));
            return;
        }
    }

    private boolean a(boolean flag)
    {
        com.g.b.n n1;
        c.a();
        k = c.c;
        if (c.b == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        n1 = c.b.i;
_L1:
        d = n1;
        if (flag)
        {
            try
            {
                c.i();
            }
            catch (l l1)
            {
                IOException ioexception = l1.a();
                b = ioexception;
                throw ioexception;
            }
            catch (com.g.b.a.a.o o1)
            {
                g g1 = c.a(o1);
                if (g1 != null)
                {
                    c = g1;
                    return false;
                } else
                {
                    IOException ioexception1 = o1.b;
                    b = ioexception1;
                    throw ioexception1;
                }
            }
            catch (IOException ioexception2)
            {
                g g2 = c;
                g2 = g2.a(ioexception2, g2.h);
                if (g2 != null)
                {
                    c = g2;
                    return false;
                } else
                {
                    b = ioexception2;
                    throw ioexception2;
                }
            }
        }
        return true;
        n1 = null;
          goto _L1
    }

    private void b()
    {
        if (b != null)
        {
            throw b;
        }
        if (c != null)
        {
            return;
        }
        connected = true;
        if (!doOutput) goto _L2; else goto _L1
_L1:
        if (!method.equals("GET")) goto _L4; else goto _L3
_L3:
        method = "POST";
_L2:
        c = a(method, null, null, null);
        return;
        IOException ioexception;
        ioexception;
        b = ioexception;
        throw ioexception;
_L4:
        if (com.g.b.a.a.h.c(method)) goto _L2; else goto _L5
_L5:
        throw new ProtocolException((new StringBuilder()).append(method).append(" does not support writing").toString());
    }

    private g c()
    {
        b();
        if (c.e())
        {
            return c;
        }
        do
        {
            while (!a(true)) ;
            x1 = c.f();
            v1 = c.j();
            if (v1 == null)
            {
                c.g();
                return c;
            }
            int j1 = i + 1;
            i = j1;
            if (j1 > 20)
            {
                throw new ProtocolException((new StringBuilder("Too many follow-up requests: ")).append(i).toString());
            }
            url = v1.a();
            g = v1.c.a();
            r = c.d();
            if (!v1.b.equals(method))
            {
                r = null;
            }
            if (r == null || (r instanceof n))
            {
                if (!c.b(v1.a()))
                {
                    c.g();
                }
                com.g.b.i i1 = c.h();
                c = a(v1.b, i1, (n)r, x1);
            } else
            {
                throw new HttpRetryException("Cannot retry streamed HTTP body", responseCode);
            }
        } while (true);
    }

    public final void addRequestProperty(String s1, String s2)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (s1 == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s2 == null)
        {
            com.g.b.a.i.a();
            com.g.b.a.i.a((new StringBuilder("Ignoring header ")).append(s1).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s1) || "X-Android-Protocols".equals(s1))
        {
            a(s2, true);
            return;
        } else
        {
            g.a(s1, s2);
            return;
        }
    }

    public final void connect()
    {
        b();
        while (!a(false)) ;
    }

    public final void disconnect()
    {
        g g1;
        if (c != null)
        {
            if ((g1 = c).d != null)
            {
                try
                {
                    g1.d.a(g1);
                    return;
                }
                catch (IOException ioexception)
                {
                    return;
                }
            }
        }
    }

    public final int getConnectTimeout()
    {
        return a.t;
    }

    public final InputStream getErrorStream()
    {
        Object obj = null;
        InputStream inputstream;
        g g1;
        try
        {
            g1 = c();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        inputstream = obj;
        if (!com.g.b.a.a.g.a(g1.f()))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        inputstream = obj;
        if (g1.f().c >= 400)
        {
            inputstream = g1.f().g.c();
        }
        return inputstream;
    }

    public final String getHeaderField(int i1)
    {
        String s1;
        try
        {
            s1 = a().b(i1);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s1;
    }

    public final String getHeaderField(String s1)
    {
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        return com.g.b.a.a.s.a(c().f()).toString();
        s1 = a().a(s1);
        return s1;
        s1;
        return null;
    }

    public final String getHeaderFieldKey(int i1)
    {
        String s1;
        try
        {
            s1 = a().a(i1);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s1;
    }

    public final Map getHeaderFields()
    {
        Map map;
        try
        {
            map = com.g.b.a.a.j.a(a(), com.g.b.a.a.s.a(c().f()).toString());
        }
        catch (IOException ioexception)
        {
            return Collections.emptyMap();
        }
        return map;
    }

    public final InputStream getInputStream()
    {
        if (!doInput)
        {
            throw new ProtocolException("This protocol does not support input");
        }
        g g1 = c();
        if (getResponseCode() >= 400)
        {
            throw new FileNotFoundException(url.toString());
        } else
        {
            return g1.f().g.c();
        }
    }

    public final OutputStream getOutputStream()
    {
        connect();
        g g1 = c;
        Object obj = g1.i;
        if (obj == null)
        {
            obj = g1.d();
            if (obj != null)
            {
                obj = m.a(((c.r) (obj)));
                g1.i = ((c.d) (obj));
            } else
            {
                obj = null;
            }
        }
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder("method does not support a request body: ")).append(method).toString());
        }
        if (c.e())
        {
            throw new ProtocolException("cannot write request body after response has been read");
        } else
        {
            return ((c.d) (obj)).c();
        }
    }

    public final Permission getPermission()
    {
        String s1 = getURL().getHost();
        int i1 = com.g.b.a.k.a(getURL());
        if (usingProxy())
        {
            InetSocketAddress inetsocketaddress = (InetSocketAddress)a.c.address();
            s1 = inetsocketaddress.getHostName();
            i1 = inetsocketaddress.getPort();
        }
        return new SocketPermission((new StringBuilder()).append(s1).append(":").append(i1).toString(), "connect, resolve");
    }

    public final int getReadTimeout()
    {
        return a.u;
    }

    public final Map getRequestProperties()
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        } else
        {
            return com.g.b.a.a.j.a(g.a(), null);
        }
    }

    public final String getRequestProperty(String s1)
    {
        if (s1 == null)
        {
            return null;
        }
        com.g.b.o.a a1 = g;
        for (int i1 = a1.a.size() - 2; i1 >= 0; i1 -= 2)
        {
            if (s1.equalsIgnoreCase((String)a1.a.get(i1)))
            {
                return (String)a1.a.get(i1 + 1);
            }
        }

        return null;
    }

    public final int getResponseCode()
    {
        return c().f().c;
    }

    public final String getResponseMessage()
    {
        return c().f().d;
    }

    public final void setConnectTimeout(int i1)
    {
        a.a(i1, TimeUnit.MILLISECONDS);
    }

    public final void setFixedLengthStreamingMode(int i1)
    {
        setFixedLengthStreamingMode(i1);
    }

    public final void setFixedLengthStreamingMode(long l1)
    {
        if (super.connected)
        {
            throw new IllegalStateException("Already connected");
        }
        if (chunkLength > 0)
        {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (l1 < 0L)
        {
            throw new IllegalArgumentException("contentLength < 0");
        } else
        {
            h = l1;
            super.fixedContentLength = (int)Math.min(l1, 0x7fffffffL);
            return;
        }
    }

    public final void setIfModifiedSince(long l1)
    {
        super.setIfModifiedSince(l1);
        if (ifModifiedSince != 0L)
        {
            g.b("If-Modified-Since", com.g.b.a.a.f.a(new Date(ifModifiedSince)));
            return;
        } else
        {
            g.b("If-Modified-Since");
            return;
        }
    }

    public final void setInstanceFollowRedirects(boolean flag)
    {
        a.r = flag;
    }

    public final void setReadTimeout(int i1)
    {
        a.b(i1, TimeUnit.MILLISECONDS);
    }

    public final void setRequestMethod(String s1)
    {
        if (!e.contains(s1))
        {
            throw new ProtocolException((new StringBuilder("Expected one of ")).append(e).append(" but was ").append(s1).toString());
        } else
        {
            method = s1;
            return;
        }
    }

    public final void setRequestProperty(String s1, String s2)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (s1 == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s2 == null)
        {
            com.g.b.a.i.a();
            com.g.b.a.i.a((new StringBuilder("Ignoring header ")).append(s1).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s1) || "X-Android-Protocols".equals(s1))
        {
            a(s2, false);
            return;
        } else
        {
            g.b(s1, s2);
            return;
        }
    }

    public final boolean usingProxy()
    {
        Proxy proxy;
        if (k != null)
        {
            proxy = k.b;
        } else
        {
            proxy = a.c;
        }
        return proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT;
    }

    static 
    {
        com.g.b.a.k.a(0L, 0L);
    }
}
