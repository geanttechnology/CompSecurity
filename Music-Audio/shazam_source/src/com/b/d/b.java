// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.d;

import com.b.b.e;
import com.b.e.c;
import com.b.e.k;
import com.b.e.n;
import com.b.e.o;
import com.b.e.p;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;

public final class b
{

    public static final boolean a;
    public com.b.a.b b;
    public n c;
    protected URL d;
    protected Proxy e;
    private com.b.c.b f;

    public b(com.b.a.b b1, com.b.c.b b2)
    {
        b = b1;
        c = b1.b;
        f = b2;
        d = a(f.b());
    }

    private HttpURLConnection a(URL url)
    {
        if (e != null)
        {
            return (HttpURLConnection)url.openConnection(e);
        } else
        {
            return (HttpURLConnection)url.openConnection();
        }
    }

    private URL a(String s)
    {
        c();
        String s1 = s.concat(f.a(b.al));
        if (s1.length() > 4096 && s1.indexOf("&") > 0)
        {
            int i = s1.substring(0, 4088).lastIndexOf("&");
            try
            {
                s = URLEncoder.encode(s1.substring(i + 1), "UTF-8").replace("+", "%20");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = "0";
            }
            s = (new StringBuilder()).append(s1.substring(0, i)).append("&ns_cut=").append(s).toString();
        } else
        {
            s = s1;
        }
        if (s.length() > 4096)
        {
            s = s.substring(0, 4096);
        }
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private boolean d()
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = obj;
        Object obj2 = d;
        obj1 = obj;
        if (!a) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj = a(((URL) (obj2)));
        obj2 = obj;
        obj1 = obj;
        int i = ((HttpURLConnection) (obj)).getResponseCode();
_L13:
        obj2 = obj;
        obj1 = obj;
        String s = ((HttpURLConnection) (obj)).getHeaderField("Content-Type");
        obj2 = obj;
        obj1 = obj;
        String s1 = ((HttpURLConnection) (obj)).getHeaderField("Content-Length");
        if (i != 200) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        obj1 = obj;
        if (!p.f(s)) goto _L4; else goto _L5
_L5:
        obj2 = obj;
        obj1 = obj;
        if (s.indexOf("image/") != 0) goto _L4; else goto _L6
_L6:
        obj2 = obj;
        obj1 = obj;
        if (!p.f(s1)) goto _L4; else goto _L7
_L7:
        obj2 = obj;
        obj1 = obj;
        if (Integer.parseInt(s1) > 0) goto _L8; else goto _L4
_L4:
        if (i != 204) goto _L10; else goto _L9
_L9:
        obj2 = obj;
        obj1 = obj;
        if (!p.f(s1)) goto _L10; else goto _L11
_L11:
        obj2 = obj;
        obj1 = obj;
        i = Integer.parseInt(s1);
        if (i != 0) goto _L10; else goto _L8
_L8:
        obj2 = obj;
        b.c.a();
        boolean flag = true;
_L28:
        boolean flag1;
        flag1 = flag;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
            flag1 = flag;
        }
_L23:
        return flag1;
_L2:
        int j;
        j = 0;
        i = 0;
        obj = null;
        obj1 = obj2;
_L30:
        if (obj1 == null || j >= 5) goto _L13; else goto _L12
_L12:
        obj2 = a(((URL) (obj1)));
        obj = obj2;
        int i1;
        ((HttpURLConnection) (obj)).setInstanceFollowRedirects(false);
        i1 = ((HttpURLConnection) (obj)).getResponseCode();
        obj2 = ((HttpURLConnection) (obj)).getHeaderField("Location");
        i1;
        JVM INSTR tableswitch 300 305: default 579
    //                   300 272
    //                   301 272
    //                   302 272
    //                   303 272
    //                   304 579
    //                   305 272;
           goto _L14 _L15 _L15 _L15 _L15 _L14 _L15
_L15:
        if (obj2 == null) goto _L14; else goto _L16
_L16:
        if (i1 != 305) goto _L18; else goto _L17
_L17:
        if (!((String) (obj2)).startsWith((new StringBuilder()).append(((URL) (obj1)).getProtocol()).append(':').toString())) goto _L20; else goto _L19
_L19:
        i = ((URL) (obj1)).getProtocol().length() + 1;
_L29:
        int l = i;
        if (((String) (obj2)).startsWith("//", i))
        {
            l = i + 2;
        }
        obj2 = ((String) (obj2)).substring(l);
        i = ((String) (obj2)).indexOf(':');
        if (i == -1) goto _L22; else goto _L21
_L21:
        s = ((String) (obj2)).substring(0, i);
        i = Integer.parseInt(((String) (obj2)).substring(i + 1));
        obj2 = s;
_L24:
        e = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(((String) (obj2)), i));
        break MISSING_BLOCK_LABEL_581;
        Exception exception;
        exception;
        flag = false;
_L27:
        obj2 = obj;
        com.b.e.c.a(this, (new StringBuilder("Exception sending measurement:")).append(exception.getLocalizedMessage()).toString());
        obj2 = obj;
        com.b.e.c.a(exception);
        flag1 = flag;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
            return flag;
        }
          goto _L23
_L22:
        i = 80;
          goto _L24
_L18:
        obj2 = new URL(((URL) (obj1)), ((String) (obj2)));
        flag = ((URL) (obj1)).getProtocol().equals(((URL) (obj2)).getProtocol());
        if (flag)
        {
            obj1 = obj2;
            break MISSING_BLOCK_LABEL_581;
        }
          goto _L14
        obj1;
        obj = null;
_L26:
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw obj1;
        obj1;
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L26; else goto _L25
_L25:
        exception;
        flag = false;
        obj = obj1;
          goto _L27
        exception;
        flag = false;
          goto _L27
        exception;
        flag = true;
          goto _L27
_L10:
        flag = false;
          goto _L28
_L20:
        i = 0;
          goto _L29
_L14:
        obj1 = null;
        j++;
        i = i1;
          goto _L30
    }

    public final boolean a()
    {
        o o1 = b.ak;
        if (o1 == o.a || o1 == o.c && com.b.e.e.b(b.ab) || o1 == o.d)
        {
            b.a.b();
        }
        boolean flag = d();
        if (!flag)
        {
            b();
        }
        return flag;
    }

    public final void b()
    {
        com.b.e.c.a(this, (new StringBuilder("Measurement was not transmitted: ")).append(f.a(b.al)).toString());
        b.a.a(f, false);
    }

    public final Boolean c()
    {
        Object obj;
        boolean flag;
        try
        {
            obj = b.ab;
        }
        catch (NullPointerException nullpointerexception)
        {
            return Boolean.valueOf(false);
        }
        flag = true;
        if (!com.b.e.e.b()) goto _L2; else goto _L1
_L1:
        obj = "emu";
_L4:
        f.b("ns_radio", ((String) (obj)));
        return Boolean.valueOf(flag);
_L2:
        if (com.b.e.e.b(((android.content.Context) (obj))))
        {
            obj = "wifi";
            continue; /* Loop/switch isn't completed */
        }
        if (com.b.e.e.c(((android.content.Context) (obj))))
        {
            obj = "wwan";
            continue; /* Loop/switch isn't completed */
        }
        if (com.b.e.e.e(((android.content.Context) (obj))))
        {
            obj = "bth";
            continue; /* Loop/switch isn't completed */
        }
        if (com.b.e.e.d(((android.content.Context) (obj))))
        {
            obj = "eth";
        } else
        {
            obj = "unknown";
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        boolean flag;
        if (i < 11 || i > 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
