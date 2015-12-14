// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import android.view.View;
import android.widget.LinearLayout;
import com.socialin.android.apiv3.model.stripe.StripeChargeResponse;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.stripe.android.picsart:
//            StripeAuthActivity

class this._cls0
    implements d
{

    final StripeAuthActivity this$0;

    public void onCancelRequest(StripeChargeResponse stripechargeresponse, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((StripeChargeResponse)obj, request);
    }

    public void onFailure(Exception exception, Request request)
    {
        Utils.a(StripeAuthActivity.access$100(StripeAuthActivity.this), exception.getMessage(), 1);
        if (StripeAuthActivity.access$700(StripeAuthActivity.this) != null)
        {
            StripeAuthActivity.access$700(StripeAuthActivity.this).setVisibility(8);
        }
        StripeAuthActivity.access$300(StripeAuthActivity.this).setVisibility(0);
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public void onSuccess(StripeChargeResponse stripechargeresponse, Request request)
    {
        StripeAuthActivity.access$600(StripeAuthActivity.this);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StripeChargeResponse)obj, request);
    }

    argeResponse()
    {
        this$0 = StripeAuthActivity.this;
        super();
    }
}
