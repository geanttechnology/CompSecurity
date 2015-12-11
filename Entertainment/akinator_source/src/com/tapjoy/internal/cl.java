// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

// Referenced classes of package com.tapjoy.internal:
//            ck, ch, i, hr, 
//            ho, hv, ar, cx, 
//            hl, bo, de

public final class cl
    implements ck, Closeable, Cloneable
{

    public final String a;
    public final String b;
    public final int c;
    private int d;
    private boolean e;
    private String f;
    private List g;
    private HttpClient h;

    public cl(String s, String s1, int j)
    {
        d = 443;
        f = "/";
        a = s;
        b = s1;
        c = j;
        g = Collections.synchronizedList(new LinkedList());
        h = AndroidHttpClient.newInstance(s);
        if (g == null)
        {
            g = new LinkedList();
        }
        g.add(new BasicHeader("Accept-Encoding", "gzip"));
    }

    private HttpUriRequest b(ch ch1)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[bi.a.values().length];
                try
                {
                    a[bi.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[bi.a.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[bi.a.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[bi.a.c.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        NameValuePair namevaluepair;
        int j;
        if (e)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0)
        {
            obj = "https";
        } else
        {
            obj = "http";
        }
        if (j != 0)
        {
            j = d;
        } else
        {
            j = c;
        }
        obj2 = ch1.c();
        obj1 = obj2;
        if (f.length() > 0)
        {
            obj1 = obj2;
            if (!((String) (obj2)).startsWith("/"))
            {
                obj1 = (new StringBuilder()).append(f).append(((String) (obj2))).toString();
            }
        }
        obj3 = new i();
        obj2 = (bi.a)ch1.b();
        _cls1.a[((bi.a) (obj2)).ordinal()];
        JVM INSTR tableswitch 1 4: default 140
    //                   1 180
    //                   2 180
    //                   3 266
    //                   4 266;
           goto _L1 _L2 _L2 _L3 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder("Unknown method: ")).append(obj2).toString());
_L2:
        obj = URIUtils.createURI(((String) (obj)), b, j, ((String) (obj1)), URLEncodedUtils.format(((List) (obj3)), "UTF-8"), null);
        if (obj2 == bi.a.a)
        {
            obj = new HttpGet(((java.net.URI) (obj)));
        } else
        {
            obj = new HttpDelete(((java.net.URI) (obj)));
        }
          goto _L4
_L3:
        obj1 = URIUtils.createURI(((String) (obj)), b, j, ((String) (obj1)), null, null);
        obj4 = ch1.d();
        if (obj4 != null) goto _L6; else goto _L5
_L5:
        obj4 = Collections.emptyList();
        if (((List) (obj4)).size() > 0)
        {
            obj = new hr(ho.a, (byte)0);
            for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext();)
            {
                namevaluepair = (NameValuePair)((Iterator) (obj3)).next();
                try
                {
                    ((hr) (obj)).a(namevaluepair.getName(), new hv(namevaluepair.getValue(), "text/plain", ar.c));
                }
                // Misplaced declaration of an exception variable
                catch (ch ch1)
                {
                    throw cx.a(ch1);
                }
            }

            for (obj3 = ((List) (obj4)).iterator(); ((Iterator) (obj3)).hasNext(); ((hr) (obj)).a((hl)((Iterator) (obj3)).next())) { }
        } else
        {
            try
            {
                obj = new UrlEncodedFormEntity(((List) (obj3)), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (ch ch1)
            {
                throw cx.a(ch1);
            }
        }
_L7:
        if (obj2 == bi.a.b)
        {
            obj1 = new HttpPost(((java.net.URI) (obj1)));
            ((HttpPost) (obj1)).setEntity(((HttpEntity) (obj)));
            obj = obj1;
        } else
        {
            obj1 = new HttpPut(((java.net.URI) (obj1)));
            ((HttpPut) (obj1)).setEntity(((HttpEntity) (obj)));
            obj = obj1;
        }
        if (true) goto _L4; else goto _L6
_L6:
        if ("application/json".equals(obj4))
        {
            obj = bo.a(ch1.e());
            try
            {
                obj = new StringEntity(((String) (obj)), "UTF-8");
                ((StringEntity) (obj)).setContentType((new StringBuilder()).append(((String) (obj4))).append("; charset=UTF-8").toString());
            }
            // Misplaced declaration of an exception variable
            catch (ch ch1)
            {
                throw cx.a(ch1);
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Unknown content type: ")).append(((String) (obj4))).toString());
        }
          goto _L7
_L4:
        for (obj1 = g.iterator(); ((Iterator) (obj1)).hasNext(); ((HttpUriRequest) (obj)).addHeader((Header)((Iterator) (obj1)).next())) { }
        for (ch1 = ch1.a().iterator(); ch1.hasNext(); ((HttpUriRequest) (obj)).addHeader((Header)ch1.next())) { }
        return ((HttpUriRequest) (obj));
    }

    public final Object a(ch ch1)
    {
        Object obj;
        HttpEntity httpentity;
        HttpUriRequest httpurirequest;
        httpurirequest = b(ch1);
        obj = h.execute(httpurirequest);
        httpentity = ((HttpResponse) (obj)).getEntity();
        int j;
        obj = ((HttpResponse) (obj)).getStatusLine();
        j = ((StatusLine) (obj)).getStatusCode();
        j;
        JVM INSTR lookupswitch 3: default 163
    //                   200: 105
    //                   201: 105
    //                   409: 105;
           goto _L1 _L2 _L2 _L2
_L1:
        throw new HttpResponseException(j, ((StatusLine) (obj)).getReasonPhrase());
        ch1;
        if (httpentity != null)
        {
            httpentity.consumeContent();
        }
        throw ch1;
_L2:
        obj = new BufferedInputStream(AndroidHttpClient.getUngzippedContent(httpentity));
        ch1 = ((ch) (ch1.a(httpurirequest.getURI(), ((java.io.InputStream) (obj)))));
        de.a(((Closeable) (obj)));
        if (httpentity != null)
        {
            httpentity.consumeContent();
        }
        return ch1;
        ch1;
        obj = null;
_L6:
        if (obj == null) goto _L4; else goto _L3
_L3:
        de.a(((Closeable) (obj)));
_L4:
        throw ch1;
        ch1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(int j)
    {
        d = j;
        e = true;
    }

    public final void a(String s)
    {
        f = s;
    }

    public final Object clone()
    {
        cl cl1 = new cl(a, b, c);
        cl1.d = d;
        cl1.e = e;
        cl1.f = f;
        cl1.g.clear();
        cl1.g.addAll(g);
        return cl1;
    }

    public final void close()
    {
        if (h instanceof AndroidHttpClient)
        {
            ((AndroidHttpClient)h).close();
            h = null;
        }
    }

    protected final void finalize()
    {
        close();
        super.finalize();
    }
}
