// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp;

import android.view.View;
import android.widget.AdapterView;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.fragment.product.clp:
//            CollectionsListPageFragment

private class <init>
    implements android.widget.r
{

    final CollectionsListPageFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ProductDetails)adapterview.getItemAtPosition(i);
        view = (BitmapImageView)view.findViewById(0x7f1004fd);
        CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(adapterview, view);
    }

    private esenter()
    {
        this$0 = CollectionsListPageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
