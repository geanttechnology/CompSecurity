// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import com.socialin.android.util.Utils;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Token;

// Referenced classes of package com.stripe.android.picsart:
//            StripeAuthActivity

class this._cls0 extends TokenCallback
{

    final StripeAuthActivity this$0;

    public void onError(Exception exception)
    {
        if (StripeAuthActivity.access$100(StripeAuthActivity.this) != null && !StripeAuthActivity.access$100(StripeAuthActivity.this).isFinishing())
        {
            StripeAuthActivity.access$000(StripeAuthActivity.this, 8);
            Utils.a(StripeAuthActivity.access$100(StripeAuthActivity.this), exception.getMessage(), 1);
        }
    }

    public void onSuccess(Token token)
    {
        if (StripeAuthActivity.access$100(StripeAuthActivity.this) != null && !StripeAuthActivity.access$100(StripeAuthActivity.this).isFinishing())
        {
            StripeAuthActivity.access$000(StripeAuthActivity.this, 8);
        }
        StripeAuthActivity.access$500(StripeAuthActivity.this, token.getId());
    }

    ()
    {
        this$0 = StripeAuthActivity.this;
        super();
    }
}
