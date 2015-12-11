// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Intent;
import com.ebay.common.model.UserDetail;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.service.PreferenceSyncService;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            SignInFragment

private class <init> extends com.ebay.nautilus.domain.content.dm.
{

    final SignInFragment this$0;

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        for (addressdatamanager = getActivity(); addressdatamanager == null || addressdatamanager.isFinishing() || !signInComplete || userContextDataManger.getCurrentUser() == null;)
        {
            return;
        }

        ResultStatus resultstatus = content.getStatus();
        content = (List)content.getData();
        if ((resultstatus.hasError() || content == null) && userDetail != null)
        {
            com.ebay.common.model.rver rver = userDetail.registrationAddress;
            Intent intent = new Intent(addressdatamanager, com/ebay/mobile/service/PreferenceSyncService);
            intent.putExtra("countryCode", rver.rrentUser);
            intent.putExtra("postalCode", rver.rrentUser);
            intent.putExtra("stateOrProvince", rver.rrentUser);
            intent.setAction("com.ebay.mobile.service.PreferenceSyncService.updatePrefsPrimaryAddress");
            addressdatamanager.startService(intent);
        }
        BaseCheckoutActivity.handleDefaultAddressChange(addressdatamanager, userContextDataManger, content, true, "Sign In");
        showIncentiveOrFinish(incentiveResponse);
    }

    private ()
    {
        this$0 = SignInFragment.this;
        super();
    }

    ( )
    {
        this();
    }
}
