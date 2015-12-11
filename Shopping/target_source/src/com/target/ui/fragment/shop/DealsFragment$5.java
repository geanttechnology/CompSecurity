// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.support.v7.widget.RecyclerView;
import com.target.ui.adapter.h.a;
import com.target.ui.e.f;
import com.target.ui.fragment.shop.presenter.DealsPresenter;

// Referenced classes of package com.target.ui.fragment.shop:
//            DealsFragment

class it> extends android.support.v7.widget._cls5
{

    final DealsFragment this$0;

    public void a(RecyclerView recyclerview, int i)
    {
        super.(recyclerview, i);
        while (DealsFragment.c(DealsFragment.this) == null || i != 0) 
        {
            return;
        }
        DealsFragment.c(DealsFragment.this).f();
    }

    public void a(RecyclerView recyclerview, int i, int j)
    {
        if (DealsFragment.c(DealsFragment.this) != null)
        {
            DealsFragment.c(DealsFragment.this).b(j);
        }
        i = recyclerview.d(recyclerview.getChildAt(recyclerview.getChildCount() - 1));
        j = DealsFragment.d(DealsFragment.this).a();
        DealsFragment.b(DealsFragment.this).a(i, j - 1);
    }

    resenter()
    {
        this$0 = DealsFragment.this;
        super();
    }
}
