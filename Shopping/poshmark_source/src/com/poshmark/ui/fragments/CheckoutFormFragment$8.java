// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.utils.view_holders.CheckoutFormViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements android.view.ner
{

    final CheckoutFormFragment this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            if (view == CheckoutFormFragment.access$500(CheckoutFormFragment.this).expirationEditText)
            {
                hideKeyboard();
                CheckoutFormFragment.access$1102(CheckoutFormFragment.this, (LabelledEditText)view);
                CheckoutFormFragment.access$1200(CheckoutFormFragment.this);
            } else
            if (view == CheckoutFormFragment.access$500(CheckoutFormFragment.this).billingStateEditText || view == CheckoutFormFragment.access$500(CheckoutFormFragment.this).shippingStateEditText)
            {
                hideKeyboard();
                CheckoutFormFragment.access$1102(CheckoutFormFragment.this, (LabelledEditText)view);
                CheckoutFormFragment.access$1300(CheckoutFormFragment.this);
                return;
            }
        }
    }

    older()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
