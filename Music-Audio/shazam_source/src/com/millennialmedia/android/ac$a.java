// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.millennialmedia.android:
//            ac, an, ab, v, 
//            al, ag, w, r, 
//            VideoAd, a, InterstitialAd, ao, 
//            HttpMMHeaders

private final class <init>
    implements Runnable
{

    HttpMMHeaders a;
    String b;
    final ac c;

    private static void a(HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getHeaders("Set-Cookie");
        int j = httpresponse.length;
        for (int i = 0; i < j; i++)
        {
            String s = httpresponse[i].getValue();
            int k = s.indexOf("MAC-ID=");
            if (k < 0)
            {
                continue;
            }
            int l = s.indexOf(';', k);
            if (l > k)
            {
                an.e = s.substring(k + 7, l);
            }
        }

    }

    private boolean a()
    {
        b = null;
        Object obj;
        Object obj1;
        Object obj2;
        if (c.c != null)
        {
            obj = (ab)c.c.get();
        } else
        {
            obj = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        try
        {
            obj2 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            ((ab) (obj)).a(((Map) (obj2)));
            an.a(((ab) (obj)).j(), ((Map) (obj2)));
            obj = (ab)((ab) (obj)).l.c.get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return a(new ag(((Exception) (obj))));
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((ab) (obj)).j() == null) goto _L4; else goto _L5
_L5:
        obj = System.getProperty("http.agent");
_L7:
        obj1 = obj;
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            obj1 = Build.MODEL;
        }
        ((Map) (obj2)).put("ua", obj1);
        obj = new StringBuilder(v.a());
        ((Map) (obj2)).entrySet().toString();
        al.b();
        for (obj1 = ((Map) (obj2)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append(String.format("%s=%s&", new Object[] {
    ((java.util.ntry) (obj2)).getKey(), URLEncoder.encode((String)((java.util.ntry) (obj2)).getValue(), "UTF-8")
})))
        {
            obj2 = (java.util.ntry)((Iterator) (obj1)).next();
        }

        ((StringBuilder) (obj)).delete(((StringBuilder) (obj)).length() - 1, ((StringBuilder) (obj)).length());
        b = ((StringBuilder) (obj)).toString();
        String.format("Calling for an advertisement: %s", new Object[] {
            b
        });
        al.b();
        break; /* Loop/switch isn't completed */
_L2:
        b(new ag(25));
        break; /* Loop/switch isn't completed */
_L4:
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
        return true;
    }

    private boolean a(ag ag1)
    {
        al.a("MMAdImplController", ag1.getMessage());
        return c(ag1);
    }

    private boolean a(HttpEntity httpentity)
    {
        ab ab1;
        if (c.c != null)
        {
            ab1 = (ab)c.c.get();
        } else
        {
            ab1 = null;
        }
        if (ab1 != null)
        {
            if (ab1.q())
            {
                return a(new ag("Millennial ad return unsupported format.", 15));
            }
            try
            {
                httpentity = (VideoAd)r.a(w.a(httpentity.getContent()));
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                httpentity.printStackTrace();
                return b(new ag("Millennial ad return failed. Invalid response data.", httpentity));
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                httpentity.printStackTrace();
                return b(new ag((new StringBuilder("Millennial ad return failed. ")).append(httpentity).toString(), httpentity));
            }
            if (httpentity != null && httpentity.b())
            {
                (new StringBuilder("Cached video ad JSON received: ")).append(((r) (httpentity)).a);
                al.c();
                if (httpentity.a())
                {
                    al.c();
                    httpentity.b(ab1.j());
                    a(ab1, new ag(15));
                } else
                if (com.millennialmedia.android.a.c(ab1.j(), ab1.k()) != null)
                {
                    al.c();
                    httpentity.b(ab1.j());
                    a(ab1, new ag(17));
                } else
                {
                    com.millennialmedia.android.a.a(ab1.j(), httpentity);
                    if (!httpentity.c(ab1.j()))
                    {
                        a(((VideoAd) (httpentity)).m);
                        al.b();
                        b(ab1);
                        httpentity.f = 3;
                        com.millennialmedia.android.a.a(ab1.j(), ab1.k(), httpentity, ab1.l);
                    } else
                    {
                        al.b();
                        com.millennialmedia.android.a.a(ab1.j(), ab1.k(), ((r) (httpentity)).a);
                        b(ab1);
                        f(ab1);
                    }
                }
            }
        }
        return true;
    }

    private boolean b(ag ag1)
    {
        ag1.getMessage();
        al.c();
        return c(ag1);
    }

    private boolean b(HttpEntity httpentity)
    {
        ab ab1 = null;
        Object obj;
        HttpMMHeaders httpmmheaders;
        try
        {
            if (c.c != null)
            {
                ab1 = (ab)c.c.get();
            }
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            return a(new ag((new StringBuilder("Exception raised in HTTP stream: ")).append(httpentity).toString(), httpentity));
        }
        if (ab1 == null)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        if (!ab1.q())
        {
            obj = new InterstitialAd();
            obj.h = w.a(httpentity.getContent());
            obj.a = ab1.f;
            obj.i = b;
            obj.j = a;
            if (an.a >= 5)
            {
                String.format("Received interstitial ad with url %s.", new Object[] {
                    ((InterstitialAd) (obj)).i
                });
                al.a();
                httpentity = ((InterstitialAd) (obj)).h;
                al.a();
            }
            com.millennialmedia.android.a.a(ab1.j(), ((r) (obj)));
            com.millennialmedia.android.a.a(ab1.j(), ab1.k(), ((r) (obj)).a);
            b(ab1);
            f(ab1);
            break MISSING_BLOCK_LABEL_245;
        }
        if (ab1.l != null)
        {
            obj = ab1.l;
            httpmmheaders = a;
            if (((ac) (obj)).b != null)
            {
                ((ac) (obj)).b.n = httpmmheaders;
            }
            ab1.l.a(w.a(httpentity.getContent()), b);
        }
        f(ab1);
        return true;
    }

    private boolean c(ag ag1)
    {
        ab ab1 = null;
        if (c.c != null)
        {
            ab1 = (ab)c.c.get();
        }
        a(ab1, ag1);
        return false;
    }

    public final void run()
    {
        if (c.c == null) goto _L2; else goto _L1
_L1:
        Object obj = (ab)c.c.get();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (!an.a(((ab) (obj)).j())) goto _L4; else goto _L5
_L5:
        boolean flag1 = a();
        if (!flag1)
        {
            c.d = null;
            return;
        }
        obj = (new w()).a(b);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        a(new ag("HTTP response is null.", 14));
        c.d = null;
        return;
        obj;
        a(new ag((new StringBuilder("Ad request HTTP error. ")).append(((Exception) (obj)).getMessage()).toString(), 14));
        c.d = null;
        return;
        HttpEntity httpentity = ((HttpResponse) (obj)).getEntity();
        if (httpentity != null) goto _L7; else goto _L6
_L6:
        b(new ag("Null HTTP entity", 14));
        boolean flag = false;
_L24:
        if (!flag)
        {
            c.d = null;
            return;
        }
          goto _L2
_L7:
        if (httpentity.getContentLength() != 0L)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        b(new ag("Millennial ad return failed. Zero content length returned.", 14));
        flag = false;
        continue; /* Loop/switch isn't completed */
        Header header;
        a(((HttpResponse) (obj)));
        header = httpentity.getContentType();
        if (header == null) goto _L9; else goto _L8
_L8:
        if (header.getValue() == null) goto _L9; else goto _L10
_L10:
        if (!header.getValue().toLowerCase().startsWith("application/json")) goto _L12; else goto _L11
_L11:
        a(httpentity);
          goto _L13
_L12:
        if (!header.getValue().toLowerCase().startsWith("text/html")) goto _L15; else goto _L14
_L14:
        header = ((HttpResponse) (obj)).getFirstHeader("X-MM-Video");
        a = new HttpMMHeaders(((HttpResponse) (obj)).getAllHeaders());
        if (header == null) goto _L17; else goto _L16
_L16:
        if (!header.getValue().equalsIgnoreCase("true")) goto _L17; else goto _L18
_L18:
        if (c.c == null) goto _L20; else goto _L19
_L19:
        obj = (ab)c.c.get();
_L22:
        if (obj == null) goto _L17; else goto _L21
_L21:
        android.content.Context context = ((ab) (obj)).j();
        v.a(context).a(context, ((ab) (obj)).f);
_L17:
        b(httpentity);
        break; /* Loop/switch isn't completed */
        obj;
        b(new ag("Request not filled, can't call for ads.", 14));
        c.d = null;
        return;
_L15:
        b(new ag("Millennial ad return failed. Invalid (JSON/HTML expected) mime type returned.", 15));
        flag = false;
        continue; /* Loop/switch isn't completed */
_L9:
        b(new ag("Millennial ad return failed. HTTP Header value null.", 15));
        flag = false;
        continue; /* Loop/switch isn't completed */
_L4:
        b(new ag("No network available, can't call for ads.", 11));
        c.d = null;
        return;
_L2:
        c.d = null;
        return;
        obj;
        c.d = null;
        throw obj;
_L20:
        obj = null;
        if (true) goto _L22; else goto _L13
_L13:
        flag = true;
        if (true) goto _L24; else goto _L23
_L23:
    }

    private ion(ac ac1)
    {
        c = ac1;
        super();
    }

    c(ac ac1, byte byte0)
    {
        this(ac1);
    }
}
