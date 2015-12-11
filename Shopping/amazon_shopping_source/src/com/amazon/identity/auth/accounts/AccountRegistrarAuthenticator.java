// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.credentials.AccountCredentialsHolder;
import com.amazon.identity.auth.device.credentials.AnonymousAccountCredentials;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;

public class AccountRegistrarAuthenticator
{

    private static final String TAG = com/amazon/identity/auth/accounts/AccountRegistrarAuthenticator.getName();
    private final Context mContext;
    private final DataStorage mDataStorage;

    public AccountRegistrarAuthenticator(Context context)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    public void clearAnonymousCredentials()
    {
        setAnonymousCredentials(null, null);
    }

    public String getAdpToken()
    {
        return AccountCredentialsHolder.getInstance(mContext).getToken();
    }

    public String getPrivateKey()
    {
        return AccountCredentialsHolder.getInstance(mContext).getPrivateKey();
    }

    public boolean hasAnonymousCredentials()
    {
        String s = mDataStorage.getDeviceData(AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.adptoken");
        String s1 = mDataStorage.getDeviceData(AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.privatekey");
        return s != null && s1 != null;
    }

    public void setAnonymousCredentials(String s, String s1)
    {
        mDataStorage.setDeviceData(AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.adptoken", s);
        mDataStorage.setDeviceData(AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.privatekey", s1);
    }

}
