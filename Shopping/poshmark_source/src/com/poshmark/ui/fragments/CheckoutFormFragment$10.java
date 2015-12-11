// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.utils.AddressUtils;
import java.util.HashMap;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutFormFragment

class val.items
    implements android.content.istener
{

    final CheckoutFormFragment this$0;
    final CharSequence val$items[];

    public void onClick(DialogInterface dialoginterface, int i)
    {
        HashMap hashmap = AddressUtils.statesOfUSA();
        CheckoutFormFragment.access$1100(CheckoutFormFragment.this).setText((CharSequence)hashmap.get(val$items[i]));
        dialoginterface.dismiss();
    }

    ()
    {
        this$0 = final_checkoutformfragment;
        val$items = _5B_Ljava.lang.CharSequence_3B_.this;
        super();
    }
}
