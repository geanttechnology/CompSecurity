// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment_Offers

class this._cls0
    implements android.view.ent_Offers._cls1
{

    final CheckoutConfirmationFragment_Offers this$0;

    public void onClick(View view)
    {
        current_state = E.CHANGE_CREDIT_CARD_INFO;
        launchCheckoutForm(ES.CHECKOUT_FORM_MODE_CREDIT_CARD);
    }

    ES()
    {
        this$0 = CheckoutConfirmationFragment_Offers.this;
        super();
    }
}
