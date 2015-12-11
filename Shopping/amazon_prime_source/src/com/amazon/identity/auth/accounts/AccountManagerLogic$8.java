// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, RenameDevice

class val.tracer
    implements eue.AccountAuthenticatorTask
{

    final AccountManagerLogic this$0;
    final String val$directedId;
    final String val$newDeviceName;
    final Bundle val$options;
    final Tracer val$tracer;

    public Bundle run(Callback callback)
    {
        AccountManagerLogic.access$1400(AccountManagerLogic.this).renameDevice$28cc6a5(val$directedId, val$newDeviceName, callback, val$tracer);
        return null;
    }

    eue.AccountAuthenticatorTask()
    {
        this$0 = final_accountmanagerlogic;
        val$directedId = s;
        val$newDeviceName = s1;
        val$options = bundle;
        val$tracer = Tracer.this;
        super();
    }
}
