// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;


// Referenced classes of package android.support.v4.view:
//            q

public class p
{
    static interface a
    {

        public abstract int a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams);

        public abstract int b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams);
    }

    static class b
        implements a
    {

        public int a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return marginlayoutparams.leftMargin;
        }

        public int b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return marginlayoutparams.rightMargin;
        }

        b()
        {
        }
    }

    static class c
        implements a
    {

        public int a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return q.a(marginlayoutparams);
        }

        public int b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            return q.b(marginlayoutparams);
        }

        c()
        {
        }
    }


    static final a a;

    public static int a(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return a.a(marginlayoutparams);
    }

    public static int b(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        return a.b(marginlayoutparams);
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
