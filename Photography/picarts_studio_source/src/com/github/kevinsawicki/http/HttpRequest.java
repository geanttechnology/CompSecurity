// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.github.kevinsawicki.http;

import com.socialin.android.util.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.github.kevinsawicki.http:
//            c, h, f, d, 
//            g

public final class HttpRequest
{

    public static final String a;
    private static c d;
    public boolean b;
    public boolean c;
    private HttpURLConnection e;
    private final URL f;
    private final String g;
    private f h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private long m;
    private long n;
    private h o;

    public HttpRequest(CharSequence charsequence, String s)
    {
        e = null;
        k = true;
        b = false;
        l = 8192;
        m = -1L;
        n = 0L;
        o = h.a;
        c = false;
        try
        {
            f = new URL(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new HttpRequestException(charsequence);
        }
        g = s;
    }

    static int a(HttpRequest httprequest)
    {
        return httprequest.l;
    }

    static long a(HttpRequest httprequest, long l1)
    {
        l1 = httprequest.n + l1;
        httprequest.n = l1;
        return l1;
    }

    private HttpRequest a(InputStream inputstream, OutputStream outputstream)
    {
        return (HttpRequest)(new _cls1(inputstream, k, inputstream, outputstream)).call();
    }

    public static HttpRequest a(CharSequence charsequence)
    {
        return new HttpRequest(charsequence, "POST");
    }

    private HttpRequest a(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("form-data; name=\"").append(s);
        if (s1 != null)
        {
            stringbuilder.append("\"; filename=\"").append(s1);
        }
        stringbuilder.append('"');
        e("Content-Disposition", stringbuilder.toString());
        if (s2 != null)
        {
            e("Content-Type", s2);
        }
        return b("\r\n");
    }

    private HttpRequest a(String s, String s1, String s2, InputStream inputstream)
    {
        try
        {
            l();
            a(s, s1, s2);
            a(inputstream, (OutputStream)h);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return this;
    }

    static String a(String s)
    {
        return b(s);
    }

    static long b(HttpRequest httprequest)
    {
        return httprequest.n;
    }

    private HttpRequest b(String s, String s1, String s2)
    {
        try
        {
            l();
            a(s, ((String) (null)), null);
            h.a(s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return this;
    }

    private static String b(String s)
    {
        if (s != null && s.length() > 0)
        {
            return s;
        } else
        {
            return a;
        }
    }

    static long c(HttpRequest httprequest)
    {
        return httprequest.m;
    }

    private String c(String s)
    {
        int i1 = h();
        ByteArrayOutputStream bytearrayoutputstream;
        if (i1 > 0)
        {
            bytearrayoutputstream = new ByteArrayOutputStream(i1);
        } else
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
        }
        try
        {
            a(new BufferedInputStream(f(), l), bytearrayoutputstream);
            s = bytearrayoutputstream.toString(b(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return s;
    }

    private static String c(String s, String s1)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        int k1 = s.length();
        int i1 = s.indexOf(';') + 1;
        if (i1 == 0 || i1 == k1)
        {
            return null;
        }
        int j1 = s.indexOf(';', i1);
        if (j1 == -1)
        {
            j1 = k1;
        }
        int l1;
        for (; i1 < j1; j1 = l1)
        {
            l1 = s.indexOf('=', i1);
            if (l1 != -1 && l1 < j1 && s1.equals(s.substring(i1, l1).trim()))
            {
                String s2 = s.substring(l1 + 1, j1).trim();
                i1 = s2.length();
                if (i1 != 0)
                {
                    s = s2;
                    if (i1 > 2)
                    {
                        s = s2;
                        if ('"' == s2.charAt(0))
                        {
                            s = s2;
                            if ('"' == s2.charAt(i1 - 1))
                            {
                                return s2.substring(1, i1 - 1);
                            }
                        }
                    }
                    continue; /* Loop/switch isn't completed */
                }
            }
            j1++;
            l1 = s.indexOf(';', j1);
            i1 = l1;
            if (l1 == -1)
            {
                i1 = k1;
            }
            l1 = i1;
            i1 = j1;
        }

        return null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private HttpRequest d(String s, String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            return a("Content-Type", (new StringBuilder()).append(s).append("; charset=").append(s1).toString());
        } else
        {
            return a("Content-Type", s);
        }
    }

    static h d(HttpRequest httprequest)
    {
        return httprequest.o;
    }

    private String d(String s)
    {
        j();
        return a().getHeaderField(s);
    }

    private HttpRequest e(String s, String s1)
    {
        return b(s).b(": ").b(s1).b("\r\n");
    }

    private HttpURLConnection g()
    {
        HttpURLConnection httpurlconnection;
        try
        {
            httpurlconnection = d.a(f);
            httpurlconnection.setRequestMethod(g);
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return httpurlconnection;
    }

    private int h()
    {
        j();
        return a().getHeaderFieldInt("Content-Length", -1);
    }

    private HttpRequest i()
    {
        a(((h) (null)));
        if (h == null)
        {
            return this;
        }
        if (i)
        {
            h.a("\r\n--00content0boundary00--\r\n");
        }
        if (k)
        {
            try
            {
                h.close();
            }
            catch (IOException ioexception) { }
        } else
        {
            h.close();
        }
        h = null;
        return this;
    }

    private HttpRequest j()
    {
        HttpRequest httprequest;
        try
        {
            httprequest = i();
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return httprequest;
    }

    private HttpRequest k()
    {
        if (h != null)
        {
            return this;
        }
        a().setDoOutput(true);
        String s = c(a().getRequestProperty("Content-Type"), "charset");
        if (c)
        {
            h = new d(a().getOutputStream(), s, l);
            return this;
        } else
        {
            h = new g(a().getOutputStream(), s, l);
            return this;
        }
    }

    private HttpRequest l()
    {
        if (!i)
        {
            i = true;
            d("multipart/form-data; boundary=00content0boundary00", null).k();
            h.a("--00content0boundary00\r\n");
            return this;
        } else
        {
            h.a("\r\n--00content0boundary00\r\n");
            return this;
        }
    }

    public final HttpRequest a(h h1)
    {
        if (h1 == null)
        {
            o = h.a;
            return this;
        } else
        {
            o = h1;
            return this;
        }
    }

    public final HttpRequest a(Object obj, Object obj1, String s)
    {
        boolean flag;
        if (!j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            d("application/x-www-form-urlencoded", s);
            j = true;
        }
        s = b(s);
        try
        {
            k();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new HttpRequestException(((IOException) (obj)));
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        ((OutputStream)h).write(38);
        h.a(URLEncoder.encode(obj.toString(), s));
        ((OutputStream)h).write(61);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        h.a(URLEncoder.encode(obj1.toString(), s));
        return this;
    }

    public final HttpRequest a(String s, String s1)
    {
        a().setRequestProperty(s, s1);
        return this;
    }

    public final HttpRequest a(String s, String s1, String s2, File file)
    {
        BufferedInputStream bufferedinputstream;
        try
        {
            bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
            long l1 = file.length();
            if (m == -1L)
            {
                m = 0L;
            }
            m = l1 + m;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpRequestException(s);
        }
        return a(s, s1, s2, ((InputStream) (bufferedinputstream)));
    }

    public final HttpRequest a(Map map)
    {
        if (!map.isEmpty())
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); a((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        return this;
    }

    public final HttpURLConnection a()
    {
        if (e == null)
        {
            e = g();
        }
        return e;
    }

    public final int b()
    {
        int i1;
        try
        {
            i();
            i1 = a().getResponseCode();
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return i1;
    }

    public final HttpRequest b(CharSequence charsequence)
    {
        try
        {
            k();
            h.a(charsequence.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new HttpRequestException(charsequence);
        }
        return this;
    }

    public final HttpRequest b(String s, String s1)
    {
        return b(s, null, s1);
    }

    public final boolean c()
    {
        return 200 == b();
    }

    public final String d()
    {
        String s;
        try
        {
            i();
            s = a().getResponseMessage();
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return s;
    }

    public final String e()
    {
        return c(c(d("Content-Type"), "charset"));
    }

    public final InputStream f()
    {
        if (b() >= 400) goto _L2; else goto _L1
_L1:
        Object obj;
        try
        {
            obj = a().getInputStream();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new HttpRequestException(((IOException) (obj)));
        }
_L4:
        if (!b || !"gzip".equals(d("Content-Encoding")))
        {
            return ((InputStream) (obj));
        }
        break; /* Loop/switch isn't completed */
_L2:
        InputStream inputstream = a().getErrorStream();
        obj = inputstream;
        if (inputstream == null)
        {
            try
            {
                obj = a().getInputStream();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                if (h() > 0)
                {
                    throw new HttpRequestException(((IOException) (obj)));
                }
                obj = new ByteArrayInputStream(new byte[0]);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            obj = new GZIPInputStream(((InputStream) (obj)));
        }
        catch (IOException ioexception)
        {
            throw new HttpRequestException(ioexception);
        }
        return ((InputStream) (obj));
    }

    public final String toString()
    {
        return (new StringBuilder()).append(a().getRequestMethod()).append(' ').append(a().getURL()).toString();
    }

    static 
    {
        a = e.a.name();
        d = c.a;
    }

    /* member class not found */
    class HttpRequestException {}


    /* member class not found */
    class _cls1 {}

}
