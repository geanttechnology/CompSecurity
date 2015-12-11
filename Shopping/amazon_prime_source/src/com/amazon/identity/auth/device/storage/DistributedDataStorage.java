// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.UnitTestSafeExecutorService;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, LocalDataStorage, RetrySyncDirtyDataScheduler, LambortishClock, 
//            RemoteAmazonDataStorage, CentralAccountManagerDataStorage, AccountTransaction, DatabaseCleaner

public class DistributedDataStorage extends DataStorage
{
    private static interface RemoteDataStorageAction
    {

        public abstract String getName();

        public abstract boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage);

        public abstract void setActionPerformed();
    }


    private static final Executor PROPAGATION_EXECUTOR = new UnitTestSafeExecutorService(Executors.newFixedThreadPool(1));
    private static final String TAG = com/amazon/identity/auth/device/storage/DistributedDataStorage.getName();
    private static DistributedDataStorage sTheOneAndTheOnly;
    private final Context mContext;
    private final LambortishClock mLambortishClock;
    private final LocalDataStorage mLocalDataStorage;
    private final MAPApplicationInformationQueryer mMAPApplicationInformationQueryer;
    private final RetrySyncDirtyDataScheduler mRetryDirtyDataScheduler;

    DistributedDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mLocalDataStorage = (LocalDataStorage)mContext.getSystemService("sso_local_datastorage");
        mRetryDirtyDataScheduler = new RetrySyncDirtyDataScheduler(mContext);
        mLambortishClock = LambortishClock.getInstance(mContext);
        mMAPApplicationInformationQueryer = MAPApplicationInformationQueryer.getInstance(mContext);
    }

    public static DistributedDataStorage getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/DistributedDataStorage;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new DistributedDataStorage(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/storage/DistributedDataStorage;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private boolean propagateDataChange(RemoteDataStorageAction remotedatastorageaction)
    {
        RetrySyncDirtyDataScheduler.RetrySyncDirtyDataUnscheduler retrysyncdirtydataunscheduler = mRetryDirtyDataScheduler.setDirtyData();
        boolean flag = propagateDataChangeToAllMapApplications(remotedatastorageaction);
        if (flag)
        {
            retrysyncdirtydataunscheduler.markDataNotDirty();
        }
        return flag;
        remotedatastorageaction;
        if (false)
        {
            retrysyncdirtydataunscheduler.markDataNotDirty();
        }
        throw remotedatastorageaction;
    }

    private void propagateDataChangeInTheBackground(final RemoteDataStorageAction action, final DataStorage.DataPropogationCallback callback)
    {
        PROPAGATION_EXECUTOR.execute(new Runnable() {

            final DistributedDataStorage this$0;
            final RemoteDataStorageAction val$action;
            final DataStorage.DataPropogationCallback val$callback;

            public void run()
            {
                propagateDataChange(action);
                if (callback != null)
                {
                    callback.onSuccess();
                }
            }

            
            {
                this$0 = DistributedDataStorage.this;
                action = remotedatastorageaction;
                callback = datapropogationcallback;
                super();
            }
        });
    }

    private boolean propagateDataChangeToAllMapApplications(RemoteDataStorageAction remotedatastorageaction)
    {
        Iterator iterator;
        boolean flag1;
        flag1 = true;
        iterator = mMAPApplicationInformationQueryer.getAllMapApplication().iterator();
_L5:
        RemoteMapInfo remotemapinfo;
        RemoteAmazonDataStorage remoteamazondatastorage;
        int i;
        boolean flag;
        boolean flag2;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_211;
        }
        remotemapinfo = (RemoteMapInfo)iterator.next();
        if (remotemapinfo.isSelf())
        {
            continue; /* Loop/switch isn't completed */
        }
        remotedatastorageaction.getName();
        remotemapinfo.getPackageName();
        mContext.getPackageName();
        remoteamazondatastorage = new RemoteAmazonDataStorage(mContext, remotemapinfo);
        flag2 = false;
        flag = false;
        i = 0;
_L2:
        int j = i + 1;
        boolean flag3 = remotedatastorageaction.performAction(remoteamazondatastorage);
        flag = true;
_L3:
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        flag2 = flag3;
        if (j < 2) goto _L2; else goto _L1
_L1:
        if (!flag3)
        {
            MAPLog.w(TAG, String.format("Failed action %s with remote package %s.", new Object[] {
                remotedatastorageaction.getName(), remotemapinfo.getPackageName()
            }));
        }
        flag1 &= flag3;
        continue; /* Loop/switch isn't completed */
        RuntimeException runtimeexception;
        runtimeexception;
        MAPLog.e(TAG, String.format("Package %s threw runtime exception while propogating action %s", new Object[] {
            remotemapinfo.getPackageName(), remotedatastorageaction.getName()
        }), runtimeexception);
        flag3 = flag2;
          goto _L3
        if (flag1)
        {
            String.format("Action %s was synced to all other MAP instances successfully", new Object[] {
                remotedatastorageaction.getName()
            });
            remotedatastorageaction.setActionPerformed();
        }
        return flag1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean shouldPlatformUseThisStore(PlatformWrapper platformwrapper)
    {
        return !CentralAccountManagerDataStorage.shouldPlatformUseThisStore(platformwrapper);
    }

    public boolean addAccount(final String displayName, final AccountTransaction accountData, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        initialize();
        saveHighestTimestampFromDBSnapshot(mLocalDataStorage.getSnapShotOfData());
        final Date timestamp = mLambortishClock.getNewTimestamp();
        flag = mLocalDataStorage.addAccount(displayName, accountData, timestamp, false);
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final AccountTransaction val$accountData;
            final String val$displayName;
            final Date val$timestamp;

            public String getName()
            {
                return "AddAccount";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.addAccount(displayName, accountData, timestamp);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setNotDirtyAddAccount(accountData, timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                displayName = s;
                accountData = accounttransaction;
                timestamp = date;
                super();
            }
        }, datapropogationcallback);
        this;
        JVM INSTR monitorexit ;
        return flag;
        displayName;
        throw displayName;
    }

    public void expireToken(final String directedId, final String key)
    {
        this;
        JVM INSTR monitorenter ;
        final Date timestamp;
        initialize();
        timestamp = mLambortishClock.getNewTimestamp();
        if (mLocalDataStorage.expireToken(directedId, key, timestamp, false)) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Expiring the token was not successful");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final String val$directedId;
            final String val$key;
            final Date val$timestamp;

            public String getName()
            {
                return "ExpireToken";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.expireToken(directedId, key, timestamp);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setNotDirtyExpireToken(directedId, key, timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                directedId = s;
                key = s1;
                timestamp = date;
                super();
            }
        }, null);
        if (true) goto _L4; else goto _L3
_L3:
        directedId;
        throw directedId;
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
        this;
        JVM INSTR monitorenter ;
        initialize();
        s = mLocalDataStorage.getDeviceData(s, s1);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public String getDeviceSnapshot()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(mLocalDataStorage.getDBSnapshot());
        for (Iterator iterator = mMAPApplicationInformationQueryer.getAllMapApplication().iterator(); iterator.hasNext(); stringbuilder.append(((RemoteMapInfo)iterator.next()).toString())) { }
        return stringbuilder.toString();
    }

    public String getToken(String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        initialize();
        s = mLocalDataStorage.getToken(s, s1);
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
        s = mLocalDataStorage.getUserData(s, s1);
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
        boolean flag = mContext.getSharedPreferences("distributed.datastore.info.store", 0).getBoolean("distributed.datastore.init.key", false);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj1 = MAPApplicationInformationQueryer.getInstance(mContext).getSortedByLatestMapApplications();
        Object obj = null;
        Iterator iterator = ((List) (obj1)).iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        RemoteMapInfo remotemapinfo;
        remotemapinfo = (RemoteMapInfo)iterator.next();
        flag = remotemapinfo.isSelf();
        if (flag) goto _L6; else goto _L5
_L5:
        obj1 = remotemapinfo.fetchMAPInitVersion();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (3 <= ((Integer) (obj1)).intValue())
        {
            break MISSING_BLOCK_LABEL_189;
        }
        MAPLog.i(TAG, (new StringBuilder("Can't initialize from ")).append(remotemapinfo.getPackageName()).append(" because its MAP init version is ").append(obj1).toString());
          goto _L6
        RemoteMAPException remotemapexception;
        remotemapexception;
        MAPLog.w(TAG, (new StringBuilder("Failed to get MAP init version from ")).append(remotemapinfo.getPackageName()).toString(), remotemapexception);
        MAPApplicationInformationQueryer.getInstance(mContext).invalidateCache();
          goto _L6
        obj;
        throw obj;
        MAPLog.i(TAG, (new StringBuilder("Initializing data storage from ")).append(remotemapinfo.getPackageName()).toString());
        remotemapexception = (new RemoteAmazonDataStorage(mContext, remotemapinfo)).getAllData();
        obj = remotemapexception;
        if (obj == null) goto _L6; else goto _L4
_L4:
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        MAPLog.i(TAG, "Did not find another MAP application to get initial data from.");
_L7:
        if (!mContext.getSharedPreferences("distributed.datastore.info.store", 0).edit().putBoolean("distributed.datastore.init.key", true).commit())
        {
            MAPLog.e(TAG, "Was unable to save distributed store initialized");
        }
          goto _L1
        remotemapexception;
        MAPLog.w(TAG, (new StringBuilder("Failed to get all data from ")).append(remotemapinfo.getPackageName()).toString(), remotemapexception);
        MAPApplicationInformationQueryer.getInstance(mContext).invalidateCache();
          goto _L6
        mLocalDataStorage.setSnapshotOfData(((Collection) (obj)));
        saveHighestTimestampFromDBSnapshot(((Collection) (obj)));
          goto _L7
    }

    public void removeAccount(final String directedId)
    {
        this;
        JVM INSTR monitorenter ;
        final Date timestamp;
        initialize();
        timestamp = mLambortishClock.getNewTimestamp();
        if (mLocalDataStorage.removeAccount(directedId, timestamp, false)) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Removing the account was not successful");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final String val$directedId;
            final Date val$timestamp;

            public String getName()
            {
                return "RemovedAccount";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.removeAccount(directedId, timestamp);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setNotDirtyRemoveAccount(directedId, timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                directedId = s;
                timestamp = date;
                super();
            }
        }, null);
        if (true) goto _L4; else goto _L3
_L3:
        directedId;
        throw directedId;
    }

    public void saveHighestTimestampFromDBSnapshot(Collection collection)
    {
        long l;
        l = -1L;
        collection = collection.iterator();
_L2:
        Map map;
        if (!collection.hasNext())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        map = (Map)collection.next();
        long l1 = Long.parseLong((String)map.get("timestamp_key"));
        if (l1 > l)
        {
            l = l1;
        }
        continue; /* Loop/switch isn't completed */
        if (l == -1L)
        {
            MAPLog.e(TAG, "Not able to find a timestamp from the DB snapshot used to initialize the current apps");
            return;
        } else
        {
            collection = new Date(l);
            mLambortishClock.markDateSeen(collection);
            return;
        }
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setData(final AccountTransaction userData)
    {
        initialize();
        final Date timestamp = mLambortishClock.getNewTimestamp();
        boolean flag = mLocalDataStorage.setData(userData, timestamp, false);
        final String directedId = userData.getDirectedId();
        final Map tokens = userData.getTokens();
        userData = userData.getUserData();
        if (!flag)
        {
            MAPLog.e(TAG, "Setting the data was not successful");
            return;
        } else
        {
            propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

                final DistributedDataStorage this$0;
                final String val$directedId;
                final Date val$timestamp;
                final Map val$tokens;
                final Map val$userData;

                public String getName()
                {
                    return "SetData";
                }

                public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
                {
label0:
                    {
                        if (tokens == null)
                        {
                            break label0;
                        }
                        Iterator iterator = tokens.entrySet().iterator();
                        java.util.Map.Entry entry;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                            entry = (java.util.Map.Entry)iterator.next();
                        } while (remoteamazondatastorage.setToken(directedId, (String)entry.getKey(), (String)entry.getValue(), timestamp));
                        return false;
                    }
label1:
                    {
                        if (userData == null)
                        {
                            break label1;
                        }
                        Iterator iterator1 = userData.entrySet().iterator();
                        java.util.Map.Entry entry1;
                        do
                        {
                            if (!iterator1.hasNext())
                            {
                                break label1;
                            }
                            entry1 = (java.util.Map.Entry)iterator1.next();
                        } while (remoteamazondatastorage.setUserData(directedId, (String)entry1.getKey(), (String)entry1.getValue(), timestamp));
                        return false;
                    }
                    return true;
                }

                public void setActionPerformed()
                {
                    if (tokens != null)
                    {
                        String s;
                        for (Iterator iterator = tokens.keySet().iterator(); iterator.hasNext(); mLocalDataStorage.setNotDirtySetToken(directedId, s, timestamp))
                        {
                            s = (String)iterator.next();
                        }

                    }
                    if (userData != null)
                    {
                        String s1;
                        for (Iterator iterator1 = userData.keySet().iterator(); iterator1.hasNext(); mLocalDataStorage.setNotDirtySetUserData(directedId, s1, timestamp))
                        {
                            s1 = (String)iterator1.next();
                        }

                    }
                }

            
            {
                this$0 = DistributedDataStorage.this;
                tokens = map;
                directedId = s;
                timestamp = date;
                userData = map1;
                super();
            }
            }, null);
            return;
        }
    }

    public void setDeviceData(final String namespace, final String key, final String value)
    {
        this;
        JVM INSTR monitorenter ;
        final Date timestamp;
        initialize();
        timestamp = mLambortishClock.getNewTimestamp();
        if (mLocalDataStorage.setDeviceData(namespace, key, value, timestamp, false)) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Setting the token was not successful");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final String val$key;
            final String val$namespace;
            final Date val$timestamp;
            final String val$value;

            public String getName()
            {
                return "SetDeviceData";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.setDeviceData(namespace, key, value, timestamp);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setNotDirtySetDeviceData(namespace, key, timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                namespace = s;
                key = s1;
                value = s2;
                timestamp = date;
                super();
            }
        }, null);
        if (true) goto _L4; else goto _L3
_L3:
        namespace;
        throw namespace;
    }

    public void setToken(final String directedId, final String key, final String token)
    {
        this;
        JVM INSTR monitorenter ;
        final Date timestamp;
        initialize();
        timestamp = mLambortishClock.getNewTimestamp();
        if (mLocalDataStorage.setToken(directedId, key, token, timestamp, false)) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Setting the token was not successful");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final String val$directedId;
            final String val$key;
            final Date val$timestamp;
            final String val$token;

            public String getName()
            {
                return "SetToken";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.setToken(directedId, key, token, timestamp);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setNotDirtySetToken(directedId, key, timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                directedId = s;
                key = s1;
                token = s2;
                timestamp = date;
                super();
            }
        }, null);
        if (true) goto _L4; else goto _L3
_L3:
        directedId;
        throw directedId;
    }

    public void setUserData(final String directedId, final String key, final String value)
    {
        this;
        JVM INSTR monitorenter ;
        final Date timestamp;
        initialize();
        timestamp = mLambortishClock.getNewTimestamp();
        if (mLocalDataStorage.setUserData(directedId, key, value, timestamp, false)) goto _L2; else goto _L1
_L1:
        MAPLog.e(TAG, "Setting the userdata was not successful");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final String val$directedId;
            final String val$key;
            final Date val$timestamp;
            final String val$value;

            public String getName()
            {
                return "SetUserdata";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.setUserData(directedId, key, value, timestamp);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setNotDirtySetUserData(directedId, key, timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                directedId = s;
                key = s1;
                value = s2;
                timestamp = date;
                super();
            }
        }, null);
        if (true) goto _L4; else goto _L3
_L3:
        directedId;
        throw directedId;
    }

    public void setup()
    {
        this;
        JVM INSTR monitorenter ;
        RemoteMapInfo remotemapinfo = mMAPApplicationInformationQueryer.getLatestMapApp();
        if (remotemapinfo == null) goto _L2; else goto _L1
_L1:
        if (mContext.getPackageName().equals(remotemapinfo.getPackageName())) goto _L3; else goto _L2
_L2:
        MAPLog.i(TAG, "Am not the latest application. Not creating alarm to clean database");
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        MAPLog.i(TAG, "Am the latest application. Setting up alarm to clean database");
        (new DatabaseCleaner(mContext)).scheduleDatabaseClean();
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        MAPLog.w(TAG, "Failed to initialize DatabaseCleaner", ((Throwable) (obj)));
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        throw obj;
    }

    public void syncDirtyData()
    {
        this;
        JVM INSTR monitorenter ;
        final Date timestamp;
        final Collection allCurrentDirtyData;
        int i;
        initialize();
        timestamp = mLambortishClock.getNewTimestamp();
        allCurrentDirtyData = mLocalDataStorage.getAllDirtyData(timestamp);
        i = allCurrentDirtyData.size();
        if (i != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        propagateDataChangeInTheBackground(new RemoteDataStorageAction() {

            final DistributedDataStorage this$0;
            final Collection val$allCurrentDirtyData;
            final Date val$timestamp;

            public String getName()
            {
                return "SetBulkData";
            }

            public boolean performAction(RemoteAmazonDataStorage remoteamazondatastorage)
            {
                return remoteamazondatastorage.setBulkData(allCurrentDirtyData);
            }

            public void setActionPerformed()
            {
                mLocalDataStorage.setAllBeforeTimeNotDirty(timestamp);
            }

            
            {
                this$0 = DistributedDataStorage.this;
                allCurrentDirtyData = collection;
                timestamp = date;
                super();
            }
        }, null);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }



}
