// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v4.view.ai;
import android.support.v4.view.w;
import android.support.v7.internal.view.menu.b;
import android.support.v7.internal.view.menu.f;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package android.support.v7.internal.widget:
//            h, r, l, q, 
//            m

public final class s
    implements h
{

    Toolbar a;
    CharSequence b;
    android.view.Window.Callback c;
    boolean d;
    private int e;
    private View f;
    private View g;
    private Drawable h;
    private Drawable i;
    private Drawable j;
    private boolean k;
    private CharSequence l;
    private CharSequence m;
    private a n;
    private int o;
    private final q p;
    private int q;
    private Drawable r;

    public s(Toolbar toolbar, boolean flag)
    {
        this(toolbar, flag, android.support.v7.b.a.i.abc_action_bar_up_description, android.support.v7.b.a.e.abc_ic_ab_back_mtrl_am_alpha);
    }

    private s(Toolbar toolbar, boolean flag, int i1, int j1)
    {
        o = 0;
        q = 0;
        a = toolbar;
        b = toolbar.getTitle();
        l = toolbar.getSubtitle();
        boolean flag1;
        if (b != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        k = flag1;
        j = toolbar.getNavigationIcon();
        if (flag)
        {
            toolbar = android.support.v7.internal.widget.r.a(toolbar.getContext(), null, android.support.v7.b.a.k.ActionBar, android.support.v7.b.a.a.actionBarStyle);
            Object obj = toolbar.c(android.support.v7.b.a.k.ActionBar_title);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                b(((CharSequence) (obj)));
            }
            obj = toolbar.c(android.support.v7.b.a.k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                l = ((CharSequence) (obj));
                if ((e & 8) != 0)
                {
                    a.setSubtitle(((CharSequence) (obj)));
                }
            }
            obj = toolbar.a(android.support.v7.b.a.k.ActionBar_logo);
            if (obj != null)
            {
                b(((Drawable) (obj)));
            }
            obj = toolbar.a(android.support.v7.b.a.k.ActionBar_icon);
            if (j == null && obj != null)
            {
                a(((Drawable) (obj)));
            }
            obj = toolbar.a(android.support.v7.b.a.k.ActionBar_homeAsUpIndicator);
            if (obj != null)
            {
                j = ((Drawable) (obj));
                t();
            }
            c(toolbar.a(android.support.v7.b.a.k.ActionBar_displayOptions, 0));
            int k1 = toolbar.e(android.support.v7.b.a.k.ActionBar_customNavigationLayout, 0);
            if (k1 != 0)
            {
                View view = LayoutInflater.from(a.getContext()).inflate(k1, a, false);
                if (g != null && (e & 0x10) != 0)
                {
                    a.removeView(g);
                }
                g = view;
                if (view != null && (e & 0x10) != 0)
                {
                    a.addView(g);
                }
                c(e | 0x10);
            }
            k1 = toolbar.d(android.support.v7.b.a.k.ActionBar_height, 0);
            if (k1 > 0)
            {
                android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
                layoutparams.height = k1;
                a.setLayoutParams(layoutparams);
            }
            int i2 = toolbar.b(android.support.v7.b.a.k.ActionBar_contentInsetStart, -1);
            k1 = toolbar.b(android.support.v7.b.a.k.ActionBar_contentInsetEnd, -1);
            if (i2 >= 0 || k1 >= 0)
            {
                Toolbar toolbar1 = a;
                i2 = Math.max(i2, 0);
                k1 = Math.max(k1, 0);
                toolbar1.i.a(i2, k1);
            }
            k1 = toolbar.e(android.support.v7.b.a.k.ActionBar_titleTextStyle, 0);
            if (k1 != 0)
            {
                Toolbar toolbar2 = a;
                Context context = a.getContext();
                toolbar2.g = k1;
                if (toolbar2.b != null)
                {
                    toolbar2.b.setTextAppearance(context, k1);
                }
            }
            k1 = toolbar.e(android.support.v7.b.a.k.ActionBar_subtitleTextStyle, 0);
            if (k1 != 0)
            {
                Toolbar toolbar3 = a;
                Context context1 = a.getContext();
                toolbar3.h = k1;
                if (toolbar3.c != null)
                {
                    toolbar3.c.setTextAppearance(context1, k1);
                }
            }
            k1 = toolbar.e(android.support.v7.b.a.k.ActionBar_popupTheme, 0);
            if (k1 != 0)
            {
                a.setPopupTheme(k1);
            }
            ((r) (toolbar)).a.recycle();
            p = toolbar.a();
        } else
        {
            int l1 = 11;
            if (a.getNavigationIcon() != null)
            {
                l1 = 15;
            }
            e = l1;
            p = android.support.v7.internal.widget.q.a(toolbar.getContext());
        }
        if (i1 != q)
        {
            q = i1;
            if (TextUtils.isEmpty(a.getNavigationContentDescription()))
            {
                i1 = q;
                if (i1 == 0)
                {
                    toolbar = null;
                } else
                {
                    toolbar = a.getContext().getString(i1);
                }
                m = toolbar;
                s();
            }
        }
        m = a.getNavigationContentDescription();
        toolbar = p.a(j1, false);
        if (r != toolbar)
        {
            r = toolbar;
            t();
        }
        a.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final android.support.v7.internal.view.menu.a a;
            final s b;

            public final void onClick(View view1)
            {
                if (b.c != null && b.d)
                {
                    b.c.onMenuItemSelected(0, a);
                }
            }

            
            {
                b = s.this;
                super();
                a = new android.support.v7.internal.view.menu.a(b.a.getContext(), b.b);
            }
        });
    }

    private void b(Drawable drawable)
    {
        i = drawable;
        r();
    }

    private void c(CharSequence charsequence)
    {
        b = charsequence;
        if ((e & 8) != 0)
        {
            a.setTitle(charsequence);
        }
    }

    private void r()
    {
        Drawable drawable = null;
        if ((e & 2) != 0)
        {
            if ((e & 1) != 0)
            {
                if (i != null)
                {
                    drawable = i;
                } else
                {
                    drawable = h;
                }
            } else
            {
                drawable = h;
            }
        }
        a.setLogo(drawable);
    }

    private void s()
    {
label0:
        {
            if ((e & 4) != 0)
            {
                if (!TextUtils.isEmpty(m))
                {
                    break label0;
                }
                a.setNavigationContentDescription(q);
            }
            return;
        }
        a.setNavigationContentDescription(m);
    }

    private void t()
    {
        if ((e & 4) != 0)
        {
            Toolbar toolbar = a;
            Drawable drawable;
            if (j != null)
            {
                drawable = j;
            } else
            {
                drawable = r;
            }
            toolbar.setNavigationIcon(drawable);
        }
    }

    public final ViewGroup a()
    {
        return a;
    }

    public final void a(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = p.a(i1, false);
        } else
        {
            drawable = null;
        }
        a(drawable);
    }

    public final void a(Drawable drawable)
    {
        h = drawable;
        r();
    }

    public final void a(android.support.v7.internal.view.menu.l.a a1, android.support.v7.internal.view.menu.f.a a2)
    {
        Toolbar toolbar = a;
        toolbar.l = a1;
        toolbar.m = a2;
    }

    public final void a(m m1)
    {
        if (f != null && f.getParent() == a)
        {
            a.removeView(f);
        }
        f = m1;
        if (m1 != null && o == 2)
        {
            a.addView(f, 0);
            android.support.v7.widget.Toolbar.b b1 = (android.support.v7.widget.Toolbar.b)f.getLayoutParams();
            b1.width = -2;
            b1.height = -2;
            b1.a = 0x800053;
            m1.setAllowCollapse(true);
        }
    }

    public final void a(Menu menu, android.support.v7.internal.view.menu.l.a a1)
    {
        if (n == null)
        {
            n = new a(a.getContext());
            n.h = android.support.v7.b.a.f.action_menu_presenter;
        }
        n.f = a1;
        a1 = a;
        menu = (f)menu;
        a a2 = n;
        if (menu != null || ((Toolbar) (a1)).a != null)
        {
            a1.d();
            f f1 = ((Toolbar) (a1)).a.a;
            if (f1 != menu)
            {
                if (f1 != null)
                {
                    f1.b(((Toolbar) (a1)).j);
                    f1.b(((Toolbar) (a1)).k);
                }
                if (((Toolbar) (a1)).k == null)
                {
                    a1.k = new android.support.v7.widget.Toolbar.a(a1, (byte)0);
                }
                a2.l = true;
                if (menu != null)
                {
                    menu.a(a2, ((Toolbar) (a1)).e);
                    menu.a(((Toolbar) (a1)).k, ((Toolbar) (a1)).e);
                } else
                {
                    a2.a(((Toolbar) (a1)).e, null);
                    ((Toolbar) (a1)).k.a(((Toolbar) (a1)).e, null);
                    a2.b(true);
                    ((Toolbar) (a1)).k.b(true);
                }
                ((Toolbar) (a1)).a.setPopupTheme(((Toolbar) (a1)).f);
                ((Toolbar) (a1)).a.setPresenter(a2);
                a1.j = a2;
            }
        }
    }

    public final void a(android.view.Window.Callback callback)
    {
        c = callback;
    }

    public final void a(CharSequence charsequence)
    {
        if (!k)
        {
            c(charsequence);
        }
    }

    public final void a(boolean flag)
    {
        a.setCollapsible(flag);
    }

    public final Context b()
    {
        return a.getContext();
    }

    public final void b(int i1)
    {
        Drawable drawable;
        if (i1 != 0)
        {
            drawable = p.a(i1, false);
        } else
        {
            drawable = null;
        }
        b(drawable);
    }

    public final void b(CharSequence charsequence)
    {
        k = true;
        c(charsequence);
    }

    public final void c(int i1)
    {
label0:
        {
            int j1 = e ^ i1;
            e = i1;
            if (j1 != 0)
            {
                if ((j1 & 4) != 0)
                {
                    if ((i1 & 4) != 0)
                    {
                        t();
                        s();
                    } else
                    {
                        a.setNavigationIcon(null);
                    }
                }
                if ((j1 & 3) != 0)
                {
                    r();
                }
                if ((j1 & 8) != 0)
                {
                    if ((i1 & 8) != 0)
                    {
                        a.setTitle(b);
                        a.setSubtitle(l);
                    } else
                    {
                        a.setTitle(null);
                        a.setSubtitle(null);
                    }
                }
                if ((j1 & 0x10) != 0 && g != null)
                {
                    if ((i1 & 0x10) == 0)
                    {
                        break label0;
                    }
                    a.addView(g);
                }
            }
            return;
        }
        a.removeView(g);
    }

    public final boolean c()
    {
        Toolbar toolbar = a;
        return toolbar.k != null && toolbar.k.b != null;
    }

    public final void d()
    {
        a.c();
    }

    public final void d(int i1)
    {
        if (i1 == 8)
        {
            w.n(a).a(0.0F).a(new ai() {

                final s a;
                private boolean b;

                public final void b(View view)
                {
                    if (!b)
                    {
                        a.a.setVisibility(8);
                    }
                }

                public final void c(View view)
                {
                    b = true;
                }

            
            {
                a = s.this;
                super();
                b = false;
            }
            });
        } else
        if (i1 == 0)
        {
            w.n(a).a(1.0F).a(new ai() {

                final s a;

                public final void a(View view)
                {
                    a.a.setVisibility(0);
                }

            
            {
                a = s.this;
                super();
            }
            });
            return;
        }
    }

    public final CharSequence e()
    {
        return a.getTitle();
    }

    public final void e(int i1)
    {
        a.setVisibility(i1);
    }

    public final boolean f()
    {
        Toolbar toolbar = a;
        return toolbar.getVisibility() == 0 && toolbar.a != null && toolbar.a.b;
    }

    public final boolean g()
    {
        return a.a();
    }

    public final boolean h()
    {
        Object obj = a;
        if (((Toolbar) (obj)).a == null) goto _L2; else goto _L1
_L1:
        obj = ((Toolbar) (obj)).a;
        if (((ActionMenuView) (obj)).c == null) goto _L4; else goto _L3
_L3:
        boolean flag;
        obj = ((ActionMenuView) (obj)).c;
        if (((a) (obj)).o != null || ((a) (obj)).h())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L5
_L5:
        flag = true;
_L6:
        if (flag)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
        flag = false;
        if (true) goto _L6; else goto _L2
_L2:
        return false;
    }

    public final boolean i()
    {
        return a.b();
    }

    public final boolean j()
    {
        Object obj = a;
        if (((Toolbar) (obj)).a != null)
        {
            obj = ((Toolbar) (obj)).a;
            boolean flag;
            if (((ActionMenuView) (obj)).c != null && ((ActionMenuView) (obj)).c.e())
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

    public final void k()
    {
        d = true;
    }

    public final void l()
    {
        Toolbar toolbar = a;
        if (toolbar.a != null)
        {
            toolbar.a.b();
        }
    }

    public final int m()
    {
        return e;
    }

    public final int n()
    {
        return o;
    }

    public final int o()
    {
        return a.getHeight();
    }

    public final int p()
    {
        return a.getVisibility();
    }

    public final Menu q()
    {
        return a.getMenu();
    }
}
