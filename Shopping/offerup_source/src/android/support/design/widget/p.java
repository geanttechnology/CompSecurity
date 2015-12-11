// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;
import java.util.Comparator;

// Referenced classes of package android.support.design.widget:
//            u, CoordinatorLayout

final class p
    implements Comparator
{

    private CoordinatorLayout a;

    p(CoordinatorLayout coordinatorlayout)
    {
        a = coordinatorlayout;
        super();
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (View)obj;
        obj1 = (View)obj1;
        if (obj != obj1)
        {
            if (((u)((View) (obj)).getLayoutParams()).a(a, ((View) (obj)), ((View) (obj1))))
            {
                return 1;
            }
            if (((u)((View) (obj1)).getLayoutParams()).a(a, ((View) (obj1)), ((View) (obj))))
            {
                return -1;
            }
        }
        return 0;
    }
}
