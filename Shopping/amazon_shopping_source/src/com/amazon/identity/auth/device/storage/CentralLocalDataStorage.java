// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.CentralApkUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, LocalDataStorageV2, AccountTransaction, LocalKeyValueStore, 
//            AccountManagerDataMigrationHelper, AccountInfoV2

public final class CentralLocalDataStorage extends DataStorage
{

    private static final String TAG = com/amazon/identity/auth/device/storage/CentralLocalDataStorage.getName();
    private static boolean sInitialized;
    private static CentralLocalDataStorage sTheOneAndTheOnly;
    private final Context mContext;
    private final LocalDataStorageV2 mLocalDataStorage;
    private final PlatformWrapper mPlatform;

    private CentralLocalDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mLocalDataStorage = (LocalDataStorageV2)mContext.getSystemService("sso_local_datastorage_v2");
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
    }

    private boolean addAccountInternal(String s, String s1, Map map)
    {
        return mLocalDataStorage.addAccount(s, s1, map);
    }

    public static CentralLocalDataStorage getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/CentralLocalDataStorage;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new CentralLocalDataStorage(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/storage/CentralLocalDataStorage;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void setIsInitialized(Context context)
    {
        context = context.getSharedPreferences("central.local.datastore.info.store", 0);
        if (!context.edit().putBoolean("central.local.datastore.init.key", true).commit())
        {
            MAPLog.e(TAG, "Was unable to save CentralLocalDataStore as initialized. Retrying...");
            if (!context.edit().putBoolean("central.local.datastore.init.key", true).commit())
            {
                MAPLog.e(TAG, "Was unable to save CentralLocalDataStore as initialized after retry.");
                return;
            }
        }
        sInitialized = true;
    }

    public static boolean shouldPlatformUseThisStore(PlatformWrapper platformwrapper, FeatureSet featureset)
    {
        return platformwrapper.isRunningInCentralApk() && featureset.hasFeature(Feature.MovingAwayFromAM);
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        initialize();
        HashMap hashmap = new HashMap();
        hashmap.putAll(accounttransaction.getUserData());
        hashmap.putAll(accounttransaction.getTokens());
        flag = addAccountInternal(s, accounttransaction.getDirectedId(), hashmap);
        if (!flag || datapropogationcallback == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        datapropogationcallback.onSuccess();
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public void expireToken(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        if (!mLocalDataStorage.removeAccountData(s, s1))
        {
            MAPLog.e(TAG, "Expiring the token was not successful. ");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public Set getAccountNames()
    {
        initialize();
        return mLocalDataStorage.getAccountNames();
    }

    public Set getAccounts()
    {
        this;
        JVM INSTR monitorenter ;
        Set set;
        initialize();
        set = mLocalDataStorage.getAccounts();
        this;
        JVM INSTR monitorexit ;
        return set;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceData(String s, String s1)
    {
        initialize();
        if (!mPlatform.isRunningInCentralApk())
        {
            throw new UnsupportedOperationException("getDeviceData should only be called via central apk");
        } else
        {
            return (new LocalKeyValueStore(mContext, s)).getValue(s1);
        }
    }

    public String getDirectedId(String s)
    {
        initialize();
        return mLocalDataStorage.getDirectedId(s);
    }

    public String getDisplayName(String s)
    {
        initialize();
        return mLocalDataStorage.getDisplayName(s);
    }

    public String getToken(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        s = mLocalDataStorage.getAccountData(s, s1);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public String getUserData(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        s = mLocalDataStorage.getAccountData(s, s1);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void initialize()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = sInitialized;
        if (!flag) goto _L2; else goto _L1
_L1:
        flag = true;
_L5:
        if (!flag) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        flag = mContext.getSharedPreferences("central.local.datastore.info.store", 0).getBoolean("central.local.datastore.init.key", false);
        sInitialized = flag;
          goto _L5
        Exception exception;
        exception;
        throw exception;
_L4:
        MAPLog.i(TAG, "Try to do data migration");
        if (CentralApkUtils.isRunningInCentralAPK(mContext)) goto _L7; else goto _L6
_L6:
        MAPLog.e(TAG, "Cannot dump data from local application. The dump AccountManager data API can only be triggered by com.amazon.imp");
_L8:
        setIsInitialized(mContext);
          goto _L3
_L7:
        AccountManagerDataMigrationHelper accountmanagerdatamigrationhelper;
        Object obj;
        accountmanagerdatamigrationhelper = new AccountManagerDataMigrationHelper(mContext);
        obj = (ArrayList)accountmanagerdatamigrationhelper.dumpDataFromAccountManager();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (!((ArrayList) (obj)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_134;
        }
        MAPLog.i(TAG, "There is no data in old AccountManager. Won't do migration");
          goto _L8
        MAPLog.i(TAG, (new StringBuilder("The total number of migration accounts is")).append(((ArrayList) (obj)).size()).toString());
        AccountInfoV2 accountinfov2;
        for (Iterator iterator = ((ArrayList) (obj)).iterator(); iterator.hasNext(); addAccountInternal(accountinfov2.displayName, accountinfov2.directedId, accountinfov2.accountData))
        {
            accountinfov2 = (AccountInfoV2)iterator.next();
        }

        MAPLog.i(TAG, "Try to remove account in old AccountManager");
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); accountmanagerdatamigrationhelper.removeDataFromAccountManagerAfterMigration(((AccountInfoV2)((Iterator) (obj)).next()).directedId)) { }
        MetricsHelper.increasePeriodicCounter("DataMigrationSucceed", new String[0]);
        MAPLog.i(TAG, "Data migration finished");
          goto _L8
    }

    public void removeAccount(String s)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        if (!mLocalDataStorage.removeAccount(s))
        {
            MAPLog.e(TAG, "Removing the account was not successful.");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
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
        if (!mPlatform.isRunningInCentralApk())
        {
            throw new UnsupportedOperationException("setDeviceData should only be called via central apk");
        } else
        {
            (new LocalKeyValueStore(mContext, s)).setValue(s1, s2);
            return;
        }
    }

    public void setToken(String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        if (!mLocalDataStorage.setAccountData(s, s1, s2))
        {
            MAPLog.e(TAG, "Setting the token was not successful.");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setTokens(String s, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        if (!mLocalDataStorage.setAccountData(s, map))
        {
            MAPLog.e(TAG, "Setting the tokens was not successful.");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setUserData(String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        if (!mLocalDataStorage.setAccountData(s, s1, s2))
        {
            MAPLog.e(TAG, "Setting the userdata was not successful.");
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setup()
    {
        this;
        JVM INSTR monitorenter ;
    }

    public void syncDirtyData()
    {
        this;
        JVM INSTR monitorenter ;
    }

}
