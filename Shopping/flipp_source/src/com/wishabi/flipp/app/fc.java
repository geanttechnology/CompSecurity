// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.support.v7.widget.ax;
import com.wishabi.flipp.content.as;
import com.wishabi.flipp.widget.db;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment, FocusedRecyclerView

final class fc extends ax
{

    final ShoppingListFragment a;

    fc(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final void a(int i)
    {
        android.app.Activity activity = a.getActivity();
        android.view.View view = ShoppingListFragment.g(a).getFocusedChild();
        if (i != 1 || view == null || activity == null)
        {
            return;
        }
        if (view instanceof db)
        {
            ShoppingListFragment.e(a).c(FocusedRecyclerView.c(view));
        }
        ShoppingListFragment.d(a);
    }
}
