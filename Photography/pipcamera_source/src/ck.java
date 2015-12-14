// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class ck
    implements br
{

    private Toolbar a;
    private int b;
    private View c;
    private View d;
    private Drawable e;
    private Drawable f;
    private Drawable g;
    private boolean h;
    private CharSequence i;
    private CharSequence j;
    private CharSequence k;
    private l l;
    private boolean m;
    private ActionMenuPresenter n;
    private int o;
    private final cg p;
    private int q;
    private Drawable r;

    public ck(Toolbar toolbar, boolean flag)
    {
        this(toolbar, flag, android.support.v7.appcompat.R.string.abc_action_bar_up_description, android.support.v7.appcompat.R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    }

    public ck(Toolbar toolbar, boolean flag, int i1, int j1)
    {
        o = 0;
        q = 0;
        a = toolbar;
        i = toolbar.getTitle();
        j = toolbar.getSubtitle();
        boolean flag1;
        if (i != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        h = flag1;
        if (flag)
        {
            toolbar = cj.a(toolbar.getContext(), null, android.support.v7.appcompat.R.styleable.ActionBar, android.support.v7.appcompat.R.attr.actionBarStyle, 0);
            Object obj = toolbar.b(android.support.v7.appcompat.R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                b(((CharSequence) (obj)));
            }
            obj = toolbar.b(android.support.v7.appcompat.R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                c(((CharSequence) (obj)));
            }
            obj = toolbar.a(android.support.v7.appcompat.R.styleable.ActionBar_logo);
            if (obj != null)
            {
                d(((Drawable) (obj)));
            }
            obj = toolbar.a(android.support.v7.appcompat.R.styleable.ActionBar_icon);
            if (obj != null)
            {
                a(((Drawable) (obj)));
            }
            obj = toolbar.a(android.support.v7.appcompat.R.styleable.ActionBar_homeAsUpIndicator);
            if (obj != null)
            {
                b(((Drawable) (obj)));
            }
            c(toolbar.a(android.support.v7.appcompat.R.styleable.ActionBar_displayOptions, 0));
            int k1 = toolbar.f(android.support.v7.appcompat.R.styleable.ActionBar_customNavigationLayout, 0);
            if (k1 != 0)
            {
                a(LayoutInflater.from(a.getContext()).inflate(k1, a, false));
                c(b | 0x10);
            }
            k1 = toolbar.e(android.support.v7.appcompat.R.styleable.ActionBar_height, 0);
            if (k1 > 0)
            {
                android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
                layoutparams.height = k1;
                a.setLayoutParams(layoutparams);
            }
            k1 = toolbar.c(android.support.v7.appcompat.R.styleable.ActionBar_contentInsetStart, -1);
            int l1 = toolbar.c(android.support.v7.appcompat.R.styleable.ActionBar_contentInsetEnd, -1);
            if (k1 >= 0 || l1 >= 0)
            {
                a.setContentInsetsRelative(Math.max(k1, 0), Math.max(l1, 0));
            }
            k1 = toolbar.f(android.support.v7.appcompat.R.styleable.ActionBar_titleTextStyle, 0);
            if (k1 != 0)
            {
                a.setTitleTextAppearance(a.getContext(), k1);
            }
            k1 = toolbar.f(android.support.v7.appcompat.R.styleable.ActionBar_subtitleTextStyle, 0);
            if (k1 != 0)
            {
                a.setSubtitleTextAppearance(a.getContext(), k1);
            }
            k1 = toolbar.f(android.support.v7.appcompat.R.styleable.ActionBar_popupTheme, 0);
            if (k1 != 0)
            {
                a.setPopupTheme(k1);
            }
            toolbar.b();
            p = toolbar.c();
        } else
        {
            b = t();
            p = new cg(toolbar.getContext());
        }
        f(i1);
        k = a.getNavigationContentDescription();
        c(p.a(j1));
        a.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final ActionMenuItem a;
            final ck b;

            public void onClick(View view)
            {
                if (ck.c(b) != null && ck.d(b))
                {
                    ck.c(b).a(0, a);
                }
            }

            
            {
                b = ck.this;
                super();
                a = new ActionMenuItem(ck.a(b).getContext(), 0, 0x102002c, 0, 0, ck.b(b));
            }
        });
    }

    static Toolbar a(ck ck1)
    {
        return ck1.a;
    }

    static CharSequence b(ck ck1)
    {
        return ck1.i;
    }

    static l c(ck ck1)
    {
        return ck1.l;
    }

    static boolean d(ck ck1)
    {
        return ck1.m;
    }

    private void e(CharSequence charsequence)
    {
        i = charsequence;
        if ((b & 8) != 0)
        {
            a.setTitle(charsequence);
        }
    }

    private int t()
    {
        byte byte0 = 11;
        if (a.getNavigationIcon() != null)
        {
            byte0 = 15;
        }
        return byte0;
    }

    private void u()
    {
        Drawable drawable = null;
        if ((b & 2) != 0)
        {
            if ((b & 1) != 0)
            {
                if (f != null)
                {
                    drawable = f;
                } else
                {
                    drawable = e;
                }
            } else
            {
                drawable = e;
            }
        }
        a.setLogo(drawable);
    }

    private void v()
    {
label0:
        {
            if ((b & 4) != 0)
            {
                if (!TextUtils.isEmpty(k))
                {
                    break label0;
                }
                a.setNavigationContentDescription(q);
            }
            return;
        }
        a.setNavigationContentDescription(k);
    }

    private void w()
    {
        if ((b & 4) != 0)
        {
            Toolbar toolbar = a;
            Drawable drawable;
            if (g != null)
            {
                drawable = g;
            } else
            {
                drawable = r;
            }
            toolbar.setNavigationIcon(drawable);
        }
    }

    public ViewGroup a()
    {
        return a;
    }

    public void a(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = p.a(i1);
        } else
        {
            drawable = null;
        }
        a(drawable);
    }

    public void a(Drawable drawable)
    {
        e = drawable;
        u();
    }

    public void a(ScrollingTabContainerView scrollingtabcontainerview)
    {
        if (c != null && c.getParent() == a)
        {
            a.removeView(c);
        }
        c = scrollingtabcontainerview;
        if (scrollingtabcontainerview != null && o == 2)
        {
            a.addView(c, 0);
            android.support.v7.widget.Toolbar.LayoutParams layoutparams = (android.support.v7.widget.Toolbar.LayoutParams)c.getLayoutParams();
            layoutparams.width = -2;
            layoutparams.height = -2;
            layoutparams.a = 0x800053;
            scrollingtabcontainerview.setAllowCollapse(true);
        }
    }

    public void a(SparseArray sparsearray)
    {
        a.saveHierarchyState(sparsearray);
    }

    public void a(Menu menu, as as)
    {
        if (n == null)
        {
            n = new ActionMenuPresenter(a.getContext());
            n.a(android.support.v7.appcompat.R.id.action_menu_presenter);
        }
        n.a(as);
        a.setMenu((MenuBuilder)menu, n);
    }

    public void a(View view)
    {
        if (d != null && (b & 0x10) != 0)
        {
            a.removeView(d);
        }
        d = view;
        if (view != null && (b & 0x10) != 0)
        {
            a.addView(d);
        }
    }

    public void a(CharSequence charsequence)
    {
        if (!h)
        {
            e(charsequence);
        }
    }

    public void a(l l1)
    {
        l = l1;
    }

    public void a(boolean flag)
    {
        a.setCollapsible(flag);
    }

    public Context b()
    {
        return a.getContext();
    }

    public void b(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = p.a(i1);
        } else
        {
            drawable = null;
        }
        d(drawable);
    }

    public void b(Drawable drawable)
    {
        g = drawable;
        w();
    }

    public void b(SparseArray sparsearray)
    {
        a.restoreHierarchyState(sparsearray);
    }

    public void b(CharSequence charsequence)
    {
        h = true;
        e(charsequence);
    }

    public void b(boolean flag)
    {
    }

    public void c(int i1)
    {
label0:
        {
            int j1 = b ^ i1;
            b = i1;
            if (j1 != 0)
            {
                if ((j1 & 4) != 0)
                {
                    if ((i1 & 4) != 0)
                    {
                        w();
                        v();
                    } else
                    {
                        a.setNavigationIcon(null);
                    }
                }
                if ((j1 & 3) != 0)
                {
                    u();
                }
                if ((j1 & 8) != 0)
                {
                    if ((i1 & 8) != 0)
                    {
                        a.setTitle(i);
                        a.setSubtitle(j);
                    } else
                    {
                        a.setTitle(null);
                        a.setSubtitle(null);
                    }
                }
                if ((j1 & 0x10) != 0 && d != null)
                {
                    if ((i1 & 0x10) == 0)
                    {
                        break label0;
                    }
                    a.addView(d);
                }
            }
            return;
        }
        a.removeView(d);
    }

    public void c(Drawable drawable)
    {
        if (r != drawable)
        {
            r = drawable;
            w();
        }
    }

    public void c(CharSequence charsequence)
    {
        j = charsequence;
        if ((b & 8) != 0)
        {
            a.setSubtitle(charsequence);
        }
    }

    public boolean c()
    {
        return false;
    }

    public void d(int i1)
    {
        if (i1 == 8)
        {
            ViewCompat.animate(a).alpha(0.0F).setListener(new ViewPropertyAnimatorListenerAdapter() {

                final ck a;
                private boolean b;

                public void onAnimationCancel(View view)
                {
                    b = true;
                }

                public void onAnimationEnd(View view)
                {
                    if (!b)
                    {
                        ck.a(a).setVisibility(8);
                    }
                }

            
            {
                a = ck.this;
                super();
                b = false;
            }
            });
        } else
        if (i1 == 0)
        {
            ViewCompat.animate(a).alpha(1.0F).setListener(new ViewPropertyAnimatorListenerAdapter() {

                final ck a;

                public void onAnimationStart(View view)
                {
                    ck.a(a).setVisibility(0);
                }

            
            {
                a = ck.this;
                super();
            }
            });
            return;
        }
    }

    public void d(Drawable drawable)
    {
        f = drawable;
        u();
    }

    public void d(CharSequence charsequence)
    {
        k = charsequence;
        v();
    }

    public boolean d()
    {
        return a.hasExpandedActionView();
    }

    public void e()
    {
        a.collapseActionView();
    }

    public void e(int i1)
    {
        Object obj;
        if (i1 == 0)
        {
            obj = null;
        } else
        {
            obj = b().getString(i1);
        }
        d(((CharSequence) (obj)));
    }

    public CharSequence f()
    {
        return a.getTitle();
    }

    public void f(int i1)
    {
        if (i1 != q)
        {
            q = i1;
            if (TextUtils.isEmpty(a.getNavigationContentDescription()))
            {
                e(q);
                return;
            }
        }
    }

    public void g()
    {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void h()
    {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean i()
    {
        return e != null;
    }

    public boolean j()
    {
        return f != null;
    }

    public boolean k()
    {
        return a.canShowOverflowMenu();
    }

    public boolean l()
    {
        return a.isOverflowMenuShowing();
    }

    public boolean m()
    {
        return a.isOverflowMenuShowPending();
    }

    public boolean n()
    {
        return a.showOverflowMenu();
    }

    public boolean o()
    {
        return a.hideOverflowMenu();
    }

    public void p()
    {
        m = true;
    }

    public void q()
    {
        a.dismissPopupMenus();
    }

    public int r()
    {
        return b;
    }

    public int s()
    {
        return o;
    }
}
