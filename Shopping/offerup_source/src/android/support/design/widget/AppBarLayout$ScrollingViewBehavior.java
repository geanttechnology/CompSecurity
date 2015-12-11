// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.v4.view.bi;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            bz, CoordinatorLayout, AppBarLayout, u, 
//            a

public class a extends bz
{

    private int a;

    public final volatile boolean a(int i)
    {
        return super.a(i);
    }

    public final volatile boolean a(CoordinatorLayout coordinatorlayout, View view, int i)
    {
        return super.a(coordinatorlayout, view, i);
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, int i, int j, int k, int l)
    {
        int i1 = view.getLayoutParams().lingViewBehavior;
        if (i1 != -1 && i1 != -2) goto _L2; else goto _L1
_L1:
        Object obj = coordinatorlayout.b(view);
        if (!((List) (obj)).isEmpty()) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        int j1;
        j1 = ((List) (obj)).size();
        l = 0;
_L6:
        View view1;
        if (l >= j1)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        view1 = (View)((List) (obj)).get(l);
        if (!(view1 instanceof AppBarLayout)) goto _L5; else goto _L4
_L4:
        obj = (AppBarLayout)view1;
_L7:
        if (obj != null && bi.B(((View) (obj))))
        {
            if (bi.v(((View) (obj))))
            {
                bi.a(view, true);
            }
            l = android.view.b(k);
            k = l;
            if (l == 0)
            {
                k = coordinatorlayout.getHeight();
            }
            int k1 = ((AppBarLayout) (obj)).getMeasuredHeight();
            int l1 = ((AppBarLayout) (obj)).getTotalScrollRange();
            if (i1 == -1)
            {
                l = 0x40000000;
            } else
            {
                l = 0x80000000;
            }
            coordinatorlayout.a(view, i, j, android.view.a(l1 + (k - k1), l), 0);
            return true;
        }
          goto _L2
_L5:
        l++;
          goto _L6
        obj = null;
          goto _L7
    }

    public final volatile int b()
    {
        return super.b();
    }

    public final boolean b(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        return view1 instanceof AppBarLayout;
    }

    public final boolean c(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        r r = ((u)view1.getLayoutParams()).a;
        if (r instanceof a)
        {
            int i = ((a)r).a();
            int j = view1.getHeight();
            int k = a;
            int l = coordinatorlayout.getHeight();
            int i1 = view.getHeight();
            if (a != 0 && (view1 instanceof AppBarLayout))
            {
                int j1 = ((AppBarLayout)view1).getTotalScrollRange();
                super.a(android.support.design.widget.a.a(j - k, l - i1, (float)Math.abs(i) / (float)j1));
            } else
            {
                super.a(i + (view1.getHeight() - a));
            }
        }
        return false;
    }

    public ()
    {
    }

    public (Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, a.ae);
        a = context.getDimensionPixelSize(a.af, 0);
        context.recycle();
    }
}
