// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.SSOBroadcastIntentFactory;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import java.util.ArrayList;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsLogic, MultipleAccountPlugin, MultipleAccountPluginHolder

public final class AccountStateBroadcasts
{

    private AccountStateBroadcasts()
    {
    }

    private static void addRelatedProfileIDsToIntent(Intent intent, Set set)
    {
        intent.putIntegerArrayListExtra("com.amazon.identity.auth.extra.account.profiles", new ArrayList(set));
    }

    private static Intent createAccountChangedIntent(String s, Account account, String s1, String s2)
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
        return s1;
    }

    public static void sendAccountForPackageChangedBroadcast(Context context)
    {
        MultipleAccountPluginHolder.getMultipleAccountPlugin(context).sendBroadcast(null, new Intent("com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED"), "com.amazon.dcp.sso.permission.account.changed");
    }

    private static void sendAccountRemovedNotification(Context context, String s, Account account, String s1, String s2, Set set)
    {
        account = createAccountChangedIntent(s, account, s1, s2);
        MultipleAccountPluginHolder.getMultipleAccountPlugin(context).sendAccountRemovalBroadcast(s, set, account, "com.amazon.dcp.sso.permission.account.changed");
    }

    public static void sendAccountRemovedNotification(Context context, boolean flag, String s, Account account, String s1, Set set)
    {
        Intent intent = createAccountChangedIntent(s, null, "com.amazon.identity.auth.account.removed.on.device", null);
        addRelatedProfileIDsToIntent(intent, set);
        MultipleAccountPluginHolder.getMultipleAccountPlugin(context).sendBroadcastToMainUser(s, intent, "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE");
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

    public static void sendAsynchronousAccountAddedNotification(Context context, MultipleAccountsLogic multipleaccountslogic, MultipleAccountPlugin multipleaccountplugin, String s, String s1)
    {
        ThreadUtils.submitToBackgroundThread(new Runnable(context, s, multipleaccountslogic, multipleaccountplugin, s1) {

            final Context val$context;
            final String val$directedId;
            final MultipleAccountsLogic val$multipleAccountManager;
            final MultipleAccountPlugin val$multipleAccountPlugin;
            final String val$packageName;

            public void run()
            {
                Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(context, directedId);
                this = <no variable>.getListOfProfilesWhereTheAccountIsPrimary(this, 
// JavaClassFileOutputException: get_local_var: index out of range

            
            {
                context = context1;
                directedId = s;
                multipleAccountManager = multipleaccountslogic;
                multipleAccountPlugin = multipleaccountplugin;
                packageName = s1;
                super();
            }
        });
    }


/*
    static void access$000(Context context, MultipleAccountsLogic multipleaccountslogic, MultipleAccountPlugin multipleaccountplugin, String s, String s1)
    {
        context = multipleaccountslogic.getListOfProfilesWhereTheAccountIsPrimary(context, s);
        multipleaccountslogic = createAccountChangedIntent(s, null, s1, null);
        addRelatedProfileIDsToIntent(multipleaccountslogic, context);
        multipleaccountplugin.sendBroadcastToMainUser(s, multipleaccountslogic, "com.amazon.identity.permission.MULTIPLE_PROFILE_AWARE");
        return;
    }

*/

}
