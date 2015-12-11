// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import com.target.mothership.common.a.g;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.model.a;

// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductFiatsDialogFragment

private class <init>
    implements com.target.ui.adapter.product.gment.c
{

    final ProductFiatsDialogFragment this$0;

    public void a()
    {
    }

    public void a(Store store)
    {
        if (ProductFiatsDialogFragment.e(ProductFiatsDialogFragment.this) == null)
        {
            return;
        } else
        {
            ProductFiatsDialogFragment.e(ProductFiatsDialogFragment.this).(store);
            getDialog().dismiss();
            return;
        }
    }

    public void a(a a1, g g)
    {
    }

    private ()
    {
        this$0 = ProductFiatsDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
