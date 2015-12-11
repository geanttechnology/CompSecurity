// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import com.amazon.rio.j2me.client.services.mShop.LoginResponse;

// Referenced classes of package com.amazon.mShop.sso:
//            MShopCheckLogin

class op.LoginResponse
    implements Runnable
{

    final MShopCheckLogin this$0;
    final LoginResponse val$loginResponse;

    public void run()
    {
label0:
        {
            MShopCheckLogin.access$000(MShopCheckLogin.this, val$loginResponse);
            if (MShopCheckLogin.access$100(MShopCheckLogin.this) != null)
            {
                if (val$loginResponse == null)
                {
                    break label0;
                }
                MShopCheckLogin.access$100(MShopCheckLogin.this).onComplete();
            }
            return;
        }
        MShopCheckLogin.access$100(MShopCheckLogin.this).onError();
    }

    op.LoginResponse()
    {
        this$0 = final_mshopchecklogin;
        val$loginResponse = LoginResponse.this;
        super();
    }
}
