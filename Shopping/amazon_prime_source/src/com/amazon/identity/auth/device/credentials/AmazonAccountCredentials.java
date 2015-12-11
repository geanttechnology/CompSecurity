// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.credentials;

import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.credentials:
//            AccountCredentials

public class AmazonAccountCredentials extends AccountCredentials
{

    private static final String TAG = com/amazon/identity/auth/device/credentials/AmazonAccountCredentials.getName();
    private String mAdpToken;
    private final AmazonAccountManager mAmznAcctMan;
    private final ServiceWrappingContext mContext;
    private String mDirectedId;
    private String mEncryptedAdpToken;
    private String mEncryptedPrivateKey;
    private String mPrivateKey;
    private final BackwardsCompatiableDataStorage mStorage;
    private String mValidatorString;

    protected AmazonAccountCredentials()
    {
        mContext = null;
        mAmznAcctMan = null;
        mStorage = null;
    }

    protected AmazonAccountCredentials(Context context)
    {
        this(context, null);
    }

    protected AmazonAccountCredentials(Context context, String s)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mStorage = new BackwardsCompatiableDataStorage(mContext);
        mDirectedId = s;
        mValidatorString = getValidatorString();
        mEncryptedAdpToken = getCurrentUserData("com.amazon.dcp.sso.token.device.adptoken");
        mEncryptedPrivateKey = getCurrentUserData("com.amazon.dcp.sso.token.device.privatekey");
    }

    public static AmazonAccountCredentials createFromContext(Context context)
    {
        if (!(new AmazonAccountManager(context)).hasDevicePrimaryAmazonAccount())
        {
            return null;
        } else
        {
            return new AmazonAccountCredentials(context);
        }
    }

    public static AmazonAccountCredentials createFromContextForAccount(Context context, String s)
    {
        AmazonAccountManager amazonaccountmanager = new AmazonAccountManager(context);
        if (s == null || !amazonaccountmanager.doesAccountExist(s))
        {
            MAPLog.e(TAG, "Error, the account given does not exist. Cannot construct account credentials");
            return null;
        } else
        {
            return new AmazonAccountCredentials(context, s);
        }
    }

    private String getAccountDirectedId()
    {
        if (mDirectedId == null)
        {
            mDirectedId = mAmznAcctMan.getDevicePrimaryAmazonAccount();
        }
        return mDirectedId;
    }

    private String getCurrentUserData(String s)
    {
        String s1 = getAccountDirectedId();
        if (s1 == null)
        {
            MAPLog.e(TAG, "Failed to locate an amazon account to retrieve amazon credentials from.");
            return null;
        } else
        {
            return mStorage.getUndecryptedUserData(s1, s);
        }
    }

    private String tryToDecryptKey(String s)
    {
        String s1 = getAccountDirectedId();
        if (s1 == null)
        {
            MAPLog.e(TAG, "Failed to locate an amazon account to retrieve amazon credentials from.");
            return null;
        } else
        {
            return mStorage.getUserData(s1, s);
        }
    }

    public String getPrivateKey()
    {
        if (mPrivateKey == null)
        {
            mPrivateKey = tryToDecryptKey("com.amazon.dcp.sso.token.device.privatekey");
        }
        return mPrivateKey;
    }

    public String getToken()
    {
        if (mAdpToken == null)
        {
            mAdpToken = tryToDecryptKey("com.amazon.dcp.sso.token.device.adptoken");
        }
        return mAdpToken;
    }

    protected String getValidatorString()
    {
        String s = getAccountDirectedId();
        if (s == null)
        {
            return null;
        } else
        {
            return mStorage.getUserData(s, "com.amazon.dcp.sso.property.account.UUID");
        }
    }

    public boolean isStale$faab209()
    {
        for (String s = getValidatorString(); s == null || !s.equals(mValidatorString) || !TextUtils.equals(mEncryptedAdpToken, getCurrentUserData("com.amazon.dcp.sso.token.device.adptoken")) || !TextUtils.equals(mEncryptedPrivateKey, getCurrentUserData("com.amazon.dcp.sso.token.device.privatekey"));)
        {
            return true;
        }

        return false;
    }

}
