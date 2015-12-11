// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.cart.CartController;
import com.amazon.now.cart.CartResponse;
import com.amazon.now.util.AppUtils;
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
        CartController.getInstance().addToCartFailureMessage(cordova.getActivity(), s);
        callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
    }

    public void onSuccess(CartResponse cartresponse)
    {
        CartController.getInstance().addToCartSuccessMessage(cordova.getActivity());
        callbackContext.success();
    }

    l.callbackContext()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniPlugin$3

/* anonymous class */
    class MASHHoudiniPlugin._cls3
        implements Runnable
    {

        final MASHHoudiniPlugin this$0;
        final JSONObject val$args;
        final CallbackContext val$callbackContext;

        public void run()
        {
            String s = args.optString("asin");
            String s1 = args.optString("offerId");
            if (!AppUtils.isDefined(s) || !AppUtils.isDefined(s1))
            {
                callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                return;
            }
            String s2 = args.optString("qid");
            String s3 = args.optString("sr");
            String s4 = args.optString("ref");
            String s5 = args.optString("merchantId");
            int i = args.optInt("quantity", 1);
            android.app.Activity activity;
            if (args.optBoolean("showSpinner", true))
            {
                activity = cordova.getActivity();
            } else
            {
                activity = null;
            }
            CartController.getInstance().addToCart(activity, s, s1, s5, s2, s3, s4, i, new MASHHoudiniPlugin._cls3._cls1());
        }

            
            {
                this$0 = final_mashhoudiniplugin;
                args = jsonobject;
                callbackContext = CallbackContext.this;
                super();
            }
    }

}
