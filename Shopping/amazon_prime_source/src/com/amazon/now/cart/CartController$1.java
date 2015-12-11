// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.cart;

import android.util.Log;
import com.amazon.now.platform.AndroidPlatform;

// Referenced classes of package com.amazon.now.cart:
//            CartController, CartResponse

class val.attempts
    implements rtCallback
{

    final CartController this$0;
    final int val$attempts;

    public void onFailure(CartResponse cartresponse, String s)
    {
        if (val$attempts <= 0)
        {
            Log.e(CartController.access$000(), "Unable to retrieve cart.");
        }
        AndroidPlatform.getInstance().invokeLater(new Runnable() {

            final CartController._cls1 this$1;

            public void run()
            {
                CartController.access$100(this$0, attempts - 1);
            }

            
            {
                this$1 = CartController._cls1.this;
                super();
            }
        }, 5000L);
    }

    public void onSuccess(CartResponse cartresponse)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = final_cartcontroller;
        val$attempts = I.this;
        super();
    }
}
