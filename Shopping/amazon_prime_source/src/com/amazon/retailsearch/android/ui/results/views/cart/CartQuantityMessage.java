// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.cart;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.buttons.AddToCartState;
import com.amazon.retailsearch.android.ui.cart.CartStateListener;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

public class CartQuantityMessage extends TextView
    implements CartStateListener, RetailSearchResultView
{

    private static final int MAX_DISPLAY_QUANTITY = 99;
    private final Context context;
    private AddToCartState linkedCartState;
    private final String over99;

    public CartQuantityMessage(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
        over99 = context1.getResources().getString(com.amazon.retailsearch.R.string.rs_over_99);
    }

    private void updateView(int i)
    {
        if (i <= 0)
        {
            setVisibility(8);
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(context);
        styledspannablestring.appendImage(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_checkmark_white), " ", Integer.valueOf(com.amazon.retailsearch.R.style.Results_ImageOverlayMessage));
        String s;
        if (i <= 99)
        {
            s = String.valueOf(i);
        } else
        {
            s = over99;
        }
        styledspannablestring.append((new StringBuilder()).append(" ").append(s).append(" ").append(context.getString(com.amazon.retailsearch.R.string.rs_add_to_cart_success_short)).toString());
        setText(styledspannablestring);
        setVisibility(0);
    }

    public void buildView(AddToCartState addtocartstate, ResultLayoutType resultlayouttype)
    {
        if (linkedCartState != null)
        {
            linkedCartState.removeListener(this);
        }
        if (addtocartstate == null)
        {
            return;
        } else
        {
            addtocartstate.addListener(this);
            linkedCartState = addtocartstate;
            updateView(addtocartstate.getQuantity());
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((AddToCartState)obj, resultlayouttype);
    }

    public void onQuantityUpdated(int i)
    {
        updateView(i);
    }

    public void onStateChange(int i)
    {
    }
}
