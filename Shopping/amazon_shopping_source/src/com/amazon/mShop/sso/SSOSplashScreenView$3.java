// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.view.View;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOSplashScreenView

class this._cls0
    implements android.view.nView._cls3
{

    final SSOSplashScreenView this$0;

    public void onClick(View view)
    {
        view = SSOSplashScreenView.access$000(SSOSplashScreenView.this).getString(com.amazon.mShop.android.lib.s_of_use_link_url);
        String s = SSOSplashScreenView.access$000(SSOSplashScreenView.this).getString(com.amazon.mShop.android.lib.s_of_use);
        SSOSplashScreenView.access$100(SSOSplashScreenView.this, view, s);
    }

    ()
    {
        this$0 = SSOSplashScreenView.this;
        super();
    }
}
