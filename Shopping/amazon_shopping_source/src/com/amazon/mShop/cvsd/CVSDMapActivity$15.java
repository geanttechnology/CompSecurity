// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import android.content.Intent;
import android.view.View;
import com.amazon.mShop.control.cvsd.CVSDReceivedResult;
import com.amazon.rio.j2me.client.services.mShop.Address;
import java.util.List;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDMapActivity, CVSDStoreDetailsActivity

class .Address
    implements android.view.r
{

    final CVSDMapActivity this$0;
    final Address val$selectedAddress;

    public void onClick(View view)
    {
        CVSDReceivedResult.reset();
        CVSDReceivedResult.receivedType = 0;
        CVSDReceivedResult.receivedAddresss.add(val$selectedAddress);
        view = new Intent(CVSDMapActivity.this, com/amazon/mShop/cvsd/CVSDStoreDetailsActivity);
        startActivityForResult(view, 7);
    }

    .Address()
    {
        this$0 = final_cvsdmapactivity;
        val$selectedAddress = Address.this;
        super();
    }
}
