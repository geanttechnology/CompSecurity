// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v7.internal.view.menu.k;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            a, s

final class nit> extends nit>
{

    final a a;
    final b b;

    public final s a()
    {
        if (b.b.m == null)
        {
            return null;
        } else
        {
            return ((k) (b.b.m)).c;
        }
    }

    public final boolean b()
    {
        b.b.d();
        return true;
    }

    public final boolean c()
    {
        if (b.b.o != null)
        {
            return false;
        } else
        {
            b.b.e();
            return true;
        }
    }

    .menu.k(.menu.k k1, View view, a a1)
    {
        b = k1;
        a = a1;
        super(view);
    }
}
