// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import com.mopub.common.b;
import com.mopub.common.c.a;
import com.mopub.common.g;
import com.mopub.common.m;
import com.mopub.common.n;
import com.mopub.common.o;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.lang.ref.WeakReference;
import java.net.URI;

// Referenced classes of package com.mopub.b:
//            a, j, k, f, 
//            g, e, b, i

public final class com.mopub.b.c
{
    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();
    }

    public final class b extends BroadcastReceiver
    {

        public Context a;
        final com.mopub.b.c b;
        private int c;

        public final void onReceive(Context context, Intent intent)
        {
            if (a != null && "android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()))
            {
                int i1 = ((WindowManager)b.a.getSystemService("window")).getDefaultDisplay().getRotation();
                if (i1 != c)
                {
                    c = i1;
                    b.a(null);
                    return;
                }
            }
        }

        b()
        {
            b = com.mopub.b.c.this;
            super();
            c = -1;
        }
    }

    public static final class c
    {

        final Handler a = new Handler();
        a b;

        public final void a()
        {
            if (b != null)
            {
                a a1 = b;
                a1.b.removeCallbacks(a1.e);
                a1.c = null;
                b = null;
            }
        }

        c()
        {
        }
    }

    static final class c.a
    {

        final View a[];
        final Handler b;
        Runnable c;
        int d;
        final Runnable e;

        static void a(c.a a1)
        {
            a1.d = a1.d - 1;
            if (a1.d == 0 && a1.c != null)
            {
                a1.c.run();
                a1.c = null;
            }
        }

        private c.a(Handler handler, View aview[])
        {
            e = new _cls1(this);
            b = handler;
            a = aview;
        }

        c.a(Handler handler, View aview[], byte byte0)
        {
            this(handler, aview);
        }
    }

    public static interface d
    {

        public abstract void a(boolean flag);
    }


    public final Context a;
    final j b;
    public final FrameLayout c;
    public final g d;
    public final c e;
    final com.mopub.b.g f;
    k g;
    public a h;
    public d i;
    public i j;
    public a.b k;
    public a.b l;
    public final com.mopub.b.a m;
    public final com.mopub.b.a n;
    public b o;
    public boolean p;
    private final com.mopub.common.b q;
    private final WeakReference r;
    private ViewGroup s;
    private Integer t;
    private boolean u;
    private f v;
    private final e w;
    private final a.a x;
    private final a.a y;

    public com.mopub.b.c(Context context, com.mopub.common.b b1, j j1)
    {
        this(context, b1, j1, new com.mopub.b.a(b1, j1), new com.mopub.b.a(b1, com.mopub.b.j.b), new c());
    }

    private com.mopub.b.c(Context context, com.mopub.common.b b1, j j1, com.mopub.b.a a1, com.mopub.b.a a2, c c1)
    {
        g = com.mopub.b.k.a;
        o = new b();
        u = true;
        v = f.c;
        x = new a.a() {

            final com.mopub.b.c a;

            public final void a()
            {
                com.mopub.b.c c2 = a;
                c2.a(com.mopub.b.k.b, c2. new Runnable() {

                    final com.mopub.b.c a;

                    public final void run()
                    {
                        a.m.a(com.mopub.b.e.b(a.a), com.mopub.b.e.a(a.a), com.mopub.b.e.d(a.a), com.mopub.b.e.c(a.a), com.mopub.b.c.a(a));
                        a.m.a(a.b);
                        a.m.a(a.m.a());
                        a.m.a("mraidbridge.notifyReadyEvent();");
                    }

            
            {
                a = com.mopub.b.c.this;
                super();
            }
                });
                if (c2.h != null)
                {
                    c2.h.a();
                }
            }

            public final void a(int i1, int k1, int l1, int i2, com.mopub.common.g.a a3, boolean flag)
            {
                com.mopub.b.c c2;
                Object obj;
                c2 = a;
                if (c2.k == null)
                {
                    throw new com.mopub.b.b("Unable to resize after the WebView is destroyed");
                }
                if (c2.g == com.mopub.b.k.a || c2.g == k.e)
                {
                    return;
                }
                if (c2.g == k.d)
                {
                    throw new com.mopub.b.b("Not allowed to resize from an already expanded ad");
                }
                if (c2.b == com.mopub.b.j.b)
                {
                    throw new com.mopub.b.b("Not allowed to resize from an interstitial ad");
                }
                int j2 = com.mopub.common.d.d.b(i1, c2.a);
                int k2 = com.mopub.common.d.d.b(k1, c2.a);
                int i3 = com.mopub.common.d.d.b(l1, c2.a);
                int l2 = com.mopub.common.d.d.b(i2, c2.a);
                i3 += c2.f.g.left;
                l2 += c2.f.g.top;
                Rect rect = new Rect(i3, l2, j2 + i3, l2 + k2);
                if (!flag)
                {
                    Rect rect1 = c2.f.c;
                    if (rect.width() > rect1.width() || rect.height() > rect1.height())
                    {
                        throw new com.mopub.b.b((new StringBuilder("resizeProperties specified a size (")).append(i1).append(", ").append(k1).append(") and offset (").append(l1).append(", ").append(i2).append(") that doesn't allow the ad to appear within the max allowed size (").append(c2.f.d.width()).append(", ").append(c2.f.d.height()).append(")").toString());
                    }
                    rect.offsetTo(com.mopub.b.c.a(rect1.left, rect.left, rect1.right - rect.width()), com.mopub.b.c.a(rect1.top, rect.top, rect1.bottom - rect.height()));
                }
                obj = new Rect();
                c2.d.a(a3, rect, ((Rect) (obj)));
                if (!c2.f.c.contains(((Rect) (obj))))
                {
                    throw new com.mopub.b.b((new StringBuilder("resizeProperties specified a size (")).append(i1).append(", ").append(k1).append(") and offset (").append(l1).append(", ").append(i2).append(") that doesn't allow the close region to appear within the max allowed size (").append(c2.f.d.width()).append(", ").append(c2.f.d.height()).append(")").toString());
                }
                if (!rect.contains(((Rect) (obj))))
                {
                    throw new com.mopub.b.b((new StringBuilder("resizeProperties specified a size (")).append(i1).append(", ").append(k2).append(") and offset (").append(l1).append(", ").append(i2).append(") that don't allow the close region to appear within the resized ad.").toString());
                }
                c2.d.setCloseVisible(false);
                c2.d.setClosePosition(a3);
                obj = new android.widget.FrameLayout.LayoutParams(rect.width(), rect.height());
                obj.leftMargin = rect.left - c2.f.c.left;
                obj.topMargin = rect.top - c2.f.c.top;
                if (c2.g != com.mopub.b.k.b) goto _L2; else goto _L1
_L1:
                c2.c.removeView(c2.k);
                c2.c.setVisibility(4);
                c2.d.addView(c2.k, new android.widget.FrameLayout.LayoutParams(-1, -1));
                c2.c().addView(c2.d, ((android.view.ViewGroup.LayoutParams) (obj)));
_L4:
                c2.d.setClosePosition(a3);
                c2.a(k.c, null);
                return;
_L2:
                if (c2.g == k.c)
                {
                    c2.d.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public final void a(URI uri)
            {
                a.c(uri.toString());
            }

            public final void a(URI uri, boolean flag)
            {
                com.mopub.b.c c2;
                c2 = a;
                if (c2.k == null)
                {
                    throw new com.mopub.b.b("Unable to expand after the WebView is destroyed");
                }
                if (c2.b == com.mopub.b.j.b || c2.g != com.mopub.b.k.b && c2.g != k.c) goto _L2; else goto _L1
_L1:
                boolean flag1;
                c2.d();
                if (uri != null)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    c2.l = new a.b(c2.a);
                    c2.n.a(c2.l);
                    com.mopub.b.a a3 = c2.n;
                    uri = uri.toString();
                    if (a3.b == null)
                    {
                        com.mopub.common.c.a.b("MRAID bridge called setContentHtml while WebView was not attached");
                    } else
                    {
                        a3.d = false;
                        a3.b.loadUrl(uri);
                    }
                }
                uri = new android.widget.FrameLayout.LayoutParams(-1, -1);
                if (c2.g != com.mopub.b.k.b) goto _L4; else goto _L3
_L3:
                if (flag1)
                {
                    c2.d.addView(c2.l, uri);
                } else
                {
                    c2.c.removeView(c2.k);
                    c2.c.setVisibility(4);
                    c2.d.addView(c2.k, uri);
                }
                c2.c().addView(c2.d, new android.widget.FrameLayout.LayoutParams(-1, -1));
_L6:
                c2.d.setLayoutParams(uri);
                c2.b(flag);
                c2.a(k.d, null);
_L2:
                return;
_L4:
                if (c2.g == k.c && flag1)
                {
                    c2.d.removeView(c2.k);
                    c2.c.addView(c2.k, uri);
                    c2.c.setVisibility(4);
                    c2.d.addView(c2.l, uri);
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            public final void a(boolean flag)
            {
                if (!a.n.b())
                {
                    a.m.a(flag);
                }
            }

            public final void a(boolean flag, f f1)
            {
                a.a(flag, f1);
            }

            public final boolean a(JsResult jsresult)
            {
                return a.a(jsresult);
            }

            public final void b()
            {
                if (a.h != null)
                {
                    a.h.b();
                }
            }

            public final void b(URI uri)
            {
                a.a(uri.toString());
            }

            public final void b(boolean flag)
            {
                a.b(flag);
            }

            public final boolean c()
            {
                return a.a();
            }

            public final void d()
            {
                a.b();
            }

            
            {
                a = com.mopub.b.c.this;
                super();
            }
        };
        y = new a.a() {

            final com.mopub.b.c a;

            public final void a()
            {
                com.mopub.b.c c2 = a;
                c2.a(c2. new Runnable() {

                    final com.mopub.b.c a;

                    public final void run()
                    {
                        a.n.a(com.mopub.b.e.b(a.a), com.mopub.b.e.a(a.a), com.mopub.b.e.d(a.a), com.mopub.b.e.c(a.a), com.mopub.b.c.a(a));
                        a.n.a(a.g);
                        a.n.a(a.b);
                        a.n.a(a.n.a());
                        a.n.a("mraidbridge.notifyReadyEvent();");
                    }

            
            {
                a = com.mopub.b.c.this;
                super();
            }
                });
            }

            public final void a(int i1, int k1, int l1, int i2, com.mopub.common.g.a a3, boolean flag)
            {
                throw new com.mopub.b.b("Not allowed to resize from an expanded state");
            }

            public final void a(URI uri)
            {
                a.c(uri.toString());
            }

            public final void a(URI uri, boolean flag)
            {
            }

            public final void a(boolean flag)
            {
                a.m.a(flag);
                a.n.a(flag);
            }

            public final void a(boolean flag, f f1)
            {
                a.a(flag, f1);
            }

            public final boolean a(JsResult jsresult)
            {
                return a.a(jsresult);
            }

            public final void b()
            {
            }

            public final void b(URI uri)
            {
                a.a(uri.toString());
            }

            public final void b(boolean flag)
            {
                a.b(flag);
            }

            public final boolean c()
            {
                return a.a();
            }

            public final void d()
            {
                a.b();
            }

            
            {
                a = com.mopub.b.c.this;
                super();
            }
        };
        a = context.getApplicationContext();
        com.mopub.common.m.a(a);
        q = b1;
        if (context instanceof Activity)
        {
            r = new WeakReference((Activity)context);
        } else
        {
            r = new WeakReference(null);
        }
        b = j1;
        m = a1;
        n = a2;
        e = c1;
        g = com.mopub.b.k.a;
        context = a.getResources().getDisplayMetrics();
        f = new com.mopub.b.g(a, ((DisplayMetrics) (context)).density);
        c = new FrameLayout(a);
        d = new g(a);
        d.setOnCloseListener(new com.mopub.common.g.b() {

            final com.mopub.b.c a;

            public final void a()
            {
                a.b();
            }

            
            {
                a = com.mopub.b.c.this;
                super();
            }
        });
        context = new View(a);
        context.setOnTouchListener(new android.view.View.OnTouchListener() {

            final com.mopub.b.c a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = com.mopub.b.c.this;
                super();
            }
        });
        d.addView(context, new android.widget.FrameLayout.LayoutParams(-1, -1));
        context = o;
        b1 = a;
        com.mopub.common.m.a(b1);
        context.a = b1.getApplicationContext();
        if (((b) (context)).a != null)
        {
            ((b) (context)).a.registerReceiver(context, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        m.a = x;
        n.a = y;
        w = new e();
    }

    static int a(int i1, int j1, int k1)
    {
        return Math.max(i1, Math.min(j1, k1));
    }

    private void a(int i1)
    {
        Activity activity = (Activity)r.get();
        if (activity == null || !a(v))
        {
            throw new com.mopub.b.b((new StringBuilder("Attempted to lock orientation to unsupported value: ")).append(v.name()).toString());
        }
        if (t == null)
        {
            t = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i1);
    }

    static boolean a(com.mopub.b.c c1)
    {
        Activity activity = (Activity)c1.r.get();
        if (activity == null || c1.e() == null)
        {
            return false;
        } else
        {
            return com.mopub.b.e.a(activity, c1.e());
        }
    }

    private boolean a(f f1)
    {
        boolean flag2 = false;
        boolean flag;
        if (f1 == f.c)
        {
            flag = true;
        } else
        {
            Object obj = (Activity)r.get();
            flag = flag2;
            if (obj != null)
            {
                int i1;
                try
                {
                    obj = ((Activity) (obj)).getPackageManager().getActivityInfo(new ComponentName(((Context) (obj)), obj.getClass()), 0);
                }
                // Misplaced declaration of an exception variable
                catch (f f1)
                {
                    return false;
                }
                i1 = ((ActivityInfo) (obj)).screenOrientation;
                if (i1 != -1)
                {
                    flag = flag2;
                    if (i1 == f1.d)
                    {
                        return true;
                    }
                } else
                {
                    boolean flag3 = com.mopub.common.d.m.a(((ActivityInfo) (obj)).configChanges, 128);
                    boolean flag1 = flag3;
                    if (android.os.Build.VERSION.SDK_INT >= 13)
                    {
                        if (flag3 && com.mopub.common.d.m.a(((ActivityInfo) (obj)).configChanges, 1024))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    private View e()
    {
        if (n.b())
        {
            return l;
        } else
        {
            return k;
        }
    }

    private void f()
    {
        Activity activity = (Activity)r.get();
        if (activity != null && t != null)
        {
            activity.setRequestedOrientation(t.intValue());
        }
        t = null;
    }

    final void a(k k1, Runnable runnable)
    {
        com.mopub.common.c.a.b((new StringBuilder("MRAID state set to ")).append(k1).toString());
        g = k1;
        m.a(k1);
        if (n.d)
        {
            n.a(k1);
        }
        if (h != null && k1 != k.d && k1 == k.e)
        {
            h.c();
        }
        a(runnable);
    }

    final void a(Runnable runnable)
    {
        e.a();
        View view = e();
        if (view == null)
        {
            return;
        } else
        {
            Object obj = e;
            FrameLayout framelayout = c;
            obj.b = new c.a(((c) (obj)).a, new View[] {
                framelayout, view
            }, (byte)0);
            obj = ((c) (obj)).b;
            obj.c = new Runnable(view, runnable) {

                final View a;
                final Runnable b;
                final com.mopub.b.c c;

                public final void run()
                {
                    DisplayMetrics displaymetrics = c.a.getResources().getDisplayMetrics();
                    Object obj1 = c.f;
                    int i1 = displaymetrics.widthPixels;
                    int j1 = displaymetrics.heightPixels;
                    ((com.mopub.b.g) (obj1)).a.set(0, 0, i1, j1);
                    ((com.mopub.b.g) (obj1)).a(((com.mopub.b.g) (obj1)).a, ((com.mopub.b.g) (obj1)).b);
                    int ai[] = new int[2];
                    obj1 = c.c();
                    ((View) (obj1)).getLocationOnScreen(ai);
                    com.mopub.b.g g1 = c.f;
                    i1 = ai[0];
                    j1 = ai[1];
                    int k1 = ((View) (obj1)).getWidth();
                    int l1 = ((View) (obj1)).getHeight();
                    g1.c.set(i1, j1, k1 + i1, l1 + j1);
                    g1.a(g1.c, g1.d);
                    c.c.getLocationOnScreen(ai);
                    obj1 = c.f;
                    i1 = ai[0];
                    j1 = ai[1];
                    k1 = c.c.getWidth();
                    l1 = c.c.getHeight();
                    ((com.mopub.b.g) (obj1)).g.set(i1, j1, k1 + i1, l1 + j1);
                    ((com.mopub.b.g) (obj1)).a(((com.mopub.b.g) (obj1)).g, ((com.mopub.b.g) (obj1)).h);
                    a.getLocationOnScreen(ai);
                    obj1 = c.f;
                    i1 = ai[0];
                    j1 = ai[1];
                    k1 = a.getWidth();
                    l1 = a.getHeight();
                    ((com.mopub.b.g) (obj1)).e.set(i1, j1, k1 + i1, l1 + j1);
                    ((com.mopub.b.g) (obj1)).a(((com.mopub.b.g) (obj1)).e, ((com.mopub.b.g) (obj1)).f);
                    c.m.a(c.f);
                    if (c.n.b())
                    {
                        c.n.a(c.f);
                    }
                    if (b != null)
                    {
                        b.run();
                    }
                }

            
            {
                c = com.mopub.b.c.this;
                a = view;
                b = runnable;
                super();
            }
            };
            obj.d = ((c.a) (obj)).a.length;
            ((c.a) (obj)).b.post(((c.a) (obj)).e);
            return;
        }
    }

    final void a(String s1)
    {
        MraidVideoPlayerActivity.a(a, s1);
    }

    public final void a(boolean flag)
    {
        p = true;
        if (k != null)
        {
            com.mopub.mobileads.c.a.a(k, flag);
        }
        if (l != null)
        {
            com.mopub.mobileads.c.a.a(l, flag);
        }
    }

    final void a(boolean flag, f f1)
    {
        if (!a(f1))
        {
            throw new com.mopub.b.b((new StringBuilder("Unable to force orientation to ")).append(f1).toString());
        }
        u = flag;
        v = f1;
        if (g == k.d || b == com.mopub.b.j.b)
        {
            d();
        }
    }

    final boolean a()
    {
        if (j != null)
        {
            return j.b();
        } else
        {
            return true;
        }
    }

    final boolean a(JsResult jsresult)
    {
        if (j != null)
        {
            return j.a();
        } else
        {
            jsresult.confirm();
            return true;
        }
    }

    final void b()
    {
        if (k != null && g != com.mopub.b.k.a && g != k.e)
        {
            if (g == k.d || b == com.mopub.b.j.b)
            {
                f();
            }
            if (g == k.c || g == k.d)
            {
                if (n.b() && l != null)
                {
                    d.removeView(l);
                    n.b = null;
                } else
                {
                    d.removeView(k);
                    c.addView(k, new android.widget.FrameLayout.LayoutParams(-1, -1));
                    c.setVisibility(0);
                }
                c().removeView(d);
                a(com.mopub.b.k.b, ((Runnable) (null)));
                return;
            }
            if (g == com.mopub.b.k.b)
            {
                c.setVisibility(4);
                a(k.e, ((Runnable) (null)));
                return;
            }
        }
    }

    public final void b(String s1)
    {
        m.a(s1);
    }

    final void b(boolean flag)
    {
        boolean flag3 = true;
        boolean flag1;
        if (!d.a.isVisible())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag != flag1)
        {
            g g1 = d;
            boolean flag2;
            if (!flag)
            {
                flag2 = flag3;
            } else
            {
                flag2 = false;
            }
            g1.setCloseVisible(flag2);
            if (i != null)
            {
                i.a(flag);
                return;
            }
        }
    }

    final ViewGroup c()
    {
        if (s == null)
        {
            if (android.os.Build.VERSION.SDK_INT >= 19)
            {
                com.mopub.common.m.b(c.isAttachedToWindow());
            }
            s = (ViewGroup)c.getRootView().findViewById(0x1020002);
        }
        return s;
    }

    final void c(String s1)
    {
        if (h != null)
        {
            h.d();
        }
        (new com.mopub.common.o.a()).a(n.b, new n[] {
            n.d, n.f, n.g, n.h, n.i
        }).a().a(a, s1);
    }

    final void d()
    {
        if (v == f.c)
        {
            if (u)
            {
                f();
                return;
            }
            Activity activity = (Activity)r.get();
            if (activity == null)
            {
                throw new com.mopub.b.b("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            } else
            {
                a(com.mopub.common.d.c.a(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation));
                return;
            }
        } else
        {
            a(v.d);
            return;
        }
    }

    // Unreferenced inner class com/mopub/b/c$c$a$1

/* anonymous class */
    final class c.a._cls1
        implements Runnable
    {

        final c.a a;

        public final void run()
        {
            View aview[] = a.a;
            int j1 = aview.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                View view = aview[i1];
                if (view.getHeight() > 0 || view.getWidth() > 0)
                {
                    com.mopub.b.c.a.a(a);
                } else
                {
                    view.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(this, view) {

                        final View a;
                        final c.a._cls1 b;

                        public final boolean onPreDraw()
                        {
                            a.getViewTreeObserver().removeOnPreDrawListener(this);
    final class c.a._cls1
        implements Runnable
    {
                            com.mopub.b.c.a.a(b.a);
                            return true;
                        }

            
            {
                b = _pcls1;
                a = view;
                super();
            }
                    });
                }
                i1++;
            }
        }

            
            {
                a = a1;
                super();
            }
    }

}
