// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

// Referenced classes of package android.support.v4.view:
//            g

public class f
{
    static interface a
    {

        public abstract int a(int i, int j);

        public abstract void a(int i, int j, int k, Rect rect, Rect rect1, int l);
    }

    static class b
        implements a
    {

        public int a(int i, int j)
        {
            return 0xff7fffff & i;
        }

        public void a(int i, int j, int k, Rect rect, Rect rect1, int l)
        {
            Gravity.apply(i, j, k, rect, rect1);
        }

        b()
        {
        }
    }

    static class c
        implements a
    {

        public int a(int i, int j)
        {
            return g.a(i, j);
        }

        public void a(int i, int j, int k, Rect rect, Rect rect1, int l)
        {
            g.a(i, j, k, rect, rect1, l);
        }

        c()
        {
        }
    }


    static final a a;

    public static int a(int i, int j)
    {
        return a.a(i, j);
    }

    public static void a(int i, int j, int k, Rect rect, Rect rect1, int l)
    {
        a.a(i, j, k, rect, rect1, l);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
