// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.framework.AlarmManagerWrapper;
import com.amazon.identity.auth.device.framework.AmazonIntentService;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.PendingIntentWrapper;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemWrapper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorageFactory, RemoteAmazonDataStorage, DataStorage, DistributedDataStorage

public class DatabaseCleaner
{
    public static class DatabaseCleaningService extends AmazonIntentService
    {

        private Context mContext;

        public static boolean isValidOnThisPlatform(PlatformWrapper platformwrapper)
        {
            return DistributedDataStorage.shouldPlatformUseThisStore(platformwrapper);
        }

        protected void protectedOnHandleIntent(Intent intent)
        {
            if (!isValidOnThisPlatform((PlatformWrapper)mContext.getSystemService("sso_platform")))
            {
                MAPLog.e(TAG, "Ignoring Database cleaning request because this platform does not use distributed data storage");
                return;
            }
            MAPLog.i(TAG, "Cleaning database of unneeded items");
            intent = new DatabaseCleaner(mContext);
            intent.cleanDatabase();
            intent.scheduleDatabaseClean();
            return;
            Exception exception;
            exception;
            intent.scheduleDatabaseClean();
            throw exception;
        }

        public void setContext(Context context)
        {
            mContext = ServiceWrappingContext.create(context);
        }

        public DatabaseCleaningService()
        {
            super(com/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService.getName());
            setContext(this);
        }
    }


    public static final String CLEAN_DATA_ACTION = "com.amazon.identity.action.CLEAN_DATA";
    private static final Object LOCK[] = new Object[0];
    private static final String TAG = com/amazon/identity/auth/device/storage/DatabaseCleaner.getName();
    public static final String WAIT_TO_CLEAN_DATABASE_MS_KEY = "wait_to_clean_database_ms";
    private final AlarmManagerWrapper mAlarmManager;
    private final ServiceWrappingContext mContext;
    private final DataStorage mDataStorage;
    private final SystemWrapper mSystem;

    public DatabaseCleaner(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mAlarmManager = (AlarmManagerWrapper)mContext.getSystemService("sso_alarm_maanger");
        mSystem = (SystemWrapper)mContext.getSystemService("dcp_system");
    }

    private void cleanDatabaseOfUnneededDeletedItems(Collection collection, Collection collection1)
    {
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            RemoteMapInfo remotemapinfo = (RemoteMapInfo)collection.next();
            if (!(new RemoteAmazonDataStorage(mContext, remotemapinfo)).clearBulkData(collection1))
            {
                MAPLog.e(TAG, "Was not fully successful remotely removing deleted items");
            }
        } while (true);
    }

    public static PendingIntentWrapper getCleanDatabaseIntent(Context context)
    {
        Intent intent = new Intent("com.amazon.identity.action.CLEAN_DATA");
        intent.setClass(context, com/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService);
        return PendingIntentWrapper.getService(context, 0, intent, 0x40000000);
    }

    public void cleanDatabase()
    {
        Collection collection2 = MAPApplicationInformationQueryer.getInstance(mContext).getAllMapApplication();
        Collection collection = null;
        for (Iterator iterator = collection2.iterator(); iterator.hasNext();)
        {
            RemoteMapInfo remotemapinfo = (RemoteMapInfo)iterator.next();
            Collection collection1 = (new RemoteAmazonDataStorage(mContext, remotemapinfo)).getAllDeletedData();
            if (collection1 == null)
            {
                MAPLog.w(TAG, String.format("Remote Package %s is unable to provide any deleted data", new Object[] {
                    remotemapinfo.toString()
                }));
            } else
            if (collection == null)
            {
                collection = collection1;
            } else
            {
                collection.retainAll(collection1);
            }
        }

        String s = TAG;
        StringBuilder stringbuilder = new StringBuilder("Deleting Values: ");
        if (collection != null)
        {
            s = collection.toString();
        } else
        {
            s = "None";
        }
        stringbuilder.append(s).toString();
        if (collection == null || collection.size() == 0)
        {
            MAPLog.i(TAG, "No Deleted items to clean from the MAP databases");
            return;
        } else
        {
            cleanDatabaseOfUnneededDeletedItems(collection2, collection);
            return;
        }
    }

    public void scheduleDatabaseClean()
    {
        boolean flag = true;
        Object aobj[] = LOCK;
        aobj;
        JVM INSTR monitorenter ;
        Object obj;
        long l;
        l = mSystem.currentTimeMillis();
        obj = StringConversionHelpers.toLong(mDataStorage.getDeviceData("clean_database_store", "clean_database_time_ms_key"));
        if (obj != null) goto _L2; else goto _L1
_L9:
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj = TAG;
_L5:
        aobj;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (((Long) (obj)).longValue() > l)
        {
            flag = false;
        }
          goto _L1
_L7:
        obj = getCleanDatabaseIntent(mContext);
        continue; /* Loop/switch isn't completed */
_L4:
        String s = TAG;
        l = PlatformSettings.getInstance(mContext).getSettingLong("wait_to_clean_database_ms", TimeUtil.fromDaysTo(1L, TimeUnit.MILLISECONDS)) + l;
        mAlarmManager.set(1, l, ((PendingIntentWrapper) (obj)));
        mDataStorage.setDeviceData("clean_database_store", "clean_database_time_ms_key", String.valueOf(l));
          goto _L5
        obj;
        throw obj;
_L1:
        if (flag) goto _L7; else goto _L6
_L6:
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
