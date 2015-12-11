// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wishlist;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.wishlist:
//            AddToWishlistAction

class val.currentView
    implements com.amazon.mShop.error.rrorBoxActionListener
{

    final AddToWishlistAction this$0;
    final View val$currentView;

    public void onActionButtonClick(int i)
    {
        com.amazon.mShop.platform.stance().invokeLater(new Runnable() {

            final AddToWishlistAction._cls1 this$1;

            public void run()
            {
                AddToWishlistAction.access$000(this$0).clearErrorOnView(currentView);
            }

            
            {
                this$1 = AddToWishlistAction._cls1.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_addtowishlistaction;
        val$currentView = View.this;
        super();
    }
}
