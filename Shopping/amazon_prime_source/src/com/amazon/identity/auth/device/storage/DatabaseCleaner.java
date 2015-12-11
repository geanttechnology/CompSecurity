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
import com.amazon.identity.auth.device.framework.RemoteMAPException;
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

        protected void protectedOnHandleIntent$14d1abce()
        {
            DatabaseCleaner databasecleaner;
            if (!DistributedDataStorage.shouldPlatformUseThisStore((PlatformWrapper)mContext.getSystemService("sso_platform")))
            {
                MAPLog.e(TAG, "Ignoring Database cleaning request because this platform does not use distributed data storage");
                return;
            }
            MAPLog.i(TAG, "Cleaning database of unneeded items");
            databasecleaner = new DatabaseCleaner(mContext);
            databasecleaner.cleanDatabase();
            databasecleaner.scheduleDatabaseClean();
            return;
            Exception exception;
            exception;
            databasecleaner.scheduleDatabaseClean();
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


    private static final Object LOCK[] = new Object[0];
    private static final String TAG = com/amazon/identity/auth/device/storage/DatabaseCleaner.getName();
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

    private Collection calculatedDatabaseValuesToRemove(Collection collection)
    {
        Collection collection1 = null;
        for (Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            RemoteMapInfo remotemapinfo = (RemoteMapInfo)iterator.next();
            collection = new RemoteAmazonDataStorage(mContext, remotemapinfo);
            try
            {
                collection = collection.getAllDeletedData();
            }
            // Misplaced declaration of an exception variable
            catch (Collection collection)
            {
                MAPLog.w(TAG, (new StringBuilder("Failed to get deleted data from ")).append(remotemapinfo.getPackageName()).toString(), collection);
                collection = null;
            }
            if (collection == null)
            {
                MAPLog.w(TAG, String.format("Remote Package %s is unable to provide any deleted data", new Object[] {
                    remotemapinfo.toString()
                }));
            } else
            if (collection1 == null)
            {
                collection1 = collection;
            } else
            {
                collection1.retainAll(collection);
            }
        }

        StringBuilder stringbuilder = new StringBuilder("Deleting Values: ");
        if (collection1 != null)
        {
            collection = collection1.toString();
        } else
        {
            collection = "None";
        }
        stringbuilder.append(collection);
        return collection1;
    }

    public void cleanDatabase()
    {
        Object obj = MAPApplicationInformationQueryer.getInstance(mContext).getAllMapApplication();
        Collection collection = calculatedDatabaseValuesToRemove(((Collection) (obj)));
        if (collection == null || collection.size() == 0)
        {
            MAPLog.i(TAG, "No Deleted items to clean from the MAP databases");
        } else
        {
            obj = ((Collection) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                RemoteMapInfo remotemapinfo = (RemoteMapInfo)((Iterator) (obj)).next();
                if (!(new RemoteAmazonDataStorage(mContext, remotemapinfo)).clearBulkData(collection))
                {
                    MAPLog.e(TAG, "Was not fully successful remotely removing deleted items");
                }
            }
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
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        l = PlatformSettings.getInstance(mContext).getSettingLong("wait_to_clean_database_ms", TimeUtil.fromHoursTo(24L, TimeUnit.MILLISECONDS)) + l;
        mAlarmManager.set$6d261ae(l, ((PendingIntentWrapper) (obj)));
        mDataStorage.setDeviceData("clean_database_store", "clean_database_time_ms_key", String.valueOf(l));
        aobj;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (((Long) (obj)).longValue() > l)
        {
            flag = false;
        }
          goto _L1
_L4:
        obj = mContext;
        Intent intent = new Intent("com.amazon.identity.action.CLEAN_DATA");
        intent.setClass(((Context) (obj)), com/amazon/identity/auth/device/storage/DatabaseCleaner$DatabaseCleaningService);
        obj = PendingIntentWrapper.getService$227fb7c8(((Context) (obj)), intent);
        continue; /* Loop/switch isn't completed */
        obj;
        aobj;
        JVM INSTR monitorexit ;
        throw obj;
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
