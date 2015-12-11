// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.util.u;

// Referenced classes of package com.target.ui.adapter.product:
//            ProductAddToListDialogAdapter

private class <init>
    implements android.view.tDialogAdapter.b
{

    final ProductAddToListDialogAdapter this$0;

    public void onClick(View view)
    {
        view = (ewHolder)u.a(view.getTag(), com/target/ui/adapter/product/ProductAddToListDialogAdapter$ViewHolder);
        if (view != null)
        {
            if (ProductAddToListDialogAdapter.a(ProductAddToListDialogAdapter.this) != ((ewHolder) (view)).position)
            {
                ProductAddToListDialogAdapter.a(ProductAddToListDialogAdapter.this, ((ewHolder) (view)).position);
                notifyDataSetChanged();
            }
            if (ProductAddToListDialogAdapter.b(ProductAddToListDialogAdapter.this) != null)
            {
                view = (ListSummary)getItem(((ewHolder) (view)).position);
                ProductAddToListDialogAdapter.b(ProductAddToListDialogAdapter.this).a(view);
                return;
            }
        }
    }

    private ewHolder()
    {
        this$0 = ProductAddToListDialogAdapter.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
