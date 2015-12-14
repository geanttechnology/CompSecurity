// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

public class m extends ActionBar
    implements bb
{

    static final boolean h;
    private static final boolean i;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private x G;
    private boolean H;
    n a;
    cn b;
    co c;
    boolean d;
    final ViewPropertyAnimatorListener e = new ViewPropertyAnimatorListenerAdapter() {

        final m a;

        public void onAnimationEnd(View view)
        {
            if (m.a(a) && m.b(a) != null)
            {
                ViewCompat.setTranslationY(m.b(a), 0.0F);
                ViewCompat.setTranslationY(m.c(a), 0.0F);
            }
            if (m.d(a) != null && m.e(a) == 1)
            {
                m.d(a).setVisibility(8);
            }
            m.c(a).setVisibility(8);
            m.c(a).setTransitioning(false);
            m.a(a, null);
            a.e();
            if (m.f(a) != null)
            {
                ViewCompat.requestApplyInsets(m.f(a));
            }
        }

            
            {
                a = m.this;
                super();
            }
    };
    final ViewPropertyAnimatorListener f = new ViewPropertyAnimatorListenerAdapter() {

        final m a;

        public void onAnimationEnd(View view)
        {
            m.a(a, null);
            m.c(a).requestLayout();
        }

            
            {
                a = m.this;
                super();
            }
    };
    final ViewPropertyAnimatorUpdateListener g = new ViewPropertyAnimatorUpdateListener() {

        final m a;

        public void onAnimationUpdate(View view)
        {
            ((View)m.c(a).getParent()).invalidate();
        }

            
            {
                a = m.this;
                super();
            }
    };
    private Context j;
    private Context k;
    private FragmentActivity l;
    private ActionBarOverlayLayout m;
    private ActionBarContainer n;
    private br o;
    private ActionBarContextView p;
    private ActionBarContainer q;
    private View r;
    private ScrollingTabContainerView s;
    private ArrayList t;
    private int u;
    private boolean v;
    private boolean w;
    private ArrayList x;
    private int y;
    private boolean z;

    public m(ActionBarActivity actionbaractivity, boolean flag)
    {
        t = new ArrayList();
        u = -1;
        x = new ArrayList();
        A = 0;
        B = true;
        F = true;
        l = actionbaractivity;
        actionbaractivity = actionbaractivity.getWindow().getDecorView();
        a(actionbaractivity);
        if (!flag)
        {
            r = actionbaractivity.findViewById(0x1020002);
        }
    }

    static x a(m m1, x x1)
    {
        m1.G = x1;
        return x1;
    }

    private void a(View view)
    {
        m = (ActionBarOverlayLayout)view.findViewById(android.support.v7.appcompat.R.id.decor_content_parent);
        if (m != null)
        {
            m.setActionBarVisibilityCallback(this);
        }
        o = b(view.findViewById(android.support.v7.appcompat.R.id.action_bar));
        p = (ActionBarContextView)view.findViewById(android.support.v7.appcompat.R.id.action_context_bar);
        n = (ActionBarContainer)view.findViewById(android.support.v7.appcompat.R.id.action_bar_container);
        q = (ActionBarContainer)view.findViewById(android.support.v7.appcompat.R.id.split_action_bar);
        if (o == null || p == null || n == null)
        {
            throw new IllegalStateException((new StringBuilder()).append(getClass().getSimpleName()).append(" can only be used ").append("with a compatible window decor layout").toString());
        }
        j = o.b();
        int i1;
        boolean flag;
        if (o.c())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        y = i1;
        if ((o.r() & 4) != 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            v = true;
        }
        view = q.a(j);
        if (view.f() || i1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        k(view.d());
        view = j.obtainStyledAttributes(null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
        if (view.getBoolean(android.support.v7.appcompat.R.styleable.ActionBar_hideOnContentScroll, false))
        {
            b(true);
        }
        i1 = view.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.ActionBar_elevation, 0);
        if (i1 != 0)
        {
            a(i1);
        }
        view.recycle();
    }

    static boolean a(m m1)
    {
        return m1.B;
    }

    static boolean a(boolean flag, boolean flag1, boolean flag2)
    {
        return b(flag, flag1, flag2);
    }

    static View b(m m1)
    {
        return m1.r;
    }

    private br b(View view)
    {
        if (view instanceof br)
        {
            return (br)view;
        }
        if (view instanceof Toolbar)
        {
            return ((Toolbar)view).getWrapper();
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Can't make a decor toolbar out of ").append(view.getClass().getSimpleName()).toString());
        }
    }

    private static boolean b(boolean flag, boolean flag1, boolean flag2)
    {
        while (flag2 || !flag && !flag1) 
        {
            return true;
        }
        return false;
    }

    static ActionBarContainer c(m m1)
    {
        return m1.n;
    }

    static ActionBarContainer d(m m1)
    {
        return m1.q;
    }

    static int e(m m1)
    {
        return m1.y;
    }

    static ActionBarOverlayLayout f(m m1)
    {
        return m1.m;
    }

    static boolean g(m m1)
    {
        return m1.C;
    }

    static boolean h(m m1)
    {
        return m1.D;
    }

    static ActionBarContextView i(m m1)
    {
        return m1.p;
    }

    static br j(m m1)
    {
        return m1.o;
    }

    static Context k(m m1)
    {
        return m1.j;
    }

    private void k()
    {
        if (!E)
        {
            E = true;
            if (m != null)
            {
                m.setShowingForActionMode(true);
            }
            l(false);
        }
    }

    private void k(boolean flag)
    {
        boolean flag2 = true;
        z = flag;
        Object obj;
        boolean flag1;
        if (!z)
        {
            o.a(null);
            n.setTabContainer(s);
        } else
        {
            n.setTabContainer(null);
            o.a(s);
        }
        if (f() == 2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (s != null)
        {
            if (flag1)
            {
                s.setVisibility(0);
                if (m != null)
                {
                    ViewCompat.requestApplyInsets(m);
                }
            } else
            {
                s.setVisibility(8);
            }
        }
        obj = o;
        if (!z && flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((br) (obj)).a(flag);
        obj = m;
        if (!z && flag1)
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
        if (E)
        {
            E = false;
            if (m != null)
            {
                m.setShowingForActionMode(false);
            }
            l(false);
        }
    }

    private void l(boolean flag)
    {
        if (b(C, D, E))
        {
            if (!F)
            {
                F = true;
                h(flag);
            }
        } else
        if (F)
        {
            F = false;
            i(flag);
            return;
        }
    }

    public int a()
    {
        return o.r();
    }

    public cn a(co co1)
    {
        if (a != null)
        {
            a.c();
        }
        m.setHideOnContentScrollEnabled(false);
        p.killMode();
        co1 = new n(this, co1);
        if (co1.e())
        {
            co1.d();
            p.initForMode(co1);
            j(true);
            if (q != null && y == 1 && q.getVisibility() != 0)
            {
                q.setVisibility(0);
                if (m != null)
                {
                    ViewCompat.requestApplyInsets(m);
                }
            }
            p.sendAccessibilityEvent(32);
            a = co1;
            return co1;
        } else
        {
            return null;
        }
    }

    public void a(float f1)
    {
        ViewCompat.setElevation(n, f1);
        if (q != null)
        {
            ViewCompat.setElevation(q, f1);
        }
    }

    public void a(int i1)
    {
        o.e(i1);
    }

    public void a(int i1, int j1)
    {
        int k1 = o.r();
        if ((j1 & 4) != 0)
        {
            v = true;
        }
        o.c(k1 & ~j1 | i1 & j1);
    }

    public void a(Configuration configuration)
    {
        k(q.a(j).d());
    }

    public void a(Drawable drawable)
    {
        o.b(drawable);
    }

    public void a(CharSequence charsequence)
    {
        o.a(charsequence);
    }

    public void a(boolean flag)
    {
        o.b(flag);
    }

    public Context b()
    {
        if (k == null)
        {
            TypedValue typedvalue = new TypedValue();
            j.getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.actionBarWidgetTheme, typedvalue, true);
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
        A = i1;
    }

    public void b(boolean flag)
    {
        if (flag && !m.isInOverlayMode())
        {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        } else
        {
            d = flag;
            m.setHideOnContentScrollEnabled(flag);
            return;
        }
    }

    public void c(boolean flag)
    {
        if (!v)
        {
            f(flag);
        }
    }

    public void d(boolean flag)
    {
        H = flag;
        if (!flag && G != null)
        {
            G.b();
        }
    }

    public boolean d()
    {
        if (o != null && o.d())
        {
            o.e();
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
        if (flag != w)
        {
            w = flag;
            int j1 = x.size();
            int i1 = 0;
            while (i1 < j1) 
            {
                ((a)x.get(i1)).a(flag);
                i1++;
            }
        }
    }

    public int f()
    {
        return o.s();
    }

    public void f(boolean flag)
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

    public void g()
    {
        if (D)
        {
            D = false;
            l(true);
        }
    }

    public void g(boolean flag)
    {
        B = flag;
    }

    public void h()
    {
        if (!D)
        {
            D = true;
            l(true);
        }
    }

    public void h(boolean flag)
    {
        if (G != null)
        {
            G.b();
        }
        n.setVisibility(0);
        if (A == 0 && i && (H || flag))
        {
            ViewCompat.setTranslationY(n, 0.0F);
            float f2 = -n.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 0;
                n.getLocationInWindow(ai);
                f1 = f2 - (float)ai[1];
            }
            ViewCompat.setTranslationY(n, f1);
            x x1 = new x();
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(n).translationY(0.0F);
            viewpropertyanimatorcompat.setUpdateListener(g);
            x1.a(viewpropertyanimatorcompat);
            if (B && r != null)
            {
                ViewCompat.setTranslationY(r, f1);
                x1.a(ViewCompat.animate(r).translationY(0.0F));
            }
            if (q != null && y == 1)
            {
                ViewCompat.setTranslationY(q, q.getHeight());
                q.setVisibility(0);
                x1.a(ViewCompat.animate(q).translationY(0.0F));
            }
            x1.a(AnimationUtils.loadInterpolator(j, 0x10a0006));
            x1.a(250L);
            x1.a(f);
            G = x1;
            x1.a();
        } else
        {
            ViewCompat.setAlpha(n, 1.0F);
            ViewCompat.setTranslationY(n, 0.0F);
            if (B && r != null)
            {
                ViewCompat.setTranslationY(r, 0.0F);
            }
            if (q != null && y == 1)
            {
                ViewCompat.setAlpha(q, 1.0F);
                ViewCompat.setTranslationY(q, 0.0F);
                q.setVisibility(0);
            }
            f.onAnimationEnd(null);
        }
        if (m != null)
        {
            ViewCompat.requestApplyInsets(m);
        }
    }

    public void i()
    {
        if (G != null)
        {
            G.b();
            G = null;
        }
    }

    public void i(boolean flag)
    {
        if (G != null)
        {
            G.b();
        }
        if (A == 0 && i && (H || flag))
        {
            ViewCompat.setAlpha(n, 1.0F);
            n.setTransitioning(true);
            x x1 = new x();
            float f2 = -n.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai[] = new int[2];
                int[] _tmp = ai;
                ai[0] = 0;
                ai[1] = 0;
                n.getLocationInWindow(ai);
                f1 = f2 - (float)ai[1];
            }
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(n).translationY(f1);
            viewpropertyanimatorcompat.setUpdateListener(g);
            x1.a(viewpropertyanimatorcompat);
            if (B && r != null)
            {
                x1.a(ViewCompat.animate(r).translationY(f1));
            }
            if (q != null && q.getVisibility() == 0)
            {
                ViewCompat.setAlpha(q, 1.0F);
                x1.a(ViewCompat.animate(q).translationY(q.getHeight()));
            }
            x1.a(AnimationUtils.loadInterpolator(j, 0x10a0005));
            x1.a(250L);
            x1.a(e);
            G = x1;
            x1.a();
            return;
        } else
        {
            e.onAnimationEnd(null);
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
        obj = o;
        if (flag)
        {
            i1 = 8;
        } else
        {
            i1 = 0;
        }
        ((br) (obj)).d(i1);
        obj = p;
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        ((ActionBarContextView) (obj)).animateToVisibility(i1);
    }

    static 
    {
        boolean flag1 = true;
        boolean flag;
        if (!m.desiredAssertionStatus())
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
