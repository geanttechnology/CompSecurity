// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.view.product.ProductAddToListFooter;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductAddToListDialogFragment

private class <init>
    implements com.target.ui.adapter.product.gment.a
{

    final ProductAddToListDialogFragment this$0;

    public void a(ListSummary listsummary)
    {
        if (ProductAddToListDialogFragment.c(ProductAddToListDialogFragment.this) == null)
        {
            return;
        } else
        {
            ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, listsummary);
            ProductAddToListDialogFragment.a(ProductAddToListDialogFragment.this, true);
            ProductAddToListDialogFragment.c(ProductAddToListDialogFragment.this).footer.a();
            return;
        }
    }

    private ews()
    {
        this$0 = ProductAddToListDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
