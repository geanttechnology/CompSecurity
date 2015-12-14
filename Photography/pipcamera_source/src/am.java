// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MenuItem;

class am extends ac
    implements android.view.MenuItem.OnMenuItemClickListener
{

    final ai a;

    am(ai ai1, android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        a = ai1;
        super(onmenuitemclicklistener);
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        return ((android.view.MenuItem.OnMenuItemClickListener)b).onMenuItemClick(a.a(menuitem));
    }
}
