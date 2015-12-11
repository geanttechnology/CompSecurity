// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import com.amazon.mShop.AmazonProgressDialog;
import com.amazon.mShop.control.pushnotification.MShopNotificationSubScriber;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchChain

public class ToggleMarketNotificationSubScriber extends MShopNotificationSubScriber
{

    private LocaleSwitchChain mChain;
    private AmazonProgressDialog mProgDiag;

    public ToggleMarketNotificationSubScriber(LocaleSwitchChain localeswitchchain)
    {
        mChain = null;
        mProgDiag = null;
        mChain = localeswitchchain;
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        mChain.setExistentProgressDialog(mProgDiag);
        mChain.process();
    }

    public void onMarketplaceToggled(String s, boolean flag)
    {
        mChain.process();
    }

    public void onMarketplaceToggledReuseProgress(String s, AmazonProgressDialog amazonprogressdialog)
    {
        mChain.setExistentProgressDialog(amazonprogressdialog);
        mChain.process();
    }

    public void setProgDiag(AmazonProgressDialog amazonprogressdialog)
    {
        mProgDiag = amazonprogressdialog;
    }
}
