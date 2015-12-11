// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.tapjoy.internal:
//            ge, gl, f, gg, 
//            cw, gc, ga, fx, 
//            gb, gp, gm, gf, 
//            hc, fz, d, cl, 
//            ch, gh, g, h, 
//            da, ae, bo, he, 
//            s, u, r, fu, 
//            cm

public final class gd
{

    private static final gd a;
    private static gd b;
    private static Handler v;
    private static File w;
    private final gl c = new gl(this);
    private gm d;
    private boolean e;
    private boolean f;
    private String g;
    private boolean h;
    private Context i;
    private gg j;
    private gc k;
    private gp l;
    private gb m;
    private String n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private ge u;

    private gd()
    {
        e = false;
        f = false;
        g = null;
        h = false;
        u = ge.a(null);
    }

    static Context a(gd gd1)
    {
        return gd1.i;
    }

    public static gd a()
    {
        return b;
    }

    public static gd a(Context context)
    {
        gd gd1 = b;
        gd1.d(context);
        return gd1;
    }

    public static String a(Context context, Intent intent)
    {
        String s1 = com.tapjoy.internal.f.a(intent);
        if (s1 != null)
        {
            gd gd1 = b;
            gd1.d(context);
            if (cw.c(gd1.j.c()) || intent.getBooleanExtra("fiverocks:force", false))
            {
                gd1.j.a(s1);
                if (s1.length() > 0)
                {
                    context = gd1.k;
                    context.a(context.a(gt.i.a, "referrer"));
                }
            }
        }
        return s1;
    }

    public static void a(GLSurfaceView glsurfaceview)
    {
        if (!ga.a(glsurfaceview, "setGLSurfaceView: The given GLSurfaceView was null"))
        {
            return;
        } else
        {
            fx.a(glsurfaceview);
            return;
        }
    }

    public static void a(Runnable runnable)
    {
        com/tapjoy/internal/gd;
        JVM INSTR monitorenter ;
        if (v == null)
        {
            v = new Handler(Looper.getMainLooper());
        }
        v.post(runnable);
        com/tapjoy/internal/gd;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    static File b(Context context)
    {
        com/tapjoy/internal/gd;
        JVM INSTR monitorenter ;
        if (w == null)
        {
            w = context.getDir("fiverocks", 0);
        }
        context = w;
        com/tapjoy/internal/gd;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static File c(Context context)
    {
        return new File(b(context), "install");
    }

    private void d(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (i == null)
        {
            context = context.getApplicationContext();
            i = context;
            j = gg.a(context);
            File file = new File(b(context), "events2");
            if (m == null)
            {
                m = new gb(file);
            }
            k = new gc(j, m);
            l = new gp(k);
            d = new gm(context);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private boolean i(String s1)
    {
        if (!o && n == null || i == null)
        {
            if (ga.a)
            {
                ga.b((new StringBuilder()).append(s1).append(": Should be called after initializing the SDK").toString());
            }
            return false;
        } else
        {
            return true;
        }
    }

    private boolean j(String s1)
    {
        if (i == null)
        {
            if (ga.a)
            {
                ga.b((new StringBuilder()).append(s1).append(": Should be called after initializing the SDK").toString());
            }
            return false;
        } else
        {
            return true;
        }
    }

    private void k()
    {
        this;
        JVM INSTR monitorenter ;
        if (o)
        {
            gf.a(i).d(g);
            c(((String) (null)));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void l()
    {
        boolean flag = true;
        Object obj = l;
        if (((gp) (obj)).c != null)
        {
            ((gp) (obj)).c.cancel(false);
            obj.c = null;
        }
        if (((gp) (obj)).b.compareAndSet(false, true))
        {
            ga.a("New session started");
            obj = ((gp) (obj)).a;
            gt.p p1 = ((gc) (obj)).a.d();
            ((gc) (obj)).a.e();
            gt.c.a a1 = ((gc) (obj)).a(gt.i.a, "bootup");
            obj.c = SystemClock.elapsedRealtime();
            if (p1 != null)
            {
                a1.a(p1);
            }
            ((gc) (obj)).a(a1);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            synchronized (c)
            {
                gl1.b = null;
            }
        }
    }

    public final hc a(String s1, Context context)
    {
        gl gl1 = c;
        gt.n n1 = gl1.a.b(false);
        return new hc(gl1.a, n1.f(), n1.h(), n1.j(), s1, context);
    }

    public final void a(int i1)
    {
        if (!j("setUserLevel"))
        {
            return;
        }
        int j1 = i1;
        if (i1 < -1)
        {
            j1 = -1;
        }
        j.a(j1);
    }

    public final void a(int i1, String s1)
    {
        if (j("setUserCohortVariable"))
        {
            boolean flag;
            if (i1 > 0 && i1 <= 5)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (ga.a && !flag)
            {
                ga.b("setCohortVariable: variableIndex is out of range");
            }
            if (flag)
            {
                s1 = fz.a(s1);
                j.a(i1, s1);
                return;
            }
        }
    }

    public final void a(Activity activity)
    {
        if (ga.a(activity, "onActivityStart: The given activity was null"))
        {
            ga.c("onActivityStart");
            com.tapjoy.internal.d.a(activity.getApplication());
            com.tapjoy.internal.d.a(activity);
            if (i("onActivityStart"))
            {
                l();
                return;
            }
        }
    }

    public final void a(Context context, String s1, String s2, String s3, String s4, String s5)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = o;
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d(context);
        int i1;
        if (i != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!ga.a(flag1, "The given context was null")) goto _L1; else goto _L3
_L3:
        if (s4 == null) goto _L5; else goto _L4
_L4:
        if (s4.length() != 24 || !s4.matches("[0-9a-f]{24}")) goto _L5; else goto _L6
_L6:
        i1 = 1;
_L14:
        if (i1 == 0) goto _L1; else goto _L7
_L7:
        if (s5 == null) goto _L9; else goto _L8
_L8:
        if (s5.length() != 20 || !s5.matches("[0-9A-Za-z\\-_]{20}")) goto _L9; else goto _L10
_L10:
        i1 = 1;
_L15:
        if (i1 == 0) goto _L1; else goto _L11
_L11:
        p = s1;
        q = s2;
        r = s4;
        s = s5;
        s1 = new URL(s3);
        context = s1.getProtocol();
        i1 = s1.getPort();
        if (!"http".equals(context)) goto _L13; else goto _L12
_L12:
        context = s1.getHost();
        if (i1 == -1)
        {
            i1 = 80;
        }
        context = new cl("TapjoySDK", context, i1);
_L16:
        context.a(s1.getPath());
        ch.b = context;
        ch.a = Executors.newCachedThreadPool();
        m.a(context);
        o = true;
        context = new gh(c(i));
        if (context.b() != null)
        {
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        if (context.a())
        {
            context = k;
            context.a(context.a(gt.i.a, "install"));
        }
        k();
          goto _L1
        context;
        throw context;
_L5:
        ga.b("Invalid App ID: {}", new Object[] {
            s4
        });
        i1 = 0;
          goto _L14
_L9:
        ga.b("Invalid App Key: {}", new Object[] {
            s5
        });
        i1 = 0;
          goto _L15
        context;
        throw new IllegalArgumentException(context);
_L13:
        if (!"https".equals(context))
        {
            break MISSING_BLOCK_LABEL_390;
        }
        context = new cl("TapjoySDK", s1.getHost(), 80);
        if (i1 == -1)
        {
            i1 = 443;
        }
        context.a(i1);
          goto _L16
        throw new IllegalArgumentException((new StringBuilder("Unsupported protocol: ")).append(s3).toString());
          goto _L1
    }

    public final void a(fu fu)
    {
        u = ge.a(fu);
    }

    public final void a(String s1)
    {
        n = s1;
    }

    public final void a(String s1, String s2, double d1, String s3)
    {
        if (i("trackPurchase"))
        {
            if ((s1 = fz.a(s1, "trackPurchase", "productId")) != null && (s2 = fz.a(s2, "trackPurchase", "currencyCode")) != null)
            {
                if (s2.length() != 3)
                {
                    ga.a("trackPurchase", "currencyCode", "invalid currency code");
                    return;
                } else
                {
                    s2 = s2.toUpperCase(Locale.US);
                    s3 = fz.b(s3);
                    k.a(s1, s2, d1, null, null, s3);
                    return;
                }
            }
        }
    }

    public final void a(String s1, String s2, String s3, String s4)
    {
        String s5;
        String s6;
        if (!i("trackPurchase"))
        {
            return;
        }
        try
        {
            s1 = new g(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            ga.a("trackPurchase", "skuDetails", "invalid SkuDetails JSON");
            return;
        }
        s5 = fz.b(((g) (s1)).a);
        s6 = fz.b(((g) (s1)).f);
        if (s5 == null || s6 == null)
        {
            ga.a("trackPurchase", "skuDetails", "insufficient fields");
            return;
        }
        if (s6.length() != 3)
        {
            ga.a("trackPurchase", "skuDetails", "invalid currency code");
            return;
        }
        s2 = fz.b(s2);
        s3 = fz.b(s3);
        if (s2 == null) goto _L2; else goto _L1
_L1:
        if (s3 != null)
        {
            try
            {
                h h1 = new h(s2);
                if (cw.c(h1.a) || cw.c(h1.b) || cw.c(h1.c) || h1.d == 0L)
                {
                    ga.a("trackPurchase", "purchaseData", "insufficient fields");
                }
            }
            catch (IOException ioexception)
            {
                ga.a("trackPurchase", "purchaseData", "invalid PurchaseData JSON");
            }
        } else
        {
            ga.a("trackPurchase", "dataSignature", "is null, skipping purchase validation");
        }
_L4:
        s6 = s6.toUpperCase(Locale.US);
        s4 = fz.b(s4);
        k.a(s5, s6, (double)((g) (s1)).g / 1000000D, s2, s3, s4);
        return;
_L2:
        if (s3 != null)
        {
            ga.a("trackPurchase", "purchaseData", "is null. skipping purchase validation");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(String s1, String s2, String s3, String s4, long l1)
    {
        while (!j("trackEvent") || !ga.a(s2, "trackEvent: name was null")) 
        {
            return;
        }
        LinkedHashMap linkedhashmap = null;
        if (l1 != 0L)
        {
            linkedhashmap = da.b();
            linkedhashmap.put("value", Long.valueOf(l1));
        }
        k.a(s1, s2, s3, s4, linkedhashmap);
    }

    public final void a(String s1, String s2, String s3, String s4, String s5, long l1, 
            String s6, long l2, String s7, long l3)
    {
        while (!j("trackEvent") || !ga.a(s2, "trackEvent: name was null")) 
        {
            return;
        }
        LinkedHashMap linkedhashmap = da.b();
        if (s5 != null && l1 != 0L)
        {
            linkedhashmap.put(s5, Long.valueOf(l1));
        }
        if (s6 != null && l2 != 0L)
        {
            linkedhashmap.put(s6, Long.valueOf(l2));
        }
        if (s7 != null && l3 != 0L)
        {
            linkedhashmap.put(s7, Long.valueOf(l3));
        }
        s5 = linkedhashmap;
        if (linkedhashmap.isEmpty())
        {
            s5 = null;
        }
        k.a(s1, s2, s3, s4, s5);
    }

    public final void a(String s1, String s2, String s3, String s4, Map map)
    {
_L2:
        return;
        if (!i("trackEvent") || cw.c(s2)) goto _L2; else goto _L1
_L1:
        LinkedHashMap linkedhashmap;
        linkedhashmap = da.b();
        if (map == null || map.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        map = map.entrySet().iterator();
_L7:
        Object obj;
        Object obj1;
        if (!map.hasNext())
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj = (java.util.Map.Entry)map.next();
        obj1 = ((java.util.Map.Entry) (obj)).getKey();
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        if (!ga.a) goto _L2; else goto _L5
_L5:
        ae.a("Tapjoy", "{}: {} must not be null", new Object[] {
            "trackEvent", "key in values map"
        });
        return;
_L4:
        if (!(obj1 instanceof String)) goto _L7; else goto _L6
_L6:
        obj1 = fz.a((String)obj1, "trackEvent", "key in values map");
        if (obj1 == null) goto _L2; else goto _L8
_L8:
        obj = ((java.util.Map.Entry) (obj)).getValue();
        if (obj instanceof Number)
        {
            linkedhashmap.put(obj1, Long.valueOf(((Number)obj).longValue()));
        } else
        {
            ga.a("trackEvent", "value in values map", "must be a long");
            return;
        }
          goto _L7
        k.a(s1, s2, s3, s4, linkedhashmap);
        return;
    }

    final void a(Map map)
    {
        gc gc1 = k;
        gt.c.a a1 = gc1.a(gt.i.b, "impression");
        if (map != null)
        {
            a1.c(bo.a(map));
        }
        gc1.a(a1);
    }

    final void a(Map map, long l1)
    {
        gc gc1 = k;
        gt.c.a a1 = gc1.a(gt.i.b, "view").d(l1);
        if (map != null)
        {
            a1.c(bo.a(map));
        }
        gc1.a(a1);
    }

    final void a(Map map, String s1)
    {
        gc gc1 = k;
        gt.c.a a1 = gc1.a(gt.i.b, "click");
        map = new LinkedHashMap(map);
        map.put("region", s1);
        a1.c(bo.a(map));
        gc1.a(a1);
    }

    public final void a(boolean flag)
    {
        boolean flag1;
        if (ga.a != flag)
        {
            ga.a = flag;
            if (flag)
            {
                ga.a("The debug mode has been enabled");
            } else
            {
                ga.a("The debug mode has been disabled");
            }
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 && flag && o)
        {
            m.a();
        }
    }

    final boolean a(Context context, String s1, boolean flag)
    {
        long l1 = System.currentTimeMillis();
        d(context);
        if (j.a(s1, l1, flag))
        {
            context = k;
            gt.c.a a1 = context.a(gt.i.a, "push_show");
            a1.a(gt.p.k().c(s1));
            context.a(a1);
            return true;
        } else
        {
            return false;
        }
    }

    public final gt.n b(boolean flag)
    {
        if (flag)
        {
            j.a();
        }
        return j.b();
    }

    public final void b()
    {
        if (!e)
        {
            e = true;
            boolean flag = o;
        }
    }

    public final void b(int i1)
    {
        if (!j("setUserFriendCount"))
        {
            return;
        }
        int j1 = i1;
        if (i1 < -1)
        {
            j1 = -1;
        }
        j.b(j1);
    }

    public final void b(Activity activity)
    {
        if (ga.a(activity, "onActivityStop: The given activity was null"))
        {
            ga.c("onActivityStop");
            com.tapjoy.internal.d.b(activity);
            if (i("onActivityStop") && !com.tapjoy.internal.d.b())
            {
                l.a();
                return;
            }
        }
    }

    public final void b(String s1)
    {
        g = cw.a(s1);
        k();
    }

    public final String c()
    {
        return p;
    }

    final void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!o) goto _L2; else goto _L1
_L1:
        String s2;
        s2 = s1;
        if (s1 != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        s2 = s1;
        if (t != null)
        {
            s2 = t;
        }
        t = null;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        s1 = j.b();
        ga.a("GCM registration id of device {} updated for sender {}: {}", new Object[] {
            s1.f().h(), g, s2
        });
        (new he(s1, s2)).a(new cm(s2) {

            final String a;
            final gd b;

            public final void a(ch ch1)
            {
            }

            public final void a(ch ch1, Object obj)
            {
                ch1 = gf.a(gd.a(b));
                obj = a;
                Object obj1 = ((s) (ch1)).b;
                obj1 = ((s) (ch1)).a;
                long l1;
                if (0L != 0L)
                {
                    l1 = System.currentTimeMillis() + 0L;
                } else
                {
                    l1 = 0L;
                }
                if (!((String) (obj)).equals(((s) (ch1)).b.b(((s) (ch1)).a)))
                {
                    return;
                }
                ((s) (ch1)).b.b(((s) (ch1)).a, true);
                if (l1 != 0L)
                {
                    new Timestamp(l1);
                }
                ((s) (ch1)).b.a(((s) (ch1)).a, l1);
            }

            
            {
                b = gd.this;
                a = s1;
                super();
            }
        }, ch.a);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        t = s1;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public final void c(boolean flag)
    {
        while (!j("setPushNotificationDisabled") || !j.a(flag) || !o || cw.c(g)) 
        {
            return;
        }
        Object obj;
        if (t != null)
        {
            obj = null;
        } else
        {
            obj = gf.a(i);
            obj = cw.b(((s) (obj)).b.b(((s) (obj)).a));
        }
        c(((String) (obj)));
    }

    public final String d()
    {
        return q;
    }

    final void d(String s1)
    {
        gc gc1 = k;
        gt.c.a a1 = gc1.a(gt.i.a, "push_ignore");
        a1.a(gt.p.k().c(s1));
        gc1.a(a1);
    }

    public final void e(String s1)
    {
        if (j.d(s1))
        {
            gc gc1 = k;
            gt.c.a a1 = gc1.a(gt.i.a, "push_click");
            a1.a(gt.p.k().c(s1));
            gc1.a(a1);
        }
    }

    public final boolean e()
    {
        if (!j("isPushNotificationDisabled"))
        {
            return false;
        } else
        {
            return j.f();
        }
    }

    public final void f(String s1)
    {
        if (!j("setAppDataVersion"))
        {
            return;
        } else
        {
            s1 = fz.a(s1);
            j.b(s1);
            return;
        }
    }

    final boolean f()
    {
        return l != null && l.b.get();
    }

    public final void g()
    {
        if (!i("startSession"))
        {
            return;
        } else
        {
            l();
            return;
        }
    }

    public final void g(String s1)
    {
        if (!j("setUserId"))
        {
            return;
        } else
        {
            s1 = fz.a(s1);
            j.c(s1);
            return;
        }
    }

    public final void h()
    {
        if (!i("endSession"))
        {
            return;
        } else
        {
            l.a();
            return;
        }
    }

    public final void h(String s1)
    {
        if (d == null)
        {
            return;
        }
        gm gm1 = d;
        String s3 = gm.a();
        String s2 = gm1.b.a();
        String s4 = gm1.a.a();
        if (s4 == null || !s3.equals(s4))
        {
            gm1.a.a(s3);
            s2 = "";
        }
        boolean flag;
        if (s2.length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            if (!s2.contains(s1))
            {
                s1 = s2.concat((new StringBuilder(",")).append(s1).toString());
            } else
            {
                s1 = s2;
            }
        }
        gm1.b.a(s1);
    }

    public final String i()
    {
        if (d == null)
        {
            return null;
        } else
        {
            gm gm1 = d;
            gm1.b();
            return gm1.b.a();
        }
    }

    public final ge j()
    {
        return u;
    }

    static 
    {
        gd gd1 = new gd();
        a = gd1;
        b = gd1;
    }
}
