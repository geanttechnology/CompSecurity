// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.a;

import android.support.v7.internal.view.menu.f;
import android.view.Menu;

// Referenced classes of package android.support.v7.internal.a:
//            c

final class a
    implements Runnable
{

    final c a;

    public final void run()
    {
        f f1;
        c c1 = a;
        Menu menu = c1.i();
        if (menu instanceof f)
        {
            f1 = (f)menu;
        } else
        {
            f1 = null;
        }
        if (f1 != null)
        {
            f1.d();
        }
        menu.clear();
        if (!c1.c.onCreatePanelMenu(0, menu) || !c1.c.onPreparePanel(0, null, menu))
        {
            menu.clear();
        }
        if (f1 != null)
        {
            f1.e();
        }
        return;
        Exception exception;
        exception;
        if (f1 != null)
        {
            f1.e();
        }
        throw exception;
    }

    enu.f(c c1)
    {
        a = c1;
        super();
    }
}
