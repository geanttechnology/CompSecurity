// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.ViewGroup;

// Referenced classes of package android.support.v4.view:
//            av

public class au
{
    static class a extends f
    {

        public void a(ViewGroup viewgroup, boolean flag)
        {
            av.a(viewgroup, flag);
        }

        a()
        {
        }
    }

    static class b extends a
    {

        b()
        {
        }
    }

    static interface c
    {

        public abstract void a(ViewGroup viewgroup, boolean flag);
    }

    static class d extends b
    {

        d()
        {
        }
    }

    static class e extends d
    {

        e()
        {
        }
    }

    static class f
        implements c
    {

        public void a(ViewGroup viewgroup, boolean flag)
        {
        }

        f()
        {
        }
    }


    static final c a;

    public static void a(ViewGroup viewgroup, boolean flag)
    {
        a.a(viewgroup, flag);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            a = new e();
        } else
        if (i >= 18)
        {
            a = new d();
        } else
        if (i >= 14)
        {
            a = new b();
        } else
        if (i >= 11)
        {
            a = new a();
        } else
        {
            a = new f();
        }
    }
}
