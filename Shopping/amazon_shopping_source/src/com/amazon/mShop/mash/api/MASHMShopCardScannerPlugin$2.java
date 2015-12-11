// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import com.creditcardreader.activities.CreditCardScanActivity;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopCardScannerPlugin

class this._cls0
    implements Runnable
{

    final MASHMShopCardScannerPlugin this$0;

    public void run()
    {
        Intent intent = new Intent(cordova.getActivity(), com/creditcardreader/activities/CreditCardScanActivity);
        intent.addFlags(0x20000);
        cordova.startActivityForResult(MASHMShopCardScannerPlugin.this, intent, 20);
    }

    ()
    {
        this$0 = MASHMShopCardScannerPlugin.this;
        super();
    }
}
