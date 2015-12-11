// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.view.View;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.CouponMerchant;
import java.util.List;

// Referenced classes of package com.groupon.view:
//            CouponMapSlice

class val.closest
    implements android.view.ner
{

    final CouponMapSlice this$0;
    final int val$closest;
    final CouponMerchant val$couponMerchant;
    final List val$merchantLocations;

    public void onClick(View view)
    {
        onMapViewClicked();
        getContext().startActivity(intentFactory.newShowOnMapIntent(val$merchantLocations, val$couponMerchant.name, val$closest));
    }

    nt()
    {
        this$0 = final_couponmapslice;
        val$merchantLocations = list;
        val$couponMerchant = couponmerchant;
        val$closest = I.this;
        super();
    }
}
