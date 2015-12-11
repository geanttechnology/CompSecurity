// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountStateBroadcasts, MultipleAccountsLogic, MultipleAccountPlugin

static final class val.packageName
    implements Runnable
{

    final Context val$context;
    final String val$directedId;
    final MultipleAccountsLogic val$multipleAccountManager;
    final MultipleAccountPlugin val$multipleAccountPlugin;
    final String val$packageName;

    public void run()
    {
        android.accounts.Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(val$context, val$directedId);
        AccountStateBroadcasts.access$000(val$context, val$multipleAccountManager, val$multipleAccountPlugin, val$directedId, "com.amazon.identity.auth.account.added.on.device");
        if (val$multipleAccountManager.isAPrimaryAccount(val$directedId))
        {
            AccountStateBroadcasts.access$100(val$multipleAccountPlugin, val$directedId, account, "com.amazon.dcp.sso.action.account.added", val$packageName);
            return;
        } else
        {
            AccountStateBroadcasts.access$100(val$multipleAccountPlugin, val$directedId, account, "com.amazon.dcp.sso.action.secondary.account.added", val$packageName);
            return;
        }
    }

    tyHelper(Context context1, String s, MultipleAccountsLogic multipleaccountslogic, MultipleAccountPlugin multipleaccountplugin, String s1)
    {
        val$context = context1;
        val$directedId = s;
        val$multipleAccountManager = multipleaccountslogic;
        val$multipleAccountPlugin = multipleaccountplugin;
        val$packageName = s1;
        super();
    }
}
