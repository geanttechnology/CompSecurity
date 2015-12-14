// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;

import android.content.Context;
import com.facebook.ads.internal.dto.f;
import com.facebook.ads.internal.e;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.facebook.ads.internal.thirdparty.http:
//            g, e, p, m, 
//            q, l, n, i, 
//            d, c, k, o, 
//            j, b, f

public class a
{

    private static int g[] = new int[20];
    private static final String h = com/facebook/ads/internal/thirdparty/http/a.getSimpleName();
    protected final p a;
    protected final d b;
    protected String c;
    protected q d;
    protected int e;
    protected int f;
    private int i;
    private Map j;
    private boolean k;

    public a()
    {
        this("");
    }

    public a(Context context)
    {
        this(context, ((e) (null)));
    }

    public a(Context context, e e1)
    {
        this();
        a("user-agent", (new StringBuilder()).append(com.facebook.ads.internal.util.h.a(context, e1)).append(" [").append("FBAN/AudienceNetworkForAndroid;").append("FBSN/").append("Android").append(";").append("FBSV/").append(f.a).append(";").append("FBAB/").append(f.d).append(";").append("FBAV/").append(f.f).append(";").append("FBBV/").append(f.g).append(";").append("FBLC/").append(Locale.getDefault().toString()).append("]").toString());
        if (com.facebook.ads.internal.util.g.a())
        {
            com.facebook.ads.internal.util.g.b();
        }
    }

    public a(d d1, String s)
    {
        this(d1, s, ((p) (new com.facebook.ads.internal.thirdparty.http.f() {

        })));
    }

    public a(d d1, String s, p p1)
    {
        c = "";
        d = new com.facebook.ads.internal.thirdparty.http.g();
        e = 2000;
        f = 8000;
        i = 3;
        j = new TreeMap();
        c = s;
        a = p1;
        b = d1;
    }

    public a(String s)
    {
        this(((d) (new com.facebook.ads.internal.thirdparty.http.e())), s);
    }

    public static void a()
    {
        if (CookieHandler.getDefault() == null)
        {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private static void c()
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void c(HttpURLConnection httpurlconnection)
    {
        String s;
        for (Iterator iterator = j.keySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty(s, (String)j.get(s)))
        {
            s = (String)iterator.next();
        }

    }

    protected int a(int i1)
    {
        return g[i1 + 2] * 1000;
    }

    protected int a(HttpURLConnection httpurlconnection, byte abyte0[])
    {
        OutputStream outputstream = null;
        OutputStream outputstream1 = a.a(httpurlconnection);
        if (outputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        outputstream = outputstream1;
        a.a(outputstream1, abyte0);
        outputstream = outputstream1;
        int i1 = httpurlconnection.getResponseCode();
        if (outputstream1 != null)
        {
            try
            {
                outputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                return i1;
            }
        }
        return i1;
        httpurlconnection;
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
        }
        throw httpurlconnection;
    }

    public a a(String s, String s1)
    {
        j.put(s, s1);
        return this;
    }

    public n a(l l1)
    {
        int i1;
        long l3;
        i1 = 0;
        l3 = System.currentTimeMillis();
_L3:
        if (i1 >= i) goto _L2; else goto _L1
_L1:
        long l2 = l3;
        c(a(i1));
        l2 = l3;
        if (!d.a())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        l2 = l3;
        d.a((new StringBuilder()).append(i1 + 1).append("of").append(i).append(", trying ").append(l1.a()).toString());
        l2 = l3;
        l3 = System.currentTimeMillis();
        l2 = l3;
        n n1 = a(l1.a(), l1.b(), l1.c(), l1.d());
        l2 = l3;
        if (n1 != null)
        {
            return n1;
        }
        break MISSING_BLOCK_LABEL_164;
        m m1;
        m1;
        if (!a(((Throwable) (m1)), l2) || i1 >= i - 1)
        {
            if (a.a(m1) && i1 < i - 1)
            {
                try
                {
                    Thread.sleep(e);
                }
                // Misplaced declaration of an exception variable
                catch (l l1)
                {
                    throw m1;
                }
            } else
            {
                throw m1;
            }
        }
        i1++;
        l3 = l2;
          goto _L3
_L2:
        return null;
    }

    protected n a(String s, j j1, String s1, byte abyte0[])
    {
        Object obj = null;
        HttpURLConnection httpurlconnection;
        k = false;
        httpurlconnection = a(s);
        a(httpurlconnection, j1, s1);
        c(httpurlconnection);
        if (d.a())
        {
            d.a(httpurlconnection, abyte0);
        }
        httpurlconnection.connect();
        k = true;
        if (!httpurlconnection.getDoOutput() || abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        a(httpurlconnection, abyte0);
        if (!httpurlconnection.getDoInput()) goto _L2; else goto _L1
_L1:
        s = a(httpurlconnection);
_L3:
        if (d.a())
        {
            d.a(s);
        }
        s1 = s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
            s1 = s;
        }
_L5:
        return s1;
_L2:
        s = new n(httpurlconnection, null);
          goto _L3
        s1;
        s = httpurlconnection;
_L7:
        j1 = b(s);
        if (j1 == null)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        int i1 = j1.a();
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        if (d.a())
        {
            d.a(j1);
        }
        s1 = j1;
        if (s == null) goto _L5; else goto _L4
_L4:
        s.disconnect();
        return j1;
        throw new m(s1, j1);
        abyte0;
        s1 = s;
        s = abyte0;
        abyte0 = j1;
        j1 = s1;
        s1 = abyte0;
_L6:
        if (d.a())
        {
            d.a(s1);
        }
        if (j1 != null)
        {
            j1.disconnect();
        }
        throw s;
        j1;
        s1.printStackTrace();
        if (true)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        throw new NullPointerException();
        throw new m(s1, null);
        j1;
        if (true)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        throw new NullPointerException();
        throw new m(s1, null);
        s;
        j1 = null;
        s1 = obj;
          goto _L6
        s;
        s1 = obj;
        j1 = httpurlconnection;
          goto _L6
        s1;
        s = null;
          goto _L7
        s1;
        j1 = s;
        s = s1;
        s1 = obj;
          goto _L6
    }

    public n a(String s, o o1)
    {
        return b(new i(s, o1));
    }

    protected n a(HttpURLConnection httpurlconnection)
    {
        byte abyte0[] = null;
        InputStream inputstream = a.b(httpurlconnection);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        abyte0 = a.a(inputstream);
        httpurlconnection = new n(httpurlconnection, abyte0);
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception)
            {
                return httpurlconnection;
            }
        }
        return httpurlconnection;
        httpurlconnection;
        inputstream = null;
_L2:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception1) { }
        }
        throw httpurlconnection;
        httpurlconnection;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected HttpURLConnection a(String s)
    {
        s = (new StringBuilder()).append(c).append(s).toString();
        try
        {
            new URL(s);
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(" is not a valid URL").toString(), malformedurlexception);
        }
        return a.a(s);
    }

    protected void a(l l1, b b1)
    {
        b.a(this, b1).a(l1);
    }

    public void a(String s, o o1, b b1)
    {
        a(((l) (new k(s, o1))), b1);
    }

    protected void a(HttpURLConnection httpurlconnection, j j1, String s)
    {
        httpurlconnection.setConnectTimeout(e);
        httpurlconnection.setReadTimeout(f);
        a.a(httpurlconnection, j1, s);
    }

    protected boolean a(Throwable throwable, long l1)
    {
        l1 = (System.currentTimeMillis() - l1) + 10L;
        if (d.a())
        {
            d.a((new StringBuilder()).append("ELAPSED TIME = ").append(l1).append(", CT = ").append(e).append(", RT = ").append(f).toString());
        }
        if (!k) goto _L2; else goto _L1
_L1:
        if (l1 < (long)f) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (l1 < (long)e)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public n b(l l1)
    {
        try
        {
            l1 = a(l1.a(), l1.b(), l1.c(), l1.d());
        }
        // Misplaced declaration of an exception variable
        catch (l l1)
        {
            a.a(l1);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (l l1)
        {
            a.a(new m(l1, null));
            return null;
        }
        return l1;
    }

    public n b(String s, o o1)
    {
        return b(((l) (new k(s, o1))));
    }

    protected n b(HttpURLConnection httpurlconnection)
    {
        byte abyte0[] = null;
        InputStream inputstream = httpurlconnection.getErrorStream();
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        abyte0 = a.a(inputstream);
        httpurlconnection = new n(httpurlconnection, abyte0);
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception)
            {
                return httpurlconnection;
            }
        }
        return httpurlconnection;
        httpurlconnection;
        inputstream = null;
_L2:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (Exception exception1) { }
        }
        throw httpurlconnection;
        httpurlconnection;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public o b()
    {
        return new o();
    }

    public void b(int i1)
    {
        if (i1 < 1 || i1 > 18)
        {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        } else
        {
            i = i1;
            return;
        }
    }

    public void c(int i1)
    {
        e = i1;
    }

    static 
    {
        c();
        if (android.os.Build.VERSION.SDK_INT > 8)
        {
            a();
        }
    }
}
