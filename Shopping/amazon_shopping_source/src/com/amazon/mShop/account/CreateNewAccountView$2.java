// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.content.res.Resources;
import android.view.View;
import com.amazon.mShop.AmazonBrandedWebView;

// Referenced classes of package com.amazon.mShop.account:
//            CreateNewAccountView, LoginActivity

class val.loginActivity
    implements android.view.countView._cls2
{

    final CreateNewAccountView this$0;
    final LoginActivity val$loginActivity;

    public void onClick(View view)
    {
        view = getResources().getString(com.amazon.mShop.android.lib._url);
        String s = getResources().getString(com.amazon.mShop.android.lib.);
        val$loginActivity.pushView(new AmazonBrandedWebView(val$loginActivity, view, s));
    }

    ()
    {
        this$0 = final_createnewaccountview;
        val$loginActivity = LoginActivity.this;
        super();
    }
}
