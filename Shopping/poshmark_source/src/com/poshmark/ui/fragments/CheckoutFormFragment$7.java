// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.MotionEvent;
import android.view.View;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.utils.view_holders.CheckoutFormViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements android.view.rmFragment._cls7
{

    final CheckoutFormFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            if (view == CheckoutFormFragment.access$500(CheckoutFormFragment.this).expirationEditText)
            {
                CheckoutFormFragment.access$1102(CheckoutFormFragment.this, (LabelledEditText)view);
                CheckoutFormFragment.access$1200(CheckoutFormFragment.this);
                return true;
            }
            if (view == CheckoutFormFragment.access$500(CheckoutFormFragment.this).billingStateEditText || view == CheckoutFormFragment.access$500(CheckoutFormFragment.this).shippingStateEditText)
            {
                CheckoutFormFragment.access$1102(CheckoutFormFragment.this, (LabelledEditText)view);
                CheckoutFormFragment.access$1300(CheckoutFormFragment.this);
                return true;
            }
        }
        return false;
    }

    older()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
