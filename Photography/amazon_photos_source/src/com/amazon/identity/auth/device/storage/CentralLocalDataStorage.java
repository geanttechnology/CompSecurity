// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, LocalDataStorageV2, AccountTransaction, DeviceDataMigrationHelper

public final class CentralLocalDataStorage extends DataStorage
{

    private static final String TAG = com/amazon/identity/auth/device/storage/CentralLocalDataStorage.getName();
    private static boolean sAccountDataInitialized;
    private static boolean sDeviceDataInitialized;
    private static CentralLocalDataStorage sTheOneAndTheOnly;
    private final ServiceWrappingContext mContext;
    private final LocalDataStorageV2 mLocalDataStorage;

    CentralLocalDataStorage(Context context, LocalDataStorageV2 localdatastoragev2)
    {
        mContext = ServiceWrappingContext.create(context);
        mLocalDataStorage = localdatastoragev2;
    }

    public static CentralLocalDataStorage getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/CentralLocalDataStorage;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            context = ServiceWrappingContext.create(context.getApplicationContext());
            sTheOneAndTheOnly = new CentralLocalDataStorage(context, LocalDataStorageV2.getInstance(context));
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/storage/CentralLocalDataStorage;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void setDeviceDataListIntoDatabase(List list)
    {
        if (!mLocalDataStorage.setDeviceData(list))
        {
            throw new RuntimeException("Migrating device data fail");
        } else
        {
            return;
        }
    }

    public static void setIsInitialized(Context context, String s)
    {
        context = context.getSharedPreferences("central.local.datastore.info.store", 0);
        if (context.edit().putBoolean(s, true).commit()) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Was unable to save CentralLocalDataStore as initialized. Retrying...");
        if (context.edit().putBoolean(s, true).commit()) goto _L2; else goto _L3
_L3:
        MAPLog.e(TAG, "Was unable to save CentralLocalDataStore as initialized after retry.");
_L5:
        return;
_L2:
        if (TextUtils.equals(s, "central.local.datastore.init.key"))
        {
            sAccountDataInitialized = true;
            return;
        }
        if (TextUtils.equals(s, "central.local.datastore.device.data.init.key"))
        {
            sDeviceDataInitialized = true;
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean shouldPlatformUseThisStore(PlatformWrapper platformwrapper, FeatureSet featureset)
    {
        return featureset.hasFeature(Feature.IsolateApplication) || platformwrapper.isRunningInCentralApk() && featureset.hasFeature(Feature.MovingAwayFromAM);
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        initialize();
        HashMap hashmap = new HashMap();
        hashmap.putAll(accounttransaction.getUserData());
        hashmap.putAll(accounttransaction.getTokens());
        accounttransaction = accounttransaction.getDirectedId();
        boolean flag = mLocalDataStorage.addAccount(s, accounttransaction, hashmap);
        if (flag && datapropogationcallback != null)
        {
            datapropogationcallback.onSuccess();
        }
        return flag;
    }

    public void expireToken(String s, String s1)
    {
        initialize();
        if (!mLocalDataStorage.removeAccountData(s, s1))
        {
            MAPLog.e(TAG, "Expiring the token was not successful. ");
        }
    }

    public Account getAccountForDirectedId(String s)
    {
        return null;
    }

    public Set getAccountNames()
    {
        initialize();
        return mLocalDataStorage.getAccountNames();
    }

    public Set getAccounts()
    {
        initialize();
        return mLocalDataStorage.getAccounts();
    }

    public String getDeviceData(String s, String s1)
    {
        initialize();
        return mLocalDataStorage.getDeviceData(s, s1);
    }

    public String getDeviceSnapshot()
    {
        MAPLog.i(TAG, "getDeviceSnapshot API is only supported on 3P devices.");
        return "";
    }

    public String getToken(String s, String s1)
    {
        initialize();
        return mLocalDataStorage.getAccountData(s, s1);
    }

    public String getUserData(String s, String s1)
    {
        initialize();
        return mLocalDataStorage.getAccountData(s, s1);
    }

    public void initialize()
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        if (!sAccountDataInitialized) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L9:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        MAPLog.i(TAG, "Start initializing CentralLocalDataStorage account data");
        mContext.getFeatureSet().hasFeature(Feature.IsolateApplication);
        setIsInitialized(mContext, "central.local.datastore.init.key");
        if (!sDeviceDataInitialized) goto _L4; else goto _L3
_L3:
        flag = flag1;
_L10:
        if (flag) goto _L6; else goto _L5
_L5:
        MAPLog.i(TAG, "Start initializing CentralLocalDataStorage device data");
        if (mContext.getFeatureSet().hasFeature(Feature.IsolateApplication)) goto _L8; else goto _L7
_L7:
        Object obj;
        List list;
        obj = new DeviceDataMigrationHelper(mContext);
        list = ((DeviceDataMigrationHelper) (obj)).getAllDeviceData();
        setDeviceDataListIntoDatabase(list);
        ((DeviceDataMigrationHelper) (obj)).clearAllDeviceDataInSharedPreference(mContext);
_L11:
        MAPLog.i(TAG, "Migrating device data to local database successfully");
_L8:
        setIsInitialized(mContext, "central.local.datastore.device.data.init.key");
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        sAccountDataInitialized = mContext.getSharedPreferences("central.local.datastore.info.store", 0).getBoolean("central.local.datastore.init.key", false);
        obj = TAG;
        (new StringBuilder("Is CentralLocalDataStorage account data initialized:")).append(sAccountDataInitialized).toString();
        flag = sAccountDataInitialized;
          goto _L9
_L4:
        sDeviceDataInitialized = mContext.getSharedPreferences("central.local.datastore.info.store", 0).getBoolean("central.local.datastore.device.data.init.key", false);
        obj = TAG;
        (new StringBuilder("Is CentralLocalDataStorage device data initialized:")).append(sDeviceDataInitialized).toString();
        flag = sDeviceDataInitialized;
          goto _L10
        Exception exception;
        exception;
        MAPLog.w(TAG, "Retrying migrating device data into the local database");
        setDeviceDataListIntoDatabase(list);
        ((DeviceDataMigrationHelper) (obj)).clearAllDeviceDataInSharedPreference(mContext);
          goto _L11
        obj;
        throw obj;
        Object obj1;
        obj1;
        MAPLog.logAndReportError(TAG, null, "Error happened when inserting device data into the new local database", "MigrateDeviceDataFail");
        ((DeviceDataMigrationHelper) (obj)).clearAllDeviceDataInSharedPreference(mContext);
          goto _L8
        obj1;
        ((DeviceDataMigrationHelper) (obj)).clearAllDeviceDataInSharedPreference(mContext);
        throw obj1;
          goto _L9
    }

    public void removeAccount(String s)
    {
        initialize();
        if (!mLocalDataStorage.removeAccount(s))
        {
            MAPLog.e(TAG, "Removing the account was not successful.");
        }
    }

    public void setData(AccountTransaction accounttransaction)
    {
        initialize();
        HashMap hashmap = new HashMap();
        hashmap.putAll(accounttransaction.getUserData());
        hashmap.putAll(accounttransaction.getTokens());
        if (!mLocalDataStorage.setAccountData(accounttransaction.getDirectedId(), hashmap))
        {
            MAPLog.e(TAG, "Setting the data was not successful.");
        }
    }

    public void setDeviceData(String s, String s1, String s2)
    {
        initialize();
        if (!mLocalDataStorage.setDeviceData(s, s1, s2))
        {
            MAPLog.e(TAG, "Setting device token was not successful. ");
        }
    }

    public void setToken(String s, String s1, String s2)
    {
        initialize();
        if (!mLocalDataStorage.setAccountData(s, s1, s2))
        {
            MAPLog.e(TAG, "Setting the token was not successful.");
        }
    }

    public void setUserData(String s, String s1, String s2)
    {
        initialize();
        if (!mLocalDataStorage.setAccountData(s, s1, s2))
        {
            MAPLog.e(TAG, "Setting the userdata was not successful.");
        }
    }

    public void setup()
    {
    }

    public void syncDirtyData()
    {
    }

}
