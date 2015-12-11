// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.LayoutInflater;

// Referenced classes of package android.support.v4.view:
//            o, l, m, n

public class k
{
    static interface a
    {

        public abstract void a(LayoutInflater layoutinflater, o o);
    }

    static class b
        implements a
    {

        public void a(LayoutInflater layoutinflater, o o)
        {
            l.a(layoutinflater, o);
        }

        b()
        {
        }
    }

    static class c extends b
    {

        public void a(LayoutInflater layoutinflater, o o)
        {
            m.a(layoutinflater, o);
        }

        c()
        {
        }
    }

    static class d extends c
    {

        public void a(LayoutInflater layoutinflater, o o)
        {
            n.a(layoutinflater, o);
        }

        d()
        {
        }
    }


    static final a a;

    public static void a(LayoutInflater layoutinflater, o o)
    {
        a.a(layoutinflater, o);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            a = new d();
        } else
        if (i >= 11)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
