// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.d.e;
import android.view.ViewGroup;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView

public static abstract class b
{

    public final c a = new <init>();
    boolean b;

    public abstract int a();

    public int a(int i)
    {
        return 0;
    }

    public abstract b a(ViewGroup viewgroup, int i);

    public final void a(int i, int j)
    {
        a.b(i, j);
    }

    public final void a(b b1)
    {
        a.registerObserver(b1);
    }

    public abstract void a(registerObserver registerobserver, int i);

    public long b(int i)
    {
        return -1L;
    }

    public final void b(int i, int j)
    {
        a.c(i, j);
    }

    public final void b(c c1, int i)
    {
        c1.b = i;
        if (b)
        {
            c1.d = b(i);
        }
        c1.a(1, 519);
        e.a("RV OnBindView");
        a(c1, i);
        e.a();
    }

    public final void c(int i)
    {
        a.c(i, 1);
    }

    public ()
    {
        b = false;
    }
}
