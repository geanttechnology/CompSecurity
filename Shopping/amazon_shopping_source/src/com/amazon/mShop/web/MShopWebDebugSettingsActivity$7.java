// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.View;
import com.amazon.mShop.util.AppUtils;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebDebugSettingsActivity

class this._cls0
    implements android.view.ivity._cls7
{

    final MShopWebDebugSettingsActivity this$0;

    public void onClick(View view)
    {
        MShopWebDebugSettingsActivity.access$100(MShopWebDebugSettingsActivity.this);
        AppUtils.restartApp();
    }

    ()
    {
        this$0 = MShopWebDebugSettingsActivity.this;
        super();
    }
}
