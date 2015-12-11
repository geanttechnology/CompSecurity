// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.content.DialogInterface;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            FedexEulaDialogFragment, ShippingLabelActivity

class this._cls0
    implements android.content.tener
{

    final FedexEulaDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dismiss();
        ((ShippingLabelActivity)getActivity()).acceptFedexEula();
    }

    ()
    {
        this$0 = FedexEulaDialogFragment.this;
        super();
    }
}
