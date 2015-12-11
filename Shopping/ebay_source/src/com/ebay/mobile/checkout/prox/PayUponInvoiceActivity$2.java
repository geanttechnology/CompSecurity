// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.PreferredCountryActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.Address;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            PayUponInvoiceActivity

class this._cls0
    implements android.view.nvoiceActivity._cls2
{

    final PayUponInvoiceActivity this$0;

    public void onClick(View view)
    {
        view = new Intent(PayUponInvoiceActivity.this, com/ebay/mobile/activities/PreferredCountryActivity);
        if (PayUponInvoiceActivity.access$000(PayUponInvoiceActivity.this) != null)
        {
            view.putExtra("extraCountry", EbayCountry.getInstance(PayUponInvoiceActivity.access$000(PayUponInvoiceActivity.this).addressFields.ntry));
        }
        startActivityForResult(view, 920);
    }

    ()
    {
        this$0 = PayUponInvoiceActivity.this;
        super();
    }
}
