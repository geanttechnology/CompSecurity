// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.support.v7.widget.RecyclerView;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            ProductListFragment

class > extends android.support.v7.widget.istener
{

    final ProductListFragment a;

    public void onScrollStateChanged(RecyclerView recyclerview, int i)
    {
        super.onScrollStateChanged(recyclerview, i);
    }

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        super.onScrolled(recyclerview, i, j);
        ProductListFragment.a(a);
    }

    (ProductListFragment productlistfragment)
    {
        a = productlistfragment;
        super();
    }
}
