// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aviary.android.feather.cds.billing.util.Purchase;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryStoreWrapperAbstract

class this._cls0 extends BroadcastReceiver
{

    final AviaryStoreWrapperAbstract this$0;

    public void onReceive(Context context, Intent intent)
    {
        AviaryStoreWrapperAbstract.logger.gger("packPurchasedReceiver::onReceive: %s", new Object[] {
            intent
        });
        if (intent != null && isActive())
        {
            context = intent.getStringExtra("packType");
            long l = intent.getLongExtra("packId", -1L);
            intent = (Purchase)intent.getParcelableExtra("purchase");
            AviaryStoreWrapperAbstract.access$000(AviaryStoreWrapperAbstract.this).onPurchaseSuccess(l, context, intent);
        }
    }

    llback()
    {
        this$0 = AviaryStoreWrapperAbstract.this;
        super();
    }
}
