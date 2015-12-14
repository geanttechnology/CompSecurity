// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.SSOBroadcastIntentFactory;
import java.util.ArrayList;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, MultipleAccountPlugin, MultipleAccountPluginHolder

public final class AccountStateBroadcasts
{

    private static void addRelatedProfileIDsToIntent(Intent intent, Set set)
    {
        intent.putIntegerArrayListExtra("com.amazon.identity.auth.extra.account.profiles", new ArrayList(set));
    }

    private static Intent createAccountChangedIntent(String s, Account account, String s1, String s2, boolean flag)
    {
        s1 = SSOBroadcastIntentFactory.createIntent(s1);
        if (s2 != null)
        {
            s1.setPackage(s2);
        }
        if (account != null)
        {
            s1.putExtra("com.amazon.dcp.sso.extra.account.name", account.name);
            s1.putExtra("com.amazon.dcp.sso.extra.account.type", account.type);
        }
        s1.putExtra("com.amazon.dcp.sso.extra.account.directed_id", s);
        if (flag)
        {
            s1.putExtra("com.amazon.identity.auth.device.accountManager.newaccount", flag);
        }
        return s1;
    }

    private static void sendAccountRemovedNotification(Context context, String s, Account account, String s1, String s2, Set set)
    {
        account = createAccountChangedIntent(s, account, s1, s2, false);
        MultipleAccountPluginHolder.getMultipleAccountPlugin(context).sendAccountRemovalBroadcast(s, set, account, "com.amazon.dcp.sso.permission.account.changed");
    }

    public static void sendAccountRemovedNotification(Context context, boolean flag, String s, Account account, String s1, Set set)
    {
        Intent intent = createAccountChangedIntent(s, null, "com.amazon.identity.auth.account.removed.on.device", null, false);
        addRelatedProfileIDsToIntent(intent, set);
        MultipleAccountPluginHolder.getMultipleAccountPlugin(context).sendBroadcastToMainUser$655207a(intent, "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE");
        if (flag)
        {
            sendAccountRemovedNotification(context, s, account, "com.amazon.dcp.sso.action.account.removed", s1, set);
            return;
        } else
        {
            sendAccountRemovedNotification(context, s, account, "com.amazon.dcp.sso.action.secondary.account.removed", s1, set);
            return;
        }
    }


/*
    static void access$000(ServiceWrappingContext servicewrappingcontext, MultipleAccountsLogic multipleaccountslogic, MultipleAccountPlugin multipleaccountplugin, String s, String s1, boolean flag)
    {
        servicewrappingcontext = multipleaccountslogic.getListOfProfilesWhereTheAccountIsPrimary(servicewrappingcontext, s);
        multipleaccountslogic = createAccountChangedIntent(s, null, s1, null, flag);
        addRelatedProfileIDsToIntent(multipleaccountslogic, servicewrappingcontext);
        multipleaccountplugin.sendBroadcastToMainUser$655207a(multipleaccountslogic, "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE");
        return;
    }

*/


    // Unreferenced inner class com/amazon/identity/auth/accounts/AccountStateBroadcasts$1

/* anonymous class */
    static final class _cls1
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
            Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(context, directedId);
            this = <no variable>.getListOfProfilesWhereTheAccountIsPrimary(this, 
// JavaClassFileOutputException: get_local_var: index out of range

            
            {
                context = servicewrappingcontext;
                directedId = s;
                multipleAccountManager = multipleaccountslogic;
                multipleAccountPlugin = multipleaccountplugin;
                isNewAccount = flag;
                super();
            }
    }

}
