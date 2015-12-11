// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v7.internal.view.menu.b;
import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.view.menu.p;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.widget:
//            a

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final a a;

    public final void a(f f1, boolean flag)
    {
        if (f1 instanceof p)
        {
            ((p)f1).l.a(false);
        }
        android.support.v7.internal.view.menu.  = ((b) (a)).f;
        if ( != null)
        {
            .a(f1, flag);
        }
    }

    public final boolean a(f f1)
    {
        if (f1 == null)
        {
            return false;
        }
        a.q = ((p)f1).getItem().getItemId();
        android.support.v7.internal.view.menu.a a1 = ((b) (a)).f;
        if (a1 != null)
        {
            return a1.a(f1);
        } else
        {
            return false;
        }
    }

    private ew.menu.f(a a1)
    {
        a = a1;
        super();
    }

    a(a a1, byte byte0)
    {
        this(a1);
    }
}
