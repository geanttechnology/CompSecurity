// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import android.text.TextUtils;
import android.widget.LinearLayout;
import com.socialin.android.apiv3.model.stripe.StripeTokenResponse;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.stripe.android.picsart:
//            StripeAuthActivity

class this._cls0
    implements d
{

    final StripeAuthActivity this$0;

    public void onCancelRequest(StripeTokenResponse stripetokenresponse, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((StripeTokenResponse)obj, request);
    }

    public void onFailure(Exception exception, Request request)
    {
        StripeAuthActivity.access$000(StripeAuthActivity.this, 8);
        StripeAuthActivity.access$300(StripeAuthActivity.this).setVisibility(0);
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public void onSuccess(StripeTokenResponse stripetokenresponse, Request request)
    {
        StripeAuthActivity.access$000(StripeAuthActivity.this, 8);
        if (!TextUtils.isEmpty(stripetokenresponse.message))
        {
            Utils.a(StripeAuthActivity.access$100(StripeAuthActivity.this), stripetokenresponse.message, 1);
        }
        if (!TextUtils.isEmpty(stripetokenresponse.cusomerId))
        {
            StripeAuthActivity.access$200(StripeAuthActivity.this);
            return;
        } else
        {
            StripeAuthActivity.access$300(StripeAuthActivity.this).setVisibility(0);
            return;
        }
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StripeTokenResponse)obj, request);
    }

    kenResponse()
    {
        this$0 = StripeAuthActivity.this;
        super();
    }
}
