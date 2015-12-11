// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.sso:
//            SigninPromptView, SSOUtil

class this._cls0
    implements android.view.r
{

    final SigninPromptView this$0;

    public void onClick(View view)
    {
        SigninPromptView.access$000(SigninPromptView.this).finish();
        SSOUtil.skipSigin(SigninPromptView.access$000(SigninPromptView.this));
        RefMarkerObserver.logRefMarker("sps_skip_sign_in");
    }

    ()
    {
        this$0 = SigninPromptView.this;
        super();
    }
}
