// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            QuantitySwitcherDialog, AddToCartState

class val.sr
    implements android.widget.stener
{

    final QuantitySwitcherDialog this$0;
    final AddToCartState val$cartState;
    final String val$offerId;
    final String val$qid;
    final String val$sr;

    public void onItemClick(AdapterView adapterview, View view, final int quantity, long l)
    {
        val$cartState.setState(2);
        userInteractionListener.updateQuantity(val$cartState.getItemId(), val$offerId, val$qid, val$sr, quantity, new com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback() {

            final QuantitySwitcherDialog._cls2 this$1;
            final int val$quantity;

            public void error()
            {
                cartState.reset();
            }

            public void error(int i, String s, int j)
            {
                cartState.update(i, s, j);
            }

            public void success()
            {
                cartState.reset(quantity);
            }

            public void success(int i, String s, int j)
            {
                cartState.update(i, s, j);
            }

            
            {
                this$1 = QuantitySwitcherDialog._cls2.this;
                quantity = i;
                super();
            }
        });
        try
        {
            dismiss();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            QuantitySwitcherDialog.access$000().error("Could not dismiss dialog", adapterview);
        }
    }

    _cls1.val.quantity()
    {
        this$0 = final_quantityswitcherdialog;
        val$cartState = addtocartstate;
        val$offerId = s;
        val$qid = s1;
        val$sr = String.this;
        super();
    }
}
