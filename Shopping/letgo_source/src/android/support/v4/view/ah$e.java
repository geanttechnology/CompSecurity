// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ah, am, a, ay

static class  extends 
{

    static Field b;
    static boolean c = false;

    public void a(View view, a a1)
    {
        if (a1 == null)
        {
            a1 = null;
        } else
        {
            a1 = ((a) (a1.getBridge()));
        }
        am.a(view, a1);
    }

    public boolean a(View view, int i)
    {
        return am.a(view, i);
    }

    public boolean b(View view)
    {
        boolean flag = true;
        if (c)
        {
            return false;
        }
        if (b == null)
        {
            try
            {
                b = android/view/View.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
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
        if (view == null)
        {
            flag = false;
        }
        return flag;
    }

    public boolean b(View view, int i)
    {
        return am.b(view, i);
    }

    public ay r(View view)
    {
        if (a == null)
        {
            a = new WeakHashMap();
        }
        ay ay2 = (ay)a.get(view);
        ay ay1 = ay2;
        if (ay2 == null)
        {
            ay1 = new ay(view);
            a.put(view, ay1);
        }
        return ay1;
    }


    ()
    {
    }
}
