// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v4.view.ba;
import android.support.v4.view.be;
import android.support.v4.view.bf;
import android.support.v4.view.bg;
import android.support.v7.app.a;
import android.support.v7.internal.view.e;
import android.support.v7.internal.view.f;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.h;
import android.support.v7.internal.widget.n;
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

public class c extends android.support.v7.app.a
    implements android.support.v7.internal.widget.ActionBarOverlayLayout.a
{
    public class a extends android.support.v7.d.a
        implements android.support.v7.internal.view.menu.f.a
    {

        final c a;
        private final Context b;
        private final android.support.v7.internal.view.menu.f c;
        private android.support.v7.d.a.a d;
        private WeakReference e;

        public MenuInflater a()
        {
            return new e(b);
        }

        public void a(int i1)
        {
            b(c.k(a).getResources().getString(i1));
        }

        public void a(android.support.v7.internal.view.menu.f f1)
        {
            if (d == null)
            {
                return;
            } else
            {
                d();
                c.i(a).a();
                return;
            }
        }

        public void a(View view)
        {
            c.i(a).setCustomView(view);
            e = new WeakReference(view);
        }

        public void a(CharSequence charsequence)
        {
            c.i(a).setSubtitle(charsequence);
        }

        public void a(boolean flag)
        {
            super.a(flag);
            c.i(a).setTitleOptional(flag);
        }

        public boolean a(android.support.v7.internal.view.menu.f f1, MenuItem menuitem)
        {
            if (d != null)
            {
                return d.a(this, menuitem);
            } else
            {
                return false;
            }
        }

        public Menu b()
        {
            return c;
        }

        public void b(int i1)
        {
            a(c.k(a).getResources().getString(i1));
        }

        public void b(CharSequence charsequence)
        {
            c.i(a).setTitle(charsequence);
        }

        public void c()
        {
            if (a.a != this)
            {
                return;
            }
            if (!android.support.v7.internal.a.c.a(c.g(a), android.support.v7.internal.a.c.h(a), false))
            {
                a.b = this;
                a.c = d;
            } else
            {
                d.a(this);
            }
            d = null;
            a.j(false);
            c.i(a).b();
            c.j(a).a().sendAccessibilityEvent(32);
            android.support.v7.internal.a.c.f(a).setHideOnContentScrollEnabled(a.d);
            a.a = null;
        }

        public void d()
        {
            if (a.a != this)
            {
                return;
            }
            c.g();
            d.b(this, c);
            c.h();
            return;
            Exception exception;
            exception;
            c.h();
            throw exception;
        }

        public boolean e()
        {
            c.g();
            boolean flag = d.a(this, c);
            c.h();
            return flag;
            Exception exception;
            exception;
            c.h();
            throw exception;
        }

        public CharSequence f()
        {
            return c.i(a).getTitle();
        }

        public CharSequence g()
        {
            return c.i(a).getSubtitle();
        }

        public boolean h()
        {
            return c.i(a).d();
        }

        public View i()
        {
            if (e != null)
            {
                return (View)e.get();
            } else
            {
                return null;
            }
        }

        public a(Context context, android.support.v7.d.a.a a1)
        {
            a = c.this;
            super();
            b = context;
            d = a1;
            c = (new android.support.v7.internal.view.menu.f(context)).a(1);
            c.a(this);
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
    android.support.v7.d.a b;
    android.support.v7.d.a.a c;
    boolean d;
    final be e;
    final be f;
    final bg g;
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
    private n t;
    private ArrayList u;
    private int v;
    private boolean w;
    private boolean x;
    private ArrayList y;
    private int z;

    public c(Activity activity, boolean flag)
    {
        u = new ArrayList();
        v = -1;
        y = new ArrayList();
        B = 0;
        C = true;
        G = true;
        e = new bf() {

            final c a;

            public void b(View view)
            {
                if (android.support.v7.internal.a.c.a(a) && c.b(a) != null)
                {
                    ai.b(c.b(a), 0.0F);
                    ai.b(c.c(a), 0.0F);
                }
                if (c.d(a) != null && android.support.v7.internal.a.c.e(a) == 1)
                {
                    c.d(a).setVisibility(8);
                }
                c.c(a).setVisibility(8);
                c.c(a).setTransitioning(false);
                android.support.v7.internal.a.c.a(a, null);
                a.e();
                if (android.support.v7.internal.a.c.f(a) != null)
                {
                    ai.v(android.support.v7.internal.a.c.f(a));
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        f = new bf() {

            final c a;

            public void b(View view)
            {
                android.support.v7.internal.a.c.a(a, null);
                c.c(a).requestLayout();
            }

            
            {
                a = c.this;
                super();
            }
        };
        g = new bg() {

            final c a;

            public void a(View view)
            {
                ((View)c.c(a).getParent()).invalidate();
            }

            
            {
                a = c.this;
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

    public c(Dialog dialog)
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

    static f a(c c1, f f1)
    {
        c1.H = f1;
        return f1;
    }

    private void a(View view)
    {
        n = (ActionBarOverlayLayout)view.findViewById(android.support.v7.a.a.f.decor_content_parent);
        if (n != null)
        {
            n.setActionBarVisibilityCallback(this);
        }
        p = b(view.findViewById(android.support.v7.a.a.f.action_bar));
        q = (ActionBarContextView)view.findViewById(android.support.v7.a.a.f.action_context_bar);
        o = (ActionBarContainer)view.findViewById(android.support.v7.a.a.f.action_bar_container);
        r = (ActionBarContainer)view.findViewById(android.support.v7.a.a.f.split_action_bar);
        if (p == null || q == null || o == null)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with a compatible window decor layout").toString());
        }
        j = p.b();
        int i1;
        boolean flag;
        if (p.c())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        z = i1;
        if ((p.p() & 4) != 0)
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
        if (view.f() || i1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b(flag);
        k(view.d());
        view = j.obtainStyledAttributes(null, android.support.v7.a.a.k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        if (view.getBoolean(android.support.v7.a.a.k.ActionBar_hideOnContentScroll, false))
        {
            c(true);
        }
        i1 = view.getDimensionPixelSize(android.support.v7.a.a.k.ActionBar_elevation, 0);
        if (i1 != 0)
        {
            a(i1);
        }
        view.recycle();
    }

    static boolean a(c c1)
    {
        return c1.C;
    }

    static boolean a(boolean flag, boolean flag1, boolean flag2)
    {
        return b(flag, flag1, flag2);
    }

    private h b(View view)
    {
        if (view instanceof h)
        {
            return (h)view;
        }
        if (view instanceof Toolbar)
        {
            return ((Toolbar)view).getWrapper();
        }
        if ((new StringBuilder()).append("Can't make a decor toolbar out of ").append(view).toString() != null)
        {
            view = view.getClass().getSimpleName();
        } else
        {
            view = "null";
        }
        throw new IllegalStateException(view);
    }

    static View b(c c1)
    {
        return c1.s;
    }

    private static boolean b(boolean flag, boolean flag1, boolean flag2)
    {
        while (flag2 || !flag && !flag1) 
        {
            return true;
        }
        return false;
    }

    static ActionBarContainer c(c c1)
    {
        return c1.o;
    }

    static ActionBarContainer d(c c1)
    {
        return c1.r;
    }

    static int e(c c1)
    {
        return c1.z;
    }

    static ActionBarOverlayLayout f(c c1)
    {
        return c1.n;
    }

    static boolean g(c c1)
    {
        return c1.D;
    }

    static boolean h(c c1)
    {
        return c1.E;
    }

    static ActionBarContextView i(c c1)
    {
        return c1.q;
    }

    static h j(c c1)
    {
        return c1.p;
    }

    static Context k(c c1)
    {
        return c1.j;
    }

    private void k()
    {
        if (!F)
        {
            F = true;
            if (n != null)
            {
                n.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    private void k(boolean flag)
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
        if (f() == 2)
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
                    ai.v(n);
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

    private void l()
    {
        if (F)
        {
            F = false;
            if (n != null)
            {
                n.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private void l(boolean flag)
    {
        if (b(D, E, F))
        {
            if (!G)
            {
                G = true;
                h(flag);
            }
        } else
        if (G)
        {
            G = false;
            i(flag);
            return;
        }
    }

    public int a()
    {
        return p.p();
    }

    public android.support.v7.d.a a(android.support.v7.d.a.a a1)
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
            j(true);
            if (r != null && z == 1 && r.getVisibility() != 0)
            {
                r.setVisibility(0);
                if (n != null)
                {
                    ai.v(n);
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

    public void a(float f1)
    {
        ai.f(o, f1);
        if (r != null)
        {
            ai.f(r, f1);
        }
    }

    public void a(int i1)
    {
        p.e(i1);
    }

    public void a(int i1, int j1)
    {
        int k1 = p.p();
        if ((j1 & 4) != 0)
        {
            w = true;
        }
        p.c(k1 & ~j1 | i1 & j1);
    }

    public void a(Configuration configuration)
    {
        k(android.support.v7.internal.view.a.a(j).d());
    }

    public void a(Drawable drawable)
    {
        p.b(drawable);
    }

    public void a(CharSequence charsequence)
    {
        p.b(charsequence);
    }

    public void a(boolean flag)
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

    public Context b()
    {
        if (k == null)
        {
            TypedValue typedvalue = new TypedValue();
            j.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedvalue, true);
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

    public void b(int i1)
    {
        B = i1;
    }

    public void b(CharSequence charsequence)
    {
        p.a(charsequence);
    }

    public void b(boolean flag)
    {
        p.b(flag);
    }

    public void c(boolean flag)
    {
        if (flag && !n.a())
        {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        } else
        {
            d = flag;
            n.setHideOnContentScrollEnabled(flag);
            return;
        }
    }

    public void d(boolean flag)
    {
        if (!w)
        {
            a(flag);
        }
    }

    public boolean d()
    {
        if (p != null && p.d())
        {
            p.e();
            return true;
        } else
        {
            return false;
        }
    }

    void e()
    {
        if (c != null)
        {
            c.a(b);
            b = null;
            c = null;
        }
    }

    public void e(boolean flag)
    {
        I = flag;
        if (!flag && H != null)
        {
            H.b();
        }
    }

    public int f()
    {
        return p.q();
    }

    public void f(boolean flag)
    {
        if (flag != x)
        {
            x = flag;
            int j1 = y.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                ((android.support.v7.app.a.b)y.get(i1)).a(flag);
                i1++;
            }
        }
    }

    public void g()
    {
        if (E)
        {
            E = false;
            l(true);
        }
    }

    public void g(boolean flag)
    {
        C = flag;
    }

    public void h()
    {
        if (!E)
        {
            E = true;
            l(true);
        }
    }

    public void h(boolean flag)
    {
        if (H != null)
        {
            H.b();
        }
        o.setVisibility(0);
        if (B == 0 && i && (I || flag))
        {
            ai.b(o, 0.0F);
            float f2 = -o.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai1[] = new int[2];
                int[] _tmp = ai1;
                ai1[0] = 0;
                ai1[1] = 0;
                o.getLocationInWindow(ai1);
                f1 = f2 - (float)ai1[1];
            }
            ai.b(o, f1);
            f f3 = new f();
            ba ba1 = ai.s(o).c(0.0F);
            ba1.a(g);
            f3.a(ba1);
            if (C && s != null)
            {
                ai.b(s, f1);
                f3.a(ai.s(s).c(0.0F));
            }
            if (r != null && z == 1)
            {
                ai.b(r, r.getHeight());
                r.setVisibility(0);
                f3.a(ai.s(r).c(0.0F));
            }
            f3.a(AnimationUtils.loadInterpolator(j, 0x10a0006));
            f3.a(250L);
            f3.a(f);
            H = f3;
            f3.a();
        } else
        {
            ai.c(o, 1.0F);
            ai.b(o, 0.0F);
            if (C && s != null)
            {
                ai.b(s, 0.0F);
            }
            if (r != null && z == 1)
            {
                ai.c(r, 1.0F);
                ai.b(r, 0.0F);
                r.setVisibility(0);
            }
            f.b(null);
        }
        if (n != null)
        {
            ai.v(n);
        }
    }

    public void i()
    {
        if (H != null)
        {
            H.b();
            H = null;
        }
    }

    public void i(boolean flag)
    {
        if (H != null)
        {
            H.b();
        }
        if (B == 0 && i && (I || flag))
        {
            ai.c(o, 1.0F);
            o.setTransitioning(true);
            f f3 = new f();
            float f2 = -o.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai1[] = new int[2];
                int[] _tmp = ai1;
                ai1[0] = 0;
                ai1[1] = 0;
                o.getLocationInWindow(ai1);
                f1 = f2 - (float)ai1[1];
            }
            ba ba1 = ai.s(o).c(f1);
            ba1.a(g);
            f3.a(ba1);
            if (C && s != null)
            {
                f3.a(ai.s(s).c(f1));
            }
            if (r != null && r.getVisibility() == 0)
            {
                ai.c(r, 1.0F);
                f3.a(ai.s(r).c(r.getHeight()));
            }
            f3.a(AnimationUtils.loadInterpolator(j, 0x10a0005));
            f3.a(250L);
            f3.a(e);
            H = f3;
            f3.a();
            return;
        } else
        {
            e.b(null);
            return;
        }
    }

    public void j()
    {
    }

    public void j(boolean flag)
    {
        boolean flag1 = false;
        Object obj;
        int i1;
        if (flag)
        {
            k();
        } else
        {
            l();
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

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (!android/support/v7/internal/a/c.desiredAssertionStatus())
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
