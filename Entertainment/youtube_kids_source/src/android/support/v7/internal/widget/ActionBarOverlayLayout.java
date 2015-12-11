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
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import dz;
import ep;
import fa;
import fr;
import hg;
import hh;
import hi;
import hj;
import hk;
import hs;
import ic;
import ie;

// Referenced classes of package android.support.v7.internal.widget:
//            ContentFrameLayout, ActionBarContainer

public class ActionBarOverlayLayout extends ViewGroup
{

    private static int x[] = {
        0x7f010093, 0x1010059
    };
    private int a;
    private ContentFrameLayout b;
    private ActionBarContainer c;
    private ActionBarContainer d;
    private hs e;
    private Drawable f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private final Rect k;
    private final Rect l;
    private final Rect m;
    private final Rect n;
    private final Rect o;
    private final Rect p;
    private fr q;
    private ep r;
    private ep s;
    private final fa t;
    private final fa u;
    private final Runnable v;
    private final Runnable w;

    public ActionBarOverlayLayout(Context context)
    {
        super(context);
        k = new Rect();
        l = new Rect();
        m = new Rect();
        n = new Rect();
        o = new Rect();
        p = new Rect();
        t = new hg(this);
        u = new hh(this);
        v = new hi(this);
        w = new hj(this);
        a(context);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        k = new Rect();
        l = new Rect();
        m = new Rect();
        n = new Rect();
        o = new Rect();
        p = new Rect();
        t = new hg(this);
        u = new hh(this);
        v = new hi(this);
        w = new hj(this);
        a(context);
    }

    public static ep a(ActionBarOverlayLayout actionbaroverlaylayout, ep ep1)
    {
        actionbaroverlaylayout.r = ep1;
        return ep1;
    }

    private void a()
    {
        if (b == null)
        {
            b = (ContentFrameLayout)findViewById(0x7f10000c);
            d = (ActionBarContainer)findViewById(0x7f10007b);
            Object obj = findViewById(0x7f10007c);
            if (obj instanceof hs)
            {
                obj = (hs)obj;
            } else
            if (obj instanceof Toolbar)
            {
                obj = (Toolbar)obj;
                if (((Toolbar) (obj)).k == null)
                {
                    obj.k = new ic(((Toolbar) (obj)), true);
                }
                obj = ((Toolbar) (obj)).k;
            } else
            {
                throw new IllegalStateException((new StringBuilder("Can't make a decor toolbar out of ")).append(obj.getClass().getSimpleName()).toString());
            }
            e = ((hs) (obj));
            c = (ActionBarContainer)findViewById(0x7f10000d);
        }
    }

    private void a(Context context)
    {
        boolean flag1 = true;
        TypedArray typedarray = getContext().getTheme().obtainStyledAttributes(x);
        a = typedarray.getDimensionPixelSize(0, 0);
        f = typedarray.getDrawable(1);
        boolean flag;
        if (f == null)
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
        g = flag;
        q = new fr(context, null);
    }

    public static void a(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        actionbaroverlaylayout.b();
    }

    public static boolean a(ActionBarOverlayLayout actionbaroverlaylayout, boolean flag)
    {
        actionbaroverlaylayout.h = false;
        return false;
    }

    private static boolean a(View view, Rect rect, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        flag = false;
        view = (hk)view.getLayoutParams();
        if (((hk) (view)).leftMargin != rect.left)
        {
            view.leftMargin = rect.left;
            flag = true;
        }
        flag3 = flag;
        if (flag1)
        {
            flag3 = flag;
            if (((hk) (view)).topMargin != rect.top)
            {
                view.topMargin = rect.top;
                flag3 = true;
            }
        }
        if (((hk) (view)).rightMargin != rect.right)
        {
            view.rightMargin = rect.right;
            flag3 = true;
        }
        if (flag2 && ((hk) (view)).bottomMargin != rect.bottom)
        {
            view.bottomMargin = rect.bottom;
            return true;
        } else
        {
            return flag3;
        }
    }

    public static ep b(ActionBarOverlayLayout actionbaroverlaylayout, ep ep1)
    {
        actionbaroverlaylayout.s = ep1;
        return ep1;
    }

    public static fa b(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.t;
    }

    private void b()
    {
        removeCallbacks(v);
        removeCallbacks(w);
        if (r != null)
        {
            r.a();
        }
        if (s != null)
        {
            s.a();
        }
    }

    public static ActionBarContainer c(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.d;
    }

    public static ActionBarContainer d(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.c;
    }

    public static fa e(ActionBarOverlayLayout actionbaroverlaylayout)
    {
        return actionbaroverlaylayout.u;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return layoutparams instanceof hk;
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (f != null && !g)
        {
            int i1;
            if (d.getVisibility() == 0)
            {
                i1 = (int)((float)d.getBottom() + dz.c(d) + 0.5F);
            } else
            {
                i1 = 0;
            }
            f.setBounds(0, i1, getWidth(), f.getIntrinsicHeight() + i1);
            f.draw(canvas);
        }
    }

    protected boolean fitSystemWindows(Rect rect)
    {
        a();
        dz.f(this);
        boolean flag1 = a(d, rect, true, true, false, true);
        boolean flag = flag1;
        if (c != null)
        {
            flag = flag1 | a(c, rect, true, false, true, true);
        }
        n.set(rect);
        ie.a(this, n, k);
        if (!l.equals(k))
        {
            l.set(k);
            flag = true;
        }
        if (flag)
        {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new hk(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new hk(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return new hk(layoutparams);
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            super.onConfigurationChanged(configuration);
        }
        a(getContext());
        dz.g(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        b();
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
                hk hk1 = (hk)view.getLayoutParams();
                int i3 = view.getMeasuredWidth();
                int j3 = view.getMeasuredHeight();
                int k3 = hk1.leftMargin + j2;
                if (view == c)
                {
                    k1 = l1 - j1 - l2 - j3 - hk1.bottomMargin;
                } else
                {
                    k1 = hk1.topMargin + k2;
                }
                view.layout(k3, k1, i3 + k3, j3 + k1);
            }
            i1++;
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        a();
        measureChildWithMargins(d, i1, 0, j1, 0);
        Object obj = (hk)d.getLayoutParams();
        int j2 = Math.max(0, d.getMeasuredWidth() + ((hk) (obj)).leftMargin + ((hk) (obj)).rightMargin);
        int k1 = d.getMeasuredHeight();
        int l1 = ((hk) (obj)).topMargin;
        int i2 = Math.max(0, ((hk) (obj)).bottomMargin + (k1 + l1));
        l1 = ie.a(0, dz.b(d));
        if (c != null)
        {
            measureChildWithMargins(c, i1, 0, j1, 0);
            obj = (hk)c.getLayoutParams();
            j2 = Math.max(j2, c.getMeasuredWidth() + ((hk) (obj)).leftMargin + ((hk) (obj)).rightMargin);
            k1 = c.getMeasuredHeight();
            int k2 = ((hk) (obj)).topMargin;
            i2 = Math.max(i2, ((hk) (obj)).bottomMargin + (k1 + k2));
            l1 = ie.a(l1, dz.b(c));
        }
        int l2;
        if ((dz.f(this) & 0x100) != 0)
        {
            l2 = 1;
        } else
        {
            l2 = 0;
        }
        if (l2 != 0)
        {
            k1 = a;
        } else
        if (d.getVisibility() != 8)
        {
            k1 = d.getMeasuredHeight();
        } else
        {
            k1 = 0;
        }
        obj = e;
        m.set(k);
        o.set(n);
        if (l2 == 0)
        {
            obj = m;
            obj.top = k1 + ((Rect) (obj)).top;
            obj = m;
            obj.bottom = ((Rect) (obj)).bottom;
        } else
        {
            Rect rect = o;
            rect.top = k1 + rect.top;
            rect = o;
            rect.bottom = rect.bottom;
        }
        a(b, m, true, true, true, true);
        if (!p.equals(o))
        {
            p.set(o);
            b.a(o);
        }
        measureChildWithMargins(b, i1, 0, j1, 0);
        obj = (hk)b.getLayoutParams();
        k1 = Math.max(j2, b.getMeasuredWidth() + ((hk) (obj)).leftMargin + ((hk) (obj)).rightMargin);
        j2 = b.getMeasuredHeight();
        l2 = ((hk) (obj)).topMargin;
        i2 = Math.max(i2, ((hk) (obj)).bottomMargin + (j2 + l2));
        l1 = ie.a(l1, dz.b(b));
        j2 = getPaddingLeft();
        l2 = getPaddingRight();
        i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(dz.a(Math.max(k1 + (j2 + l2), getSuggestedMinimumWidth()), i1, l1), dz.a(i2, j1, l1 << 16));
    }

    public boolean onNestedFling(View view, float f1, float f2, boolean flag)
    {
        return false;
    }

    public void onNestedScroll(View view, int i1, int j1, int k1, int l1)
    {
        i = i + j1;
        j1 = i;
        b();
        i1 = d.getHeight();
        j1 = Math.max(0, Math.min(j1, i1));
        dz.a(d, -j1);
        if (c != null && c.getVisibility() != 8)
        {
            i1 = (int)(((float)j1 / (float)i1) * (float)c.getHeight());
            dz.a(c, i1);
        }
    }

    public void onNestedScrollAccepted(View view, View view1, int i1)
    {
        super.onNestedScrollAccepted(view, view1, i1);
        if (d != null)
        {
            i1 = -(int)dz.c(d);
        } else
        {
            i1 = 0;
        }
        i = i1;
        b();
    }

    public boolean onStartNestedScroll(View view, View view1, int i1)
    {
        if ((i1 & 2) != 0)
        {
            if (d.getVisibility() == 0);
        }
        return false;
    }

    public void onStopNestedScroll(View view)
    {
        super.onStopNestedScroll(view);
    }

    public void onWindowSystemUiVisibilityChanged(int i1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            super.onWindowSystemUiVisibilityChanged(i1);
        }
        a();
        int j1 = j;
        j = i1;
    }

    protected void onWindowVisibilityChanged(int i1)
    {
        super.onWindowVisibilityChanged(i1);
    }

    public boolean shouldDelayChildPressedState()
    {
        return false;
    }

}
