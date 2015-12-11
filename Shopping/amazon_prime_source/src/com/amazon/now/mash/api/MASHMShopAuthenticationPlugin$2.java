// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.now.account.SSO;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHMShopAuthenticationPlugin

class val.callbackContext
    implements Runnable
{

    final MASHMShopAuthenticationPlugin this$0;
    final CallbackContext val$callbackContext;

    public void run()
    {
        SSO.deRegisterUser(cordova.getActivity(), val$callbackContext);
    }

    ()
    {
        this$0 = final_mashmshopauthenticationplugin;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
