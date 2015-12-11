// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            bm, a, cx

class bn extends bm
{

    private static Field b;
    private static boolean c = false;

    bn()
    {
    }

    public final void a(View view, a a1)
    {
        if (a1 == null)
        {
            a1 = null;
        } else
        {
            a1 = ((a) (a1.getBridge()));
        }
        view.setAccessibilityDelegate((android.view.View.AccessibilityDelegate)a1);
    }

    public final void a(View view, boolean flag)
    {
        view.setFitsSystemWindows(flag);
    }

    public final boolean a(View view, int i)
    {
        return view.canScrollHorizontally(i);
    }

    public final boolean b(View view)
    {
        if (!c)
        {
            if (b == null)
            {
                try
                {
                    Field field = android/view/View.getDeclaredField("mAccessibilityDelegate");
                    b = field;
                    field.setAccessible(true);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    c = true;
                    return false;
                }
            }
            try
            {
                view = ((View) (b.get(view)));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                c = true;
                return false;
            }
            if (view != null)
            {
                return true;
            }
        }
        return false;
    }

    public final boolean b(View view, int i)
    {
        return view.canScrollVertically(i);
    }

    public final cx s(View view)
    {
        if (a == null)
        {
            a = new WeakHashMap();
        }
        cx cx2 = (cx)a.get(view);
        cx cx1 = cx2;
        if (cx2 == null)
        {
            cx1 = new cx(view);
            a.put(view, cx1);
        }
        return cx1;
    }

}
