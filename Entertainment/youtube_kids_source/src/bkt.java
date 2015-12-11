// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.EventLog;
import android.util.Log;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public final class bkt
    implements HttpClient
{

    private final HttpClient a;
    private final ContentResolver b;
    private final String c;
    private final ThreadLocal d = new ThreadLocal();

    public bkt(Context context, HttpClient httpclient, String s)
    {
        a = httpclient;
        b = context.getContentResolver();
        c = s;
        httpclient = getConnectionManager().getSchemeRegistry();
        s = httpclient.getSchemeNames().iterator();
        while (s.hasNext()) 
        {
            String s1 = (String)s.next();
            Scheme scheme = httpclient.unregister(s1);
            context = scheme.getSocketFactory();
            if (context instanceof LayeredSocketFactory)
            {
                context = new bku(this, (LayeredSocketFactory)context);
            } else
            {
                context = new bkv(this, context);
            }
            httpclient.register(new Scheme(s1, context, scheme.getDefaultPort()));
        }
    }

    static ThreadLocal a(bkt bkt1)
    {
        return bkt1.d;
    }

    private HttpResponse a(HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        long l = SystemClock.elapsedRealtime();
        d.set(null);
        if (!bcf.a(b, "http_stats", false)) goto _L2; else goto _L1
_L1:
        int i;
        long l1;
        long l3;
        i = Process.myUid();
        l1 = TrafficStats.getUidTxBytes(i);
        l3 = TrafficStats.getUidRxBytes(i);
        httpcontext = a.execute(httpurirequest, httpcontext);
        if (httpcontext != null) goto _L4; else goto _L3
_L3:
        httpurirequest = null;
_L5:
        if (httpurirequest == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        long l4 = SystemClock.elapsedRealtime();
        httpcontext.setEntity(new amz(httpurirequest, c, i, l1, l3, l4 - l, l4));
        break MISSING_BLOCK_LABEL_297;
_L6:
        int k = httpurirequest.getStatusLine().getStatusCode();
        l1 = SystemClock.elapsedRealtime();
        int j;
        if (d.get() == null && k >= 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        try
        {
            EventLog.writeEvent(0x318fa, new Object[] {
                Long.valueOf(l1 - l), Integer.valueOf(k), c, Integer.valueOf(j)
            });
        }
        // Misplaced declaration of an exception variable
        catch (HttpContext httpcontext)
        {
            Log.e("GoogleHttpClient", "Error recording stats", httpcontext);
            return httpurirequest;
        }
        return httpurirequest;
_L4:
        httpurirequest = httpcontext.getEntity();
          goto _L5
_L2:
        httpurirequest = a.execute(httpurirequest, httpcontext);
          goto _L6
        httpurirequest;
        try
        {
            long l2 = SystemClock.elapsedRealtime();
            if (d.get() != null);
            EventLog.writeEvent(0x318fa, new Object[] {
                Long.valueOf(l2 - l), Integer.valueOf(-1), c, Integer.valueOf(0)
            });
        }
        // Misplaced declaration of an exception variable
        catch (HttpContext httpcontext)
        {
            Log.e("GoogleHttpClient", "Error recording stats", httpcontext);
        }
        throw httpurirequest;
        httpurirequest = httpcontext;
          goto _L6
    }

    private static RequestWrapper a(HttpUriRequest httpurirequest)
    {
        if (!(httpurirequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        httpurirequest = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)httpurirequest);
_L1:
        httpurirequest.resetHeaders();
        return httpurirequest;
        try
        {
            httpurirequest = new RequestWrapper(httpurirequest);
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            throw new ClientProtocolException(httpurirequest);
        }
          goto _L1
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
    {
        return a.execute(httphost, httprequest, responsehandler);
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        return a.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
    {
        return a.execute(httpurirequest, responsehandler);
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        return a.execute(httpurirequest, responsehandler, httpcontext);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
    {
        return a.execute(httphost, httprequest);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
    {
        return a.execute(httphost, httprequest, httpcontext);
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest)
    {
        return execute(httpurirequest, ((HttpContext) (null)));
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        Object obj = httpurirequest.getURI().toString();
        anc anc1 = anb.a(b).a(((String) (obj)));
        String s = anc1.a(((String) (obj)));
        if (s == null)
        {
            httpurirequest = String.valueOf(anc1.a);
            Log.w("GoogleHttpClient", (new StringBuilder(String.valueOf(httpurirequest).length() + 13 + String.valueOf(obj).length())).append("Blocked by ").append(httpurirequest).append(": ").append(((String) (obj))).toString());
            throw new arv(anc1);
        }
        if (s.equals(obj))
        {
            return a(httpurirequest, httpcontext);
        }
        try
        {
            obj = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (HttpContext httpcontext)
        {
            httpurirequest = String.valueOf(anc1.a);
            if (httpurirequest.length() != 0)
            {
                httpurirequest = "Bad URL from rule: ".concat(httpurirequest);
            } else
            {
                httpurirequest = new String("Bad URL from rule: ");
            }
            throw new RuntimeException(httpurirequest, httpcontext);
        }
        httpurirequest = a(httpurirequest);
        httpurirequest.setURI(((URI) (obj)));
        return a(httpurirequest, httpcontext);
    }

    public final ClientConnectionManager getConnectionManager()
    {
        return a.getConnectionManager();
    }

    public final HttpParams getParams()
    {
        return a.getParams();
    }
}
