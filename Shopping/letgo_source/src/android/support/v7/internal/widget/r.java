// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ah;
import android.support.v4.view.ay;
import android.support.v4.view.bd;
import android.support.v7.internal.view.menu.a;
import android.support.v7.internal.view.menu.f;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v7.internal.widget:
//            g, q, p, l

public class r
    implements g
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
    private android.view.Window.Callback l;
    private boolean m;
    private ActionMenuPresenter n;
    private int o;
    private final p p;
    private int q;
    private Drawable r;

    public r(Toolbar toolbar, boolean flag)
    {
        this(toolbar, flag, android.support.v7.br.i.abc_action_bar_up_description, android.support.v7.br.e.abc_ic_ab_back_mtrl_am_alpha);
    }

    public r(Toolbar toolbar, boolean flag, int i1, int j1)
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
        g = toolbar.getNavigationIcon();
        if (flag)
        {
            toolbar = android.support.v7.internal.widget.q.a(toolbar.getContext(), null, android.support.v7.br.k.ActionBar, android.support.v7.br.a.actionBarStyle, 0);
            Object obj = toolbar.c(android.support.v7.br.k.ActionBar_title);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                b(((CharSequence) (obj)));
            }
            obj = toolbar.c(android.support.v7.br.k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                c(((CharSequence) (obj)));
            }
            obj = toolbar.a(android.support.v7.br.k.ActionBar_logo);
            if (obj != null)
            {
                d(((Drawable) (obj)));
            }
            obj = toolbar.a(android.support.v7.br.k.ActionBar_icon);
            if (g == null && obj != null)
            {
                a(((Drawable) (obj)));
            }
            obj = toolbar.a(android.support.v7.br.k.ActionBar_homeAsUpIndicator);
            if (obj != null)
            {
                b(((Drawable) (obj)));
            }
            c(toolbar.a(android.support.v7.br.k.ActionBar_displayOptions, 0));
            int k1 = toolbar.f(android.support.v7.br.k.ActionBar_customNavigationLayout, 0);
            if (k1 != 0)
            {
                a(LayoutInflater.from(a.getContext()).inflate(k1, a, false));
                c(b | 0x10);
            }
            k1 = toolbar.e(android.support.v7.br.k.ActionBar_height, 0);
            if (k1 > 0)
            {
                android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
                layoutparams.height = k1;
                a.setLayoutParams(layoutparams);
            }
            k1 = toolbar.c(android.support.v7.br.k.ActionBar_contentInsetStart, -1);
            int l1 = toolbar.c(android.support.v7.br.k.ActionBar_contentInsetEnd, -1);
            if (k1 >= 0 || l1 >= 0)
            {
                a.setContentInsetsRelative(Math.max(k1, 0), Math.max(l1, 0));
            }
            k1 = toolbar.f(android.support.v7.br.k.ActionBar_titleTextStyle, 0);
            if (k1 != 0)
            {
                a.setTitleTextAppearance(a.getContext(), k1);
            }
            k1 = toolbar.f(android.support.v7.br.k.ActionBar_subtitleTextStyle, 0);
            if (k1 != 0)
            {
                a.setSubtitleTextAppearance(a.getContext(), k1);
            }
            k1 = toolbar.f(android.support.v7.br.k.ActionBar_popupTheme, 0);
            if (k1 != 0)
            {
                a.setPopupTheme(k1);
            }
            toolbar.b();
            p = toolbar.c();
        } else
        {
            b = t();
            p = android.support.v7.internal.widget.p.a(toolbar.getContext());
        }
        f(i1);
        k = a.getNavigationContentDescription();
        c(p.a(j1));
        a.setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final a a;
            final r b;

            public void onClick(View view)
            {
                if (r.c(b) != null && r.d(b))
                {
                    r.c(b).onMenuItemSelected(0, a);
                }
            }

            
            {
                b = r.this;
                super();
                a = new a(android.support.v7.internal.widget.r.a(b).getContext(), 0, 0x102002c, 0, 0, r.b(b));
            }
        });
    }

    static Toolbar a(r r1)
    {
        return r1.a;
    }

    static CharSequence b(r r1)
    {
        return r1.i;
    }

    static android.view.Window.Callback c(r r1)
    {
        return r1.l;
    }

    static boolean d(r r1)
    {
        return r1.m;
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

    public void a(android.support.v7.internal.view.menu.l.a a1, android.support.v7.internal.view.menu.f.a a2)
    {
        a.setMenuCallbacks(a1, a2);
    }

    public void a(l l1)
    {
        if (c != null && c.getParent() == a)
        {
            a.removeView(c);
        }
        c = l1;
        if (l1 != null && o == 2)
        {
            a.addView(c, 0);
            android.support.v7.widget.Toolbar.LayoutParams layoutparams = (android.support.v7.widget.Toolbar.LayoutParams)c.getLayoutParams();
            layoutparams.width = -2;
            layoutparams.height = -2;
            layoutparams.gravity = 0x800053;
            l1.setAllowCollapse(true);
        }
    }

    public void a(Menu menu, android.support.v7.internal.view.menu.l.a a1)
    {
        if (n == null)
        {
            n = new ActionMenuPresenter(a.getContext());
            n.setId(android.support.v7.br.f.action_menu_presenter);
        }
        n.setCallback(a1);
        a.setMenu((f)menu, n);
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

    public void a(android.view.Window.Callback callback)
    {
        l = callback;
    }

    public void a(CharSequence charsequence)
    {
        if (!h)
        {
            e(charsequence);
        }
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
            ah.q(a).a(0.0F).a(new bd() {

                final r a;
                private boolean b;

                public void onAnimationCancel(View view)
                {
                    b = true;
                }

                public void onAnimationEnd(View view)
                {
                    if (!b)
                    {
                        android.support.v7.internal.widget.r.a(a).setVisibility(8);
                    }
                }

            
            {
                a = r.this;
                super();
                b = false;
            }
            });
        } else
        if (i1 == 0)
        {
            ah.q(a).a(1.0F).a(new bd() {

                final r a;

                public void onAnimationStart(View view)
                {
                    android.support.v7.internal.widget.r.a(a).setVisibility(0);
                }

            
            {
                a = r.this;
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
        return a.canShowOverflowMenu();
    }

    public boolean j()
    {
        return a.isOverflowMenuShowing();
    }

    public boolean k()
    {
        return a.isOverflowMenuShowPending();
    }

    public boolean l()
    {
        return a.showOverflowMenu();
    }

    public boolean m()
    {
        return a.hideOverflowMenu();
    }

    public void n()
    {
        m = true;
    }

    public void o()
    {
        a.dismissPopupMenus();
    }

    public int p()
    {
        return b;
    }

    public int q()
    {
        return o;
    }

    public View r()
    {
        return d;
    }

    public Menu s()
    {
        return a.getMenu();
    }
}
