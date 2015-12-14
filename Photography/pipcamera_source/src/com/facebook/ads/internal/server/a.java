// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.server;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.AdErrorType;
import com.facebook.ads.internal.b;
import com.facebook.ads.internal.dto.c;
import com.facebook.ads.internal.dto.d;
import com.facebook.ads.internal.dto.e;
import com.facebook.ads.internal.dto.f;
import com.facebook.ads.internal.thirdparty.http.m;
import com.facebook.ads.internal.thirdparty.http.n;
import com.facebook.ads.internal.thirdparty.http.o;
import com.facebook.ads.internal.util.AdInternalSettings;
import com.facebook.ads.internal.util.p;
import com.facebook.ads.internal.util.r;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;

// Referenced classes of package com.facebook.ads.internal.server:
//            b, c, d, e

public class a
{

    private static final p g;
    private static final ThreadPoolExecutor h;
    Map a;
    private final com.facebook.ads.internal.server.b b = com.facebook.ads.internal.server.b.a();
    private a c;
    private e d;
    private com.facebook.ads.internal.thirdparty.http.a e;
    private final String f;

    public a()
    {
        String s = AdSettings.getUrlPrefix();
        if (AdInternalSettings.shouldUseLiveRailEndpoint())
        {
            if (r.a(s))
            {
                s = "https://ad6.liverail.com/";
            } else
            {
                s = String.format("https://ad6.%s.liverail.com/", new Object[] {
                    s
                });
            }
            f = s;
            return;
        }
        if (r.a(s))
        {
            s = "https://graph.facebook.com/network_ads_common/";
        } else
        {
            s = String.format("https://graph.%s.facebook.com/network_ads_common/", new Object[] {
                s
            });
        }
        f = s;
    }

    static com.facebook.ads.internal.thirdparty.http.a a(a a1, com.facebook.ads.internal.thirdparty.http.a a2)
    {
        a1.e = a2;
        return a2;
    }

    static String a(a a1)
    {
        return a1.f;
    }

    private void a(b b1)
    {
        if (c != null)
        {
            c.a(b1);
        }
        a();
    }

    static void a(com.facebook.ads.internal.server.a a1, b b1)
    {
        a1.a(b1);
    }

    static void a(com.facebook.ads.internal.server.a a1, String s)
    {
        a1.a(s);
    }

    private void a(com.facebook.ads.internal.server.d d1)
    {
        if (c != null)
        {
            c.a(d1);
        }
        a();
    }

    private void a(String s)
    {
        Object obj;
        class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.ads.internal.server.c.a.values().length];
                try
                {
                    a[com.facebook.ads.internal.server.c.a.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.facebook.ads.internal.server.c.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        c c1;
        try
        {
            obj = b.a(s);
            c1 = ((com.facebook.ads.internal.server.c) (obj)).b();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            a(AdErrorType.PARSER_FAILURE.getAdErrorWrapper(s.getMessage()));
            return;
        }
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        com.facebook.ads.internal.util.d.a(c1.a().c(), d);
        _cls3.a[((com.facebook.ads.internal.server.c) (obj)).a().ordinal()];
        JVM INSTR tableswitch 1 2: default 162
    //                   1 76
    //                   2 125;
           goto _L1 _L2 _L3
_L1:
        a(AdErrorType.UNKNOWN_RESPONSE.getAdErrorWrapper(s));
        return;
_L2:
        obj = (com.facebook.ads.internal.server.d)obj;
        if (c1 == null) goto _L5; else goto _L4
_L4:
        if (c1.a().d())
        {
            com.facebook.ads.internal.util.d.a(s, d);
        }
_L5:
        a(((com.facebook.ads.internal.server.d) (obj)));
        return;
_L3:
        String s1;
        obj = (com.facebook.ads.internal.server.e)obj;
        s1 = ((com.facebook.ads.internal.server.e) (obj)).c();
        obj = AdErrorType.adErrorTypeFromCode(((com.facebook.ads.internal.server.e) (obj)).d(), AdErrorType.ERROR_MESSAGE);
        if (s1 != null)
        {
            s = s1;
        }
        a(((AdErrorType) (obj)).getAdErrorWrapper(s));
        return;
    }

    private boolean a(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0)
        {
            return true;
        }
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean flag;
        if (context != null && context.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    static com.facebook.ads.internal.thirdparty.http.a b(com.facebook.ads.internal.server.a a1)
    {
        return a1.e;
    }

    private com.facebook.ads.internal.thirdparty.http.b b()
    {
        return new com.facebook.ads.internal.thirdparty.http.b() {

            final com.facebook.ads.internal.server.a a;

            public void a(m m1)
            {
                com.facebook.ads.internal.util.d.b(com.facebook.ads.internal.server.a.d(a));
                com.facebook.ads.internal.server.a.a(a, null);
                Object obj = m1.a();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                Object obj1;
                Object obj2;
                com.facebook.ads.internal.server.a a1;
                obj = ((n) (obj)).e();
                obj1 = com.facebook.ads.internal.server.a.e(a).a(((String) (obj)));
                if (((com.facebook.ads.internal.server.c) (obj1)).a() != com.facebook.ads.internal.server.c.a.b)
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                obj2 = (com.facebook.ads.internal.server.e)obj1;
                obj1 = ((com.facebook.ads.internal.server.e) (obj2)).c();
                obj2 = AdErrorType.adErrorTypeFromCode(((com.facebook.ads.internal.server.e) (obj2)).d(), AdErrorType.ERROR_MESSAGE);
                a1 = a;
                if (obj1 != null)
                {
                    obj = obj1;
                }
                try
                {
                    com.facebook.ads.internal.server.a.a(a1, ((AdErrorType) (obj2)).getAdErrorWrapper(((String) (obj))));
                    return;
                }
                catch (JSONException jsonexception) { }
                com.facebook.ads.internal.server.a.a(a, new b(AdErrorType.NETWORK_ERROR, m1.getMessage()));
                return;
            }

            public void a(n n1)
            {
                if (n1 != null)
                {
                    n1 = n1.e();
                    com.facebook.ads.internal.util.d.b(com.facebook.ads.internal.server.a.d(a));
                    com.facebook.ads.internal.server.a.a(a, null);
                    com.facebook.ads.internal.server.a.a(a, n1);
                }
            }

            public void a(Exception exception)
            {
                if (com/facebook/ads/internal/thirdparty/http/m.equals(exception.getClass()))
                {
                    a((m)exception);
                    return;
                } else
                {
                    com.facebook.ads.internal.server.a.a(a, new b(AdErrorType.NETWORK_ERROR, exception.getMessage()));
                    return;
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    static com.facebook.ads.internal.thirdparty.http.b c(com.facebook.ads.internal.server.a a1)
    {
        return a1.b();
    }

    static e d(com.facebook.ads.internal.server.a a1)
    {
        return a1.d;
    }

    static com.facebook.ads.internal.server.b e(com.facebook.ads.internal.server.a a1)
    {
        return a1.b;
    }

    public void a()
    {
        if (e != null)
        {
            e.c(1);
            e.b(1);
            e = null;
        }
    }

    public void a(Context context, e e1)
    {
        a();
        if (!a(context))
        {
            a(new b(AdErrorType.NETWORK_ERROR, "No network connection"));
            return;
        }
        d = e1;
        if (com.facebook.ads.internal.util.d.a(e1))
        {
            context = com.facebook.ads.internal.util.d.c(e1);
            if (context != null)
            {
                a(((String) (context)));
                return;
            } else
            {
                a(AdErrorType.LOAD_TOO_FREQUENTLY.getAdErrorWrapper(null));
                return;
            }
        } else
        {
            h.submit(new Runnable(context, e1) {

                final Context a;
                final e b;
                final com.facebook.ads.internal.server.a c;

                public void run()
                {
                    com.facebook.ads.internal.dto.f.b(a);
                    c.a = b.e();
                    try
                    {
                        com.facebook.ads.internal.server.a.a(c, new com.facebook.ads.internal.thirdparty.http.a(a, b.e));
                        com.facebook.ads.internal.server.a.b(c).a(com.facebook.ads.internal.server.a.a(c), com.facebook.ads.internal.server.a.b(c).b().a(c.a), com.facebook.ads.internal.server.a.c(c));
                        return;
                    }
                    catch (Exception exception)
                    {
                        com.facebook.ads.internal.server.a.a(c, AdErrorType.AD_REQUEST_FAILED.getAdErrorWrapper(exception.getMessage()));
                    }
                }

            
            {
                c = a.this;
                a = context;
                b = e1;
                super();
            }
            });
            return;
        }
    }

    public void a(a a1)
    {
        c = a1;
    }

    static 
    {
        g = new p();
        h = (ThreadPoolExecutor)Executors.newCachedThreadPool(g);
    }

    private class a
    {

        public abstract void a(b b1);

        public abstract void a(com.facebook.ads.internal.server.d d1);
    }

}
