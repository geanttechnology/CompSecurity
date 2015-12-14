// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountPlugin, MultipleAccountsLogic

public class DefaultMultipleAccountPlugin
    implements MultipleAccountPlugin
{

    private static final String TAG = com/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin.getName();
    private final ServiceWrappingContext mContext;
    private final MultipleAccountsLogic mMultipleAccountLogic;

    public DefaultMultipleAccountPlugin(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, MultipleAccountsLogic.getInstance(servicewrappingcontext));
    }

    DefaultMultipleAccountPlugin(ServiceWrappingContext servicewrappingcontext, MultipleAccountsLogic multipleaccountslogic)
    {
        mContext = servicewrappingcontext;
        mMultipleAccountLogic = multipleaccountslogic;
    }

    public void addDataOnAddAccount$3060423f(Bundle bundle, Bundle bundle1)
    {
    }

    public boolean deregisterAllAccountsOnAccountRemoval(String s)
    {
        boolean flag = mMultipleAccountLogic.isAPrimaryAccount(s);
        MAPLog.i(TAG, (new StringBuilder("deregisterAllAccountsOnAccountRemoval returns: ")).append(flag).toString());
        return flag;
    }

    public com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] getAccountHierarchy(String s, int i)
    {
        return (new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
            new com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType(s), new com.amazon.identity.auth.device.api.MultipleAccountManager.SessionUserMappingType(), com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(i)
        });
    }

    public String getVisibleUser()
    {
        return mMultipleAccountLogic.getAccountForMapping(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
            new com.amazon.identity.auth.device.api.MultipleAccountManager.SessionUserMappingType(), new com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType()
        });
    }

    public void notifyToolbarOfUserChanged(String s, Intent intent, String s1)
    {
        sendBroadcast(s, intent, s1);
    }

    public void sendAccountRemovalBroadcast(String s, Set set, Intent intent, String s1)
    {
        sendBroadcast(s, intent, s1);
    }

    public void sendBroadcast(String s, Intent intent, String s1)
    {
        SecurityHelpers.secureSendBroadcast(mContext, intent, s1, null);
    }

    public void sendBroadcastToMainUser$655207a(Intent intent, String s)
    {
        intent = TAG;
    }

}
