// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.CentralAccountManagerCommunication;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreDefinition;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreFactory;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.platform.util.PlatformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, DataStorageFactory, AccountTransaction

final class NonCanonicalDataStorage extends DataStorage
{
    public static class GetAccountsAction
        implements IPCCommand
    {

        public static final String KEY_VALUES = "values";

        public static Set getResult(Bundle bundle)
        {
            bundle = bundle.getStringArray("values");
            HashSet hashset = new HashSet();
            hashset.addAll(Arrays.asList(bundle));
            return hashset;
        }

        public static Bundle parametersToBundle()
        {
            return new Bundle();
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            context = this = ((DataStorageFactory)ServiceWrappingContext.create(this).getSystemService("dcp_data_storage_factory")).getDataStorage();
            bundle = new Bundle();
            bundle.putStringArray("values", (String[])context.getAccounts().toArray(new String[0]));
            return bundle;
        }

        public GetAccountsAction()
        {
        }
    }

    public static class GetTokenAction
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_KEY = "key";
        public static final String KEY_VALUE = "value";

        public static String getResult(Bundle bundle)
        {
            return bundle.getString("value");
        }

        public static Bundle parametersToBundle(String s, String s1)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            bundle.putString("key", s1);
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            callback = bundle.getString("directedId");
            bundle = bundle.getString("key");
            context = this = ((DataStorageFactory)ServiceWrappingContext.create(this).getSystemService("dcp_data_storage_factory")).getDataStorage();
            bundle1 = new Bundle();
            bundle1.putString("value", context.getToken(callback, bundle));
            return bundle1;
        }

        public GetTokenAction()
        {
        }
    }

    public static class GetUserDataAction
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_KEY = "key";
        public static final String KEY_VALUE = "value";

        public static String getResult(Bundle bundle)
        {
            return bundle.getString("value");
        }

        public static Bundle parametersToBundle(String s, String s1)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            bundle.putString("key", s1);
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            callback = bundle.getString("directedId");
            bundle = bundle.getString("key");
            context = this = ((DataStorageFactory)ServiceWrappingContext.create(this).getSystemService("dcp_data_storage_factory")).getDataStorage();
            bundle1 = new Bundle();
            bundle1.putString("value", context.getUserData(callback, bundle));
            return bundle1;
        }

        public GetUserDataAction()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/NonCanonicalDataStorage.getName();
    private final CentralAccountManagerCommunication mAccountManagerCommunication;
    private final CustomerAttributeStoreDefinition mCAStore;
    private final Context mContext;

    NonCanonicalDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAccountManagerCommunication = (CentralAccountManagerCommunication)mContext.getSystemService("sso_map_account_manager_communicator");
        mCAStore = ((CustomerAttributeStoreFactory)mContext.getSystemService("sso_customer_attribute_store_factory")).createCustomerAttributeStore();
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

    public Set getAccountNames()
    {
        throw onError("getAccountNames not supported in non-canonical process");
    }

    public Set getAccounts()
    {
        return mAccountManagerCommunication.getAccounts();
    }

    public String getDeviceData(String s, String s1)
    {
        throw onError("Cannot call device data operations on data storage in non-canonical process");
    }

    public String getDirectedId(String s)
    {
        throw new UnsupportedOperationException("It is not supported on NonCanonicalDataStorage!");
    }

    public String getDisplayName(String s)
    {
        throw new UnsupportedOperationException("It is not supported on NonCanonicalDataStorage!");
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



/*
    static DataStorage access$000(Context context)
    {
        context = ((DataStorageFactory)ServiceWrappingContext.create(context).getSystemService("dcp_data_storage_factory")).getDataStorage();
        if (context instanceof NonCanonicalDataStorage)
        {
            throw new IllegalStateException("Invalid datastorage");
        } else
        {
            return context;
        }
    }

*/
}
