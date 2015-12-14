// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

// Referenced classes of package com.packetzoom.speed:
//            k, b, Session, e, 
//            m, PZHttpURLConnection, c, j

public class l extends HttpsURLConnection
    implements k
{

    private PZHttpURLConnection a_com_packetzoom_speed_PZHttpURLConnection_fld;
    private Session a_com_packetzoom_speed_Session_fld;
    private b a_com_packetzoom_speed_b_fld;
    private m a_com_packetzoom_speed_m_fld;
    private HttpURLConnection a_java_net_HttpURLConnection_fld;

    public l(PZHttpURLConnection pzhttpurlconnection, HttpURLConnection httpurlconnection, URL url, Session session)
    {
        super(url);
        a_com_packetzoom_speed_Session_fld = session;
        a_com_packetzoom_speed_PZHttpURLConnection_fld = pzhttpurlconnection;
        a_java_net_HttpURLConnection_fld = httpurlconnection;
        a_com_packetzoom_speed_b_fld = new b(url.toString());
        if (session != null)
        {
            a_com_packetzoom_speed_b_fld.a_boolean_fld = session.isWhiteListed(url.toString());
        }
        if (!a_com_packetzoom_speed_b_fld.a_boolean_fld)
        {
            e.a("libpz", "ProxyURLConnection url failed to pass regex filter");
            a_com_packetzoom_speed_m_fld = m.c;
            return;
        } else
        {
            a_com_packetzoom_speed_m_fld = m.a;
            return;
        }
    }

    public l(HttpURLConnection httpurlconnection, URL url, Session session)
    {
        super(url);
        a_com_packetzoom_speed_Session_fld = session;
        a_java_net_HttpURLConnection_fld = httpurlconnection;
        a_com_packetzoom_speed_b_fld = new b(url.toString());
        a_com_packetzoom_speed_m_fld = m.c;
        if (session != null)
        {
            a_com_packetzoom_speed_b_fld.a_boolean_fld = session.isWhiteListed(url.toString());
        }
        e.a("libpz", "ProxyURLConnection in fallback mode");
    }

    private void a()
    {
        if (a_com_packetzoom_speed_b_fld.a() || c() && !d()) goto _L2; else goto _L1
_L1:
        a_com_packetzoom_speed_b_fld.a();
        int i = a_java_net_HttpURLConnection_fld.getResponseCode();
        e.a("libpz", (new StringBuilder("http status:")).append(i).append(" for url:").append(a_java_net_HttpURLConnection_fld.getURL().toString()).toString());
        a_com_packetzoom_speed_b_fld.b_int_fld = i;
        a_com_packetzoom_speed_b_fld.c();
        b();
_L4:
        return;
        Object obj;
        obj;
        e.a("libpz", Log.getStackTraceString(((Throwable) (obj))));
        a_com_packetzoom_speed_b_fld.c();
        b();
        return;
        obj;
        e.a("libpz", Log.getStackTraceString(((Throwable) (obj))));
        a_com_packetzoom_speed_b_fld.c();
        b();
        return;
        obj;
        a_com_packetzoom_speed_b_fld.c();
        b();
        throw obj;
_L2:
        if (a())
        {
            e.a("libpz", (new StringBuilder("pz stats: ")).append(a_com_packetzoom_speed_PZHttpURLConnection_fld.a()).toString());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b()
    {
        int i = 0;
        b b1 = a_com_packetzoom_speed_b_fld;
        byte byte0 = a_com_packetzoom_speed_b_fld.a_byte_fld;
        boolean flag;
        if (!d())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b1.a_byte_fld = a(byte0, 0, flag);
        a_com_packetzoom_speed_b_fld.a_byte_fld = a(a_com_packetzoom_speed_b_fld.a_byte_fld, 1, a_com_packetzoom_speed_b_fld.a_boolean_fld);
        a_com_packetzoom_speed_b_fld.a_byte_fld = a(a_com_packetzoom_speed_b_fld.a_byte_fld, 2, a_com_packetzoom_speed_Session_fld.isInitOk());
        a_com_packetzoom_speed_b_fld.a_byte_fld = a(a_com_packetzoom_speed_b_fld.a_byte_fld, 3, a_com_packetzoom_speed_Session_fld.isEnabled());
        a_com_packetzoom_speed_b_fld.a_byte_fld = a(a_com_packetzoom_speed_b_fld.a_byte_fld, 4, a_com_packetzoom_speed_b_fld.b());
        b1 = a_com_packetzoom_speed_b_fld;
        if (d())
        {
            i = a_com_packetzoom_speed_PZHttpURLConnection_fld.a();
        }
        b1.a_int_fld = i;
        a_com_packetzoom_speed_Session_fld.a(a_com_packetzoom_speed_b_fld.a_com_packetzoom_speed_c_fld.ordinal(), a_com_packetzoom_speed_b_fld.b_int_fld, a_com_packetzoom_speed_b_fld.a_java_lang_String_fld, a_com_packetzoom_speed_b_fld.a_byte_fld, (int)a_com_packetzoom_speed_b_fld.a_long_fld, a_com_packetzoom_speed_b_fld.a_int_fld, a_com_packetzoom_speed_b_fld.c, a_com_packetzoom_speed_b_fld.b_long_fld);
    }

    private boolean b()
    {
        return a_com_packetzoom_speed_m_fld == m.a || a_com_packetzoom_speed_m_fld == m.c;
    }

    private boolean c()
    {
        return a_com_packetzoom_speed_m_fld == m.a || a_com_packetzoom_speed_m_fld == m.b;
    }

    private boolean d()
    {
        return a_com_packetzoom_speed_PZHttpURLConnection_fld != null && a_com_packetzoom_speed_PZHttpURLConnection_fld.a();
    }

    public byte a(byte byte0, int i, boolean flag)
    {
        if (flag)
        {
            return (byte)(1 << i | byte0);
        } else
        {
            return (byte)(~(1 << i) & byte0);
        }
    }

    public void a(long l1)
    {
        e.a("libpz", (new StringBuilder("http request complete: ")).append(l1).append(" bytes rcvd").toString());
        a_com_packetzoom_speed_b_fld.a_com_packetzoom_speed_c_fld = c.a;
        a_com_packetzoom_speed_b_fld.a_long_fld = l1;
        a();
    }

    public void a(Exception exception, long l1)
    {
        e.a("libpz", (new StringBuilder("http request failed: ")).append(l1).append(" bytes rcvd").toString());
        a_com_packetzoom_speed_b_fld.a_com_packetzoom_speed_c_fld = c.e;
        a_com_packetzoom_speed_b_fld.a_long_fld = l1;
        a();
    }

    public boolean a()
    {
        return c() && !d();
    }

    public void addRequestProperty(String s, String s1)
    {
        e.a("libpz", (new StringBuilder("addRequestProperty: ")).append(s).append(" : ").append(s1).toString());
        if (b())
        {
            a_java_net_HttpURLConnection_fld.addRequestProperty(s, s1);
        }
        if (c() && a_com_packetzoom_speed_Session_fld.pzHeadersCheck(s))
        {
            a_com_packetzoom_speed_m_fld = m.c;
        }
    }

    public void connect()
    {
        try
        {
            if (!c())
            {
                a_java_net_HttpURLConnection_fld.connect();
            }
            return;
        }
        catch (IOException ioexception)
        {
            a(ioexception, 0L);
            throw ioexception;
        }
    }

    public void disconnect()
    {
        if (!c())
        {
            a_java_net_HttpURLConnection_fld.disconnect();
            if (!a_com_packetzoom_speed_b_fld.a())
            {
                a_com_packetzoom_speed_b_fld.b();
                b();
            }
            return;
        } else
        {
            a_com_packetzoom_speed_PZHttpURLConnection_fld.disconnect();
            return;
        }
    }

    public String getCipherSuite()
    {
        return ((HttpsURLConnection)a_java_net_HttpURLConnection_fld).getCipherSuite();
    }

    public int getConnectTimeout()
    {
        return a_java_net_HttpURLConnection_fld.getConnectTimeout();
    }

    public Object getContent()
    {
        Object obj;
        int i;
        if (!c())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = a_com_packetzoom_speed_PZHttpURLConnection_fld.getInputStream();
        i = a_com_packetzoom_speed_PZHttpURLConnection_fld.getContentLength();
_L1:
        if (!c() || d())
        {
            obj = a_java_net_HttpURLConnection_fld.getContent();
            a_com_packetzoom_speed_b_fld.a_long_fld = a_java_net_HttpURLConnection_fld.getContentLength();
            a(i);
        }
        return obj;
        obj;
        a(((Exception) (obj)), 0L);
        throw obj;
        obj = null;
        i = 0;
          goto _L1
    }

    public String getContentType()
    {
        if (a())
        {
            return a_com_packetzoom_speed_PZHttpURLConnection_fld.getContentType();
        } else
        {
            return a_java_net_HttpURLConnection_fld.getContentType();
        }
    }

    public long getDate()
    {
        if (a())
        {
            return a_com_packetzoom_speed_PZHttpURLConnection_fld.getDate();
        } else
        {
            return a_java_net_HttpURLConnection_fld.getDate();
        }
    }

    public InputStream getErrorStream()
    {
        if (c())
        {
            return a_com_packetzoom_speed_PZHttpURLConnection_fld.getErrorStream();
        } else
        {
            return a_java_net_HttpURLConnection_fld.getErrorStream();
        }
    }

    public String getHeaderField(int i)
    {
        String s = null;
        if (c())
        {
            s = a_com_packetzoom_speed_PZHttpURLConnection_fld.getHeaderField(i);
        }
        if (!c() || d())
        {
            s = a_java_net_HttpURLConnection_fld.getHeaderField(i);
        }
        return s;
    }

    public String getHeaderField(String s)
    {
        String s1 = null;
        if (c())
        {
            s1 = a_com_packetzoom_speed_PZHttpURLConnection_fld.getHeaderField(s);
        }
        if (!c() || d())
        {
            s1 = a_java_net_HttpURLConnection_fld.getHeaderField(s);
            a_com_packetzoom_speed_b_fld.a();
        }
        return s1;
    }

    public Map getHeaderFields()
    {
        Map map = null;
        if (c())
        {
            map = a_com_packetzoom_speed_PZHttpURLConnection_fld.getHeaderFields();
        }
        if (!c() || d())
        {
            map = a_java_net_HttpURLConnection_fld.getHeaderFields();
        }
        return map;
    }

    public InputStream getInputStream()
    {
        Object obj = null;
        if (c())
        {
            obj = a_com_packetzoom_speed_PZHttpURLConnection_fld.getInputStream();
        }
        e.a("libpz", "proxy::getInputStream");
        try
        {
            if (!c() || d())
            {
                e.a("libpz", (new StringBuilder("http fallback to:")).append(a_java_net_HttpURLConnection_fld.getURL().toString()).toString());
                obj = new j(a_java_net_HttpURLConnection_fld.getInputStream(), this);
                e.a("libpz", "http fallback returned");
            }
        }
        catch (IOException ioexception)
        {
            e.a("libpz", "getInputStream:", ioexception);
            a(ioexception, 0L);
            throw ioexception;
        }
        return ((InputStream) (obj));
    }

    public Certificate[] getLocalCertificates()
    {
        return ((HttpsURLConnection)a_java_net_HttpURLConnection_fld).getLocalCertificates();
    }

    public OutputStream getOutputStream()
    {
        a_com_packetzoom_speed_m_fld = m.c;
        e.a("libpz", "getOutputStream: ");
        return a_java_net_HttpURLConnection_fld.getOutputStream();
    }

    public int getReadTimeout()
    {
        return a_java_net_HttpURLConnection_fld.getReadTimeout();
    }

    public final String getRequestProperty(String s)
    {
        return a_java_net_HttpURLConnection_fld.getRequestProperty(s);
    }

    public int getResponseCode()
    {
        int i = 0;
        if (c())
        {
            i = a_com_packetzoom_speed_PZHttpURLConnection_fld.getResponseCode();
        }
        if (c() && !d())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        int i1;
        try
        {
            i1 = a_java_net_HttpURLConnection_fld.getResponseCode();
            a_com_packetzoom_speed_b_fld.a();
        }
        catch (IOException ioexception)
        {
            a(ioexception, 0L);
            throw ioexception;
        }
        i = i1;
        if (i1 == 200)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        a(0L);
        i = i1;
        return i;
    }

    public Certificate[] getServerCertificates()
    {
        return ((HttpsURLConnection)a_java_net_HttpURLConnection_fld).getServerCertificates();
    }

    public void setConnectTimeout(int i)
    {
        a_java_net_HttpURLConnection_fld.setConnectTimeout(i);
    }

    public void setDoInput(boolean flag)
    {
        if (c())
        {
            a_com_packetzoom_speed_PZHttpURLConnection_fld.setDoInput(flag);
        }
        if (b())
        {
            a_java_net_HttpURLConnection_fld.setDoInput(flag);
        }
    }

    public void setDoOutput(boolean flag)
    {
        if (c())
        {
            a_com_packetzoom_speed_PZHttpURLConnection_fld.setDoOutput(flag);
        }
        if (b())
        {
            a_java_net_HttpURLConnection_fld.setDoOutput(flag);
        }
    }

    public void setHostnameVerifier(HostnameVerifier hostnameverifier)
    {
        e.a("libpz", "setHostnameVerifier: ");
        ((HttpsURLConnection)a_java_net_HttpURLConnection_fld).setHostnameVerifier(hostnameverifier);
    }

    public void setInstanceFollowRedirects(boolean flag)
    {
        e.a("libpz", (new StringBuilder("setInstanceFollowRedirects: ")).append(flag).toString());
        HttpURLConnection.setFollowRedirects(flag);
    }

    public void setReadTimeout(int i)
    {
        a_java_net_HttpURLConnection_fld.setReadTimeout(i);
    }

    public void setRequestMethod(String s)
    {
        if (!s.equals("GET"))
        {
            a_com_packetzoom_speed_m_fld = m.c;
        }
        e.a("libpz", (new StringBuilder("setRequestMethod: ")).append(s).toString());
        a_java_net_HttpURLConnection_fld.setRequestMethod(s);
        a_com_packetzoom_speed_b_fld.a(s);
    }

    public void setRequestProperty(String s, String s1)
    {
        e.a("libpz", (new StringBuilder("setRequestProperty: ")).append(s).append(" : ").append(s1).toString());
        if (b())
        {
            a_java_net_HttpURLConnection_fld.setRequestProperty(s, s1);
        }
        if (c() && a_com_packetzoom_speed_Session_fld.pzHeadersCheck(s))
        {
            a_com_packetzoom_speed_m_fld = m.c;
        }
    }

    public void setSSLSocketFactory(SSLSocketFactory sslsocketfactory)
    {
        e.a("libpz", "setSSLSocketFactory: ");
        ((HttpsURLConnection)a_java_net_HttpURLConnection_fld).setSSLSocketFactory(sslsocketfactory);
    }

    public void setUseCaches(boolean flag)
    {
        if (c())
        {
            a_com_packetzoom_speed_PZHttpURLConnection_fld.setUseCaches(flag);
        }
        if (b())
        {
            a_java_net_HttpURLConnection_fld.setUseCaches(flag);
        }
    }

    public boolean usingProxy()
    {
        if (b())
        {
            return a_java_net_HttpURLConnection_fld.usingProxy();
        } else
        {
            return false;
        }
    }
}
