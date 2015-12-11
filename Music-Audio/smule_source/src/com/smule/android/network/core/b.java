// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;
import b.b.a.a.a.a.c;
import b.b.a.a.a.a.f;
import b.b.a.a.a.d;
import b.b.a.a.a.g;
import com.crittercism.app.Crittercism;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.c.w;
import com.smule.android.f.a;
import com.smule.android.f.e;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.managers.UserManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.NameValuePair;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.BasicManagedEntity;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.json.JSONObject;

// Referenced classes of package com.smule.android.network.core:
//            c, g, k, l, 
//            r, m, o, e, 
//            v, h, p, j, 
//            s, i, d

public class b
{

    private static final String c = com/smule/android/network/core/b.getName();
    private static String d = null;
    private static String e = null;
    private static final String f;
    private static b n;
    private static Handler o = new Handler(Looper.getMainLooper());
    public long a;
    public AtomicLong b;
    private Context g;
    private com.smule.android.b h;
    private String i;
    private AtomicBoolean j;
    private ScheduledThreadPoolExecutor k;
    private com.smule.android.network.core.e l;
    private com.smule.android.network.core.g m;
    private String p;

    public b()
    {
        k = null;
        l = new com.smule.android.network.core.c();
        m = new com.smule.android.network.core.g();
    }

    private long a(HttpResponse httpresponse)
    {
        long l1 = httpresponse.getStatusLine().toString().length() + 2;
        BasicManagedEntity basicmanagedentity = (BasicManagedEntity)httpresponse.getEntity();
        httpresponse = httpresponse.getAllHeaders();
        int j1 = httpresponse.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            l1 += httpresponse[i1].toString().length() + 2;
        }

        if (basicmanagedentity != null)
        {
            return basicmanagedentity.getContentLength() + 2L + l1;
        } else
        {
            return l1;
        }
    }

    private long a(HttpUriRequest httpurirequest)
    {
        long l1 = httpurirequest.getRequestLine().toString().length() + 2;
        Header aheader[] = httpurirequest.getAllHeaders();
        int j1 = aheader.length;
        for (int i1 = 0; i1 < j1;)
        {
            long l2 = aheader[i1].toString().length() + 2;
            i1++;
            l1 = l2 + l1;
        }

        httpurirequest = httpurirequest.getFirstHeader("Content-Length");
        long l3 = l1;
        if (httpurirequest != null)
        {
            l3 = l1 + (long)(Integer.getInteger(httpurirequest.getValue()).intValue() + 2);
        }
        return l3;
    }

    public static b a()
    {
        com/smule/android/network/core/b;
        JVM INSTR monitorenter ;
        b b1 = n;
        com/smule/android/network/core/b;
        JVM INSTR monitorexit ;
        return b1;
        Exception exception;
        exception;
        throw exception;
    }

    private o a(k k1, String s, Long long1)
    {
        String s1 = null;
        List list = a(s, long1);
        if (k1.c == com.smule.android.network.core.l.a)
        {
            a(k1, list, k1.d);
            s = list;
            long1 = null;
        } else
        if (k1.c == l.b)
        {
            long1 = new ArrayList();
            a(k1, ((List) (long1)), k1.d);
            s = new ArrayList();
            s.addAll(list);
            if (k1.j != null && long1.size() > 0)
            {
                s.add(new BasicNameValuePair("jsonData", a(((List) (long1)))));
            } else
            if (k1.d != null)
            {
                s1 = com.smule.android.f.e.a().writeValueAsString(k1.d);
            } else
            {
                Log.w(c, (new StringBuilder()).append("Empty HTTP body for POST request to ").append(k1.b).toString());
            }
        } else
        {
            s = null;
            long1 = null;
        }
        list.add(new BasicNameValuePair("digest", com.smule.android.network.core.r.a(s, k(), k1.b, 2, s1)));
        return a(k1, list, ((List) (long1)), s1);
    }

    private o a(k k1, List list, List list1, String s)
    {
        if (k1.a != com.smule.android.network.core.m.a && k1.a != m.b)
        {
            throw new InvalidParameterException((new StringBuilder()).append("Unsupported scheme ").append(k1.a).toString());
        }
        break MISSING_BLOCK_LABEL_65;
        int i1;
        try
        {
            throw new InvalidParameterException((new StringBuilder()).append("Unsupported method: ").append(k1.c).toString());
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            Log.e(c, "Couldn't encode UTF-8", k1);
        }
        // Misplaced declaration of an exception variable
        catch (k k1)
        {
            Log.i(c, "Couldn't parse URI", k1);
        }
        return null;
        if (k1.a == com.smule.android.network.core.m.a)
        {
            obj = "http";
        } else
        {
            obj = "https";
        }
        obj1 = d;
        obj2 = k1.b;
        if (list != null) goto _L2; else goto _L1
_L1:
        list = null;
_L6:
        list = URIUtils.createURI(((String) (obj)), ((String) (obj1)), -1, ((String) (obj2)), list, null);
        if (com.smule.android.network.core.l.a != k1.c) goto _L4; else goto _L3
_L3:
        list = new HttpGet(list);
        if (k1.e != null)
        {
            for (list1 = k1.e.entrySet().iterator(); list1.hasNext(); list.addHeader((String)s.getKey(), (String)s.getValue()))
            {
                s = (java.util.Map.Entry)list1.next();
            }

        }
          goto _L5
_L2:
        list = URLEncodedUtils.format(list, "UTF-8");
          goto _L6
_L5:
        l1 = System.currentTimeMillis();
        list1 = a(((HttpUriRequest) (list)), k1.a());
        j1 = list1.getStatusLine().getStatusCode();
        s = list.getURI().toASCIIString();
        k1 = new o(list1, k1.b);
        b(k1);
        l2 = System.currentTimeMillis();
        if (((o) (k1)).b <= 0)
        {
            break MISSING_BLOCK_LABEL_697;
        }
        i1 = ((o) (k1)).b;
_L15:
        w.a(s, l2 - l1, j1, i1, a(((HttpUriRequest) (list))), a(((HttpResponse) (list1))));
        return k1;
_L4:
        if (l.b != k1.c)
        {
            break MISSING_BLOCK_LABEL_666;
        }
        list = new HttpPost(list);
        if (k1.e != null)
        {
            for (obj = k1.e.entrySet().iterator(); ((Iterator) (obj)).hasNext(); list.addHeader((String)((java.util.Map.Entry) (obj1)).getKey(), (String)((java.util.Map.Entry) (obj1)).getValue()))
            {
                obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

        }
        if (k1.j == null) goto _L8; else goto _L7
_L7:
        obj = new g(d.b);
        for (obj1 = k1.j.entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((g) (obj)).a((String)((java.util.Map.Entry) (obj2)).getKey(), (c)((java.util.Map.Entry) (obj2)).getValue()))
        {
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
        }

        if (s == null) goto _L10; else goto _L9
_L9:
        ((g) (obj)).a("", new f(s, "application/json", Charset.forName("UTF-8")));
_L12:
        list.setEntity(((HttpEntity) (obj)));
_L14:
        k1 = new o(a(((HttpUriRequest) (list)), k1.a()), k1.b);
        b(k1);
        return k1;
_L10:
        if (list1 == null) goto _L12; else goto _L11
_L11:
        if (list1.size() <= 0) goto _L12; else goto _L13
_L13:
        ((g) (obj)).a("jsonData", new f(a(list1), "application/json", Charset.forName("UTF-8")));
          goto _L12
_L8:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_648;
        }
        list1 = new StringEntity(s, "UTF-8");
        list1.setContentType("application/json");
        list.setEntity(list1);
          goto _L14
        list.setEntity(new UrlEncodedFormEntity(list1, "UTF-8"));
          goto _L14
        i1 = 0;
          goto _L15
    }

    private String a(String s)
    {
label0:
        {
            String s1;
            if (!s.startsWith((new StringBuilder()).append("http://").append(d).toString()))
            {
                s1 = s;
                if (!s.startsWith((new StringBuilder()).append("https://").append(d).toString()))
                {
                    break label0;
                }
            }
            s1 = s;
            if (!s.contains("session="))
            {
                String s2 = h();
                s1 = s2;
                if (s2 == null)
                {
                    g();
                    String s3 = h();
                    s1 = s3;
                    if (s3 == null)
                    {
                        throw new IOException((new StringBuilder()).append("Failed to connect to smule server ").append(d).toString());
                    }
                }
                if (s.contains("?"))
                {
                    s = (new StringBuilder()).append(s).append("&").toString();
                } else
                {
                    s = (new StringBuilder()).append(s).append("?").toString();
                }
                s1 = (new StringBuilder()).append(s).append("session=").append(URLEncoder.encode(s1, "UTF-8")).toString();
            }
        }
        return s1;
    }

    private static String a(List list)
    {
        HashMap hashmap = new HashMap();
        NameValuePair namevaluepair;
        for (list = list.iterator(); list.hasNext(); hashmap.put(namevaluepair.getName(), namevaluepair.getValue()))
        {
            namevaluepair = (NameValuePair)list.next();
        }

        return (new JSONObject(hashmap)).toString();
    }

    private List a(String s, Long long1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("appVersion", e));
        arraylist.add(new BasicNameValuePair("app", b()));
        arraylist.add(new BasicNameValuePair("appVariant", "1"));
        if (long1 != null)
        {
            arraylist.add(new BasicNameValuePair("msgId", long1.toString()));
        }
        if (s != null)
        {
            arraylist.add(new BasicNameValuePair("session", s));
        }
        return arraylist;
    }

    private Map a(k k1, boolean flag, Map map)
    {
        if (!flag)
        {
            return map;
        }
        HashMap hashmap = new HashMap();
        if (map != null)
        {
            hashmap.putAll(map);
        }
        HashMap hashmap1 = new HashMap();
        hashmap1.put("deviceType", "AND");
        map = d().a(true);
        Map map1;
        Context context;
        if (map != null)
        {
            hashmap1.put("deviceId", map);
        } else
        {
            hashmap1.put("deviceId", d().c());
        }
        hashmap1.put("machine", Build.MODEL);
        hashmap1.put("screenSize", com.smule.android.f.a.a());
        hashmap1.put("manufacturer", Build.MANUFACTURER);
        hashmap1.put("os", android.os.Build.VERSION.RELEASE);
        hashmap1.put("locale", Locale.getDefault().toString());
        hashmap1.put("prefLangs", null);
        context = d().e();
        hashmap1.put("lang", context.getResources().getConfiguration().locale.getLanguage());
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            map = context.getResources().getConfiguration().locale.getScript();
        } else
        {
            map = "?";
        }
        map1 = map;
        if (map.isEmpty())
        {
            map1 = null;
        }
        hashmap1.put("script", map1);
        hashmap1.put("country", context.getResources().getConfiguration().locale.getCountry());
        hashmap1.put("carrierCountry", ((TelephonyManager)context.getSystemService("phone")).getNetworkCountryIso());
        hashmap1.put("hasMail", Boolean.valueOf(true));
        a(k1, "addDeviceParams", ((Map) (hashmap1)));
        hashmap.put("device", hashmap1);
        return hashmap;
    }

    public static Future a(Runnable runnable)
    {
        return a().k.submit(b(runnable));
    }

    public static ScheduledFuture a(Runnable runnable, long l1, long l2, TimeUnit timeunit)
    {
        return a().k.scheduleWithFixedDelay(b(runnable), l1, l2, timeunit);
    }

    public static ScheduledFuture a(Runnable runnable, long l1, TimeUnit timeunit)
    {
        return a().k.schedule(b(runnable), l1, timeunit);
    }

    private HttpResponse a(HttpUriRequest httpurirequest, int i1)
    {
        HttpResponse httpresponse;
        String s1 = httpurirequest.getURI().toASCIIString();
        Log.d(c, (new StringBuilder()).append("Making request to ").append(httpurirequest.getURI().toASCIIString()).toString());
        httpurirequest.setHeader("User-Agent", p);
        httpurirequest.setHeader("Accept-Encoding", "gzip");
        long l1 = System.currentTimeMillis();
        String s;
        Object obj;
        RuntimeException runtimeexception;
        int j1;
        try
        {
            httpresponse = l.a(httpurirequest, i1);
            j1 = httpresponse.getStatusLine().getStatusCode();
        }
        catch (NoHttpResponseException nohttpresponseexception)
        {
            w.a(s1, System.currentTimeMillis() - l1, -102, 0, a(httpurirequest), 0L, nohttpresponseexception.toString());
            throw nohttpresponseexception;
        }
        catch (ConnectTimeoutException connecttimeoutexception)
        {
            w.a(s1, System.currentTimeMillis() - l1, -101, 0, a(httpurirequest), 0L, connecttimeoutexception.toString());
            throw connecttimeoutexception;
        }
        catch (SocketException socketexception)
        {
            w.a(s1, System.currentTimeMillis() - l1, -101, 0, a(httpurirequest), 0L, socketexception.toString());
            throw socketexception;
        }
        catch (IOException ioexception)
        {
            w.a(s1, System.currentTimeMillis() - l1, -100, 0, a(httpurirequest), 0L, ioexception.toString());
            throw ioexception;
        }
        if (j1 == 200) goto _L2; else goto _L1
_L1:
        s = "";
        obj = com.smule.android.network.core.r.a(httpresponse);
        s = ((String) (obj));
_L5:
        Log.e(c, (new StringBuilder()).append("Server Exception: ").append(httpresponse.getStatusLine().getStatusCode()).append(httpresponse.getStatusLine().getReasonPhrase()).append(s).toString());
        obj = new o(s);
        if (((o) (obj)).b <= 0)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        i1 = ((o) (obj)).b;
_L3:
        w.a(s1, System.currentTimeMillis() - l1, j1, i1, a(httpurirequest), 0L);
        throw new v(httpresponse, s);
        runtimeexception;
        Log.d(c, "API Call was canceled");
        continue; /* Loop/switch isn't completed */
        i1 = 0;
          goto _L3
_L2:
        return httpresponse;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static HttpClient a(int i1)
    {
        Object obj = new BasicHttpParams();
        ConnManagerParams.setMaxConnectionsPerRoute(((HttpParams) (obj)), new ConnPerRoute() {

            public int getMaxForRoute(HttpRoute httproute)
            {
                return 10;
            }

        });
        ConnManagerParams.setMaxTotalConnections(((HttpParams) (obj)), 20);
        Object obj1 = new SchemeRegistry();
        ((SchemeRegistry) (obj1)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        ((SchemeRegistry) (obj1)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        obj = new com.smule.android.network.core.h(((HttpParams) (obj)), ((SchemeRegistry) (obj1)));
        obj1 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj1)), i1);
        HttpConnectionParams.setSoTimeout(((HttpParams) (obj1)), i1);
        HttpConnectionParams.setSocketBufferSize(((HttpParams) (obj1)), 8192);
        obj = new DefaultHttpClient(((ClientConnectionManager) (obj)), ((HttpParams) (obj1))) {

            protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy()
            {
                return new i();
            }

        };
        ((DefaultHttpClient) (obj)).setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(0, false));
        ((DefaultHttpClient) (obj)).addResponseInterceptor(new HttpResponseInterceptor() {

            public void process(HttpResponse httpresponse, HttpContext httpcontext)
            {
                httpcontext = httpresponse.getEntity();
                if (httpcontext != null) goto _L2; else goto _L1
_L1:
                Header header;
                return;
_L2:
                if ((header = httpcontext.getContentEncoding()) != null)
                {
                    HeaderElement aheaderelement[] = header.getElements();
                    int k1 = aheaderelement.length;
                    int j1 = 0;
                    while (j1 < k1) 
                    {
                        if (aheaderelement[j1].getName().equalsIgnoreCase("gzip"))
                        {
                            httpresponse.setEntity(new com.smule.android.network.core.d(httpcontext));
                            return;
                        }
                        j1++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

        });
        return ((HttpClient) (obj));
    }

    public static void a(com.smule.android.b b1)
    {
        a(b1, ((com.smule.android.network.core.g) (null)));
    }

    public static void a(com.smule.android.b b1, com.smule.android.network.core.g g1)
    {
        if (n == null)
        {
            n = new b();
            n.g = b1.e();
            n.h = b1;
            n.k = new ScheduledThreadPoolExecutor(3);
            d = b1.g();
            e = b1.h();
            if (g1 != null)
            {
                n.m = g1;
            }
            b1 = n.g.getSharedPreferences("network", 0);
            n.i = b1.getString("session", null);
            n.a = b1.getLong("session_time", 0L);
            n.b = new AtomicLong(b1.getLong("message_id", n.m()) + 100L);
            n.j = new AtomicBoolean(false);
            n.p();
            n.b(true);
        }
    }

    private void a(k k1, List list, Map map)
    {
        if (map == null)
        {
            Log.w(c, "addParams - params to add is null");
        } else
        {
            if (map.size() == 0)
            {
                Log.w(c, "addParams - params to add is empty");
                return;
            }
            a(k1, "addParams(List<NameValuePair> params, Map<String, Object> additional)", map);
            k1 = map.entrySet().iterator();
            while (k1.hasNext()) 
            {
                map = (java.util.Map.Entry)k1.next();
                list.add(new BasicNameValuePair((String)map.getKey(), map.getValue().toString()));
            }
        }
    }

    public static void a(o o1)
    {
        if (o1 != null)
        {
            String s1 = c;
            StringBuilder stringbuilder = (new StringBuilder()).append("unexpected response: ");
            String s;
            if (o1.h != null)
            {
                s = o1.h;
            } else
            {
                StringBuilder stringbuilder1 = (new StringBuilder()).append("empty body string; ");
                if (o1.c != null)
                {
                    s = o1.c;
                } else
                {
                    s = "empty message string";
                }
                s = stringbuilder1.append(s).toString();
            }
            Log.e(s1, stringbuilder.append(s).toString());
            if (o1.c != null)
            {
                a().h.a(o1.c);
            }
        }
    }

    private void a(o o1, String s, long l1, String s1)
    {
        Object obj = o1.i.getFirstHeader("X-Smule-Digest");
        if (obj == null || ((Header) (obj)).getValue() == null)
        {
            s1 = c;
            StringBuilder stringbuilder = (new StringBuilder()).append("Bad server signature. ");
            if (obj == null)
            {
                s = "Header was null.";
            } else
            {
                s = "getValue on header returned null.";
            }
            Log.e(s1, stringbuilder.append(s).toString());
            throw new RuntimeException((new StringBuilder()).append("Bad response signature from server, null header! ").append(o1.i.getStatusLine().getStatusCode()).append(": ").append(o1.i.getStatusLine().getReasonPhrase()).toString());
        }
        String s2 = ((Header) (obj)).getValue();
        obj = com.smule.android.network.core.r.a(k(), s, l1, o1.h, s1);
        if (!s2.equals(obj))
        {
            String s3 = (new StringBuilder()).append("Bad response signature from server!").append("Code: ").append(o1.i.getStatusLine().getStatusCode()).append(": ").append(o1.i.getStatusLine().getReasonPhrase()).toString();
            s = (new StringBuilder()).append(s3).append(" Digest in header: ").append(s2).append(". Computed digest: ").append(((String) (obj))).append(". For API: ").append(s).append(" MsgId: ").append(l1).append(" Session: ").append(s1).append(" Session in response: ").append(o1.g).toString();
            int k1;
            if (o1.h == null)
            {
                s = (new StringBuilder()).append(s).append(" Body null ").toString();
            } else
            if (o1.h.equals(""))
            {
                s = (new StringBuilder()).append(s).append(" Body empty").toString();
            } else
            {
                s = (new StringBuilder()).append(s).append(" Body fine").toString();
            }
            s1 = o1.i.getAllHeaders();
            k1 = s1.length;
            for (int i1 = 0; i1 < k1; i1++)
            {
                Header header = s1[i1];
                s = (new StringBuilder()).append(s).append(" {Header ").append(header.getName()).append(":").append(header.getValue()).toString();
                HeaderElement aheaderelement[] = header.getElements();
                int i2 = aheaderelement.length;
                for (int j1 = 0; j1 < i2; j1++)
                {
                    HeaderElement headerelement = aheaderelement[j1];
                    s = (new StringBuilder()).append(s).append("(").append(headerelement.getName()).append(":").append(headerelement.getValue()).append("), ").toString();
                }

                s = (new StringBuilder()).append(s).append("}, ").toString();
            }

            Log.e(c, (new StringBuilder()).append(s).append(" Body: ").append(o1.h).toString());
            throw new RuntimeException(s);
        } else
        {
            return;
        }
    }

    private boolean a(k k1, String s, Map map)
    {
        Log.d(c, (new StringBuilder()).append("checkMapForNullElements - called from: ").append(s).append(", for API: ").append(k1.b).toString());
        if (map == null)
        {
            Log.d(c, "checkMapForNullElements - map param is null; nothing to check");
            return false;
        }
        Iterator iterator = map.entrySet().iterator();
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            map = (java.util.Map.Entry)iterator.next();
            String s1 = (String)map.getKey();
            Object obj = map.getValue();
            if (s1 == null || obj == null)
            {
                String s2 = c;
                StringBuilder stringbuilder = (new StringBuilder()).append("checkMapForNullElements - null value found from calling source: ").append(s).append(". Key: ");
                boolean flag1;
                if (s1 == null)
                {
                    map = "null";
                } else
                {
                    map = s1;
                }
                stringbuilder = stringbuilder.append(map).append(". Value: ");
                if (obj == null)
                {
                    map = "null";
                } else
                {
                    map = ((Map) (obj));
                }
                Log.e(s2, stringbuilder.append(map).toString());
                flag1 = true;
                if (s1 == null)
                {
                    try
                    {
                        throw new NullPointerException((new StringBuilder()).append("null-param-key-").append(k1.b).toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Map map)
                    {
                        Crittercism.a(map);
                    }
                }
                flag = flag1;
                if (obj == null)
                {
                    try
                    {
                        throw new NullPointerException((new StringBuilder()).append("null-param-value-").append(k1.b).toString());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Map map)
                    {
                        Crittercism.a(map);
                    }
                    flag = flag1;
                }
            }
        } while (true);
        return flag;
    }

    private o b(k k1)
    {
        Object obj;
        if (k1.c != l.b)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj = a(k1, k1.i, k1.d);
_L1:
        o o1;
        k1.d = ((Map) (obj));
        o1 = c(k1);
        obj = o1;
        if (o1.a != com.smule.android.network.core.p.e)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        o1.a = com.smule.android.network.core.p.a;
        return o1;
        obj = k1.d;
          goto _L1
        obj;
        h.p();
        Log.e(c, (new StringBuilder()).append("Unknown host exception when calling ").append(k1.b).append(" : ").toString(), ((Throwable) (obj)));
        k1 = new o(null);
        k1.a = com.smule.android.network.core.p.c;
        return k1;
        obj;
        Log.e(c, (new StringBuilder()).append("Connection timeout exception when calling ").append(k1.b).append(" : ").toString(), ((Throwable) (obj)));
        k1 = new o(null);
        k1.a = p.b;
        return k1;
        obj;
        Log.e(c, (new StringBuilder()).append("Socket timeout exception when calling ").append(k1.b).append(" : ").toString(), ((Throwable) (obj)));
        k1 = new o(null);
        k1.a = p.b;
        return k1;
        obj;
        o o2 = new o(null);
        if (((v) (obj)).a() == 304)
        {
            o2.a = com.smule.android.network.core.p.a;
            o2.b = 304;
            return o2;
        }
        if (((v) (obj)).a() == 543)
        {
            Log.w(c, (new StringBuilder()).append("Server is in maintenance state when calling ").append(k1.b).toString());
            o2.a = com.smule.android.network.core.p.g;
            return o2;
        } else
        {
            Log.e(c, (new StringBuilder()).append("ServerException when calling ").append(k1.b).append(" : ").toString(), ((Throwable) (obj)));
            o2.a = com.smule.android.network.core.p.d;
            return o2;
        }
        obj;
        Log.e(c, (new StringBuilder()).append("Exception when calling ").append(k1.b).append(" : ").toString(), ((Throwable) (obj)));
        obj = new o(null);
        obj.a = com.smule.android.network.core.p.d;
        return ((o) (obj));
    }

    private static Runnable b(Runnable runnable)
    {
        return new Runnable(runnable) {

            final Runnable a;

            public void run()
            {
                try
                {
                    a.run();
                    return;
                }
                catch (Exception exception)
                {
                    Log.e(b.j(), "Uncaught exception in a NETWORK thread!", exception);
                    Crittercism.a("MagicNetwork.wrapRunnable()");
                    Crittercism.a(exception);
                    return;
                }
            }

            
            {
                a = runnable;
                super();
            }
        };
    }

    public static String b()
    {
        return d().b();
    }

    private void b(o o1)
    {
        if (o1.g == null)
        {
            b(false);
            return;
        }
        if (o1.b != 0)
        {
            b(false);
            return;
        }
        String s = h();
        if (o1.g.equals(s))
        {
            b(false);
            return;
        }
        this;
        JVM INSTR monitorenter ;
        i = o1.g;
        b = new AtomicLong(m());
        this;
        JVM INSTR monitorexit ;
        a = System.currentTimeMillis() / 1000L;
        android.content.SharedPreferences.Editor editor = g.getSharedPreferences("network", 0).edit();
        editor.putString("session", o1.g);
        editor.putLong("session_time", a);
        com.smule.android.f.p.a(editor);
        b(true);
        Log.i(c, (new StringBuilder()).append("Session updated to ").append(o1.g).append("/").append(b.get()).toString());
        return;
        o1;
        this;
        JVM INSTR monitorexit ;
        throw o1;
    }

    private void b(boolean flag)
    {
        long l1 = b.get();
        if (!flag && l1 % 5L != 0L)
        {
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = g.getSharedPreferences("network", 0).edit();
            editor.putLong("message_id", l1);
            com.smule.android.f.p.a(editor);
            Log.d(c, (new StringBuilder()).append("persistMessageId - messageId persisted to ").append(l1).toString());
            return;
        }
    }

    private o c(k k1)
    {
        o o1;
        o o2;
        try
        {
            o2 = d(k1);
        }
        catch (v v1)
        {
            if ((new o(v1.a)).b == 51)
            {
                i();
                return d(k1);
            } else
            {
                throw v1;
            }
        }
        o1 = o2;
        if (o2.b == 51)
        {
            i();
            o1 = d(k1);
        }
        return o1;
    }

    public static String c()
    {
        return d;
    }

    private void c(o o1)
    {
        o1 = o1.a("upgradeUrl");
        if (o1 == null || o1.length() == 0)
        {
            Log.e(c, "Upgrade required returned without an upgrade url!");
            return;
        } else
        {
            com.smule.android.f.h.a().a("MagicNetwork.UPGRADE_REQUIRED_EVENT", o1);
            return;
        }
    }

    public static com.smule.android.b d()
    {
        return a().h;
    }

    private o d(k k1)
    {
        a(k1, "callAPINoLogin", k1.d);
        switch (k1.g)
        {
        case 1: // '\001'
        default:
            Log.e(c, (new StringBuilder()).append("Unsupported API version: ").append(k1.g).toString());
            return null;

        case 2: // '\002'
            return f(k1);

        case 0: // '\0'
            return e(k1);
        }
    }

    public static Handler e()
    {
        return o;
    }

    private o e(k k1)
    {
        Object obj;
        ArrayList arraylist;
        if (k1.c == com.smule.android.network.core.l.a)
        {
            arraylist = new ArrayList();
            a(k1, arraylist, k1.d);
            obj = null;
        } else
        if (k1.c == l.b)
        {
            obj = new ArrayList();
            a(k1, ((List) (obj)), k1.d);
            arraylist = null;
        } else
        {
            obj = null;
            arraylist = null;
        }
        return a(k1, arraylist, ((List) (obj)), ((String) (null)));
    }

    private o f(k k1)
    {
        String s;
        Long long1;
        o o1;
        do
        {
            if (k1.f)
            {
                s = h();
            } else
            {
                s = null;
            }
            if (k1.f && s == null)
            {
                g();
                s = h();
            }
            if (k1.f && s == null)
            {
                k1 = new o(null);
                k1.a = com.smule.android.network.core.p.d;
                return k1;
            }
            long1 = Long.valueOf(b.incrementAndGet());
            if (k1.b())
            {
                b(true);
            }
            o1 = a(k1, s, long1);
            if (o1 == null || o1.b != 2001)
            {
                break;
            }
            b.addAndGet(100L);
        } while (true);
        try
        {
            a(o1, k1.b, long1.longValue(), s);
        }
        catch (Exception exception)
        {
            if (com.smule.android.network.core.p.f == o1.a)
            {
                Log.d(c, "Response verification failed because API call was canceled by client action");
                return o1;
            }
            String s1 = (new StringBuilder()).append("Params for ").append(k1.b).append(": {").toString();
            String s2;
            if (k1.d != null && !k1.d.isEmpty())
            {
                Iterator iterator = k1.d.keySet().iterator();
                do
                {
                    s2 = s1;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    s2 = (String)iterator.next();
                    s1 = (new StringBuilder()).append(s1).append("(").append(s2).append(":").append(k1.d.get(s2)).append("), ").toString();
                } while (true);
            } else
            {
                s2 = (new StringBuilder()).append(s1).append("Params were null or empty}").toString();
            }
            Log.d(c, s2);
            return o1;
        }
        return o1;
    }

    static String j()
    {
        return c;
    }

    private static String k()
    {
        return d().f();
    }

    private boolean l()
    {
        return UserManager.n().c() == 0L && m.a;
    }

    private long m()
    {
        return (long)(new SecureRandom()).nextInt(1000);
    }

    private void n()
    {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper())
        {
            throw new RuntimeException("Executing network functions in UI-thread ");
        } else
        {
            return;
        }
    }

    private void o()
    {
        com.smule.android.f.h.a().a("MagicNetwork.SERVER_MAINTENANCE_EVENT", new Object[0]);
    }

    private void p()
    {
        String s;
        try
        {
            s = g.getPackageManager().getPackageInfo(g.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            namenotfoundexception = "unknown";
        }
        p = (new StringBuilder()).append(g.getPackageName()).append("/").append(s).toString();
        p = (new StringBuilder()).append(p).append(" (").append(f).append(",").append(Build.MODEL).append(",").append(Locale.getDefault().toString()).append(")").toString();
    }

    public j a(String s, s s1, int i1)
    {
        HttpResponse httpresponse;
        HttpGet httpget;
        long l1;
        httpget = new HttpGet();
        httpget.setURI(new URI(a(s)));
        l1 = System.currentTimeMillis();
        httpresponse = a(((HttpUriRequest) (httpget)), i1);
        s = httpget.getURI().toASCIIString();
        i1 = httpresponse.getStatusLine().getStatusCode();
        if (i1 == 200)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        s = "";
        s1 = com.smule.android.network.core.r.a(httpresponse, s1);
        s = s1;
_L1:
        try
        {
            throw new v(httpresponse, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(c, "Couldn't parse URI", s);
        }
        return null;
        s1;
        Log.d(c, "API Call was cancelled");
          goto _L1
        w.a(s, System.currentTimeMillis() - l1, i1, 0, a(((HttpUriRequest) (httpget))), a(httpresponse));
        s = new j();
        s.a = httpget;
        s.b = httpresponse;
        s.c = httpresponse.getEntity().getContent();
        if (!httpresponse.containsHeader("Content-Length"))
        {
            break MISSING_BLOCK_LABEL_241;
        }
        s1 = httpresponse.getFirstHeader("Content-Length");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        s.d = Long.parseLong(s1.getValue());
        return s;
        s1;
        s.d = -1L;
        return s;
        s.d = -1L;
        return s;
        s.d = -1L;
        return s;
    }

    public o a(k k1)
    {
        o o1;
        o o2;
        o2 = null;
        o1 = null;
        if (k1.g != 1) goto _L2; else goto _L1
_L1:
        Log.e(c, "V1 API call support has been removed!");
_L4:
        return o1;
_L2:
        if (k1.g == 0)
        {
            Log.e(c, "V0 API call support will be removed!");
        }
        n();
        int i1 = k1.h + 1;
        o1 = o2;
        do
        {
            int j1;
            do
            {
                if (i1 <= 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                o2 = b(k1);
                j1 = i1 - 1;
                o1 = o2;
                i1 = j1;
            } while (o2.a == p.b);
            o1 = o2;
            i1 = j1;
        } while (o2.a == com.smule.android.network.core.p.c);
        if (o2.a == com.smule.android.network.core.p.g)
        {
            o();
            return o2;
        }
        o1 = o2;
        if (o2.b == 2000)
        {
            c(o2);
            return o2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (flag) goto _L2; else goto _L1
_L1:
        String s = h();
        if (s == null) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        j.set(true);
        if (!UserManager.n().h())
        {
            break; /* Loop/switch isn't completed */
        }
        UserManager.n().p();
_L5:
        j.set(false);
        if (true) goto _L3; else goto _L4
        Exception exception;
        exception;
        throw exception;
_L4:
        UserManager.n().a(l());
          goto _L5
        exception;
        j.set(false);
        throw exception;
    }

    public boolean f()
    {
        return j.get();
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        a(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String h()
    {
        this;
        JVM INSTR monitorenter ;
        String s = i;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public void i()
    {
        if (j.get())
        {
            break MISSING_BLOCK_LABEL_25;
        }
        this;
        JVM INSTR monitorenter ;
        i = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        f = android.os.Build.VERSION.RELEASE;
    }
}
