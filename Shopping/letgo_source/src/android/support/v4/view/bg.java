// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.WindowInsets;

// Referenced classes of package android.support.v4.view:
//            bf

class bg extends bf
{

    private final WindowInsets a;

    bg(WindowInsets windowinsets)
    {
        a = windowinsets;
    }

    public int a()
    {
        return a.getSystemWindowInsetLeft();
    }

    public bf a(int i, int j, int k, int l)
    {
        return new bg(a.replaceSystemWindowInsets(i, j, k, l));
    }

    public int b()
    {
        return a.getSystemWindowInsetTop();
    }

    public int c()
    {
        return a.getSystemWindowInsetRight();
    }

    public int d()
    {
        return a.getSystemWindowInsetBottom();
    }

    public boolean e()
    {
        return a.isConsumed();
    }

    public bf f()
    {
        return new bg(a.consumeSystemWindowInsets());
    }

    WindowInsets g()
    {
        return a;
    }
}
