// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountStateBroadcasts, MultipleAccountsLogic, MultipleAccountPlugin

static final class val.isNewAccount
    implements Runnable
{

    final ServiceWrappingContext val$context;
    final String val$directedId;
    final boolean val$isNewAccount;
    final MultipleAccountsLogic val$multipleAccountManager;
    final MultipleAccountPlugin val$multipleAccountPlugin;
    final String val$packageName = null;

    public void run()
    {
        android.accounts.Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(val$context, val$directedId);
        AccountStateBroadcasts.access$000(val$context, val$multipleAccountManager, val$multipleAccountPlugin, val$directedId, "com.amazon.identity.auth.account.added.on.device", val$isNewAccount);
        if (val$multipleAccountManager.isAPrimaryAccount(val$directedId))
        {
            AccountStateBroadcasts.access$100(val$multipleAccountPlugin, val$directedId, account, "com.amazon.dcp.sso.action.account.added", val$packageName, val$isNewAccount);
            return;
        } else
        {
            AccountStateBroadcasts.access$100(val$multipleAccountPlugin, val$directedId, account, "com.amazon.dcp.sso.action.secondary.account.added", val$packageName, val$isNewAccount);
            return;
        }
    }

    ntext(ServiceWrappingContext servicewrappingcontext, String s, MultipleAccountsLogic multipleaccountslogic, MultipleAccountPlugin multipleaccountplugin, boolean flag)
    {
        val$context = servicewrappingcontext;
        val$directedId = s;
        val$multipleAccountManager = multipleaccountslogic;
        val$multipleAccountPlugin = multipleaccountplugin;
        val$isNewAccount = flag;
        super();
    }
}
