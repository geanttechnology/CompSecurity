// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.TGTBillingCardDetailsModel;

// Referenced classes of package com.target.ui.view.checkout:
//            BillingView

public class tailsModel
{

    private final TGTBillingCardDetailsModel model;
    final BillingView this$0;

    public boolean a()
    {
        return model != null;
    }

    public BillingCardDetailsModel b()
        throws IllegalStateException
    {
        if (!a())
        {
            throw new IllegalStateException("Does not contain valid BillingCardDetailsModel.  Did you remember to check isValid()?");
        } else
        {
            return model;
        }
    }

    private (BillingCardDetailsModel billingcarddetailsmodel)
    {
        this$0 = BillingView.this;
        super();
        if (billingcarddetailsmodel == null)
        {
            model = null;
            return;
        } else
        {
            model = new TGTBillingCardDetailsModel();
            model.a(billingcarddetailsmodel.b());
            model.a(billingcarddetailsmodel.a());
            return;
        }
    }

    tailsModel(BillingCardDetailsModel billingcarddetailsmodel, tailsModel tailsmodel)
    {
        this(billingcarddetailsmodel);
    }
}
