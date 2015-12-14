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

public class ae extends ActionBar
    implements cf
{

    static final boolean h;
    private static final boolean i;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private as G;
    private boolean H;
    ai a;
    ee b;
    ef c;
    boolean d;
    final ViewPropertyAnimatorListener e = new af(this);
    final ViewPropertyAnimatorListener f = new ag(this);
    final ViewPropertyAnimatorUpdateListener g = new ah(this);
    private Context j;
    private Context k;
    private FragmentActivity l;
    private ActionBarOverlayLayout m;
    private ActionBarContainer n;
    private da o;
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

    public ae(ActionBarActivity actionbaractivity, boolean flag)
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

    static as a(ae ae1, as as1)
    {
        ae1.G = as1;
        return as1;
    }

    private void a(View view)
    {
        m = (ActionBarOverlayLayout)view.findViewById(w.decor_content_parent);
        if (m != null)
        {
            m.setActionBarVisibilityCallback(this);
        }
        o = b(view.findViewById(w.action_bar));
        p = (ActionBarContextView)view.findViewById(w.action_context_bar);
        n = (ActionBarContainer)view.findViewById(w.action_bar_container);
        q = (ActionBarContainer)view.findViewById(w.split_action_bar);
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
        view = al.a(j);
        if (view.f() || i1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        k(view.d());
        view = j.obtainStyledAttributes(null, ab.ActionBar, r.actionBarStyle, 0);
        if (view.getBoolean(ab.ActionBar_hideOnContentScroll, false))
        {
            b(true);
        }
        i1 = view.getDimensionPixelSize(ab.ActionBar_elevation, 0);
        if (i1 != 0)
        {
            a(i1);
        }
        view.recycle();
    }

    static boolean a(ae ae1)
    {
        return ae1.B;
    }

    static boolean a(boolean flag, boolean flag1, boolean flag2)
    {
        return b(flag, flag1, flag2);
    }

    static View b(ae ae1)
    {
        return ae1.r;
    }

    private da b(View view)
    {
        if (view instanceof da)
        {
            return (da)view;
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

    static ActionBarContainer c(ae ae1)
    {
        return ae1.n;
    }

    static ActionBarContainer d(ae ae1)
    {
        return ae1.q;
    }

    static int e(ae ae1)
    {
        return ae1.y;
    }

    static ActionBarOverlayLayout f(ae ae1)
    {
        return ae1.m;
    }

    static boolean g(ae ae1)
    {
        return ae1.C;
    }

    static boolean h(ae ae1)
    {
        return ae1.D;
    }

    static ActionBarContextView i(ae ae1)
    {
        return ae1.p;
    }

    static da j(ae ae1)
    {
        return ae1.o;
    }

    static Context k(ae ae1)
    {
        return ae1.j;
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
        ((da) (obj)).a(flag);
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

    public ee a(ef ef1)
    {
        if (a != null)
        {
            a.c();
        }
        m.setHideOnContentScrollEnabled(false);
        p.killMode();
        ef1 = new ai(this, ef1);
        if (ef1.e())
        {
            ef1.d();
            p.initForMode(ef1);
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
            a = ef1;
            return ef1;
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
        k(al.a(j).d());
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
            j.getTheme().resolveAttribute(r.actionBarWidgetTheme, typedvalue, true);
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
                int ai1[] = new int[2];
                int[] _tmp = ai1;
                ai1[0] = 0;
                ai1[1] = 0;
                n.getLocationInWindow(ai1);
                f1 = f2 - (float)ai1[1];
            }
            ViewCompat.setTranslationY(n, f1);
            as as1 = new as();
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(n).translationY(0.0F);
            viewpropertyanimatorcompat.setUpdateListener(g);
            as1.a(viewpropertyanimatorcompat);
            if (B && r != null)
            {
                ViewCompat.setTranslationY(r, f1);
                as1.a(ViewCompat.animate(r).translationY(0.0F));
            }
            if (q != null && y == 1)
            {
                ViewCompat.setTranslationY(q, q.getHeight());
                q.setVisibility(0);
                as1.a(ViewCompat.animate(q).translationY(0.0F));
            }
            as1.a(AnimationUtils.loadInterpolator(j, 0x10a0006));
            as1.a(250L);
            as1.a(f);
            G = as1;
            as1.a();
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
            as as1 = new as();
            float f2 = -n.getHeight();
            float f1 = f2;
            if (flag)
            {
                int ai1[] = new int[2];
                int[] _tmp = ai1;
                ai1[0] = 0;
                ai1[1] = 0;
                n.getLocationInWindow(ai1);
                f1 = f2 - (float)ai1[1];
            }
            ViewPropertyAnimatorCompat viewpropertyanimatorcompat = ViewCompat.animate(n).translationY(f1);
            viewpropertyanimatorcompat.setUpdateListener(g);
            as1.a(viewpropertyanimatorcompat);
            if (B && r != null)
            {
                as1.a(ViewCompat.animate(r).translationY(f1));
            }
            if (q != null && q.getVisibility() == 0)
            {
                ViewCompat.setAlpha(q, 1.0F);
                as1.a(ViewCompat.animate(q).translationY(q.getHeight()));
            }
            as1.a(AnimationUtils.loadInterpolator(j, 0x10a0005));
            as1.a(250L);
            as1.a(e);
            G = as1;
            as1.a();
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
        ((da) (obj)).d(i1);
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
        if (!ae.desiredAssertionStatus())
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
