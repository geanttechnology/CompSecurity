// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.now.cart.CartActivity;
import com.amazon.now.cart.CartController;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class val.callbackContext
    implements Runnable
{

    final MASHHoudiniPlugin this$0;
    final CallbackContext val$callbackContext;
    final int val$quantity;

    public void run()
    {
        if (CartController.getInstance().getCartCount() != val$quantity && (cordova.getActivity() instanceof CartActivity))
        {
            ((CartActivity)cordova.getActivity()).shouldRefreshOnPause(true);
        }
        CartController.getInstance().cartDidUpdate(val$quantity);
        val$callbackContext.success();
    }

    ()
    {
        this$0 = final_mashhoudiniplugin;
        val$quantity = i;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
