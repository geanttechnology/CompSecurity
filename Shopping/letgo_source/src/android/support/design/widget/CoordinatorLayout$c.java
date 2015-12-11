// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout

public static class i extends android.view.utParams
{

    m a;
    boolean b;
    public int c;
    public int d;
    public int e;
    int f;
    View g;
    View h;
    final Rect i;
    Object j;
    private boolean k;
    private boolean l;
    private boolean m;

    private void a(View view, CoordinatorLayout coordinatorlayout)
    {
        g = coordinatorlayout.findViewById(f);
        if (g != null)
        {
            View view1 = g;
            for (ViewParent viewparent = g.getParent(); viewparent != coordinatorlayout && viewparent != null; viewparent = viewparent.getParent())
            {
                if (viewparent == view)
                {
                    if (coordinatorlayout.isInEditMode())
                    {
                        h = null;
                        g = null;
                        return;
                    } else
                    {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                }
                if (viewparent instanceof View)
                {
                    view1 = (View)viewparent;
                }
            }

            h = view1;
            return;
        }
        if (coordinatorlayout.isInEditMode())
        {
            h = null;
            g = null;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not find CoordinatorLayout descendant view with id ").append(coordinatorlayout.getResources().getResourceName(f)).append(" to anchor view ").append(view).toString());
        }
    }

    private boolean b(View view, CoordinatorLayout coordinatorlayout)
    {
        if (g.getId() != f)
        {
            return false;
        }
        View view1 = g;
        for (ViewParent viewparent = g.getParent(); viewparent != coordinatorlayout; viewparent = viewparent.getParent())
        {
            if (viewparent == null || viewparent == view)
            {
                h = null;
                g = null;
                return false;
            }
            if (viewparent instanceof View)
            {
                view1 = (View)viewparent;
            }
        }

        h = view1;
        return true;
    }

    public h a()
    {
        return a;
    }

    void a(Rect rect)
    {
        i.set(rect);
    }

    public void a(i i1)
    {
        if (a != i1)
        {
            a = i1;
            j = null;
            b = true;
        }
    }

    void a(boolean flag)
    {
        l = flag;
    }

    boolean a(CoordinatorLayout coordinatorlayout, View view)
    {
        if (k)
        {
            return true;
        }
        boolean flag1 = k;
        boolean flag;
        if (a != null)
        {
            flag = a.d(coordinatorlayout, view);
        } else
        {
            flag = false;
        }
        flag |= flag1;
        k = flag;
        return flag;
    }

    boolean a(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        return view1 == h || a != null && a.b(coordinatorlayout, view, view1);
    }

    Rect b()
    {
        return i;
    }

    View b(CoordinatorLayout coordinatorlayout, View view)
    {
        if (f == -1)
        {
            h = null;
            g = null;
            return null;
        }
        if (g == null || !b(view, coordinatorlayout))
        {
            a(view, coordinatorlayout);
        }
        return g;
    }

    void b(boolean flag)
    {
        m = flag;
    }

    boolean c()
    {
        return g == null && f != -1;
    }

    boolean c(CoordinatorLayout coordinatorlayout, View view)
    {
        return a != null && a.e(coordinatorlayout, view);
    }

    boolean d()
    {
        if (a == null)
        {
            k = false;
        }
        return k;
    }

    void e()
    {
        k = false;
    }

    void f()
    {
        l = false;
    }

    boolean g()
    {
        return l;
    }

    boolean h()
    {
        return m;
    }

    void i()
    {
        m = false;
    }

    public (int i1, int j1)
    {
        super(i1, j1);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    i(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, android.support.v7.t_LayoutParams);
        c = typedarray.getInteger(android.support.v7.t_LayoutParams_android_layout_gravity, 0);
        f = typedarray.getResourceId(android.support.v7.t_LayoutParams_layout_anchor, -1);
        d = typedarray.getInteger(android.support.v7.t_LayoutParams_layout_anchorGravity, 0);
        e = typedarray.getInteger(android.support.v7.t_LayoutParams_layout_keyline, -1);
        b = typedarray.hasValue(android.support.v7.t_LayoutParams_layout_behavior);
        if (b)
        {
            a = CoordinatorLayout.a(context, attributeset, typedarray.getString(android.support.v7.t_LayoutParams_layout_behavior));
        }
        typedarray.recycle();
    }

    public ams_layout_behavior(ams_layout_behavior ams_layout_behavior)
    {
        super(ams_layout_behavior);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    public i(android.view.ms ms)
    {
        super(ms);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    public i(android.view.utParams utparams)
    {
        super(utparams);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }
}
