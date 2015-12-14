// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, CentralDcpAuthenticationMethod

class val.callbackFuture
    implements Callback
{

    final CentralDcpAuthenticationMethod this$0;
    final CallbackFuture val$callbackFuture;

    public void onError(Bundle bundle)
    {
        val$callbackFuture.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        val$callbackFuture.onSuccess(bundle);
    }

    ()
    {
        this$0 = final_centraldcpauthenticationmethod;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
