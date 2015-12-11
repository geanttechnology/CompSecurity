// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.content.Context;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AccountManagerDefinition;
import com.amazon.identity.auth.accounts.AccountManagerImplementationFactory;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreDefinition;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreImplementationFactory;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, AccountTransaction

final class NonCanonicalDataStorage extends DataStorage
{

    private static final String TAG = com/amazon/identity/auth/device/storage/NonCanonicalDataStorage.getName();
    private final AccountManagerDefinition mAccountManagerImplementation;
    private final CustomerAttributeStoreDefinition mCAStore;
    private final ServiceWrappingContext mContext;

    NonCanonicalDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAccountManagerImplementation = AccountManagerImplementationFactory.getAccountManagerImplementation(mContext);
        mCAStore = CustomerAttributeStoreImplementationFactory.getCustomerAttributeStoreImplementation(mContext);
    }

    private RuntimeException onError(String s)
    {
        MAPLog.e(TAG, s);
        return new IllegalStateException(s);
    }

    public static boolean shouldUseNonCanonicalDataStorage(Context context)
    {
        return Platform.hasDeviceAttribute(context, DeviceAttribute.CentralAPK) && !CentralApkUtils.isRunningInCentralAPK(context) && PlatformUtils.doesPlatformSupportsMultipleProfiles(context);
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        throw onError("Cannot call write operations on data storage in non-canonical process");
    }

    public void expireToken(String s, String s1)
    {
        throw onError("Cannot call write operations on data storage in non-canonical process");
    }

    public Account getAccountForDirectedId(String s)
    {
        throw new UnsupportedOperationException("getAccountForDirectedId not supported on NonCanonicalDataStorage.");
    }

    public Set getAccountNames()
    {
        throw onError("getAccountNames not supported in non-canonical process");
    }

    public Set getAccounts()
    {
        return mAccountManagerImplementation.getAccounts();
    }

    public String getDeviceData(String s, String s1)
    {
        throw onError("Cannot call device data operations on data storage in non-canonical process");
    }

    public String getDeviceSnapshot()
    {
        MAPLog.i(TAG, "getDeviceSnapshot API is only supported on 3P devices.");
        return "";
    }

    public String getToken(String s, String s1)
    {
        throw onError("Cannot call getToken on NonCanonicalStorage. Please use MAP's API instead.");
    }

    public String getUserData(String s, String s1)
    {
        if (TextUtils.equals(s1, "com.amazon.dcp.sso.property.account.UUID") || TextUtils.equals(s1, "com.amazon.dcp.sso.property.secondary") || TextUtils.equals(s1, "com.amazon.dcp.sso.property.account.ACCOUNT_STATUS"))
        {
            return CustomerAttributeStore.getValueOrAttributeDefault(mCAStore.peekAttribute(s, s1));
        } else
        {
            throw onError((new StringBuilder("Cannot call getUserData on NonCanonicalDataStorage for: ")).append(s1).toString());
        }
    }

    public void initialize()
    {
    }

    public void removeAccount(String s)
    {
        throw onError("Cannot call write operations on data storage in non-canonical process");
    }

    public void setData(AccountTransaction accounttransaction)
    {
        throw onError("Cannot call write operations on data storage in non-canonical process");
    }

    public void setDeviceData(String s, String s1, String s2)
    {
        throw onError("Cannot call device data operations on data storage in non-canonical process");
    }

    public void setToken(String s, String s1, String s2)
    {
        throw onError("Cannot call write operations on data storage in non-canonical process");
    }

    public void setUserData(String s, String s1, String s2)
    {
        throw onError("Cannot call write operations on data storage in non-canonical process");
    }

    public void setup()
    {
    }

    public void syncDirtyData()
    {
        throw onError("Cannot call sync dirty data on data storage in non-canonical process");
    }

}
