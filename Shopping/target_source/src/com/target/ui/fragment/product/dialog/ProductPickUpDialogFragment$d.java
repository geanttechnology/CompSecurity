// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import com.target.mothership.common.a.g;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.model.a;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductPickUpDialogFragment

private class <init>
    implements com.target.ui.adapter.product.gment.d
{

    final ProductPickUpDialogFragment this$0;

    public void a()
    {
    }

    public void a(Store store)
    {
        if (ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this) == null)
        {
            return;
        } else
        {
            ProductPickUpDialogFragment.b(ProductPickUpDialogFragment.this)._mth0(store);
            getDialog().dismiss();
            return;
        }
    }

    public void a(a a1, g g)
    {
        com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, a1.a());
        com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, g);
        com.target.ui.fragment.product.dialog.ProductPickUpDialogFragment.a(ProductPickUpDialogFragment.this, true);
    }

    private I()
    {
        this$0 = ProductPickUpDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
