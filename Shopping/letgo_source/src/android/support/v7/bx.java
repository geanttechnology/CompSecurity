// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v4.view.ay;
import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.support.v4.view.be;
import android.support.v7.app.ActionBar;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.g;
import android.support.v7.internal.widget.l;
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

// Referenced classes of package android.support.v7:
//            ca, cf, cj, ce

public class bx extends ActionBar
    implements android.support.v7.internal.widget.ActionBarOverlayLayout.a
{
    public class a extends cj
        implements android.support.v7.internal.view.menu.f.a
    {

        final bx a;
        private final Context b;
        private final f c;
        private cj.a d;
        private WeakReference e;

        public MenuInflater a()
        {
            return new ce(b);
        }

        public void a(int i1)
        {
            b(bx.k(a).getResources().getString(i1));
        }

        public void a(View view)
        {
            bx.i(a).setCustomView(view);
            e = new WeakReference(view);
        }

        public void a(CharSequence charsequence)
        {
            bx.i(a).setSubtitle(charsequence);
        }

        public void a(boolean flag)
        {
            super.a(flag);
            bx.i(a).setTitleOptional(flag);
        }

        public Menu b()
        {
            return c;
        }

        public void b(int i1)
        {
            a(bx.k(a).getResources().getString(i1));
        }

        public void b(CharSequence charsequence)
        {
            bx.i(a).setTitle(charsequence);
        }

        public void c()
        {
            if (a.a != this)
            {
                return;
            }
            if (!bx.a(android.support.v7.bx.g(a), bx.h(a), false))
            {
                a.b = this;
                a.c = d;
            } else
            {
                d.a(this);
            }
            d = null;
            a.l(false);
            bx.i(a).b();
            bx.j(a).a().sendAccessibilityEvent(32);
            android.support.v7.bx.f(a).setHideOnContentScrollEnabled(a.d);
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
            return bx.i(a).getTitle();
        }

        public CharSequence g()
        {
            return bx.i(a).getSubtitle();
        }

        public boolean h()
        {
            return bx.i(a).d();
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

        public boolean onMenuItemSelected(f f1, MenuItem menuitem)
        {
            if (d != null)
            {
                return d.a(this, menuitem);
            } else
            {
                return false;
            }
        }

        public void onMenuModeChange(f f1)
        {
            if (d == null)
            {
                return;
            } else
            {
                d();
                bx.i(a).a();
                return;
            }
        }

        public a(Context context, cj.a a1)
        {
            a = bx.this;
            super();
            b = context;
            d = a1;
            c = (new f(context)).a(1);
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
    private cf H;
    private boolean I;
    a a;
    cj b;
    cj.a c;
    boolean d;
    final bc e;
    final bc f;
    final be g;
    private Context j;
    private Context k;
    private Activity l;
    private Dialog m;
    private ActionBarOverlayLayout n;
    private ActionBarContainer o;
    private g p;
    private ActionBarContextView q;
    private ActionBarContainer r;
    private View s;
    private l t;
    private ArrayList u;
    private int v;
    private boolean w;
    private boolean x;
    private ArrayList y;
    private int z;

    public bx(Activity activity, boolean flag)
    {
        u = new ArrayList();
        v = -1;
        y = new ArrayList();
        B = 0;
        C = true;
        G = true;
        e = new bd() {

            final bx a;

            public void onAnimationEnd(View view)
            {
                if (bx.a(a) && bx.b(a) != null)
                {
                    ah.b(bx.b(a), 0.0F);
                    ah.b(bx.c(a), 0.0F);
                }
                if (bx.d(a) != null && bx.e(a) == 1)
                {
                    bx.d(a).setVisibility(8);
                }
                bx.c(a).setVisibility(8);
                bx.c(a).setTransitioning(false);
                bx.a(a, null);
                a.f();
                if (android.support.v7.bx.f(a) != null)
                {
                    ah.u(android.support.v7.bx.f(a));
                }
            }

            
            {
                a = bx.this;
                super();
            }
        };
        f = new bd() {

            final bx a;

            public void onAnimationEnd(View view)
            {
                bx.a(a, null);
                bx.c(a).requestLayout();
            }

            
            {
                a = bx.this;
                super();
            }
        };
        g = new be() {

            final bx a;

            public void a(View view)
            {
                ((View)bx.c(a).getParent()).invalidate();
            }

            
            {
                a = bx.this;
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

    public bx(Dialog dialog)
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

    static cf a(bx bx1, cf cf1)
    {
        bx1.H = cf1;
        return cf1;
    }

    private void a(View view)
    {
        n = (ActionBarOverlayLayout)view.findViewById(br.f.decor_content_parent);
        if (n != null)
        {
            n.setActionBarVisibilityCallback(this);
        }
        p = b(view.findViewById(br.f.action_bar));
        q = (ActionBarContextView)view.findViewById(br.f.action_context_bar);
        o = (ActionBarContainer)view.findViewById(br.f.action_bar_container);
        r = (ActionBarContainer)view.findViewById(br.f.split_action_bar);
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
        view = ca.a(j);
        if (view.f() || i1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d(flag);
        m(view.d());
        view = j.obtainStyledAttributes(null, android.support.v7.br.k.ActionBar, br.a.actionBarStyle, 0);
        if (view.getBoolean(br.k.ActionBar_hideOnContentScroll, false))
        {
            e(true);
        }
        i1 = view.getDimensionPixelSize(br.k.ActionBar_elevation, 0);
        if (i1 != 0)
        {
            a(i1);
        }
        view.recycle();
    }

    static boolean a(bx bx1)
    {
        return bx1.C;
    }

    static boolean a(boolean flag, boolean flag1, boolean flag2)
    {
        return b(flag, flag1, flag2);
    }

    private g b(View view)
    {
        if (view instanceof g)
        {
            return (g)view;
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

    static View b(bx bx1)
    {
        return bx1.s;
    }

    private static boolean b(boolean flag, boolean flag1, boolean flag2)
    {
        while (flag2 || !flag && !flag1) 
        {
            return true;
        }
        return false;
    }

    static ActionBarContainer c(bx bx1)
    {
        return bx1.o;
    }

    static ActionBarContainer d(bx bx1)
    {
        return bx1.r;
    }

    static int e(bx bx1)
    {
        return bx1.z;
    }

    static ActionBarOverlayLayout f(bx bx1)
    {
        return bx1.n;
    }

    static boolean g(bx bx1)
    {
        return bx1.D;
    }

    static boolean h(bx bx1)
    {
        return bx1.E;
    }

    static ActionBarContextView i(bx bx1)
    {
        return bx1.q;
    }

    static g j(bx bx1)
    {
        return bx1.p;
    }

    static Context k(bx bx1)
    {
        return bx1.j;
    }

    private void l()
    {
        if (!F)
        {
            F = true;
            if (n != null)
            {
                n.setShowingForActionMode(true);
            }
            n(false);
        }
    }

    private void m()
    {
        if (F)
        {
            F = false;
            if (n != null)
            {
                n.setShowingForActionMode(false);
            }
            n(false);
        }
    }

    private void m(boolean flag)
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
        if (g() == 2)
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
                    ah.u(n);
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
        ((g) (obj)).a(flag);
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

    private void n(boolean flag)
    {
        if (b(D, E, F))
        {
            if (!G)
            {
                G = true;
                j(flag);
            }
        } else
        if (G)
        {
            G = false;
            k(flag);
            return;
        }
    }

    public cj a(cj.a a1)
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
            l(true);
            if (r != null && z == 1 && r.getVisibility() != 0)
            {
                r.setVisibility(0);
                if (n != null)
                {
                    ah.u(n);
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

    public View a()
    {
        return p.r();
    }

    public void a(float f1)
    {
        ah.f(o, f1);
        if (r != null)
        {
            ah.f(r, f1);
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
        m(ca.a(j).d());
    }

    public void a(Drawable drawable)
    {
        p.b(drawable);
    }

    public void a(View view, android.support.v7.app.ActionBar.LayoutParams layoutparams)
    {
        view.setLayoutParams(layoutparams);
        p.a(view);
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

    public int b()
    {
        return p.p();
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

    public Context c()
    {
        if (k == null)
        {
            TypedValue typedvalue = new TypedValue();
            j.getTheme().resolveAttribute(br.a.actionBarWidgetTheme, typedvalue, true);
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

    public void c(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 16;
        } else
        {
            byte0 = 0;
        }
        a(byte0, 16);
    }

    public void d(boolean flag)
    {
        p.b(flag);
    }

    public void e(boolean flag)
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

    public boolean e()
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

    void f()
    {
        if (c != null)
        {
            c.a(b);
            b = null;
            c = null;
        }
    }

    public void f(boolean flag)
    {
        if (!w)
        {
            a(flag);
        }
    }

    public int g()
    {
        return p.q();
    }

    public void g(boolean flag)
    {
        I = flag;
        if (!flag && H != null)
        {
            H.b();
        }
    }

    public void h()
    {
        if (E)
        {
            E = false;
            n(true);
        }
    }

    public void h(boolean flag)
    {
        if (flag != x)
        {
            x = flag;
            int j1 = y.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                ((android.support.v7.app.ActionBar.a)y.get(i1)).a(flag);
                i1++;
            }
        }
    }

    public void i()
    {
        if (!E)
        {
            E = true;
            n(true);
        }
    }

    public void i(boolean flag)
    {
        C = flag;
    }

    public void j()
    {
        if (H != null)
        {
            H.b();
            H = null;
        }
    }

    public void j(boolean flag)
    {
        if (H != null)
        {
            H.b();
        }
        o.setVisibility(0);
        if (B == 0 && i && (I || flag))
        {
            ah.b(o, 0.0F);
            float f2 = -o.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 0;
                o.getLocationInWindow(ai);
                f1 = f2 - (float)ai[1];
            }
            ah.b(o, f1);
            cf cf1 = new cf();
            ay ay1 = ah.q(o).c(0.0F);
            ay1.a(g);
            cf1.a(ay1);
            if (C && s != null)
            {
                ah.b(s, f1);
                cf1.a(ah.q(s).c(0.0F));
            }
            if (r != null && z == 1)
            {
                ah.b(r, r.getHeight());
                r.setVisibility(0);
                cf1.a(ah.q(r).c(0.0F));
            }
            cf1.a(AnimationUtils.loadInterpolator(j, 0x10a0006));
            cf1.a(250L);
            cf1.a(f);
            H = cf1;
            cf1.a();
        } else
        {
            ah.c(o, 1.0F);
            ah.b(o, 0.0F);
            if (C && s != null)
            {
                ah.b(s, 0.0F);
            }
            if (r != null && z == 1)
            {
                ah.c(r, 1.0F);
                ah.b(r, 0.0F);
                r.setVisibility(0);
            }
            f.onAnimationEnd(null);
        }
        if (n != null)
        {
            ah.u(n);
        }
    }

    public void k()
    {
    }

    public void k(boolean flag)
    {
        if (H != null)
        {
            H.b();
        }
        if (B == 0 && i && (I || flag))
        {
            ah.c(o, 1.0F);
            o.setTransitioning(true);
            cf cf1 = new cf();
            float f2 = -o.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 0;
                o.getLocationInWindow(ai);
                f1 = f2 - (float)ai[1];
            }
            ay ay1 = ah.q(o).c(f1);
            ay1.a(g);
            cf1.a(ay1);
            if (C && s != null)
            {
                cf1.a(ah.q(s).c(f1));
            }
            if (r != null && r.getVisibility() == 0)
            {
                ah.c(r, 1.0F);
                cf1.a(ah.q(r).c(r.getHeight()));
            }
            cf1.a(AnimationUtils.loadInterpolator(j, 0x10a0005));
            cf1.a(250L);
            cf1.a(e);
            H = cf1;
            cf1.a();
            return;
        } else
        {
            e.onAnimationEnd(null);
            return;
        }
    }

    public void l(boolean flag)
    {
        boolean flag1 = false;
        Object obj;
        int i1;
        if (flag)
        {
            l();
        } else
        {
            m();
        }
        obj = p;
        if (flag)
        {
            i1 = 8;
        } else
        {
            i1 = 0;
        }
        ((g) (obj)).d(i1);
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
        if (!android/support/v7/bx.desiredAssertionStatus())
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
