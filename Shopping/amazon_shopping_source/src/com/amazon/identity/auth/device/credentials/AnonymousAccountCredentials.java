// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.credentials;

import android.content.Context;
import com.amazon.identity.auth.accounts.AmazonAccountManager;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;

// Referenced classes of package com.amazon.identity.auth.device.credentials:
//            AccountCredentials

public class AnonymousAccountCredentials extends AccountCredentials
{

    public static final String ANONYMOUS_CREDENTIALS_NAMESPACE = (new StringBuilder()).append(com/amazon/identity/auth/device/credentials/AnonymousAccountCredentials.getName()).append(".SHARED_PREFS").toString();
    private String mAdpToken;
    private final AmazonAccountManager mAmznAcctMan;
    private final Context mContext;
    private final DataStorage mDataStorage;
    private String mPrivateKey;

    public AnonymousAccountCredentials(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException();
        } else
        {
            mContext = ServiceWrappingContext.create(context.getApplicationContext());
            mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
            mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
            return;
        }
    }

    public String getPrivateKey()
    {
        populateCredentials();
        return mPrivateKey;
    }

    public String getToken()
    {
        populateCredentials();
        return mAdpToken;
    }

    public boolean isStale(Context context)
    {
        if (!mAmznAcctMan.hasDevicePrimaryAmazonAccount())
        {
            context = mDataStorage.getDeviceData(ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.adptoken");
            String s = mDataStorage.getDeviceData(ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.privatekey");
            if (mAdpToken != null && mAdpToken.equals(context) && mPrivateKey != null && mPrivateKey.equals(s))
            {
                return false;
            }
        }
        return true;
    }

    protected void populateCredentials()
    {
        if (mAdpToken != null && mPrivateKey != null)
        {
            return;
        } else
        {
            mAdpToken = mDataStorage.getDeviceData(ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.adptoken");
            mPrivateKey = mDataStorage.getDeviceData(ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.privatekey");
            return;
        }
    }

}
