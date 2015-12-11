// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.f;
import android.support.v7.internal.widget.h;
import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.a:
//            b

private final class <init>
    implements android.support.v7.internal.view.menu.
{

    final b a;

    public void a(f f)
    {
        if (android.support.v7.internal.a.b.a(a) != null)
        {
            if (android.support.v7.internal.a.b.c(a).j())
            {
                android.support.v7.internal.a.b.a(a).onPanelClosed(8, f);
            } else
            if (android.support.v7.internal.a.b.a(a).onPreparePanel(0, null, f))
            {
                android.support.v7.internal.a.b.a(a).onMenuOpened(8, f);
                return;
            }
        }
    }

    public boolean a(f f, MenuItem menuitem)
    {
        return false;
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
