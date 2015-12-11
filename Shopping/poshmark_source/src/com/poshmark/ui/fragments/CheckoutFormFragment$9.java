// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.poshmark.utils.view_holders.CheckoutFormViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class this._cls0
    implements android.widget.dChangeListener
{

    final CheckoutFormFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            CheckoutFormFragment.access$500(CheckoutFormFragment.this).billingAddressLayout.setVisibility(8);
            return;
        } else
        {
            CheckoutFormFragment.access$500(CheckoutFormFragment.this).billingAddressLayout.setVisibility(0);
            return;
        }
    }

    older()
    {
        this$0 = CheckoutFormFragment.this;
        super();
    }
}
