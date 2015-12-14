// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, AccountAuthenticator

class val.tracer
    implements Runnable
{

    final AccountManagerLogic this$0;
    final Bundle val$authData;
    final Callback val$callback;
    final Tracer val$tracer;

    public void run()
    {
        AccountManagerLogic.access$300(AccountManagerLogic.this).authenticateAccount(val$authData, val$callback, val$tracer);
    }

    ()
    {
        this$0 = final_accountmanagerlogic;
        val$authData = bundle;
        val$callback = callback1;
        val$tracer = Tracer.this;
        super();
    }
}
