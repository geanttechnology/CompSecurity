// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.target.ui.view.a;
import com.target.ui.view.account.AddressSetAsPrimaryView;
import com.target.ui.view.checkout.AddressFormView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.shipping:
//            ShippingAddressDetailsFragment

static class  extends a
{

    Button actionDoneButton;
    AddressFormView addressFormView;
    AddressSetAsPrimaryView addressSetAsPrimaryView;
    TargetErrorView errorView;
    ImageView shippingImageView;
    View specialDeliveryLegalCopy;

    (View view)
    {
        super(view);
    }
}
