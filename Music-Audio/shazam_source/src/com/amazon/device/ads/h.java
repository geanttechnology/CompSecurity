// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ea, cl, co, ak, 
//            cm, cu, as, ay, 
//            ab, ds, ag, bc, 
//            ae, m, ah, am, 
//            an, d, cn, e, 
//            dw, dd, de, k, 
//            at, aa, aj, f, 
//            j, z, dq, cq, 
//            cz, ck, g, bg, 
//            dt, u, cd, du, 
//            dz, dy, ac, cv, 
//            do, bb, cx, da, 
//            l, v

public class h
    implements ck.b
{
    private final class a
        implements am.a
    {

        final h a;

        public final void a(WebView webview, String s1)
        {
            if (webview.equals(a.a().a.d))
            {
                webview = a;
                if (webview.n())
                {
                    ((h) (webview)).d.b("Ad Rendered", null);
                    dd dd1;
                    if (((h) (webview)).x.equals(ae.d))
                    {
                        if (!webview.p())
                        {
                            ((h) (webview)).C.set(false);
                            ((h) (webview)).m.a();
                            j j1 = ((h) (webview)).o;
                            long l1 = System.currentTimeMillis();
                            l1 = j1.i - l1;
                            if (l1 > 0L)
                            {
                                ((h) (webview)).m.b();
                                ((h) (webview)).m.a(webview. new TimerTask() {

                                    final h a;

                                    public final void run()
                                    {
                                        h.a(a);
                                    }

            
            {
                a = h.this;
                super();
            }
                                }, l1);
                            }
                            webview.a(ae.e);
                            ds.b(webview. new Runnable() {

                                final h a;

                                public final void run()
                                {
                                    if (!a.n())
                                    {
                                        return;
                                    } else
                                    {
                                        a.b().a();
                                        return;
                                    }
                                }

            
            {
                a = h.this;
                super();
            }
                            });
                            l1 = System.nanoTime();
                            if (((h) (webview)).f != null)
                            {
                                ((h) (webview)).f.c(ck.a.y, l1);
                                ((h) (webview)).f.c(ck.a.a, l1);
                                ((h) (webview)).f.c(ck.a.b, l1);
                                webview.q();
                                webview.c(true);
                            }
                            ds.b(webview. new Runnable() {

                                final h a;

                                public final void run()
                                {
                                    if (!a.n())
                                    {
                                        return;
                                    } else
                                    {
                                        a.b().b();
                                        return;
                                    }
                                }

            
            {
                a = h.this;
                super();
            }
                            });
                        }
                    } else
                    {
                        ((h) (webview)).d.b((new StringBuilder("Ad State was not Rendering. It was ")).append(((h) (webview)).x).toString(), null);
                    }
                    dd1 = new dd(dd.a.a);
                    dd1.b.put("url", s1);
                    webview.a(dd1);
                }
            }
        }

        private a()
        {
            a = h.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    final class b
        implements g
    {

        final h a;

        public final void a()
        {
            h.b(a).b("DefaultAdControlCallback onAdRendered called", null);
        }

        public final void a(k k1)
        {
            h.b(a).b("DefaultAdControlCallback onAdFailed called", null);
        }

        public final void a(l l1)
        {
            h.b(a).b("DefaultAdControlCallback onAdEvent called", null);
        }

        public final void a(v v1)
        {
            h.b(a).b("DefaultAdControlCallback onAdLoaded called", null);
        }

        public final boolean a(boolean flag)
        {
            h.b(a).b("DefaultAdControlCallback isAdReady called", null);
            return a.x.equals(ae.a) || a.x.equals(ae.g);
        }

        public final void b()
        {
            h.b(a).b("DefaultAdControlCallback postAdRendered called", null);
        }

        public final int c()
        {
            h.b(a).b("DefaultAdControlCallback adClosing called", null);
            return 1;
        }

        public final void d()
        {
            h.b(a).b("DefaultAdControlCallback onAdExpired called", null);
        }

        b()
        {
            a = h.this;
            super();
        }
    }


    private static final String H = com/amazon/device/ads/h.getSimpleName();
    bb A;
    ViewGroup B;
    final AtomicBoolean C;
    boolean D;
    boolean E;
    boolean F;
    boolean G;
    private final cu I;
    private final m J;
    private final e.a K;
    private final ArrayList L;
    private f M;
    private final AtomicBoolean N;
    private boolean O;
    protected final ea a;
    final Context b;
    final ac c;
    public final cn d;
    final ak e;
    public cl f;
    final cm g;
    final as h;
    final ah i;
    public final d j;
    final ay k;
    public final ab l;
    public final ag m;
    final bc n;
    public j o;
    Activity p;
    int q;
    int r;
    g s;
    public e t;
    int u;
    int v;
    boolean w;
    public ae x;
    double y;
    public boolean z;

    h(Context context, ac ac1)
    {
        this(context, ac1, new ea(), new cl(), new co(), new ak(), new e.a(), cm.a(), new cu(), new as(), ay.a(), new ab(), ds.a(), new dy.d(), new ag(), bc.a());
    }

    private h(Context context, ac ac1, ea ea1, cl cl1, ak ak1, e.a a1, cm cm1, 
            cu cu1, as as1, ay ay1, ab ab1, ds.k k1, an an1, dy.d d1, 
            ag ag1, bc bc1)
    {
        r = 20000;
        L = new ArrayList();
        u = 0;
        v = 0;
        w = false;
        x = ae.a;
        y = 1.0D;
        z = false;
        B = null;
        C = new AtomicBoolean(false);
        N = new AtomicBoolean(false);
        O = false;
        D = false;
        E = false;
        F = false;
        G = false;
        b = context;
        c = ac1;
        a = ea1;
        f = cl1;
        d = co.a(H);
        e = ak1;
        K = a1;
        g = cm1;
        I = cu1;
        h = as1;
        k = ay1;
        m = ag1;
        n = bc1;
        l = ab1;
        J = new m(ay1, l, c(), ak1);
        i = new ah(k1, new am(context, l, c(), an1.b, an1.a, an1.c), d1, c(), ea1, cm1.b);
        context = i;
        ac1 = new a((byte)0);
        ((ah) (context)).a.b = ac1;
        j = new d(this);
    }

    private h(Context context, ac ac1, ea ea1, cl cl1, co co1, ak ak1, e.a a1, 
            cm cm1, cu cu1, as as1, ay ay1, ab ab1, ds.k k1, dy.d d1, 
            ag ag1, bc bc1)
    {
        this(context, ac1, ea1, cl1, ak1, a1, cm1, cu1, as1, ay1, ab1, k1, new an(ea1, co1, as1), d1, ag1, bc1);
    }

    static void a(h h1)
    {
        if (ae.e.compareTo(h1.x) >= 0 && h1.b(ae.j))
        {
            h1.d.b("Ad Has Expired", null);
            ds.b(h1. new Runnable() {

                final h a;

                public final void run()
                {
                    a.b().d();
                    a.c(true);
                }

            
            {
                a = h.this;
                super();
            }
            });
        }
    }

    private void a(k k1, boolean flag)
    {
        ds.b(new Runnable(k1, flag) {

            final k a;
            final boolean b;
            final h c;

            public final void run()
            {
                c.b().a(a);
                c.c(b);
            }

            
            {
                c = h.this;
                a = k1;
                b = flag;
                super();
            }
        });
    }

    static cn b(h h1)
    {
        return h1.d;
    }

    private boolean w()
    {
        return D || O;
    }

    public final e a()
    {
        if (t == null)
        {
            t = new e(b, j);
            t.a(w());
            Object obj = t;
            am am1 = i.a;
            obj = ((e) (obj)).a;
            obj.c = am1;
            if (((dw) (obj)).a())
            {
                ((dw) (obj)).b().setWebViewClient(((dw) (obj)).c);
            }
        }
        return t;
    }

    public final void a(int i1, int j1)
    {
        v = i1;
        u = j1;
        w = true;
    }

    public final void a(ae ae1)
    {
        d.b("Changing AdState from %s to %s", new Object[] {
            x, ae1
        });
        x = ae1;
    }

    public final void a(dd dd1)
    {
        d.b("Firing SDK Event of type %s", new Object[] {
            dd1.a
        });
        for (Iterator iterator = L.iterator(); iterator.hasNext(); ((de)iterator.next()).a(dd1, c())) { }
    }

    public final void a(de de1)
    {
        d.b("Add SDKEventListener %s", new Object[] {
            de1
        });
        L.add(de1);
    }

    final void a(k k1)
    {
        while (!n() || p()) 
        {
            return;
        }
        m.a();
        b(k1);
        a(ae.a);
    }

    public final void a(String s1)
    {
        d.d(s1, null);
        a(new k(k.a.e, s1));
    }

    public final void a(String s1, String s2, boolean flag, cx cx)
    {
        Object obj = a().a;
        if (((dw) (obj)).d != null)
        {
            if (at.a(11))
            {
                String s3;
                for (Iterator iterator = ((dw) (obj)).k.iterator(); iterator.hasNext(); at.a(((dw) (obj)).d, s3))
                {
                    s3 = (String)iterator.next();
                }

            } else
            {
                ((dw) (obj)).a(((dw) (obj)).a(((dw) (obj)).a.getContext()), true);
                ((dw) (obj)).d.setContentDescription("originalWebView");
            }
        }
        ((dw) (obj)).k.clear();
        L.clear();
        m m1 = J;
        obj = m1.a;
        Object obj1 = new HashSet();
        Object obj2 = ((ay) (obj)).b.keySet().iterator();
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break;
            }
            String s4 = (String)((Iterator) (obj2)).next();
            if (((ay) (obj)).a(s4).matcher(s2).find())
            {
                ((Set) (obj1)).addAll((Collection)((ay) (obj)).b.get(s4));
            }
        } while (true);
        for (obj = ((Set) (obj1)).iterator(); ((Iterator) (obj)).hasNext(); m1.e.a(((z) (obj1))))
        {
            obj1 = ((aa)((Iterator) (obj)).next()).a(m1.b);
        }

        obj = m1.c;
        obj1 = m1.d;
        float f1 = aj.a();
        int i1 = m1.b.a.v;
        int j1 = m1.b.a.u;
        float f2 = m1.b.a.o.g;
        obj1 = m1.d;
        int k1 = (int)(f2 * aj.a());
        f2 = m1.b.a.o.f;
        obj1 = m1.d;
        ((cn) (obj)).b("Scaling Params: scalingDensity: %f, windowWidth: %d, windowHeight: %d, adWidth: %d, adHeight: %d, scale: %f", new Object[] {
            Float.valueOf(f1), Integer.valueOf(i1), Integer.valueOf(j1), Integer.valueOf(k1), Integer.valueOf((int)(f2 * aj.a())), Double.valueOf(m1.b.a.y)
        });
        obj2 = m1.e.iterator();
        obj = "";
        while (((Iterator) (obj2)).hasNext()) 
        {
            Object obj3 = (z)((Iterator) (obj2)).next();
            if (((z) (obj3)).d() != null)
            {
                obj1 = m1.b;
                de de1 = ((z) (obj3)).d();
                ((f) (obj1)).a.a(de1);
            }
            obj1 = obj;
            if (((z) (obj3)).c() != null)
            {
                obj1 = (new StringBuilder()).append(((String) (obj))).append(((z) (obj3)).c()).toString();
            }
            Object obj4 = m1.b;
            obj = ((z) (obj3)).a();
            obj3 = ((z) (obj3)).b();
            obj4 = ((f) (obj4)).a.a().a;
            ((dw) (obj4)).l.b("Add JavaScript Interface %s", new Object[] {
                obj3
            });
            ((dw) (obj4)).k.add(obj3);
            if (flag)
            {
                ((dw) (obj4)).d().addJavascriptInterface(obj, ((String) (obj3)));
                obj = obj1;
            } else
            {
                ((dw) (obj4)).b().addJavascriptInterface(obj, ((String) (obj3)));
                obj = obj1;
            }
        }
        obj2 = com.amazon.device.ads.m.a(s2);
        String s5 = dq.b("<[Hh][Ee][Aa][Dd](\\s*>|\\s[^>]*>)", ((String) (obj2)));
        s2 = "";
        if (!dq.a("<[Mm][Ee][Tt][Aa](\\s[^>]*\\s|\\s)[Nn][Aa][Mm][Ee]\\s*=\\s*[\"'][Vv][Ii][Ee][Ww][Pp][Oo][Rr][Tt][\"']", ((String) (obj2))))
        {
            if (m1.b.a.y >= 0.0D)
            {
                s2 = (new StringBuilder()).append("").append("<meta name=\"viewport\" content=\"width=").append(m1.b.a.v).append(", height=").append(m1.b.a.u).append(", initial-scale=");
                obj1 = m1.d;
                s2 = s2.append(aj.a(m1.b.a.y)).append(", minimum-scale=").append(m1.b.a.y).append(", maximum-scale=").append(m1.b.a.y).append("\"/>").toString();
            } else
            {
                s2 = (new StringBuilder()).append("").append("<meta name=\"viewport\" content=\"width=device-width, height=device-height, user-scalable=no, initial-scale=1.0\"/>").toString();
            }
        }
        obj1 = (new StringBuilder()).append(s2).append("<style>html,body{margin:0;padding:0;height:100%;border:none;}</style>").toString();
        s2 = ((String) (obj1));
        if (((String) (obj)).length() > 0)
        {
            s2 = (new StringBuilder()).append(((String) (obj1))).append("<script type='text/javascript'>").append(((String) (obj))).append("</script>").toString();
        }
        s2 = ((String) (obj2)).replace(s5, (new StringBuilder()).append(s5).append(s2).toString());
        a().a(s1, s2, flag, cx);
    }

    public final void a(String s1, boolean flag)
    {
        ds.c(new Runnable(s1, flag) {

            final String a;
            final boolean b;
            final h c;

            public final void run()
            {
                Object obj = c.a();
                String s2 = a;
                boolean flag1 = b;
                obj = ((e) (obj)).a;
                s2 = (new StringBuilder("javascript:")).append(s2).toString();
                if (flag1)
                {
                    ((dw) (obj)).d().loadUrl(s2);
                    return;
                } else
                {
                    ((dw) (obj)).l.b((new StringBuilder("Loading URL: ")).append(s2).toString(), null);
                    ((dw) (obj)).b().loadUrl(s2);
                    return;
                }
            }

            
            {
                c = h.this;
                a = s1;
                b = flag;
                super();
            }
        });
    }

    public final void a(boolean flag)
    {
        O = flag;
        if (t != null)
        {
            t.a(w());
        }
    }

    public final void a(boolean flag, da da)
    {
        a().b.a(flag, da);
    }

    public final boolean a(long l1, boolean flag)
    {
        if (n()) goto _L2; else goto _L1
_L1:
        a("An ad could not be loaded because the view has been destroyed or was not created properly.");
_L4:
        return false;
_L2:
        if (!aj.a(g().getApplicationContext()))
        {
            a("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
            return false;
        }
        if (!cu.a(b, "android.permission.INTERNET"))
        {
            a("Ads cannot load because the INTERNET permission is missing from the app's manifest.");
            return false;
        }
        boolean flag1;
        if (g.c.d() != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1)
        {
            a("Can't load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
            return false;
        }
        if (!a().b())
        {
            ck.a().b.a(ck.a.H);
            a("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
            return false;
        }
        if (b().a(flag))
        {
            break; /* Loop/switch isn't completed */
        }
        bg bg1;
        Context context;
        if (x.equals(ae.e))
        {
            if (m())
            {
                flag1 = false;
            } else
            {
                d.d("An ad is ready to show. Please call showAd() to show the ad before loading another ad.", null);
                flag1 = true;
            }
        } else
        if (x.equals(ae.h))
        {
            d.d("An ad could not be loaded because another ad is currently expanded.", null);
            flag1 = true;
        } else
        {
            d.d("An ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.", null);
            flag1 = true;
        }
        if (flag1) goto _L4; else goto _L3
_L3:
        if (n())
        {
            z = false;
            m.a();
            e();
            G = false;
            if (t != null)
            {
                t.a();
                l.a.clear();
                t = null;
            }
            o = null;
        }
        f.b(ck.a.a, l1);
        f.b(ck.a.c, l1);
        f.b(ck.a.b, l1);
        f.b(ck.a.d, l1);
        a(ae.b);
        C.set(false);
        N.set(false);
        m.b();
        m.a(new TimerTask() {

            final h a;

            public final void run()
            {
                h h1 = a;
                if (h1.n.a("debug.canTimeout", Boolean.valueOf(true)).booleanValue() && !h1.p())
                {
                    h1.b(new k(k.a.b, "Ad Load Timed Out"));
                    h1.a(ae.j);
                }
            }

            
            {
                a = h.this;
                super();
            }
        }, r);
        bg1 = g.b;
        context = b;
        bg1.d.b(context);
        z = true;
        return true;
    }

    final g b()
    {
        if (s == null)
        {
            s = new b();
        }
        return s;
    }

    final void b(k k1)
    {
        if (f == null || f.b())
        {
            a(k1, false);
            return;
        }
        long l1 = System.nanoTime();
        f.c(ck.a.a, l1);
        f.c(ck.a.j, l1);
        f.c(ck.a.c, l1);
        if (k1 != null && (k.a.c.equals(k1.a) || k.a.a.equals(k1.a) || k.a.b.equals(k1.a) || k.a.d.equals(k1.a)))
        {
            f.a(ck.a.t);
            if (k1.a == k.a.b)
            {
                if (C.get())
                {
                    f.a(ck.a.v);
                } else
                {
                    f.a(ck.a.u);
                }
            }
        }
        f.c(ck.a.z, l1);
        if (x.equals(ae.d))
        {
            f.a(ck.a.x);
        }
        q();
        a(k1, true);
    }

    public final void b(boolean flag)
    {
        if (flag)
        {
            a(ae.h);
            return;
        } else
        {
            a(ae.g);
            return;
        }
    }

    public final boolean b(ae ae1)
    {
        this;
        JVM INSTR monitorenter ;
        if (ae.e.compareTo(x) < 0) goto _L2; else goto _L1
_L1:
        a(ae1);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        ae1;
        throw ae1;
    }

    final f c()
    {
        if (M == null)
        {
            M = new f(this);
        }
        return M;
    }

    public final void c(boolean flag)
    {
label0:
        {
            boolean flag2 = false;
            if (flag)
            {
                ck ck1 = ck.a();
                ck1.a.b("METRIC Submit and Reset", null);
                u u1 = new u(this);
                Object obj = u1.b.f();
                boolean flag1 = flag2;
                Object obj1;
                if (obj != null)
                {
                    if (((String) (obj)).equals(""))
                    {
                        flag1 = flag2;
                    } else
                    {
                        String s1 = cm.a().c.d();
                        if (s1 == null || s1.equals("123"))
                        {
                            u1.d.b("Not submitting metrics because the AppKey is either not set or set to a test key.", null);
                            flag1 = flag2;
                        } else
                        {
                            flag1 = true;
                        }
                    }
                }
                if (!flag1)
                {
                    break label0;
                }
                obj = ck1.b;
                ck1.b = new cl();
                u1.c = ((cl) (obj));
                obj = u1.e.a();
                obj1 = new JSONObject();
                cd.b(((JSONObject) (obj1)), "c", "msdk");
                cd.b(((JSONObject) (obj1)), "v", du.a());
                com.amazon.device.ads.u.a(((JSONObject) (obj1)), u1.b.d());
                com.amazon.device.ads.u.a(((JSONObject) (obj1)), u1.c);
                obj1 = ((JSONObject) (obj1)).toString();
                obj1 = dz.a(((String) (obj1)).substring(1, ((String) (obj1)).length() - 1));
                obj1 = (new StringBuilder()).append(u1.b.f()).append(((String) (obj1))).toString();
                u1.b.e();
                ((dy) (obj)).c(((String) (obj1)));
                ds.a(new ck._cls1(ck1, ((dy) (obj))));
            }
            return;
        }
        e();
    }

    public final cl d()
    {
        return f;
    }

    public final void e()
    {
        f = new cl();
    }

    public final String f()
    {
        if (o != null)
        {
            return o.a;
        } else
        {
            return null;
        }
    }

    protected final Context g()
    {
        if (p == null)
        {
            return b;
        } else
        {
            return p;
        }
    }

    public final boolean h()
    {
        boolean flag = z;
        z = false;
        return flag;
    }

    final void i()
    {
        int i1;
label0:
        {
            if (o != null)
            {
                int j1 = (int)((double)o.f * y * (double)aj.a());
                i1 = j1;
                if (j1 <= 0)
                {
                    i1 = -1;
                }
                if (!c.b())
                {
                    break label0;
                }
                dw dw1 = a().a;
                dw1.g = i1;
                dw1.c();
            }
            return;
        }
        int k1 = (int)((double)o.g * y * (double)aj.a());
        a().a(k1, i1, c.k);
    }

    public final void j()
    {
        if (!n())
        {
            return;
        } else
        {
            p = null;
            z = false;
            m.a();
            e();
            G = false;
            a().a();
            l.a.clear();
            o = null;
            a(ae.a);
            return;
        }
    }

    final boolean k()
    {
        try
        {
            e e1 = a();
            e1.a.j = e1.c;
            e1.a.b();
        }
        catch (IllegalStateException illegalstateexception)
        {
            a(new k(k.a.d, "An unknown error occurred when attempting to create the web view."));
            a(ae.j);
            d.d("An unknown error occurred when attempting to create the web view.", null);
            return false;
        }
        return true;
    }

    public final void l()
    {
        if (!n())
        {
            return;
        } else
        {
            a(ae.d);
            long l1 = System.nanoTime();
            f.c(ck.a.i, l1);
            f.b(ck.a.y, l1);
            C.set(true);
            a("http://amazon-adsystem.amazon.com/", o.c, false, null);
            return;
        }
    }

    public final boolean m()
    {
        if (o != null)
        {
            j j1 = o;
            boolean flag;
            if (j1.i >= 0L && System.currentTimeMillis() > j1.i)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean n()
    {
        return !ae.k.equals(x) && !ae.j.equals(x);
    }

    public final void o()
    {
        if (!n())
        {
            return;
        }
        f.c(ck.a.p);
        m.a();
        boolean flag;
        if (!x.equals(ae.i))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            dz.c(o.b);
        }
        a(ae.g);
        if (!w)
        {
            a(a().getWidth(), a().getHeight());
        }
        a(new dd(dd.a.b));
    }

    final boolean p()
    {
        return N.getAndSet(true);
    }

    final void q()
    {
        aj.a(A, f);
        if (u == 0)
        {
            f.a(ck.a.E);
        }
        cl cl1 = f;
        ck.a a1 = ck.a.F;
        String s1;
        if (y > 1.0D)
        {
            s1 = "u";
        } else
        if (y < 1.0D && y > 0.0D)
        {
            s1 = "d";
        } else
        {
            s1 = "n";
        }
        cl1.a(a1, s1);
    }

    final boolean r()
    {
        if (E)
        {
            a(new dd(dd.a.i));
            return true;
        } else
        {
            j.a();
            return false;
        }
    }

    final ViewGroup s()
    {
        return (ViewGroup)a().getParent();
    }

    final cv t()
    {
        int k1 = a().getWidth();
        int i2 = a().getHeight();
        int i1 = i2;
        int j1 = k1;
        if (k1 == 0)
        {
            i1 = i2;
            j1 = k1;
            if (i2 == 0)
            {
                j1 = v;
                i1 = u;
            }
        }
        j1 = aj.a(j1);
        i1 = aj.a(i1);
        int ai[] = new int[2];
        a().getLocationOnScreen(ai);
        View view = ((Activity)g()).findViewById(0x1020002);
        if (view == null)
        {
            d.c("Could not find the activity's root view while determining ad position.", null);
            return null;
        } else
        {
            int ai1[] = new int[2];
            view.getLocationOnScreen(ai1);
            int l1 = aj.a(ai[0]);
            int j2 = aj.a(ai[1] - ai1[1]);
            return new cv(new do(j1, i1), l1, j2);
        }
    }

    final boolean u()
    {
        return ac.c.c.equals(c.l);
    }

    final do v()
    {
        FrameLayout framelayout = (FrameLayout)((Activity)g()).findViewById(0x1020002);
        if (framelayout == null)
        {
            d.c("Could not find the activity's root view while determining max expandable size.", null);
            return null;
        } else
        {
            int i1 = framelayout.getWidth();
            int j1 = framelayout.getHeight();
            return new do(aj.a(i1), aj.a(j1));
        }
    }


    // Unreferenced inner class com/amazon/device/ads/h$10

/* anonymous class */
    final class _cls10
        implements Runnable
    {

        final l a;
        final h b;

        public final void run()
        {
            if (!b.n())
            {
                return;
            } else
            {
                b.b().a(a);
                return;
            }
        }

            
            {
                b = h.this;
                a = l1;
                super();
            }
    }


    // Unreferenced inner class com/amazon/device/ads/h$2

/* anonymous class */
    final class _cls2
        implements android.view.View.OnKeyListener
    {

        final h a;

        public final boolean onKey(View view, int i1, KeyEvent keyevent)
        {
            if (i1 == 4 && keyevent.getRepeatCount() == 0)
            {
                a.r();
                return true;
            } else
            {
                return false;
            }
        }

            
            {
                a = h.this;
                super();
            }
    }


    // Unreferenced inner class com/amazon/device/ads/h$7

/* anonymous class */
    final class _cls7
        implements Runnable
    {

        final v a;
        final h b;

        public final void run()
        {
            if (!b.n())
            {
                return;
            } else
            {
                b.b().a(a);
                return;
            }
        }

            
            {
                b = h.this;
                a = v1;
                super();
            }
    }

}
