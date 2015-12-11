// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.accounts.Account;
import android.os.Bundle;
import com.amazon.identity.auth.device.callback.CallbackFuture;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            CentralTokenManagementCommunication

class val.callbackFuture
    implements Runnable
{

    final CentralTokenManagementCommunication this$0;
    final Account val$account;
    final CallbackFuture val$callbackFuture;
    final String val$directedId;
    final Bundle val$options;
    final String val$token;

    public void run()
    {
        CentralTokenManagementCommunication.access$000(CentralTokenManagementCommunication.this, val$token, val$account, val$directedId, val$options, val$callbackFuture);
    }

    Q()
    {
        this$0 = final_centraltokenmanagementcommunication;
        val$token = s;
        val$account = account1;
        val$directedId = s1;
        val$options = bundle;
        val$callbackFuture = CallbackFuture.this;
        super();
    }
}
