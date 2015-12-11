// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;

// Referenced classes of package com.ebay.mobile.sell:
//            SellerRegistrationDialogFragment, ListingFragmentActivity

class this._cls0
    implements android.view.gment._cls1
{

    final SellerRegistrationDialogFragment this$0;

    public void onClick(View view)
    {
        ((ListingFragmentActivity)getActivity()).launchSellerRegistration();
        dismiss();
    }

    ()
    {
        this$0 = SellerRegistrationDialogFragment.this;
        super();
    }
}
