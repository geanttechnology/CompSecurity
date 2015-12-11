// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.util.Log;
import com.amazon.now.platform.AndroidPlatform;

// Referenced classes of package com.amazon.now.cart:
//            CartController, CartResponse

class this._cls1
    implements Runnable
{

    final l.attempts this$1;

    public void run()
    {
        CartController.access$100(_fld0, attempts - 1);
    }

    l.attempts()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/cart/CartController$1

/* anonymous class */
    class CartController._cls1
        implements CartController.CartCallback
    {

        final CartController this$0;
        final int val$attempts;

        public void onFailure(CartResponse cartresponse, String s)
        {
            if (attempts <= 0)
            {
                Log.e(CartController.access$000(), "Unable to retrieve cart.");
            }
            AndroidPlatform.getInstance().invokeLater(new CartController._cls1._cls1(), 5000L);
        }

        public void onSuccess(CartResponse cartresponse)
        {
        }

            
            {
                this$0 = final_cartcontroller;
                attempts = I.this;
                super();
            }
    }

}
