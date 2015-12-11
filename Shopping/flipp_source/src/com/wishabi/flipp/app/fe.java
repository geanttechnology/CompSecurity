// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.MenuItem;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment

final class fe
    implements android.widget.PopupMenu.OnMenuItemClickListener
{

    final ShoppingListFragment a;

    fe(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final boolean onMenuItemClick(MenuItem menuitem)
    {
        return ShoppingListFragment.a(a, menuitem);
    }
}
