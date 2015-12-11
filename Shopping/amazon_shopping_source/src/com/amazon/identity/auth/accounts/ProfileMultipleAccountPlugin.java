// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.AndroidUser;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.UserManagerWrapper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SecurityHelpers;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountPlugin, MultipleAccountsLogic, AmazonAccountManager

public class ProfileMultipleAccountPlugin
    implements MultipleAccountPlugin
{

    private static final String TAG = com/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin.getName();
    private final AmazonAccountManager mAmazonAccountManager;
    private final Context mContext;
    private final MultipleAccountsLogic mMultipleAccountLogic;
    private final boolean mSendBroadcastCrossProfile;
    private final UserManagerWrapper mUserManWrapper;

    public ProfileMultipleAccountPlugin(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, MultipleAccountsLogic.getInstance(servicewrappingcontext), new UserManagerWrapper(servicewrappingcontext), new AmazonAccountManager(servicewrappingcontext), PlatformSettings.getInstance(servicewrappingcontext).getSettingBoolean("send.broadcast.cross.user", false));
    }

    ProfileMultipleAccountPlugin(ServiceWrappingContext servicewrappingcontext, MultipleAccountsLogic multipleaccountslogic, UserManagerWrapper usermanagerwrapper, AmazonAccountManager amazonaccountmanager, boolean flag)
    {
        mContext = servicewrappingcontext;
        mMultipleAccountLogic = multipleaccountslogic;
        mUserManWrapper = usermanagerwrapper;
        mAmazonAccountManager = amazonaccountmanager;
        mSendBroadcastCrossProfile = flag;
    }

    private void sendBroadcastInternal$3f4fcad8(Intent intent, String s, AndroidUser androiduser)
    {
        intent.getAction();
        String s1 = TAG;
        Integer.toString(androiduser.getUserId());
        setIntentPriority(intent);
        SecurityHelpers.secureSendBroadcast(mContext, intent, s, androiduser);
    }

    private void setIntentPriority(Intent intent)
    {
        String s = intent.getAction();
        if ("com.amazon.dcp.sso.action.account.added".equals(s) || "com.amazon.dcp.sso.action.secondary.account.added".equals(s) || "com.amazon.identity.auth.account.added.on.device".equals(s) || "com.amazon.dcp.sso.action.AmazonAccountPropertyService.property.changed".equals(s) || "com.amazon.dcp.sso.broadcast.CORPFMHasChanged".equals(s))
        {
            String s1 = TAG;
            (new StringBuilder("Using foreground priority for ")).append(s).toString();
            intent.addFlags(0x10000000);
        }
    }

    private boolean shouldWeFireThisBroadcastForThisAccountToThisUser(String s, AndroidUser androiduser)
    {
        if (s != null)
        {
            if (!mMultipleAccountLogic.doesAccountHaveMapping(s, androiduser = com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(androiduser.getUserId())) && mMultipleAccountLogic.isAPrimaryAccount(s))
            {
                return false;
            }
        }
        return true;
    }

    public void addDataOnAddAccount(String s, Bundle bundle, Bundle bundle1)
    {
        int i;
        if (bundle.containsKey("profile_mapping"))
        {
            i = bundle.getInt("profile_mapping");
        } else
        if (bundle.containsKey("calling_profile"))
        {
            i = bundle.getInt("calling_profile");
        } else
        {
            MAPLog.w(TAG, "No calling profile or mapping profile given. Defaulting to main profile");
            i = AndroidUser.getOwnerId();
        }
        s = Integer.valueOf(i);
        if (s != null)
        {
            i = s.intValue();
            if (mMultipleAccountLogic.getAccountForMapping(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
    com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(i)
}) == null)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                bundle1.putString("com.amazon.dcp.sso.property.account.extratokens.account_profiles", Integer.toString(s.intValue()));
            }
        }
    }

    public boolean deregisterAllAccountsOnAccountRemoval(String s)
    {
        boolean flag = mAmazonAccountManager.isDevicePrimaryAmazonAccount(s);
        MAPLog.i(TAG, (new StringBuilder("deregisterAllAccountsOnAccountRemoval returns: ")).append(flag).toString());
        return flag;
    }

    public com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] getAccountHierarchy(String s, int i)
    {
        return (new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
            new com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType(s), com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(i)
        });
    }

    public String getVisibleUser()
    {
        AndroidUser androiduser = mUserManWrapper.getCurrentUser();
        String s = mMultipleAccountLogic.getAccountForMapping(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
            com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(androiduser.getUserId())
        });
        String s1 = TAG;
        Integer.toString(androiduser.getUserId());
        return s;
    }

    public void notifyToolbarOfUserChanged(String s, Intent intent, String s1)
    {
        setIntentPriority(intent);
        AndroidUser androiduser = mUserManWrapper.getMainUser();
        AndroidUser androiduser1 = mUserManWrapper.getCurrentUser();
        String s2 = TAG;
        intent.getAction();
        Integer.toString(androiduser1.getUserId());
        Integer.toString(androiduser.getUserId());
        if (shouldWeFireThisBroadcastForThisAccountToThisUser(s, androiduser1))
        {
            SecurityHelpers.secureSendBroadcast(mContext, intent, s1, androiduser1);
        }
        MAPLog.i(TAG, "Sending broadcast to User 0 quick setting bar.");
        s = new Intent(intent);
        s.setPackage("com.android.systemui");
        SecurityHelpers.secureSendBroadcast(mContext, s, null, androiduser);
    }

    public void sendAccountRemovalBroadcast(String s, Set set, Intent intent, String s1)
    {
        s = mUserManWrapper.getCurrentUser();
        if (s != null) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Can not send broadcast if current AndroidUser is null");
_L4:
        return;
_L2:
        HashSet hashset = new HashSet(set);
        Integer integer = Integer.valueOf(s.getUserId());
        if (hashset.contains(integer))
        {
            sendBroadcastInternal$3f4fcad8(intent, s1, s);
            hashset.remove(integer);
        }
        if (mSendBroadcastCrossProfile && !hashset.isEmpty() && TextUtils.equals(intent.getAction(), "com.amazon.dcp.sso.action.account.removed"))
        {
            s = set.iterator();
            while (s.hasNext()) 
            {
                set = (Integer)s.next();
                sendBroadcastInternal$3f4fcad8(intent, s1, mUserManWrapper.getAndroidUserFromUserId(set.intValue()));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void sendBroadcast(String s, Intent intent, String s1)
    {
        AndroidUser androiduser = mUserManWrapper.getCurrentUser();
        if (!shouldWeFireThisBroadcastForThisAccountToThisUser(s, androiduser))
        {
            s = TAG;
            intent.getAction();
            Integer.toString(androiduser.getUserId());
            return;
        } else
        {
            sendBroadcastInternal$3f4fcad8(intent, s1, androiduser);
            return;
        }
    }

    public void sendBroadcastToMainUser(String s, Intent intent, String s1)
    {
        sendBroadcastInternal$3f4fcad8(intent, s1, mUserManWrapper.getMainUser());
    }

}
