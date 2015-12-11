// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.credentials.AnonymousAccountCredentials;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorageFactory, DataStorage

public class AnonymousCredentialsStore
{

    private static final String TAG = com/amazon/identity/auth/device/storage/AnonymousCredentialsStore.getName();
    private final Context mContext;
    private final DataStorage mDataStorage;

    public AnonymousCredentialsStore(Context context)
    {
        mContext = ServiceWrappingContext.create(context.getApplicationContext());
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    public AccountCredentials getCredentials()
    {
        return new AnonymousAccountCredentials(mContext);
    }

    public boolean hasCredentials()
    {
        AccountCredentials accountcredentials = getCredentials();
        return accountcredentials.getToken() != null && accountcredentials.getPrivateKey() != null;
    }

    public boolean setCredentials(AccountCredentials accountcredentials)
    {
        mDataStorage.setDeviceData(AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.adptoken", accountcredentials.getToken());
        mDataStorage.setDeviceData(AnonymousAccountCredentials.ANONYMOUS_CREDENTIALS_NAMESPACE, "com.amazon.dcp.sso.token.device.privatekey", accountcredentials.getPrivateKey());
        return true;
    }

}
