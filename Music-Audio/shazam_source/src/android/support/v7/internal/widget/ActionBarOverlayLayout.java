// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v4.view.ai;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.w;
import android.support.v4.widget.k;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v7.internal.widget:
//            g, ContentFrameLayout, ActionBarContainer, h, 
//            t

public class ActionBarOverlayLayout extends ViewGroup
    implements q, g
{
    public static interface a
    {

        public abstract void a(int i1);

        public abstract void f(boolean flag);

        public abstract void i();

        public abstract void j();

        public abstract void k();
    }

    public static final class b extends android.view.ViewGroup.MarginLayoutParams
    {

        public b()
        {
            super(-1, -1);
        }

        public b(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
        }

        public b(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }
    }


    static final int b[];
    private final ah A;
    private final ah B;
    private final Runnable C;
    private final Runnable D;
    private final r E;
    public boolean a;
    private int c;
    private int d;
    private ContentFrameLayout e;
    private ActionBarContainer f;
    private ActionBarContainer g;
    private h h;
    private Drawable i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private final Rect p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private a v;
    private final int w;
    private k x;
    private ad y;
    private ad z;

    public ActionBarOverlayLayout(Context context)
    {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d = 0;
        p = new Rect();
        q = new Rect();
        r = new Rect();
        s = new Rect();
        t = new Rect();
        u = new Rect();
        w = 600;
        A = new ai() {

            final ActionBarOverlayLayout a;

            public final void b(View view)
            {
                ActionBarOverlayLayout.a(a, null);
                ActionBarOverlayLayout.a(a);
            }

            public final void c(View view)
            {
                ActionBarOverlayLayout.a(a, null);
                ActionBarOverlayLayout.a(a);
            }

            
            {
                a = ActionBarOverlayLayout.this;
                super();
            }
        };
        B = new ai() {

            final ActionBarOverlayLayout a;

            public final void b(View view)
            {
                ActionBarOverlayLayout.b(a, null);
                ActionBarOverlayLayout.a(a);
            }

            public final void c(View view)
            {
                ActionBarOverlayLayout.b(a, null);
                ActionBarOverlayLayout.a(a);
            }

            
            {
                a = ActionBarOverlayLayout.this;
                super();
            }
        };
        C = new Runnable() {

            final ActionBarOverlayLayout a;

            public final void run()
            {
                ActionBarOverlayLayout.b(a);
                ActionBarOverlayLayout.a(a, android.support.v4.view.w.n(ActionBarOverlayLayout.d(a)).c(0.0F).a(ActionBarOverlayLayout.c(a)));
                if (ActionBarOverlayLayout.e(a) != null && ActionBarOverlayLayout.e(a).getVisibility() != 8)
                {
                    ActionBarOverlayLayout.b(a, android.support.v4.view.w.n(ActionBarOverlayLayout.e(a)).c(0.0F).a(ActionBarOverlayLayout.f(a)));
                }
            }

            
            {
                a = ActionBarOverlayLayout.this;
                super();
            }
        };
        D = new Runnable() {

            final ActionBarOverlayLayout a;

            public final void run()
            {
                ActionBarOverlayLayout.b(a);
                ActionBarOverlayLayout.a(a, android.support.v4.view.w.n(ActionBarOverlayLayout.d(a)).c(-ActionBarOverlayLayout.d(a).getHeight()).a(ActionBarOverlayLayout.c(a)));
                if (ActionBarOverlayLayout.e(a) != null && ActionBarOverlayLayout.e(a).getVisibility() != 8)
                {
                    ActionBarOverlayLayout.b(a, android.support.v4.view.w.n(ActionBarOverlayLayout.e(a)).c(ActionBarOverlayLayout.e(a).getHeight()).a(ActionBarOverlayLayout.f(a)));
                }
            }

            
            {
                a = ActionBarOverlayLayout.this;
                super();
            }
        };
        a(context);
        E = new r(this);
    }

    static ad a(ActionBarOverlayLayout actionbaroverlaylayout, ad ad1)
    {
        actionbaroverlaylayout.y = ad1;
        return ad1;
    }

    private void a(Context context)
    {
        boolean flag1 = true;
        TypedArray typedarray = getContext().getTheme().obtainStyledAttributes(b);
        c = typedarray.getDimensionPixelSize(0, 0);
        i = typedarray.getDrawable(1);
        boolean flag;
        if (i == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        typedarray.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        j = flag;
        x = android.support.v4.widget.k.a(context, null);
    }

    static boolean a(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        actionbaroverlaylayout.m = false;
        return false;
    }

    private static boolean a(View view, Rect rect, boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        view = (b)view.getLayoutParams();
        if (((b) (view)).leftMargin != rect.left)
        {
            view.leftMargin = rect.left;
            flag2 = true;
        }
        boolean flag3 = flag2;
        if (flag)
        {
            flag3 = flag2;
            if (((b) (view)).topMargin != rect.top)
            {
                view.topMargin = rect.top;
                flag3 = true;
            }
        }
        if (((b) (view)).rightMargin != rect.right)
        {
            view.rightMargin = rect.right;
            flag3 = true;
        }
        if (flag1 && ((b) (view)).bottomMargin != rect.bottom)
        {
            view.bottomMargin = rect.bottom;
            return true;
        } else
        {
            return flag3;
        }
    }

    static ad b(ActionBarOverlayLayout actionbaroverlaylayout, ad ad1)
    {
        actionbaroverlaylayout.z = ad1;
        return ad1;
    }

    static void b(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        actionbaroverlaylayout.i();
    }

    static ah c(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.A;
    }

    static ActionBarContainer d(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.g;
    }

    static ActionBarContainer e(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.f;
    }

    static ah f(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.B;
    }

    private void h()
    {
        if (e == null)
        {
            e = (ContentFrameLayout)findViewById(android.support.v7.b.a.f.action_bar_activity_content);
            g = (ActionBarContainer)findViewById(android.support.v7.b.a.f.action_bar_container);
            Object obj = findViewById(android.support.v7.b.a.f.action_bar);
            if (obj instanceof h)
            {
                obj = (h)obj;
            } else
            if (obj instanceof Toolbar)
            {
                obj = ((Toolbar)obj).getWrapper();
            } else
            {
                throw new IllegalStateException((new StringBuilder("Can't make a decor toolbar out of ")).append(obj.getClass().getSimpleName()).toString());
            }
            h = ((h) (obj));
            f = (ActionBarContainer)findViewById(android.support.v7.b.a.f.split_action_bar);
        }
    }

    private void i()
    {
        removeCallbacks(C);
        removeCallbacks(D);
        if (y != null)
        {
            y.a();
        }
        if (z != null)
        {
            z.a();
        }
    }

    public final void a(int i1)
    {
        h();
        switch (i1)
        {
        case 2: // '\002'
        case 5: // '\005'
        default:
            return;

        case 9: // '\t'
            setOverlayMode(true);
            break;
        }
    }

    public final void a(Menu menu, android.support.v7.internal.view.menu.l.a a1)
    {
        h();
        h.a(menu, a1);
    }

    public final boolean a()
    {
        h();
        return h.f();
    }

    public final boolean b()
    {
        h();
        return h.g();
    }

    public final boolean c()
    {
        h();
        return h.h();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof b;
    }

    public final boolean d()
    {
        h();
        return h.i();
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (i != null && !j)
        {
            int i1;
            if (g.getVisibility() == 0)
            {
                i1 = (int)((float)g.getBottom() + android.support.v4.view.w.k(g) + 0.5F);
            } else
            {
                i1 = 0;
            }
            i.setBounds(0, i1, getWidth(), i.getIntrinsicHeight() + i1);
            i.draw(canvas);
        }
    }

    public final boolean e()
    {
        h();
        return h.j();
    }

    public final void f()
    {
        h();
        h.k();
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        h();
        android.support.v4.view.w.p(this);
        boolean flag1 = a(g, rect, true, false);
        boolean flag = flag1;
        if (f != null)
        {
            flag = flag1 | a(f, rect, false, true);
        }
        s.set(rect);
        android.support.v7.internal.widget.t.a(this, s, p);
        if (!q.equals(p))
        {
            q.set(p);
            flag = true;
        }
        if (flag)
        {
            requestLayout();
        }
        return true;
    }

    public final void g()
    {
        h();
        h.l();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new b();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new b(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new b(layoutparams);
    }

    public int getActionBarHideOffset()
    {
        if (g != null)
        {
            return -(int)android.support.v4.view.w.k(g);
        } else
        {
            return 0;
        }
    }

    public int getNestedScrollAxes()
    {
        return E.a;
    }

    public CharSequence getTitle()
    {
        h();
        return h.e();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        android.support.v4.view.w.q(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        i();
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        int i2 = getChildCount();
        int j2 = getPaddingLeft();
        getPaddingRight();
        int k2 = getPaddingTop();
        int l2 = getPaddingBottom();
        i1 = 0;
        while (i1 < i2) 
        {
            View view = getChildAt(i1);
            if (view.getVisibility() != 8)
            {
                b b1 = (b)view.getLayoutParams();
                int i3 = view.getMeasuredWidth();
                int j3 = view.getMeasuredHeight();
                int k3 = b1.leftMargin + j2;
                if (view == f)
                {
                    k1 = l1 - j1 - l2 - j3 - b1.bottomMargin;
                } else
                {
                    k1 = b1.topMargin + k2;
                }
                view.layout(k3, k1, i3 + k3, j3 + k1);
            }
            i1++;
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        h();
        measureChildWithMargins(g, i1, 0, j1, 0);
        Object obj = (b)g.getLayoutParams();
        int l2 = Math.max(0, g.getMeasuredWidth() + ((b) (obj)).leftMargin + ((b) (obj)).rightMargin);
        int k1 = g.getMeasuredHeight();
        int l1 = ((b) (obj)).topMargin;
        int k2 = Math.max(0, ((b) (obj)).bottomMargin + (k1 + l1));
        k1 = android.support.v7.internal.widget.t.a(0, android.support.v4.view.w.i(g));
        int i2 = k1;
        int j2 = l2;
        l1 = k2;
        if (f != null)
        {
            measureChildWithMargins(f, i1, 0, j1, 0);
            obj = (b)f.getLayoutParams();
            j2 = Math.max(l2, f.getMeasuredWidth() + ((b) (obj)).leftMargin + ((b) (obj)).rightMargin);
            l1 = f.getMeasuredHeight();
            i2 = ((b) (obj)).topMargin;
            l1 = Math.max(k2, ((b) (obj)).bottomMargin + (l1 + i2));
            i2 = android.support.v7.internal.widget.t.a(k1, android.support.v4.view.w.i(f));
        }
        if ((android.support.v4.view.w.p(this) & 0x100) != 0)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (k2 != 0)
        {
            int i3 = c;
            k1 = i3;
            if (k)
            {
                k1 = i3;
                if (g.getTabContainer() != null)
                {
                    k1 = i3 + c;
                }
            }
        } else
        if (g.getVisibility() != 8)
        {
            k1 = g.getMeasuredHeight();
        } else
        {
            k1 = 0;
        }
        r.set(p);
        t.set(s);
        if (!a && k2 == 0)
        {
            obj = r;
            obj.top = k1 + ((Rect) (obj)).top;
            obj = r;
            obj.bottom = ((Rect) (obj)).bottom + 0;
        } else
        {
            Rect rect = t;
            rect.top = k1 + rect.top;
            rect = t;
            rect.bottom = rect.bottom + 0;
        }
        a(e, r, true, true);
        if (!u.equals(t))
        {
            u.set(t);
            e.a(t);
        }
        measureChildWithMargins(e, i1, 0, j1, 0);
        obj = (b)e.getLayoutParams();
        k1 = Math.max(j2, e.getMeasuredWidth() + ((b) (obj)).leftMargin + ((b) (obj)).rightMargin);
        j2 = e.getMeasuredHeight();
        k2 = ((b) (obj)).topMargin;
        l1 = Math.max(l1, ((b) (obj)).bottomMargin + (j2 + k2));
        i2 = android.support.v7.internal.widget.t.a(i2, android.support.v4.view.w.i(e));
        j2 = getPaddingLeft();
        k2 = getPaddingRight();
        l1 = Math.max(l1 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(android.support.v4.view.w.a(Math.max(k1 + (j2 + k2), getSuggestedMinimumWidth()), i1, i2), android.support.v4.view.w.a(l1, j1, i2 << 16));
    }

    public boolean onNestedFling(View view, float f1, float f2, boolean flag)
    {
        boolean flag1 = false;
        if (!l || !flag)
        {
            return false;
        }
        x.a(0, (int)f2, 0, 0);
        if (x.a() > g.getHeight())
        {
            flag1 = true;
        }
        if (flag1)
        {
            i();
            D.run();
        } else
        {
            i();
            C.run();
        }
        m = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f1, float f2)
    {
        return false;
    }

    public void onNestedPreScroll(View view, int i1, int j1, int ai[])
    {
    }

    public void onNestedScroll(View view, int i1, int j1, int k1, int l1)
    {
        n = n + j1;
        setActionBarHideOffset(n);
    }

    public void onNestedScrollAccepted(View view, View view1, int i1)
    {
        E.a = i1;
        n = getActionBarHideOffset();
        i();
        if (v != null)
        {
            v.k();
        }
    }

    public boolean onStartNestedScroll(View view, View view1, int i1)
    {
        if ((i1 & 2) == 0 || g.getVisibility() != 0)
        {
            return false;
        } else
        {
            return l;
        }
    }

    public void onStopNestedScroll(View view)
    {
label0:
        {
            if (l && !m)
            {
                if (n > g.getHeight())
                {
                    break label0;
                }
                i();
                postDelayed(C, 600L);
            }
            return;
        }
        i();
        postDelayed(D, 600L);
    }

    public void onWindowSystemUiVisibilityChanged(int i1)
    {
        boolean flag2 = true;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            super.onWindowSystemUiVisibilityChanged(i1);
        }
        h();
        int j1 = o;
        o = i1;
        boolean flag;
        boolean flag1;
        if ((i1 & 4) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i1 & 0x100) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (v != null)
        {
            a a1 = v;
            if (flag1)
            {
                flag2 = false;
            }
            a1.f(flag2);
            if (flag || !flag1)
            {
                v.i();
            } else
            {
                v.j();
            }
        }
        if (((j1 ^ i1) & 0x100) != 0 && v != null)
        {
            android.support.v4.view.w.q(this);
        }
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
        d = i1;
        if (v != null)
        {
            v.a(i1);
        }
    }

    public void setActionBarHideOffset(int i1)
    {
        i();
        int j1 = g.getHeight();
        i1 = Math.max(0, Math.min(i1, j1));
        android.support.v4.view.w.b(g, -i1);
        if (f != null && f.getVisibility() != 8)
        {
            i1 = (int)(((float)i1 / (float)j1) * (float)f.getHeight());
            android.support.v4.view.w.b(f, i1);
        }
    }

    public void setActionBarVisibilityCallback(a a1)
    {
        v = a1;
        if (getWindowToken() != null)
        {
            v.a(d);
            if (o != 0)
            {
                onWindowSystemUiVisibilityChanged(o);
                android.support.v4.view.w.q(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean flag)
    {
        k = flag;
    }

    public void setHideOnContentScrollEnabled(boolean flag)
    {
        if (flag != l)
        {
            l = flag;
            if (!flag)
            {
                i();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i1)
    {
        h();
        h.a(i1);
    }

    public void setIcon(Drawable drawable)
    {
        h();
        h.a(drawable);
    }

    public void setLogo(int i1)
    {
        h();
        h.b(i1);
    }

    public void setOverlayMode(boolean flag)
    {
        a = flag;
        if (flag && getContext().getApplicationInfo().targetSdkVersion < 19)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = flag;
    }

    public void setShowingForActionMode(boolean flag)
    {
    }

    public void setUiOptions(int i1)
    {
    }

    public void setWindowCallback(android.view.Window.Callback callback)
    {
        h();
        h.a(callback);
    }

    public void setWindowTitle(CharSequence charsequence)
    {
        h();
        h.a(charsequence);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

    static 
    {
        b = (new int[] {
            android.support.v7.b.a.a.actionBarSize, 0x1010059
        });
    }
}
