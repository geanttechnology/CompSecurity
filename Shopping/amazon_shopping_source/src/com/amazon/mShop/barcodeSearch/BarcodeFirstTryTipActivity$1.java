// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.barcodeSearch:
//            BarcodeFirstTryTipActivity

class this._cls0
    implements android.view.tTryTipActivity._cls1
{

    final BarcodeFirstTryTipActivity this$0;

    public void onClick(View view)
    {
        RefMarkerObserver.logRefMarker("scan_try_it_btn");
        com.amazon.mShop.platform.ty._mth1().getDataStore().putBoolean("keyBarcodeSearchTryAccepted", true);
        setResult(90);
        finish();
    }

    A()
    {
        this$0 = BarcodeFirstTryTipActivity.this;
        super();
    }
}
