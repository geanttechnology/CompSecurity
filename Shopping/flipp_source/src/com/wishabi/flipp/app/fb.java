// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.bf;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment

final class fb extends LinearLayoutManager
{

    final ShoppingListFragment a;

    fb(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final boolean a(RecyclerView recyclerview, bf bf, View view, View view1)
    {
        if (recyclerview.getScrollState() == 0)
        {
            return super.a(recyclerview, bf, view, view1);
        } else
        {
            return true;
        }
    }
}
