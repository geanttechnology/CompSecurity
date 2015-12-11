// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.mothership.model.product.interfaces.ProductEntry;

// Referenced classes of package com.target.ui.view.product:
//            PlpRefineHeaderView

class uctEntry
    implements android.view.eaderView.c._cls1
{

    final val.productEntry this$0;
    final ProductEntry val$productEntry;

    public void onClick(View view)
    {
        if (uctEntry(this._cls0.this) == null)
        {
            return;
        } else
        {
            com.target.ui.view.product.this._mth0(this._cls0.this).a(val$productEntry);
            return;
        }
    }

    uctEntry()
    {
        this$0 = final_uctentry;
        val$productEntry = ProductEntry.this;
        super();
    }
}
