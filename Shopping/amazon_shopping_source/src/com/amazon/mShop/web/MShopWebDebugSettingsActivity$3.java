// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.view.View;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebDebugSettingsActivity, WeinreDebugSettingsView

class this._cls0
    implements android.view.ivity._cls3
{

    final MShopWebDebugSettingsActivity this$0;

    public void onClick(View view)
    {
        pushView(new WeinreDebugSettingsView(MShopWebDebugSettingsActivity.this, null));
    }

    ()
    {
        this$0 = MShopWebDebugSettingsActivity.this;
        super();
    }
}
