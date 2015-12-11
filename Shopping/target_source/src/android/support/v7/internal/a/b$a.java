// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.h;

// Referenced classes of package android.support.v7.internal.a:
//            b

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final b a;
    private boolean b;

    public void a(f f, boolean flag)
    {
        if (b)
        {
            return;
        }
        b = true;
        android.support.v7.internal.a.b.c(a).o();
        if (android.support.v7.internal.a.b.a(a) != null)
        {
            android.support.v7.internal.a.b.a(a).onPanelClosed(8, f);
        }
        b = false;
    }

    public boolean a_(f f)
    {
        if (android.support.v7.internal.a.b.a(a) != null)
        {
            android.support.v7.internal.a.b.a(a).onMenuOpened(8, f);
            return true;
        } else
        {
            return false;
        }
    }

    private enu.f(b b1)
    {
        a = b1;
        super();
    }

    a(b b1, a a1)
    {
        this(b1);
    }
}
