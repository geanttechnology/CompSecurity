// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.m;
import com.a.a.a.u;
import com.a.a.b;
import com.a.a.r;
import com.a.a.v;
import com.a.a.w;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketPermission;
import java.net.URL;
import java.security.Permission;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;

// Referenced classes of package com.a.a.a.a:
//            u, v, h, q, 
//            ac, ab, p, z, 
//            d

public class o extends HttpURLConnection
    implements com.a.a.a.a.u
{

    final r a;
    protected IOException b;
    protected h c;
    private final com.a.a.a.a.v d = new com.a.a.a.a.v();
    private long e;
    private int f;

    public o(URL url, r r1)
    {
        super(url);
        e = -1L;
        a = r1;
    }

    private h a(String s, com.a.a.a.a.v v1, b b1, ab ab1)
    {
        if (url.getProtocol().equals("http"))
        {
            return new h(a, this, s, v1, b1, ab1);
        }
        if (url.getProtocol().equals("https"))
        {
            return new q(a, this, s, v1, b1, ab1);
        } else
        {
            throw new AssertionError();
        }
    }

    private void a(String s, boolean flag)
    {
        Object obj = new ArrayList();
        if (flag)
        {
            ((List) (obj)).addAll(a.c);
        }
        s = s.split(",", -1);
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            ((List) (obj)).add(s[i]);
        }

        s = a;
        obj = u.a(((List) (obj)));
        if (!((List) (obj)).contains("http/1.1"))
        {
            throw new IllegalArgumentException((new StringBuilder("transports doesn't contain http/1.1: ")).append(obj).toString());
        }
        if (((List) (obj)).contains(null))
        {
            throw new IllegalArgumentException("transports must not contain null");
        }
        if (((List) (obj)).contains(""))
        {
            throw new IllegalArgumentException("transports contains an empty string");
        } else
        {
            s.c = ((List) (obj));
            return;
        }
    }

    private boolean a(boolean flag)
    {
        boolean flag3 = true;
        c.a();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        c.n();
        return true;
        IOException ioexception;
        ioexception;
        ac ac1;
        Object obj;
        boolean flag1;
label0:
        {
            ac1 = c.e;
            if (ac1 != null && c.d != null)
            {
                v v1 = c.d.d;
                if (v1.b.type() != java.net.Proxy.Type.DIRECT && ac1.b != null)
                {
                    ac1.b.connectFailed(ac1.a, v1.b.address(), ioexception);
                }
                ac1.c.a(v1, ioexception);
            }
            obj = c.d();
            boolean flag2;
            if (obj == null || (obj instanceof ab))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (ac1 == null && c.d == null)
            {
                break label0;
            }
            if (ac1 != null)
            {
                if (ac1.b() || ac1.a() || ac1.d || ac1.c())
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                if (!flag2)
                {
                    break label0;
                }
            }
            if ((ioexception instanceof SSLHandshakeException) && (ioexception.getCause() instanceof CertificateException))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag = ioexception instanceof ProtocolException;
            if (!flag2 && !flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2 && flag1)
            {
                break MISSING_BLOCK_LABEL_274;
            }
        }
        b = ioexception;
        flag1 = false;
_L1:
        if (flag1)
        {
            return false;
        } else
        {
            throw ioexception;
        }
        c.a(true);
        obj = (ab)obj;
        c = a(method, d, null, ((ab) (obj)));
        c.e = ac1;
        flag1 = flag3;
          goto _L1
    }

    private void e()
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
        c = a(method, d, null, null);
        return;
        IOException ioexception;
        ioexception;
        b = ioexception;
        throw ioexception;
_L4:
        if (method.equals("POST") || method.equals("PUT")) goto _L2; else goto _L5
_L5:
        throw new ProtocolException((new StringBuilder()).append(method).append(" does not support writing").toString());
    }

    private h f()
    {
        e();
        if (c.e())
        {
            return c;
        }
          goto _L1
_L13:
        Object obj;
        Object obj1;
        int i;
        if (i == p.c)
        {
            c.j();
        }
        c.a(false);
        c = a(((String) (obj1)), d, c.i(), (ab)obj);
_L1:
        while (!a(true)) ;
        if (c.d != null)
        {
            obj = c.d.d.b;
        } else
        {
            obj = a.b;
        }
        i = getResponseCode();
        i;
        JVM INSTR lookupswitch 7: default 168
    //                   300: 273
    //                   301: 273
    //                   302: 273
    //                   303: 273
    //                   307: 273
    //                   401: 223
    //                   407: 202;
           goto _L2 _L3 _L3 _L3 _L3 _L3 _L4 _L5
_L2:
        i = p.a;
          goto _L6
_L5:
        if (((Proxy) (obj)).type() != java.net.Proxy.Type.HTTP)
        {
            throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
        }
_L4:
        if (com.a.a.a.a.d.a(a.i, getResponseCode(), c.f().f, d, ((Proxy) (obj)), url))
        {
            i = com.a.a.a.a.p.b;
        } else
        {
            i = p.a;
        }
          goto _L6
_L3:
        if (!getInstanceFollowRedirects()) goto _L2; else goto _L7
_L7:
        int j = f + 1;
        f = j;
        if (j > 20)
        {
            throw new ProtocolException((new StringBuilder("Too many redirects: ")).append(f).toString());
        }
        if (i == 307 && !method.equals("GET") && !method.equals("HEAD")) goto _L2; else goto _L8
_L8:
        obj = getHeaderField("Location");
        if (obj == null) goto _L2; else goto _L9
_L9:
        obj1 = url;
        url = new URL(((URL) (obj1)), ((String) (obj)));
        if (!url.getProtocol().equals("https") && !url.getProtocol().equals("http")) goto _L2; else goto _L10
_L10:
        flag = ((URL) (obj1)).getProtocol().equals(url.getProtocol());
        if (!flag && !a.k) goto _L2; else goto _L11
_L11:
        boolean flag1 = ((URL) (obj1)).getHost().equals(url.getHost());
        if (u.a(((URL) (obj1))) == u.a(url))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (flag1 && i != 0 && flag)
        {
            i = com.a.a.a.a.p.b;
        } else
        {
            i = p.c;
        }
_L6:
        boolean flag;
        if (i == p.a)
        {
            c.j();
            return c;
        }
        obj1 = method;
        obj = c.d();
        int k = getResponseCode();
        if (k == 300 || k == 301 || k == 302 || k == 303)
        {
            obj1 = "GET";
            obj = null;
        }
        if (obj != null && !(obj instanceof ab))
        {
            throw new HttpRetryException("Cannot retry streamed HTTP body", c.g());
        }
        if (true) goto _L13; else goto _L12
_L12:
    }

    public HttpURLConnection a()
    {
        return this;
    }

    public final void addRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            m.a();
            m.a((new StringBuilder("Ignoring header ")).append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s))
        {
            a(s1, true);
            return;
        } else
        {
            d.a(s, s1);
            return;
        }
    }

    public final h b()
    {
        return c;
    }

    public final long c()
    {
        return e;
    }

    public final void connect()
    {
        e();
        while (!a(false)) ;
    }

    public final int d()
    {
        return chunkLength;
    }

    public final void disconnect()
    {
        if (c != null)
        {
            if (c.e())
            {
                u.a(c.h());
            }
            c.a(true);
        }
    }

    public int getConnectTimeout()
    {
        return a.l;
    }

    public final InputStream getErrorStream()
    {
        Object obj = null;
        InputStream inputstream;
        h h1;
        try
        {
            h1 = f();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        inputstream = obj;
        if (!h1.k())
        {
            break MISSING_BLOCK_LABEL_33;
        }
        inputstream = obj;
        if (h1.g() >= 400)
        {
            inputstream = h1.h();
        }
        return inputstream;
    }

    public final String getHeaderField(int i)
    {
        String s;
        try
        {
            s = f().f().f.b(i);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final String getHeaderField(String s)
    {
        com.a.a.a.a.v v1;
        try
        {
            v1 = f().f().f;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        return v1.b;
        s = v1.e(s);
        return s;
    }

    public final String getHeaderFieldKey(int i)
    {
        String s;
        try
        {
            s = f().f().f.a(i);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return s;
    }

    public final Map getHeaderFields()
    {
        Map map;
        try
        {
            map = f().f().f.a(true);
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return map;
    }

    public final InputStream getInputStream()
    {
        if (!doInput)
        {
            throw new ProtocolException("This protocol does not support input");
        }
        Object obj = f();
        if (getResponseCode() >= 400)
        {
            throw new FileNotFoundException(url.toString());
        }
        obj = ((h) (obj)).h();
        if (obj == null)
        {
            throw new ProtocolException((new StringBuilder("No response body exists; responseCode=")).append(getResponseCode()).toString());
        } else
        {
            return ((InputStream) (obj));
        }
    }

    public final OutputStream getOutputStream()
    {
        connect();
        OutputStream outputstream = c.d();
        if (outputstream == null)
        {
            throw new ProtocolException((new StringBuilder("method does not support a request body: ")).append(method).toString());
        }
        if (c.e())
        {
            throw new ProtocolException("cannot write request body after response has been read");
        } else
        {
            return outputstream;
        }
    }

    public final Permission getPermission()
    {
        String s = getURL().getHost();
        int i = u.a(getURL());
        if (usingProxy())
        {
            InetSocketAddress inetsocketaddress = (InetSocketAddress)a.b.address();
            s = inetsocketaddress.getHostName();
            i = inetsocketaddress.getPort();
        }
        return new SocketPermission((new StringBuilder()).append(s).append(":").append(i).toString(), "connect, resolve");
    }

    public int getReadTimeout()
    {
        return a.m;
    }

    public final Map getRequestProperties()
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        } else
        {
            return d.a(false);
        }
    }

    public final String getRequestProperty(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return d.e(s);
        }
    }

    public final int getResponseCode()
    {
        return f().g();
    }

    public String getResponseMessage()
    {
        return f().f().f.e;
    }

    public void setConnectTimeout(int i)
    {
        r r1 = a;
        long l = i;
        TimeUnit timeunit = TimeUnit.MILLISECONDS;
        if (l < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        l = timeunit.toMillis(l);
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        } else
        {
            r1.l = (int)l;
            return;
        }
    }

    public void setFixedLengthStreamingMode(int i)
    {
        setFixedLengthStreamingMode(i);
    }

    public void setFixedLengthStreamingMode(long l)
    {
        if (super.connected)
        {
            throw new IllegalStateException("Already connected");
        }
        if (chunkLength > 0)
        {
            throw new IllegalStateException("Already in chunked mode");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException("contentLength < 0");
        } else
        {
            e = l;
            super.fixedContentLength = (int)Math.min(l, 0x7fffffffL);
            return;
        }
    }

    public void setReadTimeout(int i)
    {
        r r1 = a;
        long l = i;
        TimeUnit timeunit = TimeUnit.MILLISECONDS;
        if (l < 0L)
        {
            throw new IllegalArgumentException("timeout < 0");
        }
        if (timeunit == null)
        {
            throw new IllegalArgumentException("unit == null");
        }
        l = timeunit.toMillis(l);
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException("Timeout too large.");
        } else
        {
            r1.m = (int)l;
            return;
        }
    }

    public final void setRequestProperty(String s, String s1)
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (s == null)
        {
            throw new NullPointerException("field == null");
        }
        if (s1 == null)
        {
            m.a();
            m.a((new StringBuilder("Ignoring header ")).append(s).append(" because its value was null.").toString());
            return;
        }
        if ("X-Android-Transports".equals(s))
        {
            a(s1, false);
            return;
        } else
        {
            d.b(s, s1);
            return;
        }
    }

    public final boolean usingProxy()
    {
        Proxy proxy = a.b;
        return proxy != null && proxy.type() != java.net.Proxy.Type.DIRECT;
    }
}
