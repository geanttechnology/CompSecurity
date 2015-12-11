// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.graphics.Rect;
import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.view.View;
import java.util.List;

// Referenced classes of package android.support.design.widget:
//            r, FloatingActionButton, u, AppBarLayout, 
//            bu, CoordinatorLayout, a

public class A extends r
{

    private static final boolean a;
    private Rect b;

    private boolean a(CoordinatorLayout coordinatorlayout, AppBarLayout appbarlayout, FloatingActionButton floatingactionbutton)
    {
        if (((u)floatingactionbutton.getLayoutParams()).f != appbarlayout.getId())
        {
            return false;
        }
        if (b == null)
        {
            b = new Rect();
        }
        Rect rect = b;
        bu.a(coordinatorlayout, appbarlayout, rect);
        if (rect.bottom <= appbarlayout.getMinimumHeightForVisibleOverlappingContent())
        {
            floatingactionbutton.b();
        } else
        {
            floatingactionbutton.a();
        }
        return true;
    }

    public final boolean a(CoordinatorLayout coordinatorlayout, View view, int i)
    {
        Object obj;
        boolean flag;
        flag = false;
        view = (FloatingActionButton)view;
        obj = coordinatorlayout.b(view);
        int l = ((List) (obj)).size();
        int j = 0;
        do
        {
            if (j >= l)
            {
                break;
            }
            View view1 = (View)((List) (obj)).get(j);
            if ((view1 instanceof AppBarLayout) && a(coordinatorlayout, (AppBarLayout)view1, ((FloatingActionButton) (view))))
            {
                break;
            }
            j++;
        } while (true);
        coordinatorlayout.a(view, i);
        obj = FloatingActionButton.a(view);
        if (obj == null || ((Rect) (obj)).centerX() <= 0 || ((Rect) (obj)).centerY() <= 0) goto _L2; else goto _L1
_L1:
        u u1 = (u)view.getLayoutParams();
        int k;
        if (view.getRight() >= coordinatorlayout.getWidth() - u1.rightMargin)
        {
            i = ((Rect) (obj)).right;
        } else
        if (view.getLeft() <= u1.leftMargin)
        {
            i = -((Rect) (obj)).left;
        } else
        {
            i = 0;
        }
        if (view.getBottom() < coordinatorlayout.getBottom() - u1.bottomMargin) goto _L4; else goto _L3
_L3:
        k = ((Rect) (obj)).bottom;
_L6:
        view.offsetTopAndBottom(k);
        view.offsetLeftAndRight(i);
_L2:
        return true;
_L4:
        k = ((flag) ? 1 : 0);
        if (view.getTop() <= u1.topMargin)
        {
            k = -((Rect) (obj)).top;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final volatile boolean b(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        return a && (view1 instanceof a);
    }

    public final boolean c(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        view = (FloatingActionButton)view;
        if (view1 instanceof a)
        {
            if (view.getVisibility() == 0)
            {
                float f = 0.0F;
                view1 = coordinatorlayout.b(view);
                int j = view1.size();
                for (int i = 0; i < j; i++)
                {
                    View view2 = (View)view1.get(i);
                    if ((view2 instanceof lity) && coordinatorlayout.a(view, view2))
                    {
                        f = Math.min(f, bi.n(view2) - (float)view2.getHeight());
                    }
                }

                bi.b(view, f);
            }
        } else
        if (view1 instanceof AppBarLayout)
        {
            a(coordinatorlayout, (AppBarLayout)view1, view);
            return false;
        }
        return false;
    }

    public final void d(CoordinatorLayout coordinatorlayout, View view, View view1)
    {
        coordinatorlayout = (FloatingActionButton)view;
        if ((view1 instanceof a) && bi.n(coordinatorlayout) != 0.0F)
        {
            bi.q(coordinatorlayout).c(0.0F).d(1.0F).e(1.0F).a(1.0F).a(a.a).a(null);
        }
    }

    static 
    {
        boolean flag;
        if (android.os.ackbarLayout >= 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    public A()
    {
    }
}
