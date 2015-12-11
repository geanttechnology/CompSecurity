// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            bt, ay, bd, bc, 
//            c, cx, dn, a, 
//            ba

class bj
    implements bt
{

    WeakHashMap a;

    bj()
    {
        a = null;
    }

    public boolean A(View view)
    {
        if (view instanceof ay)
        {
            return ((ay)view).isNestedScrollingEnabled();
        } else
        {
            return false;
        }
    }

    public void B(View view)
    {
        if (view instanceof ay)
        {
            ((ay)view).stopNestedScroll();
        }
    }

    public boolean C(View view)
    {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public float D(View view)
    {
        return w(view) + v(view);
    }

    public boolean E(View view)
    {
        return view.getWindowToken() != null;
    }

    public int a(int i1, int j1)
    {
        return i1 | j1;
    }

    public int a(int i1, int j1, int k1)
    {
        return View.resolveSize(i1, j1);
    }

    public int a(View view)
    {
        return 2;
    }

    long a()
    {
        return 10L;
    }

    public dn a(View view, dn dn)
    {
        return dn;
    }

    public void a(View view, float f1)
    {
    }

    public void a(View view, int i1, int j1, int k1, int l1)
    {
        view.setPadding(i1, j1, k1, l1);
    }

    public void a(View view, int i1, Paint paint)
    {
    }

    public void a(View view, ColorStateList colorstatelist)
    {
        if (view instanceof bd)
        {
            ((bd)view).setSupportBackgroundTintList(colorstatelist);
        }
    }

    public void a(View view, android.graphics.PorterDuff.Mode mode)
    {
        if (view instanceof bd)
        {
            ((bd)view).setSupportBackgroundTintMode(mode);
        }
    }

    public void a(View view, a a1)
    {
    }

    public void a(View view, ba ba)
    {
    }

    public void a(View view, Runnable runnable)
    {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long l1)
    {
        view.postDelayed(runnable, a() + l1);
    }

    public void a(View view, boolean flag)
    {
    }

    public void a(ViewGroup viewgroup, boolean flag)
    {
    }

    public boolean a(View view, int i1)
    {
        if (!(view instanceof bc)) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        view = (bc)view;
        j1 = view.computeHorizontalScrollOffset();
        k1 = view.computeHorizontalScrollRange() - view.computeHorizontalScrollExtent();
        if (k1 == 0) goto _L4; else goto _L3
_L3:
        if (i1 >= 0) goto _L6; else goto _L5
_L5:
        if (j1 > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
_L7:
        if (i1 != 0)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (j1 < k1 - 1)
        {
            i1 = 1;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        i1 = 0;
        if (true) goto _L7; else goto _L2
_L2:
        return false;
    }

    public dn b(View view, dn dn)
    {
        return dn;
    }

    public void b(View view, float f1)
    {
    }

    public void b(View view, boolean flag)
    {
    }

    public boolean b(View view)
    {
        return false;
    }

    public boolean b(View view, int i1)
    {
        if (!(view instanceof bc)) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        view = (bc)view;
        j1 = view.computeVerticalScrollOffset();
        k1 = view.computeVerticalScrollRange() - view.computeVerticalScrollExtent();
        if (k1 == 0) goto _L4; else goto _L3
_L3:
        if (i1 >= 0) goto _L6; else goto _L5
_L5:
        if (j1 > 0)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
_L7:
        if (i1 != 0)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
_L6:
        if (j1 < k1 - 1)
        {
            i1 = 1;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        i1 = 0;
        if (true) goto _L7; else goto _L2
_L2:
        return false;
    }

    public void c(View view, float f1)
    {
    }

    public void c(View view, int i1)
    {
    }

    public void c(View view, boolean flag)
    {
    }

    public boolean c(View view)
    {
        return false;
    }

    public void d(View view)
    {
        view.invalidate();
    }

    public void d(View view, float f1)
    {
    }

    public int e(View view)
    {
        return 0;
    }

    public void e(View view, float f1)
    {
    }

    public float f(View view)
    {
        return 1.0F;
    }

    public void f(View view, float f1)
    {
    }

    public int g(View view)
    {
        return 0;
    }

    public int h(View view)
    {
        return 0;
    }

    public ViewParent i(View view)
    {
        return view.getParent();
    }

    public int j(View view)
    {
        return 0;
    }

    public int k(View view)
    {
        return view.getPaddingLeft();
    }

    public int l(View view)
    {
        return view.getPaddingRight();
    }

    public boolean m(View view)
    {
        return true;
    }

    public float n(View view)
    {
        return 0.0F;
    }

    public float o(View view)
    {
        return 0.0F;
    }

    public float p(View view)
    {
        return 0.0F;
    }

    public int q(View view)
    {
        return android.support.v4.view.c.a(view);
    }

    public int r(View view)
    {
        return android.support.v4.view.c.b(view);
    }

    public cx s(View view)
    {
        return new cx(view);
    }

    public int t(View view)
    {
        return 0;
    }

    public void u(View view)
    {
    }

    public float v(View view)
    {
        return 0.0F;
    }

    public float w(View view)
    {
        return 0.0F;
    }

    public boolean x(View view)
    {
        return false;
    }

    public void y(View view)
    {
    }

    public boolean z(View view)
    {
        return false;
    }
}
