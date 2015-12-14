// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.app.Activity;
import com.aviary.android.feather.cds.IAPInstance;
import com.aviary.android.feather.library.services.IAPService;
import com.aviary.android.feather.sdk.AviaryMainController;
import com.aviary.android.feather.sdk.FeatherActivity;

// Referenced classes of package com.aviary.android.feather.sdk.widget:
//            AviaryStoreWrapperAbstract

public class AviaryStoreWrapper extends AviaryStoreWrapperAbstract
{

    public AviaryStoreWrapper(AviaryStoreWrapperAbstract.Callback callback, int i)
    {
        super(callback, i);
    }

    protected IAPInstance createWrapper(Activity activity, String s)
    {
        return (IAPInstance)((FeatherActivity)activity).getMainController().getService(com/aviary/android/feather/library/services/IAPService);
    }

    protected void launchPurchaseFlow(String s, com.aviary.android.feather.cds.billing.util.IabHelper.OnIabPurchaseFinishedListener oniabpurchasefinishedlistener, String s1)
    {
        ((IAPService)wrapper).launchPurchaseFlow(s, oniabpurchasefinishedlistener, null);
    }

    public void onAttach(FeatherActivity featheractivity)
    {
        super.onAttach(featheractivity, null);
    }
}
