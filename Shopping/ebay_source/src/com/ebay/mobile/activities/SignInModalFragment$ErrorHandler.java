// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.View;
import android.widget.TextView;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            SignInModalFragment

private final class this._cls0 extends EbayErrorHandler
{

    final SignInModalFragment this$0;

    protected void onUserError(List list)
    {
        if (EbayErrorUtil.incorrectCredentials(list))
        {
            int i;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.SignInWithEmailOrUsername))
            {
                i = 0x7f070486;
            } else
            {
                i = 0x7f070487;
            }
            errorTextView.setText(i);
            errorView.setVisibility(0);
            return;
        }
        if (EbayErrorUtil.missingPaypalSecurityKey(list))
        {
            errorTextView.setText(0x7f07063a);
            errorView.setVisibility(0);
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

    public A()
    {
        this$0 = SignInModalFragment.this;
        super(getActivity());
    }
}
