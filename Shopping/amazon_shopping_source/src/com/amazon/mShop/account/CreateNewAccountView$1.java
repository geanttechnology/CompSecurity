// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.account;

import android.view.View;
import android.widget.EditText;
import com.amazon.mShop.control.account.NewAccountController;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.account:
//            CreateNewAccountView, LoginActivity

class val.loginActivity
    implements android.view.countView._cls1
{

    final CreateNewAccountView this$0;
    final LoginActivity val$loginActivity;

    public void onClick(View view)
    {
        if (CreateNewAccountView.access$000(CreateNewAccountView.this) && CreateNewAccountView.access$100(CreateNewAccountView.this) && !CreateNewAccountView.access$200(CreateNewAccountView.this).hasServiceCallRunning())
        {
            if (ConfigUtils.isEnabled(val$loginActivity, com.amazon.mShop.android.lib.uires_furigana))
            {
                CreateNewAccountView.access$200(CreateNewAccountView.this).createNewAccount(CreateNewAccountView.access$300(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$400(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$500(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$600(CreateNewAccountView.this).getText().toString(), false, CreateNewAccountView.access$700(CreateNewAccountView.this));
            } else
            {
                CreateNewAccountView.access$200(CreateNewAccountView.this).createNewAccount(CreateNewAccountView.access$300(CreateNewAccountView.this).getText().toString(), null, CreateNewAccountView.access$500(CreateNewAccountView.this).getText().toString(), CreateNewAccountView.access$600(CreateNewAccountView.this).getText().toString(), false, CreateNewAccountView.access$700(CreateNewAccountView.this));
            }
            if (!Util.isEmpty(CreateNewAccountView.access$800(CreateNewAccountView.this)))
            {
                RefMarkerObserver.logRefMarker(CreateNewAccountView.access$800(CreateNewAccountView.this));
            }
        }
    }

    oller()
    {
        this$0 = final_createnewaccountview;
        val$loginActivity = LoginActivity.this;
        super();
    }
}
