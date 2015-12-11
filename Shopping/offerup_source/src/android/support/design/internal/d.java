// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.support.v7.internal.view.menu.m;

final class d
{

    private final m a;
    private final int b;
    private final int c;

    private d(m m1, int i, int j)
    {
        a = m1;
        b = i;
        c = j;
    }

    public static d a(int i, int j)
    {
        return new d(null, i, j);
    }

    public static d a(m m1)
    {
        return new d(m1, 0, 0);
    }

    public final boolean a()
    {
        return a == null;
    }

    public final int b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final m d()
    {
        return a;
    }

    public final boolean e()
    {
        return a != null && !a.hasSubMenu() && a.isEnabled();
    }
}
