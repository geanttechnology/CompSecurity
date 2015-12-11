// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.f;

// Referenced classes of package android.support.v7.internal.a:
//            c

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final c a;

    public final void a(f f, boolean flag)
    {
        if (a.c != null)
        {
            a.c.onPanelClosed(0, f);
        }
    }

    public final boolean a(f f)
    {
        if (f == null && a.c != null)
        {
            a.c.onMenuOpened(0, f);
        }
        return true;
    }

    private enu.f(c c1)
    {
        a = c1;
        super();
    }

    a(c c1, byte byte0)
    {
        this(c1);
    }
}
