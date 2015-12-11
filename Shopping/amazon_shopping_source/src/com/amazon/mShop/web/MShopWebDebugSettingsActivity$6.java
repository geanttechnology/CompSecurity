// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.View;
import com.amazon.mShop.social.SocialConnectDebugSettingsActivity;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebDebugSettingsActivity

class this._cls0
    implements android.view.ivity._cls6
{

    final MShopWebDebugSettingsActivity this$0;

    public void onClick(View view)
    {
        view = ActivityUtils.getStartActivityIntent(MShopWebDebugSettingsActivity.this, com/amazon/mShop/social/SocialConnectDebugSettingsActivity, -1);
        startActivity(view);
    }

    ivity()
    {
        this$0 = MShopWebDebugSettingsActivity.this;
        super();
    }
}
