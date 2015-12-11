// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.view.View;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.interaction.UserInteractionListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            InlineActionsButton, AddToCartState, InlineActionsButtonModel

private class productView
    implements android.view.Button.AddToCartClickListener
{

    private final String asin;
    private final AddToCartState cartState;
    private final ContentSwitcherModel contentSwitcherModel;
    private final String merchantId;
    private final String offerId;
    private final ProductView productView;
    private final String qid;
    private final String sr;
    final InlineActionsButton this$0;

    public void onClick(View view)
    {
        cartState.setState(2);
        userInteractionListener.addToCart(asin, offerId, merchantId, qid, sr, 1, new com.amazon.retailsearch.interaction.AddToCartInteractionListener.SearchCartCallback() {

            final InlineActionsButton.AddToCartClickListener this$1;

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
                cartState.reset(1);
            }

            public void success(int i, String s, int j)
            {
                cartState.update(i, s, j);
            }

            
            {
                this$1 = InlineActionsButton.AddToCartClickListener.this;
                super();
            }
        });
        if (productView != null)
        {
            if (InlineActionsButton.access$100(InlineActionsButton.this).getOffer() == null)
            {
                productView.switchViewTypes(contentSwitcherModel);
            } else
            {
                productView.switchViewTypes(InlineActionsButton.access$100(InlineActionsButton.this).getOffer(), contentSwitcherModel);
            }
            productView.scrollIntoView();
        }
    }


    public _cls1.this._cls1(AddToCartState addtocartstate, String s, String s1, String s2, String s3, String s4, 
            ContentSwitcherModel contentswitchermodel, ProductView productview)
    {
        this$0 = InlineActionsButton.this;
        super();
        cartState = addtocartstate;
        asin = s;
        offerId = s1;
        merchantId = s2;
        qid = s3;
        sr = s4;
        contentSwitcherModel = contentswitchermodel;
        productView = productview;
    }
}
