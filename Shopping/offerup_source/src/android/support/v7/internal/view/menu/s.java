// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.view.MenuItem;

// Referenced classes of package android.support.v7.internal.view.menu:
//            f, o

final class s extends f
    implements android.view.MenuItem.OnMenuItemClickListener
{

    private o a;

    s(o o1, android.view.MenuItem.OnMenuItemClickListener onmenuitemclicklistener)
    {
        a = o1;
        super(onmenuitemclicklistener);
    }

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        return ((android.view.MenuItem.OnMenuItemClickListener)b).onMenuItemClick(a.a(menuitem));
    }
}
