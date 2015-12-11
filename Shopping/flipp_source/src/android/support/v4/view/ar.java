// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            az, cj, a

class ar
    implements az
{

    WeakHashMap a;

    ar()
    {
        a = null;
    }

    public int a(View view)
    {
        return 2;
    }

    long a()
    {
        return 10L;
    }

    public void a(View view, float f1)
    {
    }

    public void a(View view, int i1, int j1, int k1, int l1)
    {
        view.invalidate(i1, j1, k1, l1);
    }

    public void a(View view, int i1, Paint paint)
    {
    }

    public void a(View view, Paint paint)
    {
    }

    public void a(View view, a a1)
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

    public boolean a(View view, int i1)
    {
        return false;
    }

    public void b(View view, float f1)
    {
    }

    public boolean b(View view)
    {
        return false;
    }

    public boolean b(View view, int i1)
    {
        return false;
    }

    public void c(View view, float f1)
    {
    }

    public void c(View view, int i1)
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

    public int e(View view)
    {
        return 0;
    }

    public float f(View view)
    {
        return 1.0F;
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

    public boolean j(View view)
    {
        boolean flag1 = false;
        view = view.getBackground();
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (view.getOpacity() == -1)
            {
                flag = true;
            }
        }
        return flag;
    }

    public float k(View view)
    {
        return 0.0F;
    }

    public float l(View view)
    {
        return 0.0F;
    }

    public int m(View view)
    {
        return 0;
    }

    public int n(View view)
    {
        return 0;
    }

    public cj o(View view)
    {
        return new cj(view);
    }

    public boolean p(View view)
    {
        return false;
    }
}
