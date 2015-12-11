// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import com.target.mothership.common.params.AddressParams;

// Referenced classes of package com.target.ui.view.checkout:
//            BillingView

public class sParams
{

    private final AddressParams mAddressParams;
    final BillingView this$0;

    public boolean a()
    {
        return mAddressParams != null;
    }

    public AddressParams b()
        throws IllegalStateException
    {
        if (!a())
        {
            throw new IllegalStateException("Does not contain valid AddressParams.  Did you remember to check isValid()?");
        } else
        {
            return mAddressParams;
        }
    }

    private sParams(AddressParams addressparams)
    {
        this$0 = BillingView.this;
        super();
        mAddressParams = addressparams;
    }

    sParams(AddressParams addressparams, sParams sparams)
    {
        this(addressparams);
    }
}
