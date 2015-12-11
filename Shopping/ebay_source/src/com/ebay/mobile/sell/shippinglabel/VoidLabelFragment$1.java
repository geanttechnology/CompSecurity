// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.view.View;
import android.widget.Spinner;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            VoidLabelFragment, ShippingLabelActivity

class val.voidLabelReasons
    implements android.view.
{

    final VoidLabelFragment this$0;
    final Spinner val$voidLabelReasons;

    public void onClick(View view)
    {
        ((ShippingLabelActivity)getActivity()).cancelLabel((y.VoidLabelReasons)val$voidLabelReasons.getSelectedItem());
        getView().setVisibility(8);
    }

    y.VoidLabelReasons()
    {
        this$0 = final_voidlabelfragment;
        val$voidLabelReasons = Spinner.this;
        super();
    }
}
