// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.asyncnet;

import android.text.TextUtils;
import com.github.kevinsawicki.http.HttpRequest;
import com.socialin.android.apiv3.model.parsers.IStreamParser;
import com.socialin.android.apiv3.model.parsers.StringParser;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import com.socialin.android.util.al;
import com.socialin.android.util.e;
import com.socialin.asyncnet.cache.CacheManager;
import com.socialin.asyncnet.cache.a;
import com.socialin.asyncnet.cache.b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.socialin.asyncnet:
//            f, h, e, g, 
//            c

public class Request
{

    private static final String l = com/socialin/asyncnet/Request.getSimpleName();
    private static f m = new f();
    private static int u = 0;
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public a g;
    protected h h;
    public boolean i;
    public boolean j;
    c k;
    private int n;
    private String o;
    private HashMap p;
    private HashMap q;
    private ArrayList r;
    private HashMap s;
    private IStreamParser t;
    private ArrayList v;

    public Request(String s1)
    {
        this(s1, null);
    }

    public Request(String s1, IStreamParser istreamparser)
    {
        this(s1, istreamparser, "GET");
    }

    public Request(String s1, IStreamParser istreamparser, String s2)
    {
        this(s1, istreamparser, s2, 5);
    }

    public Request(String s1, IStreamParser istreamparser, String s2, int i1)
    {
        a = "";
        b = "";
        n = 0;
        c = 0;
        o = "GET";
        d = 0;
        e = 60000;
        f = 60000;
        h = new h();
        i = false;
        j = false;
        a = s1;
        b = s1;
        o = s2;
        t = istreamparser;
        if (t == null)
        {
            t = StringParser.instance();
        }
        int j1 = u + 1;
        u = j1;
        d = j1;
        g = new a(i1);
        g.c = istreamparser;
    }

    static c a(Request request)
    {
        return request.k;
    }

    private static String a(String s1, Map map)
    {
        String s2;
label0:
        {
            s2 = a(map);
            map = s1;
            if (!TextUtils.isEmpty(s2))
            {
                if (!s1.contains("?"))
                {
                    break label0;
                }
                map = (new StringBuilder(s1)).append('&').append(s2).toString();
            }
            return map;
        }
        return (new StringBuilder(s1)).append('?').append(s2).toString();
    }

    private static String a(Map map)
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        if (map == null || map.isEmpty())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        stringbuilder = new StringBuilder();
        iterator = map.keySet().iterator();
_L2:
        String s1;
        String s2;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)iterator.next();
        s2 = (String)map.get(s1);
        if (s1 != null && s2 != null)
        {
            try
            {
                stringbuilder.append(s1).append('=').append(URLEncoder.encode(s2, e.a.name()));
                if (iterator.hasNext())
                {
                    stringbuilder.append('&');
                }
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                com.socialin.android.d.b(l, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(map.getMessage()).toString()
                });
                return null;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
        return stringbuilder.toString();
        return null;
    }

    public final void a(int i1)
    {
        g.a = i1;
    }

    public final void a(long l1)
    {
        g.f.b = l1;
    }

    public final void a(String s1)
    {
        if (v == null)
        {
            v = new ArrayList();
        }
        v.add(s1);
    }

    public final void a(String s1, String s2)
    {
        if (s == null)
        {
            s = new HashMap();
        }
        s.put(s1, s2);
    }

    public final void a(String s1, String s2, String s3, File file)
    {
        if (s == null)
        {
            s = new HashMap();
        }
        com.socialin.asyncnet.e e1 = new com.socialin.asyncnet.e((byte)0);
        e1.a = s2;
        e1.b = s3;
        e1.c = file;
        s.put(s1, e1);
    }

    public final boolean a()
    {
        return h.a();
    }

    public final void b()
    {
        h.b = true;
    }

    public final void b(String s1, String s2)
    {
        if (p == null)
        {
            p = new HashMap();
        }
        p.put(s1, s2);
    }

    public final void c()
    {
        h.a = true;
    }

    public final void c(String s1, String s2)
    {
        if (q == null)
        {
            q = new HashMap();
        }
        q.put(s1, s2);
    }

    public final Object d()
    {
_L23:
        Object obj;
        obj = a;
        if (n > 0)
        {
            obj = b;
        }
        if (!o.equals("GET")) goto _L2; else goto _L1
_L1:
        obj = a(((String) (obj)), p);
_L18:
        if (!h.a()) goto _L4; else goto _L3
_L3:
        Object obj1;
        h h1;
        Object obj3;
        int i1;
        h1 = h;
        obj1 = o;
        obj3 = String.valueOf(d);
        i1 = n;
        if (!h1.a()) goto _L4; else goto _L5
_L5:
        h1.c = System.currentTimeMillis();
        if (i1 != 0) goto _L7; else goto _L6
_L6:
        h1.d = h1.c;
        long l1 = h1.d;
        Object obj4 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l1);
        obj4 = ((DateFormat) (obj4)).format(calendar.getTime());
        obj1 = (new StringBuilder("\nStart, time:")).append(((String) (obj4))).append(" \nurl:").append(((String) (obj))).append(" \nmethod:").append(((String) (obj1))).append(" \nid:").append(((String) (obj3))).toString();
_L19:
        h1.b(((String) (obj1)));
_L4:
        if (g == null || g.a == 5 || !o.equals("GET")) goto _L9; else goto _L8
_L8:
        g.b = al.a(((String) (obj)));
        if (g.a != 2) goto _L11; else goto _L10
_L10:
        obj1 = CacheManager.a().b(g);
        if (!h.a()) goto _L13; else goto _L12
_L12:
        h1 = h;
        if (!h.a)
        {
            break MISSING_BLOCK_LABEL_1588;
        }
        obj = obj1.toString();
_L39:
        h1.a(((String) (obj)));
_L13:
        if (obj1 == null) goto _L15; else goto _L14
_L14:
        h.c();
        return obj1;
_L2:
        if (!o.equals("POST")) goto _L17; else goto _L16
_L16:
        if (p != null)
        {
            if (s == null || s.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_357;
            }
            obj = a(((String) (obj)), p);
        }
          goto _L18
        p.containsKey("path");
          goto _L18
_L7:
        obj1 = (new StringBuilder("\nRetry, url:")).append(((String) (obj))).append(" \nmethod:").append(((String) (obj1))).append(" \nid:").append(((String) (obj3))).append("\nretry_count:").append(i1).toString();
          goto _L19
_L15:
        throw new RequestException(new FileNotFoundException("cached file not found"), "cached file not found");
        obj1;
        if (g.a == 2) goto _L21; else goto _L20
_L20:
        int k1;
        i1 = c;
        k1 = n;
        n = k1 + 1;
        if (i1 <= k1) goto _L21; else goto _L22
_L22:
        if (h.a())
        {
            Object obj2 = h;
            h h3;
            int j1;
            if (TextUtils.isEmpty(((Exception) (obj1)).getMessage()))
            {
                obj = Utils.a(((Throwable) (obj1)));
            } else
            {
                obj = ((Exception) (obj1)).getMessage();
            }
            ((h) (obj2)).a(((String) (obj)), false);
        }
        Thread.sleep(n * 2);
          goto _L23
_L11:
        if (g == null || g.a != 4) goto _L9; else goto _L24
_L24:
        obj1 = CacheManager.a().b(g);
        if (d.b)
        {
            h.a(null);
        }
        if (obj1 == null) goto _L9; else goto _L25
_L25:
        h.c();
        return obj1;
_L9:
        obj1 = new HttpRequest(((CharSequence) (obj)), o);
        obj1.c = j;
        if (((HttpRequest) (obj1)).c)
        {
            ((HttpRequest) (obj1)).a("Content-Encoding", "gzip");
        }
        ((HttpRequest) (obj1)).a(new _cls1());
        obj = ((HttpRequest) (obj1)).a("Accept-Encoding", "gzip");
        obj.b = true;
        j1 = f;
        ((HttpRequest) (obj)).a().setReadTimeout(j1);
        j1 = e;
        ((HttpRequest) (obj)).a().setConnectTimeout(j1);
        if (q != null)
        {
            ((HttpRequest) (obj1)).a(q);
        }
        if (r != null && r.size() > 0)
        {
            obj = ((HttpRequest) (obj1)).a();
            if (r != null)
            {
                for (obj2 = r.iterator(); ((Iterator) (obj2)).hasNext(); ((HttpURLConnection) (obj)).addRequestProperty((String)((java.util.Map.Entry) (obj3)).getKey(), (String)((java.util.Map.Entry) (obj3)).getValue()))
                {
                    obj3 = (java.util.Map.Entry)((Iterator) (obj2)).next();
                }

            }
        }
          goto _L26
        obj;
_L38:
        throw new RequestException(((Exception) (obj)), (new StringBuilder("Error on openning input stream. \nResponse code : ")).append(((HttpRequest) (obj1)).b()).append(" \nresponseMsg: ").append(((HttpRequest) (obj1)).d()).toString());
        obj;
        throw obj;
_L26:
        if (s == null || s.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_958;
        }
        obj = s.keySet().iterator();
_L29:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_1203;
        }
        obj2 = (String)((Iterator) (obj)).next();
        obj3 = s.get(obj2);
        if (!(obj3 instanceof com.socialin.asyncnet.e)) goto _L28; else goto _L27
_L27:
        obj3 = (com.socialin.asyncnet.e)obj3;
        ((HttpRequest) (obj1)).a(((String) (obj2)), ((com.socialin.asyncnet.e) (obj3)).a, ((com.socialin.asyncnet.e) (obj3)).b, ((com.socialin.asyncnet.e) (obj3)).c);
          goto _L29
_L28:
        if (!(obj3 instanceof String) || obj3 == null) goto _L29; else goto _L30
_L30:
        ((HttpRequest) (obj1)).b(((String) (obj2)), (String)obj3);
          goto _L29
        if (!o.equals("POST") || p == null || !p.containsKey("path"))
        {
            break MISSING_BLOCK_LABEL_1115;
        }
        obj = new File((String)p.get("path"));
        obj2 = (String)p.get("type");
        ((HttpRequest) (obj1)).a("file", ((File) (obj)).getName(), ((String) (obj2)), ((File) (obj)));
        obj = p.keySet().iterator();
_L32:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_1203;
            }
            obj2 = (String)((Iterator) (obj)).next();
            obj3 = (String)p.get(obj2);
        } while (obj3 == null || obj2 == null);
        if (((String) (obj2)).equals("path")) goto _L32; else goto _L31
_L31:
        ((HttpRequest) (obj1)).b(((String) (obj2)), ((String) (obj3)));
          goto _L32
        if (p == null || !o.equals("POST"))
        {
            break MISSING_BLOCK_LABEL_1203;
        }
        obj = p.keySet().iterator();
_L33:
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_1203;
            }
            obj2 = (String)((Iterator) (obj)).next();
            obj3 = (String)p.get(obj2);
        } while (obj3 == null || obj2 == null);
        ((HttpRequest) (obj1)).a(obj2, obj3, HttpRequest.a);
          goto _L33
        if (v != null && v.size() > 0)
        {
            for (obj = v.iterator(); ((Iterator) (obj)).hasNext(); ((HttpRequest) (obj1)).b((String)((Iterator) (obj)).next())) { }
        }
        obj = new BufferedInputStream(((HttpRequest) (obj1)).f());
        obj3 = t.parse(((java.io.InputStream) (obj)));
        if (!h.a()) goto _L35; else goto _L34
_L34:
        h3 = h;
        if (!h.a)
        {
            break MISSING_BLOCK_LABEL_1482;
        }
        obj = obj3.toString();
_L37:
        if (!h3.a()) goto _L35; else goto _L36
_L36:
        h3.e = System.currentTimeMillis();
        obj1 = com.socialin.asyncnet.h.a(h3.c, h3.e);
        obj2 = (new StringBuilder("\nReceived result and parsed in: ")).append(((String) (obj1))).append(" seconds").toString();
        obj1 = obj2;
        if (h3.a)
        {
            obj1 = (new StringBuilder()).append(((String) (obj2))).append("\nResult:  ").append(((String) (obj))).toString();
        }
        h3.b(((String) (obj1)));
_L35:
        if (g.a != 5 && g != null && o.equals("GET"))
        {
            g.d = obj3;
            h h2;
            if (i)
            {
                (new _cls2()).start();
            } else
            {
                CacheManager.a().a(g);
                if (h.a())
                {
                    h.b();
                }
            }
        }
        if (h.a())
        {
            h.c();
            return obj3;
        } else
        {
            return obj3;
        }
        obj = null;
          goto _L37
_L21:
        if (h.a())
        {
            h2 = h;
            if (TextUtils.isEmpty(((Exception) (obj1)).getMessage()))
            {
                obj = Utils.a(((Throwable) (obj1)));
            } else
            {
                obj = ((Exception) (obj1)).getMessage();
            }
            h2.a(((String) (obj)), true);
        }
        throw obj1;
        obj;
        obj1 = null;
        if (true) goto _L38; else goto _L17
_L17:
        obj = null;
          goto _L18
        obj = null;
          goto _L39
    }

    public final void d(String s1, String s2)
    {
        if (r == null)
        {
            r = new ArrayList();
        }
        r.add(new g(s1, s2));
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            System.setProperty("http.keepAlive", "false");
        }
    }

    /* member class not found */
    class RequestException {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
