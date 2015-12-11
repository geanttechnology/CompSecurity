// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.cart.CartController;
import com.amazon.now.cart.CartResponse;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class this._cls1
    implements com.amazon.now.cart.lback
{

    final l.callbackContext this$1;

    public void onFailure(CartResponse cartresponse, String s)
    {
        callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
    }

    public void onSuccess(CartResponse cartresponse)
    {
        callbackContext.success();
    }

    l.callbackContext()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniPlugin$6

/* anonymous class */
    class MASHHoudiniPlugin._cls6
        implements Runnable
    {

        final MASHHoudiniPlugin this$0;
        final JSONObject val$args;
        final CallbackContext val$callbackContext;

        public void run()
        {
            android.app.Activity activity;
            if (args.optBoolean("showSpinner", false))
            {
                activity = cordova.getActivity();
            } else
            {
                activity = null;
            }
            CartController.getInstance().fetchCartCount(activity, new MASHHoudiniPlugin._cls6._cls1());
        }

            
            {
                this$0 = final_mashhoudiniplugin;
                args = jsonobject;
                callbackContext = CallbackContext.this;
                super();
            }
    }

}
