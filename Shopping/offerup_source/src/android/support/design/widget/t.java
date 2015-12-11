// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            CoordinatorLayout, u, r

final class t
    implements android.view.ViewGroup.OnHierarchyChangeListener
{

    private CoordinatorLayout a;

    t(CoordinatorLayout coordinatorlayout)
    {
        a = coordinatorlayout;
        super();
    }

    public final void onChildViewAdded(View view, View view1)
    {
        if (CoordinatorLayout.a(a) != null)
        {
            CoordinatorLayout.a(a).onChildViewAdded(view, view1);
        }
    }

    public final void onChildViewRemoved(View view, View view1)
    {
        CoordinatorLayout coordinatorlayout = a;
        int j = coordinatorlayout.getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view2 = coordinatorlayout.getChildAt(i);
            r r1 = ((u)view2.getLayoutParams()).a;
            if (r1 != null && r1.b(coordinatorlayout, view2, view1))
            {
                r1.d(coordinatorlayout, view2, view1);
            }
        }

        if (CoordinatorLayout.a(a) != null)
        {
            CoordinatorLayout.a(a).onChildViewRemoved(view, view1);
        }
    }
}
