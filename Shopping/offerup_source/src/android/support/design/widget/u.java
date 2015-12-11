// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout, r

public final class u extends android.view.ViewGroup.MarginLayoutParams
{

    r a;
    boolean b;
    public int c;
    public int d;
    public int e;
    int f;
    View g;
    View h;
    final Rect i;
    private boolean j;
    private boolean k;
    private boolean l;

    public u(int i1, int j1)
    {
        super(-2, -2);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    u(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, a.A);
        c = typedarray.getInteger(a.B, 0);
        f = typedarray.getResourceId(a.C, -1);
        d = typedarray.getInteger(a.D, 0);
        e = typedarray.getInteger(a.F, -1);
        b = typedarray.hasValue(a.E);
        if (b)
        {
            a = android.support.design.widget.CoordinatorLayout.a(context, attributeset, typedarray.getString(a.E));
        }
        typedarray.recycle();
    }

    public u(u u1)
    {
        super(u1);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    public u(android.view.ViewGroup.LayoutParams layoutparams)
    {
        super(layoutparams);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    public u(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        super(marginlayoutparams);
        b = false;
        c = 0;
        d = 0;
        e = -1;
        f = -1;
        i = new Rect();
    }

    public final void a(r r1)
    {
        if (a != r1)
        {
            a = r1;
            b = true;
        }
    }

    final void a(boolean flag)
    {
        k = flag;
    }

    final boolean a()
    {
        if (a == null)
        {
            j = false;
        }
        return j;
    }

    final boolean a(CoordinatorLayout coordinatorlayout, View view)
    {
        if (j)
        {
            return true;
        }
        boolean flag = j;
        if (a != null)
        {
            coordinatorlayout = a;
        }
        j = flag;
        return flag;
    }

    final boolean a(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        return view1 == h || a != null && a.b(coordinatorlayout, view, view1);
    }

    final View b(CoordinatorLayout coordinatorlayout, View view)
    {
        if (f == -1)
        {
            h = null;
            g = null;
            return null;
        }
        if (g == null) goto _L2; else goto _L1
_L1:
        if (g.getId() == f) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L16:
        if (flag) goto _L5; else goto _L2
_L2:
        g = coordinatorlayout.findViewById(f);
        if (g == null) goto _L7; else goto _L6
_L6:
        ViewParent viewparent;
        View view1;
        view1 = g;
        viewparent = g.getParent();
_L14:
        if (viewparent == coordinatorlayout || viewparent == null) goto _L9; else goto _L8
_L8:
        if (viewparent != view) goto _L11; else goto _L10
_L10:
        if (!coordinatorlayout.isInEditMode()) goto _L13; else goto _L12
_L12:
        h = null;
        g = null;
_L5:
        return g;
_L4:
        view1 = g;
        for (viewparent = g.getParent(); viewparent != coordinatorlayout; viewparent = viewparent.getParent())
        {
            if (viewparent == null || viewparent == view)
            {
                h = null;
                g = null;
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
            if (viewparent instanceof View)
            {
                view1 = (View)viewparent;
            }
        }

        h = view1;
        flag = true;
        continue; /* Loop/switch isn't completed */
_L13:
        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
_L11:
        if (viewparent instanceof View)
        {
            view1 = (View)viewparent;
        }
        viewparent = viewparent.getParent();
          goto _L14
_L9:
        h = view1;
          goto _L5
_L7:
label0:
        {
            if (!coordinatorlayout.isInEditMode())
            {
                break label0;
            }
            h = null;
            g = null;
        }
          goto _L5
        throw new IllegalStateException((new StringBuilder("Could not find CoordinatorLayout descendant view with id ")).append(coordinatorlayout.getResources().getResourceName(f)).append(" to anchor view ").append(view).toString());
        if (true) goto _L16; else goto _L15
_L15:
    }

    final void b()
    {
        j = false;
    }

    final void b(boolean flag)
    {
        l = flag;
    }

    final void c()
    {
        k = false;
    }

    final boolean d()
    {
        return k;
    }

    final boolean e()
    {
        return l;
    }

    final void f()
    {
        l = false;
    }
}
