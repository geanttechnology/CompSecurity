// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Intent;
import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOSplashScreenView, DistributedSSOLoginActivity, SSOUtil, MShopCheckLogin

class this._cls0
    implements android.view.nView._cls2
{

    final SSOSplashScreenView this$0;

    public void onClick(View view)
    {
        SSOSplashScreenView.access$000(SSOSplashScreenView.this).finish();
        view = new Intent(SSOSplashScreenView.access$000(SSOSplashScreenView.this), com/amazon/mShop/sso/DistributedSSOLoginActivity);
        view.putExtra("force_signin", true);
        SSOSplashScreenView.access$000(SSOSplashScreenView.this).startActivity(view);
        if (SSOUtil.isAppstoreInstalledWithSpecificVersion(SSOSplashScreenView.access$000(SSOSplashScreenView.this)))
        {
            RefMarkerObserver.logRefMarker("sso_wl_switch_account_wappstore");
        } else
        {
            RefMarkerObserver.logRefMarker("sso_wl_switch_account");
        }
        MShopCheckLogin.savePendingNotification(null);
    }

    ivity()
    {
        this$0 = SSOSplashScreenView.this;
        super();
    }
}
