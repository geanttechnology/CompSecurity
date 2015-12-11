// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home.web;

import com.amazon.mShop.control.home.HomeController;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;

// Referenced classes of package com.amazon.mShop.home.web:
//            MShopWebHomeBar, MShopWebGatewayActivity

class this._cls0
    implements Runnable
{

    final MShopWebHomeBar this$0;

    public void run()
    {
        long l;
        boolean flag;
        flag = true;
        l = System.currentTimeMillis();
        MShopWebHomeBar.access$000(MShopWebHomeBar.this).setReturnCartItems(true);
        HomeController homecontroller = MShopWebHomeBar.access$000(MShopWebHomeBar.this);
        if (SSOUtil.getCurrentIdentityType() != IdentityType.CENTRAL_SSO_TYPE)
        {
            flag = false;
        }
        homecontroller.setReturnHomeItems(flag);
        flag = MShopWebHomeBar.access$000(MShopWebHomeBar.this).phoneHome(MShopWebHomeBar.access$100(MShopWebHomeBar.this), MShopWebHomeBar.access$100(MShopWebHomeBar.this));
        if (!MShopWebHomeBar.access$100(MShopWebHomeBar.this)) goto _L2; else goto _L1
_L1:
        MShopWebHomeBar.access$200(MShopWebHomeBar.this).loadHTMLGateway();
_L4:
        MShopWebHomeBar.access$102(MShopWebHomeBar.this, false);
        return;
_L2:
        if (flag)
        {
            MShopWebHomeBar.access$200(MShopWebHomeBar.this).reloadHtmlGateway(l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ivity()
    {
        this$0 = MShopWebHomeBar.this;
        super();
    }
}
