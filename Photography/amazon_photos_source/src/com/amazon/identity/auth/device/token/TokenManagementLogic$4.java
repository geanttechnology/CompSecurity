// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            TokenManagementLogic

class this._cls0
    implements Callback
{

    final TokenManagementLogic this$0;

    public void onError(Bundle bundle)
    {
        MAPLog.e(TokenManagementLogic.access$1100(), "Registration check failed. This does not mean the device deregistered, this can happen if the network call failed.  Also this will not ever be raised to an application calling one of our apis as this is a background task to check the serverside registration state.");
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(TokenManagementLogic.access$1100(), "Registration check succeeded.");
    }

    ()
    {
        this$0 = TokenManagementLogic.this;
        super();
    }
}
