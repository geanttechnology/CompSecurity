// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            SignInFragment

private final class this._cls0 extends EbayErrorHandler
{

    final SignInFragment this$0;

    protected void onUserError(List list)
    {
        if (EbayErrorUtil.incorrectCredentials(list))
        {
            int i;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.SignInWithEmailOrUsername))
            {
                i = 0x7f070485;
            } else
            {
                i = 0x7f070484;
            }
            showDialog(i);
            return;
        }
        if (EbayErrorUtil.missingPaypalSecurityKey(list))
        {
            showDialog(0x7f07063a);
            return;
        }
        if (EbayErrorUtil.forcedChangePassword(list))
        {
            showDialog(0x7f07041e);
            return;
        } else
        {
            super.onUserError(list);
            return;
        }
    }

    public ()
    {
        this$0 = SignInFragment.this;
        super(getActivity());
    }
}
