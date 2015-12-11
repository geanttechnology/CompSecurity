// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.widget.Toast;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.ServiceCallIdentifier;

// Referenced classes of package com.amazon.mShop.sso:
//            DistributedSSOLoginActivity

static final class val.errorMessageId
    implements Runnable
{

    final Context val$context;
    final int val$errorCode;
    final int val$errorMessageId;

    public void run()
    {
        CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", (new StringBuilder()).append("distributedSSOError_").append(com.amazon.identity.auth.device.api.Error.fromValue(val$errorCode).getName()).toString())).onComplete();
        Toast.makeText(val$context, (new StringBuilder()).append(val$context.getString(val$errorMessageId)).append("(").append(val$errorCode).append(")").toString(), 1).show();
    }

    er.RegistrationError(int i, Context context1, int j)
    {
        val$errorCode = i;
        val$context = context1;
        val$errorMessageId = j;
        super();
    }
}
