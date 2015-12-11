// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            StandardChildApplicationRegistrar, ChildApplicationRegistrarCallback

class nit> extends DefaultAmazonWebserviceCallListener
{

    final StandardChildApplicationRegistrar this$0;
    final ChildApplicationRegistrarCallback val$callback;

    public void onAuthenticationFailed()
    {
        val$callback.onAuthenticationFailed();
    }

    public void onNetworkFailure()
    {
        val$callback.onNetworkError();
    }

    public void onParseError$6fe276bc()
    {
        val$callback.onBadResponse();
    }

    public void onResponseComplete(Object obj)
    {
        obj = (RegisterDeviceResponse)obj;
        val$callback.onRegisterChildApplicationComplete(((RegisterDeviceResponse) (obj)));
    }

    ()
    {
        this$0 = final_standardchildapplicationregistrar;
        val$callback = ChildApplicationRegistrarCallback.this;
        super();
    }
}
