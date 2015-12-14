// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.amazon.identity.auth.device.api.MAPInit;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DistributedDataStorage, DataStorageFactory, DataStorage

public class DirtyDataSyncingService extends IntentService
{

    private static final String TAG = com/amazon/identity/auth/device/storage/DirtyDataSyncingService.getName();
    private Context mContext;
    private DataStorage mDataStorage;
    private PlatformWrapper mPlatform;

    public DirtyDataSyncingService()
    {
        super(com/amazon/identity/auth/device/storage/DirtyDataSyncingService.getSimpleName());
        mContext = this;
    }

    public static boolean isValidOnThisPlatform(PlatformWrapper platformwrapper)
    {
        return DistributedDataStorage.shouldPlatformUseThisStore(platformwrapper);
    }

    public void onCreate()
    {
        super.onCreate();
        MAPInit.getInstance(this).initialize();
        mContext = ServiceWrappingContext.create(mContext);
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
    }

    protected void onHandleIntent(Intent intent)
    {
        MAPLog.i(TAG, String.format("Package %s is syncing dirty data to other processes", new Object[] {
            getPackageName()
        }));
        if (!DistributedDataStorage.shouldPlatformUseThisStore(mPlatform))
        {
            MAPLog.e(TAG, "Ignoring dirty data sync request because this platform does not use the distributed datastorage");
            return;
        } else
        {
            mDataStorage.syncDirtyData();
            return;
        }
    }

}
