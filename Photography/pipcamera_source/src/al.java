// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MenuItem;

class al extends ac
    implements android.support.v4.view.MenuItemCompat.OnActionExpandListener
{

    final ai a;

    al(ai ai1, android.view.MenuItem.OnActionExpandListener onactionexpandlistener)
    {
        a = ai1;
        super(onactionexpandlistener);
    }

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return ((android.view.MenuItem.OnActionExpandListener)b).onMenuItemActionCollapse(a.a(menuitem));
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return ((android.view.MenuItem.OnActionExpandListener)b).onMenuItemActionExpand(a.a(menuitem));
    }
}
