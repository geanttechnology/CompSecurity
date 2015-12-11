// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.widget.Toast;
import com.amazon.mShop.net.CallObserver;
import com.amazon.mShop.net.ServiceCallIdentifier;

// Referenced classes of package com.amazon.mShop.sso:
//            CentralSSOLoginActivity

static final class val.errorMessageId
    implements Runnable
{

    final Context val$context;
    final int val$errorCode;
    final int val$errorMessageId;

    public void run()
    {
        CallObserver.start(new ServiceCallIdentifier("MobileAuthenticationPlatform", (new StringBuilder()).append("centralSSOError_").append(com.amazon.identity.auth.device.api.tionError.fromValue(val$errorCode).getName()).toString())).onComplete();
        Toast.makeText(val$context, val$errorMessageId, 1).show();
    }

    anager.RegistrationError(int i, Context context1, int j)
    {
        val$errorCode = i;
        val$context = context1;
        val$errorMessageId = j;
        super();
    }
}
