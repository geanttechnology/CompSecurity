// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.sso.MShopCheckLogin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHMShopAuthenticationPlugin

class val.callback
    implements Runnable
{

    final MASHMShopAuthenticationPlugin this$0;
    final CallbackContext val$callback;

    public void run()
    {
        (new MShopCheckLogin(cordova.getActivity(), false, null)).checkLogin();
        val$callback.success();
    }

    ()
    {
        this$0 = final_mashmshopauthenticationplugin;
        val$callback = CallbackContext.this;
        super();
    }
}
