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

class this._cls1
    implements com.amazon.now.account.
{

    final l.callbackContext this$1;

    public void failure()
    {
        callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
    }

    public void success(Activity activity)
    {
        callbackContext.success();
    }

    l.callbackContext()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/mash/api/MASHMShopAuthenticationPlugin$1

/* anonymous class */
    class MASHMShopAuthenticationPlugin._cls1
        implements Runnable
    {

        final MASHMShopAuthenticationPlugin this$0;
        final CallbackContext val$callbackContext;

        public void run()
        {
            SSO.authenticateUser(cordova.getActivity(), new MASHMShopAuthenticationPlugin._cls1._cls1());
        }

            
            {
                this$0 = final_mashmshopauthenticationplugin;
                callbackContext = CallbackContext.this;
                super();
            }
    }

}
