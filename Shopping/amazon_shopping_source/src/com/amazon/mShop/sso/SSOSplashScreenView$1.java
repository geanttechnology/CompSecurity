// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOSplashScreenView, SSOUtil

class this._cls0
    implements android.view.nView._cls1
{

    final SSOSplashScreenView this$0;

    public void onClick(View view)
    {
        SSOSplashScreenView.access$000(SSOSplashScreenView.this).finish();
        if (SSOUtil.isAppstoreInstalledWithSpecificVersion(SSOSplashScreenView.access$000(SSOSplashScreenView.this)))
        {
            RefMarkerObserver.logRefMarker("sso_wl_continue_wappstore");
            return;
        } else
        {
            RefMarkerObserver.logRefMarker("sso_wl_continue");
            return;
        }
    }

    ()
    {
        this$0 = SSOSplashScreenView.this;
        super();
    }
}
