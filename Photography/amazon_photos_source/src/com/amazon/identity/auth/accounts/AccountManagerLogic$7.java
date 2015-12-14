// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerLogic, AccountStateBroadcasts

class val.callback
    implements egisterAccount
{

    final AccountManagerLogic this$0;
    final Account val$backCompatAccount;
    final Callback val$callback;
    final String val$directedId;
    final boolean val$isPrimaryAccount;
    final Set val$profilesForRemovedDirectedId;

    public void onResult(Bundle bundle)
    {
        if (bundle.getBoolean("booleanResult"))
        {
            MAPLog.i(AccountManagerLogic.access$700(), "Device deregistration success");
        } else
        {
            MAPLog.w(AccountManagerLogic.access$700(), "Device deregistration failed");
        }
        AccountStateBroadcasts.sendAccountRemovedNotification(AccountManagerLogic.access$100(AccountManagerLogic.this), val$isPrimaryAccount, val$directedId, val$backCompatAccount, null, val$profilesForRemovedDirectedId);
        AccountManagerLogic.access$1300(AccountManagerLogic.this, val$callback);
    }

    ()
    {
        this$0 = final_accountmanagerlogic;
        val$isPrimaryAccount = flag;
        val$directedId = s;
        val$backCompatAccount = account;
        val$profilesForRemovedDirectedId = set;
        val$callback = Callback.this;
        super();
    }
}
