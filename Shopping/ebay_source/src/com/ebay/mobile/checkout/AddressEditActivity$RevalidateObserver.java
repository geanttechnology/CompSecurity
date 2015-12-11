// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.text.TextUtils;
import com.ebay.common.net.api.local.EbayNowMappedException;
import com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.checkout:
//            AddressEditActivity

private final class errorMessage
    implements com.ebay.common.net.api.local.rver
{

    private String errorMessage;
    private int revalidateCount;
    final AddressEditActivity this$0;

    public void onValidateTimeSlotComplete(EbayNowValidateTimeSlotDataManager ebaynowvalidatetimeslotdatamanager, Content content)
    {
        revalidateCount = revalidateCount - 1;
        content = content.getStatus();
        if (!content.hasError()) goto _L2; else goto _L1
_L1:
        errorMessage = MyApp.getDisplayableServiceError(getEbayContext(), content);
        if (TextUtils.isEmpty(errorMessage))
        {
            errorMessage = getString(0x7f07024a);
        }
_L4:
        if (revalidateCount == 0)
        {
            if (errorMessage == null)
            {
                break; /* Loop/switch isn't completed */
            }
            dialogManager.showDynamicAlertDialog(null, errorMessage, false);
            resetUi(true);
        }
        return;
_L2:
        ebaynowvalidatetimeslotdatamanager = ebaynowvalidatetimeslotdatamanager.getMappedException();
        if (ebaynowvalidatetimeslotdatamanager != null && "INVALID_PHONE".equals(((EbayNowMappedException) (ebaynowvalidatetimeslotdatamanager)).errorId))
        {
            errorMessage = getString(0x7f070caa);
        }
        if (true) goto _L4; else goto _L3
_L3:
        boolean flag = MyApp.getDeviceConfiguration().isMECAddressValidationEnabledForCountry(currentAddress.addressFields.);
        updateAddressRequestId = currentAddress.getAddressId();
        addressDataManager.updateAddress(currentAddress, flag);
        return;
    }

    public (int i)
    {
        this$0 = AddressEditActivity.this;
        super();
        revalidateCount = i;
        errorMessage = null;
    }
}
