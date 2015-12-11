// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.View;

// Referenced classes of package android.support.design.widget:
//            g, i, h, o

class n
{
    private static interface a
    {

        public abstract void a(View view);
    }

    private static class b
        implements a
    {

        public void a(View view)
        {
        }

        private b()
        {
        }

    }

    private static class c
        implements a
    {

        public void a(View view)
        {
            o.a(view);
        }

        private c()
        {
        }

    }


    static final g.d a = new g.d() {

        public g a()
        {
            Object obj;
            if (android.os.Build.VERSION.SDK_INT >= 12)
            {
                obj = new i();
            } else
            {
                obj = new h();
            }
            return new g(((g.e) (obj)));
        }

    };
    private static final a b;

    static g a()
    {
        return a.a();
    }

    static void a(View view)
    {
        b.a(view);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            b = new c();
        } else
        {
            b = new b();
        }
    }
}
