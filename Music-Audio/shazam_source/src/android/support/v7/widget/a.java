// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.aa;
import android.support.v4.view.d;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.b;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.view.menu.p;
import android.support.v7.internal.widget.TintImageView;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            ActionMenuView, s

public final class android.support.v7.widget.a extends android.support.v7.internal.view.menu.b
    implements android.support.v4.view.d.a
{
    private final class a extends k
    {

        final android.support.v7.widget.a g;
        private p h;

        public final void onDismiss()
        {
            super.onDismiss();
            g.n = null;
            g.q = 0;
        }

        public a(Context context, p p1)
        {
            boolean flag1 = false;
            g = android.support.v7.widget.a.this;
            super(context, p1, null, false, android.support.v7.b.a.actionOverflowMenuStyle);
            h = p1;
            int i1;
            if (!((h)p1.getItem()).f())
            {
                int j1;
                boolean flag;
                if (i == null)
                {
                    context = (View)android.support.v7.widget.a.this.g;
                } else
                {
                    context = i;
                }
                super.b = context;
            }
            super.d = android.support.v7.widget.a.this.p;
            j1 = p1.size();
            i1 = 0;
            do
            {
label0:
                {
                    flag = flag1;
                    if (i1 < j1)
                    {
                        a1 = p1.getItem(i1);
                        if (!isVisible() || getIcon() == null)
                        {
                            break label0;
                        }
                        flag = true;
                    }
                    super.e = flag;
                    return;
                }
                i1++;
            } while (true);
        }
    }

    private final class b extends android.support.v7.internal.view.menu.ActionMenuItemView.b
    {

        final android.support.v7.widget.a a;

        public final s a()
        {
            if (a.n != null)
            {
                return ((k) (a.n)).c;
            } else
            {
                return null;
            }
        }

        private b()
        {
            a = android.support.v7.widget.a.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    private final class c
        implements Runnable
    {

        final android.support.v7.widget.a a;
        private e b;

        public final void run()
        {
            Object obj = a.c;
            if (((android.support.v7.internal.view.menu.f) (obj)).b != null)
            {
                ((android.support.v7.internal.view.menu.f) (obj)).b.a(((android.support.v7.internal.view.menu.f) (obj)));
            }
            obj = (View)a.g;
            if (obj != null && ((View) (obj)).getWindowToken() != null && b.b())
            {
                a.m = b;
            }
            a.o = null;
        }

        public c(e e1)
        {
            a = android.support.v7.widget.a.this;
            super();
            b = e1;
        }
    }

    private final class d extends TintImageView
        implements ActionMenuView.a
    {

        final android.support.v7.widget.a a;
        private final float b[] = new float[2];

        public final boolean c()
        {
            return false;
        }

        public final boolean d()
        {
            return false;
        }

        public final boolean performClick()
        {
            if (super.performClick())
            {
                return true;
            } else
            {
                playSoundEffect(0);
                a.d();
                return true;
            }
        }

        protected final boolean setFrame(int i1, int j1, int k1, int l1)
        {
            boolean flag = super.setFrame(i1, j1, k1, l1);
            android.graphics.drawable.Drawable drawable = getDrawable();
            android.graphics.drawable.Drawable drawable1 = getBackground();
            if (drawable != null && drawable1 != null)
            {
                int i2 = getWidth();
                j1 = getHeight();
                i1 = Math.max(i2, j1) / 2;
                int j2 = getPaddingLeft();
                int k2 = getPaddingRight();
                k1 = getPaddingTop();
                l1 = getPaddingBottom();
                i2 = (i2 + (j2 - k2)) / 2;
                j1 = (j1 + (k1 - l1)) / 2;
                android.support.v4.b.a.a.a(drawable1, i2 - i1, j1 - i1, i2 + i1, j1 + i1);
            }
            return flag;
        }

        public d(Context context)
        {
            a = android.support.v7.widget.a.this;
            super(context, null, android.support.v7.b.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new _cls1(this, this, android.support.v7.widget.a.this));
        }
    }

    private final class e extends k
    {

        final android.support.v7.widget.a g;

        public final void onDismiss()
        {
            super.onDismiss();
            g.c.close();
            g.m = null;
        }

        public e(Context context, android.support.v7.internal.view.menu.f f1, View view)
        {
            g = android.support.v7.widget.a.this;
            super(context, f1, view, true, android.support.v7.b.a.actionOverflowMenuStyle);
            super.f = 0x800005;
            super.d = p;
        }
    }

    private final class f
        implements android.support.v7.internal.view.menu.l.a
    {

        final android.support.v7.widget.a a;

        public final void a(android.support.v7.internal.view.menu.f f1, boolean flag)
        {
            if (f1 instanceof p)
            {
                ((p)f1).l.a(false);
            }
            android.support.v7.internal.view.menu.l.a a1 = ((android.support.v7.internal.view.menu.b) (a)).f;
            if (a1 != null)
            {
                a1.a(f1, flag);
            }
        }

        public final boolean a(android.support.v7.internal.view.menu.f f1)
        {
            if (f1 == null)
            {
                return false;
            }
            a.q = ((p)f1).getItem().getItemId();
            android.support.v7.internal.view.menu.l.a a1 = ((android.support.v7.internal.view.menu.b) (a)).f;
            if (a1 != null)
            {
                return a1.a(f1);
            } else
            {
                return false;
            }
        }

        private f()
        {
            a = android.support.v7.widget.a.this;
            super();
        }

        f(byte byte0)
        {
            this();
        }
    }


    private b A;
    View i;
    public int j;
    public boolean k;
    public boolean l;
    e m;
    a n;
    public c o;
    final f p = new f((byte)0);
    int q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private final SparseBooleanArray y = new SparseBooleanArray();
    private View z;

    public android.support.v7.widget.a(Context context)
    {
        super(context, android.support.v7.b.h.abc_action_menu_layout, android.support.v7.b.h.abc_action_menu_item_layout);
    }

    public final m a(ViewGroup viewgroup)
    {
        viewgroup = super.a(viewgroup);
        ((ActionMenuView)viewgroup).setPresenter(this);
        return viewgroup;
    }

    public final View a(h h1, View view, ViewGroup viewgroup)
    {
        View view1 = h1.getActionView();
        if (view1 == null || h1.i())
        {
            view1 = super.a(h1, view, viewgroup);
        }
        byte byte0;
        if (h1.isActionViewExpanded())
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        view1.setVisibility(byte0);
        h1 = (ActionMenuView)viewgroup;
        view = view1.getLayoutParams();
        if (!h1.checkLayoutParams(view))
        {
            view1.setLayoutParams(ActionMenuView.a(view));
        }
        return view1;
    }

    public final void a(int i1)
    {
        t = i1;
        v = true;
        w = true;
    }

    public final void a(Context context, android.support.v7.internal.view.menu.f f1)
    {
        boolean flag = true;
        super.a(context, f1);
        f1 = context.getResources();
        context = android.support.v7.internal.view.a.a(context);
        if (!s)
        {
            int i1;
            int j1;
            if (android.os.Build.VERSION.SDK_INT < 19 && aa.b(ViewConfiguration.get(((android.support.v7.internal.view.a) (context)).a)))
            {
                flag = false;
            }
            r = flag;
        }
        if (!w)
        {
            t = ((android.support.v7.internal.view.a) (context)).a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!k)
        {
            j = ((android.support.v7.internal.view.a) (context)).a.getResources().getInteger(android.support.v7.b.g.abc_max_action_buttons);
        }
        i1 = t;
        if (r)
        {
            if (i == null)
            {
                i = new d(a);
                j1 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
                i.measure(j1, j1);
            }
            i1 -= i.getMeasuredWidth();
        } else
        {
            i = null;
        }
        u = i1;
        x = (int)(56F * f1.getDisplayMetrics().density);
        z = null;
    }

    public final void a(android.support.v7.internal.view.menu.f f1, boolean flag)
    {
        f();
        super.a(f1, flag);
    }

    public final void a(h h1, android.support.v7.internal.view.menu.m.a a1)
    {
        a1.a(h1);
        h1 = (ActionMenuView)g;
        a1 = (ActionMenuItemView)a1;
        a1.setItemInvoker(h1);
        if (A == null)
        {
            A = new b((byte)0);
        }
        a1.setPopupCallback(A);
    }

    public final void a(ActionMenuView actionmenuview)
    {
        g = actionmenuview;
        actionmenuview.a = c;
    }

    public final void a(boolean flag)
    {
        if (flag)
        {
            super.a(null);
            return;
        } else
        {
            c.a(false);
            return;
        }
    }

    public final boolean a()
    {
        ArrayList arraylist;
        ViewGroup viewgroup;
        int k1;
        int l1;
        int l4;
        int j6;
        int k6;
label0:
        {
            arraylist = c.h();
            j6 = arraylist.size();
            int i1 = j;
            l4 = u;
            k6 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            viewgroup = (ViewGroup)g;
            l1 = 0;
            int i2 = 0;
            boolean flag = false;
            k1 = 0;
            while (k1 < j6) 
            {
                h h1 = (h)arraylist.get(k1);
                if (h1.h())
                {
                    l1++;
                } else
                if (h1.g())
                {
                    i2++;
                } else
                {
                    flag = true;
                }
                if (l && h1.isActionViewExpanded())
                {
                    i1 = 0;
                }
                k1++;
            }
            k1 = i1;
            if (!r)
            {
                break label0;
            }
            if (!flag)
            {
                k1 = i1;
                if (l1 + i2 <= i1)
                {
                    break label0;
                }
            }
            k1 = i1 - 1;
        }
        k1 -= l1;
        SparseBooleanArray sparsebooleanarray = y;
        sparsebooleanarray.clear();
        int j1;
        int k2;
        boolean flag1;
        int j4;
        int k4;
        if (v)
        {
            j1 = l4 / x;
            l1 = x;
            int j2 = x;
            j4 = (l4 % l1) / j1 + j2;
        } else
        {
            j4 = 0;
            j1 = 0;
        }
        flag1 = false;
        k4 = 0;
        l1 = j1;
        j1 = k1;
        k2 = l4;
        k1 = ((flag1) ? 1 : 0);
        while (k4 < j6) 
        {
            h h2 = (h)arraylist.get(k4);
            if (h2.h())
            {
                View view = a(h2, z, viewgroup);
                if (z == null)
                {
                    z = view;
                }
                int l2;
                int i5;
                if (v)
                {
                    l2 = l1 - ActionMenuView.a(view, j4, l1, k6, 0);
                } else
                {
                    view.measure(k6, k6);
                    l2 = l1;
                }
                l1 = view.getMeasuredWidth();
                if (k1 == 0)
                {
                    k1 = l1;
                }
                i5 = h2.getGroupId();
                if (i5 != 0)
                {
                    sparsebooleanarray.put(i5, true);
                }
                h2.c(true);
                l1 = k2 - l1;
                k2 = j1;
                j1 = l2;
            } else
            if (h2.g())
            {
                int l6 = h2.getGroupId();
                boolean flag3 = sparsebooleanarray.get(l6);
                boolean flag2;
                if ((j1 > 0 || flag3) && k2 > 0 && (!v || l1 > 0))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                int l3;
                if (flag2)
                {
                    View view1 = a(h2, z, viewgroup);
                    if (z == null)
                    {
                        z = view1;
                    }
                    int j3;
                    int k5;
                    if (v)
                    {
                        int j5 = ActionMenuView.a(view1, j4, l1, k6, 0);
                        int i3 = l1 - j5;
                        l1 = i3;
                        if (j5 == 0)
                        {
                            flag2 = false;
                            l1 = i3;
                        }
                    } else
                    {
                        view1.measure(k6, k6);
                    }
                    k5 = view1.getMeasuredWidth();
                    k2 -= k5;
                    j3 = k1;
                    if (k1 == 0)
                    {
                        j3 = k5;
                    }
                    if (v)
                    {
                        int l5;
                        if (k2 >= 0)
                        {
                            k1 = 1;
                        } else
                        {
                            k1 = 0;
                        }
                        flag2 &= k1;
                        k1 = l1;
                        l1 = j3;
                    } else
                    {
                        if (k2 + j3 > 0)
                        {
                            k1 = 1;
                        } else
                        {
                            k1 = 0;
                        }
                        flag2 &= k1;
                        k1 = l1;
                        l1 = j3;
                    }
                } else
                {
                    int i4 = l1;
                    l1 = k1;
                    k1 = i4;
                }
                if (flag2 && l6 != 0)
                {
                    sparsebooleanarray.put(l6, true);
                } else
                if (flag3)
                {
                    sparsebooleanarray.put(l6, false);
                    int i6 = 0;
                    while (i6 < k4) 
                    {
                        h h3 = (h)arraylist.get(i6);
                        int k3 = j1;
                        if (h3.getGroupId() == l6)
                        {
                            k3 = j1;
                            if (h3.f())
                            {
                                k3 = j1 + 1;
                            }
                            h3.c(false);
                        }
                        i6++;
                        j1 = k3;
                    }
                }
                j3 = j1;
                if (flag2)
                {
                    j3 = j1 - 1;
                }
                h2.c(flag2);
                l5 = l1;
                l1 = k2;
                k2 = j3;
                j1 = k1;
                k1 = l5;
            } else
            {
                h2.c(false);
                l3 = j1;
                j1 = l1;
                l1 = k2;
                k2 = l3;
            }
            i5 = k4 + 1;
            l2 = l1;
            k4 = k2;
            l1 = j1;
            k2 = l2;
            j1 = k4;
            k4 = i5;
        }
        return true;
    }

    public final boolean a(h h1)
    {
        return h1.f();
    }

    public final boolean a(p p1)
    {
        MenuItem menuitem;
        ViewGroup viewgroup;
        if (!p1.hasVisibleItems())
        {
            return false;
        }
        p p2;
        for (p2 = p1; p2.l != c; p2 = (p)p2.l) { }
        menuitem = p2.getItem();
        viewgroup = (ViewGroup)g;
        if (viewgroup == null) goto _L2; else goto _L1
_L1:
        int i1;
        int j1;
        j1 = viewgroup.getChildCount();
        i1 = 0;
_L7:
        if (i1 >= j1) goto _L2; else goto _L3
_L3:
        View view = viewgroup.getChildAt(i1);
        if (!(view instanceof android.support.v7.internal.view.menu.m.a) || ((android.support.v7.internal.view.menu.m.a)view).getItemData() != menuitem) goto _L5; else goto _L4
_L5:
        i1++;
        continue; /* Loop/switch isn't completed */
_L2:
        view = null;
_L4:
        View view1 = view;
        if (view == null)
        {
            if (i == null)
            {
                return false;
            }
            view1 = i;
        }
        q = p1.getItem().getItemId();
        n = new a(b, p1);
        n.b = view1;
        if (!n.b())
        {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        super.a(p1);
        return true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final boolean a(ViewGroup viewgroup, int i1)
    {
        if (viewgroup.getChildAt(i1) == i)
        {
            return false;
        } else
        {
            return super.a(viewgroup, i1);
        }
    }

    public final void b()
    {
        r = true;
        s = true;
    }

    public final void b(boolean flag)
    {
        boolean flag1 = true;
        boolean flag2 = false;
        ((View)g).getParent();
        super.b(flag);
        ((View)g).requestLayout();
        if (c != null)
        {
            Object obj = c;
            ((android.support.v7.internal.view.menu.f) (obj)).i();
            obj = ((android.support.v7.internal.view.menu.f) (obj)).d;
            int k1 = ((ArrayList) (obj)).size();
            for (int i1 = 0; i1 < k1; i1++)
            {
                android.support.v4.view.d d1 = ((h)((ArrayList) (obj)).get(i1)).d;
                if (d1 != null)
                {
                    d1.setSubUiVisibilityListener(this);
                }
            }

        }
        Object obj1;
        int j1;
        if (c != null)
        {
            obj1 = c.j();
        } else
        {
            obj1 = null;
        }
        j1 = ((flag2) ? 1 : 0);
        if (r)
        {
            j1 = ((flag2) ? 1 : 0);
            if (obj1 != null)
            {
                j1 = ((ArrayList) (obj1)).size();
                if (j1 == 1)
                {
                    if (!((h)((ArrayList) (obj1)).get(0)).isActionViewExpanded())
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = 0;
                    }
                } else
                if (j1 > 0)
                {
                    j1 = ((flag1) ? 1 : 0);
                } else
                {
                    j1 = 0;
                }
            }
        }
        if (j1 == 0) goto _L2; else goto _L1
_L1:
        if (i == null)
        {
            i = new d(a);
        }
        obj1 = (ViewGroup)i.getParent();
        if (obj1 != g)
        {
            if (obj1 != null)
            {
                ((ViewGroup) (obj1)).removeView(i);
            }
            ((ActionMenuView)g).addView(i, ActionMenuView.a());
        }
_L4:
        ((ActionMenuView)g).setOverflowReserved(r);
        return;
_L2:
        if (i != null && i.getParent() == g)
        {
            ((ViewGroup)g).removeView(i);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void c()
    {
        j = 0x7fffffff;
        k = true;
    }

    public final boolean d()
    {
        if (r && !h() && c != null && g != null && o == null && !c.j().isEmpty())
        {
            o = new c(new e(b, c, i));
            ((View)g).post(o);
            super.a(null);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean e()
    {
        if (o != null && g != null)
        {
            ((View)g).removeCallbacks(o);
            o = null;
            return true;
        }
        e e1 = m;
        if (e1 != null)
        {
            e1.c();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean f()
    {
        return e() | g();
    }

    public final boolean g()
    {
        if (n != null)
        {
            n.c();
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean h()
    {
        return m != null && m.d();
    }

    // Unreferenced inner class android/support/v7/widget/a$d$1

/* anonymous class */
    final class d._cls1 extends s.b
    {

        final android.support.v7.widget.a a;
        final d b;

        public final s a()
        {
            if (b.a.m == null)
            {
                return null;
            } else
            {
                return ((k) (b.a.m)).c;
            }
        }

        public final boolean b()
        {
            b.a.d();
            return true;
        }

        public final boolean c()
        {
            if (b.a.o != null)
            {
                return false;
            } else
            {
                b.a.e();
                return true;
            }
        }

            
            {
                b = d1;
                a = a1;
                super(view);
            }
    }

}
