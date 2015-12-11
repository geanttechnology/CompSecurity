// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.home:
//            HomeView

class this._cls0
    implements android.view.kListener
{

    final HomeView this$0;

    public void onClick(View view)
    {
        if (SSOUtil.isSSOSupported(getContext()))
        {
            SSOUtil.getCurrentIdentityType().handleSSOLogin(HomeView.access$1500(HomeView.this), true, false, false, "gw");
            return;
        } else
        {
            ActivityUtils.startLoginActivity(HomeView.access$1500(HomeView.this), "gw", true, "hm_si", new int[0]);
            return;
        }
    }

    ls()
    {
        this$0 = HomeView.this;
        super();
    }
}
