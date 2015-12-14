// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.MenuItem;

class bj extends ay
    implements android.view.MenuItem.OnMenuItemClickListener
{

    final bf a;

    bj(bf bf1, android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        a = bf1;
        super(onmenuitemclicklistener);
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        return ((android.view.MenuItem.OnMenuItemClickListener)b).onMenuItemClick(a.a(menuitem));
    }
}
