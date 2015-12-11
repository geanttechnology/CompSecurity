// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.wishabi.flipp.content.as;
import com.wishabi.flipp.widget.CustomAutoCompleteTextView;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment

final class ex
    implements android.view.ActionMode.Callback
{

    final ShoppingListFragment a;

    ex(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
    {
        return false;
    }

    public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
    {
        ShoppingListFragment.d(a);
        ShoppingListFragment.e(a).a(true);
        ShoppingListFragment.f(a).setEnabled(false);
        return true;
    }

    public final void onDestroyActionMode(ActionMode actionmode)
    {
        ShoppingListFragment.d(a);
        ShoppingListFragment.e(a).a(false);
        ShoppingListFragment.f(a).setEnabled(true);
    }

    public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
    {
        return true;
    }
}
