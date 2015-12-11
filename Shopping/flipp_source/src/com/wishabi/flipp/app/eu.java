// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import android.widget.PopupMenu;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment

final class eu
    implements android.view.View.OnClickListener
{

    final ShoppingListFragment a;

    eu(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final void onClick(View view)
    {
        ShoppingListFragment.a(a, ShoppingListFragment.h(a).getMenu());
        ShoppingListFragment.h(a).show();
    }
}
