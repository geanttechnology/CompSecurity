// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tapjoy.internal:
//            fb

class fn
{

    private static final String f = com/tapjoy/internal/fn.toString();
    private final AndroidHttpClient a;
    private final ArrayList b = new ArrayList();
    private HttpResponse c;
    private HttpRequestBase d;
    private fk.c e;

    fn(AndroidHttpClient androidhttpclient)
    {
        a = androidhttpclient;
        e = fk.c.a;
        d = null;
    }

    public static void a(Context context, HttpClient httpclient, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            context = SSLCertificateSocketFactory.getHttpSocketFactory(i, new SSLSessionCache(context));
            httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", context, 443));
            return;
        } else
        {
            context = new LayeredSocketFactory(i, context) {

                final SSLSocketFactory a;
                final int b;
                final Context c;

                public final Socket connectSocket(Socket socket, String s, int j, InetAddress inetaddress, int k, HttpParams httpparams)
                {
                    return a.connectSocket(socket, s, j, inetaddress, k, httpparams);
                }

                public final Socket createSocket()
                {
                    return a.createSocket();
                }

                public final Socket createSocket(Socket socket, String s, int j, boolean flag)
                {
                    try
                    {
                        Field field = java/net/InetAddress.getDeclaredField("hostName");
                        field.setAccessible(true);
                        field.set(socket.getInetAddress(), s);
                    }
                    catch (Exception exception) { }
                    return a.createSocket(socket, s, j, flag);
                }

                public final boolean isSecure(Socket socket)
                {
                    return a.isSecure(socket);
                }

            
            {
                b = i;
                c = context;
                super();
                a = SSLCertificateSocketFactory.getHttpSocketFactory(b, new SSLSessionCache(c));
            }
            };
            httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", context, 443));
            return;
        }
    }

    private void a(HttpRequestBase httprequestbase)
    {
        this;
        JVM INSTR monitorenter ;
        d = httprequestbase;
        this;
        JVM INSTR monitorexit ;
        BasicHeader basicheader;
        for (httprequestbase = b.iterator(); httprequestbase.hasNext(); d.addHeader(basicheader))
        {
            basicheader = (BasicHeader)httprequestbase.next();
        }

        break MISSING_BLOCK_LABEL_52;
        httprequestbase;
        throw httprequestbase;
        HttpClientParams.setRedirecting(d.getParams(), true);
        httprequestbase = new fb();
        if (httprequestbase.a() != null && !httprequestbase.a().isEmpty())
        {
            httprequestbase = new HttpHost(httprequestbase.a(), httprequestbase.b());
            a.getParams().setParameter("http.route.default-proxy", httprequestbase);
        } else
        {
            a.getParams().setParameter("http.route.default-proxy", null);
        }
        try
        {
            c = a.execute(d);
            e = fk.c.b;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestBase httprequestbase)
        {
            String s;
            if (httprequestbase.getCause() instanceof CertificateException)
            {
                e = fk.c.g;
            } else
            if (httprequestbase instanceof SSLPeerUnverifiedException)
            {
                e = fk.c.g;
            } else
            if (httprequestbase instanceof UnknownHostException)
            {
                e = fk.c.d;
            } else
            if (httprequestbase instanceof SocketTimeoutException)
            {
                e = fk.c.e;
            } else
            if (e == fk.c.a)
            {
                e = fk.c.c;
            } else
            {
                s = f;
            }
            Log.e(f, "Failed to retrieve URI", httprequestbase);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestBase httprequestbase)
        {
            Log.e(f, "Caught runtime exception:", httprequestbase);
        }
        e = fk.c.c;
        return;
    }

    final long a(String s)
    {
        a(((HttpRequestBase) (new HttpGet(s))));
        if (c == null || e != fk.c.b)
        {
            return -1L;
        } else
        {
            return (long)c.getStatusLine().getStatusCode();
        }
    }

    final long a(String s, HttpEntity httpentity)
    {
        s = new HttpPost(s);
        s.setEntity(httpentity);
        a(((HttpRequestBase) (s)));
        if (c == null || e != fk.c.b)
        {
            return -1L;
        } else
        {
            return (long)c.getStatusLine().getStatusCode();
        }
    }

    public final String a()
    {
        if (d != null)
        {
            return (new StringBuilder()).append(d.getURI().getScheme()).append("://").append(d.getURI().getHost()).append(d.getURI().getPath()).toString();
        } else
        {
            return "";
        }
    }

    final void a(Map map)
    {
        if (map != null)
        {
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) 
            {
                String s = (String)iterator.next();
                String s1 = (String)map.get(s);
                b.add(new BasicHeader(s, s1));
            }
        }
    }

    public final String b()
    {
        if (d != null)
        {
            return d.getURI().getHost();
        } else
        {
            return "";
        }
    }

    public final void c()
    {
        String s = f;
        this;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            d.abort();
        }
        this;
        JVM INSTR monitorexit ;
        e = fk.c.h;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final HttpResponse d()
    {
        return c;
    }

    public final void e()
    {
        Object obj;
        if (c != null)
        {
            if ((obj = c.getEntity()) != null)
            {
                try
                {
                    ((HttpEntity) (obj)).consumeContent();
                    return;
                }
                catch (IOException ioexception)
                {
                    ioexception = f;
                }
                return;
            }
        }
    }

    public final fk.c f()
    {
        return e;
    }

}
