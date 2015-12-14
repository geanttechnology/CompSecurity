// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.widget.Toast;
import com.aviary.android.feather.cds.billing.util.IabResult;
import com.aviary.android.feather.cds.billing.util.Purchase;
import com.aviary.android.feather.common.tracking.AviaryTracker;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryStoreWrapperAbstract

class val.clickFromPosition
    implements com.aviary.android.feather.cds.billing.util.edListener
{

    final AviaryStoreWrapperAbstract this$0;
    final int val$clickFromPosition;
    final String val$identifier;
    final String val$packType;
    final long val$packid;
    final String val$price;
    final String val$whereFrom;

    public void onIabPurchaseFinished(IabResult iabresult, Purchase purchase)
    {
        AviaryStoreWrapperAbstract.logger.gger("onIabPurchaseFinished: { result: %s, purchase: %s }", new Object[] {
            iabresult, purchase
        });
        if (!isActive())
        {
            AviaryStoreWrapperAbstract.logger.gger("context is no more valid");
            return;
        }
        if (iabresult.isFailure())
        {
            switch (iabresult.getResponse())
            {
            default:
                Toast.makeText(context, iabresult.getMessage(), 0).show();
                break;

            case -1005: 
                break;
            }
        } else
        {
            AviaryStoreWrapperAbstract.access$100(AviaryStoreWrapperAbstract.this, purchase, val$packid, val$identifier, val$packType, val$price);
        }
        tracker.trackEndPurchaseFlow(val$identifier, val$whereFrom, iabresult.isSuccess(), val$clickFromPosition);
    }

    FinishedListener()
    {
        this$0 = final_aviarystorewrapperabstract;
        val$packid = l;
        val$identifier = s;
        val$packType = s1;
        val$price = s2;
        val$whereFrom = s3;
        val$clickFromPosition = I.this;
        super();
    }
}
