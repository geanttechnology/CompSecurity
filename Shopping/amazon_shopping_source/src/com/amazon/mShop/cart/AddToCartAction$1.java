// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cart;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.cart:
//            AddToCartAction

class val.currentView
    implements com.amazon.mShop.error.zonErrorBoxActionListener
{

    final AddToCartAction this$0;
    final View val$currentView;

    public void onActionButtonClick(int i)
    {
        com.amazon.mShop.platform.etInstance().invokeLater(new Runnable() {

            final AddToCartAction._cls1 this$1;

            public void run()
            {
                ((AmazonActivity)mContext).clearErrorOnView(currentView);
            }

            
            {
                this$1 = AddToCartAction._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_addtocartaction;
        val$currentView = View.this;
        super();
    }
}
