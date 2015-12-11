// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

// Referenced classes of package android.support.v4.view:
//            aa, ax

public class aw
{
    static class a extends e
    {

        a()
        {
        }
    }

    static interface b
    {

        public abstract void a(ViewParent viewparent, View view);

        public abstract void a(ViewParent viewparent, View view, int i, int j, int k, int l);

        public abstract void a(ViewParent viewparent, View view, int i, int j, int ai[]);

        public abstract boolean a(ViewParent viewparent, View view, float f, float f1);

        public abstract boolean a(ViewParent viewparent, View view, float f, float f1, boolean flag);

        public abstract boolean a(ViewParent viewparent, View view, View view1, int i);

        public abstract void b(ViewParent viewparent, View view, View view1, int i);
    }

    static class c extends a
    {

        c()
        {
        }
    }

    static class d extends c
    {

        public void a(ViewParent viewparent, View view)
        {
            ax.a(viewparent, view);
        }

        public void a(ViewParent viewparent, View view, int i, int j, int k, int l)
        {
            ax.a(viewparent, view, i, j, k, l);
        }

        public void a(ViewParent viewparent, View view, int i, int j, int ai[])
        {
            ax.a(viewparent, view, i, j, ai);
        }

        public boolean a(ViewParent viewparent, View view, float f, float f1)
        {
            return ax.a(viewparent, view, f, f1);
        }

        public boolean a(ViewParent viewparent, View view, float f, float f1, boolean flag)
        {
            return ax.a(viewparent, view, f, f1, flag);
        }

        public boolean a(ViewParent viewparent, View view, View view1, int i)
        {
            return ax.a(viewparent, view, view1, i);
        }

        public void b(ViewParent viewparent, View view, View view1, int i)
        {
            ax.b(viewparent, view, view1, i);
        }

        d()
        {
        }
    }

    static class e
        implements b
    {

        public void a(ViewParent viewparent, View view)
        {
            if (viewparent instanceof aa)
            {
                ((aa)viewparent).onStopNestedScroll(view);
            }
        }

        public void a(ViewParent viewparent, View view, int i, int j, int k, int l)
        {
            if (viewparent instanceof aa)
            {
                ((aa)viewparent).onNestedScroll(view, i, j, k, l);
            }
        }

        public void a(ViewParent viewparent, View view, int i, int j, int ai[])
        {
            if (viewparent instanceof aa)
            {
                ((aa)viewparent).onNestedPreScroll(view, i, j, ai);
            }
        }

        public boolean a(ViewParent viewparent, View view, float f, float f1)
        {
            if (viewparent instanceof aa)
            {
                return ((aa)viewparent).onNestedPreFling(view, f, f1);
            } else
            {
                return false;
            }
        }

        public boolean a(ViewParent viewparent, View view, float f, float f1, boolean flag)
        {
            if (viewparent instanceof aa)
            {
                return ((aa)viewparent).onNestedFling(view, f, f1, flag);
            } else
            {
                return false;
            }
        }

        public boolean a(ViewParent viewparent, View view, View view1, int i)
        {
            if (viewparent instanceof aa)
            {
                return ((aa)viewparent).onStartNestedScroll(view, view1, i);
            } else
            {
                return false;
            }
        }

        public void b(ViewParent viewparent, View view, View view1, int i)
        {
            if (viewparent instanceof aa)
            {
                ((aa)viewparent).onNestedScrollAccepted(view, view1, i);
            }
        }

        e()
        {
        }
    }


    static final b a;

    public static void a(ViewParent viewparent, View view)
    {
        a.a(viewparent, view);
    }

    public static void a(ViewParent viewparent, View view, int i, int j, int k, int l)
    {
        a.a(viewparent, view, i, j, k, l);
    }

    public static void a(ViewParent viewparent, View view, int i, int j, int ai[])
    {
        a.a(viewparent, view, i, j, ai);
    }

    public static boolean a(ViewParent viewparent, View view, float f, float f1)
    {
        return a.a(viewparent, view, f, f1);
    }

    public static boolean a(ViewParent viewparent, View view, float f, float f1, boolean flag)
    {
        return a.a(viewparent, view, f, f1, flag);
    }

    public static boolean a(ViewParent viewparent, View view, View view1, int i)
    {
        return a.a(viewparent, view, view1, i);
    }

    public static void b(ViewParent viewparent, View view, View view1, int i)
    {
        a.b(viewparent, view, view1, i);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            a = new d();
        } else
        if (i >= 19)
        {
            a = new c();
        } else
        if (i >= 14)
        {
            a = new a();
        } else
        {
            a = new e();
        }
    }
}
