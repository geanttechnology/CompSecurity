// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import java.lang.ref.WeakReference;

// Referenced classes of package android.support.design.widget:
//            TabLayout

public static class a
    implements android.support.v4.view.out.d
{

    private final WeakReference a;
    private int b;

    public void a(int i)
    {
        b = i;
    }

    public void a(int i, float f, int j)
    {
        boolean flag = true;
        TabLayout tablayout = (TabLayout)a.get();
        if (tablayout != null)
        {
            if (b != 1)
            {
                flag = false;
            }
            tablayout.a(i, f, flag);
        }
    }

    public void b(int i)
    {
        TabLayout tablayout = (TabLayout)a.get();
        if (tablayout != null)
        {
            tablayout.a(i).e();
        }
    }

    public (TabLayout tablayout)
    {
        a = new WeakReference(tablayout);
    }
}
