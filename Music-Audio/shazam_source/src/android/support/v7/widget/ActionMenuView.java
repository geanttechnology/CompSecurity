// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.b;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.m;
import android.support.v7.internal.widget.t;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7.widget:
//            q, a

public class ActionMenuView extends q
    implements android.support.v7.internal.view.menu.f.b, m
{
    public static interface a
    {

        public abstract boolean c();

        public abstract boolean d();
    }

    private final class b
        implements android.support.v7.internal.view.menu.l.a
    {

        final ActionMenuView a;

        public final void a(f f1, boolean flag)
        {
        }

        public final boolean a(f f1)
        {
            return false;
        }

        private b()
        {
            a = ActionMenuView.this;
            super();
        }

        b(byte byte0)
        {
            this();
        }
    }

    public static final class c extends q.a
    {

        public boolean a;
        public int b;
        public int c;
        public boolean d;
        public boolean e;
        boolean f;

        public c()
        {
            super(-2, -2);
            a = false;
        }

        public c(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public c(c c1)
        {
            super(c1);
            a = c1.a;
        }

        public c(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }
    }

    private final class d
        implements android.support.v7.internal.view.menu.f.a
    {

        final ActionMenuView a;

        public final void a(f f1)
        {
            if (android.support.v7.widget.ActionMenuView.b(a) != null)
            {
                android.support.v7.widget.ActionMenuView.b(a).a(f1);
            }
        }

        public final boolean a(f f1, MenuItem menuitem)
        {
            return ActionMenuView.a(a) != null && ActionMenuView.a(a).a(menuitem);
        }

        private d()
        {
            a = ActionMenuView.this;
            super();
        }

        d(byte byte0)
        {
            this();
        }
    }

    public static interface e
    {

        public abstract boolean a(MenuItem menuitem);
    }


    public f a;
    public boolean b;
    public android.support.v7.widget.a c;
    android.support.v7.internal.view.menu.l.a d;
    android.support.v7.internal.view.menu.f.a e;
    private Context f;
    private Context g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private e m;

    public ActionMenuView(Context context)
    {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = context;
        setBaselineAligned(false);
        float f1 = context.getResources().getDisplayMetrics().density;
        k = (int)(56F * f1);
        l = (int)(f1 * 4F);
        g = context;
        h = 0;
    }

    static int a(View view, int i1, int j1, int k1, int l1)
    {
        boolean flag1 = false;
        c c1 = (c)view.getLayoutParams();
        int i2 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(k1) - l1, android.view.View.MeasureSpec.getMode(k1));
        ActionMenuItemView actionmenuitemview;
        boolean flag;
        if (view instanceof ActionMenuItemView)
        {
            actionmenuitemview = (ActionMenuItemView)view;
        } else
        {
            actionmenuitemview = null;
        }
        if (actionmenuitemview != null && actionmenuitemview.b())
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (j1 > 0 && (l1 == 0 || j1 >= 2))
        {
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(i1 * j1, 0x80000000), i2);
            int j2 = view.getMeasuredWidth();
            k1 = j2 / i1;
            j1 = k1;
            if (j2 % i1 != 0)
            {
                j1 = k1 + 1;
            }
            k1 = j1;
            if (l1 != 0)
            {
                k1 = j1;
                if (j1 < 2)
                {
                    k1 = 2;
                }
            }
        } else
        {
            k1 = 0;
        }
        flag = flag1;
        if (!c1.a)
        {
            flag = flag1;
            if (l1 != 0)
            {
                flag = true;
            }
        }
        c1.d = flag;
        c1.b = k1;
        view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1 * i1, 0x40000000), i2);
        return k1;
    }

    public static c a()
    {
        c c1 = d();
        c1.a = true;
        return c1;
    }

    protected static c a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams != null)
        {
            if (layoutparams instanceof c)
            {
                layoutparams = new c((c)layoutparams);
            } else
            {
                layoutparams = new c(layoutparams);
            }
            if (((c) (layoutparams)).h <= 0)
            {
                layoutparams.h = 16;
            }
            return layoutparams;
        } else
        {
            return d();
        }
    }

    static e a(ActionMenuView actionmenuview)
    {
        return actionmenuview.m;
    }

    private boolean a(int i1)
    {
        boolean flag1 = false;
        if (i1 == 0)
        {
            return false;
        }
        View view = getChildAt(i1 - 1);
        View view1 = getChildAt(i1);
        boolean flag = flag1;
        if (i1 < getChildCount())
        {
            flag = flag1;
            if (view instanceof a)
            {
                flag = ((a)view).d() | false;
            }
        }
        if (i1 > 0 && (view1 instanceof a))
        {
            return ((a)view1).c() | flag;
        } else
        {
            return flag;
        }
    }

    static android.support.v7.internal.view.menu.f.a b(ActionMenuView actionmenuview)
    {
        return actionmenuview.e;
    }

    private c b(AttributeSet attributeset)
    {
        return new c(getContext(), attributeset);
    }

    private static c d()
    {
        c c1 = new c();
        c1.h = 16;
        return c1;
    }

    public final q.a a(AttributeSet attributeset)
    {
        return b(attributeset);
    }

    public final void a(f f1)
    {
        a = f1;
    }

    public final boolean a(h h1)
    {
        return a.a(h1, null, 0);
    }

    protected final q.a b(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public final void b()
    {
        if (c != null)
        {
            c.f();
        }
    }

    protected final q.a c()
    {
        return d();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams != null && (layoutparams instanceof c);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityevent)
    {
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return d();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return b(attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return a(layoutparams);
    }

    public Menu getMenu()
    {
        if (a == null)
        {
            Object obj = getContext();
            a = new f(((Context) (obj)));
            a.a(new d((byte)0));
            c = new android.support.v7.widget.a(((Context) (obj)));
            c.b();
            android.support.v7.widget.a a1 = c;
            if (d != null)
            {
                obj = d;
            } else
            {
                obj = new b((byte)0);
            }
            a1.f = ((android.support.v7.internal.view.menu.l.a) (obj));
            a.a(c, g);
            c.a(this);
        }
        return a;
    }

    public int getPopupTheme()
    {
        return h;
    }

    public int getWindowAnimations()
    {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        if (c != null)
        {
            c.b(false);
            if (c.h())
            {
                c.e();
                c.d();
            }
        }
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        b();
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (i) goto _L2; else goto _L1
_L1:
        super.onLayout(flag, i1, j1, k1, l1);
_L4:
        return;
_L2:
        int i4 = getChildCount();
        int l3 = (l1 - j1) / 2;
        int j4 = getDividerWidth();
        j1 = 0;
        l1 = k1 - i1 - getPaddingRight() - getPaddingLeft();
        int j2 = 0;
        flag = t.a(this);
        int i2 = 0;
        while (i2 < i4) 
        {
            View view = getChildAt(i2);
            c c2;
            if (view.getVisibility() != 8)
            {
                c c1 = (c)view.getLayoutParams();
                if (c1.a)
                {
                    int k2 = view.getMeasuredWidth();
                    j2 = k2;
                    if (a(i2))
                    {
                        j2 = k2 + j4;
                    }
                    int k4 = view.getMeasuredHeight();
                    int j3;
                    int l4;
                    if (flag)
                    {
                        k2 = getPaddingLeft();
                        k2 = c1.leftMargin + k2;
                        j3 = k2 + j2;
                    } else
                    {
                        j3 = getWidth() - getPaddingRight() - c1.rightMargin;
                        k2 = j3 - j2;
                    }
                    l4 = l3 - k4 / 2;
                    view.layout(k2, l4, j3, k4 + l4);
                    k2 = l1 - j2;
                    j2 = 1;
                    l1 = j1;
                    j1 = k2;
                } else
                {
                    int l2 = view.getMeasuredWidth();
                    int k3 = c1.leftMargin;
                    l1 -= c1.rightMargin + (l2 + k3);
                    a(i2);
                    l2 = j1 + 1;
                    j1 = l1;
                    l1 = l2;
                }
            } else
            {
                int i3 = j1;
                j1 = l1;
                l1 = i3;
            }
            k2 = i2 + 1;
            i2 = l1;
            l1 = j1;
            j1 = i2;
            i2 = k2;
        }
        if (i4 == 1 && j2 == 0)
        {
            view = getChildAt(0);
            j1 = view.getMeasuredWidth();
            l1 = view.getMeasuredHeight();
            i1 = (k1 - i1) / 2 - j1 / 2;
            k1 = l3 - l1 / 2;
            view.layout(i1, k1, j1 + i1, l1 + k1);
            return;
        }
        if (j2 != 0)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        i1 = j1 - i1;
        if (i1 > 0)
        {
            i1 = l1 / i1;
        } else
        {
            i1 = 0;
        }
        k1 = Math.max(0, i1);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = getWidth() - getPaddingRight();
        j1 = 0;
        while (j1 < i4) 
        {
            view = getChildAt(j1);
            c2 = (c)view.getLayoutParams();
            if (view.getVisibility() != 8 && !c2.a)
            {
                i1 -= c2.rightMargin;
                l1 = view.getMeasuredWidth();
                i2 = view.getMeasuredHeight();
                j2 = l3 - i2 / 2;
                view.layout(i1 - l1, j2, i1, i2 + j2);
                i1 -= c2.leftMargin + l1 + k1;
            }
            j1++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i1 = getPaddingLeft();
        j1 = 0;
        while (j1 < i4) 
        {
            view = getChildAt(j1);
            c2 = (c)view.getLayoutParams();
            if (view.getVisibility() != 8 && !c2.a)
            {
                i1 += c2.leftMargin;
                l1 = view.getMeasuredWidth();
                i2 = view.getMeasuredHeight();
                j2 = l3 - i2 / 2;
                view.layout(i1, j2, i1 + l1, i2 + j2);
                i1 = c2.rightMargin + l1 + k1 + i1;
            }
            j1++;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected void onMeasure(int i1, int j1)
    {
        int i2;
        boolean flag2 = i;
        int k1;
        boolean flag;
        if (android.view.View.MeasureSpec.getMode(i1) == 0x40000000)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = flag;
        if (flag2 != i)
        {
            j = 0;
        }
        k1 = android.view.View.MeasureSpec.getSize(i1);
        if (i && a != null && k1 != j)
        {
            j = k1;
            a.b(true);
        }
        i2 = getChildCount();
        if (!i || i2 <= 0) goto _L2; else goto _L1
_L1:
        int k4 = android.view.View.MeasureSpec.getMode(j1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        int j4 = android.view.View.MeasureSpec.getSize(j1);
        k1 = getPaddingLeft();
        i2 = getPaddingRight();
        int l3 = getPaddingTop() + getPaddingBottom();
        int l4 = getChildMeasureSpec(j1, l3, -2);
        int i5 = i1 - (k1 + i2);
        i1 = i5 / k;
        j1 = k;
        if (i1 == 0)
        {
            setMeasuredDimension(i5, 0);
            return;
        }
        int j5 = k + (i5 % j1) / i1;
        j1 = 0;
        int l2 = 0;
        int k2 = 0;
        int i3 = 0;
        int j2 = 0;
        long l5 = 0L;
        int k5 = getChildCount();
        int j3 = 0;
        while (j3 < k5) 
        {
            Object obj = getChildAt(j3);
            int l1;
            if (((View) (obj)).getVisibility() != 8)
            {
                boolean flag1 = obj instanceof ActionMenuItemView;
                i3++;
                if (flag1)
                {
                    ((View) (obj)).setPadding(l, 0, l, 0);
                }
                c c1 = (c)((View) (obj)).getLayoutParams();
                c1.f = false;
                c1.c = 0;
                c1.b = 0;
                c1.d = false;
                c1.leftMargin = 0;
                c1.rightMargin = 0;
                int k3;
                if (flag1 && ((ActionMenuItemView)obj).b())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                c1.e = flag1;
                if (c1.a)
                {
                    l1 = 1;
                } else
                {
                    l1 = i1;
                }
                k3 = a(((View) (obj)), j5, l1, l4, l3);
                l2 = Math.max(l2, k3);
                float f1;
                float f2;
                float f3;
                int i4;
                long l7;
                long l8;
                if (c1.d)
                {
                    l1 = k2 + 1;
                } else
                {
                    l1 = k2;
                }
                if (c1.a)
                {
                    i2 = 1;
                } else
                {
                    i2 = j2;
                }
                i1 -= k3;
                k2 = Math.max(j1, ((View) (obj)).getMeasuredHeight());
                if (k3 == 1)
                {
                    long l6 = 1 << j3;
                    j1 = k2;
                    j2 = i1;
                    k2 = l1;
                    k3 = i2;
                    l5 = l6 | l5;
                    i1 = i3;
                    i2 = j2;
                    l1 = j1;
                    j2 = k3;
                    j1 = l2;
                } else
                {
                    j1 = i3;
                    j2 = l2;
                    l2 = k2;
                    i3 = i1;
                    i1 = j1;
                    j1 = j2;
                    k2 = l1;
                    j2 = i2;
                    l1 = l2;
                    i2 = i3;
                }
            } else
            {
                l1 = j1;
                i2 = i1;
                j1 = l2;
                i1 = i3;
            }
            j3++;
            i3 = i1;
            i1 = i2;
            l2 = j1;
            j1 = l1;
        }
        if (j2 != 0 && i3 == 2)
        {
            k3 = 1;
        } else
        {
            k3 = 0;
        }
        l1 = 0;
        j3 = i1;
        i1 = l1;
        l8 = l5;
        if (k2 <= 0) goto _L4; else goto _L3
_L3:
        l8 = l5;
        if (j3 <= 0) goto _L4; else goto _L5
_L5:
        l1 = 0x7fffffff;
        l7 = 0L;
        i2 = 0;
        l3 = 0;
_L12:
        if (l3 >= k5) goto _L7; else goto _L6
_L6:
        obj = (c)getChildAt(l3).getLayoutParams();
        if (!((c) (obj)).d) goto _L9; else goto _L8
_L8:
        if (((c) (obj)).b >= l1) goto _L11; else goto _L10
_L10:
        i2 = ((c) (obj)).b;
        l7 = 1 << l3;
        l1 = 1;
_L14:
        i4 = l3 + 1;
        l3 = i2;
        i2 = l1;
        l1 = l3;
        l3 = i4;
          goto _L12
_L11:
        if (((c) (obj)).b != l1) goto _L9; else goto _L13
_L13:
        l7 |= 1 << l3;
        i4 = i2 + 1;
        i2 = l1;
        l1 = i4;
          goto _L14
_L7:
        l5 |= l7;
        l8 = l5;
        if (i2 <= j3)
        {
            i2 = 0;
            i1 = j3;
            while (i2 < k5) 
            {
                obj = getChildAt(i2);
                c1 = (c)((View) (obj)).getLayoutParams();
                if (((long)(1 << i2) & l7) == 0L)
                {
                    if (c1.b == l1 + 1)
                    {
                        l5 |= 1 << i2;
                    }
                } else
                {
                    if (k3 && c1.e && i1 == 1)
                    {
                        ((View) (obj)).setPadding(l + j5, 0, l, 0);
                    }
                    c1.b = c1.b + 1;
                    c1.f = true;
                    i1--;
                }
                i2++;
            }
            l1 = 1;
            j3 = i1;
            i1 = l1;
            break MISSING_BLOCK_LABEL_541;
        }
_L4:
        if (j2 == 0 && i3 == 1)
        {
            l1 = 1;
        } else
        {
            l1 = 0;
        }
        if (j3 <= 0 || l8 == 0L || j3 >= i3 - 1 && l1 == 0 && l2 <= 1) goto _L16; else goto _L15
_L15:
        f3 = Long.bitCount(l8);
        f2 = f3;
        if (l1 != 0) goto _L18; else goto _L17
_L17:
        f1 = f3;
        if ((1L & l8) != 0L)
        {
            f1 = f3;
            if (!((c)getChildAt(0).getLayoutParams()).e)
            {
                f1 = f3 - 0.5F;
            }
        }
        f2 = f1;
        if (((long)(1 << k5 - 1) & l8) == 0L) goto _L18; else goto _L19
_L19:
        f2 = f1;
        if (((c)getChildAt(k5 - 1).getLayoutParams()).e) goto _L18; else goto _L20
_L20:
        f1 -= 0.5F;
_L22:
        if (f1 > 0.0F)
        {
            l1 = (int)((float)(j3 * j5) / f1);
        } else
        {
            l1 = 0;
        }
        i2 = 0;
        do
        {
            j2 = i1;
            if (i2 >= k5)
            {
                break;
            }
            if (((long)(1 << i2) & l8) != 0L)
            {
                obj = getChildAt(i2);
                c1 = (c)((View) (obj)).getLayoutParams();
                if (obj instanceof ActionMenuItemView)
                {
                    c1.c = l1;
                    c1.f = true;
                    if (i2 == 0 && !c1.e)
                    {
                        c1.leftMargin = -l1 / 2;
                    }
                    i1 = 1;
                } else
                if (c1.a)
                {
                    c1.c = l1;
                    c1.f = true;
                    c1.rightMargin = -l1 / 2;
                    i1 = 1;
                } else
                {
                    if (i2 != 0)
                    {
                        c1.leftMargin = l1 / 2;
                    }
                    if (i2 != k5 - 1)
                    {
                        c1.rightMargin = l1 / 2;
                    }
                }
            }
            i2++;
        } while (true);
          goto _L21
_L16:
        j2 = i1;
_L21:
        if (j2 != 0)
        {
            for (i1 = 0; i1 < k5; i1++)
            {
                obj = getChildAt(i1);
                c1 = (c)((View) (obj)).getLayoutParams();
                if (c1.f)
                {
                    l1 = c1.b;
                    ((View) (obj)).measure(android.view.View.MeasureSpec.makeMeasureSpec(c1.c + l1 * j5, 0x40000000), l4);
                }
            }

        }
        if (k4 == 0x40000000)
        {
            j1 = j4;
        }
        setMeasuredDimension(i5, j1);
        return;
_L2:
        for (l1 = 0; l1 < i2; l1++)
        {
            obj = (c)getChildAt(l1).getLayoutParams();
            obj.rightMargin = 0;
            obj.leftMargin = 0;
        }

        super.onMeasure(i1, j1);
        return;
_L18:
        f1 = f2;
        if (true) goto _L22; else goto _L9
_L9:
        i4 = l1;
        l1 = i2;
        i2 = i4;
          goto _L14
    }

    public void setExpandedActionViewsExclusive(boolean flag)
    {
        c.l = flag;
    }

    public void setOnMenuItemClickListener(e e1)
    {
        m = e1;
    }

    public void setOverflowReserved(boolean flag)
    {
        b = flag;
    }

    public void setPopupTheme(int i1)
    {
label0:
        {
            if (h != i1)
            {
                h = i1;
                if (i1 != 0)
                {
                    break label0;
                }
                g = f;
            }
            return;
        }
        g = new ContextThemeWrapper(f, i1);
    }

    public void setPresenter(android.support.v7.widget.a a1)
    {
        c = a1;
        c.a(this);
    }
}
