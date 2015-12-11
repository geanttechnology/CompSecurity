// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.view.View;

// Referenced classes of package com.target.ui.fragment.checkout:
//            SelectPaymentDialogFragment

class this._cls0
    implements android.view.ntDialogFragment._cls1
{

    final SelectPaymentDialogFragment this$0;

    public void onClick(View view)
    {
        dismiss();
        switch (view.getId())
        {
        default:
            return;

        case 2131755967: 
        case 2131755969: 
            SelectPaymentDialogFragment.a(SelectPaymentDialogFragment.this).P();
            return;

        case 2131755686: 
            SelectPaymentDialogFragment.a(SelectPaymentDialogFragment.this).Q();
            return;
        }
    }

    ()
    {
        this$0 = SelectPaymentDialogFragment.this;
        super();
    }
}
