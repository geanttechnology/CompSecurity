// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.content.Intent;
import com.amazon.mShop.search.viewit.ViewItScanEntryActivity;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopSearchPlugin

class this._cls0
    implements Runnable
{

    final MASHMShopSearchPlugin this$0;

    public void run()
    {
        Intent intent = new Intent(cordova.getActivity(), com/amazon/mShop/search/viewit/ViewItScanEntryActivity);
        intent.addFlags(0x20000);
        cordova.startActivityForResult(MASHMShopSearchPlugin.this, intent, 4);
    }

    vity()
    {
        this$0 = MASHMShopSearchPlugin.this;
        super();
    }
}
