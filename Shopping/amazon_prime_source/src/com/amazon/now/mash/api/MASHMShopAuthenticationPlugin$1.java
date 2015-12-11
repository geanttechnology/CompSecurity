// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import com.amazon.mobile.mash.error.MASHError;
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
        SSO.authenticateUser(cordova.getActivity(), new com.amazon.now.account.SSO.SignInCallback() {

            final MASHMShopAuthenticationPlugin._cls1 this$1;

            public void failure()
            {
                callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
            }

            public void success(Activity activity)
            {
                callbackContext.success();
            }

            
            {
                this$1 = MASHMShopAuthenticationPlugin._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_mashmshopauthenticationplugin;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
