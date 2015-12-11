// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic

class val.tracer
    implements eue.AccountAuthenticatorTask
{

    final AccountManagerLogic this$0;
    final Bundle val$regData;
    final RegistrationType val$regType;
    final Tracer val$tracer;

    public Bundle run(Callback callback)
    {
        return AccountManagerLogic.access$400(AccountManagerLogic.this, val$regType, val$regData, callback, val$tracer);
    }

    eue.AccountAuthenticatorTask()
    {
        this$0 = final_accountmanagerlogic;
        val$regType = registrationtype;
        val$regData = bundle;
        val$tracer = Tracer.this;
        super();
    }
}
