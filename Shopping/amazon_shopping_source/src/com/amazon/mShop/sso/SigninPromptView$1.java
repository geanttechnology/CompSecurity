// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.view.View;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.sso:
//            SigninPromptView, SSOUtil, IdentityType

class this._cls0
    implements android.view.r
{

    final SigninPromptView this$0;

    public void onClick(View view)
    {
        if (SSOUtil.getCurrentIdentityType() != IdentityType.NON_SSO_TYPE)
        {
            SSOUtil.getCurrentIdentityType().handleSSOLogin(SigninPromptView.access$000(SigninPromptView.this), true, false, false, null);
        } else
        {
            ActivityUtils.startLoginActivityForResult(SigninPromptView.access$000(SigninPromptView.this), 0, null, false, true, false, null);
        }
        RefMarkerObserver.logRefMarker("sps_sign_in");
    }

    ()
    {
        this$0 = SigninPromptView.this;
        super();
    }
}
