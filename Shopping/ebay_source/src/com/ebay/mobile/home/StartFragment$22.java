// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.SellSignInViewModel;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.Listener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        if (viewmodel instanceof SellSignInViewModel)
        {
            if (view.getId() == 0x7f10029e)
            {
                view = SignInModalActivity.getIntentForSignIn("HomePage", getActivity());
                view.putExtra("fromHome", true);
                startActivityForResult(view, 1);
            } else
            if (view.getId() == 0x7f10029d)
            {
                startActivityForResult(getRegisterIntent(getActivity(), true), 1);
                return;
            }
        }
    }

    Activity()
    {
        this$0 = StartFragment.this;
        super();
    }
}
