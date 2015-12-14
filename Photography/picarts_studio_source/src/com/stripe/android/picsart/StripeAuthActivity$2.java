// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stripe.android.picsart;

import com.socialin.android.apiv3.model.StatusObj;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;

// Referenced classes of package com.stripe.android.picsart:
//            StripeAuthActivity

class this._cls0
    implements d
{

    final StripeAuthActivity this$0;

    public void onCancelRequest(StatusObj statusobj, Request request)
    {
    }

    public volatile void onCancelRequest(Object obj, Request request)
    {
        onCancelRequest((StatusObj)obj, request);
    }

    public void onFailure(Exception exception, Request request)
    {
        StripeAuthActivity.access$000(StripeAuthActivity.this, 8);
        Utils.a(StripeAuthActivity.access$100(StripeAuthActivity.this), exception.getMessage(), 1);
    }

    public transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public void onSuccess(StatusObj statusobj, Request request)
    {
        StripeAuthActivity.access$000(StripeAuthActivity.this, 8);
        StripeAuthActivity.access$400(StripeAuthActivity.this);
        StripeAuthActivity.access$500(StripeAuthActivity.this, null);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StatusObj)obj, request);
    }

    ()
    {
        this$0 = StripeAuthActivity.this;
        super();
    }
}
