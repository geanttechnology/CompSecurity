// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.h;

// Referenced classes of package android.support.v7.internal.a:
//            c

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final c a;
    private boolean b;

    public final void a(f f, boolean flag)
    {
        if (b)
        {
            return;
        }
        b = true;
        a.a.l();
        if (a.c != null)
        {
            a.c.onPanelClosed(8, f);
        }
        b = false;
    }

    public final boolean a(f f)
    {
        if (a.c != null)
        {
            a.c.onMenuOpened(8, f);
            return true;
        } else
        {
            return false;
        }
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
