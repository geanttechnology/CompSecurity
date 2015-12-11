// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.view.View;
import android.widget.AdapterView;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            AddToCartState, QuantitySwitcherDialog

class val.quantity
    implements com.amazon.retailsearch.interaction.r.SearchCartCallback
{

    final l.cartState this$1;
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
        cartState.reset(val$quantity);
    }

    public void success(int i, String s, int j)
    {
        cartState.update(i, s, j);
    }

    l.sr()
    {
        this$1 = final_sr;
        val$quantity = I.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/ui/buttons/QuantitySwitcherDialog$2

/* anonymous class */
    class QuantitySwitcherDialog._cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final QuantitySwitcherDialog this$0;
        final AddToCartState val$cartState;
        final String val$offerId;
        final String val$qid;
        final String val$sr;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            cartState.setState(2);
            userInteractionListener.updateQuantity(cartState.getItemId(), offerId, qid, sr, i, i. new QuantitySwitcherDialog._cls2._cls1());
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

            
            {
                this$0 = final_quantityswitcherdialog;
                cartState = addtocartstate;
                offerId = s;
                qid = s1;
                sr = String.this;
                super();
            }
    }

}
