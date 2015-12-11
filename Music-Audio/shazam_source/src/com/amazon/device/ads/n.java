// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            c, co, i, w, 
//            r, q, cn, x, 
//            h, e, cl, ac, 
//            ae, ds, ad, af, 
//            bd, bf, p, j, 
//            o, g, k, l, 
//            cs, ck, at, v, 
//            d

public class n extends FrameLayout
    implements c
{
    final class a
        implements g
    {

        final n a;
        private v b;

        public final void a()
        {
            n.b(a).f.b(ck.a.p);
            if (n.e(a) != null)
            {
                a.removeView(n.e(a));
            }
            if (n.f(a) != null)
            {
                n.f(a).a();
            }
            n.a(a, n.b(a).a());
            n.a(a, n.b(a).a());
            Object obj = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
            a.addView(n.e(a), ((android.view.ViewGroup.LayoutParams) (obj)));
            obj = b;
            a.getAdController().o();
            a.getAdListenerExecutor().a(a, ((v) (obj)));
        }

        public final void a(k k1)
        {
            if (k.a.b.equals(k1.a))
            {
                n.g(a);
            }
            a.getAdListenerExecutor().a(a, k1);
        }

        public final void a(l l1)
        {
            static final class _cls4
            {

                static final int a[];
                static final int b[];

                static 
                {
                    b = new int[com.amazon.device.ads.l.a.values().length];
                    try
                    {
                        b[l.a.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        b[l.a.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        b[l.a.d.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    a = new int[ae.values().length];
                    try
                    {
                        a[ae.j.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[ae.k.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[ae.h.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls4.b[l1.a.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                a.getAdListenerExecutor().a(a);
                return;

            case 2: // '\002'
                a.getAdListenerExecutor().b(a);
                return;

            case 3: // '\003'
                l1 = (Rect)l1.b.a.get("positionOnScreen");
                break;
            }
            a.getAdListenerExecutor().a(a, l1);
        }

        public final void a(v v1)
        {
            b = v1;
            n.b(a).l();
        }

        public final boolean a(boolean flag)
        {
            n n1;
            boolean flag1;
            flag1 = false;
            n1 = a;
            if (!flag) goto _L2; else goto _L1
_L1:
            n1.f.b("Skipping ad layout preparation steps because the layout is already prepared.", null);
_L6:
            flag = true;
_L4:
            return flag;
_L2:
            flag = flag1;
            if (!n1.b()) goto _L4; else goto _L3
_L3:
            if (n1.getNeedsToLoadAdOnLayout())
            {
                n1.f.d("Can't load an ad because ad loading is already in progress", null);
                return false;
            }
            if (n1.getAdSize().a())
            {
                n1.f.b("Ad size to be determined automatically.", null);
            }
            if (n1.getParent() == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            n1.b = flag;
            if (!n1.getAdSize().a() || !n1.getAdController().w)
            {
                if (n1.isLayoutRequested() && n1.getAdSize().a() && !n1.b)
                {
                    n1.d();
                    return false;
                }
                if (n1.b)
                {
                    n1.f.b("The ad's parent view is missing at load time.", null);
                    if (n1.getLayoutParams() == null)
                    {
                        ck.a().b.a(ck.a.I);
                        n1.a("Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.");
                        return false;
                    }
                    if (at.a(11))
                    {
                        n1.c = ((Activity)n1.a).getWindow().getDecorView().findViewById(0x1020002).getRootView();
                        if (n1.e())
                        {
                            n1.a("Ad load failed because root view could not be obtained from the activity.");
                            return false;
                        }
                        if (n1.c.isLayoutRequested())
                        {
                            n1.f.b("Activity root view layout is requested.", null);
                            n1.d();
                            android.view.View.OnLayoutChangeListener onlayoutchangelistener = new android.view.View.OnLayoutChangeListener(n1) {

                                final n a;

                                public final void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                                        int k2, int l2)
                                {
                                    if (a.getAndSetNeedsToLoadAdOnLayout$138603())
                                    {
                                        a.c();
                                        n.c(a);
                                        n.d(a).removeOnLayoutChangeListener(this);
                                    }
                                }

            
            {
                a = n1;
                super();
            }
                            };
                            n1.c.addOnLayoutChangeListener(onlayoutchangelistener);
                            return false;
                        }
                        n1.c();
                    } else
                    {
                        n1.c();
                    }
                }
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        public final void b()
        {
        }

        public final int c()
        {
            return !n.b(a).x.equals(ae.h) ? 2 : 0;
        }

        public final void d()
        {
        }

        a()
        {
            a = n.this;
            super();
        }
    }

    private static final class b
    {
    }


    private static final String g = com/amazon/device/ads/n.getSimpleName();
    private static ScheduledThreadPoolExecutor u;
    final Context a;
    boolean b;
    View c;
    public boolean d;
    public boolean e;
    public final cn f;
    private BroadcastReceiver h;
    private boolean i;
    private final ac j;
    private final i k;
    private h l;
    private boolean m;
    private boolean n;
    private int o;
    private AtomicBoolean p;
    private af q;
    private View r;
    private bf s;
    private boolean t;
    private final q v;
    private p w;
    private final co x;
    private final x y;
    private final r z;

    public n(Activity activity, ac ac1)
    {
        this(activity, ac1, new co(), new i(), com.amazon.device.ads.w.a(), new r());
    }

    private n(Activity activity, ac ac1, co co1, i i1, x x1, r r1)
    {
        this(activity, ac1, co1, new q(co1), i1, x1, r1);
    }

    private n(Activity activity, ac ac1, co co1, q q1, i i1, x x1, r r1)
    {
        super(activity);
        m = false;
        n = false;
        o = 8;
        p = new AtomicBoolean(false);
        b = false;
        c = null;
        q = null;
        d = false;
        e = false;
        a = activity;
        j = ac1;
        x = co1;
        f = co.a(g);
        v = q1;
        k = i1;
        y = x1;
        z = r1;
    }

    private int a(boolean flag)
    {
        DisplayMetrics displaymetrics;
        int i1;
        int j1;
        if (flag)
        {
            i1 = getLayoutParams().width;
        } else
        {
            i1 = getLayoutParams().height;
        }
        if (i1 != -1) goto _L2; else goto _L1
_L1:
        if (!e()) goto _L4; else goto _L3
_L3:
        WindowManager windowmanager = (WindowManager)a.getSystemService("window");
        displaymetrics = new DisplayMetrics();
        windowmanager.getDefaultDisplay().getMetrics(displaymetrics);
        if (!flag) goto _L6; else goto _L5
_L5:
        j1 = displaymetrics.widthPixels;
_L8:
        return j1;
_L6:
        return displaymetrics.heightPixels;
_L4:
        if (flag)
        {
            return c.getWidth();
        } else
        {
            return c.getHeight();
        }
_L2:
        j1 = i1;
        if (i1 == -2)
        {
            return 0;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    static View a(n n1, View view)
    {
        n1.r = view;
        return view;
    }

    static bf a(n n1, bf bf)
    {
        n1.s = bf;
        return bf;
    }

    static boolean a(n n1)
    {
        return n1.i;
    }

    static h b(n n1)
    {
        return n1.getAdController();
    }

    static void c(n n1)
    {
        n1.i();
    }

    static View d(n n1)
    {
        return n1.c;
    }

    static View e(n n1)
    {
        return n1.r;
    }

    static bf f(n n1)
    {
        return n1.s;
    }

    private void f()
    {
        if (e)
        {
            return;
        }
        long l1 = System.nanoTime();
        f.b("Initializing AdLayout.", null);
        y.a(a);
        setContentDescription("adLayoutObject");
        if (isInEditMode())
        {
            TextView textview = new TextView(a);
            textview.setText("AdLayout");
            textview.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
            textview.setGravity(17);
            addView(textview);
            e = true;
            return;
        }
        boolean flag;
        boolean flag1;
        if (getVisibility() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        i = flag1;
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        e = true;
        if (w == null)
        {
            setListener(null);
        }
        g();
        if (!getAdController().a().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            f.a(true, cn.a.b, "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789", new Object[0]);
            e = false;
            return;
        } else
        {
            l.f.b(ck.a.r, l1);
            l.f.c(ck.a.r);
            return;
        }
    }

    static h g(n n1)
    {
        n1.l = null;
        return null;
    }

    private void g()
    {
        if (l == null)
        {
            ac ac1;
            if (j == null)
            {
                ac1 = ac.g;
            } else
            {
                ac1 = j;
            }
            setAdController(com.amazon.device.ads.i.a(a, ac1));
            l.a(t);
        }
    }

    private void h()
    {
        if (getAdController().x.equals(ae.h))
        {
            ds.b(new Runnable() {

                final n a;

                public final void run()
                {
                    if (n.b(a).x.equals(ae.h))
                    {
                        n.b(a).j.a();
                    }
                }

            
            {
                a = n.this;
                super();
            }
            });
        }
    }

    private void i()
    {
        af af1 = q;
        ad ad1 = new ad(getAdController(), af1);
        ad1.d = true;
        z.a(getAdController().r, af1, new ad[] {
            ad1
        });
        if (!getAndResetIsPrepared())
        {
            a("Could not load ad on layout.");
        }
    }

    private void setAdController(h h1)
    {
        l = h1;
        l.s = new a();
    }

    public final void a()
    {
        if (m)
        {
            m = false;
            a.getApplicationContext().unregisterReceiver(h);
        }
    }

    final void a(String s1)
    {
        getAdController().a(s1);
    }

    public final boolean a(af af1)
    {
        af af2 = af1;
        if (af1 == null)
        {
            af2 = new af();
        }
        q = af2;
        if (getNeedsToLoadAdOnLayout())
        {
            f.d("Can't load an ad because ad loading is already in progress", null);
            return false;
        }
        f();
        if (!e)
        {
            f.d("The ad could not be initialized properly.", null);
            return false;
        }
        if (!b())
        {
            switch (_cls4.a[getAdController().x.ordinal()])
            {
            default:
                f.d("Can't load an ad because ad loading is already in progress", null);
                return false;

            case 1: // '\001'
                f.d("An ad could not be loaded because of an unknown issue with web views.", null);
                return false;

            case 2: // '\002'
                f.d("An ad could not be loaded because the AdLayout has been destroyed.", null);
                return false;

            case 3: // '\003'
                f.d("An ad could not be loaded because another ad is currently expanded.", null);
                break;
            }
            return false;
        }
        z.a(getAdController().r, af2, new ad[] {
            new ad(getAdController(), af2)
        });
        if (getNeedsToLoadAdOnLayout())
        {
            return true;
        } else
        {
            return getAndResetIsPrepared();
        }
    }

    final boolean b()
    {
        return ae.a.equals(getAdController().x) || ae.g.equals(getAdController().x);
    }

    final void c()
    {
        if (getLayoutParams().width == -1 || getLayoutParams().height == -1)
        {
            f.b("The requested ad will scale based on the screen's dimensions because at least one AdLayout dimension is set to MATCH_PARENT but the AdLayout is currently missing a fixed-size parent view.", null);
        }
        int i1 = a(true);
        int j1 = a(false);
        getAdController().a(i1, j1);
    }

    final void d()
    {
        setNeedsToLoadAdOnLayout(true);
        Runnable runnable = new Runnable() {

            final n a;

            public final void run()
            {
                n n1 = a;
                if (n1.getAndSetNeedsToLoadAdOnLayout$138603())
                {
                    ck.a().b.a(ck.a.J);
                    n1.a("Can't load an ad because the view size cannot be determined.");
                }
            }

            
            {
                a = n.this;
                super();
            }
        };
        u.schedule(runnable, getTimeout(), TimeUnit.MILLISECONDS);
    }

    final boolean e()
    {
        return c == null;
    }

    View getActivityRootView()
    {
        return c;
    }

    public h getAdController()
    {
        f();
        if (l == null)
        {
            g();
        }
        return l;
    }

    j getAdData()
    {
        return getAdController().o;
    }

    p getAdListenerExecutor()
    {
        return w;
    }

    public ac getAdSize()
    {
        h h1 = getAdController();
        if (h1 == null)
        {
            return null;
        } else
        {
            return h1.c;
        }
    }

    boolean getAndResetIsPrepared()
    {
        return getAdController().h();
    }

    final boolean getAndSetNeedsToLoadAdOnLayout$138603()
    {
        return p.getAndSet(false);
    }

    cn getLogger()
    {
        return f;
    }

    boolean getNeedsToLoadAdOnLayout()
    {
        return p.get();
    }

    public int getTimeout()
    {
        if (getAdController() == null)
        {
            return -1;
        } else
        {
            return getAdController().r;
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (!isInEditMode())
        {
            n = true;
            if (!m)
            {
                m = true;
                h = new BroadcastReceiver() {

                    final n a;

                    public final void onReceive(Context context, Intent intent)
                    {
                        if (intent.getAction().equals("android.intent.action.SCREEN_OFF") && n.a(a))
                        {
                            n.b(a).j.a();
                        }
                    }

            
            {
                a = n.this;
                super();
            }
                };
                IntentFilter intentfilter = new IntentFilter("android.intent.action.SCREEN_OFF");
                intentfilter.addAction("android.intent.action.USER_PRESENT");
                a.getApplicationContext().registerReceiver(h, intentfilter);
                return;
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        n = false;
        h();
        a();
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (!d)
        {
            super.onLayout(flag, i1, j1, k1, l1);
            if (!isInEditMode())
            {
                getAdController().a(k1 - i1, l1 - j1);
                if (getAndSetNeedsToLoadAdOnLayout$138603())
                {
                    i();
                    return;
                }
            }
        }
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        if (n && o != i1)
        {
            if (i1 != 0)
            {
                i = false;
                h();
                a();
            } else
            if (i1 == 0)
            {
                i = true;
                return;
            }
        }
    }

    void setIsParentViewMissingAtLoadTime(boolean flag)
    {
        b = flag;
    }

    public void setListener(o o1)
    {
        Object obj = o1;
        if (o1 == null)
        {
            obj = new bd(g);
        }
        w = v.a(((o) (obj)));
    }

    void setNeedsToLoadAdOnLayout(boolean flag)
    {
        p.set(flag);
    }

    void setShouldDisableWebViewHardwareAcceleration(boolean flag)
    {
        t = flag;
        if (l != null)
        {
            l.a(t);
        }
    }

    public void setTimeout(int i1)
    {
        h h1 = getAdController();
        if (h1 != null)
        {
            h1.r = i1;
        }
    }

    static 
    {
        ScheduledThreadPoolExecutor scheduledthreadpoolexecutor = new ScheduledThreadPoolExecutor(1);
        u = scheduledthreadpoolexecutor;
        scheduledthreadpoolexecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
    }
}
