// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            au, a, bd, cj

class av extends au
{

    static Field b;
    static boolean c = false;

    av()
    {
    }

    public final void a(View view, a a1)
    {
        bd.a(view, a1.a);
    }

    public final boolean a(View view, int i)
    {
        return bd.a(view, i);
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
        return bd.b(view, i);
    }

    public final cj o(View view)
    {
        if (a == null)
        {
            a = new WeakHashMap();
        }
        cj cj2 = (cj)a.get(view);
        cj cj1 = cj2;
        if (cj2 == null)
        {
            cj1 = new cj(view);
            a.put(view, cj1);
        }
        return cj1;
    }

}
