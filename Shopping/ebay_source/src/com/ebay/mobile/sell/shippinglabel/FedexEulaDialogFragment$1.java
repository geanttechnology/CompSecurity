// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.view.View;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            FedexEulaDialogFragment, ShippingLabelActivity

class this._cls0
    implements android.view.xEulaDialogFragment._cls1
{

    final FedexEulaDialogFragment this$0;

    public void onClick(View view)
    {
        ((ShippingLabelActivity)getActivity()).showFedexEula();
    }

    ()
    {
        this$0 = FedexEulaDialogFragment.this;
        super();
    }
}
