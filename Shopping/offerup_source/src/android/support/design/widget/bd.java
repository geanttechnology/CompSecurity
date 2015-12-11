// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import java.lang.ref.WeakReference;

// Referenced classes of package android.support.design.widget:
//            bc

final class bd
{

    private final WeakReference a;
    private int b;

    bd(int i, bc bc)
    {
        a = new WeakReference(bc);
        b = i;
    }

    static int a(bd bd1, int i)
    {
        bd1.b = i;
        return i;
    }

    static WeakReference a(bd bd1)
    {
        return bd1.a;
    }

    static int b(bd bd1)
    {
        return bd1.b;
    }

    final boolean a(bc bc)
    {
        return bc != null && a.get() == bc;
    }
}
