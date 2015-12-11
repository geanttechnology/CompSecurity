// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cart;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.cart:
//            AddToCartAction

class this._cls1
    implements Runnable
{

    final l.currentView this$1;

    public void run()
    {
        ((AmazonActivity)mContext).clearErrorOnView(currentView);
    }

    l.currentView()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/cart/AddToCartAction$1

/* anonymous class */
    class AddToCartAction._cls1
        implements com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener
    {

        final AddToCartAction this$0;
        final View val$currentView;

        public void onActionButtonClick(int i)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new AddToCartAction._cls1._cls1());
        }

            
            {
                this$0 = final_addtocartaction;
                currentView = View.this;
                super();
            }
    }

}
