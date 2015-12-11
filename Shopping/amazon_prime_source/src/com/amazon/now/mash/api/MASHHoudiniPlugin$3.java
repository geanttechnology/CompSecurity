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

class val.callbackContext
    implements Runnable
{

    final MASHHoudiniPlugin this$0;
    final JSONObject val$args;
    final CallbackContext val$callbackContext;

    public void run()
    {
        String s = val$args.optString("asin");
        String s1 = val$args.optString("offerId");
        if (!AppUtils.isDefined(s) || !AppUtils.isDefined(s1))
        {
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        }
        String s2 = val$args.optString("qid");
        String s3 = val$args.optString("sr");
        String s4 = val$args.optString("ref");
        String s5 = val$args.optString("merchantId");
        int i = val$args.optInt("quantity", 1);
        android.app.Activity activity;
        if (val$args.optBoolean("showSpinner", true))
        {
            activity = cordova.getActivity();
        } else
        {
            activity = null;
        }
        CartController.getInstance().addToCart(activity, s, s1, s5, s2, s3, s4, i, new com.amazon.now.cart.CartController.CartCallback() {

            final MASHHoudiniPlugin._cls3 this$1;

            public void onFailure(CartResponse cartresponse, String s6)
            {
                CartController.getInstance().addToCartFailureMessage(cordova.getActivity(), s6);
                callbackContext.error(MASHError.TIMEOUT.toJSONObejct());
            }

            public void onSuccess(CartResponse cartresponse)
            {
                CartController.getInstance().addToCartSuccessMessage(cordova.getActivity());
                callbackContext.success();
            }

            
            {
                this$1 = MASHHoudiniPlugin._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_mashhoudiniplugin;
        val$args = jsonobject;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
