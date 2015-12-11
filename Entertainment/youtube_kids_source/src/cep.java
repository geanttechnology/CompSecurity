// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.message.BasicNameValuePair;

public final class cep
    implements cfa
{

    private final HttpClient a;
    private final HttpClient b;
    private final cej c = new cej();
    private final cho d;
    private final Uri e;
    private final Uri f;
    private final chq g;
    private final Map h;
    private final Map i;
    private volatile String j;
    private int k;
    private String l;
    private int m;
    private int n;
    private HttpResponse o;

    public cep(String s, cho cho1, Map map, Map map1, HttpClient httpclient, HttpClient httpclient1, chq chq1)
    {
        boolean flag1 = false;
        super();
        m = 0;
        e = Uri.parse(s);
        f = Uri.parse(s.replace("bind", "test"));
        boolean flag = flag1;
        if (e != null)
        {
            flag = flag1;
            if ("https".equalsIgnoreCase(e.getScheme()))
            {
                flag = true;
            }
        }
        b.a(flag);
        i = (Map)b.a(map1);
        h = (Map)b.a(map);
        d = cho1;
        n = 1;
        a = httpclient;
        b = httpclient1;
        g = chq1;
    }

    private String a(InputStream inputstream)
    {
        byte abyte0[] = new byte[256];
        int i1 = inputstream.read(abyte0);
        if (i1 <= 0)
        {
            g.b("Unexpected test response: no data for chunk.");
            return "";
        } else
        {
            return new String(abyte0, 0, i1, "UTF-8");
        }
    }

    private static List a(Map map)
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return arraylist;
    }

    private HttpResponse a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = e.buildUpon().appendQueryParameter("RID", String.valueOf(n)).appendQueryParameter("VER", "8").appendQueryParameter("CVER", "1");
        if (j != null)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("SID", j);
        }
        if (l != null)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("gsessionid", l);
        }
        obj = new HttpPost(((android.net.Uri.Builder) (obj)).build().toString());
        a(((HttpRequest) (obj)));
        ((HttpPost) (obj)).setEntity(new UrlEncodedFormEntity(list));
        list = b.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        if (list.getStatusLine().getStatusCode() == 200)
        {
            n = n + 1;
        }
        this;
        JVM INSTR monitorexit ;
        return list;
        list;
        throw list;
    }

    private void a(HttpRequest httprequest)
    {
        Object obj = d.a();
        if (obj != null)
        {
            obj = String.valueOf(obj);
            java.util.Map.Entry entry;
            if (((String) (obj)).length() != 0)
            {
                obj = "Bearer ".concat(((String) (obj)));
            } else
            {
                obj = new String("Bearer ");
            }
            httprequest.setHeader("Authorization", ((String) (obj)));
        }
        obj = d.b();
        if (obj != null)
        {
            httprequest.setHeader("X-Goog-PageId", ((String) (obj)));
        }
        for (obj = i.entrySet().iterator(); ((Iterator) (obj)).hasNext(); httprequest.setHeader((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

    }

    public final int a(cgl cgl1, cgo cgo1)
    {
        Object obj;
        HttpResponse httpresponse;
        Object obj1;
        HttpResponse httpresponse1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        httpresponse1 = null;
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        int i1 = m;
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        m = i1 + 1;
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        ArrayList arraylist = new ArrayList();
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        arraylist.add(new BasicNameValuePair("count", "1"));
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        arraylist.add(new BasicNameValuePair(String.format("req%s__sc", new Object[] {
            String.valueOf(i1)
        }), cgl1.toString()));
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        Iterator iterator = cgo1.iterator();
_L2:
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        cgq cgq1 = (cgq)iterator.next();
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        arraylist.add(new BasicNameValuePair(String.format("req%s_%s", new Object[] {
            String.valueOf(i1), cgq1.a
        }), cgq1.b));
        if (true) goto _L2; else goto _L1
        obj1;
        obj = httpresponse;
        g.c("Exception while sending message: %s(%s), %s", new Object[] {
            cgl1, cgo1, ((ClientProtocolException) (obj1)).getMessage()
        });
        a.a(httpresponse);
        return 505;
_L1:
        httpresponse = httpresponse1;
        obj1 = obj2;
        obj = obj3;
        httpresponse1 = a(((List) (arraylist)));
        httpresponse = httpresponse1;
        obj1 = httpresponse1;
        obj = httpresponse1;
        i1 = httpresponse1.getStatusLine().getStatusCode();
        a.a(httpresponse1);
        return i1;
        IOException ioexception;
        ioexception;
        obj = obj1;
        g.c("Exception while sending message: %s(%s), %s", new Object[] {
            cgl1, cgo1, ioexception.getMessage()
        });
        a.a(((HttpResponse) (obj1)));
        return 500;
        cgl1;
        a.a(((HttpResponse) (obj)));
        throw cgl1;
    }

    public final void a()
    {
        Object obj = a(a(h));
        int i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        cej cej1 = c;
        cej.a(i1);
        if (i1 == 200)
        {
            obj = (new BasicResponseHandler()).handleResponse(((HttpResponse) (obj)));
            c.a(((String) (obj)).toCharArray());
        }
    }

    public final void a(int i1)
    {
        k = i1;
    }

    public final void a(cfb cfb)
    {
        c.a = new cel(this, cfb, g);
    }

    public final void a(String s)
    {
        j = s;
    }

    public final void a(boolean flag)
    {
        if (!flag)
        {
            b.b();
        }
        Object obj1 = e.buildUpon().appendQueryParameter("RID", "rpc").appendQueryParameter("SID", j).appendQueryParameter("AID", String.valueOf(k));
        Object obj;
        char ac[];
        int i1;
        if (flag)
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        obj = ((android.net.Uri.Builder) (obj1)).appendQueryParameter("CI", ((String) (obj))).appendQueryParameter("TYPE", "xmlhttp");
        if (l != null)
        {
            ((android.net.Uri.Builder) (obj)).appendQueryParameter("gsessionid", l);
        }
        obj = ((android.net.Uri.Builder) (obj)).build().toString();
        obj1 = g;
        obj1 = String.valueOf(obj);
        if (((String) (obj1)).length() != 0)
        {
            "Get URL: ".concat(((String) (obj1)));
        } else
        {
            new String("Get URL: ");
        }
        obj = new HttpGet(((String) (obj)));
        a(((HttpRequest) (obj)));
        if (o != null)
        {
            a.a(o);
            o = null;
        }
        o = a.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        obj = c;
        cej.a(o.getStatusLine().getStatusCode());
        obj = o.getEntity().getContent();
        ac = new byte[2048];
        i1 = ((InputStream) (obj)).read(ac);
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_314;
        }
        obj1 = c;
        ac = (new String(ac, 0, i1, "UTF-8")).toCharArray();
        ((cej) (obj1)).a(ac);
        break MISSING_BLOCK_LABEL_205;
        obj;
        if (o != null)
        {
            a.a(o);
            o = null;
        }
        throw obj;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        throw new IllegalStateException("This application needs UTF-8 support in order to run");
        chq chq1 = g;
        if (o != null)
        {
            a.a(o);
            o = null;
        }
        return;
    }

    public final void a(boolean flag, boolean flag1)
    {
        Object obj;
        obj = new HashMap();
        ((Map) (obj)).put("TYPE", "terminate");
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        ((Map) (obj)).put("ui", "");
        obj = a(a(((Map) (obj))));
        a.a(((HttpResponse) (obj)));
_L3:
        j = null;
        if (o != null)
        {
            a.a(o);
            o = null;
        }
        return;
        Object obj1;
        obj1;
        chq chq1;
        chq1 = g;
        obj1 = String.valueOf(((Exception) (obj1)).getMessage());
        if (((String) (obj1)).length() == 0)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        obj1 = "Terminate request failed: ".concat(((String) (obj1)));
_L1:
        chq1.b(((String) (obj1)));
        a.a(null);
        continue; /* Loop/switch isn't completed */
        obj1 = new String("Terminate request failed: ");
          goto _L1
        obj1;
        a.a(null);
        throw obj1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void b(String s)
    {
        l = s;
    }

    public final boolean b()
    {
        Object obj;
        Object obj1;
        InputStream inputstream;
        boolean flag = false;
        obj = f.buildUpon().appendQueryParameter("VER", "8").appendQueryParameter("TYPE", "xmlhttp").build().toString();
        obj1 = g;
        obj1 = String.valueOf(obj);
        long l1;
        long l2;
        if (((String) (obj1)).length() != 0)
        {
            "Test request: ".concat(((String) (obj1)));
        } else
        {
            new String("Test request: ");
        }
        obj = new HttpGet(((String) (obj)));
        obj1 = a.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        inputstream = ((HttpResponse) (obj1)).getEntity().getContent();
        obj = a(inputstream);
        if (!"11111".equals(obj))
        {
            break MISSING_BLOCK_LABEL_172;
        }
        l1 = System.currentTimeMillis();
        obj = a(inputstream);
        if (!"2".equals(obj))
        {
            break MISSING_BLOCK_LABEL_241;
        }
        l2 = System.currentTimeMillis();
        if (l2 - l1 < 200L)
        {
            flag = true;
        }
        a.a(((HttpResponse) (obj1)));
        inputstream.close();
        return flag;
        chq chq1;
        chq1 = g;
        obj = String.valueOf(obj);
        if (((String) (obj)).length() == 0)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj = "Unexpected test response, wrong chunk 1: ".concat(((String) (obj)));
_L1:
        chq1.b(((String) (obj)));
        a.a(((HttpResponse) (obj1)));
        inputstream.close();
        return false;
        obj = new String("Unexpected test response, wrong chunk 1: ");
          goto _L1
        obj;
        a.a(((HttpResponse) (obj1)));
        inputstream.close();
        throw obj;
        chq1 = g;
        obj = String.valueOf(obj);
        if (((String) (obj)).length() == 0)
        {
            break MISSING_BLOCK_LABEL_285;
        }
        obj = "Unexpected test response, wrong chunk 2: ".concat(((String) (obj)));
_L2:
        chq1.b(((String) (obj)));
        a.a(((HttpResponse) (obj1)));
        inputstream.close();
        return false;
        obj = new String("Unexpected test response, wrong chunk 2: ");
          goto _L2
    }

    public final String toString()
    {
        String s = j;
        String s1 = l;
        return (new StringBuilder(String.valueOf(s).length() + 33 + String.valueOf(s1).length())).append("Session id: ").append(s).append(" GFE Session cookie: ").append(s1).toString();
    }
}
