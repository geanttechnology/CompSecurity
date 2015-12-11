// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.internal;

import android.content.Context;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.view.MenuItem;

// Referenced classes of package android.support.design.internal:
//            NavigationMenu

public class NavigationSubMenu extends SubMenuBuilder
{

    public NavigationSubMenu(Context context, NavigationMenu navigationmenu, MenuItemImpl menuitemimpl)
    {
        super(context, navigationmenu, menuitemimpl);
    }

    private void notifyParent()
    {
        ((MenuBuilder)getParentMenu()).onItemsChanged(true);
    }

    public MenuItem add(int i)
    {
        MenuItem menuitem = super.add(i);
        notifyParent();
        return menuitem;
    }

    public MenuItem add(int i, int j, int k, int l)
    {
        MenuItem menuitem = super.add(i, j, k, l);
        notifyParent();
        return menuitem;
    }

    public MenuItem add(int i, int j, int k, CharSequence charsequence)
    {
        charsequence = super.add(i, j, k, charsequence);
        notifyParent();
        return charsequence;
    }

    public MenuItem add(CharSequence charsequence)
    {
        charsequence = super.add(charsequence);
        notifyParent();
        return charsequence;
    }
}
