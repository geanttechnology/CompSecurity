// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MenuItem;

// Referenced classes of package android.support.v4.view:
//            an, c, ap, ar

final class ao extends an
{

    ao()
    {
    }

    public final MenuItem a(MenuItem menuitem, ar ar)
    {
        if (ar == null)
        {
            return android.support.v4.view.c.a(menuitem, null);
        } else
        {
            return android.support.v4.view.c.a(menuitem, new ap(this, ar));
        }
    }

    public final boolean b(MenuItem menuitem)
    {
        return menuitem.expandActionView();
    }

    public final boolean c(MenuItem menuitem)
    {
        return menuitem.collapseActionView();
    }

    public final boolean d(MenuItem menuitem)
    {
        return menuitem.isActionViewExpanded();
    }
}
