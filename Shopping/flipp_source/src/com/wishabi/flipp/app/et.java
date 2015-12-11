// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.SharedPreferences;
import com.wishabi.flipp.content.ShoppingList;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment, ff

final class et
    implements android.content.SharedPreferences.OnSharedPreferenceChangeListener
{

    final ShoppingListFragment a;

    et(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if (s.equals("postal_code"))
        {
            ShoppingListFragment.a(a, ShoppingListFragment.a(a).getString("postal_code", null));
            if (ShoppingListFragment.b(a) != null)
            {
                ShoppingListFragment.b(a).f = -1L;
            }
            if (ShoppingListFragment.b(a) != null)
            {
                ShoppingListFragment.b(a).c();
            }
            if (ShoppingListFragment.c(a) != null)
            {
                ShoppingListFragment.c(a).a();
                return;
            }
        }
    }
}
