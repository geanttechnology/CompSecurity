// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.ViewGroup;

// Referenced classes of package android.support.v7.widget:
//            ao, bi

public abstract class an
{

    public final ao a = new ao();
    public boolean b;

    public an()
    {
        b = false;
    }

    public abstract int a();

    public int a(int i)
    {
        return 0;
    }

    public abstract bi a(ViewGroup viewgroup, int i);

    public abstract void a(bi bi1, int i);

    public long b(int i)
    {
        return -1L;
    }

    public final void b(bi bi1, int i)
    {
        bi1.b = i;
        if (b)
        {
            bi1.d = b(i);
        }
        a(bi1, i);
        bi1.a(1, 7);
    }

    public final void c(int i)
    {
        a.a(i);
    }
}
