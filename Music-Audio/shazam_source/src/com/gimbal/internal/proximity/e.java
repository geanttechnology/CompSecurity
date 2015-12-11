// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.gimbal.internal.c.c;
import com.gimbal.internal.d.h;
import com.gimbal.internal.persistance.ApplicationConfiguration;
import com.gimbal.internal.persistance.a;
import com.gimbal.internal.persistance.b;
import com.gimbal.internal.persistance.g;
import com.gimbal.internal.proximity.core.c.f;
import com.gimbal.internal.proximity.core.c.k;
import com.gimbal.internal.proximity.core.c.l;
import com.gimbal.internal.proximity.core.c.n;
import com.gimbal.internal.proximity.core.sighting.d;
import com.gimbal.internal.rest.BeaconUserAgentBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.gimbal.internal.proximity:
//            a

public class e
    implements com.gimbal.internal.persistance.e
{

    public static final com.gimbal.a.b a = com.gimbal.internal.c.c.f(com/gimbal/internal/proximity/e.getName());
    private static final com.gimbal.a.a g = com.gimbal.internal.c.c.e(com/gimbal/internal/proximity/e.getName());
    private static Context h;
    private static e i;
    public com.gimbal.internal.proximity.core.service.a.a b;
    public b c;
    public a d;
    public com.gimbal.internal.proximity.a e;
    public com.gimbal.internal.b.a.a f;
    private Executor j;
    private RestTemplate k;
    private com.gimbal.android.a.a l;
    private com.gimbal.internal.proximity.core.c.h m;
    private com.gimbal.internal.proximity.core.sighting.a n;
    private com.gimbal.internal.rest.c o;
    private com.gimbal.internal.proximity.core.c.a p;
    private com.gimbal.internal.proximity.core.sighting.b q;
    private n r;
    private com.gimbal.internal.proximity.core.c.c s;
    private com.gimbal.internal.c.d t;
    private com.gimbal.internal.proximity.core.g.d u;
    private Map v;
    private com.gimbal.internal.c.a w;
    private c x;

    private e()
    {
    }

    public static int a(String s1)
    {
        int i1;
        try
        {
            i1 = Integer.parseInt(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new RuntimeException("setAPIKeyWithOptions error: invalid smoothing window");
        }
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        throw new RuntimeException("setAPIKeyWithOptions error: invalid smoothing window");
        return i1;
    }

    private com.gimbal.internal.proximity.core.c.h a(n n1, com.gimbal.internal.proximity.core.c.c c1)
    {
        Class class1 = b();
        if (class1 == com/gimbal/internal/proximity/core/c/f)
        {
            return new f(h, c1, n1, com.gimbal.internal.proximity.core.sighting.d.a());
        }
        if (class1 == com/gimbal/internal/proximity/core/c/k)
        {
            return new k(h, c1, n1, com.gimbal.internal.proximity.core.sighting.d.a());
        } else
        {
            return new l(h, c1, n1, com.gimbal.internal.proximity.core.sighting.d.a());
        }
    }

    public static e a()
    {
        if (h == null)
        {
            throw new RuntimeException("Android context not initialized yet. Call setApiKey before calling any other method.");
        }
        if (i == null)
        {
            throw new RuntimeException("Processor factory initializeApplicationContext not called.");
        } else
        {
            return i;
        }
    }

    public static void a(Application application)
    {
        if (i == null)
        {
            h = application.getApplicationContext();
            e e1 = new e();
            i = e1;
            e1.j = Executors.newSingleThreadExecutor(new ThreadFactory() {

                public final Thread newThread(Runnable runnable)
                {
                    return new Thread(runnable, "PropertyChangeNotify");
                }

            });
            e1.c = new b(new g(h.getSharedPreferences("Gimbal_Storage_File", 0), e1.j));
            e1.d = new a(new g(h.getSharedPreferences("Application_Configuration", 0), e1.j));
            e1.w = new com.gimbal.internal.c.a(h);
            e1.x = new c();
            e1.t = new com.gimbal.internal.c.d(android.os.Build.VERSION.SDK_INT, android.os.Build.VERSION.RELEASE);
            com.gimbal.internal.proximity.core.a.a.a(h.getApplicationContext());
            e1.o = new com.gimbal.internal.rest.c(e1.c);
            BeaconUserAgentBuilder beaconuseragentbuilder = new BeaconUserAgentBuilder(h);
            application = new HttpComponentsClientHttpRequestFactory();
            application.setConnectTimeout(60000);
            application.setReadTimeout(60000);
            com.gimbal.internal.rest.b b1 = new com.gimbal.internal.rest.b(application);
            Object obj = b1.getInterceptors();
            application = ((Application) (obj));
            if (obj == null)
            {
                application = new ArrayList();
            }
            application.add(new com.gimbal.internal.rest.d(beaconuseragentbuilder));
            application.add(new com.gimbal.internal.rest.a(e1.c));
            b1.setInterceptors(application);
            e1.k = b1;
            application = new com.gimbal.internal.d.b();
            application.a(new h(), new Class[0]);
            e1.l = new com.gimbal.android.a.a(application);
            e1.b = new com.gimbal.internal.proximity.core.service.a.a(e1.k, e1.o, e1.l);
            com.gimbal.internal.proximity.core.e.a.a();
            e1.f = new com.gimbal.internal.b.a.a(e1.w, e1.c);
            e1.u = new com.gimbal.internal.proximity.core.g.d();
            e1.v = new HashMap();
            e1.q = new com.gimbal.internal.proximity.core.sighting.b(e1.u, e1.v);
            e1.n = new com.gimbal.internal.proximity.core.sighting.a(h, e1.q);
            e1.r = new n(e1.n);
            e1.s = com.gimbal.internal.proximity.core.e.a.a().a;
            e1.m = e1.a(e1.r, e1.s);
            e1.q.a(e1.m);
            e1.p = new com.gimbal.internal.proximity.core.c.a(e1.c, h, e1.q);
            application = e1.p;
            ((com.gimbal.internal.e.a) (application)).a.a(application, new String[] {
                "Api_Key"
            });
            application.a("Api_Key", ((com.gimbal.internal.e.a) (application)).a.b());
            e1.e = new com.gimbal.internal.proximity.a(e1.q, e1.x, e1.d);
            e1.e.a();
            e1.d.a.a(e1, new String[] {
                "allowKitKat"
            });
            e1.c.a(e1, new String[] {
                "Api_Key"
            });
            e1.a("Api_Key", e1.c.b());
            application = h;
            obj = new Intent(application.getPackageName());
            ((Intent) (obj)).setPackage(application.getPackageName());
            application.startService(((Intent) (obj)));
            obj = a;
            application = application.getPackageName();
            ((com.gimbal.a.b) (obj)).a.c("Proxmity Service started by {}", new Object[] {
                application
            });
        }
    }

    private Class b()
    {
        com.gimbal.internal.c.d d1;
        boolean flag;
        boolean flag1;
        flag = true;
        d1 = t;
        Boolean boolean1 = d.a().isAllowKitKat();
        if (boolean1 == null)
        {
            flag1 = true;
        } else
        {
            flag1 = boolean1.booleanValue();
        }
        break MISSING_BLOCK_LABEL_25;
        if (d1.a < 21 && (d1.a < 19 || !flag1 || com.gimbal.internal.c.c.a(d1.b, "4.4.3").intValue() < 0))
        {
            flag = false;
        }
        if (flag)
        {
            if (android.os.Build.VERSION.SDK_INT < 21)
            {
                return com/gimbal/internal/proximity/core/c/l;
            } else
            {
                return com/gimbal/internal/proximity/core/c/k;
            }
        } else
        {
            return com/gimbal/internal/proximity/core/c/f;
        }
    }

    public final void a(String s1, Object obj)
    {
        if ("allowKitKat".equals(s1) && b() != m.getClass())
        {
            s1 = a(r, s);
            if (t.a())
            {
                com.gimbal.internal.a.a.a.a();
            }
            m = s1;
            q.a(m);
            if (t.a())
            {
                com.gimbal.internal.a.a.a.a();
            }
        }
    }

}
