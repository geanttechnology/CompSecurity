// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.Address;

// Referenced classes of package com.ebay.mobile.checkout:
//            AddressEditActivity

class this._cls0
    implements android.view.tActivity._cls1
{

    final AddressEditActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(AddressEditActivity.this, com/ebay/mobile/activities/PreferredCountryActivity);
        if (isEditingExistingAddress)
        {
            view.putExtra("extraCountry", EbayCountry.getInstance(currentAddress.addressFields.country));
        }
        startActivityForResult(view, AddressEditActivity.RESULT_SHIPPING_COUNTRY.intValue());
    }

    elds()
    {
        this$0 = AddressEditActivity.this;
        super();
    }
}
