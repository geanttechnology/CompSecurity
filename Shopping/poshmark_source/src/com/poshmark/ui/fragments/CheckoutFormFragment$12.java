// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;
import android.widget.NumberPicker;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.utils.view_holders.CheckoutFormViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class val.v
    implements android.content.istener
{

    final CheckoutFormFragment this$0;
    final View val$v;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = (NumberPicker)val$v.findViewById(0x7f0c009b);
        NumberPicker numberpicker = (NumberPicker)val$v.findViewById(0x7f0c009c);
        cc_local.setExpirationMonth(Integer.toString(dialoginterface.getValue()));
        cc_local.setExpirationYear(Integer.toString(numberpicker.getValue()));
        CheckoutFormFragment.access$500(CheckoutFormFragment.this).expirationEditText.setText((new StringBuilder()).append(cc_local.getExpirationMonth()).append(" / ").append(cc_local.getExpirationYear()).toString());
    }

    lder()
    {
        this$0 = final_checkoutformfragment;
        val$v = View.this;
        super();
    }
}
