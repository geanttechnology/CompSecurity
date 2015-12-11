// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.ai;
import android.support.v4.view.aj;
import android.support.v4.view.w;
import android.support.v7.a.a;
import android.support.v7.internal.view.e;
import android.support.v7.internal.view.f;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.h;
import android.support.v7.internal.widget.m;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class d extends android.support.v7.a.a
    implements android.support.v7.internal.widget.ActionBarOverlayLayout.a
{
    public final class a extends android.support.v7.e.a
        implements android.support.v7.internal.view.menu.f.a
    {

        final d a;
        private final Context d;
        private final android.support.v7.internal.view.menu.f e;
        private android.support.v7.e.a.a f;
        private WeakReference g;

        public final MenuInflater a()
        {
            return new e(d);
        }

        public final void a(int i1)
        {
            b(d.l(a).getResources().getString(i1));
        }

        public final void a(android.support.v7.internal.view.menu.f f1)
        {
            if (f == null)
            {
                return;
            } else
            {
                d();
                d.j(a).a();
                return;
            }
        }

        public final void a(View view)
        {
            d.j(a).setCustomView(view);
            g = new WeakReference(view);
        }

        public final void a(CharSequence charsequence)
        {
            d.j(a).setSubtitle(charsequence);
        }

        public final void a(boolean flag)
        {
            super.a(flag);
            d.j(a).setTitleOptional(flag);
        }

        public final boolean a(android.support.v7.internal.view.menu.f f1, MenuItem menuitem)
        {
            if (f != null)
            {
                return f.a(this, menuitem);
            } else
            {
                return false;
            }
        }

        public final Menu b()
        {
            return e;
        }

        public final void b(int i1)
        {
            a(d.l(a).getResources().getString(i1));
        }

        public final void b(CharSequence charsequence)
        {
            d.j(a).setTitle(charsequence);
        }

        public final void c()
        {
            if (a.a != this)
            {
                return;
            }
            ActionBarContextView actionbarcontextview;
            if (!android.support.v7.internal.a.d.a(android.support.v7.internal.a.d.h(a), d.i(a)))
            {
                a.b = this;
                a.c = f;
            } else
            {
                f.a(this);
            }
            f = null;
            a.g(false);
            actionbarcontextview = d.j(a);
            if (actionbarcontextview.m != 2)
            {
                if (actionbarcontextview.j == null)
                {
                    actionbarcontextview.c();
                } else
                {
                    actionbarcontextview.b();
                    actionbarcontextview.m = 2;
                    actionbarcontextview.l = actionbarcontextview.d();
                    actionbarcontextview.l.a();
                }
            }
            d.k(a).a().sendAccessibilityEvent(32);
            d.g(a).setHideOnContentScrollEnabled(a.d);
            a.a = null;
        }

        public final void d()
        {
            if (a.a != this)
            {
                return;
            }
            e.d();
            f.b(this, e);
            e.e();
            return;
            Exception exception;
            exception;
            e.e();
            throw exception;
        }

        public final boolean e()
        {
            e.d();
            boolean flag = f.a(this, e);
            e.e();
            return flag;
            Exception exception;
            exception;
            e.e();
            throw exception;
        }

        public final CharSequence f()
        {
            return d.j(a).getTitle();
        }

        public final CharSequence g()
        {
            return d.j(a).getSubtitle();
        }

        public final boolean h()
        {
            return d.j(a).k;
        }

        public final View i()
        {
            if (g != null)
            {
                return (View)g.get();
            } else
            {
                return null;
            }
        }

        public a(Context context, android.support.v7.e.a.a a1)
        {
            a = d.this;
            super();
            d = context;
            f = a1;
            d1 = new android.support.v7.internal.view.menu.f(context);
            d.this.e = 1;
            e = d.this;
            e.a(this);
        }
    }


    static final boolean h;
    private static final boolean i;
    private boolean A;
    private int B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private f H;
    private boolean I;
    a a;
    android.support.v7.e.a b;
    android.support.v7.e.a.a c;
    boolean d;
    final ah e;
    final ah f;
    final aj g;
    private Context j;
    private Context k;
    private Activity l;
    private Dialog m;
    private ActionBarOverlayLayout n;
    private ActionBarContainer o;
    private h p;
    private ActionBarContextView q;
    private ActionBarContainer r;
    private View s;
    private m t;
    private ArrayList u;
    private int v;
    private boolean w;
    private boolean x;
    private ArrayList y;
    private int z;

    public d(Activity activity, boolean flag)
    {
        u = new ArrayList();
        v = -1;
        y = new ArrayList();
        B = 0;
        C = true;
        G = true;
        e = new ai() {

            final d a;

            public final void b(View view)
            {
                if (android.support.v7.internal.a.d.a(a) && d.b(a) != null)
                {
                    android.support.v4.view.w.b(d.b(a), 0.0F);
                    android.support.v4.view.w.b(d.c(a), 0.0F);
                }
                if (d.d(a) != null && android.support.v7.internal.a.d.e(a) == 1)
                {
                    d.d(a).setVisibility(8);
                }
                d.c(a).setVisibility(8);
                d.c(a).setTransitioning(false);
                android.support.v7.internal.a.d.f(a);
                view = a;
                if (((d) (view)).c != null)
                {
                    ((d) (view)).c.a(((d) (view)).b);
                    view.b = null;
                    view.c = null;
                }
                if (d.g(a) != null)
                {
                    android.support.v4.view.w.q(d.g(a));
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        f = new ai() {

            final d a;

            public final void b(View view)
            {
                android.support.v7.internal.a.d.f(a);
                d.c(a).requestLayout();
            }

            
            {
                a = d.this;
                super();
            }
        };
        g = new aj() {

            final d a;

            public final void a()
            {
                ((View)d.c(a).getParent()).invalidate();
            }

            
            {
                a = d.this;
                super();
            }
        };
        l = activity;
        activity = activity.getWindow().getDecorView();
        a(activity);
        if (!flag)
        {
            s = activity.findViewById(0x1020002);
        }
    }

    public d(Dialog dialog)
    {
        u = new ArrayList();
        v = -1;
        y = new ArrayList();
        B = 0;
        C = true;
        G = true;
        e = new _cls1();
        f = new _cls2();
        g = new _cls3();
        m = dialog;
        a(dialog.getWindow().getDecorView());
    }

    private void a(int i1, int j1)
    {
        int k1 = p.m();
        if ((j1 & 4) != 0)
        {
            w = true;
        }
        p.c(k1 & ~j1 | i1 & j1);
    }

    private void a(View view)
    {
        Object obj;
        n = (ActionBarOverlayLayout)view.findViewById(android.support.v7.b.a.f.decor_content_parent);
        if (n != null)
        {
            n.setActionBarVisibilityCallback(this);
        }
        obj = view.findViewById(android.support.v7.b.a.f.action_bar);
        if (!(obj instanceof h)) goto _L2; else goto _L1
_L1:
        obj = (h)obj;
_L4:
        p = ((h) (obj));
        q = (ActionBarContextView)view.findViewById(android.support.v7.b.a.f.action_context_bar);
        o = (ActionBarContainer)view.findViewById(android.support.v7.b.a.f.action_bar_container);
        r = (ActionBarContainer)view.findViewById(android.support.v7.b.a.f.split_action_bar);
        if (p == null || q == null || o == null)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used with a compatible window decor layout").toString());
        }
        break MISSING_BLOCK_LABEL_210;
_L2:
        if (!(obj instanceof Toolbar))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((Toolbar)obj).getWrapper();
        if (true) goto _L4; else goto _L3
_L3:
        if ((new StringBuilder("Can't make a decor toolbar out of ")).append(obj).toString() != null)
        {
            view = obj.getClass().getSimpleName();
        } else
        {
            view = "null";
        }
        throw new IllegalStateException(view);
        j = p.b();
        z = 0;
        int i1;
        if ((p.m() & 4) != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            w = true;
        }
        view = android.support.v7.internal.view.a.a(j);
        i1 = ((android.support.v7.internal.view.a) (view)).a.getApplicationInfo().targetSdkVersion;
        h(view.a());
        view = j.obtainStyledAttributes(null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.a.actionBarStyle, 0);
        if (view.getBoolean(android.support.v7.b.a.k.ActionBar_hideOnContentScroll, false))
        {
            if (!n.a)
            {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            d = true;
            n.setHideOnContentScrollEnabled(true);
        }
        i1 = view.getDimensionPixelSize(android.support.v7.b.a.k.ActionBar_elevation, 0);
        if (i1 != 0)
        {
            float f1 = i1;
            android.support.v4.view.w.f(o, f1);
            if (r != null)
            {
                android.support.v4.view.w.f(r, f1);
            }
        }
        view.recycle();
        return;
    }

    static boolean a(d d1)
    {
        return d1.C;
    }

    static boolean a(boolean flag, boolean flag1)
    {
        return a(flag, flag1, false);
    }

    private static boolean a(boolean flag, boolean flag1, boolean flag2)
    {
        while (flag2 || !flag && !flag1) 
        {
            return true;
        }
        return false;
    }

    static View b(d d1)
    {
        return d1.s;
    }

    static ActionBarContainer c(d d1)
    {
        return d1.o;
    }

    static ActionBarContainer d(d d1)
    {
        return d1.r;
    }

    static int e(d d1)
    {
        return d1.z;
    }

    static f f(d d1)
    {
        d1.H = null;
        return null;
    }

    static ActionBarOverlayLayout g(d d1)
    {
        return d1.n;
    }

    private void h(boolean flag)
    {
        boolean flag2 = true;
        A = flag;
        Object obj;
        boolean flag1;
        if (!A)
        {
            p.a(null);
            o.setTabContainer(t);
        } else
        {
            o.setTabContainer(null);
            p.a(t);
        }
        if (p.n() == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (t != null)
        {
            if (flag1)
            {
                t.setVisibility(0);
                if (n != null)
                {
                    android.support.v4.view.w.q(n);
                }
            } else
            {
                t.setVisibility(8);
            }
        }
        obj = p;
        if (!A && flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((h) (obj)).a(flag);
        obj = n;
        if (!A && flag1)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        ((ActionBarOverlayLayout) (obj)).setHasNonEmbeddedTabs(flag);
    }

    static boolean h(d d1)
    {
        return d1.D;
    }

    private void i(boolean flag)
    {
        if (a(D, E, F))
        {
            if (!G)
            {
                G = true;
                if (H != null)
                {
                    H.b();
                }
                o.setVisibility(0);
                if (B == 0 && i && (I || flag))
                {
                    android.support.v4.view.w.b(o, 0.0F);
                    float f3 = -o.getHeight();
                    float f1 = f3;
                    if (flag)
                    {
                        int ai[] = new int[2];
                        int[] _tmp = ai;
                        ai[0] = 0;
                        ai[1] = 0;
                        o.getLocationInWindow(ai);
                        f1 = f3 - (float)ai[1];
                    }
                    android.support.v4.view.w.b(o, f1);
                    f f5 = new f();
                    ad ad1 = android.support.v4.view.w.n(o).c(0.0F);
                    ad1.a(g);
                    f5.a(ad1);
                    if (C && s != null)
                    {
                        android.support.v4.view.w.b(s, f1);
                        f5.a(android.support.v4.view.w.n(s).c(0.0F));
                    }
                    if (r != null && z == 1)
                    {
                        android.support.v4.view.w.b(r, r.getHeight());
                        r.setVisibility(0);
                        f5.a(android.support.v4.view.w.n(r).c(0.0F));
                    }
                    f5.a(AnimationUtils.loadInterpolator(j, 0x10a0006));
                    f5.c();
                    f5.a(f);
                    H = f5;
                    f5.a();
                } else
                {
                    android.support.v4.view.w.c(o, 1.0F);
                    android.support.v4.view.w.b(o, 0.0F);
                    if (C && s != null)
                    {
                        android.support.v4.view.w.b(s, 0.0F);
                    }
                    if (r != null && z == 1)
                    {
                        android.support.v4.view.w.c(r, 1.0F);
                        android.support.v4.view.w.b(r, 0.0F);
                        r.setVisibility(0);
                    }
                    f.b(null);
                }
                if (n != null)
                {
                    android.support.v4.view.w.q(n);
                }
            }
        } else
        if (G)
        {
            G = false;
            if (H != null)
            {
                H.b();
            }
            if (B == 0 && i && (I || flag))
            {
                android.support.v4.view.w.c(o, 1.0F);
                o.setTransitioning(true);
                f f6 = new f();
                float f4 = -o.getHeight();
                float f2 = f4;
                if (flag)
                {
                    int ai1[] = new int[2];
                    int[] _tmp1 = ai1;
                    ai1[0] = 0;
                    ai1[1] = 0;
                    o.getLocationInWindow(ai1);
                    f2 = f4 - (float)ai1[1];
                }
                ad ad2 = android.support.v4.view.w.n(o).c(f2);
                ad2.a(g);
                f6.a(ad2);
                if (C && s != null)
                {
                    f6.a(android.support.v4.view.w.n(s).c(f2));
                }
                if (r != null && r.getVisibility() == 0)
                {
                    android.support.v4.view.w.c(r, 1.0F);
                    f6.a(android.support.v4.view.w.n(r).c(r.getHeight()));
                }
                f6.a(AnimationUtils.loadInterpolator(j, 0x10a0005));
                f6.c();
                f6.a(e);
                H = f6;
                f6.a();
                return;
            } else
            {
                e.b(null);
                return;
            }
        }
    }

    static boolean i(d d1)
    {
        return d1.E;
    }

    static ActionBarContextView j(d d1)
    {
        return d1.q;
    }

    static h k(d d1)
    {
        return d1.p;
    }

    static Context l(d d1)
    {
        return d1.j;
    }

    public final int a()
    {
        return p.m();
    }

    public final android.support.v7.e.a a(android.support.v7.e.a.a a1)
    {
        if (a != null)
        {
            a.c();
        }
        n.setHideOnContentScrollEnabled(false);
        q.c();
        a1 = new a(q.getContext(), a1);
        if (a1.e())
        {
            a1.d();
            q.a(a1);
            g(true);
            if (r != null && z == 1 && r.getVisibility() != 0)
            {
                r.setVisibility(0);
                if (n != null)
                {
                    android.support.v4.view.w.q(n);
                }
            }
            q.sendAccessibilityEvent(32);
            a = a1;
            return a1;
        } else
        {
            return null;
        }
    }

    public final void a(int i1)
    {
        B = i1;
    }

    public final void a(Configuration configuration)
    {
        h(android.support.v7.internal.view.a.a(j).a());
    }

    public final void a(CharSequence charsequence)
    {
        p.b(charsequence);
    }

    public final void a(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        a(byte0, 4);
    }

    public final int b()
    {
        return o.getHeight();
    }

    public final void b(CharSequence charsequence)
    {
        p.a(charsequence);
    }

    public final void b(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        a(byte0, 8);
    }

    public final void c()
    {
        if (D)
        {
            D = false;
            i(false);
        }
    }

    public final void c(boolean flag)
    {
        if (!w)
        {
            a(flag);
        }
    }

    public final void d()
    {
        if (!D)
        {
            D = true;
            i(false);
        }
    }

    public final void d(boolean flag)
    {
        I = flag;
        if (!flag && H != null)
        {
            H.b();
        }
    }

    public final void e(boolean flag)
    {
        if (flag != x)
        {
            x = flag;
            int j1 = y.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                y.get(i1);
                i1++;
            }
        }
    }

    public final boolean e()
    {
        int i1 = o.getHeight();
        return G && (i1 == 0 || n.getActionBarHideOffset() < i1);
    }

    public final Context f()
    {
        if (k == null)
        {
            TypedValue typedvalue = new TypedValue();
            j.getTheme().resolveAttribute(android.support.v7.b.a.a.actionBarWidgetTheme, typedvalue, true);
            int i1 = typedvalue.resourceId;
            if (i1 != 0)
            {
                k = new ContextThemeWrapper(j, i1);
            } else
            {
                k = j;
            }
        }
        return k;
    }

    public final void f(boolean flag)
    {
        C = flag;
    }

    public final void g(boolean flag)
    {
        boolean flag1 = false;
        Object obj;
        int i1;
        if (flag)
        {
            if (!F)
            {
                F = true;
                if (n != null)
                {
                    n.setShowingForActionMode(true);
                }
                i(false);
            }
        } else
        if (F)
        {
            F = false;
            if (n != null)
            {
                n.setShowingForActionMode(false);
            }
            i(false);
        }
        obj = p;
        if (flag)
        {
            i1 = 8;
        } else
        {
            i1 = 0;
        }
        ((h) (obj)).d(i1);
        obj = q;
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        ((ActionBarContextView) (obj)).a(i1);
    }

    public final boolean h()
    {
        if (p != null && p.c())
        {
            p.d();
            return true;
        } else
        {
            return false;
        }
    }

    public final void i()
    {
        if (E)
        {
            E = false;
            i(true);
        }
    }

    public final void j()
    {
        if (!E)
        {
            E = true;
            i(true);
        }
    }

    public final void k()
    {
        if (H != null)
        {
            H.b();
            H = null;
        }
    }

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (!android/support/v7/internal/a/d.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = flag;
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        i = flag;
    }
}
